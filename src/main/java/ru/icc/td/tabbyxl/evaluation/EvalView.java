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

import dnl.utils.text.table.TextTable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class EvalView {
    private int numOfGroundTruthEntries;
    private int numOfResultEntries;
    private int numOfCorrectEntries;

    private int numOfGroundTruthLabels;
    private int numOfResultLabels;
    private int numOfCorrectLabels;

    private int numOfGroundTruthELPairs;
    private int numOfResultELPairs;
    private int numOfCorrectELPairs;

    private int numOfGroundTruthLLPairs;
    private int numOfResultLLPairs;
    private int numOfCorrectLLPairs;

    public void increment(EvalView evalView) {
        numOfGroundTruthEntries += evalView.numOfGroundTruthEntries;
        numOfResultEntries += evalView.numOfResultEntries;
        numOfCorrectEntries += evalView.numOfCorrectEntries;

        numOfGroundTruthLabels += evalView.numOfGroundTruthLabels;
        numOfResultLabels += evalView.numOfResultLabels;
        numOfCorrectLabels += evalView.numOfCorrectLabels;

        numOfGroundTruthELPairs += evalView.numOfGroundTruthELPairs;
        numOfResultELPairs += evalView.numOfResultELPairs;
        numOfCorrectELPairs += evalView.numOfCorrectELPairs;

        numOfGroundTruthLLPairs += evalView.numOfGroundTruthLLPairs;
        numOfResultLLPairs += evalView.numOfResultLLPairs;
        numOfCorrectLLPairs += evalView.numOfCorrectLLPairs;
    }

    private String fractionAsString(int numerator, int denominator) {
        float f = (float) numerator / (float) denominator;
        return String.format("%s (%d/%d)", Float.toString(f), numerator, denominator);
    }

    public String trace() {
        final String[] columnNames = {"", "entries", "labels", "entry-label pairs", "label-label pairs"};

        String r1 = fractionAsString(numOfCorrectEntries, numOfGroundTruthEntries);
        String r2 = fractionAsString(numOfCorrectLabels, numOfGroundTruthLabels);
        String r3 = fractionAsString(numOfCorrectELPairs, numOfGroundTruthELPairs);
        String r4 = fractionAsString(numOfCorrectLLPairs, numOfGroundTruthLLPairs);
        final String[] recallRecord = {"recall", r1, r2, r3, r4};

        String p1 = fractionAsString(numOfCorrectEntries, numOfResultEntries);
        String p2 = fractionAsString(numOfCorrectLabels, numOfResultLabels);
        String p3 = fractionAsString(numOfCorrectELPairs, numOfResultELPairs);
        String p4 = fractionAsString(numOfCorrectLLPairs, numOfResultLLPairs);
        final String[] precisionRecord = {"precision", p1, p2, p3, p4};

        final Object[][] data = {recallRecord, precisionRecord};
        TextTable tt = new TextTable(columnNames, data);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        tt.printTable(ps, 0);
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

    public EvalView() {
    }

    public EvalView(EvalBox evalBox) {
        numOfGroundTruthEntries = evalBox.entryEval.numOfAllCasesInGroundTruth();
        numOfResultEntries = evalBox.entryEval.numOfAllCasesInResult();
        numOfCorrectEntries = evalBox.entryEval.numOfCorrectCases();

        numOfGroundTruthLabels = evalBox.labelEval.numOfAllCasesInGroundTruth();
        numOfResultLabels = evalBox.labelEval.numOfAllCasesInResult();
        numOfCorrectLabels = evalBox.labelEval.numOfCorrectCases();

        numOfGroundTruthELPairs = evalBox.elPairEval.numOfAllCasesInGroundTruth();
        numOfResultELPairs = evalBox.elPairEval.numOfAllCasesInResult();
        numOfCorrectELPairs = evalBox.elPairEval.numOfCorrectCases();

        numOfGroundTruthLLPairs = evalBox.llPairEval.numOfAllCasesInGroundTruth();
        numOfResultLLPairs = evalBox.llPairEval.numOfAllCasesInResult();
        numOfCorrectLLPairs = evalBox.llPairEval.numOfCorrectCases();
    }
}
