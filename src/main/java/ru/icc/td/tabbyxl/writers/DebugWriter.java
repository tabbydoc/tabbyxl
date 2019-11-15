package ru.icc.td.tabbyxl.writers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.CValue;
import ru.icc.td.tabbyxl.model.CanonicalForm;
import ru.icc.td.tabbyxl.model.CanonicalForm.Record;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DebugWriter extends BasicExcelWriter {
    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = super.writeToWorkbook(table);

        // Writing the canonical form of a table
        CanonicalForm canonicalForm = table.toCanonicalForm();
        String[] header = canonicalForm.getHeaderStrings();

        Sheet sheet = workbook.createSheet("NER TAG LAYER");
        Row excelRow = sheet.createRow(0);

        for (int i = 0; i < header.length; i++) {
            excelRow.createCell(i).setCellValue(header[i]);
            excelRow.createCell(i).setCellValue(header[i]);
        }

        List<Record> records = canonicalForm.getRecords();

        int i = 1;

        for (Record record : records) {
            excelRow = sheet.createRow(i);

            //String[] recordString = record.getStrings();
            CValue[] values = record.getValues();

            for (int j = 0; j < values.length; j++) {
                CValue value = values[j];
                if (null != value) {
                    CCell cell = value.getCell();
                    String nerTagString = cell.getNerTag().toString();
                    excelRow.createCell(j).setCellValue(nerTagString);
                }
            }
            i++;
        }

        for (i = 0; i < header.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }

        public void write(CTable table) throws IOException
        {
            Workbook workbook = writeToWorkbook(table);
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            workbook.write(fileOut);
            fileOut.close();
        }

    public DebugWriter(File outputFile) {
        super(outputFile);
    }
}
