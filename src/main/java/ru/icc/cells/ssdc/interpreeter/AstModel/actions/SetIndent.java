package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

public class SetIndent extends Action {

    public SetIndent(String name) {
        super(name);
    }

    private String identifier;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    private String indent;

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public String getIndent() {
        return indent;
    }

    @Override
    public String toString() {
        return String.format("[ %s ( %s, %d ) ]", getName(), identifier, indent);
    }
}
