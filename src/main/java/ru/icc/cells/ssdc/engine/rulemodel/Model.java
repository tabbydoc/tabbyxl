package ru.icc.cells.ssdc.engine.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Model {

    /*private int id;
    public int getId() {
        return id;
    }*/

    List<String> imports=new ArrayList<>();
    List<Rule> rules=new ArrayList<>();

    public Model(){}

    public void addImport(String setting)
    {
        imports.add(setting);
    }
    public void addRule(Rule rule)
    {
        rules.add(rule);
    }

    public List<Rule> getRules() {
        return rules;
    }

    public List<String> getImports() { return imports; }

    public String toString()
    {
        String lineSeparator=System.lineSeparator();
        StringBuilder result=new StringBuilder();
        result
                .append(String.format("Settings (%d):",imports.size()))
                .append(lineSeparator);
        for(String setting:imports)
            result.append(setting).append(lineSeparator);
        result
                .append(lineSeparator)
                .append(String.format("Rules (%d):",rules.size()))
                .append(lineSeparator).append(lineSeparator);
        for(Rule rule:rules)
            result.append(rule.toString()).append(lineSeparator);
        return result.toString();
    }
}
