package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Assignment {

    private String identifier;
    private List<String> expressions = new ArrayList<>();

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void addExpression (String expression) {
        this.expressions.add(expression);
    }
}
