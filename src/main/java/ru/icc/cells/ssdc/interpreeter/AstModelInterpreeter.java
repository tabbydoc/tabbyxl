package ru.icc.cells.ssdc.interpreeter;

import ru.icc.cells.ssdc.interpreeter.AstModel.*;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompiler;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompilerException;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CTable;

import java.lang.reflect.InvocationTargetException;
import java.nio.charset.CharacterCodingException;
import java.util.*;

public class AstModelInterpreeter {

    private static final String PACK = "ru.icc.cells.ssdc.interpreeter";

    public static void fireAllRules(CTable table, Model model) throws CharSequenceCompilerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        CharSequenceCompiler compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
        List<Class<? extends RuleClassPrototype>> classes = compileClasses(model, compiler);
        List<? extends RuleClassPrototype> ruleObjects = getRuleObjects(classes, table);
        for(RuleClassPrototype obj:ruleObjects)
        {
            obj.evalLHS();
            obj.evalRHS();
        }
    }

    private static List<Class<? extends RuleClassPrototype>> compileClasses(Model model, CharSequenceCompiler compiler) throws CharSequenceCompilerException {
        List<Class<? extends RuleClassPrototype>> ruleClasses = new ArrayList<>();
        for(Rule rule:model.getRules())
        {
            Class<? extends RuleClassPrototype> ruleClass = compiler.compile(getRuleClassName(rule), fetchCodeFromRule(rule, model.getImports()), null, new Class<?>[]{ RuleClassPrototype.class });
            ruleClasses.add(ruleClass);
        }
        return ruleClasses;
    }

    private static String getRuleClassName(Rule rule)
    {
        return String.format("%s.Rule%d", PACK, rule.getNum());
    }

    private static List<? extends RuleClassPrototype> getRuleObjects(List<Class<? extends RuleClassPrototype>> ruleClasses, CTable table) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<RuleClassPrototype> ruleObjects = new ArrayList<>();
        for(Class<? extends RuleClassPrototype> c:ruleClasses)
        {
            RuleClassPrototype obj = c.getConstructor(new Class[]{ CTable.class }).newInstance(new Object[] { table });
            ruleObjects.add(obj);
        }
        return ruleObjects;
    }

    private static CharSequence fetchCodeFromRule(Rule rule, List<String> imports)
    {
        StringBuilder code = new StringBuilder();
        String lineSep = System.lineSeparator();

        // import classes
        code.append(generateImports(imports)).append(lineSep);

        // begin class
        code.append("public class Rule").append(rule.getNum()).append(" extends RuleClassPrototype {").append(lineSep).append(lineSep);

        // append vars
        code.append(generateVars(rule.getRuleVariables())).append(lineSep);

        // make constructor
        code.append(generateConstructor(rule)).append(lineSep);

        // generate LHS
        code.append(generateLHS(rule.getConditions(), rule.getRuleVariables())).append(lineSep);

        // generate RHS
        code.append(generateRHS(rule.getActions())).append(lineSep);

        code
                .append("@Override").append(lineSep)
                .append("public String sayHello() {").append(lineSep)
                .append("return String.format(\"Hello, my table is %d\", getTable().getId());").append(lineSep)
                .append("}").append(lineSep);

        code
                .append("}").append(lineSep);
        System.out.println(code.toString());
        return code;
    }

    private static String generateImports(List<String> imports)
    {
        StringBuilder code = new StringBuilder();
        String lineSep = System.lineSeparator();
        code
                .append("package ").append(PACK).append(";").append(lineSep)
                .append("import java.util.*;").append(lineSep)
                .append("import java.lang.*;").append(lineSep)
                .append("import ru.icc.cells.ssdc.interpreeter.AstModel.RuleClassPrototype;").append(lineSep);
        for(String item:imports)
        {
            code.append(item).append(lineSep);
        }
        return code.toString();
    }

    private static String generateVars(List<RuleVariable> vars)
    {
        StringBuilder code = new StringBuilder();
        String lineSep = System.lineSeparator();
        code.append("List<CCell> cells = new ArrayList<>();").append(System.lineSeparator());
        for(RuleVariable variable:vars)
        {
            code.append("private List<").append(variable.getType()).append("> ").append(variable.getName()).append(" = new ArrayList<>();").append(lineSep);
        }
        return code.toString();
    }

    private static String generateConstructor(Rule rule)
    {
        StringBuilder code = new StringBuilder();
        code.append("public Rule").append(rule.getNum()).append(" (CTable table) {").append(System.lineSeparator());
        code.append("super(table);").append(System.lineSeparator());
        code.append("table.getCells().forEachRemaining(cells::add);").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateLHS(List<Condition> conditions, List<RuleVariable> vars)
    {
        StringBuilder code = new StringBuilder();
        code
                .append("@Override").append(System.lineSeparator())
                .append("public void evalLHS () {").append(System.lineSeparator()).append(System.lineSeparator());
        for(Condition condition:conditions)
        {
            code.append(generateCondition(condition, vars)).append(System.lineSeparator());
        }
        for(RuleVariable var:vars)
        {
            code.append("for( ").append(var.getType()).append(" k:").append(var.getName()).append(" ) {").append(System.lineSeparator());
            code.append("System.out.println(k.getId());").append(System.lineSeparator());
            code.append("}").append(System.lineSeparator());
        }
        code.append("System.out.println(\"done\");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateCondition(Condition condition, List<RuleVariable> vars)
    {
        StringBuilder code = new StringBuilder();

        List<Alias> aliases = new ArrayList<>();
        aliases.add(new Alias(condition.getVariable().getName(), "item"));

        code.append("for( ").append(condition.getVariable().getType()).append(" item:");
        switch (condition.getVariable().getType())
        {
            case "CCell": code.append("cells ) {").append(System.lineSeparator());
        }

        int flagIterator = 0;
        for(Constraint constraint:condition.getConstraints())
        {
            flagIterator ++;
            code.append("boolean flag").append(flagIterator).append(" = false;").append(System.lineSeparator());

            code.append(generateConstraint(constraint, flagIterator, condition.getVariable().getName(), vars, aliases));

            code.append("if(!flag").append(flagIterator).append(") { continue; }").append(System.lineSeparator());
        }
        code.append(condition.getVariable().getName()).append(".add(item);").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateConstraint(Constraint constraint, int flagIterator, String conditionVarName, List<RuleVariable> vars, List<Alias> aliases)
    {
        StringBuilder code = new StringBuilder();
        List<RuleVariable> replacementVars = new ArrayList<>();
        for(String part:constraint.getParts())
        {
            for(RuleVariable var:vars)
            {
                if(part.equals(var.getName()))
                {
                    replacementVars.add(var);
                    aliases.add(new Alias(part, var.getName()+ "_item"));
                }
            }
        }

        code.append(buildConstraint(constraint, replacementVars.iterator(), flagIterator, aliases));

        return code.toString();
    }

    private static String buildConstraint(Constraint constraint, Iterator<RuleVariable> replacementVars, int flagIterator, List<Alias> aliases)
    {
        StringBuilder code = new StringBuilder();
        if(replacementVars.hasNext())
        {
            RuleVariable currentVar = replacementVars.next();
            code.append("for( ").append(currentVar.getType()).append(" ").append(replaceVarsWithAlias(currentVar.getName(), aliases)).append(":").append(currentVar.getName()).append(" ) {").append(System.lineSeparator());

            code.append(buildConstraint(constraint, replacementVars, flagIterator, aliases));

            code.append("}").append(System.lineSeparator());
        }
        else
        {
            code.append("if(").append(getConstraintString(constraint, aliases, new FieldAlias().getAliases())).append(" ) { flag").append(flagIterator).append(" = true; }").append(System.lineSeparator());
        }
        return code.toString();
    }

    private static String getConstraintString(Constraint constraint, List<Alias> aliases, Map<String, String> fieldMap)
    {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<constraint.getParts().size();i++)
        {
            if(fieldMap.containsKey(constraint.getParts().get(i))) {
                if (i < 2) builder.append("item." + fieldMap.get(constraint.getParts().get(i)));
                else
                {
                    if(constraint.getParts().get(i-1).equals(".")) builder.append(fieldMap.get(constraint.getParts().get(i))).append(" ");
                }
            }
            else
                builder.append(replaceVarsWithAlias(constraint.getParts().get(i),aliases)).append(" ");
        }
        return builder.toString();
    }

    private static String replaceVarsWithAlias(String part, List<Alias> aliases)
    {
        for(Alias alias:aliases)
        {
            if( part.equals(alias.getName()))
                return alias.getAlias();
        }
        return part;
    }

    private static String generateRHS(List<Action> actions)
    {
        StringBuilder code = new StringBuilder();

        code.append("@Override").append(System.lineSeparator());
        code.append("public void evalRHS() {").append(System.lineSeparator());

        for(Action action:actions) {
            code.append(generateAction(action));
        }

        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateAction(Action action)
    {
        StringBuilder code = new StringBuilder();

        switch (action.getName())
        {
            case "Set_mark": code.append(generateSetMark(action.getParams())); break;
            case "New_label": code.append(generateNewLabel(action.getParams())); break;
            case "New_entry": code.append(generateNewEntry(action.getParams())); break;
        }

        return code.toString();
    }

    private static String generateSetMark(List<String> params)
    {
        StringBuilder code = new StringBuilder();

        code.append("for ( CCell item:").append(params.get(0)).append(" ) {").append(System.lineSeparator());
        code.append("item.setMark( ").append(params.get(1)).append(" );").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateNewLabel(List<String> params)
    {
        StringBuilder code = new StringBuilder();

        code.append("for ( CCell item:").append(params.get(0)).append(" ) {").append(System.lineSeparator());
        code.append("item.newLabel(");
        if(params.size()>1) code.append(params.get(1));
        code.append(");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateNewEntry(List<String> params)
    {
        StringBuilder code = new StringBuilder();

        code.append("for ( CCell item:").append(params.get(0)).append(" ) {").append(System.lineSeparator());
        code.append("item.newEntry(");
        if(params.size()>1) code.append(params.get(1));
        code.append(");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

}
