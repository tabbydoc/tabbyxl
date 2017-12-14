package ru.icc.cells.ssdc.interpreeter.AstModel;

import ru.icc.cells.ssdc.interpreeter.AstModel.actions.Action;

import java.util.ArrayList;
import java.util.List;

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

    private List<RuleVariable> ruleVariables = new ArrayList<>();
    private List<Condition> conditions=new ArrayList<>();
    private List<Action> actions=new ArrayList<>();

    public void addVariable(RuleVariable variable) { ruleVariables.add(variable); }

    public List<RuleVariable> getRuleVariables() { return ruleVariables; }

    public void addCondition(Condition condition) {
        ruleVariables.add(condition.getVariable());
        conditions.add(condition);
    }

    public List<Condition> getConditions() { return conditions; }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public List<Action> getActions() {
        return actions;
    }

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
