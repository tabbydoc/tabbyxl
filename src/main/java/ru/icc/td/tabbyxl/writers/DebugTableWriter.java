/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@gmail.com)
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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.*;

import java.io.File;
import java.util.function.BiConsumer;

public final class DebugTableWriter extends BasicTableWriter {

    @Override
    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = super.writeToWorkbook(table);

        CanonicalForm cf = table.toCanonicalForm();

        // Write Ner Tag Sheet

        Sheet sheet1 = workbook.createSheet("NER TAGS");
        BiConsumer<CItem, Cell> setCellValByNerTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            NerTag tag = cell.getNerTag();
            String s = null == tag ? null : tag.toString();
            excelCell.setCellValue(s);
        };
        writeCanonicalForm(sheet1, cf, setCellValByNerTag);

        // Write Type Tag Sheet

        Sheet sheet2 = workbook.createSheet("TYPE TAGS");
        BiConsumer<CItem, Cell> setCellValByTypeTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            TypeTag tag = cell.getTypeTag();
            String s = null == tag ? null : tag.toString();
            excelCell.setCellValue(s);
        };
        writeCanonicalForm(sheet2, cf, setCellValByTypeTag);

        // Write Type Tag Sheet

        Sheet sheet3 = workbook.createSheet("USER-DEFINED TAGS");
        BiConsumer<CItem, Cell> setCellValByTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            String tag = cell.getMark();
            excelCell.setCellValue(tag);
        };
        writeCanonicalForm(sheet3, cf, setCellValByTag);

        return workbook;
    }

    public DebugTableWriter(File outputFile) {
        super(outputFile);
    }
}
