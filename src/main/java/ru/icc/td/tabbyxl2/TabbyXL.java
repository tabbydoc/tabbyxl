/*
 * Copyright 2015-18 Alexey O. Shigarov (shigarov@gmail.com) and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl2;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.cli.*;
import org.apache.commons.io.FilenameUtils;
import ru.icc.td.tabbyxl2.crl2j.rulemodel.Ruleset;
import ru.icc.td.tabbyxl2.crl2j.RuleModelBuilder;
import ru.icc.td.tabbyxl2.crl2j.RuleCodeGen;
import ru.icc.td.tabbyxl2.crl2j.AstPrinter;
import ru.icc.td.tabbyxl2.crl2j.parsing.crl_gramLexer;
import ru.icc.td.tabbyxl2.crl2j.parsing.crl_gramParser;
import ru.icc.td.tabbyxl2.model.*;
import ru.icc.td.tabbyxl2.writers.EvaluationExcelWriter;

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
    private static File rulesetFile;
    private static Path catDirectory;
    private static boolean ignoreSuperscript;
    private static boolean useCellValue;
    private static Path outputDirectory;
    private static boolean debuggingMode;
    private static boolean useShortNames;
    private static boolean useRuleEngine;
    private static File ruleEngineConfigFile;
    private static String ruleEngineName;

    // Statistics
    private static final StatisticsManager statisticsManager = StatisticsManager.getInstance();
    private static long totalRuleFiringTime;
    private static long currentRuleFiringTime;

    private static long beginTime;
    private static long endTime;

    private static final DataLoader DATA_LOADER = DataLoader.getInstance();
    private static final CategoryTemplateManager CATEGORY_TEMPLATE_MANAGER = CategoryTemplateManager.getInstance();

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

    private static File parseRulesetFileParam(String rulesetFileParam) {
        File file = new File(rulesetFileParam);
        if (file.exists()) {
            if (file.canRead()) {
                // Note that to need to set <code>useRuleEngine</code> before parsing rule file param
                if (!useRuleEngine) {
                    String fileExtension = FilenameUtils.getExtension(file.getName());
                    if (!fileExtension.equalsIgnoreCase("crl")) {
                        System.err.println("The extension of the ruleset file is not .crl");
                    }
                }
                return file;
            } else {
                System.err.println("The knowledge base file cannot be read");
                System.exit(0);
            }
        } else {
            System.err.println("The knowledge base file does not exist");
            System.exit(0);
        }
        return null;
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

    private static boolean parseRuleEngineConfigFileParam(String ruleEngineConfigFileParam) {
        if (null != ruleEngineConfigFileParam) {
            File file = new File(ruleEngineConfigFileParam);

            if (file.exists()) {
                if (file.canRead()) {
                    String fileExtension = FilenameUtils.getExtension(file.getName());
                    if (!fileExtension.equalsIgnoreCase("properties")) {
                        System.err.println("The extension of the rule engine config file is not .properties");
                    }
                    ruleEngineConfigFile = file;
                    return true;
                } else {
                    System.err.println("The rule engine config file cannot be read");
                    System.exit(0);
                }
            } else {
                System.err.println("The rule engine config file does not exist");
                System.exit(0);
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

            if (null != catDirectory)
                sb.append(indent).append(String.format("Category directory: \"%s\"%n", catDirectory.toRealPath()));

            sb.append(indent).append(String.format("Ignoring superscript text: %b%n", ignoreSuperscript));
            sb.append(indent).append(String.format("Using cell values as text: %b%n", useCellValue));
            sb.append(indent).append(String.format("Using short names: \"%s\"%n", useShortNames));
            sb.append(indent).append(String.format("Output directory: \"%s\"%n", outputDirectory.toRealPath()));
            sb.append(indent).append(String.format("Debugging mode: %b%n", debuggingMode));
            sb.append(indent).append(String.format("Using a rule engine: %b", useRuleEngine));

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
       -ruleset <path>                    specify a path to a ruleset file (e.g. *.crl (CRL), *.drl or *.dslr (Drools), or *.clp (JESS))
       -categorySpec <path>               specify a path to a directory with category specifications in YAML files (*.cat)
       -output <path>                     specify a path to a directory for outputting results
       -ignoreSuperscript <true|false>    specify true to ignore superscript text in cells (false used by default)
       -useCellText <true|false>          specify true to use cell values as text (false used by default)
       -useShortNames <true|false>        specify true to use short names (just sheet names) for output files (false used by default)
       -debuggingMode <true|false>        specify true to turn on debugging mode (false used by default)
       -ruleEngineConfig <path>           specify a path to a rule crl2j configuration file (*.properties) you prefer to use (e.g. Drools, JESS)
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

        Option rulesetFileOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to a ruleset file (e.g. *.crl (CRL), *.drl or *.dslr (Drools), or *.clp (JESS))")
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
                .withDescription("specify a path to a configuration file (*.properties) of a rule crl2j you prefer to use (e.g. Drools, JESS)")
                .create("ruleEngineConfig");

        Option helpOpt = OptionBuilder
                .withDescription("print this message")
                .create("help");

        Options options = new Options();

        options.addOption(inputExcelFileOpt);
        options.addOption(sheetIndexesOpt);
        options.addOption(rulesetFileOpt);
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

            // Note that to need to set <code>useRuleEngine</code> before parsing rule file param
            String ruleEngineConfigFileParam = cmd.getOptionValue(ruleEngineConfigOpt.getOpt());
            useRuleEngine = parseRuleEngineConfigFileParam(ruleEngineConfigFileParam);

            String rulesetFileParam = cmd.getOptionValue(rulesetFileOpt.getOpt());
            rulesetFile = parseRulesetFileParam(rulesetFileParam);

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
        beginTime = new Date().getTime();
        System.out.printf("Start timestamp: %s%n%n", new Timestamp(new Date().getTime()));

        try {
            parseCommandLineParams(args);
            System.out.printf("%s%n%n", traceParsedParams());

            if (useRuleEngine)
                fireRulesWithRuleEngine();
            else
                fireRulesWithCRL2J();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endTime = new Date().getTime();
            System.out.println(statisticsManager.trace());
            System.out.printf(String.format("Engine: %s%n%n", ruleEngineName));
            System.out.printf("Total rule firing time: %s%n%n", totalRuleFiringTime);
            System.out.printf("Rule loading time: %s%n%n", time2.getTime() - time1.getTime());
            System.out.printf("Total time: %s%n%n", endTime - beginTime);
            System.out.printf("End timestamp: %s%n", new Timestamp(new Date().getTime()));
            CATEGORY_TEMPLATE_MANAGER.release();
        }
    }

    private static Date time1;
    private static Date time2;

    private static void fireRulesWithRuleEngine() throws Exception {

        loadWorkbook();

        time1 = new Date();

        Properties ruleEngineConfig = new Properties();
        ruleEngineConfig.load(new FileReader(ruleEngineConfigFile));

        Class.forName(ruleEngineConfig.getProperty("RULE_SERVICE_PROVIDER_IMPL"));
        RuleServiceProvider ruleServiceProvider = RuleServiceProviderManager.getRuleServiceProvider(ruleEngineConfig.getProperty("RULE_SERVICE_PROVIDER"));
        ruleEngineName = ruleEngineConfig.getProperty("RULE_SERVICE_PROVIDER");
        RuleAdministrator ruleAdministrator = ruleServiceProvider.getRuleAdministrator();

        LocalRuleExecutionSetProvider ruleExecutionSetProvider = ruleAdministrator.getLocalRuleExecutionSetProvider(null);

        Reader rulesetFileReader = new InputStreamReader(new FileInputStream(rulesetFile));

        Map properties = new HashMap();
        properties.put("source", ruleEngineConfig.getProperty("source"));

        if (null != ruleEngineConfig.getProperty("DSL")) {
            properties.put("dsl", new InputStreamReader(new FileInputStream(ruleEngineConfig.getProperty("DSL"))));
        }

        RuleExecutionSet ruleExecutionSet = ruleExecutionSetProvider.createRuleExecutionSet(rulesetFileReader, properties);

        RuleRuntime ruleRuntime = ruleServiceProvider.getRuleRuntime();

        ruleAdministrator.registerRuleExecutionSet(ruleExecutionSet.getName(), ruleExecutionSet, null);
        StatefulRuleSession session = (StatefulRuleSession) ruleRuntime.createRuleSession(ruleExecutionSet.getName(), null, RuleRuntime.STATEFUL_SESSION_TYPE);

        rulesetFileReader.close();

        System.out.println("The rule engine is ready");
        //dslReader.close();

        time2 = new Date();

        loadCatFiles();
        DATA_LOADER.setWithoutSuperscript(ignoreSuperscript);
        DATA_LOADER.setUseCellValue(useCellValue);

        int count = 0;

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

                String outFileName;
                if (useShortNames) {
                    outFileName = String.format("%s.xlsx", sheetName);

                } else {
                    outFileName = String.format("%s_%s_%s.xlsx", fileName, sheetNo, tableNo);
                }
                Path outPath = outputDirectory.resolve(outFileName);
                EvaluationExcelWriter writer = new EvaluationExcelWriter(outPath.toFile());
                writer.write(table);

                tableNo++;
            }
        }
    }

    private static void loadCRL2J() throws IOException, RecognitionException {

        ruleEngineName = "CRL2J";

        ANTLRFileStream fileStream1 = new ANTLRFileStream(rulesetFile.getPath());
        crl_gramLexer lexer = new crl_gramLexer(fileStream1);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        System.out.println("Token stream ok");
        crl_gramParser pars = new crl_gramParser(tokenStream);
        System.out.println("parser ok");
        AstPrinter astPrinter = new AstPrinter();
        System.out.println("printer ok");
        CommonTree tree = pars.crl().getTree();
        System.out.println("tree ok");
        //astPrinter.PrintAction(tree);

        RuleModelBuilder ruleModelBuilder = new RuleModelBuilder();
        ruleModelBuilder.buildModel(tree);
        Ruleset ruleset = ruleModelBuilder.getRuleset();
        System.out.println("ruleset ok");
        //System.out.println(ruleset.toString());

        RuleCodeGen.compileAllRules(ruleset);
        System.out.println("RuleClasses ok");
    }

    // TODO: Specify expected exceptions separately
    private static void fireRulesWithCRL2J() throws Exception {

        loadWorkbook();
        loadCatFiles();

        time1 = new Date();
        loadCRL2J();
        time2 = new Date();

        DATA_LOADER.setWithoutSuperscript(ignoreSuperscript);
        DATA_LOADER.setUseCellValue(useCellValue);

        int count = 0;

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

                String outFileName;
                if (useShortNames) {
                    outFileName = String.format("%s.xlsx", sheetName);

                } else {
                    outFileName = String.format("%s_%s_%s.xlsx", fileName, sheetNo, tableNo);
                }
                Path outPath = outputDirectory.resolve(outFileName);
                EvaluationExcelWriter writer = new EvaluationExcelWriter(outPath.toFile());
                writer.write(table);

                tableNo++;

            }
        }

        if (Files.notExists(outputDirectory)) Files.createDirectory(outputDirectory);

    }

    private TabbyXL() {
    }
}



