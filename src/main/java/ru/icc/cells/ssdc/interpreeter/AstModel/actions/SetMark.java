package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class SetMark extends Action {

    public SetMark(String name) {
        super(name);
    }

    private Identifier identifier;

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    private String stringExoression;

    public void setStringExoression(String stringExoression) {
        this.stringExoression = stringExoression;
    }

    public String getStringExoression() {
        return stringExoression;
    }

    @Override
    public String toString() {
        return String.format("[ %s ( %s, %s ) ]", getName(), identifier.toString(), stringExoression);
    }
}
