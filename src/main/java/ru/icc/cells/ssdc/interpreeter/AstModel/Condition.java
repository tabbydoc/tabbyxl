package ru.icc.cells.ssdc.interpreeter.AstModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class Condition {

    private int id;
    public int getId(){ return id; }

    private RuleVariable variable;

    public RuleVariable getVariable() {
        return variable;
    }

    //private String query;
    //private String identifier;

    public Condition(int id, String query, Identifier identifier)
    {
        this.id = id;
        this.variable = new RuleVariable(query, identifier);
    }


    private List<Constraint> constraints = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public void addConstraint(Constraint constraint)
    {
        constraints.add(constraint);
    }
    public List<Constraint> getConstraints() { return constraints;}

    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    }

    public String toString()
    {
        StringBuilder result=new StringBuilder();
        result.append(variable.getType()).append(" ").append(variable.getIdentifier().toString()).append(System.lineSeparator());
        result.append(String.format("constraints (%d): ",constraints.size()));
        for(Constraint constraint:constraints) {
            result.append("[ ").append(constraint.toString()).append(" ] ");
        }
        result.append(System.lineSeparator());
        result.append(String.format("assignments (%d): ", assignments.size()));
        for(Assignment assignment:assignments)
            result.append("[ ").append(assignment.toString()).append(" ] ");
        return result.toString();
    }
}
