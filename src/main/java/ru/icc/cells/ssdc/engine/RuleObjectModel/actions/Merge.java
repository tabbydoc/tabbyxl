package ru.icc.cells.ssdc.engine.RuleObjectModel.actions;

public class Merge extends Action {

    public Merge(int id, String name) {
        super(id, name);
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
        return String.format("[ %d %s ( %s, %s) ]", getId(), getName(), identifier1.toString(), identifier2.toString());
    }

    @Override
    public String generateAddSet() {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier1).append(", ").append(identifier2).append(" )");

        return code.toString();
    }
}
