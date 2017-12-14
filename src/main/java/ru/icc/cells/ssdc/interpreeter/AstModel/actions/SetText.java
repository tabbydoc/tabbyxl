package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class SetText extends Action {

    public SetText(String name) {
        super(name);
    }

    private Identifier identifier;

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    private String stringExpression;

    public String getStringExpression() {
        return stringExpression;
    }

    public void setStringExpression(String stringExpression) {
        this.stringExpression = stringExpression;
    }

    @Override
    public String toString() {
        return String.format("[ %s ( %s, %s ) ]", getName(), identifier.toString(), stringExpression);
    }
}
