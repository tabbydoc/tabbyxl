package ru.icc.td.tabbyxl.writers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.CValue;
import ru.icc.td.tabbyxl.model.CanonicalForm;
import ru.icc.td.tabbyxl.model.CanonicalForm.Record;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;

public class DebugWriter extends BasicExcelWriter {

    protected Workbook writeToWorkbook(CTable table) {
        Workbook workbook = super.writeToWorkbook(table);

        CanonicalForm cf = table.toCanonicalForm();

        Sheet sheet = workbook.createSheet("NER TAG LAYER");
        BiConsumer<CValue, Cell> fillCellByNerTag = (value, excelCell) -> {
                CCell cell = value.getCell();
                String nerTagString = cell.getNerTag().toString();
                excelCell.setCellValue(nerTagString);
        };

        writeCanonicalFormToSheet(sheet, cf, fillCellByNerTag);

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
