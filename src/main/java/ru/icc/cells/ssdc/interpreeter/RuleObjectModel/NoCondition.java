package ru.icc.cells.ssdc.interpreeter.RuleObjectModel;

import java.util.ArrayList;
import java.util.List;

public class NoCondition{

    public NoCondition(int id, String query) {
        this.id = id;
        this.query = query;
    }

    private String query;

    public String getQuery() {
        return query;
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

    public String toString() {

        StringBuilder result = new StringBuilder();

        result.append(query).append(System.lineSeparator());

        result.append(String.format("constraints (%d): ",getConstraints().size()));
        for(Constraint constraint:getConstraints()) {
            result.append("[ ").append(constraint.toString()).append(" ] ");
        }
        result.append(System.lineSeparator());

        result.append(String.format("assignments (%d): ", getAssignments().size()));
        for(Assignment assignment:getAssignments())
            result.append("[ ").append(assignment.toString()).append(" ] ");
        result.append(System.lineSeparator());

        return result.toString();
    }
}
