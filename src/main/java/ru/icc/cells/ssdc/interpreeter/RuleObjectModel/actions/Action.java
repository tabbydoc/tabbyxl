package ru.icc.cells.ssdc.interpreeter.RuleObjectModel.actions;

public class Action implements ActionInterface {

    private int id;

    public int getId() {
        return id;
    }

    private String name;

    public Action(int id, String name) {

        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String fetchCode() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("[ %d %s ]", id, name);
    }

    /*@Override
    public String generateCallingAction() {
        return "";
    }*/

    @Override
    public String generateAddSet() { return ""; }

    @Override
    public String generateExecute() { return String.format("%s%d.execute()", name, id); }
}
