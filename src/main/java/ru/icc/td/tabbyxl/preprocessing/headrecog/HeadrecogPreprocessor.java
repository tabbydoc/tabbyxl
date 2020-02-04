/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@gmail.com) and Viacheslav V. Paramonov
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

package ru.icc.td.tabbyxl.preprocessing.headrecog;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.icc.td.tabbyxl.DataLoader;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.preprocessing.Preprocessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeadrecogPreprocessor implements Preprocessor {
    private int rowLetterToInt(String col) {
        //Get number of Excel column by letter name
        int number = 0;
        col = col.toUpperCase();
        for (int i = 0; i < col.length(); i++) {
            number = number * 26 + (col.charAt(i) - ('A' - 1));
        }
        return number;
    }

    private int[] cellsInIntArray(String col){
        int divPos;
        int result[] = new int[2];
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(col);
        if (m.find()) {
            divPos = m.start();
            if (divPos < 1)
                throw new IllegalArgumentException("Incorrect coordinates of Excel cell");
            result[0] = rowLetterToInt(col.substring(0, divPos));
            result[1] = Integer.parseInt(col.substring(divPos));
        }
        return result;
    }

    private Workbook getWorkbook(File srcFile) throws IOException {
        Workbook workbook;
        FileInputStream fin = new FileInputStream(srcFile);
        workbook = new XSSFWorkbook(fin);
        return workbook;
    }

    @Override
    public void process(CTable table) {
        // TODO recovering the physical structure of a header by some visual features
        Workbook workbook;
        GetHead head;
        String pathToSave = "E:\\devel\\cells\\identHead\\testData\\";
        String fileToSave = "res.xlsx";
        int srcStartCell[];
        if (true){
            //Debug mode
            try {
                workbook = getWorkbook(table.getSrcWorkbookFile());
                srcStartCell = cellsInIntArray(table.getSrcStartCellRef());
                head = new GetHead(table, srcStartCell, workbook, table.getSrcSheetName(), pathToSave, true);
                if (head != null){
                    head.analyzeHead();
                    head.saveWorkbook(String.format("%s%s_%s", pathToSave, table.getSrcSheetName(), fileToSave));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("-------Start-----" + cellsInIntArray(table.getSrcStartCellRef())[1]);




        }
    }
}
