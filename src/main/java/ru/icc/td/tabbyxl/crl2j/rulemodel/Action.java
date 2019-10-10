package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public class Action {

    public enum Type {
        split, setText, setIndent, setMark, setValue, newEntry, newLabel, merge, addLabel, setCategory, setParent, group, update
    }

    private Type type;
    private List<Operand> operands = new ArrayList<>();

    public Type  getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Operand> getOperands() {
        return operands;
    }

    public void setOperands(List<Operand> operands) {
        this.operands = operands;
    }
}
