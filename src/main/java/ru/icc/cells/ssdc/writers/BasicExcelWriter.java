package ru.icc.cells.ssdc.writers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.icc.cells.ssdc.model.CTable;
import ru.icc.cells.ssdc.model.CanonicalForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexey Shigarov on 28.06.2016.
 */
public class BasicExcelWriter extends Writer
{
    protected Workbook writeToWorkbook(CTable table)
    {
        Workbook workbook = new XSSFWorkbook();

        // Writing the canonical form of a table
        CanonicalForm canonicalForm = table.toCanonicalForm();
        String[] header = canonicalForm.getHeader();

        Sheet sheetOfCanonicalForm = workbook.createSheet("CANONICAL TABLE");

        Row excelRow = sheetOfCanonicalForm.createRow(0);

        for ( int i = 0; i < header.length; i++ )
        {
            excelRow.createCell( i ).setCellValue( header[i] );
        }

        List<String[]> records = canonicalForm.getRecords();
        int i = 1;
        for ( String[] record : records )
        {
            excelRow = sheetOfCanonicalForm.createRow(i);
            for ( int j = 0; j < record.length; j++ )
            {
                excelRow.createCell(j).setCellValue(record[j]);
            }
            i++;
        }

        for ( i = 0; i < header.length; i++ )
        {
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

    public BasicExcelWriter(File outputFile) {
        super(outputFile);
    }
}
