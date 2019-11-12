package ru.icc.td.tabbyxl.writers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.CanonicalForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class NerLayerWriter extends Writer {
    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = new XSSFWorkbook();

        //TODO refactoring needed here //CellsDataPreproc nerData;
        // Writing the canonical form of a table
        CanonicalForm canonicalForm = table.toCanonicalForm();
        String[] header = canonicalForm.getHeader();

        Sheet sheetOfCanonicalForm = workbook.createSheet("CANONICAL TABLE");
        Sheet sheetOfNerResult = workbook.createSheet("NER RESULTS");
        Row excelRow = sheetOfCanonicalForm.createRow(0);
        Row excelRowNer = sheetOfNerResult.createRow(0);

        for (int i = 0; i < header.length; i++) {
            excelRow.createCell(i).setCellValue(header[i]);
            excelRowNer.createCell(i).setCellValue(header[i]);
        }

        List<String[]> records = canonicalForm.getRecords();
        int i = 1;
        for (String[] record : records) {
            excelRow = sheetOfCanonicalForm.createRow(i);
            excelRowNer = sheetOfNerResult.createRow(i);
            for (int j = 0; j < record.length; j++) {
                excelRow.createCell(j).setCellValue(record[j]);
                //Ner data get
                //nerData = new CellsDataPreproc(record[j], "|");
                //System.out.println(String.format(record[j]));
                //TODO refactoring needed here excelRowNer.createCell(j).setCellValue(nerData.getNerList(1));
            }
            i++;
        }

        for (i = 0; i < header.length; i++) {
            sheetOfCanonicalForm.autoSizeColumn(i);
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

    public NerLayerWriter(File outputFile) {
        super(outputFile);
    }
}
