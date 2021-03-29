package ru.icc.td.tabbyxl.preprocessing.headrecog;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import static org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER;
import static org.apache.poi.ss.usermodel.HorizontalAlignment.FILL;

public final class WorkbookManager {
    private Workbook workbook;
    private String sheetName = ".";

    public WorkbookManager(Workbook workbook, String sheetName) {
        this.workbook = workbook;
        this.sheetName = sheetName;
    }

    //Merge area
    private String concatCellsValue(String curVal, Cell cell) {
        DataFormatter df = new DataFormatter();
        String cellValue, val = "";
        cellValue = df.formatCellValue(cell).trim();
        val = (curVal.isEmpty()) ?  cellValue : curVal.trim() + " " + cellValue;
        return val;
    }

    public boolean mergeCells(Block blockToMerge, CellPointer cellShift, int cnt) {
        try {
            //If one cell then nothing to merge
            if ((blockToMerge.getLeft() == blockToMerge.getRight()) &&
                    (blockToMerge.getTop() == blockToMerge.getBottom()))
                return true;

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
                cell.setCellValue(val);
                cellStyle = cell.getCellStyle();
                cellStyle.setAlignment(CENTER);
                cellStyle.setWrapText(true);
                if (endCol-startCol > 5)
                    cellStyle.setAlignment(FILL);

                if (cellStyle != null) {
                    //TODO Check the necessity of Borders
                    cell.setCellStyle(cellStyle);

                }
            }
            return true;

        } catch (Exception e) {
            System.out.println(String.format("Cell merge error: %s", e.getMessage()));
            return false;
        }
    }

}
