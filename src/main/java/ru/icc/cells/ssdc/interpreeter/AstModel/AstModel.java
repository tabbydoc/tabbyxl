package ru.icc.cells.ssdc.interpreeter.AstModel;

import java.util.*;

public class AstModel {

    private int id;
    public int getId() {
        return id;
    }

    List<String> settings=new ArrayList<>();
    List<Rule> rules=new ArrayList<>();

    public AstModel(){}

    public void addSetting(String setting)
    {
        settings.add(setting);
    }
    public void addRule(Rule rule)
    {
        rules.add(rule);
    }

    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public String toString()
    {
        String lineSeparator=System.lineSeparator();
        StringBuilder result=new StringBuilder();
        result
                .append(String.format("Settings (%d):",settings.size()))
                .append(lineSeparator);
        for(String setting:settings)
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
