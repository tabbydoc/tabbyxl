package ru.icc.td.tabbyxl.preprocessing.headrecog;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER;
import static org.apache.poi.ss.usermodel.HorizontalAlignment.FILL;

public final class WorkbookManager {
    private String pathToSave;
    private Workbook workbook;
    private String sheetName = ".";

    public WorkbookManager(Workbook workbook, String sheetName, String pathToSave) {
        this.workbook = workbook;
        this.sheetName = sheetName;
        this.pathToSave = pathToSave;
    }

    //Merge area
    private String concatCellsValue(String curVal, Cell cell) {
        DataFormatter df = new DataFormatter();
        String cellValue, val = "";
        cellValue = df.formatCellValue(cell).trim();
        val = (curVal.isEmpty()) ?  cellValue : curVal.trim() + " " + cellValue;
        //cell.setCellType(CELL_TYPE_STRING);
        return val;
    }

    public boolean mergeCells(Block blockToMerge, CellPoint cellShift, int cnt) {
        try {
            //If one cell then nothing to merge
            if ((blockToMerge.getLeft() == blockToMerge.getRight()) &&
                    (blockToMerge.getTop() == blockToMerge.getBottom()))
                return true;

            DataFormat fmt = workbook.createDataFormat();
            BorderStyle borderTop = BorderStyle.NONE;
            BorderStyle borderLeft = BorderStyle.NONE;
            BorderStyle borderBottom = BorderStyle.NONE;
            BorderStyle borderRight = BorderStyle.NONE;
            Sheet sheet = workbook.getSheet(sheetName);

            int startCol = blockToMerge.getLeft() + cellShift.c - 1;
            int endCol = blockToMerge.getRight() + cellShift.c - 1;
            int startCell = blockToMerge.getTop() + cellShift.r - 1;
            int endCell = blockToMerge.getBottom() + cellShift.r - 1;
            CellRangeAddress reg;
            boolean isMerge;
            String val ="";
            Cell cell;
            Row row;
            CellStyle cellStyle;
            /*
            borderTop = getBorderTop(sheet, startCol, startCell);
            borderBottom = getborderBottom(sheet, startCol, endCell);
            borderLeft = getBorderLeft(sheet, startCol, startCell);
            borderRight = getBorderRight(sheet, endCol, startCell);
             */

            for (int r = startCell; r <= endCell; r++)
                for (int c = startCol; c <= endCol; c++) {
                    row = sheet.getRow(r);
                    cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    val = concatCellsValue(val, cell);
                    cell.setCellValue("");
                    cell.setBlank();

                }

            do {
                isMerge = false;
                //val = "";
                for (int r = 0; r < sheet.getNumMergedRegions(); r++) {
                    reg = sheet.getMergedRegion(r);
                    if ((reg.getFirstRow() >= startCell) && (reg.getFirstColumn() >= startCol) &&
                            (reg.getLastRow() <= endCell) && (reg.getLastColumn() <= endCol)) {
                        isMerge = true; //There is a merge region in the area
                        sheet.removeMergedRegion(r);
                    }
                }
            }while (isMerge != false);
            CellRangeAddress cellAddresses = new CellRangeAddress(startCell,  endCell, startCol, endCol);
            int mergedRegion = sheet.addMergedRegion(cellAddresses);
            if (mergedRegion >= 0) {
                //Set value to new merged cell
                row = sheet.getRow(startCell);
                cell = row.getCell(startCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                //cell.setCellType(STRING); //Depricated method
                cell.setCellValue(val);
                cellStyle = cell.getCellStyle();
                cellStyle.setAlignment(CENTER);
                cellStyle.setWrapText(true);
                if (endCol-startCol > 5)
                    cellStyle.setAlignment(FILL);

                if (cellStyle != null) {
                    //TODO Check the necessity of Borders
                    //cellStyle.setBorderTop(borderTop);
                    //cellStyle.setBorderBottom(borderBottom);
                    //cellStyle.setBorderLeft(borderLeft);
                    //cellStyle.setBorderRight(borderRight);
                    //cellStyle.setDataFormat(
                    //        fmt.getFormat("@"));
                    cell.setCellStyle(cellStyle);

                }
            }
            return true;

        } catch (Exception e) {
            System.out.println(String.format("Cell merge error: %s", e.getMessage()));
            return false;
        }
    }

    /*
    public void saveWorkbook() throws IOException {
        saveWorkbook(null);
    }

    public void saveWorkbook(String pathToSave) throws IOException {
        if (pathToSave == null) pathToSave = this.pathToSave;

        try (FileOutputStream out = new FileOutputStream(new File(pathToSave))) {
            workbook.write(out);
            System.out.println("Changes were written successfully on disk");
        }
    }
    */

    private BorderStyle getBorderTop(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
        return cell.getCellStyle().getBorderTop();
    }

    private  BorderStyle getBorderBottom(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c , Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        return cell.getCellStyle().getBorderBottom();
    }

    private BorderStyle getBorderLeft(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
        return cell.getCellStyle().getBorderLeft();
    }

    private BorderStyle getBorderRight(Sheet sheet, int c, int r){
        Cell cell;
        Row row;
        row = sheet.getRow( r );
        cell = row.getCell( c , Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        return cell.getCellStyle().getBorderRight();
    }


}
