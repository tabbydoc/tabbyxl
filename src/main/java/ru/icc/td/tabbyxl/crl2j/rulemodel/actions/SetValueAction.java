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

package ru.icc.td.tabbyxl.crl2j.rulemodel.actions;

import ru.icc.td.tabbyxl.crl2j.rulemodel.Identifier;
import ru.icc.td.tabbyxl.crl2j.RuleCodeGen;

import java.util.ArrayList;
import java.util.List;

public class SetValueAction extends Action {

    public SetValueAction(int id, String name) {
        super(id, name);
    }

    private Identifier identifier;

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    private List<String> stringExpression = new ArrayList<>();

    public void addStringToExpression(String string) {
        this.stringExpression.add(string);
    }

    public List<String> getStringExpression() {
        return stringExpression;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for (String part : stringExpression) {
            string.append(part);
        }

        return String.format("[ %d %s ( %s, %s) ]", getId(), getName(), identifier.toString(), string.toString());
    }

    @Override
    public String generateAddSet () {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier.getNormalForm()).append(", ").append(RuleCodeGen.buildExpression(stringExpression, "")).append(" )");

        return code.toString();
    }

    @Override
    public String getVarName() {
        return "";
    }
}
