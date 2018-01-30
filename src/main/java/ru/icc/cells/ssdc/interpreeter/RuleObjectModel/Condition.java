package ru.icc.cells.ssdc.interpreeter.RuleObjectModel;

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

    private RuleVariable variable;

    public RuleVariable getVariable() {
        return variable;
    }

    public void setVariable(RuleVariable variable) {
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
