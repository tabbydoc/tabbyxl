package ru.icc.cells.ssdc.engine.RuleObjectModel.actions;

import ru.icc.cells.ssdc.engine.RuleCodeGen;

import java.util.ArrayList;
import java.util.List;

public class SetIndent extends Action {

    public SetIndent(int id, String name) {
        super(id, name);
    }

    private String identifier;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    private List<String> indent = new ArrayList<>();

    public void addIndentPart(String indent) {
        this.indent.add(indent);
    }

    public List<String> getIndent() {
        return indent;
    }

    @Override
    public String toString() {
        StringBuilder indetnBuilder = new StringBuilder();

        for(String part:indent) {
            indetnBuilder.append(part);
        }
        return String.format("[ %d %s ( %s, %s ) ]", getId(), getName(), identifier, indetnBuilder.toString());
    }

    @Override
    public String generateAddSet() {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier).append(", ").append(RuleCodeGen.buildExpression(indent, "")).append(" )");

        return code.toString();
    }
}
