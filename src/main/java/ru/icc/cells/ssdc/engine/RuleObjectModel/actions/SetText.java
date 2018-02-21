package ru.icc.cells.ssdc.engine.RuleObjectModel.actions;

import ru.icc.cells.ssdc.engine.RuleCodeGen;

import java.util.ArrayList;
import java.util.List;

public class SetText extends Action {

    public SetText(int id, String name) {
        super(id, name);
    }

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private List<String> stringExpression = new ArrayList<>();

    public List<String> getStringExpression() {
        return stringExpression;
    }

    public void addStringToExpression(String stringExpression) {
        this.stringExpression.add(stringExpression);
    }

    @Override
    public String toString() {
        StringBuilder exprBuilder = new StringBuilder();
        for(String part:stringExpression) {
            exprBuilder.append(part);
        }
        return String.format("[ %d %s ( %s, %s ) ]", getId(), getName(), identifier.toString(), exprBuilder.toString());
    }

    @Override
    public String generateAddSet() {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier).append(", ").append(RuleCodeGen.buildExpression(stringExpression, "")).append(" )");

        return code.toString();
    }
}
