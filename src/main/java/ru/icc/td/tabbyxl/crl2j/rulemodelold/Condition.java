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

public class Condition {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Condition(int id) {
        this.id = id;
    }

    private Variable variable;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    private int id;

    public int getId() {
        return id;
    }

    private List<Constraint> constraints = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public void addConstraint(Constraint constraint) {
        constraints.add(constraint);
    }
    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
    public List<Assignment> getAssignments() {
        return assignments;
    }

    public String toString()
    {
        StringBuilder result=new StringBuilder();
        result.append(type.toString());
        if (type.equals("condition"))
        {
            result.append(" ").append(variable.getType()).append(" ").append(variable.getIdentifier());
        }
        result.append(System.lineSeparator());
        result.append(String.format("constraints (%d): ",getConstraints().size()));
        for(Constraint constraint:getConstraints()) {
            result.append("[ ").append(constraint.toString()).append(" ] ");
        }
        result.append(System.lineSeparator());
        result.append(String.format("assignments (%d): ", getAssignments().size()));
        for(Assignment assignment:getAssignments())
            result.append("[ ").append(assignment.toString()).append(" ] ");
        return result.toString();
    }
}
