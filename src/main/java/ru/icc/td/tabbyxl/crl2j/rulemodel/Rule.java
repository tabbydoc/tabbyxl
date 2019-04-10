package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    private List<Condition> conditions = new ArrayList<>();
    private List<Action> actions = new ArrayList<>();

    public List<Condition> getConditions() {
        return conditions;
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    public List<Action> getActions() {
        return actions;
    }

    public void addAction(Action action) {
        actions.add(action);
    }
}
