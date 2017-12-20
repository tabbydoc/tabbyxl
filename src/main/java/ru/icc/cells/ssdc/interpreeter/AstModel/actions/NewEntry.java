package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class NewEntry extends Action {

    public NewEntry(String name) {
        super(name);
    }

    private String identifier;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    private String stringExpression;

    public void setStringExpression(String stringExpression) {
        this.stringExpression = stringExpression;
    }

    public String getStringExpression() {
        return stringExpression;
    }

    @Override
    public String toString() {
        if(stringExpression != null) return String.format("[ %s ( %s, %s ) ]", getName(), identifier.toString(), stringExpression);
        else return String.format("[ %s ( %s ) ]", getName(), identifier.toString());
    }
}
