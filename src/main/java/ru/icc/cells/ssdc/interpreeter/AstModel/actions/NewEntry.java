package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;
import ru.icc.cells.ssdc.interpreeter.AstModelInterpreeter;

import java.util.ArrayList;
import java.util.List;

public class NewEntry extends Action {

    public NewEntry(int id, String name) {
        super(id, name);
    }

    private String identifier;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    private List<String> stringExpression = new ArrayList<>();

    public void addStringToExpression(String part) {
        this.stringExpression.add(part);
    }

    public List<String> getStringExpression() {
        return stringExpression;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for(String part:stringExpression)
            string.append(part);

        return String.format("[ %d %s ( %s,  ) ]", getId(), getName(), identifier.toString(), string.toString());
    }

    @Override
    public String generateCallingAction() {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".eval(").append(identifier);

        if( stringExpression.size() > 0 )
            code.append(", ").append(AstModelInterpreeter.buildExpression(stringExpression, ""));

        code.append(", ").append("getTable() )");

        return code.toString();
    }
}
