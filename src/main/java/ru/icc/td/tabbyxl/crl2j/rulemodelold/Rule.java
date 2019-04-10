/*
 * Copyright 2018 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.icc.td.tabbyxl.crl2j.rulemodelold;

import ru.icc.td.tabbyxl.crl2j.rulemodelold.actions.Action;

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

    private List<Condition> conditions=new ArrayList<>();
    private List<Action> actions=new ArrayList<>();

    /*private Map<String, String> varTypes = new HashMap<>();

    public void addVarType (String identifier, String type) {
        varTypes.put(identifier, type);
    }*/

    private List<Variable> variables = new ArrayList<>();

    public List<Variable> getVariables() {
        return variables;
    }

    public void addVariable(Variable variable) {
        variables.add(variable);
    }

    public void addCondition(Condition condition) {

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
            if(action != null)
                result.append((action.toString())).append(lineSeparator);

        return result.toString();
    }
}
