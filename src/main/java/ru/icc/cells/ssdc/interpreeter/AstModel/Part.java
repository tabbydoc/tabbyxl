package ru.icc.cells.ssdc.interpreeter.AstModel;

public class Part {

    private String text;
    private String alias;
    private boolean hasAlias;

    public Part(String text) {
        this.text = text;
        this.hasAlias = false;
    }

    public void setAlias(String alias) {
        this.alias = alias;
        hasAlias = true;
    }

    public String getAlias() {
        return alias;
    }

    public void removeAlias() {
        alias = null;
        hasAlias = false;
    }

    public boolean isAliased() {
        return hasAlias;
    }

    public String getText() {
        return text;
    }
}
