/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@gmail.com), Viacheslav V. Paramonov, and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl.preprocessing.ner;

import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.NerTag;
import ru.icc.td.tabbyxl.preprocessing.Preprocessor;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

import java.util.List;

public final class NerPreprocessor implements Preprocessor {
    @Override
    public void process(CTable table) {
        // Extracting named entity from each cell

        // We use NER-preprocessor based on "Stanford CoreNLP" library.
        // Have patience in process-time, it can take a long time to load the required NER-models
        // (up to several minutes) before table processing starts for the first time.
        System.out.println("NER is in progress, it can take a long time (up to 1-2 minutes) for the first time");

        System.out.println();

        for (CCell cell : table.getCellList()) {
            String text = cell.getText();
            NerTag nerTag = recognizeNamedEntity(text);
            cell.setNerTag(nerTag);
        }

        System.out.println();
        System.out.println("NER is completed successfully");
        System.out.println();
    }

    private NerTag recognizeNamedEntity(String text) {
        if (null == text || text.isEmpty()) return null;

        Document doc = new Document(text);

        int count = 0;

        for (Sentence sent : doc.sentences()) {
            List<String> tags = sent.nerTags();

            if (null == tags) continue;
            else count += tags.size();

            if (count > 1) return NerTag.NONE;

            try {
                return NerTag.valueOf(tags.get(0));
            } catch (IllegalArgumentException e) {
                return NerTag.NONE;
            }
        }
        return null;
    }
}
