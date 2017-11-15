package ru.icc.cells.ssdc.evaluation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey Shigarov on 27.06.2016.
 */
public class Evaluator {
    public static void main(String[] args) throws IOException {
        File resultDirectory = new File(args[0]);
        File groundTruthDirectory = new File(args[1]);

        File[] listOfExcelFiles = resultDirectory.listFiles(e -> e.getName().endsWith(".xlsx"));
        Evaluator e = new Evaluator();

        for (File resultExcelFile : listOfExcelFiles) {
            if (resultExcelFile.isFile()) {
                String name = resultExcelFile.getName();
                System.out.println("FILE: " + name);
                File gtExcelFile = new File(groundTruthDirectory.getAbsolutePath() + '\\' + resultExcelFile.getName());
                e.load(resultExcelFile, gtExcelFile);
                e.evaluate(name);
            }
        }

        System.out.println("SUMMARY OF RESULTS:");
        System.out.println(RESULT.trace());

        System.out.println("SUMMARY OF ERRORS:");
        System.out.println();
        System.out.printf("Tables processed with errors, total = %d%n", e.totalOfTablesWithErrors);
        System.out.printf("False negatives, total = %d in %d tables%n", e.sumOfFalseNegatives, e.totalOfTablesWithFalseNegatives);
        System.out.printf("False positives, total = %d in %d tables%n", e.sumOfFalsePositives, e.totalOfTablesWithFalsePositives);

        if (e.errorSummary.size() > 0) {
            System.out.println();
            System.out.println("List of tables processed with errors:");
            int count = 0;
            for (String s : e.errorSummary)
                System.out.printf("\t%d\t%s%n", ++count, s);
        }
    }

    private Workbook resWorkbook;
    private Workbook gtWorkbook;

    private Evaluator() {
    }

    private void load(File resultWorkbookFile, File groundTruthWorkbookFile) throws IOException {
        loadResultWorkbook(resultWorkbookFile);
        loadGroundTruthWorkbook(groundTruthWorkbookFile);
    }

    private void loadResultWorkbook(File resultWorkbookFile) throws IOException {
        resWorkbook = loadWorkbook(resultWorkbookFile);
    }

    private void loadGroundTruthWorkbook(File groundTruthWorkbookFile) throws IOException {
        gtWorkbook = loadWorkbook(groundTruthWorkbookFile);
    }

    private Workbook loadWorkbook(File excelFile) throws IOException {
        Workbook workbook = null;
        FileInputStream fin = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(fin);

        return workbook;
    }

    private static final EvalView RESULT = new EvalView();

    private static final String ERROR_PRINTING_TEMPLATE = "Errors (false negatives, total = %d; false positives, total = %d):%n";
    private static final String ERROR_SUMMARY_TEMPLATE = "%s\t(false negatives, total = %d;\tfalse positives, total = %d)";
    private final List<String> errorSummary = new ArrayList<>();
    private int sumOfFalseNegatives = 0;
    private int sumOfFalsePositives = 0;
    private int totalOfTablesWithErrors = 0;
    private int totalOfTablesWithFalseNegatives = 0;
    private int totalOfTablesWithFalsePositives = 0;

    private void evaluate(String name) throws IllegalStateException {
        if (null == resWorkbook)
            throw new IllegalStateException("The result workbook has not been loaded");

        if (null == gtWorkbook)
            throw new IllegalStateException("The ground truth workbook has not been loaded");

        EvalBox box = EvalBox.evaluate(gtWorkbook, resWorkbook);
        EvalView view = box.createEvalView();
        System.out.println("Results:");
        System.out.println(view.trace());
        if (box.hasErrors()) {
            int totalFalseNegatives = box.totalFalseNegatives();
            int totalFalsePositives = box.totalFalsePositives();

            sumOfFalseNegatives += totalFalseNegatives;
            sumOfFalsePositives += totalFalsePositives;

            if (totalFalseNegatives > 0) totalOfTablesWithFalseNegatives++;
            if (totalFalsePositives > 0) totalOfTablesWithFalsePositives++;
            if (totalFalseNegatives + totalFalsePositives > 0) totalOfTablesWithErrors++;

            errorSummary.add(String.format(ERROR_SUMMARY_TEMPLATE, name, totalFalseNegatives, totalFalsePositives));
            System.out.printf(ERROR_PRINTING_TEMPLATE, totalFalseNegatives, totalFalsePositives);
            System.out.println(box.traceErrors());
        }
        System.out.println();
        RESULT.increment(view);
    }
}
