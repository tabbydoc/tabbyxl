package ru.icc.cells.ssdc.engine.RuleObjectModel;

import java.util.ArrayList;
import java.util.List;

public class Constraint {

    private List<String> parts=new ArrayList<>();

    public Constraint(){}

    public void addPart(String part) { parts.add(part); }

    public List<String> getParts() {
        return parts;
    }

    public String toString()
    {
        StringBuilder stringBuilder=new StringBuilder();
        for(String s:parts)
        {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
