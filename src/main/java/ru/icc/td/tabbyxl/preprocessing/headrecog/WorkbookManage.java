package ru.icc.cells.identHead;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import ru.icc.cells.ssdc.model.CCell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

public final class WorkbookManage {
    private String pathToSave;
    private Workbook workbook;
    private String sheetName =".";

    public WorkbookManage(Workbook workbook, String sheetName){
        this.workbook = workbook;
        this.sheetName = sheetName;
    }
    //Merge area
    public boolean mergeCells(Block blockToMerge, CellPoint cellShift, int cnt){
        try {
            short borderTop = 0, borderLeft = 0, borderBottom = 0, borderRight = 0;
            Sheet sheet = workbook.getSheet(sheetName);

            int startCol = blockToMerge.getLeft() + cellShift.c - 1;
            int endCol = blockToMerge.getRight() + cellShift.c - 1;
            int startCell = blockToMerge.getTop() + cellShift.r - 1;
            int endCell = blockToMerge.getBottom() + cellShift.r - 1;
            CellRangeAddress reg;
            boolean isMerge = false;
            String val = "";
            Cell cell;
            Row row;
            CellStyle cellStyle = null;
            borderTop = getBorderTop(sheet, startCol, startCell);
            borderBottom = getborderBottom(sheet, startCol, endCell);
            borderLeft = getBorderLeft(sheet, startCol, startCell);
            borderRight = getBorderRight(sheet, endCol, startCell);

            do {
                isMerge = false;
                val = "";
                for (int r = 0; r < sheet.getNumMergedRegions(); r ++){
                    reg = sheet.getMergedRegion(r);
                    if ((reg.getFirstRow() >= startCell ) && (reg.getFirstColumn() >= startCol) &&
                            (reg.getLastRow() <= endCell ) && (reg.getLastColumn() <= endCol) ){
                        isMerge = true; //There is a merge region in the area
                        row = sheet.getRow(reg.getFirstRow());
                        cell = row.getCell(reg.getFirstColumn());
                        if (! cell.getStringCellValue().equals(""))
                            val = (val.isEmpty()) ?  cell.getStringCellValue() : val + " \n" + cell.getStringCellValue();
                        //cellStyle = cell.getCellStyle();
                        sheet.removeMergedRegion(r);
                    }
                }

            }while (isMerge != false);

            if (! isMerge){
                for (int r = startCell; r <= endCell; r ++)
                    for (int c = startCol; c <= endCol; c ++){
                        row = sheet.getRow(r);
                        cell = row.getCell(c);

                        if ((! cell.getStringCellValue().equals("")) && (!cell.getStringCellValue().trim().equals(val))) {
                            cell.setCellType(CELL_TYPE_STRING);
                            val = (val.isEmpty()) ? cell.getStringCellValue().trim() : val + " \n" + cell.getStringCellValue().trim();
                            //cellStyle = cell.getCellStyle();
                        }
                    }
            }


            row = sheet.getRow(startCell);
            cell = row.getCell(startCol);
            cell.setCellValue(val.trim());

            if (cellStyle != null) {
            cellStyle.setBorderTop(borderTop);
            cellStyle.setBorderBottom(borderBottom);
            cellStyle.setBorderLeft(borderLeft);
            cellStyle.setBorderRight(borderRight);
            cell.setCellStyle(cellStyle);
            }

            sheet.addMergedRegion(new CellRangeAddress(startCell,  endCell, startCol, endCol));


            //----Code for test only----
            /*
            if (cnt == 2){
                saveWorkbook(String.format("E:\\devel\\cells\\identHead\\testData\\test%s.xlsx", cnt));
                System.out.print("1111");
                System.exit(0);
            }
            */
            //---End of code for test-----

            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    public void saveWorkbook() throws IOException {
        saveWorkbook(null);
    }
    public void saveWorkbook(String pathToSave) throws IOException {
        if (pathToSave == null) pathToSave = this.pathToSave;

        FileOutputStream out = new FileOutputStream(new File(pathToSave));
        workbook.write(out);
        System.out.println("test.xlsx written successfully on disk.");
        out.close();


    }


    private short getBorderTop(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c );
        return cell.getCellStyle().getBorderTop();
    }

    private  short getborderBottom(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c );
        return cell.getCellStyle().getBorderBottom();
    }

    private short getBorderLeft(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c );
        return cell.getCellStyle().getBorderLeft();
    }

    private short getBorderRight(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c );
        return cell.getCellStyle().getBorderRight();
    }


}
