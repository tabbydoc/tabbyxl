package ru.icc.cells.ssdc.interpreeter.AstModel;

import ru.icc.cells.ssdc.interpreeter.AstModel.Assignment;
import ru.icc.cells.ssdc.interpreeter.AstModel.Constraint;
import ru.icc.cells.ssdc.interpreeter.AstModel.RuleVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class Condition {

    public Condition(int id, RuleVariable variable) {
        this.id = id;
        this.variable = variable;
    }

    private RuleVariable variable;

    public RuleVariable getVariable() {
        return variable;
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
        result.append(variable.getType()).append(" ").append(variable.getIdentifier()).append(System.lineSeparator());
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
