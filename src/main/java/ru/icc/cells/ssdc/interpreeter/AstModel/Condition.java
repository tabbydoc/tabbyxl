package ru.icc.cells.ssdc.interpreeter.AstModel;

import java.util.*;

public class Condition {

    /*private int id;
    public int getId(){ return id; }*/

    private String query;
    private String identifier;

    public Condition(String query, String identifier)
    {
        this.query=query;
        this.identifier=identifier;
    }

    public String getQuery() {return query; }
    public String getIdentifier() { return identifier; }

    private List<Constraint> constraints=new ArrayList<>();
    private List<Assignment> assignments=new ArrayList<>();

    public void addConstraint(Constraint constraint)
    {
        constraints.add(constraint);
    }

    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    }

    @Override
    public String toString()
    {
        StringBuilder result=new StringBuilder();
        result.append(query).append(" ").append(identifier).append(System.lineSeparator());
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
