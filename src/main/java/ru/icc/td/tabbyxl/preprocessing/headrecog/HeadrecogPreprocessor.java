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
import ru.icc.td.tabbyxl.DataLoader;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.preprocessing.Preprocessor;

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

    @Override
    public void process(CTable table) {
        // TODO recovering the physical structure of a header by some visual features

        if (true){
            //Debug mode

            System.out.println("-------Start-----" + table.getSrcStartCellRef());




        }
    }
}
