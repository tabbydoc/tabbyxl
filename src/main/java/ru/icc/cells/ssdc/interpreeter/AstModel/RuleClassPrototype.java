package ru.icc.cells.ssdc.interpreeter.AstModel;

import ru.icc.cells.ssdc.model.CTable;

public abstract class RuleClassPrototype implements RuleClassInterface{
    private String str;

    public String getStr() {
        return str;
    }

    public RuleClassPrototype(String s) { str = s; }
    @Override
    public String sayHello(){
        return "Super says "+str;
    }
}
