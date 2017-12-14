package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class SetValue extends Action {

    public SetValue(String name) {
        super(name);
    }

    private Identifier identifier;

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
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
        return String.format("[ %s ( %s, %s) ]", getName(), identifier.toString(), stringExpression);
    }
}
