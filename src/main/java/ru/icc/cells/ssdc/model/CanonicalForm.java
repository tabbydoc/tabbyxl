/*
 * Copyright 2015 Alexey O. Shigarov (shigarov@icc.ru)
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

package ru.icc.cells.ssdc.model;

import dnl.utils.text.table.TextTable;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey Shigarov (shigarov@gmail.com) on 09.02.2015.
 */

public final class CanonicalForm
{
    String[] header;

    public void setHeader( String[] header )
    {
        this.header = header;
    }

    public String[] getHeader()
    {
        return header;
    }

    private List<String[]> records = new ArrayList<String[]>();

    public void addRecord( String[] record )
    {
        this.records.add( record );
    }

    public List<String[]> getRecords()
    {
        return records;
    }

    public void print()
    {
        String[] columnNames = header;

        /*
        for ( int i = 0; i < columnNames.length; i++ )
        {
            columnNames[i] = columnNames[i].toUpperCase();
        }
        */

        Object[][] data = null;
        if ( records.size() > 0 )
        {
            data = new Object[records.size()][records.get(0).length];

            for ( int i = 0; i < records.size(); i ++ )
            {
                data[i] = records.get( i );
            }
        }
        TextTable tt = new TextTable( columnNames, data );

        // this adds the numbering on the left
        // tt.setAddRowNumbering(true);
        // sort by the first column
        // tt.setSort(0);

        tt.printTable();
    }

    public String trace()
    {
        StringBuilder sb = new StringBuilder();
        final String EOL = "\r\n";

        for ( String s : header )
        {
            sb.append( s.toUpperCase() ).append( '\t' );
        }

        sb.append( EOL );

        for ( String[] record : records)
        {
            for (String s : record)
            {
                sb.append( s ).append( '\t' );
            }
            sb.append( EOL );
        }

        return sb.toString();
    }

    public void writeToExcel( File outputFile )
    {
        try
        {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();

            Row excelRow = sheet.createRow(0);

            for ( int i = 0; i < header.length; i++ )
            {
                excelRow.createCell( i ).setCellValue( header[i] );
            }

            int i = 1;
            for ( String[] record : records )
            {
                excelRow = sheet.createRow(i);
                for ( int j = 0; j < record.length; j++ )
                {
                    excelRow.createCell(j).setCellValue(record[j]);
                }
                i++;
            }

            FileOutputStream fileOut = new FileOutputStream(outputFile);
            wb.write(fileOut);
            fileOut.close();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
