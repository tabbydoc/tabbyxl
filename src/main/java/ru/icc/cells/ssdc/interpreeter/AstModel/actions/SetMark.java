package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class SetMark extends Action {

    public SetMark(String name) {
        super(name);
    }

    private String identifier;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    private String stringExoression;

    public void setStringExpression(String stringExoression) {
        this.stringExoression = stringExoression;
    }

    public String getStringExpression() {
        return stringExoression;
    }

    @Override
    public String toString() {
        return String.format("[ %s ( %s, %s ) ]", getName(), identifier.toString(), stringExoression);
    }
}
