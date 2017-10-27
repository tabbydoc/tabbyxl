package ru.icc.cells.ssdc.interpreeter.AstModel;

public class Assignment {
    private String identifier;
    private String expression;
    public Assignment(String identifier, String expression)
    {
        this.identifier=identifier;
        this.expression=expression;
    }
    @Override
    public String toString()
    {
        return String.format("%s: %s",identifier,expression);
    }
}
