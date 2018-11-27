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

import ru.icc.td.tabbyxl.crl2j.RuleCodeGen;

import java.util.ArrayList;
import java.util.List;

public class PrintAction extends Action {

    public PrintAction(int id, String name) {
        super(id, name);
    }

    private List<String> expression = new ArrayList<>();

    public List<String> getExpression() {
        return expression;
    }

    public void addPartToExpression(String part) {
        this.expression.add(part);
    }

    @Override
    public String generateAddSet() {

        StringBuilder code = new StringBuilder();

        code.append("System.out.println( ").append(RuleCodeGen.buildExpression(expression, "")).append(" )");

        return code.toString();
    }
}
