package ru.icc.td.tabbyxl.writers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.*;

import java.io.File;
import java.util.function.BiConsumer;

public final class DebugWriter extends BasicExcelWriter {

    @Override
    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = super.writeToWorkbook(table);

        CanonicalForm cf = table.toCanonicalForm();

        // Write Ner Tag Sheet

        Sheet sheet1 = workbook.createSheet("NER TAGS");
        BiConsumer<CItem, Cell> setCellValByNerTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            NerTag tag = cell.getNerTag();
            String s = null == tag ? null : tag.toString();
            excelCell.setCellValue(s);
        };
        writeCanonicalForm(sheet1, cf, setCellValByNerTag);

        // Write Type Tag Sheet

        Sheet sheet2 = workbook.createSheet("TYPE TAGS");
        BiConsumer<CItem, Cell> setCellValByTypeTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            TypeTag tag = cell.getTypeTag();
            String s = null == tag ? null : tag.toString();
            excelCell.setCellValue(s);
        };
        writeCanonicalForm(sheet2, cf, setCellValByTypeTag);

        // Write Type Tag Sheet

        Sheet sheet3 = workbook.createSheet("USER-DEFINED TAGS");
        BiConsumer<CItem, Cell> setCellValByTag = (item, excelCell) -> {
            CCell cell = item.getCell();
            String tag = cell.getMark();
            excelCell.setCellValue(tag);
        };
        writeCanonicalForm(sheet3, cf, setCellValByTag);

        return workbook;
    }

    public DebugWriter(File outputFile) {
        super(outputFile);
    }
}
