package ru.icc.cells.ssdc.engine.rulemodel.actions;

import ru.icc.cells.ssdc.engine.RuleCodeGen;

import java.util.ArrayList;
import java.util.List;

public class NewLabel extends Action {

    public NewLabel(int id, String name) {
        super(id, name);
    }

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private List<String> stringExpression = new ArrayList<>();

    public List<String> getStringExpression() {
        return stringExpression;
    }

    public void addStringToExpression(String part) {
        this.stringExpression.add(part);
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        //if(stringExpression.size() >0 ) {
            for (String part : stringExpression) {
                string.append(part);
            }
        //}

        return String.format("[ %d %s ( %s, %s ) ]", getId(), getName(), identifier.toString(), string.toString());
    }

    @Override
    public String generateAddSet () {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier);

        if( stringExpression.size() > 0 )
            code.append(", ").append(RuleCodeGen.buildExpression(stringExpression, ""));

        code.append(" )");

        return code.toString();
    }



    /*@Override
    public String fetchCode() {

        StringBuilder code = new StringBuilder();

        code.append("for ( CCell cell:").append(identifier.toString()).append(" ) {").append(System.lineSeparator());

        code.append("cell.newLabel(");

        if(stringExpression != null) code.append(stringExpression);

        code.append(");").append(System.lineSeparator());

        code.append("}").append(System.lineSeparator());

        return code.toString();
    }*/
}
