package ru.icc.cells.ssdc.interpreeter.AstModel;

import java.util.*;

public class Rule {

    private int num;

    public int getNum()
    {
        return num;
    }

    public Rule(int num)
    {
        this.num=num;
    }

    private List<Condition> conditions=new ArrayList<>();
    private List<Action> actions=new ArrayList<>();

    public void addCondition(Condition condition)
    {
        conditions.add(condition);
    }

    @Override
    public String toString()
    {
        String lineSeparator=System.lineSeparator();
        StringBuilder result=new StringBuilder();
        result.append(String.format("rule #%d", num)).append(lineSeparator).append(lineSeparator);
        result.append(String.format("conditions (%d):",conditions.size())).append(lineSeparator);
        for(Condition condition:conditions)
            result.append(condition.toString()).append(lineSeparator);
        result
                .append(lineSeparator)
                .append(String.format("actions (%d):",actions.size()))
                .append(lineSeparator);
        for(Action action:actions)
            result.append((action.toString())).append(lineSeparator);
        return result.toString();
    }
}