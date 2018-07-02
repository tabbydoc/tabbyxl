package ru.icc.cells.ssdc.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    private List<String> expression = new ArrayList<>();

    public List<String> getExpression() {
        return expression;
    }

    public void addExpressionPart(String part) {
        expression.add(part);
    }

    public Assignment(String identifier) {
        this.identifier=identifier;;
    }

    @Override
    public String toString()
    {
        return String.format("%s: %s",identifier,expression);
    }
}
