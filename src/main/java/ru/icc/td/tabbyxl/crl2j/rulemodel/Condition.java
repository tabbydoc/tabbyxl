package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Condition {

    private String dataType;
    private String identifier;
    private List<Constraint> constraints = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }
}
