package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class Merge extends Action {

    public Merge(String name) {
        super(name);
    }

    private String identifier1;

    public String getIdentifier1() {
        return identifier1;
    }

    public void setIdentifier1(String identifier1) {
        this.identifier1 = identifier1;
    }

    private String identifier2;

    public String getIdentifier2() {
        return identifier2;
    }

    public void setIdentifier2(String identifier2) {
        this.identifier2 = identifier2;
    }

    @Override
    public String toString() {
        return String.format("[ %s ( %s, %s) ]", getName(), identifier1.toString(), identifier2.toString());
    }
}
