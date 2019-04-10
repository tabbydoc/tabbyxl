package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Operand {

    private List<String> expressions = new ArrayList<>();

    public void setExpressions(List<String> expressions) {
        this.expressions = expressions;
    }

    public List<String> getExpressions() {
        return expressions;
    }
}
