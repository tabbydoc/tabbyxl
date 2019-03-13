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

public abstract class Action implements ActionInterface {

    private int id;

    public int getId() {
        return id;
    }

    private String name;

    public Action(int id, String name) {

        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String fetchCode() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("[ %d %s ]", id, name);
    }

    /*@Override
    public String generateCallingAction() {
        return "";
    }*/

    @Override
    public String generateAddSet() { return ""; }

    @Override
    public String generateExecute() { return String.format("%s%d.execute()", name, id); }

    @Override
    public String getVarName() {
        return "";
    }
}
