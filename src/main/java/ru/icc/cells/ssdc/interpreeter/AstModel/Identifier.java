package ru.icc.cells.ssdc.interpreeter.AstModel;

import java.util.ArrayList;
import java.util.List;

public class Identifier {

    private List<Part> parts = new ArrayList<>();

    public Identifier() {}

    public void addPart(String part) {
        parts.add(new Part(part));
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<parts.size(); i++) {
            if(parts.get(i).isAliased()) builder.append(parts.get(i).getAlias());
            else builder.append(parts.get(i).getText());
            if(i<parts.size()-1) builder.append(".");
        }

        return builder.toString();
    }
}
