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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.CValue;
import ru.icc.td.tabbyxl.model.CanonicalForm;
import ru.icc.td.tabbyxl.model.CanonicalForm.Record;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;

public class BasicExcelWriter extends Writer {

    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = new XSSFWorkbook();

        // Writing the canonical form of a table
        CanonicalForm cf = table.toCanonicalForm();

        Sheet sheet = workbook.createSheet("CANONICAL FORM");
        BiConsumer<CValue, Cell> fillCellByValue = (value, excelCell) -> {
            excelCell.setCellValue(value.getValue());
        };

        writeCanonicalFormToSheet(sheet, cf, fillCellByValue);

        return workbook;
    }

    protected void writeCanonicalFormToSheet(Sheet sheet, CanonicalForm cf, BiConsumer<CValue, Cell> consumer) {

        // Write header

        String[] header = cf.getHeaderStrings();
        Row excelRow = sheet.createRow(0);

        for (int i = 0; i < header.length; i++) {
            excelRow.createCell(i).setCellValue(header[i]);
            excelRow.createCell(i).setCellValue(header[i]);
        }

        // Write rows

        List<Record> records = cf.getRecords();

        int i = 1;

        for (Record record : records) {
            excelRow = sheet.createRow(i);

            CValue[] values = record.getValues();

            for (int j = 0; j < values.length; j++) {
                CValue value = values[j];
                if (null != value) {
                    Cell excelCell = excelRow.createCell(j);
                    consumer.accept(value, excelCell);
                }
            }
            i++;
        }

        for (i = 0; i < header.length; i++) {
            sheet.autoSizeColumn(i);
        }
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
