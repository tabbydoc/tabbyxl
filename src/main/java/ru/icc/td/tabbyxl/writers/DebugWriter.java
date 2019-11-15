package ru.icc.td.tabbyxl.writers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.CItem;
import ru.icc.td.tabbyxl.model.CanonicalForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.BiConsumer;

public class DebugWriter extends BasicExcelWriter {

    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = super.writeToWorkbook(table);

        CanonicalForm cf = table.toCanonicalForm();

        // Write Ner Tag Sheet

        Sheet sheet1 = workbook.createSheet("NER TAGS");
        BiConsumer<CItem, Cell> setCellValByNerTag = (item, excelCell) -> {
                CCell cell = item.getCell();
                String s = cell.getNerTag().toString();
                excelCell.setCellValue(s);
        };
        writeCanonicalForm(sheet1, cf, setCellValByNerTag);

        // Write Type Tag Sheet

        Sheet sheet2 = workbook.createSheet("TYPE TAGS");
        BiConsumer<CItem, Cell> setCellValByTypeTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            String s = cell.getTypeTag().toString();
            excelCell.setCellValue(s);
        };
        writeCanonicalForm(sheet2, cf, setCellValByTypeTag);

        // Write Type Tag Sheet

        Sheet sheet3 = workbook.createSheet("USER-DEFINED TAGS");
        BiConsumer<CItem, Cell> setCellValByTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            String s = cell.getMark();
            excelCell.setCellValue(s);
        };
        writeCanonicalForm(sheet3, cf, setCellValByTag);

        return workbook;
    }

    public void write(CTable table) throws IOException {
        Workbook workbook = writeToWorkbook(table);
        FileOutputStream fileOut = new FileOutputStream(outputFile);
        workbook.write(fileOut);
        fileOut.close();
    }

    public DebugWriter(File outputFile) {
        super(outputFile);
    }
}
