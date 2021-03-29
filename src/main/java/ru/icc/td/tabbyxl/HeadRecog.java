package ru.icc.td.tabbyxl;

import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.preprocessing.headrecog.HeadRecogPreprocessor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HeadRecog {

    private static String input;
    private static String output;
    private static List<Integer> sheetIndexes;

    public static void main(String[] args) {
        new HeadRecog().run(args);
    }

    private void run(String[] args) {

        try {
            parseCmd(args);

            File inputFile = new File(input);

            if (!inputFile.exists()) {
                System.err.println("The input Excel file does not exist");
                System.exit(0);
            } else {
                if (!inputFile.canRead()) {
                    System.err.println("The input Excel file cannot be read");
                    System.exit(0);
                }
            }

            System.out.println(String.format("Input Excel file: %s", inputFile.getPath()));

            DataLoader loader = DataLoader.getInstance();
            loader.loadWorkbook(inputFile);

            if (sheetIndexes == null) {
                sheetIndexes = new ArrayList<>();
                for (int i = 0; i < loader.numOfSheets(); i++) {
                    sheetIndexes.add(i);
                }
            }

            HeadRecogPreprocessor hcsc;

            if (output == null) {
                System.out.println("The output file is not defined");
                System.exit(0);
            }

            File outputFile = new File(output);
            if (!outputFile.exists()) {
                Files.createFile(outputFile.toPath());
            }
            FileUtils.copyFile(inputFile, outputFile);

            hcsc = new HeadRecogPreprocessor(outputFile);
            System.out.printf("Output Excel file: %s%n", outputFile.getPath());

            // Process tables
            for (int sheetNo : sheetIndexes) {
                loader.goToSheet(sheetNo);

                while (true) {
                    CTable table = loader.nextTable();
                    if (table == null) break;

                    hcsc.process(table);
                }
            }

            hcsc.saveWorkbook();

            System.out.println();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void parseCmd(String[] args) throws ParseException {

        CommandLineParser parser = new BasicParser();

        Option inputOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to an input excel workbook (*.xlsx)")
                .create("input");

        Option sheetIndexesOpt = OptionBuilder
                .withArgName("sheet indexes")
                .hasArg()
                .withDescription("specify sheet indexes in the input excel workbook (e.g. \"0-2,4,5,7-10\")")
                .create("sheets");

        Option outputOpt = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription("specify a path to an output excel workbook (*.xlsx)")
                .create("output");

        Option helpOpt = OptionBuilder
                .withDescription("print this message")
                .create("help");

        Options options = new Options();
        options.addOption(inputOpt);
        options.addOption(sheetIndexesOpt);
        options.addOption(outputOpt);
        options.addOption(helpOpt);

        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption(helpOpt.getOpt())) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("HeadRecog", options);
            System.exit(0);
        }

        if (!cmd.hasOption(inputOpt.getOpt())) throw new ParseException("specify input excel file path");
        input = cmd.getOptionValue(inputOpt.getOpt());

        if (cmd.hasOption(sheetIndexesOpt.getOpt()))
            sheetIndexes = parseSheetIndexesParam(cmd.getOptionValue(sheetIndexesOpt.getOpt()));

        if (cmd.hasOption(outputOpt.getOpt())) output = cmd.getOptionValue(outputOpt.getOpt());
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
}
