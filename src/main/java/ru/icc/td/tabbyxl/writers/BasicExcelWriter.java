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

package ru.icc.td.tabbyxl.writers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.CanonicalForm;
import ru.icc.td.tabbyxl.model.CanonicalForm.Record;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BasicExcelWriter extends Writer {

    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = new XSSFWorkbook();

        // Writing the canonical form of a table
        CanonicalForm canonicalForm = table.toCanonicalForm();
        String[] header = canonicalForm.getHeaderStrings();

        Sheet sheet = workbook.createSheet("CANONICAL TABLE");

        Row excelRow = sheet.createRow(0);

        for (int i = 0; i < header.length; i++) {
            excelRow.createCell(i).setCellValue(header[i]);
        }

        List<Record> records = canonicalForm.getRecords();

        int i = 1;

        for (Record record : records) {
            excelRow = sheet.createRow(i);
            String[] recordString = record.getStrings();
            for (int j = 0; j < recordString.length; j++) {
                excelRow.createCell(j).setCellValue(recordString[j]);
            }
            i++;
        }

        for (i = 0; i < header.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }

    public void write(CTable table) throws IOException {
        Workbook workbook = writeToWorkbook(table);
        FileOutputStream fileOut = new FileOutputStream(outputFile);
        workbook.write(fileOut);
        fileOut.close();
    }

    public BasicExcelWriter(File outputFile) {
        super(outputFile);
    }
}
