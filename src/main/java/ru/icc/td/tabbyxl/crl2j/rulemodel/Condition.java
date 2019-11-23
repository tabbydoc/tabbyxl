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
