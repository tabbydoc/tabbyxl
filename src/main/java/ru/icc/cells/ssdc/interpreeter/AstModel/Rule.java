package ru.icc.cells.ssdc.interpreeter.AstModel;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    private int num;

    public int getNum()
    {
        return num;
    }

    public Rule(int num)
    {
        this.num=num;
    }

    private final String pack = "ru.icc.cells.ssdc.interpreeter";

    private List<Condition> conditions=new ArrayList<>();
    private List<Action> actions=new ArrayList<>();

    public void addCondition(Condition condition)
    {
        conditions.add(condition);
    }
    public List<Condition> getConditions() { return conditions; }

    public String getRuleClassName() { return String.format("%s.Rule%d", pack, num); }

    public String gerenateClass(List<String> imports)
    {
        StringBuilder builder = new StringBuilder();
        String lineSep = System.lineSeparator();
        //builder.append("package ru.icc.cells.ssdc;").append(lineSep);
        /*for(String item : imports)
        {
            builder.append(item).append(lineSep);
        }*/
        builder
                .append("package ").append(pack).append(";").append(lineSep)
                .append("import ").append(pack).append(".AstModel.RuleClassPrototype;").append(lineSep)
                .append("public class Rule").append(num)
                .append(" extends RuleClassPrototype")
                //.append(" implements RuleClassInterface")
                .append("{").append(lineSep)
                //.append("private String str;").append(lineSep)
                //.append("@Override").append(lineSep)
                .append("public Rule").append(num).append("(String s) { super(s); }").append(lineSep);
        /*for(Condition condition:conditions)
        {
            builder.append("private List<");
            switch (condition.getQuery())
            {
                case "cell" : builder.append("CCell> "); break;
            }
            builder.append(condition.getIdentifier()).append(" = new ArrayList<>();").append(lineSep);
        }*/
       /* for(Condition condition:conditions)
        {
            builder.append(condition.generateCondition());
        }*/
        builder
                .append("@Override").append(lineSep)
                .append("public String sayHello()").append(lineSep)
                .append("{").append(lineSep)
                .append(String.format("return \"Hello world from rule %d \"+ getStr();", num)).append(lineSep)
                .append("}").append(lineSep)
                .append("}").append(lineSep);
        return builder.toString();
    }

    @Override
    public String toString()
    {
        String lineSeparator=System.lineSeparator();
        StringBuilder result=new StringBuilder();
        result.append(String.format("rule #%d", num)).append(lineSeparator).append(lineSeparator);
        result.append(String.format("conditions (%d):",conditions.size())).append(lineSeparator);
        for(Condition condition:conditions)
            result.append(condition.toString()).append(lineSeparator);
        result
                .append(lineSeparator)
                .append(String.format("actions (%d):",actions.size()))
                .append(lineSeparator);
        for(Action action:actions)
            result.append((action.toString())).append(lineSeparator);
        return result.toString();
    }
}
