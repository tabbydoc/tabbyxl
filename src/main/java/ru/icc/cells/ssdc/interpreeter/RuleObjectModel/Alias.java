package ru.icc.cells.ssdc.interpreeter.RuleObjectModel;

public class Alias {

    private String name;
    public String getName() {
        return name;
    }

    private String alias;

    public String getAlias() {
        return alias;
    }

    public Alias(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }
}
