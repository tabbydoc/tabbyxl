package ru.icc.cells.ssdc.engine.RuleObjectModel.actions;

public class Split extends Action {

    public Split(int id, String name) {
        super(id, name);
    }

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return String.format("[ %d %s ( %s ) ]", getId(), getName(), identifier.toString());
    }

    @Override
    public String generateAddSet() {

        StringBuilder code= new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier).append(" )");

        return code.toString();
    }
}
