/*
 * Copyright 2015-19 Alexey O. Shigarov (shigarov@gmail.com) and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl;

import org.antlr.runtime.RecognitionException;
import org.apache.commons.cli.*;
import org.apache.commons.io.FilenameUtils;
import ru.icc.td.tabbyxl.crl2j.CRL2JEngine;
import ru.icc.td.tabbyxl.model.*;
import ru.icc.td.tabbyxl.preprocessing.ner.NERecogPreprocessor;
import ru.icc.td.tabbyxl.util.StatisticsManager;
import ru.icc.td.tabbyxl.writers.BasicTableWriter;
import ru.icc.td.tabbyxl.writers.TableWriter;
import ru.icc.td.tabbyxl.writers.DebugTableWriter;
import ru.icc.td.tabbyxl.writers.EvaluationTableWriter;

import javax.rules.*;
import javax.rules.admin.LocalRuleExecutionSetProvider;
import javax.rules.admin.RuleAdministrator;
import javax.rules.admin.RuleExecutionSet;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Consumer;
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
    private static String executingOptionName;
    private static boolean useNer;

    // Support Google Sheets
    private static String gSpreadsheetID;
    private static String gSpreadsheetRange;
    private static File gServiceAccountKeyFile;

    // Statistics

    private static final StatisticsManager statisticsManager = StatisticsManager.getInstance();

    private static long rulesetPreparationTime;
    private static long totalRulesetExecutionTime;
    private static long currentRulesetExecutionTime;

    private static long startTime;
    private static long endTime;

    private static final DataLoader dataLoader = DataLoader.getInstance();
    private static final CategoryTemplateManager categoryTemplateManager = CategoryTemplateManager.getInstance();

    private static File parseInputExcelFileParam(String inputExcelFileParam) {
        if (inputExcelFileParam == null) return null;

        File file = new File(inputExcelFileParam);

        if (file.exists()) {
            if (file.canRead()) {
                return file;
            } else {
                System.err.println("The input excel file cannot be read");
                System.exit(0);
            }
        } else {
            System.err.println("The input excel file does not exist");
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
                        System.err.println("The output directory does not exist and cannot be created");
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
                return outputDirectory;
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

    private static boolean parseUseNerParam(String useNerParam) {
        if (null != useNerParam) {
            return Boolean.valueOf(useNerParam);
        }
        return false;
    }

    private static File parseGServiceAccountKeyFileParam(String path) {
        if (null != path) {
            File file = new File(path);

            if (file.exists()) {
                if (file.canRead()) {
                    String fileExtension = FilenameUtils.getExtension(file.getName());
                    if (!fileExtension.equalsIgnoreCase("p12")) {
                        System.err.println("The extension of the Google Sheets service account key file is not p12");
                    }
                    return file;
                } else {
                    System.err.println("The Google Sheets service account key file cannot be read");
                    System.exit(0);
                }
            } else {
                System.err.println("The Google Sheets service account key file does not exist");
                System.exit(0);
            }
        }
        return null;
    }

    private static String traceParsedParams() {
        StringBuilder sb = new StringBuilder();
        sb.append("Command line parameters:\r\n");
        char indent = '\t';
        try {
            if (null != inputExcelFile)
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

            // Support Google Sheets
            if (gSpreadsheetID != null) {
                sb.append(indent).append(String.format("Google Sheets Spreadsheet ID: \"%s\"%n", gSpreadsheetID));
                if (gSpreadsheetRange != null)
                    sb.append(indent).append(String.format("Google Sheets Spreadsheet Range: \"%s\"%n", gSpreadsheetRange));
                if (gServiceAccountKeyFile != null)
                    sb.append(indent).append(String.format("Google Service Account Key File: \"%s\"%n", gServiceAccountKeyFile));
            }
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

       -gSheetID <id>                     specify a Google Sheets spreadsheet ID (this can be extracted from its URL)
       -gSheetRange <range>               specify a range (e.g. "sheet1!A1:F5") in the Google Sheets spreadsheet
       -gServiceAccountKey <path>         specify a path to the Google service account key file (e.g. "mydata/key.p12")
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
                .withDescription("specify true to use short names (just sheet names) for output files (false used by default)")
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

        Option useNerOpt = OptionBuilder
                .withArgName("true|false")
                .hasArg()
                .withDescription("specify true to use NER in pre-processing")
                .create("useNer");

        Option helpOpt = OptionBuilder
                .withDescription("print this message")
                .create("help");

        // Support Google Sheets
        Option gSpreadsheetIdOpt = OptionBuilder
                .withArgName("id")
                .hasArg()
                .withDescription("specify a Google Sheets spreadsheet ID (this can be extracted from its URL)")
                .create("gSheetID");

        Option gSpreadsheetRangeOpt = OptionBuilder
                .withArgName("range")
                .hasArg()
                .withDescription("specify a range (e.g. \"MySheet!A1:F5\") of the Google Sheets spreadsheet")
                .create("gSheetRange");

        Option gServiceAccountKeyFileOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to the Google service account key file")
                .create("gServiceAccountKey");

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
        options.addOption(useNerOpt);
        options.addOption(helpOpt);

        // Support Google Sheets
        options.addOption(gSpreadsheetIdOpt);
        options.addOption(gSpreadsheetRangeOpt);
        options.addOption(gServiceAccountKeyFileOpt);

        CommandLineParser clParser = new BasicParser();

        try {
            CommandLine cmd = clParser.parse(options, args);

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

            String useNerParam = cmd.getOptionValue(useNerOpt.getOpt());
            useNer = parseUseNerParam(useNerParam);

            // Support Google Sheets
            gSpreadsheetID = cmd.getOptionValue(gSpreadsheetIdOpt.getOpt());
            gSpreadsheetRange = cmd.getOptionValue(gSpreadsheetRangeOpt.getOpt());
            String gServiceAccountKeyFileParam = cmd.getOptionValue(gServiceAccountKeyFileOpt.getOpt());
            gServiceAccountKeyFile = parseGServiceAccountKeyFileParam(gServiceAccountKeyFileParam);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void loadWorkbook() {
        try {
            dataLoader.loadWorkbook(inputExcelFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // When sheetIndexes field is null, then all sheets in the input Excel workbook are processed
        // Generating indexes for all sheets in the input excel workbook
        if (null == sheetIndexes) {
            sheetIndexes = new ArrayList<Integer>();
            for (int i = 0; i < dataLoader.numOfSheets(); i++)
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
                                // TODO: Add checking file extension: it must be *.cat
                                System.out.println(file.getName());
                                categoryTemplateManager.load(file);
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void start(String[] args) {
        main(args);
    }

    public static void main(String[] args) {

        // This is needed for setting up log4j properly
        org.apache.log4j.BasicConfigurator.configure();

        startTime = new Date().getTime();
        System.out.printf("Start timestamp: %s%n%n", new Timestamp(new Date().getTime()));

        try {
            parseCommandLineParams(args);
            System.out.printf("%s%n%n", traceParsedParams());

            if (gSpreadsheetID == null) {
                dataLoader.setWithoutSuperscript(ignoreSuperscript);
                dataLoader.setUseCellValue(useCellValue);

                // Load data
                loadWorkbook();
                loadCatFiles();
            } else {
                // TODO Check the Google Sheets spreadsheet by its ID
            }

            if (Files.notExists(outputDirectory)) Files.createDirectory(outputDirectory);

            // Process data

            if (useRuleEngine)
                runWithRuleEngine();
            else
                runWithCRL2J();

            endTime = new Date().getTime();
            System.out.println(statisticsManager.trace());

            System.out.printf(String.format("\tUsed option: %s%n", executingOptionName));
            System.out.printf("\tRuleset preparation time: %s ms%n", rulesetPreparationTime);
            System.out.printf("\tRuleset execution time (total for all tables): %s ms%n", totalRulesetExecutionTime);
            System.out.printf("\tTotal time: %s ms%n", endTime - startTime);
            System.out.println();
            System.out.printf("End timestamp: %s%n", new Timestamp(new Date().getTime()));

        } catch (IOException | ReflectiveOperationException | RuleException | RecognitionException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {

            categoryTemplateManager.release();
        }
    }

    private static RuleSession getRuleSession(Properties ruleEngineConfig) throws IOException, ClassNotFoundException, RuleException {

        Class.forName(ruleEngineConfig.getProperty("RULE_SERVICE_PROVIDER_IMPL"));
        RuleServiceProvider ruleServiceProvider = RuleServiceProviderManager.getRuleServiceProvider(ruleEngineConfig.getProperty("RULE_SERVICE_PROVIDER"));
        RuleAdministrator ruleAdministrator = ruleServiceProvider.getRuleAdministrator();
        LocalRuleExecutionSetProvider ruleExecutionSetProvider = ruleAdministrator.getLocalRuleExecutionSetProvider(null);

        Reader rulesetFileReader = new InputStreamReader(new FileInputStream(rulesetFile));

        Map properties = new HashMap();
        properties.put("source", ruleEngineConfig.getProperty("SOURCE"));

        if (null != ruleEngineConfig.getProperty("DSL")) {
            properties.put("dsl", new InputStreamReader(new FileInputStream(ruleEngineConfig.getProperty("DSL"))));
        }

        RuleExecutionSet ruleExecutionSet = ruleExecutionSetProvider.createRuleExecutionSet(rulesetFileReader, properties);
        RuleRuntime ruleRuntime = ruleServiceProvider.getRuleRuntime();
        ruleAdministrator.registerRuleExecutionSet(ruleExecutionSet.getName(), ruleExecutionSet, null);

        rulesetFileReader.close();

        return ruleRuntime.createRuleSession(ruleExecutionSet.getName(), null, RuleRuntime.STATEFUL_SESSION_TYPE);
    }

    private static void runWithRuleEngine() throws IOException, ClassNotFoundException, RuleException {
        System.out.println("Rule preparing is in progress");
        System.out.println();

        final Date startTime = new Date();

        Properties ruleEngineConfig = new Properties();
        ruleEngineConfig.load(new FileReader(ruleEngineConfigFile));
        executingOptionName = ruleEngineConfig.getProperty("RULE_SERVICE_PROVIDER");
        StatefulRuleSession session = (StatefulRuleSession) getRuleSession(ruleEngineConfig);

        final Date endTime = new Date();
        rulesetPreparationTime = endTime.getTime() - startTime.getTime();

        System.out.println();
        System.out.println("Rule preparing is completed successfully");
        System.out.println();
        System.out.println("Table processing is in progress");
        System.out.println();

        Consumer<CTable> ruleEngineOption = (table) -> {
            try {
                session.addObjects(table.getCellList());
                session.addObjects(table.getLocalCategoryBox().getCategoryList());
                session.executeRules();
                session.reset();
            } catch (RemoteException | InvalidRuleSessionException e) {
                e.printStackTrace();
            }
        };

        processTables(ruleEngineOption);

        System.out.println();
        System.out.println("Table processing is completed successfully");
        System.out.println();
    }

    private static void runWithCRL2J() throws IOException, RecognitionException {
        System.out.println("Rule preparing is in progress");
        System.out.println();

        final Date startTime = new Date();

        executingOptionName = "CRL2JEngine";
        final CRL2JEngine crl2jEngine = new CRL2JEngine();
        crl2jEngine.loadRules(rulesetFile);

        final Date endTime = new Date();
        rulesetPreparationTime = endTime.getTime() - startTime.getTime();

        System.out.println();
        System.out.println("Rule preparing is completed successfully");
        System.out.println();
        System.out.println("Table processing is in progress");
        System.out.println();

        Consumer<CTable> crl2jOption = (table) -> {crl2jEngine.processTable(table);};

        processTables(crl2jOption);

        System.out.println();
        System.out.println("Table processing is completed successfully");
        System.out.println();
    }

    private static void processGoogleSheetTable(Consumer<CTable> executionOption) throws IOException {
        GoogleSheetsDataLoader dataLoader = new GoogleSheetsDataLoader(gServiceAccountKeyFile);
        CTable table = dataLoader.getTable(gSpreadsheetID, gSpreadsheetRange);

        if (table == null) return;

        // Assign a NER tag to each cell of the table
        if (useNer) {
            ner.process(table);
        }

        Date startDate = new Date();
        executionOption.accept(table);
        Date endDate = new Date();

        currentRulesetExecutionTime = endDate.getTime() - startDate.getTime();
        totalRulesetExecutionTime += currentRulesetExecutionTime;

        table.update();

        System.out.println(table.trace());
        System.out.println();

        CanonicalForm canonicalForm = table.toCanonicalForm();
        System.out.println("Canonical form:");
        canonicalForm.print();
        System.out.println();

        StatisticsManager.Statistics statistics = statisticsManager.collect(table);
        System.out.println(statistics.trace());
        System.out.printf("Current rule firing time: %s%n%n", currentRulesetExecutionTime);

        //String fileName = FilenameUtils.removeExtension(inputExcelFile.getName());

        String outFileName;
        if (useShortNames) {
            String sheetName = gSpreadsheetRange == null ? "Sheet1" : gSpreadsheetRange;
            sheetName.replaceAll(":", "-");
            outFileName = String.format("%s.xlsx", sheetName);

        } else {
            outFileName = String.format("%s_%s_%s.xlsx", gSpreadsheetID, 1, 1);
        }
        Path outPath = outputDirectory.resolve(outFileName);

        // Write output to Excel
        TableWriter tableWriter;
        File outFile = outPath.toFile();

        // Only basic and debug table writers supported
        tableWriter = new BasicTableWriter(outFile);
        tableWriter.write(table);
    }

    private static void processTables(Consumer<CTable> executionOption) throws IOException {
        if (inputExcelFile != null) {
            processExcelTables(executionOption);
        } else if (gSpreadsheetID != null) {
            processGoogleSheetTable(executionOption);
        }
    }

    private static void processExcelTables(Consumer<CTable> executionOption) throws IOException {
        int count = 0;

        for (int sheetNo : sheetIndexes) {
            dataLoader.goToSheet(sheetNo);
            String sheetName = dataLoader.getCurrentSheetName();

            int tableNo = 0;
            while (true) {
                CTable table = dataLoader.nextTable();
                if (null == table) break;

                count++;

                System.out.printf("#%d Processing sheet: %d [%s] | table %d%n%n", count, sheetNo, sheetName, tableNo);

                if (categoryTemplateManager.hasAtLeastOneCategoryTemplate())
                    categoryTemplateManager.createCategories(table);

                // Assign a NER tag to each cell of the table
                if (useNer) {
                    ner.process(table);
                }

                Date startDate = new Date();
                executionOption.accept(table);
                Date endDate = new Date();

                currentRulesetExecutionTime = endDate.getTime() - startDate.getTime();
                totalRulesetExecutionTime += currentRulesetExecutionTime;

                table.update();

                System.out.println(table.trace());
                System.out.println();

                CanonicalForm canonicalForm = table.toCanonicalForm();
                System.out.println("Canonical form:");
                canonicalForm.print();
                System.out.println();

                StatisticsManager.Statistics statistics = statisticsManager.collect(table);
                System.out.println(statistics.trace());
                System.out.printf("Current rule firing time: %s%n%n", currentRulesetExecutionTime);

                String fileName = FilenameUtils.removeExtension(inputExcelFile.getName());

                String outFileName;
                if (useShortNames) {
                    outFileName = String.format("%s.xlsx", sheetName);

                } else {
                    outFileName = String.format("%s_%s_%s.xlsx", fileName, sheetNo, tableNo);
                }
                Path outPath = outputDirectory.resolve(outFileName);

                // Write output to Excel
                TableWriter tableWriter;
                File outFile = outPath.toFile();

                //final boolean useDebug = false; // Comment me to use debug table writing
                final boolean useDebug = true; // Uncomment me to use debug table writing

                if (useDebug)
                    tableWriter = new DebugTableWriter(outFile);
                else
                    tableWriter = new EvaluationTableWriter(outFile);
                tableWriter.write(table);

                tableNo++;
            }
        }
    }

    private static final NERecogPreprocessor ner = new NERecogPreprocessor(false);

    private TabbyXL() {
    }
}
