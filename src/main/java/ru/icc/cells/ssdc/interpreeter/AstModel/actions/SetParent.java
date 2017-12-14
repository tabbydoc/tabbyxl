package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class SetParent extends Action {

    public SetParent(String name) {
        super(name);
    }

    private Identifier parent;

    public void setParent(Identifier parent) {
        this.parent = parent;
    }

    public Identifier getParent() {
        return parent;
    }

    private Identifier child;

    public void setChild(Identifier child) {
        this.child = child;
    }

    public Identifier getChild() {
        return child;
    }

    @Override
    public String toString() {
        return String.format("[ %s ( %s, %s) ]", getName(), parent.toString(), child.toString());
    }
}
