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

public class SetCategoryAction extends Action {

    public SetCategoryAction(int id, String name) {
        super(id, name);
    }

    private Identifier identifier1;

    public void setIdentifier1(Identifier identifier1) {
        this.identifier1 = identifier1;
    }

    public Identifier getIdentifier1() {
        return identifier1;
    }

    private Identifier identifier2;

    public void setIdentifier2(Identifier identifier2) {
        this.identifier2 = identifier2;
    }

    public Identifier getIdentifier2() {
        return identifier2;
    }

    @Override
    public String toString() {
        return String.format("[ %d %s ( %s, %s) ]", getId(), getName(), identifier1.toString(), identifier2.toString());
    }

    @Override
    public String generateAddSet() {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(identifier1.getNormalForm()).append(", ").append(identifier2.getNormalForm()).append(" )");

        return code.toString();
    }
}
