package ru.icc.cells.ssdc.interpreeter.AstModel;

import ru.icc.cells.ssdc.model.CTable;

public abstract class RuleClassPrototype implements RuleClassInterface{
    private CTable table;

    public CTable getTable() {
        return table;
    }

    public RuleClassPrototype(CTable table) { this.table = table; }

    @Override
    public String sayHello() { return null; }
   /* @Override
    public CTable evalLHS(){
        return null;
    }
    @Override
    public CTable evalRHS() { return null; }*/
}
