/*
 * Copyright 2015-18 Alexey O. Shigarov (shigarov@gmail.com)
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

package ru.icc.td.tabbyxl.evaluation;

import org.apache.poi.ss.usermodel.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.apache.poi.ss.usermodel.CellType.*;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;

public class EvalBox {
    Eval entryEval;
    Eval labelEval;
    Eval elPairEval;
    Eval llPairEval;

    private Workbook groundTruthWorkbook;
    private Workbook resultWorkbook;

    private void readCompData() {
        CompData gt = new CompData(entryEval.groundTruthCodes, labelEval.groundTruthCodes, elPairEval.groundTruthCodes, llPairEval.groundTruthCodes);
        CompData result = new CompData(entryEval.resultCodes, labelEval.resultCodes, elPairEval.resultCodes, llPairEval.resultCodes);
        readEntries(groundTruthWorkbook.getSheetAt(1), gt);
        readLabels(groundTruthWorkbook.getSheetAt(2), gt);
        readEntries(resultWorkbook.getSheetAt(1), result);
        readLabels(resultWorkbook.getSheetAt(2), result);
    }

    private void readEntries(Sheet sheet, CompData compData) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // Reading codes of entries
            String s0 = extractCellValue(row.getCell(0));
            String formula = row.getCell(1).getCellFormula();
            String s1 = formula.substring(formula.lastIndexOf(',') + 2, formula.length() - 2);
            String entryCode = String.format("%s [%s]", s0, s1);
            compData.entries.add(entryCode);

            // Reading codes of entry-label pairs
            Cell c2 = row.getCell(2);
            if (null != c2) {
                String s2 = row.getCell(2).getStringCellValue();
                if (s2 != null && s2.length() > 3) {
                    s2 = s2.substring(1, s2.length() - 1);
                    String[] labelShortCodes = s2.split("\",\\s\"");
                    for (String labelShortCode : labelShortCodes) {
                        String entryLabelPairCode = String.format("%s -> %s", entryCode, labelShortCode);
                        compData.entryLabelPairs.add(entryLabelPairCode);
                    }
                }
            }
        }
    }

    private void readLabels(Sheet sheet, CompData compData) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // Reading codes of labels
            String s0 = extractCellValue(row.getCell(0));
            String formula = row.getCell(1).getCellFormula();
            String s1 = formula.substring(formula.lastIndexOf(',') + 2, formula.length() - 2);
            String labelCode = String.format("%s [%s]", s0, s1);
            compData.labels.add(labelCode);

            // Reading label-label pairs
            Cell c2 = row.getCell(2);
            if (null != c2) {
                String s2 = c2.getStringCellValue();
                if (s2 != null && !s2.isEmpty()) {
                    String labelLabelPairCode = String.format("%s -> %s", labelCode, s2);
                    compData.labelLabelPairs.add(labelLabelPairCode);
                }
            }
        }
    }

    private String extractCellFormulaValue(Cell excelCell) {
        String value = null;

        switch (excelCell.getCachedFormulaResultType()) {
            case NUMERIC:
                value = Double.toString(excelCell.getNumericCellValue());
                break;

            case STRING:
                value = excelCell.getStringCellValue();
                break;

            case BOOLEAN:
                value = Boolean.toString(excelCell.getBooleanCellValue());
                break;
        }

        return value;
    }

    private String extractCellValue(Cell excelCell) {
        String value = null;

        switch (excelCell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(excelCell))
                    value = excelCell.getStringCellValue();
                else
                    value = Double.toString(excelCell.getNumericCellValue());
                break;

            case STRING:
                value = excelCell.getRichStringCellValue().getString();
                break;

            case BOOLEAN:
                value = Boolean.toString(excelCell.getBooleanCellValue());
                break;

            case FORMULA:
                value = extractCellFormulaValue(excelCell);
                break;

            case BLANK:
                break;

            case ERROR:
                break;
        }
        return value;
    }

    public static EvalBox evaluate(Workbook groundTruthWorkbook, Workbook resultWorkbook) {
        EvalBox evalBox = new EvalBox(groundTruthWorkbook, resultWorkbook);
        evalBox.readCompData();
        evalBox.entryEval.evaluate();
        evalBox.labelEval.evaluate();
        evalBox.elPairEval.evaluate();
        evalBox.llPairEval.evaluate();
        return evalBox;
    }

    public EvalView createEvalView(){
        return new EvalView(this);
    }

    private EvalBox(Workbook groundTruthWorkbook, Workbook resultWorkbook) {
        this.groundTruthWorkbook = groundTruthWorkbook;
        this.resultWorkbook = resultWorkbook;
        this.entryEval = new Eval(CodeType.ENTRIES);
        this.labelEval = new Eval(CodeType.LABELS);
        this.elPairEval = new Eval(CodeType.ENTRY_LABEL_PAIRS);
        this.llPairEval = new Eval(CodeType.LABEL_LABEL_PAIRS);
    }

    /*
    public void print() {
        final String[] columnNames = {"", "entries", "labels", "entry-label pairs", "label-label pairs"};

        String r1 = entryEval.recallAsString();
        String r2 = labelEval.recallAsString();
        String r3 = elPairEval.recallAsString();
        String r4 = llPairEval.recallAsString();
        final String[] recallRecord = {"recall", r1, r2, r3, r4};

        String p1 = entryEval.precisionAsString();
        String p2 = labelEval.precisionAsString();
        String p3 = elPairEval.precisionAsString();
        String p4 = llPairEval.precisionAsString();
        final String[] precisionRecord = {"precision", p1, p2, p3, p4};

        final Object[][] data = {recallRecord, precisionRecord};
        TextTable tt = new TextTable(columnNames, data);

        tt.printTable();

        System.out.print(entryEval.traceErrors());
        System.out.print(labelEval.traceErrors());
        System.out.print(elPairEval.traceErrors());
        System.out.print(llPairEval.traceErrors());
        System.out.println();
    }
    */

    public String traceErrors(){
        StringBuilder sb = new StringBuilder(4);
        sb.append(entryEval.traceErrors());
        sb.append(labelEval.traceErrors());
        sb.append(elPairEval.traceErrors());
        sb.append(llPairEval.traceErrors());
        return sb.toString();
    }

    public boolean hasErrors(){
        return entryEval.hasErrors() || labelEval.hasErrors() || elPairEval.hasErrors() || llPairEval.hasErrors();
    }

    public int totalFalseNegatives() {
        int total = 0;
        total += entryEval.numOfFalseNegatives();
        total += labelEval.numOfFalseNegatives();
        total += elPairEval.numOfFalseNegatives();
        total += llPairEval.numOfFalseNegatives();
        return total;
    }

    public int totalFalsePositives() {
        int total = 0;
        total += entryEval.numOfFalsePositives();
        total += labelEval.numOfFalsePositives();
        total += elPairEval.numOfFalsePositives();
        total += llPairEval.numOfFalsePositives();
        return total;
    }

    static class Eval {
        private CodeType codeType;

        private String codeTypeAsString() {
            switch (codeType) {
                case ENTRIES:
                    return "entries";
                case LABELS:
                    return "labels";
                case ENTRY_LABEL_PAIRS:
                    return "entry-label pairs";
                case LABEL_LABEL_PAIRS:
                    return "label-label pairs";
                default:
                    return null;
            }
        }

        private Set<String> resultCodes = new HashSet<>();
        private Set<String> groundTruthCodes = new HashSet<>();
        private Set<String> missingResultCodes = new HashSet<>();
        private Set<String> missingGroundTruthCodes = new HashSet<>();

        int numOfCorrectCases() {
            return resultCodes.size() - missingResultCodes.size();
        }

        int numOfAllCasesInGroundTruth() {
            return groundTruthCodes.size();
        }

        int numOfAllCasesInResult() {
            return resultCodes.size();
        }

        float recall() {
            return (float) numOfCorrectCases() / (float) numOfAllCasesInGroundTruth();
        }

        float precision() {
            return (float) numOfCorrectCases() / (float) numOfAllCasesInResult();
        }

        private Eval(CodeType codeType) {
            this.codeType = codeType;
        }

        private String trace() {
            StringBuffer sb = new StringBuffer();
            sb.append(String.format("recall = %f (%d/%d)%n", recall(), numOfCorrectCases(), numOfAllCasesInGroundTruth()));
            sb.append(String.format("precision = %f (%d/%d)%n", precision(), numOfCorrectCases(), numOfAllCasesInResult()));
            return sb.toString();
        }

        private String recallAsString() {
            return String.format("%s (%d/%d)", Float.toString(recall()), numOfCorrectCases(), numOfAllCasesInGroundTruth());
        }

        private String precisionAsString() {
            return String.format("%s (%d/%d)", Float.toString(precision()), numOfCorrectCases(), numOfAllCasesInResult());
        }

        private String traceMissingCodes(Iterator<String> missingCodes) {
            if (null == missingCodes) return null;
            final StringBuffer sb = new StringBuffer();
            int count = 0;
            while (missingCodes.hasNext()) {
                String code = missingCodes.next();
                sb.append(++count).append('\t').append(code).append(System.lineSeparator());
            }
            return sb.toString();
        }

        private int numOfFalsePositives(){
            return numOfAllCasesInResult() - numOfCorrectCases();
        }

        private int numOfFalseNegatives(){
            return numOfAllCasesInGroundTruth() - numOfCorrectCases();
        }

        private boolean hasErrors(){
            return numOfFalsePositives() + numOfFalseNegatives() > 0 ? true : false;
        }

        private String traceErrors() {
            final StringBuffer sb = new StringBuffer();

            final String template1 = "%nFalse negatives in the %s (total %d): %n";
            if (missingGroundTruthCodes.size() > 0) {
                sb.append(String.format(template1, codeTypeAsString(), numOfFalseNegatives()));
                String s = traceMissingCodes(missingGroundTruthCodes.iterator());
                sb.append(s);
            }

            final String template2 = "%nFalse positives in the %s (total %d):%n";
            if (missingResultCodes.size() > 0) {
                sb.append(String.format(template2, codeTypeAsString(), numOfFalsePositives()));
                String s = traceMissingCodes(missingResultCodes.iterator());
                sb.append(s);
            }

            return sb.toString();
        }

        private void evaluate() {
            for (String code : resultCodes) {
                if (!groundTruthCodes.contains(code))
                    missingResultCodes.add(code);
            }

            for (String code : groundTruthCodes) {
                if (!resultCodes.contains(code))
                    missingGroundTruthCodes.add(code);
            }
        }
    }

    private static class CompData {
        Set<String> entries;
        Set<String> labels;
        Set<String> entryLabelPairs;
        Set<String> labelLabelPairs;

        public CompData(Set<String> entries, Set<String> labels, Set<String> entryLabelPairs, Set<String> labelLabelPairs) {
            this.entries = entries;
            this.labels = labels;
            this.entryLabelPairs = entryLabelPairs;
            this.labelLabelPairs = labelLabelPairs;
        }
    }

    private enum CodeType {
        ENTRIES, LABELS, ENTRY_LABEL_PAIRS, LABEL_LABEL_PAIRS
    }

}
