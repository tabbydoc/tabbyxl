package ru.icc.td.tabbyxl.preprocessing.headrecog;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;


public final class WorkbookManage {
    private String pathToSave;
    private Workbook workbook;
    private String sheetName =".";

    public WorkbookManage(Workbook workbook, String sheetName, String pathToSave){
        this.workbook = workbook;
        this.sheetName = sheetName;
        this.pathToSave = pathToSave;
    }
    //Merge area
    private String concatCellsValue(String curVal, Cell cell){
        DataFormatter df = new DataFormatter();
        String cellValue, val = "";
        cellValue = df.formatCellValue(cell).trim();
        val = (curVal.isEmpty()) ?  cellValue : curVal.trim() + " " + cellValue;
        cell.setCellType(CELL_TYPE_STRING);
        return val;
    }

    public boolean mergeCells(Block blockToMerge, CellPoint cellShift, int cnt){
        try {
            DataFormat fmt = workbook.createDataFormat();
            short borderTop = 0, borderLeft = 0, borderBottom = 0, borderRight = 0;
            Sheet sheet = workbook.getSheet(sheetName);
            int startCol = blockToMerge.getLeft() + cellShift.c - 1;
            int endCol = blockToMerge.getRight() + cellShift.c - 1;
            int startCell = blockToMerge.getTop() + cellShift.r - 1;
            int endCell = blockToMerge.getBottom() + cellShift.r - 1;
            CellRangeAddress reg;
            boolean isMerge;
            String val = "";
            Cell cell;
            Row row;
            CellStyle cellStyle;


            borderTop = getBorderTop(sheet, startCol, startCell);
            borderBottom = getborderBottom(sheet, startCol, endCell);
            borderLeft = getBorderLeft(sheet, startCol, startCell);
            borderRight = getBorderRight(sheet, endCol, startCell);

            for (int r = startCell; r <= endCell; r ++)
                for (int c = startCol; c <= endCol; c ++){
                    row = sheet.getRow(r);
                    cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);
                    val = concatCellsValue(val, cell);
                    cell.setCellValue("");
                    cell.setCellType(CELL_TYPE_BLANK);
                }

            do {
                isMerge = false;
                //val = "";
                for (int r = 0; r < sheet.getNumMergedRegions(); r ++){
                    reg = sheet.getMergedRegion(r);
                    if ((reg.getFirstRow() >= startCell ) && (reg.getFirstColumn() >= startCol) &&
                            (reg.getLastRow() <= endCell ) && (reg.getLastColumn() <= endCol) ){
                        isMerge = true; //There is a merge region in the area
                        sheet.removeMergedRegion(r);
                    }
                }
            }while (isMerge != false);

            int mergedRegion = sheet.addMergedRegion(new CellRangeAddress(startCell,  endCell, startCol, endCol));
            if (mergedRegion > 0) {
                //Set value to new merged cell
                row = sheet.getRow(startCell);
                cell = row.getCell(startCol, Row.CREATE_NULL_AS_BLANK);
                cell.setCellType(CELL_TYPE_STRING);
                cell.setCellValue(val);
                cellStyle = cell.getCellStyle();
                cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

                if (cellStyle != null) {
                    //TODO Check the nessesity of Borders
                    //cellStyle.setBorderTop(borderTop);
                    //cellStyle.setBorderBottom(borderBottom);
                    //cellStyle.setBorderLeft(borderLeft);
                    //cellStyle.setBorderRight(borderRight);
                    cellStyle.setDataFormat(
                            fmt.getFormat("@"));
                    cell.setCellStyle(cellStyle);

                }



            }

            return true;


        }
        catch (Exception e){
            System.out.println(String.format("Cell merge error: %s", e.getMessage()));
            return false;
        }

    }

    public void saveWorkbook() throws IOException {
        saveWorkbook(null);
    }
    public void saveWorkbook(String pathToSave) throws IOException {
        if (pathToSave == null) pathToSave = this.pathToSave;

        try (FileOutputStream out = new FileOutputStream(new File(pathToSave))) {
            workbook.write(out);
            System.out.println("test.xlsx written successfully on disk.");
            out.close();
        }


    }


    private short getBorderTop(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c, Row.CREATE_NULL_AS_BLANK );
        return cell.getCellStyle().getBorderTop();
    }

    private  short getborderBottom(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c , Row.CREATE_NULL_AS_BLANK);
        return cell.getCellStyle().getBorderBottom();
    }

    private short getBorderLeft(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c, Row.CREATE_NULL_AS_BLANK );
        return cell.getCellStyle().getBorderLeft();
    }

    private short getBorderRight(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c , Row.CREATE_NULL_AS_BLANK);
        return cell.getCellStyle().getBorderRight();
    }


}
