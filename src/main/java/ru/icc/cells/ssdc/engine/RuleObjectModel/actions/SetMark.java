package ru.icc.cells.ssdc.engine.RuleObjectModel.actions;

import ru.icc.cells.ssdc.engine.RuleCodeGen;

import java.util.ArrayList;
import java.util.List;

public class SetMark extends Action {

    public SetMark(int id, String name) {
        super(id, name);
    }

    private String identifier;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    private List<String> stringExoression = new ArrayList<>();

    public void addStringToExpression(String stringExoression) {
        this.stringExoression.add(stringExoression);
    }

    public List<String> getStringExpression() {
        return stringExoression;
    }

    @Override
    public String toString() {

        StringBuilder exprBuilder = new StringBuilder();

        for(String part:stringExoression) {
            exprBuilder.append(part);
        }

        return String.format("[ %d %s ( %s, %s ) ]", getId(), getName(), identifier.toString(), exprBuilder.toString());
    }

    @Override
    public String generateAddSet() {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier).append(", ").append(RuleCodeGen.buildExpression(stringExoression, "")).append(" )");

        return code.toString();
    }

    /*@Override
    public String fetchCode() {

        StringBuilder code = new StringBuilder();

        code.append("for ( CCell cell:").append(identifier.toString()).append(" ) {").append(System.lineSeparator());
        code.append("cell.setMark( ").append(stringExoression).append(" );").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }*/
}
