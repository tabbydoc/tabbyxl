/*
 * Copyright 2015-17 Alexey O. Shigarov (shigarov@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.icc.cells.ssdc;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.sql.Timestamp;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.cli.*;

import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;

import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import ru.icc.cells.ssdc.model.*;
import ru.icc.cells.ssdc.writers.*;

public final class TabbyXL {
    // Params
    private static File inputExcelFile;
    private static List<Integer> sheetIndexes;
    private static File drlFile;
    private static Path catDirectory;
    private static boolean ignoreSuperscript;
    private static boolean useCellValue;
    private static Path outputDirectory;
    private static boolean debuggingMode;
    private static boolean useDSL;
    private static boolean useShortNames;

    // TODO DSL initialisation from settings is needed
    private static final String DSL = "/crl2.dsl";

    // Statistics
    private static final StatisticsManager statisticsManager = StatisticsManager.getInstance();
    private static long totalRuleFiringTime;
    private static long currentRuleFiringTime;

    private static final DataLoader DATA_LOADER = DataLoader.getInstance();
    private static final CategoryTemplateManager CATEGORY_TEMPLATE_MANAGER = CategoryTemplateManager.getInstance();
    private static final KnowledgeBase KNOWLEDGE_BASE = KnowledgeBaseFactory.newKnowledgeBase();

    private static File parseInputExcelFileParam(String inputExcelFileParam) {
        File file = new File(inputExcelFileParam);

        if (file.exists()) {
            if (file.canRead()) {
                return file;
            } else {
                System.err.println("The input excel file cannot be read");
                System.exit(0);
            }
        } else {
            System.err.println("The input marked excel file does not exist");
            System.exit(0);
        }
        return null;
    }

    private static List<Integer> parseSheetIndexesParam(String sheetIndexesParam) {
        if (sheetIndexesParam != null) {
            if (Pattern.matches("\\d+(((,\\s?)|(-))?\\d+)*", sheetIndexesParam)) {
                List<Integer> sheetIndexes = new ArrayList<Integer>();

                String[] ranges = sheetIndexesParam.split(",");

                for (String range : ranges) {
                    range = range.trim();

                    int firstHyphenPos = range.indexOf('-');
                    int lastHyphenPos = range.lastIndexOf('-');

                    if (firstHyphenPos > -1) {
                        String s0 = range.substring(0, firstHyphenPos);
                        String s1 = range.substring(lastHyphenPos + 1);

                        int initialIndex = Integer.parseInt(s0);
                        int lastIndex = Integer.parseInt(s1);

                        for (int i = initialIndex; i < lastIndex + 1; i++)
                            sheetIndexes.add(i);
                    } else {
                        sheetIndexes.add(Integer.valueOf(range));
                    }
                }
                return sheetIndexes;
            } else {
                System.err.println("The sheet range is incorrect");
                System.exit(0);
            }
        }
        // When sheetIndexes field is null, then all sheets in the input Excel workbook are processed
        return null;
    }

    private static File parseDrlFileParam(String drlFileParam) {
        File file = new File(drlFileParam);
        if (file.exists()) {
            if (file.canRead()) {
                String fileExtension = FilenameUtils.getExtension(file.getName());

                final String DSLR_EXTENSION = "DSLR";
                final String DRL_EXTENSION = "DRL";

                if (DSLR_EXTENSION.equalsIgnoreCase(fileExtension)) {
                    useDSL = true;
                } else if (DRL_EXTENSION.equalsIgnoreCase(fileExtension)) {
                    useDSL = false;
                } else {
                    System.err.println("The knowledge base file extension must be DSLR_EXTENSION or DRL_EXTENSION");
                    System.exit(0);
                }
            } else {
                System.err.println("The knowledge base file cannot be read");
                System.exit(0);
            }
        } else {
            System.err.println("The knowledge base file does not exist");
            System.exit(0);
        }
        return file;
    }

    private static Path parseCatDirectoryParam(String catDirectoryParam) {
        if (null != catDirectoryParam) {
            try {
                return Paths.get(catDirectoryParam);
            } catch (InvalidPathException e) {
                System.err.println("The cat directory path is invalid");
                e.printStackTrace();
            }
        }
        return null;
    }

    private static Path parseOutputDirectoryParam(String outputDirectoryParam) {
        if (null != outputDirectoryParam) {
            try {
                return Paths.get(outputDirectoryParam);
            } catch (InvalidPathException e) {
                System.err.println("The output directory path is invalid");
                e.printStackTrace();
            }
        } else {
            // Creating default output directory
            String defaultOutputDirectoryPath = inputExcelFile.getParent();
            return Paths.get(defaultOutputDirectoryPath);
        }
        return null;
    }

    private static boolean parseIgnoreSuperscriptParam(String withoutSuperscriptParam) {
        if (null != withoutSuperscriptParam) {
            return Boolean.valueOf(withoutSuperscriptParam);
        }
        return false;
    }

    private static boolean parseUseCellValueParam(String useCellValueParam) {
        if (null != useCellValueParam) {
            return Boolean.valueOf(useCellValueParam);
        }
        return false;
    }

    private static boolean parseUseShortNamesParam(String UseShortNamesParam) {
        if (null != UseShortNamesParam) {
            return Boolean.valueOf(UseShortNamesParam);
        }
        return false;
    }

    private static boolean parseDebuggingModeParam(String debuggingModeParam) {
        if (null != debuggingModeParam) {
            return Boolean.valueOf(debuggingModeParam);
        }
        return false;
    }

    private static String traceParsedParams() {
        StringBuilder sb = new StringBuilder();
        sb.append("Command line parameters:\r\n");
        char indent = '\t';
        try {
            sb.append(indent).append(String.format("Excel file: \"%s\"%n", inputExcelFile.getCanonicalPath()));
            if (null != sheetIndexes) {
                StringBuilder sb0 = new StringBuilder();
                final char comma = ',';
                for (int i = 0; i < sheetIndexes.size(); i++) {
                    Integer sheetIndex = sheetIndexes.get(i);
                    sb0.append(sheetIndex);
                    if (i < sheetIndexes.size() - 1)
                        sb0.append(comma);
                }
                sb.append(indent).append(String.format("Sheets: [%s]%n", sb0.toString()));
            } else {
                // When sheetIndexes field is null, then all sheets in the input Excel workbook are processed
                sb.append(indent).append("Sheets in processing: ALL\n");
            }

            sb.append(indent).append(String.format("DRL file: \"%s\"%n", drlFile.getCanonicalPath()));
            if (null != catDirectory)
                sb.append(indent).append(String.format("Category directory: \"%s\"%n", catDirectory.toRealPath()));

            sb.append(indent).append(String.format("Ignoring superscript text: %b%n", ignoreSuperscript));
            sb.append(indent).append(String.format("Using cell values as text: %b%n", useCellValue));
            sb.append(indent).append(String.format("Using short names: \"%s\"%n", useShortNames));
            sb.append(indent).append(String.format("Output directory: \"%s\"%n", outputDirectory.toRealPath()));
            sb.append(indent).append(String.format("Debugging mode: %b", debuggingMode));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static void printUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("TabbyXL", options);
    }

    /*
     * Params:
     * -input <input excel file>          an input excel workbook (*.xlsx file)
     * -sheets <sheet indexes>            sheet indexes in the input excel workbook (e.g. "0-2,4,5,7-10")
     * -ruleset <drl or dslr file>        a ruleset (*.drl or *.dslr file)
     * -categorySpec <category directory> a directory with category specifications in YAML (*.cat files)
     * -output <output directory>         a directory for outputting results
     * -ignoreSuperscript <true|false>    specify true to ignore superscript text in cells (false used by default)
     * -useCellText <true|false>          specify true to use cell values as text (false used by default)
     * -useShortNames <true|false>        specify true to use short names (just sheet names) for output files (false used by default)
     * -debuggingMode <true|false>        specify true to turn on debugging mode (false used by default)
     * -help                              print the usage
     */
    @SuppressWarnings("static-access")
    private static void parseCommandLineParams(String[] args) {
        // Creating command line parameters
        Option inputExcelFileOpt = OptionBuilder
                .withArgName("input excel file path")
                .hasArg()
                .withDescription("an input excel workbook (*.xlsx file)")
                //.isRequired()
                .create("input");

        Option sheetIndexesOpt = OptionBuilder
                .withArgName("sheet indexes")
                .hasArg()
                .withDescription("sheet indexes in the input excel workbook (e.g. \"0-2,4,5,7-10\")")
                .create("sheets");

        Option drlFileOpt = OptionBuilder
                .withArgName("ruleset path")
                .hasArg()
                .withDescription("a ruleset (*.drl or *.dslr file)")
                //.isRequired()
                .create("ruleset");

        Option catDirectoryOpt = OptionBuilder
                .withArgName("category directory path")
                .hasArg()
                .withDescription("a directory with category specifications in YAML (*.cat files)")
                .create("categorySpec");

        Option outputDirectoryOpt = OptionBuilder
                .withArgName("output directory path")
                .hasArg()
                .withDescription("a directory for outputting results")
                .create("output");

        Option ignoreSuperscriptOpt = OptionBuilder
                .withArgName("true|false")
                .hasArg()
                .withDescription("specify true to ignore superscript text in cells (false used by default)")
                .create("ignoreSuperscript");

        Option useCellValueOpt = OptionBuilder
                .withArgName("true|false")
                .hasArg()
                .withDescription("specify true to use cell values as text (false used by default)")
                .create("useCellText");

        Option useShortNamesOpt = OptionBuilder
                .withArgName("true|false")
                .hasArg()
                .withDescription("specify true to use short names (just sheet names) for output files (false used by default)")
                .create("useShortNames");

        Option debuggingModeOpt = OptionBuilder
                .withArgName("true|false")
                .hasArg()
                .withDescription("specify true to turn on debugging mode (false used by default)")
                .create("debuggingMode");

        Option helpOpt = OptionBuilder
                .withDescription("print this message")
                .create("help");

        Options options = new Options();

        options.addOption(inputExcelFileOpt);
        options.addOption(sheetIndexesOpt);
        options.addOption(drlFileOpt);
        options.addOption(catDirectoryOpt);
        options.addOption(ignoreSuperscriptOpt);
        options.addOption(useCellValueOpt);
        options.addOption(outputDirectoryOpt);
        options.addOption(useShortNamesOpt);
        options.addOption(debuggingModeOpt);
        options.addOption(helpOpt);

        CommandLineParser parser = new BasicParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("help")) {
                printUsage(options);
                System.exit(0);
            }

            String inputExcelFileParam = cmd.getOptionValue(inputExcelFileOpt.getOpt());
            inputExcelFile = parseInputExcelFileParam(inputExcelFileParam);

            String sheetIndexesParam = cmd.getOptionValue(sheetIndexesOpt.getOpt());
            sheetIndexes = parseSheetIndexesParam(sheetIndexesParam);

            String drlFileParam = cmd.getOptionValue(drlFileOpt.getOpt());
            drlFile = parseDrlFileParam(drlFileParam);

            String catDirectoryParam = cmd.getOptionValue(catDirectoryOpt.getOpt());
            catDirectory = parseCatDirectoryParam(catDirectoryParam);

            String outputDirectoryParam = cmd.getOptionValue(outputDirectoryOpt.getOpt());
            outputDirectory = parseOutputDirectoryParam(outputDirectoryParam);

            String ignoreSuperscriptParam = cmd.getOptionValue(ignoreSuperscriptOpt.getOpt());
            ignoreSuperscript = parseIgnoreSuperscriptParam(ignoreSuperscriptParam);

            String useCellValuParam = cmd.getOptionValue(useCellValueOpt.getOpt());
            useCellValue = parseUseCellValueParam(useCellValuParam);

            String useShortNamesParam = cmd.getOptionValue(useShortNamesOpt.getOpt());
            useShortNames = parseUseShortNamesParam(useShortNamesParam);

            String debuggingModeParam = cmd.getOptionValue(debuggingModeOpt.getOpt());
            debuggingMode = parseDebuggingModeParam(debuggingModeParam);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void loadWorkbook() {
        //final DataLoader DATA_LOADER = new DataLoader( inputExcelFile );
        try {
            DATA_LOADER.loadWorkbook(inputExcelFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // When sheetIndexes field is null, then all sheets in the input Excel workbook are processed
        // Generating indexes for all sheets in the input excel workbook
        if (null == sheetIndexes) {
            sheetIndexes = new ArrayList<Integer>();
            for (int i = 0; i < DATA_LOADER.numOfSheets(); i++)
                sheetIndexes.add(i);
        }
    }

    private static void loadCatFiles() {
        if (null != catDirectory) {
            File folder = catDirectory.toFile();
            try {
                for (File file : folder.listFiles()) {
                    if (file.isFile()) {
                        if (file.exists()) {
                            if (file.canRead()) {
                                // TODO checking file extension: it must be *.cat
                                System.out.println(file.getName());
                                CATEGORY_TEMPLATE_MANAGER.load(file);
                            } else {
                                System.out.printf("The file cannot be read: \"%s\"%n", file);
                                System.exit(0);
                            }
                        } else {
                            System.out.printf("The file is not exists: \"%s\"%n", file);
                            System.exit(0);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TODO implement it
    public static void start(String[] args) {
        main(args);
    }

    public static void main(String[] args) {
        System.out.printf("Start timestamp: %s%n%n", new Timestamp(new Date().getTime()));

        try {
            parseCommandLineParams(args);
            System.out.printf("%s%n%n", traceParsedParams());

            loadWorkbook();
            loadRules();
            loadCatFiles();
            DATA_LOADER.setWithoutSuperscript(ignoreSuperscript);
            DATA_LOADER.setUseCellValue(useCellValue);

            int count = 0;

            // Processing sheets from the input Excel workbook
            for (int sheetNo : sheetIndexes) {
                DATA_LOADER.goToSheet(sheetNo);
                String sheetName = DATA_LOADER.getCurrentSheetName();

                int tableNo = 0;
                while (true) {
                    CTable table = DATA_LOADER.nextTable();
                    if (null == table) break;

                    count++;

                    System.out.printf("#%d Processing sheet: %d [%s] | table %d%n%n", count, sheetNo, sheetName, tableNo);
                    Tables.recoverCellBorders(table);

                    if (CATEGORY_TEMPLATE_MANAGER.hasAtLeastOneCategoryTemplate())
                        CATEGORY_TEMPLATE_MANAGER.createCategories(table);

                    fireRules(table, KNOWLEDGE_BASE);
                    table.update();

                    System.out.println(table.trace());
                    System.out.println();

                    CanonicalForm canonicalForm = table.toCanonicalForm();
                    //System.out.println( canonicalForm.trace() );
                    System.out.println("Canonical form:");
                    canonicalForm.print();
                    System.out.println();

                    StatisticsManager.Statistics statistics = statisticsManager.collect(table);
                    System.out.println(statistics.trace());
                    System.out.printf("Current rule firing time: %s%n%n", currentRuleFiringTime);

                    String fileName = FilenameUtils.removeExtension(inputExcelFile.getName());

                    String outFileName = null;
                    if (useShortNames) {
                        outFileName = String.format("%s\\%s.xlsx", outputDirectory, sheetName);
                    } else {
                        outFileName = String.format("%s\\%s_%s_%s.xlsx", outputDirectory, fileName, sheetNo, tableNo);
                    }
                    EvaluationExcelWriter writer = new EvaluationExcelWriter(new File(outFileName));
                    writer.write(table);

                    tableNo++;
                }
            }
            // Checking and creating output data directory
            if (Files.notExists(outputDirectory)) Files.createDirectory(outputDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(statisticsManager.trace());
            System.out.printf("Total rule firing time: %s%n%n", totalRuleFiringTime);
            System.out.printf("End timestamp: %s%n", new Timestamp(new Date().getTime()));
            CATEGORY_TEMPLATE_MANAGER.release();
        }
    }

    private static void loadRules() {
        final KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Resource resource = ResourceFactory.newFileResource(TabbyXL.drlFile.getAbsolutePath());

        if (useDSL) {
            InputStream in = null;
            try {
                in = TabbyXL.class.getResourceAsStream(DSL);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            Resource dslResource = ResourceFactory.newInputStreamResource(in);
            kBuilder.add(dslResource, ResourceType.DSL);
            kBuilder.add(resource, ResourceType.DSLR);
        } else {
            kBuilder.add(resource, ResourceType.DRL);
        }

        if (kBuilder.hasErrors()) {
            System.out.println(kBuilder.getErrors().toString());
            throw new RuntimeException("Unable to compile");
        }
        final Collection<KnowledgePackage> pkgs = kBuilder.getKnowledgePackages();
        KNOWLEDGE_BASE.addKnowledgePackages(pkgs);
    }

    private static void fireRules(CTable table, KnowledgeBase knowledgeBase) {
        //final StatelessKnowledgeSession kSession = KNOWLEDGE_BASE.newStatelessKnowledgeSession();
        final StatefulKnowledgeSession kSession = knowledgeBase.newStatefulKnowledgeSession();

        if (debuggingMode) {
            kSession.addEventListener(new DebugAgendaEventListener());
            //kSession.addEventListener( new DebugWorkingMemoryEventListener() );
        }

        //List facts = new ArrayList();

        //Iterator<CRow> rows = table.getRows();
        //while ( rows.hasNext() ) facts.add( rows.next() );

        //Iterator<CCol> cols = table.getCols();
        //while ( cols.hasNext() ) facts.add( cols.next() );

        Iterator<CCell> cells = table.getCells();
        while (cells.hasNext()) {
            //facts.add( cells.next() );
            kSession.insert(cells.next());
        }

        Iterator<CCategory> categories = table.getLocalCategoryBox().getCategories();
        while (categories.hasNext()) {
            kSession.insert(categories.next());
        }

        Date startDate = new Date();
        //kSession.execute( facts );
        kSession.fireAllRules();
        Date endDate = new Date();

        currentRuleFiringTime = endDate.getTime() - startDate.getTime();
        totalRuleFiringTime += currentRuleFiringTime;
    }

    private TabbyXL() {
    }
}




