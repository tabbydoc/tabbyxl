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

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.cli.*;
import org.apache.commons.io.FilenameUtils;
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
import ru.icc.cells.ssdc.engine.rulemodel.Model;
import ru.icc.cells.ssdc.engine.RuleModelBuilder;
import ru.icc.cells.ssdc.engine.RuleCodeGen;
import ru.icc.cells.ssdc.engine.AstPrinter;
import ru.icc.cells.ssdc.engine.parsing.crl_gramLexer;
import ru.icc.cells.ssdc.engine.parsing.crl_gramParser;
import ru.icc.cells.ssdc.model.*;
import ru.icc.cells.ssdc.writers.EvaluationExcelWriter;

import javax.rules.*;
import javax.rules.admin.LocalRuleExecutionSetProvider;
import javax.rules.admin.RuleAdministrator;
import javax.rules.admin.RuleExecutionSet;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Pattern;


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
    private static boolean ruleEngineConfigEngine;
    private static File engineConfigFile;
    private static String engineName;

    // TODO DSL initialisation from settings is needed
    private static final String DSL = "/crl2.dsl";

    // Statistics
    private static final StatisticsManager statisticsManager = StatisticsManager.getInstance();
    private static long totalRuleFiringTime;
    private static long currentRuleFiringTime;

    private static long beginTime;
    private static long endTime;

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

                /*if (DSLR_EXTENSION.equalsIgnoreCase(fileExtension)) {
                    useDSL = true;
                } else if (DRL_EXTENSION.equalsIgnoreCase(fileExtension)) {
                    useDSL = false;
                } else {
                    System.err.println("The knowledge base file extension must be DSLR_EXTENSION or DRL_EXTENSION");
                    System.exit(0);
                }*/
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
                Path outputDirectory = Paths.get(outputDirectoryParam);

                if (Files.notExists(outputDirectory)) {
                    try {
                        Files.createDirectory(outputDirectory);
                    } catch (IOException e) {
                        System.err.println("The parsing directory does not exist and cannot be created");
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
                return outputDirectory;
            } catch (InvalidPathException e) {
                System.err.println("The parsing directory path is invalid");
                e.printStackTrace();
            }
        } else {
            // Creating default parsing directory
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

    private static boolean parseEngineParam(String engineParam) {
        if (null != engineParam) {
            engineConfigFile = new File(engineParam);
            if (engineConfigFile.exists() && engineConfigFile.canRead()) {
                return true;
            }
            else
            {
                System.err.println("Engine's configuration file is not exists or can not be read. Will be used imbedded engine");
                return false;
            }
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
            sb.append(indent).append(String.format("Debugging mode: %b%n", debuggingMode));
            sb.append(indent).append(String.format("Using rules engine: %b", ruleEngineConfigEngine));

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
       -input <path>                      specify a path to an input excel workbook (*.xlsx)
       -sheets <sheet indexes>            specify sheet indexes in the input excel workbook (e.g. "0-2,4,5,7-10")
       -ruleset <path>                    specify a path to a ruleset file (*.dslr (CRL), *.drl (Drools), or *.clp (JESS))
       -categorySpec <path>               specify a path to a directory with category specifications in YAML files (*.cat)
       -output <path>                     specify a path to a directory for outputting results
       -ignoreSuperscript <true|false>    specify true to ignore superscript text in cells (false used by default)
       -useCellText <true|false>          specify true to use cell values as text (false used by default)
       -useShortNames <true|false>        specify true to use short names (just sheet names) for output files (false used by default)
       -debuggingMode <true|false>        specify true to turn on debugging mode (false used by default)
       -ruleEngineConfig <path>           specify a path to a rule engine configuration file (*.properties) you prefer to use (e.g. Drools, JESS)
       -help                              print this usage
     */
    @SuppressWarnings("static-access")
    private static void parseCommandLineParams(String[] args) {
        // Creating command line parameters
        Option inputExcelFileOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to an input excel workbook (*.xlsx)")
                //.isRequired()
                .create("input");

        Option sheetIndexesOpt = OptionBuilder
                .withArgName("sheet indexes")
                .hasArg()
                .withDescription("specify sheet indexes in the input excel workbook (e.g. \"0-2,4,5,7-10\")")
                .create("sheets");

        Option drlFileOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to a ruleset file (*.dslr (CRL), *.drl (Drools), or *.clp (JESS))")
                //.isRequired()
                .create("ruleset");

        Option catDirectoryOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to a directory with category specifications in YAML files (*.cat)")
                .create("categorySpec");

        Option outputDirectoryOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to a directory for outputting results")
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
                .withDescription("specify true to use short names (just sheet names) for parsing files (false used by default)")
                .create("useShortNames");

        Option debuggingModeOpt = OptionBuilder
                .withArgName("true|false")
                .hasArg()
                .withDescription("specify true to turn on debugging mode (false used by default)")
                .create("debuggingMode");

        Option ruleEngineConfigOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to a configuration file (*.properties) of a rule engine you prefer to use (e.g. Drools, JESS)")
                .create("ruleEngineConfig");

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
        options.addOption(ruleEngineConfigOpt);
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

            String ruleEngineConfigParam = cmd.getOptionValue(ruleEngineConfigOpt.getOpt());
            ruleEngineConfigEngine = parseEngineParam(ruleEngineConfigParam);

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
        beginTime = new Date().getTime();
        System.out.printf("Start timestamp: %s%n%n", new Timestamp(new Date().getTime()));

        try {
            parseCommandLineParams(args);
            System.out.printf("%s%n%n", traceParsedParams());

            if(ruleEngineConfigEngine)
                fireUsingRulesEngineAPI();
            else
                fireWithOurEngine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endTime = new Date().getTime();
            System.out.println(statisticsManager.trace());
            System.out.printf(String.format("Engine: %s%n%n", engineName));
            System.out.printf("Total rule firing time: %s%n%n", totalRuleFiringTime);
            System.out.printf("Rules loading time: %s%n%n", time2.getTime() - time1.getTime());
            System.out.printf("General rules firing time: %s%n%n", endTime - beginTime);
            System.out.printf("End timestamp: %s%n", new Timestamp(new Date().getTime()));
            CATEGORY_TEMPLATE_MANAGER.release();
        }

    }


    private static Date time1;
    private static Date time2;


    /*
     * Use Java Rules Engine API
     */

    private static void fireUsingRulesEngineAPI() throws Exception {

        loadWorkbook();

        time1 = new Date();

        Properties engineConfig = new Properties();
        engineConfig.load(new FileReader(engineConfigFile));

        Class.forName(engineConfig.getProperty("RULE_SERVICE_PROVIDER_IMPL"));
        RuleServiceProvider ruleServiceProvider = RuleServiceProviderManager.getRuleServiceProvider(engineConfig.getProperty("RULE_SERVICE_PROVIDER"));
        engineName = engineConfig.getProperty("RULE_SERVICE_PROVIDER");
        RuleAdministrator ruleAdministrator = ruleServiceProvider.getRuleAdministrator();

        LocalRuleExecutionSetProvider ruleExecutionSetProvider = ruleAdministrator.getLocalRuleExecutionSetProvider(null);

        Reader drlReader = new InputStreamReader(new FileInputStream(drlFile));

        Map properties = new HashMap();
        properties.put("source", engineConfig.getProperty("source"));

        if (null != engineConfig.getProperty("DSL")) {
            properties.put("dsl", new InputStreamReader(new FileInputStream(engineConfig.getProperty("DSL"))));
        }

        RuleExecutionSet ruleExecutionSet = ruleExecutionSetProvider.createRuleExecutionSet(drlReader, properties);

        RuleRuntime ruleRuntime = ruleServiceProvider.getRuleRuntime();

        ruleAdministrator.registerRuleExecutionSet(ruleExecutionSet.getName(), ruleExecutionSet, null);
        StatefulRuleSession session = (StatefulRuleSession) ruleRuntime.createRuleSession(ruleExecutionSet.getName(), null, RuleRuntime.STATEFUL_SESSION_TYPE);

        drlReader.close();

        System.out.println("Engine is ready");
        //dslReader.close();

        time2 = new Date();

            loadCatFiles();
            DATA_LOADER.setWithoutSuperscript(ignoreSuperscript);
            DATA_LOADER.setUseCellValue(useCellValue);

            int count = 0;

            for(int sheetNo : sheetIndexes) {
            //for(int sheetNo : new int[]{88}) {
                DATA_LOADER.goToSheet(sheetNo);
                String sheetName = DATA_LOADER.getCurrentSheetName();

                int tableNo = 0;
                while (true) {
                    CTable table = DATA_LOADER.nextTable();
                    if(null == table) break;

                    count++;

                    System.out.printf("#%d Processing sheet: %d [%s] | table %d%n%n", count, sheetNo, sheetName, tableNo);
                    Tables.recoverCellBorders(table);

                    if (CATEGORY_TEMPLATE_MANAGER.hasAtLeastOneCategoryTemplate())
                        CATEGORY_TEMPLATE_MANAGER.createCategories(table);

                    Date startDate = new Date();

                    //StatefulRuleSession session = (StatefulRuleSession) ruleRuntime.createRuleSession(executionSetName, null, RuleRuntime.STATEFUL_SESSION_TYPE);

                    session.addObjects(table.getCellsList());
                    session.addObjects(table.getLocalCategoryBox().getCategoriesList());

                    session.executeRules();
                    session.reset();

                    table.update();

                    Date endDate = new Date();

                    currentRuleFiringTime = endDate.getTime() - startDate.getTime();
                    totalRuleFiringTime += currentRuleFiringTime;

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
    }


    /*
     * firing with Drools Engine
     */
    private static void fireWithDrools() throws Exception {

        loadWorkbook();

        time1 = new Date();
        loadRules();
        time2 = new Date();

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

                Date startDate = new Date();
                fireRules(table, KNOWLEDGE_BASE);
                Date endDate = new Date();

                currentRuleFiringTime = endDate.getTime() - startDate.getTime();
                totalRuleFiringTime += currentRuleFiringTime;

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
        // Checking and creating parsing data directory
        if (Files.notExists(outputDirectory)) Files.createDirectory(outputDirectory);

    }


    /*
     * firing with Our Engine
     */

    private static void loadEngine() throws IOException, RecognitionException {

        engineName = "imbedded";
        ANTLRFileStream fileStream1 = new ANTLRFileStream(drlFile.getPath());
        crl_gramLexer lexer = new crl_gramLexer(fileStream1);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        System.out.println("Token stream ok");
        crl_gramParser pars = new crl_gramParser(tokenStream);
        System.out.println("parser ok");
        AstPrinter astPrinter = new AstPrinter();
        System.out.println("printer ok");
        CommonTree tree = pars.crl().getTree();
        System.out.println("tree ok");
        //astPrinter.Print(tree);

        RuleModelBuilder ruleModelBuilder = new RuleModelBuilder();
        ruleModelBuilder.buildModel(tree);
        Model model = ruleModelBuilder.getModel();
        System.out.println("model ok");
        //System.out.println(model.toString());

        RuleCodeGen.compileAllRules(model);
        System.out.println("RuleClasses ok");
    }

    private static void fireWithOurEngine() throws Exception {

        loadWorkbook();
        loadCatFiles();

        time1 = new Date();
        loadEngine();
        time2 = new Date();

        DATA_LOADER.setWithoutSuperscript(ignoreSuperscript);
        DATA_LOADER.setUseCellValue(useCellValue);

        int count = 0;

        // for testing
            /*List<Integer> sheetIndexes2 = new ArrayList<>();
            sheetIndexes2.add(119);*/


         for (int sheetNo : sheetIndexes) {
             //for(int sheetNo : new int[]{0}) {
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

                    Date startDate = new Date();

                    RuleCodeGen.fireAllRules(table);

                    Date endDate = new Date();

                    currentRuleFiringTime = endDate.getTime() - startDate.getTime();
                    totalRuleFiringTime += currentRuleFiringTime;

                    table.update();

                    System.out.println(table.trace());
                    System.out.println();

                    CanonicalForm canonicalForm = table.toCanonicalForm();
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

            if (Files.notExists(outputDirectory)) Files.createDirectory(outputDirectory);

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

        //Date startDate = new Date();
        //kSession.execute( facts );
        kSession.fireAllRules();
        //Date endDate = new Date();

        //currentRuleFiringTime = endDate.getTime() - startDate.getTime();
        //totalRuleFiringTime += currentRuleFiringTime;
    }

    private TabbyXL() {
    }
}




