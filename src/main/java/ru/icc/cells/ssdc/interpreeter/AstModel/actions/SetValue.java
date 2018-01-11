package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;
import ru.icc.cells.ssdc.interpreeter.AstModelInterpreeter;

import java.util.ArrayList;
import java.util.List;

public class SetValue extends Action {

    public SetValue(int id, String name) {
        super(id, name);
    }

    private Identifier identifier;

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    private List<String> stringExpression = new ArrayList<>();

    public void addStringToExpression(String string) {
        this.stringExpression.add(string);
    }

    public List<String> getStringExpression() {
        return stringExpression;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for (String part : stringExpression) {
            string.append(part);
        }

        return String.format("[ %d %s ( %s, %s) ]", getId(), getName(), identifier.toString(), string.toString());
    }

    @Override
    public String generateAddSet () {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier.getNormalForm()).append(", ").append(AstModelInterpreeter.buildExpression(stringExpression, "")).append(" )");

        return code.toString();
    }
}
