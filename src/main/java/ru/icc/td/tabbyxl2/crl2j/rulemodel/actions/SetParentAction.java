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

package ru.icc.td.tabbyxl2.crl2j.rulemodel.actions;

import ru.icc.td.tabbyxl2.crl2j.rulemodel.Identifier;

public class SetParentAction extends Action {

    public SetParentAction(int id, String name) {
        super(id, name);
    }

    private Identifier parent;

    public void setParent(Identifier parent) {
        this.parent = parent;
    }

    public Identifier getParent() {
        return parent;
    }

    private Identifier child;

    public void setChild(Identifier child) {
        this.child = child;
    }

    public Identifier getChild() {
        return child;
    }

    @Override
    public String toString() {
        return String.format("[ %d %s ( %s, %s) ]", getId(), getName(), parent.toString(), child.toString());
    }

    @Override
    public String generateAddSet() {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(parent.getNormalForm()).append(", ").append(child.getNormalForm()).append(" )");

        return code.toString();
    }
}
