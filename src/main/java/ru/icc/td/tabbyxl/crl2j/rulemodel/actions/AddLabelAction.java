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

public class AddLabelAction extends Action {

    public AddLabelAction(int id, String name) {
        super(id, name);
    }

    private Identifier labelIdentifier;

    public void setLabelIdentifier(Identifier labelIdentifier) {
        this.labelIdentifier = labelIdentifier;
    }

    public Identifier getLabelIdentifier() {
        return labelIdentifier;
    }

    private Identifier categoryIdentifier;

    public void setCategoryIdentifier(Identifier categoryIdentifier) {
        this.categoryIdentifier = categoryIdentifier;
    }

    public Identifier getCategoryIdentifier() {
        return categoryIdentifier;
    }

    private Identifier destinationIdentifier;

    public void setDestinationIdentifier(Identifier destinationIdentifier) {
        this.destinationIdentifier = destinationIdentifier;
    }

    public Identifier getDestinationIdentifier() {
        return destinationIdentifier;
    }

    @Override
    public String toString() {

        if(categoryIdentifier != null) return String.format("[ %s ( %s, %s, %s ) ]", getName(), labelIdentifier.toString(), categoryIdentifier.toString(), destinationIdentifier.toString());
        else return String.format("[ %d %s ( %s, %s ) ]", getId(), getName(), labelIdentifier.toString(), destinationIdentifier.toString());

    }

    @Override
    public String generateAddSet () {

        StringBuilder code = new StringBuilder();

        code.append(getName()).append(getId()).append(".add( ").append(labelIdentifier.getNormalForm()).append(", ").append(destinationIdentifier.getNormalForm());

        if(categoryIdentifier != null) code.append(", ").append(categoryIdentifier.getNormalForm());

        code.append(" )");

        return code.toString();
    }

}
