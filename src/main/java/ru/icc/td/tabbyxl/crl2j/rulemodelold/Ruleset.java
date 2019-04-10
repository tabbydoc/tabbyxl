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

import java.util.ArrayList;
import java.util.List;

public class Ruleset {

    /*private int id;
    public int getId() {
        return id;
    }*/

    List<String> imports=new ArrayList<>();
    List<Rule> rules=new ArrayList<>();

    public Ruleset(){}

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
