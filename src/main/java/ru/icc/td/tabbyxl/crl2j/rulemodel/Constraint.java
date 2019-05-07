package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Constraint {

    private List<String> expressions = new ArrayList<>();

    public void addExpression(String expression) {
        this.expressions.add(expression);
    }

    public List<String> getExpressions() {
        return expressions;
    }
}
