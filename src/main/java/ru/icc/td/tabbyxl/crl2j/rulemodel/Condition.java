/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl.crl2j.rulemodel;

import ru.icc.td.tabbyxl.model.COwned;

import java.util.ArrayList;
import java.util.List;

public class Condition {

    public enum Quantifier {
        FOR_ALL, NOT_EXIST
    }

    private int id;
    private Quantifier quantifier;
    private Class<COwned> dataType;
    private String identifier;
    private List<Constraint> constraints = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quantifier getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(Quantifier quantifier) {
        this.quantifier = quantifier;
    }

    public void setDataType(Class<COwned> dataType) {
        this.dataType = dataType;
    }

    public Class<COwned> getDataType() {
        return dataType;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

}
