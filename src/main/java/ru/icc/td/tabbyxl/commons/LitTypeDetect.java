package ru.icc.td.tabbyxl.commons;


import edu.stanford.nlp.ie.KBPRelationExtractor;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;


import javax.swing.text.html.HTML;
import java.util.*;


public class LitTypeDetect {
    //KBPRelationExtractor.NERTag entTags;

    private enum LitType {BOOLEAN, SINGLE, FLOAT};
    List<String> nerTags = new ArrayList<String>();
    List<String> lemmas = new ArrayList<String>();


    public LitTypeDetect(String[] entities){
        for (String entity : entities){
            addData(entity);
        }

    }

    public void addData(String entry){
        TagsVerification.EntTags tag;

        Document doc = new Document(entry);
        for (Sentence sent: doc.sentences()){
            tag = TagsVerification.getTypeForList(sent.nerTags());
            nerTags.add(tag.toString());
            lemmas.addAll(sent.lemmas());

        }
    }

    public List<String> getNerTags() {
        return nerTags;
    }


    public List<String> getLemmas() {
        return lemmas;
    }

}
