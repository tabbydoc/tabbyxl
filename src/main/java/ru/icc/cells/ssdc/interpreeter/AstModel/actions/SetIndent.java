package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class SetIndent extends Action {

    public SetIndent(String name) {
        super(name);
    }

    private Identifier identifier;

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    private int indent;

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public int getIndent() {
        return indent;
    }

    @Override
    public String toString() {
        return String.format("[ %s ( %s, %d ) ]", getName(), identifier.toString(), indent);
    }
}
