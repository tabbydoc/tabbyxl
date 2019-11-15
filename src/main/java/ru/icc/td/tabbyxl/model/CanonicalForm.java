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

package ru.icc.td.tabbyxl.model;

import dnl.utils.text.table.TextTable;

import java.util.*;

public final class CanonicalForm {
    private List<String> header = new ArrayList<>();
    private List<Record> records = new ArrayList<>();
    private List<CCategory> categories = new ArrayList<>();

    private static final String defaultDataColumnName = "DATA";

    CanonicalForm(CTable table) {

        categories = table.getLocalCategoryBox().getCategoryList();

        // Fill header by using categories
        header.add(defaultDataColumnName);
        for (CCategory category : categories)
            header.add(category.getName());

        // Fill rows by using entries
        Iterator<CEntry> entries = table.getEntries();
        while (entries.hasNext()) {
            CEntry entry = entries.next();
            Record record = new Record(entry);
            records.add(record);
        }
    }

    public List<String> getHeader() {
        return header;
    }

    public String[] getHeaderStrings() {
        String[] strings = new String[header.size()];
        strings = header.toArray(strings);

        return strings;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void print() {
        String[] columnNames = getHeaderStrings();

        final int numOfCols = header.size();
        final int numOfRows = records.size();

        Object[][] data = null;
        if (records.size() > 0) {
            data = new Object[numOfRows][numOfCols];

            for (int i = 0; i < records.size(); i++) {
                data[i] = records.get(i).getStrings();
            }
        }
        TextTable tt = new TextTable(columnNames, data);

        // this adds the numbering on the left
        // tt.setAddRowNumbering(true);
        // sort by the first column
        // tt.setSort(0);

        tt.printTable();
    }

    public String trace() {
        StringBuilder sb = new StringBuilder();
        final String EOL = "\r\n";

        for (String s : header) {
            sb.append(s.toUpperCase()).append('\t');
        }

        sb.append(EOL);

        for (Record record : records) {
            for (String s : record.getStrings()) {
                sb.append(s).append('\t');
            }
            sb.append(EOL);
        }

        return sb.toString();
    }

    public class Record {
        private static final String padding = "";
        private CValue[] values;

        private Record(CEntry entry) {
            final int numOfCols = categories.size() + 1;
            values = new CValue[numOfCols];

            values[0] = entry;

            Iterator<CLabel> labels = entry.getLabels();
            while (labels.hasNext()) {
                CLabel label = labels.next();
                for (int i = 0; i < categories.size(); i++) {
                    CCategory category = categories.get(i);
                    if (label.getCategory().equals(category)) {
                        values[i + 1] = label;
                    }
                }
            }
        }

        public CValue[] getValues() {
            return values;
        }

        public String[] getStrings() {

            String[] strings = new String[values.length];
            Arrays.fill(strings, padding);

            CValue val;

            // Fill strings by using an entry
            val = values[0];
            if (null != val)
                strings[0] = val.getValue();

            // Fill strings by using labels
            for (int i = 1; i < values.length; i++) {
                val = values[i];
                if (null != val) {
                    CLabel label = (CLabel) val;
                    strings[i] = label.getCompoundValue();
                }
            }

            return strings;
        }
    }

}
