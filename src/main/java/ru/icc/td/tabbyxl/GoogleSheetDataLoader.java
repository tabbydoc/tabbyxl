package ru.icc.td.tabbyxl;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.TypeTag;
import ru.icc.td.tabbyxl.model.style.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoogleSheetDataLoader {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GoogleSheetDataLoader.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    private static Sheets createService() {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final Sheets SERVICE = createService();

    public static void main(String[] args) throws IOException {
        // The spreadsheet to request.
        final String spreadsheetId = "1HTgl9tdKXBMo9kHaIozC6BGmQ90uXyhTiSINxKOXscE";
        // The ranges to retrieve from the spreadsheet.
        //List<String> ranges = new ArrayList<>(); // TODO: Update placeholder value.
        //ranges.add("sheet1!A1:F5");
        final String range = "sheet1!A1:F5";

        load(spreadsheetId, range);
    }

    public static CTable load(String spreadsheetId, String range) throws IOException {
        Sheets.Spreadsheets.Get request = SERVICE.spreadsheets().get(spreadsheetId);
        List<String> ranges = new ArrayList<>();
        ranges.add(range);
        request.setRanges(ranges);
        request.setIncludeGridData(true);

        Spreadsheet response = request.execute();
        return parseResponse(response);
    }

    private static CTable parseResponse(Spreadsheet response) {
        List<Sheet> sheets = response.getSheets();
        if (null == sheets || sheets.isEmpty()) return null;

        Sheet sheet = sheets.get(0);

        /*
        final List<GridRange> merges = sheet.getMerges();
        for (GridRange merge: merges) {
            int startCol = merge.getStartColumnIndex();
            int startRow = merge.getStartRowIndex();
            int endCol = merge.getEndColumnIndex();
            int endRow = merge.getEndRowIndex();
            System.out.printf("merge (%d, %d, %d, %d)%n", startCol, startRow, endCol, endRow);
        }
        */

        List<GridData> gridData = sheet.getData();
        if (null == gridData || gridData.isEmpty()) return null;
        GridData gd = gridData.get(0);

        if (null == gd || gd.isEmpty()) return null;
        List<RowData> rowData = gd.getRowData();
        if (null == rowData || rowData.isEmpty()) return null;

        int numRows = gd.getRowMetadata().size();
        int numCols = gd.getColumnMetadata().size();

        //System.out.printf("START ROW = %d%n", gd.getStartRow());
        //System.out.printf("START COLUMN = %d%n", gd.getStartColumn());
        final int rowShift = gd.getStartRow() == null ? 0 : gd.getStartRow();
        final int columnShift = gd.getStartColumn() == null ? 0 : gd.getStartColumn();

        //System.out.printf("%d, %d%n", numRows, numCols);
        CTable table = new CTable(numRows, numCols);

        final List<GridRange> merges = sheet.getMerges();

        int rowIndex = 0;
        for (RowData rd : rowData) {
            rowIndex++;
            int columnIndex = 0;
            List<CellData> cellData = rd.getValues();
            if (null == cellData) continue;
            for (CellData cd : cellData) {
                columnIndex++;
                if (null == cd) continue;

                //String value = cd.getFormattedValue();
                //CellFormat format = cd.getEffectiveFormat();
                //System.out.printf("cell (%d, %d): %s, format %s%n", rowIndex, columnIndex, value, format);

                if (merges.isEmpty()) {
                    CCell cell = table.newCell();
                    cell.setCl(columnIndex);
                    cell.setRt(rowIndex);
                    cell.setCr(columnIndex);
                    cell.setRb(rowIndex);
                    fillCell(cell, cd);
                } else {
                    boolean isMerged = false;
                    for (GridRange merge : merges) {
                        int rt = merge.getStartRowIndex() - rowShift + 1;
                        int cl = merge.getStartColumnIndex() - columnShift + 1;
                        int rb = merge.getEndRowIndex() - rowShift;
                        int cr = merge.getEndColumnIndex() - columnShift;

                        if (rowIndex == rt && columnIndex == cl) {
                            CCell cell = table.newCell();
                            cell.setCl(cl);
                            cell.setRt(rt);
                            cell.setCr(cr);
                            cell.setRb(rb);
                            fillCell(cell, cd);

                            System.out.printf("merge (rt = %d, cl = %d, rb = %d, cr = %d)%n", rt, cl, rb, cr);

                            isMerged = true;
                        } else if (rowIndex >= rt && columnIndex >= cl && rowIndex <= rb && columnIndex <= cr) {
                            isMerged = true;
                        }
                    }
                    if (!isMerged) {
                        CCell cell = table.newCell();
                        cell.setCl(columnIndex);
                        cell.setRt(rowIndex);
                        cell.setCr(columnIndex);
                        cell.setRb(rowIndex);
                        fillCell(cell, cd);
                    }
                }

                //System.out.println(cell.trace());
            }
        }

        return table;
    }

    private static int cellCount;

    private static void fillCell(CCell cell, CellData cd) {
        String rawTextualContent = null;
        TypeTag typeTag = null;

        String text = cd.getFormattedValue();
        // TODO Get text without superscript
        /*
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
        */
        cell.setText(text);

        //rawTextualContent = getFormatCellValue(excelCell);
        rawTextualContent = cd.getFormattedValue(); // TODO Change to cd.getEffectiveValue()
        cell.setRawText(rawTextualContent);

        /*
        switch (excelCell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(excelCell)) {
                    typeTag = TypeTag.DATE;
                } else {
                    typeTag = TypeTag.NUMERIC;
                }
                break;

            case STRING:
                typeTag = TypeTag.STRING;
                break;

            case BOOLEAN:
                typeTag = TypeTag.BOOLEAN;
                break;

            case FORMULA:
                typeTag = TypeTag.FORMULA;
                break;

            case BLANK:
                typeTag = TypeTag.BLANK;
                break;

            case ERROR:
                typeTag = TypeTag.ERROR;
                break;
        }
        */

        cell.setId(cellCount);

        //cell.setTypeTag(typeTag);
        /*
        int height = excelCell.getRow().getHeight();
        cell.setHeight(height);

        int width = excelCell.getSheet().getColumnWidth(excelCell.getColumnIndex());
        cell.setWidth(width);
        */

        CellFormat cf = cd.getEffectiveFormat();
        //CellStyle excelCellStyle = excelCell.getCellStyle();
        CStyle cellStyle = cell.getStyle();

        fillCellStyle(cellStyle, cf);

        //String reference = new CellReference(excelCell).formatAsString(false);
        //cell.setProvenance(reference);

        cellCount++;
    }

    private static CColor convertColor(Color color) {
        if (color == null) return null;

        Float red = color.getRed();
        Float green = color.getGreen();
        Float blue = color.getBlue();

        if (red == null || green == null || blue == null) return null;

        byte r = color.getRed().byteValue();
        byte g = color.getGreen().byteValue();
        byte b = color.getBlue().byteValue();

        return new CColor(new byte[]{r, g, b});
    }

    private static void fillFont(CFont font, TextFormat tf) {
        if (tf == null) return;

        font.setName(tf.getFontFamily());
        font.setColor(convertColor(tf.getForegroundColor()));
        //font.setHeight(value);
        font.setHeightInPoints(tf.getFontSize().shortValue());

        font.setBold(tf.getBold());
        font.setItalic(tf.getItalic());
        font.setStrikeout(tf.getStrikethrough());
        font.setUnderline(tf.getUnderline());
    }

    private static HorzAlignment toHorizontalAlignment(String googleHorizontalAlignment) {
        if (googleHorizontalAlignment == null) return null;

        switch (googleHorizontalAlignment) {
            case "LEFT":
                return HorzAlignment.LEFT;
            case "CENTER":
                return HorzAlignment.CENTER;
            case "RIGHT":
                return HorzAlignment.RIGHT;
            case "JUSTIFY":
                return HorzAlignment.JUSTIFY;
            default:
                return null;
        }
    }

    private static VertAlignment toVerticalAlignment(String googleVerticalAlignment) {
        if (googleVerticalAlignment == null) return null;

        switch (googleVerticalAlignment) {
            case "TOP":
                return VertAlignment.TOP;
            case "CENTER":
                return VertAlignment.CENTER;
            case "BOTTOM":
                return VertAlignment.BOTTOM;
            default:
                return null;
        }
    }

    private static BorderType toBorderType(String googleBorderStyle) {
        if (googleBorderStyle == null) return null;

        switch (googleBorderStyle) {
            case "DOTTED":
                return BorderType.DOTTED;
            case "DASHED":
                return BorderType.DASHED;
            case "SOLID":
                return BorderType.THIN;
            case "SOLID_MEDIUM":
                return BorderType.MEDIUM;
            case "SOLID_THICK":
                return BorderType.THICK;
            case "DOUBLE":
                return BorderType.DOUBLE;
            default:
                return null;
        }
    }

    private static void fillBorder(CBorder border, Border googleBorder) {
        if (googleBorder == null) return;

        border.setType(toBorderType(googleBorder.getStyle()));
        border.setColor(convertColor(googleBorder.getColor()));
    }

    private static void fillCellStyle(CStyle cellStyle, CellFormat cf) {
        if (cf == null) return;

        CFont font = cellStyle.getFont();
        TextFormat tf = cf.getTextFormat();
        fillFont(font, tf);

        cellStyle.setBgColor(convertColor(cf.getBackgroundColor()));

        //cellStyle.setHidden(value);
        //cellStyle.setLocked(value);
        //cellStyle.setWrapped(value);
        //cellStyle.setIndention(value);

        if (cf.getTextRotation() != null && cf.getTextRotation().getAngle() != null)
            cellStyle.setRotation(cf.getTextRotation().getAngle().shortValue());

        cellStyle.setHorzAlignment(toHorizontalAlignment(cf.getHorizontalAlignment()));
        cellStyle.setVertAlignment(toVerticalAlignment(cf.getVerticalAlignment()));

        if (cf.getBorders() != null) {
            CBorder leftBorder = cellStyle.getLeftBorder();
            CBorder rightBorder = cellStyle.getRightBorder();
            CBorder topBorder = cellStyle.getTopBorder();
            CBorder bottomBorder = cellStyle.getBottomBorder();

            fillBorder(cellStyle.getLeftBorder(), cf.getBorders().getLeft());
            fillBorder(rightBorder, cf.getBorders().getRight());
            fillBorder(topBorder, cf.getBorders().getTop());
            fillBorder(bottomBorder, cf.getBorders().getBottom());
        }
    }
}

