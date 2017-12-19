package ru.icc.cells.ssdc.interpreeter.AstModel.actions;

import ru.icc.cells.ssdc.interpreeter.AstModel.Identifier;

public class NewEntry extends Action {

    public NewEntry(String name) {
        super(name);
    }

    private Identifier identifier;

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    private String stringExpression;

    public void setStringExpression(String stringExpression) {
        this.stringExpression = stringExpression;
    }

    public String getStringExpression() {
        return stringExpression;
    }

    @Override
    public String toString() {
        if(stringExpression != null) return String.format("[ %s ( %s, %s ) ]", getName(), identifier.toString(), stringExpression);
        else return String.format("[ %s ( %s ) ]", getName(), identifier.toString());
    }

    @Override
    public String fetchCode() {

        StringBuilder code = new StringBuilder();

        code.append("for ( CCell cell:").append(identifier.toString()).append(" ) {").append(System.lineSeparator());
        code.append("cell.newEntry(");
        if(stringExpression != null) code.append(stringExpression);
        code.append(");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }
}
