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

import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.preprocessing.Preprocessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class HeadrecogPreprocessor implements Preprocessor {

    private int rowLetterToInt(String col) {
        //Get number of Excel column by letter name
        int number = 0;
        col = col.toUpperCase();
        for (int i = 0; i < col.length(); i++) {
            number = number * 26 + (col.charAt(i) - ('A' - 1));
        }
        return number;
    }

    private int[] cellsInIntArray(String col) {
        int divPos;
        int[] result = new int[2];
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(col);
        if (m.find()) {
            divPos = m.start();
            if (divPos < 1)
                throw new IllegalArgumentException("Incorrect coordinates of Excel cell");
            result[0] = rowLetterToInt(col.substring(0, divPos)) - 1;
            result[1] = Integer.parseInt(col.substring(divPos)) - 1;
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
        /*
        This process corrects a cell structure in the table header by using cell borders visually highlighted.
        The results of the table header correction can be as a modified table written in a debugging workbook.

        You can use two options to output debugging workbooks:
        Use <multiSheets = 0> to write each debugging sheet to a separate workbook.
        Use <multiSheets = 1> to write all debugging sheets in one workbook.
        */

        Workbook workbook;
        GetHead head;
        byte multiSheets = 1;
        boolean firstSheet = true;
        File fileToOpen;
        String pathToSave = "D:/yd/data/tabbyxl/hrecog/saus200/data/";
        //String pathToSave = "D:\\Dev\\OutDataset\\";
        String fileToSave = "tables.xlsx";
        int[] srcStartCell;
        if (true) {
            //Debug mode
            try {
                if (multiSheets == 0) {
                    fileToOpen = table.getSrcWorkbookFile();
                } else
                    fileToOpen = new File(pathToSave + fileToSave);


                workbook = getWorkbook(fileToOpen);
                srcStartCell = cellsInIntArray(table.getSrcStartCellRef());
                head = new GetHead(table, srcStartCell, workbook, table.getSrcSheetName(), pathToSave, true);

                if (head != null) {
                    head.analyzeHead();

                    if (multiSheets == 0)
                        head.saveWorkbook(String.format("%s%s_%s", pathToSave, table.getSrcSheetName(), fileToSave));
                    else
                        head.saveWorkbook(String.format("%s%s", pathToSave, fileToSave));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("-------Start-----" + cellsInIntArray(table.getSrcStartCellRef())[1]);
        }

    }
}
