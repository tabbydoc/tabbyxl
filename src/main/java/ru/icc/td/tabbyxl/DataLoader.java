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

package ru.icc.td.tabbyxl;

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.TypeTag;
import ru.icc.td.tabbyxl.model.style.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public final class DataLoader {
    private File sourceWorkbookFile;
    private Workbook workbook;
    private Sheet sheet;
    private String sheetName;
    private int rowIndex;
    private int cellCount;

    private static final String REF_POINT_VAL = "$START";
    private static final String END_POINT_VAL = "$END";

    private boolean withoutSuperscript;

    public boolean isWithoutSuperscript() {
        return withoutSuperscript;
    }

    public void setWithoutSuperscript(boolean withoutSuperscript) {
        this.withoutSuperscript = withoutSuperscript;
    }

    private boolean useCellValue;

    public boolean isUseCellValue() {
        return useCellValue;
    }

    public void setUseCellValue(boolean useCellValue) {
        this.useCellValue = useCellValue;
    }

    public void loadWorkbook(File excelFile) throws IOException {
        FileInputStream fin = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(fin);
        formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
        sourceWorkbookFile = excelFile;
    }

    private void reset() {
        rowIndex = 0;
    }

    public int numOfSheets() {
        if (null == workbook)
            throw new IllegalStateException("The workbook is not loaded");
        return workbook.getNumberOfSheets();
    }

    public void goToSheet(int index) {
        if (null == workbook)
            throw new IllegalStateException("The workbook is not loaded");
        sheet = workbook.getSheetAt(index);
        sheetName = sheet.getSheetName();
        reset();
    }

    public String getCurrentSheetName() {
        return sheetName;
    }

    public CTable nextTable() {
        if (null == sheet)
            throw new IllegalStateException("The sheet is not initialized");

        CPoint refPnt = findRefPoint(sheet, rowIndex);
        if (null == refPnt) return null;

        CPoint endPnt = findEndPoint(sheet, refPnt.r);
        if (null == endPnt) return null;

        int numOfCols = endPnt.c - refPnt.c + 1;
        int numOfRows = endPnt.r - refPnt.r + 1;
        CTable table = new CTable(numOfRows, numOfCols);

        //CCell cell;
        Cell excelCell;
        Row row = null;
        CellRangeAddress cellRangeAddress = null;
        boolean isCell = false;

        int refRowAdr = refPnt.r;
        int endRowAdr = endPnt.r;
        int refColAdr = refPnt.c;
        int endColAdr = endPnt.c;

        for (int i = refRowAdr; i <= endRowAdr; i++) {
            row = sheet.getRow(i);

            // TODO: Check the case when <code> row == null </code>
            if (null == row)
                continue;

            for (int j = refColAdr; j <= endColAdr; j++) {
                // TODO: Check the case when <code> excelCell == null </code>
                excelCell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);

                int colAdr = excelCell.getColumnIndex() - refColAdr + 1;
                int rowAdr = excelCell.getRowIndex() - refRowAdr + 1;

                int cl = colAdr;
                int cr = colAdr;
                int rt = rowAdr;
                int rb = rowAdr;

                isCell = true;

                for (int k = 0; k < sheet.getNumMergedRegions(); k++) {
                    cellRangeAddress = sheet.getMergedRegion(k);
                    if (cellRangeAddress.getFirstColumn() == excelCell.getColumnIndex()
                            && cellRangeAddress.getFirstRow() == excelCell.getRowIndex()) {
                        cr = cellRangeAddress.getLastColumn() - refColAdr + 1;
                        rb = cellRangeAddress.getLastRow() - refRowAdr + 1;
                        break;
                    }

                    if (cellRangeAddress.getFirstColumn() <= excelCell.getColumnIndex()
                            && excelCell.getColumnIndex() <= cellRangeAddress.getLastColumn()
                            && cellRangeAddress.getFirstRow() <= excelCell.getRowIndex()
                            && excelCell.getRowIndex() <= cellRangeAddress.getLastRow()) {
                        isCell = false;
                    }
                }
                if (isCell) {
                    CCell cell = table.newCell();

                    cell.setCl(cl);
                    cell.setRt(rt);
                    cell.setCr(cr);
                    cell.setRb(rb);

                    fillCell(cell, excelCell);
                }
            }
        }

        this.rowIndex = endPnt.r + 1;

        table.setSrcWorkbookFile(sourceWorkbookFile);
        table.setSrcSheetName(sheet.getSheetName());

        CellReference cellRef;
        cellRef = new CellReference(refPnt.r, refPnt.c);
        table.setSrcStartCellRef(cellRef.formatAsString());
        cellRef = new CellReference(endPnt.r, endPnt.c);
        table.setSrcEndCellRef(cellRef.formatAsString());

        recoverCellBorders(table);

        return table;
    }

    private CPoint findPreviousPoint(Sheet sheet, String tag, int startRow) {
        for (int i = startRow; i > -1; i--) {
            Row row = sheet.getRow(i);
            if (null == row) continue;

            for (Cell cell : row) {
                String text = getFormatCellValue(cell);
                if (tag.equals(text))
                    return new CPoint(cell.getColumnIndex(), cell.getRowIndex());
            }
        }
        return null;
    }

    private CPoint findNextPoint(Sheet sheet, String tag, int startRow) {
        for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (null == row) continue;

            for (Cell cell : row) {
                String text = getFormatCellValue(cell);
                if (tag.equals(text))
                    return new CPoint(cell.getColumnIndex(), cell.getRowIndex());
            }
        }
        return null;
    }

    private String getFormatCellValue(Cell excelCell) {
        try {
            formulaEvaluator.evaluate(excelCell);
            return formatter.formatCellValue(excelCell, formulaEvaluator);
        } catch (FormulaParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private CPoint findRefPoint(Sheet sheet, int startRow) {
        CPoint point = this.findNextPoint(sheet, REF_POINT_VAL, startRow);

        if (null != point) {
            point.c = point.c + 1;
            point.r = point.r + 1;
        }

        return point;
    }

    private CPoint findEndPoint(Sheet sheet, int startRow) {
        CPoint point = this.findNextPoint(sheet, END_POINT_VAL, startRow);

        if (null != point) {
            point.c = point.c - 1;
            point.r = point.r - 1;
        }

        return point;
    }

    private String extractCellFormulaValue(Cell excelCell) {
        String value = null;

        switch (excelCell.getCachedFormulaResultType()) {
            case Cell.CELL_TYPE_NUMERIC:
                value = Double.toString(excelCell.getNumericCellValue());
                break;

            case Cell.CELL_TYPE_STRING:
                value = excelCell.getStringCellValue();
                break;

            case Cell.CELL_TYPE_BOOLEAN:
                value = Boolean.toString(excelCell.getBooleanCellValue());
                break;
        }

        return value;
    }

    private String extractCellValue(Cell excelCell) {
        String value = null;

        switch (excelCell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(excelCell))
                    value = "DATE"; // TODO: Check this magic value
                else
                    value = Double.toString(excelCell.getNumericCellValue());
                break;

            case Cell.CELL_TYPE_STRING:
                value = excelCell.getRichStringCellValue().getString();
                break;

            case Cell.CELL_TYPE_BOOLEAN:
                value = Boolean.toString(excelCell.getBooleanCellValue());
                break;

            case Cell.CELL_TYPE_FORMULA:
                //value = excelCell.getCellFormula();
                value = extractCellFormulaValue(excelCell);
                break;

            case Cell.CELL_TYPE_BLANK:
                break;

            case Cell.CELL_TYPE_ERROR:
                break;
        }
        return value;
    }

    private DataFormatter formatter = new DataFormatter();
    private FormulaEvaluator formulaEvaluator;

    private boolean hasSuperscriptText(Cell excelCell) {
        if (excelCell.getCellType() != Cell.CELL_TYPE_STRING) return false;

        RichTextString richTextString = excelCell.getRichStringCellValue();
        if (null == richTextString) return false;

        XSSFRichTextString rts = (XSSFRichTextString) richTextString;
        XSSFWorkbook wb = (XSSFWorkbook) workbook;

        XSSFCellStyle style = ((XSSFCell) excelCell).getCellStyle();
        XSSFFont font = style.getFont();

        if (rts.numFormattingRuns() > 1) {
            for (int i = 0; i < rts.numFormattingRuns(); i++) {
                try {
                    font = rts.getFontOfFormattingRun(i);
                } catch (NullPointerException e) {
                    font = wb.getFontAt(XSSFFont.DEFAULT_CHARSET);
                    font.setTypeOffset(XSSFFont.SS_NONE);
                }

                if (font != null && font.getTypeOffset() == XSSFFont.SS_SUPER)
                    return true;
            }
        } else {
            if (font != null && font.getTypeOffset() == XSSFFont.SS_SUPER)
                return true;
        }
        return false;
    }

    private String getNotSuperscriptText(Cell excelCell) {
        if (excelCell.getCellType() != Cell.CELL_TYPE_STRING) return null;
        RichTextString richTextString = excelCell.getRichStringCellValue();
        if (null == richTextString) return null;

        int index;
        int length;
        String text;

        XSSFRichTextString rts = (XSSFRichTextString) richTextString;
        XSSFWorkbook wb = (XSSFWorkbook) workbook;

        XSSFCellStyle style = ((XSSFCell) excelCell).getCellStyle();
        XSSFFont font = style.getFont();

        String richText = rts.getString();
        StringBuilder notSuperscriptRuns = new StringBuilder();
        if (rts.numFormattingRuns() > 1) {
            boolean wasNotSuperscriptRun = false;
            for (int i = 0; i < rts.numFormattingRuns(); i++) {
                index = rts.getIndexOfFormattingRun(i);
                length = rts.getLengthOfFormattingRun(i);

                try {
                    font = rts.getFontOfFormattingRun(i);
                } catch (NullPointerException e) {
                    font = wb.getFontAt(XSSFFont.DEFAULT_CHARSET);
                    font.setTypeOffset(XSSFFont.SS_NONE);
                }

                String s = richText.substring(index, index + length);

                if (font != null && font.getTypeOffset() == XSSFFont.SS_SUPER) {
                    if (wasNotSuperscriptRun) notSuperscriptRuns.append(" ");
                    wasNotSuperscriptRun = false;
                } else {
                    notSuperscriptRuns.append(s);
                    wasNotSuperscriptRun = true;
                }
            }
            text = notSuperscriptRuns.toString();
        } else {
            if (font == null || font.getTypeOffset() == XSSFFont.SS_SUPER)
                text = null;
            else
                text = richText;
        }
        return text;
    }

    private String getText(Cell excelCell) {
        String text = null;
        if (useCellValue)
            text = extractCellValue(excelCell);
        else
            text = getFormatCellValue(excelCell);
        return text;
    }

    private void fillCell(CCell cell, Cell excelCell) {
        String rawTextualContent = null;
        TypeTag typeTag = null;

        String text = null;
        if (withoutSuperscript) {
            if (hasSuperscriptText(excelCell)) {
                text = getNotSuperscriptText(excelCell);
            } else {
                text = getText(excelCell);
            }
        } else {
            text = getText(excelCell);
        }
        cell.setText(text);

        rawTextualContent = getFormatCellValue(excelCell);
        cell.setRawText(rawTextualContent);

        switch (excelCell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(excelCell)) {
                    typeTag = TypeTag.DATE;
                } else {
                    typeTag = TypeTag.NUMERIC;
                }
                break;

            case Cell.CELL_TYPE_STRING:
                typeTag = TypeTag.STRING;
                break;

            case Cell.CELL_TYPE_BOOLEAN:
                typeTag = TypeTag.BOOLEAN;
                break;

            case Cell.CELL_TYPE_FORMULA:
                typeTag = TypeTag.FORMULA;
                break;

            case Cell.CELL_TYPE_BLANK:
                typeTag = TypeTag.BLANK;
                break;

            case Cell.CELL_TYPE_ERROR:
                typeTag = TypeTag.ERROR;
                break;
        }

        cell.setId(this.cellCount);

        cell.setTypeTag(typeTag);

        int height = excelCell.getRow().getHeight();
        cell.setHeight(height);

        int width = excelCell.getSheet().getColumnWidth(excelCell.getColumnIndex());
        cell.setWidth(width);

        CellStyle excelCellStyle = excelCell.getCellStyle();
        CStyle cellStyle = cell.getStyle();
        //System.out.printf("cell = %s%n", cell.getText());
        fillCellStyle(cellStyle, excelCellStyle);

        String reference = new CellReference(excelCell).formatAsString();
        cell.setProvenance(reference);

        this.cellCount++;
    }

    private void fillCellStyle(CStyle cellStyle, CellStyle excelCellStyle) {
        Font excelFont = workbook.getFontAt(excelCellStyle.getFontIndex());
        // TODO: Change this to <code> CFont newFont(excelFont) </code>
        //CFont font = new CFont();
        //cellStyle.setFont( font );
        CFont font = cellStyle.getFont();

        fillFont(font, excelFont);

        cellStyle.setHidden(excelCellStyle.getHidden());
        cellStyle.setLocked(excelCellStyle.getLocked());
        cellStyle.setWrapped(excelCellStyle.getWrapText());

        cellStyle.setIndention(excelCellStyle.getIndention());
        cellStyle.setRotation(excelCellStyle.getRotation());

        cellStyle.setHorzAlignment(this.getHorzAlignment(excelCellStyle.getAlignment()));
        cellStyle.setVertAlignment(this.getVertAlignment(excelCellStyle.getVerticalAlignment()));

        CBorder leftBorder = cellStyle.getLeftBorder();
        CBorder rightBorder = cellStyle.getRightBorder();
        CBorder topBorder = cellStyle.getTopBorder();
        CBorder bottomBorder = cellStyle.getBottomBorder();

        BorderType lbType = this.convertBorderType(excelCellStyle.getBorderLeft());
        BorderType rbType = this.convertBorderType(excelCellStyle.getBorderRight());
        BorderType tbType = this.convertBorderType(excelCellStyle.getBorderTop());
        BorderType bbType = this.convertBorderType(excelCellStyle.getBorderBottom());

        leftBorder.setType(lbType);
        rightBorder.setType(rbType);
        topBorder.setType(tbType);
        bottomBorder.setType(bbType);

        // This color "Fill Background Color" is used when the cell has a background pattern.
        // Otherwise "Fill Foreground Color" is used when the cell does not have a background pattern.
        XSSFColor bgColor = (XSSFColor) excelCellStyle.getFillBackgroundColorColor();

        // When the index of a color is 64, then it means that this color is null
        if (null != bgColor && 64 != bgColor.getIndexed()) {
            String color = bgColor.getARGBHex();
            if (null != color) {
                color = color.substring(2);
                cellStyle.setBgColor(new CColor(color));
            }
        }

        // This color "Fill Background Color" is either the color of the cell pattern, or the cell background
        XSSFColor fgColor = (XSSFColor) excelCellStyle.getFillForegroundColorColor();

        if (null != fgColor && 64 != fgColor.getIndexed()) {
            String color = fgColor.getARGBHex();
            if (null != color) {
                color = color.substring(2);
                cellStyle.setFgColor(new CColor(color));
            }
        }

        // TODO: Set border colors
    }

    private CColor convertBorderColor(short originalExcelBorderColor) {
        // TODO: Find a border color
        return new CColor("#000000");
    }

    private BorderType convertBorderType(short originalExcelBorderType) {
        if (originalExcelBorderType < 0 || originalExcelBorderType > 13)
            return null;

        switch (originalExcelBorderType) {
            case CellStyle.BORDER_NONE:
                return BorderType.NONE;
            case CellStyle.BORDER_THIN:
                return BorderType.THIN;
            case CellStyle.BORDER_MEDIUM:
                return BorderType.MEDIUM;
            case CellStyle.BORDER_DASHED:
                return BorderType.DASHED;
            case CellStyle.BORDER_HAIR:
                return BorderType.HAIR;
            case CellStyle.BORDER_THICK:
                return BorderType.THICK;
            case CellStyle.BORDER_DOUBLE:
                return BorderType.DOUBLE;
            case CellStyle.BORDER_DOTTED:
                return BorderType.DOTTED;
            case CellStyle.BORDER_MEDIUM_DASHED:
                return BorderType.MEDIUM_DASHED;
            case CellStyle.BORDER_DASH_DOT:
                return BorderType.DASH_DOT;
            case CellStyle.BORDER_MEDIUM_DASH_DOT:
                return BorderType.MEDIUM_DASH_DOT;
            case CellStyle.BORDER_DASH_DOT_DOT:
                return BorderType.DASH_DOT_DOT;
            case CellStyle.BORDER_MEDIUM_DASH_DOT_DOT:
                return BorderType.MEDIUM_DASH_DOT_DOT;
            case CellStyle.BORDER_SLANTED_DASH_DOT:
                return BorderType.SLANTED_DASH_DOT;
            default:
                return null;
        }
    }

    private HorzAlignment getHorzAlignment(short originalExcelHorzAlignment) {
        if (originalExcelHorzAlignment < 0 || originalExcelHorzAlignment > 6)
            return null;

        switch (originalExcelHorzAlignment) {
            case CellStyle.ALIGN_GENERAL:
                return HorzAlignment.GENERAL;
            case CellStyle.ALIGN_LEFT:
                return HorzAlignment.LEFT;
            case CellStyle.ALIGN_CENTER:
                return HorzAlignment.CENTER;
            case CellStyle.ALIGN_RIGHT:
                return HorzAlignment.RIGHT;
            case CellStyle.ALIGN_FILL:
                return HorzAlignment.FILL;
            case CellStyle.ALIGN_JUSTIFY:
                return HorzAlignment.JUSTIFY;
            case CellStyle.ALIGN_CENTER_SELECTION:
                return HorzAlignment.CENTER_SELECTION;
            default:
                return null;
        }
    }

    private VertAlignment getVertAlignment(short originalExcelVertAlignment) {
        if (originalExcelVertAlignment < 0 || originalExcelVertAlignment > 3)
            return null;

        switch (originalExcelVertAlignment) {
            case CellStyle.VERTICAL_TOP:
                return VertAlignment.TOP;
            case CellStyle.VERTICAL_CENTER:
                return VertAlignment.CENTER;
            case CellStyle.VERTICAL_BOTTOM:
                return VertAlignment.BOTTOM;
            case CellStyle.VERTICAL_JUSTIFY:
                return VertAlignment.JUSTIFY;
            default:
                return null;
        }
    }

    private void fillFont(CFont font, Font excelFont) {
        font.setName(excelFont.getFontName());

        // TODO: Set a font color <code> CFont font </code>
        //font.setColor( excelFont.getColor() );

        font.setHeight(excelFont.getFontHeight());
        font.setHeightInPoints(excelFont.getFontHeightInPoints());

        short boldWeight = excelFont.getBoldweight();
        if (boldWeight >= 700)
            font.setBold(true);

        font.setItalic(excelFont.getItalic());
        font.setStrikeout(excelFont.getStrikeout());

        byte underline = excelFont.getUnderline();
        if (underline != Font.U_NONE)
            font.setUnderline(true);
        if (underline == Font.U_DOUBLE || underline == Font.U_DOUBLE_ACCOUNTING)
            font.setDoubleUnderline(true);
    }

    private static void recoverCellBorders(CTable table) {
        int numOfCols = table.numOfCols();
        int numOfRows = table.numOfRows();

        CCell[][] cellMatrix = new CCell[numOfCols + 1][numOfRows + 1];

        Iterator<CCell> cells = table.getCells();

        while (cells.hasNext()) {
            CCell cell = cells.next();
            for (int i = cell.getCl(); i <= cell.getCr(); i++) {
                for (int j = cell.getRt(); j <= cell.getRb(); j++) {
                    cellMatrix[i][j] = cell;
                }
            }
        }

        cells = table.getCells();

        while (cells.hasNext()) {
            CCell cell = cells.next();
            CStyle sty = cell.getStyle();
            CCell neighbor;
            CStyle neighborSty;
            BorderType recoveredBorderType;

            // Left
            CBorder leftBorder = sty.getLeftBorder();
            if (leftBorder.getType() == BorderType.NONE && cell.getCl() > 1) {
                recoveredBorderType = BorderType.NONE;

                for (int j = cell.getRt(); j <= cell.getRb(); j++) {
                    neighbor = cellMatrix[cell.getCl() - 1][j];
                    if (null == neighbor) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getRightBorder().getType();
                    if (recoveredBorderType == BorderType.NONE)
                        break;
                }

                if (recoveredBorderType != BorderType.NONE)
                    leftBorder.setType(recoveredBorderType);
            }

            // Right
            CBorder rightBorder = sty.getRightBorder();
            if (rightBorder.getType() == BorderType.NONE && cell.getCr() < numOfCols) {
                recoveredBorderType = BorderType.NONE;

                for (int j = cell.getRt(); j <= cell.getRb(); j++) {
                    neighbor = cellMatrix[cell.getCr() + 1][j];
                    if (null == neighbor) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getLeftBorder().getType();
                    if (recoveredBorderType == BorderType.NONE)
                        break;
                }

                if (recoveredBorderType != BorderType.NONE)
                    rightBorder.setType(recoveredBorderType);
            }

            // Top
            CBorder topBorder = sty.getTopBorder();
            if (topBorder.getType() == BorderType.NONE && cell.getRt() > 1) {
                recoveredBorderType = BorderType.NONE;

                for (int i = cell.getCl(); i <= cell.getCr(); i++) {
                    neighbor = cellMatrix[i][cell.getRt() - 1];
                    if (null == neighbor) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getBottomBorder().getType();
                    if (recoveredBorderType == BorderType.NONE)
                        break;
                }

                if (recoveredBorderType != BorderType.NONE)
                    topBorder.setType(recoveredBorderType);
            }

            // Bottom
            CBorder bottomBorder = sty.getBottomBorder();
            if (bottomBorder.getType() == BorderType.NONE && cell.getRb() < numOfRows) {
                recoveredBorderType = BorderType.NONE;

                for (int i = cell.getCl(); i <= cell.getCr(); i++) {
                    neighbor = cellMatrix[i][cell.getRb() + 1];
                    if (null == neighbor) continue;

                    neighborSty = neighbor.getStyle();

                    recoveredBorderType = neighborSty.getTopBorder().getType();
                    if (recoveredBorderType == BorderType.NONE)
                        break;
                }

                if (recoveredBorderType != BorderType.NONE)
                    bottomBorder.setType(recoveredBorderType);
            }
        }
    }


    private static final DataLoader INSTANCE = new DataLoader();

    private DataLoader() {
    }

    public static DataLoader getInstance() {
        return INSTANCE;
    }

    private static class CPoint {
        int c; // column index
        int r; // row index

        CPoint(int c, int r) {
            this.c = c;
            this.r = r;
        }
    }
}
