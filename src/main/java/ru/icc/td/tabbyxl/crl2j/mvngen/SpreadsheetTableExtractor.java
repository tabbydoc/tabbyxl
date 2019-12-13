/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@icc.ru)
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

package ru.icc.td.tabbyxl.crl2j.mvngen;

import ru.icc.td.tabbyxl.DataLoader;
import ru.icc.td.tabbyxl.crl2j.TableConsumer;
import ru.icc.td.tabbyxl.model.CTable;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class SpreadsheetTableExtractor {

    private final SortedSet<TableConsumer> tableConsumers = new TreeSet<>();
    
    public void register(TableConsumer tableConsumer) {
        tableConsumers.add(tableConsumer);
    }

    public CTable[] extract(File excelFile) throws IOException {

        // Load a workbook

        DataLoader dataLoader = DataLoader.getInstance();
        dataLoader.loadWorkbook(excelFile);

        List<CTable> extractedTables = new ArrayList<>();

        // Process all sheets of the workbook

        for (int i = 0; i < dataLoader.numOfSheets(); i++) {
            dataLoader.goToSheet(i);

            // Canonicalize all tables placed on the current sheet

            while (true) {
                CTable table = dataLoader.nextTable();
                if (null == table) break;

                tableConsumers.forEach(consumer -> consumer.accept(table));
                table.update();
                extractedTables.add(table);
            }
        }

        return extractedTables.isEmpty() ? null : extractedTables.toArray(new CTable[]{});
    }

}
