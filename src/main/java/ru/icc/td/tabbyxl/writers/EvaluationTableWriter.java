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
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CEntry;
import ru.icc.td.tabbyxl.model.CLabel;
import ru.icc.td.tabbyxl.model.CTable;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class EvaluationTableWriter extends BasicTableWriter
{
    @Override
    protected Workbook writeToWorkbook(CTable table)
    {
        Workbook workbook = super.writeToWorkbook(table);
        Sheet sheet = null;
        Row excelRow = null;
        Cell excelCell = null;
        int i = 0;

        final Path sourceWorkbookPath = table.getSrcWorkbookFile().toPath();
        final String sourceSheetName = table.getSrcSheetName();
        final Path basePath = Paths.get(outputFile.getParent());
        final Path relativePath = basePath.relativize(sourceWorkbookPath);
        final String template = "HYPERLINK(\"[%s]%s!%s\",\"%s\")";

        // Writing the evaluation sheet of entries

        sheet = workbook.createSheet("ENTRIES");
        excelRow = sheet.createRow(0);
        excelRow.createCell(0).setCellValue("ENTRY");
        excelRow.createCell(1).setCellValue("PROVENANCE");
        excelRow.createCell(2).setCellValue("LABELS");

        Iterator<CEntry> entries = table.getEntries();
        i = 1;
        while(entries.hasNext())
        {
            CEntry entry = entries.next();
            excelRow = sheet.createRow(i++);

            excelRow.createCell(0).setCellValue(entry.getValue());

            excelCell = excelRow.createCell(1);
            String cellRef = entry.getCell().getProvenance();
            String formula = String.format(template, relativePath, sourceSheetName, cellRef, cellRef);
            excelCell.setCellFormula(formula);

            final StringBuilder sb = new StringBuilder();
            Iterator<CLabel> labels = entry.getLabels();
            while ( labels.hasNext() )
            {
                CLabel label = labels.next();
                String value = label.getValue();
                CCell cell = label.getCell();
                String provenance;
                if (null != cell) {
                    provenance = label.getCell().getProvenance();
                } else {
                    provenance = null;
                }
                value = String.format("\"%s [%s]\"", value, provenance);
                sb.append(value);
                if ( labels.hasNext() )
                    sb.append(", ");
            }
            excelRow.createCell(2).setCellValue(sb.toString());
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        // Writing the evaluation sheet of labels

        sheet = workbook.createSheet("LABELS");
        excelRow = sheet.createRow(0);
        excelRow.createCell(0).setCellValue("LABEL");
        excelRow.createCell(1).setCellValue("PROVENANCE");
        excelRow.createCell(2).setCellValue("PARENT");
        excelRow.createCell(3).setCellValue("CATEGORY");

        Iterator<CLabel> labels = table.getLabels();
        i = 1;
        while(labels.hasNext()) {
            CLabel label = labels.next();
            excelRow = sheet.createRow(i++);
            excelRow.createCell(0).setCellValue(label.getValue());

            excelCell = excelRow.createCell(1);
            //excelCell.setCellValue(entry.getCell().getProvenance());
            String cellRef = label.getCell().getProvenance();
            String formula = String.format(template, relativePath, sourceSheetName, cellRef, cellRef);
            excelCell.setCellFormula(formula);

            if (label.hasParent())
            {
                CLabel parent = label.getParent();
                String value = parent.getValue();
                String provenance = parent.getCell().getProvenance();
                value = String.format("%s [%s]", value, provenance);
                excelRow.createCell(2).setCellValue(value);
            }
            excelRow.createCell(3).setCellValue(label.getCategory().getName());
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);

        // Writing the provenance information
        sheet = workbook.createSheet("INFO");
        excelRow = sheet.createRow(0);
        excelCell = excelRow.createCell(0);
        excelCell.setCellValue("LINK TO THE SOURCE TABLE");
        sheet.autoSizeColumn(0);
        excelCell = excelRow.createCell(1);

        String cellRef = table.getSrcStartCellRef();
        String s = String.format("[%s]%s!%s", relativePath, sourceSheetName, cellRef);

        String formula = String.format(template, relativePath, sourceSheetName, cellRef, s);
        excelCell.setCellFormula(formula);

        // Copying the area of the source table from the source workbook to result one
        // Sheet sheetFrom = table.getSourceSheet();
        // CellReference start = new CellReference(table.getSrcStartCellRef());
        // CellReference end = new CellReference(table.getSrcEndCellRef());
        // Sheet sheetTo = workbook.createSheet("SOURCE TABLE");
        // copyArea(sheetFrom, start, end, sheetTo);

        return workbook;
    }

    public EvaluationTableWriter(File outputFile) {
        super(outputFile);
    }

}
