package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class NewLabel extends Action {

    public NewLabel(String name) {
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
        if(stringExpression != null) return String.format("[ %s ( %s, %s ) ]", getName(), identifier.toString(), stringExpression);
        else return String.format("[ %s ( %s ) ]", getName(), identifier.toString());
    }
}
