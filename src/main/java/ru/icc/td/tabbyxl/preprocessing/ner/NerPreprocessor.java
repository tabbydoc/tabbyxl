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

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import ru.icc.td.tabbyxl.model.CCell;
import ru.icc.td.tabbyxl.model.CTable;
import ru.icc.td.tabbyxl.model.NerTag;
import ru.icc.td.tabbyxl.preprocessing.Preprocessor;

import java.util.Properties;

public final class NerPreprocessor implements Preprocessor {

    private static final StanfordCoreNLP pipeline;

    static {
        // Set up pipeline properties
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");

        props.setProperty("ssplit.isOneSentence", "true");
        props.setProperty("ner.useSUTime", "false");

        // Disable fine grained ner
        props.setProperty("ner.applyFineGrained", "false");

        // Set up pipeline
        pipeline = new StanfordCoreNLP(props);
    }

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

        // If the sentence is too long then skip running the annotator
        if (text.length() > 100) return NerTag.NONE;

        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);

        String tag = doc.tokens().get(0).ner();

        try {
            return NerTag.valueOf(tag);
        } catch (IllegalArgumentException e) {
            return NerTag.NONE;
        }
    }
}
