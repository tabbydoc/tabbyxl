package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Action {

    private String type;
    private List<Operand> operands = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Operand> getOperands() {
        return operands;
    }

    public void setOperands(List<Operand> operands) {
        this.operands = operands;
    }
}
