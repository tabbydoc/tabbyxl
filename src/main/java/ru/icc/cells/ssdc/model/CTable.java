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

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

/**
 * Created by Alexey Shigarov (shigarov@gmail.com) on 30.01.2015.
 */

public final class CTable
{
    private static String DATA_FIELD_NAME = "DATA";
    private static String LABEL_FIELD_NAME = "LABELS";

    private int id;
    private static int numberOfAllTables; // Number of all tables

    public int getId()
    {
        return id;
    }

    private List<CRow> rows = new ArrayList<CRow>();
    private List<CCol> cols = new ArrayList<CCol>();

    // TODO М.б. переделать на Set<CCell>
    private List<CCell> cells = new ArrayList<CCell>();

    public CCell getCell( int index )
    {
        return this.cells.get( index );
    }

    public Iterator<CCell> getCells()
    {
        return this.cells.iterator();
    }

    void removeCell( CCell cell )
    {
        cells.remove( cell );
    }

    void addCell( CCell cell )
    {
        // TODO checking conflicts in cell coordinate intersection
        cells.add( cell );
        /*
        for (int k = cell.getRt() - 1; k < cell.getRb(); k++)
            this.rows.get(k).addCell(cell);

        for (int k = cell.getCl() - 1; k < cell.getCr(); k++)
            this.cols.get(k).addCell(cell);
        */
    }

    boolean containsCell( CCell cell )
    {
        return cells.contains( cell );
    }

    private Set<CLabel> labels = new LinkedHashSet<CLabel>();

    public boolean addLabel( CLabel label )
    {
        return labels.add( label );
    }

    public boolean containsLabel( CLabel label )
    {
        return labels.contains( label );
    }

    public Iterator<CLabel> getLabels()
    {
        return this.labels.iterator();
    }

    private Set<CEntry> entries = new LinkedHashSet<CEntry>();

    public boolean addEntry( CEntry entry )
    {
        return entries.add( entry );
    }

    public Iterator<CEntry> getEntries()
    {
        return this.entries.iterator();
    }

    public boolean containsEntry( CEntry entry )
    {
        return entries.contains( entry );
    }

    public Iterator<CRow> getRows()
    {
        return this.rows.iterator();
    }

    public Iterator<CCol> getCols()
    {
        return this.cols.iterator();
    }

    public CCell newCell()
    {
        CCell cell = new CCell( this );
        addCell( cell );
        return cell;
    }

    private LocalCategoryBox localCategoryBox = new LocalCategoryBox( this );

    public LocalCategoryBox getLocalCategoryBox()
    {
        return localCategoryBox;
    }

    private LabelGroupBox labelGroupBox = new LabelGroupBox( this );

    public LabelGroupBox getLabelGroupBox()
    {
        return labelGroupBox;
    }

    public CTable( int rowNum, int colNum )
    {
        for ( int i = 0; i < rowNum; i ++ )
        {
            rows.add( new CRow( this, i + 1 ) );
        }
        for ( int i = 0; i < colNum; i ++ )
        {
            cols.add( new CCol( this, i + 1 ) );
        }

        numberOfAllTables ++;
        id = numberOfAllTables;
    }

    /*
     * Writing the CTable instance to Excel 2007-2010 (*.xlsx) file
     */
    public void writeToExcel(String outputFile) {
        this.writeToExcel(new File(outputFile));
    }

    /*
     * Writing the CTable instance to Excel 2007-2010 (*.xlsx) file
     */
    public void writeToExcel(File outputFile) {
        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();

            Iterator<CRow> rows = this.rows.iterator();
            int i = 0;
            while (rows.hasNext()) {
                Row excelRow = sheet.createRow(i);
                CRow row = rows.next();

                Iterator<CCell> rcells = row.getCells();
                while (rcells.hasNext()) {
                    CCell cll = rcells.next();
                    excelRow.createCell(cll.getCl() - 1).setCellValue(cll.getRawText());
                }
                i++;
            }

            Iterator<CCell> cells = this.getCells();
            while (cells.hasNext()) {
                CCell c = cells.next();
                if (c.getRt() != c.getRb() || c.getCl() != c.getCr()) {
                    CellRangeAddress rngAdr = new CellRangeAddress(c.getRt() - 1, c.getRb() - 1, c.getCl() - 1, c.getCr() - 1);
                    sheet.addMergedRegion(rngAdr);
                }
            }
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CanonicalForm toCanonicalForm()
    {
        if ( this.cells.size() < 2 ) return null;

        CanonicalForm form = new CanonicalForm();

        int size = getLocalCategoryBox().numOfCategories();
        CCategory[] orderedCategorySet = new CCategory[size];

        int c = 0;
        Iterator<CCategory> categories = getLocalCategoryBox().getCategories();

        while ( categories.hasNext() )
        {
            orderedCategorySet[c]  = categories.next();
            c ++;
        }

        String[] headerRecord = new String[orderedCategorySet.length + 1];
        // TODO getting the data field name (headerRecord[0]) from file settings
        headerRecord[0] = DATA_FIELD_NAME;

        for ( int i = 0; i < orderedCategorySet.length; i ++ )
        {
            headerRecord[i + 1] = orderedCategorySet[i].getName();
        }

        form.setHeader( headerRecord );
        String padding = "";

        for ( CEntry entry : entries )
        {
            String[] entryRecord = new String[size + 1];
            Arrays.fill( entryRecord, padding );
            entryRecord[0] = entry.getValue();
            Iterator<CLabel> labels = entry.getLabels();

            while ( labels.hasNext() )
            {
                CLabel label = labels.next();

                for ( int i = 0; i < orderedCategorySet.length; i ++ )
                {
                    CCategory category = orderedCategorySet[i];
                    if ( label.getCategory().equals( category ) )
                    {
                        entryRecord[i + 1] = label.getCompoundValue();//label.getValue();
                    }
                }
            }
            form.addRecord(entryRecord);
        }
        return form;
    }

    public String trace()
    {
        final StringBuilder sb = new StringBuilder();
        final String eol = "\r\n";
        final String tab = "\t";

        sb.append( "Entries:" ).append( eol );
        for ( CEntry entry : entries )
        {
            sb.append( tab ).append( entry.trace() ).append(eol);
        }

        sb.append( "Labels:" ).append( eol );
        for ( CLabel label : labels )
        {
            sb.append( tab ).append( label.trace() ).append( eol );
        }

        sb.append(getLabelGroupBox().trace() ).append( eol );

        sb.append( "Categories:" ).append( eol );
        Iterator<CCategory> categories = getLocalCategoryBox().getCategories();

        while ( categories.hasNext() )
        {
            sb.append( tab ).append( categories.next().trace() ).append( eol );
        }

        return sb.toString();
    }

    public int numOfRows()
    {
        return rows.size();
    }

    public int numOfCols()
    {
        return cols.size();
    }

    public int numOfCells()
    {
        return cells.size();
    }

    public int numOfNotEmptyCells()
    {
        int count = 0;
        for ( CCell cell : cells )
        {
            if ( null == cell.getText() )
                continue;
            if ( ! cell.getText().isEmpty() )
                count++;
        }
        return count;
    }

    public int numOfEntries()
    {
        return entries.size();
    }

    public int numOfLabels()
    {
        return labels.size();
    }

    public int numOfCategories()
    {
        return getLocalCategoryBox().numOfCategories();
    }

    public int numOfLabelGroups()
    {
        return getLabelGroupBox().numOfLabelGroups();
    }

    public int numOfLL()
    {
        int count = 0;
        for ( CLabel label : labels )
        {
            if ( label.hasParent() )
                count++;
        }
        return count;
    }

    public int numOfEL()
    {
        int count = 0;
        for ( CEntry entry: entries )
        {
                count += entry.numOfLabels();
        }
        return count;
    }

    public int numOfCL()
    {
        int count = 0;
        for ( CLabel label : labels )
        {
            if ( label.hasCategory() )
                count++;
        }
        return count;
    }

    // TODO changing exception is needed
    public void update() throws Exception
    {
        labelGroupBox.update();
        setDefaultCategory();
    }

    // TODO changing exception is needed
    private void setDefaultCategory() throws Exception
    {
        final List<CLabel> uncategorizedLabels = new ArrayList<CLabel>();

        for ( CLabel label : labels )
        {
            if ( null == label.getCategory() )
            {
                uncategorizedLabels.add( label );
            }
        }

        if ( uncategorizedLabels.size() > 0 )
        {
            // TODO reading the default category name from settings
            final CCategory category = localCategoryBox.newCategory( LABEL_FIELD_NAME );

            for ( CLabel label : uncategorizedLabels )
            {
                label.setCategory(category);
            }
        }
    }

    private File srcWorkbookFile;

    public File getSrcWorkbookFile() {
        return srcWorkbookFile;
    }

    public void setSrcWorkbookFile(File srcWorkbookFile) {
        this.srcWorkbookFile = srcWorkbookFile;
    }

    private String srcSheetName;

    public String getSrcSheetName() {
        return srcSheetName;
    }

    public void setSrcSheetName(String srcSheetName) {
        this.srcSheetName = srcSheetName;
    }

    private String srcStartCellRef;

    public String getSrcStartCellRef() {
        return srcStartCellRef;
    }

    public void setSrcStartCellRef(String srcStartCellRef) {
        this.srcStartCellRef = srcStartCellRef;
    }

    private String srcEndCellRef;

    public String getSrcEndCellRef() {
        return srcEndCellRef;
    }

    public void setSrcEndCellRef(String srcEndCellRef) {
        this.srcEndCellRef = srcEndCellRef;
    }
}