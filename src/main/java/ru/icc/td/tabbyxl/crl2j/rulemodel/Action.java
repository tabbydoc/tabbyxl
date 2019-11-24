package ru.icc.td.tabbyxl.crl2j.rulemodel;

import java.util.ArrayList;
import java.util.List;

public final class Action {

    private String methodName;
    private List<Expression> operands = new ArrayList<>();

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Expression> getOperands() {
        return operands;
    }

    public void setOperands(List<Expression> operands) {
        this.operands = operands;
    }
}
