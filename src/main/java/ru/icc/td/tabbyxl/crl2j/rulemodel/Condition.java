package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Condition {

    private int id;
    private String dataType;
    private String identifier;
    private List<Constraint> constraints = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();
    private boolean notExistsCondition = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
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

    public void setNotExistsCondition(boolean notExistsCondition) {
        this.notExistsCondition = notExistsCondition;
    }

    public boolean isNotExistsCondition() {
        return notExistsCondition;
    }
}
