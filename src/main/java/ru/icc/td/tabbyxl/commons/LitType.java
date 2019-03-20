package ru.icc.td.tabbyxl.commons;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

import java.util.ArrayList;
import java.util.List;

public class LitType {
    String entry;
    TagsVerification.EntTags tag;
    List<String> lemmas = new ArrayList<>();
    List<String> subType = new ArrayList<>();

    public LitType(String entry){
        setEntry(entry);
    }

    private String[] parseEntryString(String s, String delim){
        String[] result = s.split(delim);
        return result;
    }

    public void setEntry(String entry){
        this.entry = entry;
            Document doc = new Document(entry);
            for (Sentence sent: doc.sentences()){
                tag = TagsVerification.getTypeForList(sent.nerTags());
                if (tag.equals(TagsVerification.EntTags.NUMBER)){
                    subType.add(TypeClarification.getNumberType(sent.toString()));
                }
                else{
                    subType.add("String");
                }
                lemmas.addAll(sent.lemmas());
            }

    }

    public String getEntry() {
        return entry;
    }

    public TagsVerification.EntTags getTag() {
        return tag;
    }

    public List<String> getLemmas() {
        return lemmas;
    }

    public List<String> getSubType() {
        return subType;
    }
}
