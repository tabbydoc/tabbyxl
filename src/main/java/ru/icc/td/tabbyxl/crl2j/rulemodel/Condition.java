package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Condition {

    public enum Quantifier {
        FOR_ALL, NOT_EXIST
    }

    public enum DataType {
        CCell, CLabel, CEntry, CCategory
    }

    private int id;
    private Quantifier quantifier;
    private DataType dataType;
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

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
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

    /*
    public boolean isNotExistCondition() {
        return (quantifier == Quantifier.NOT_EXIST ? true : false);
    }
    */
}
