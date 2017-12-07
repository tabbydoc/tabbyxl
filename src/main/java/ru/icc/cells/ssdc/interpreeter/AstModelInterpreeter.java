package ru.icc.cells.ssdc.interpreeter;

import ru.icc.cells.ssdc.interpreeter.AstModel.*;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompiler;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompilerException;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CTable;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class AstModelInterpreeter {

    private static final String PACK = "ru.icc.cells.ssdc.interpreeter";

    public static void fireAllRules(CTable table, Model model) throws CharSequenceCompilerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        CharSequenceCompiler compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
        List<Class<? extends RuleClassPrototype>> classes = compileClasses(model, compiler);
        List<? extends RuleClassPrototype> ruleObjects = getRuleObjects(classes, table);
        for(RuleClassPrototype obj:ruleObjects)
        {
            System.out.println(obj.sayHello());
        }
        List<CCell> $c = new ArrayList<>();
        table.getCells().forEachRemaining($c::add);
    }

    private static List<Class<? extends RuleClassPrototype>> compileClasses(Model model, CharSequenceCompiler compiler)
    {
        List<Class<? extends RuleClassPrototype>> ruleClasses = new ArrayList<>();
        for(Rule rule:model.getRules())
        {
            try
            {
                Class<? extends RuleClassPrototype> ruleClass = compiler.compile(getRuleClassName(rule), fetchCodeFromRule(rule, model.getImports()), null, new Class<?>[]{ RuleClassPrototype.class });
                ruleClasses.add(ruleClass);
            } catch (CharSequenceCompilerException e) {
                e.printStackTrace();
            }
        }
        return ruleClasses;
    }

    private static String getRuleClassName(Rule rule)
    {
        return String.format("%s.Rule%d", PACK, rule.getNum());
    }

    private static List<? extends RuleClassPrototype> getRuleObjects(List<Class<? extends RuleClassPrototype>> ruleClasses, CTable table)
    {
        List<RuleClassPrototype> ruleObjects = new ArrayList<>();
        for(Class<? extends RuleClassPrototype> c:ruleClasses)
        {
            try
            {
                RuleClassPrototype obj = c.getConstructor(new Class[]{ CTable.class }).newInstance(new Object[] { table });
                ruleObjects.add(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return ruleObjects;
    }

    private static CharSequence fetchCodeFromRule(Rule rule, List<String> imports)
    {
        StringBuilder code = new StringBuilder();
        String lineSep = System.lineSeparator();
       /* for(RuleVariable r:rule.getRuleVariables())
            System.out.println(r.getName());*/
        // import classes
        code.append(generateImports(imports));

        // begin class
        code.append("public class Rule").append(rule.getNum()).append(" extends RuleClassPrototype {").append(lineSep);

        // append vars
        code.append(generateVars(rule.getRuleVariables()));

        // make constructor
        code.append(generateConstructor(rule));

        // generate LHS
        code.append(generateLHS(rule.getConditions(), rule.getRuleVariables()));

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
        for(RuleVariable variable:vars)
        {
            code.append("private List<").append(variable.getType()).append("> ").append(variable.getName()).append(" = new ArrayList<>();").append(lineSep);
            //code.append("public Iterator<").append(variable.getType()).append("> get").append(variable.getName()).append(" () { return ").append(variable.getName()).append("; }").append(lineSep);
        }
        return code.toString();
    }

    private static String generateConstructor(Rule rule)
    {
        StringBuilder code = new StringBuilder();
        code.append("public Rule").append(rule.getNum()).append(" (CTable table) {").append(System.lineSeparator());
        code.append("super(table);").append(System.lineSeparator());
        for(RuleVariable variable:rule.getRuleVariables())
        {
            switch (variable.getType())
            {
                case "CCell": code.append("table.getCells().forEachRemaining(").append(variable.getName()).append("::add);"); break;
                case "CEntry": code.append("table.getEntries();"); break;
                case "CLabel": code.append("table.getLabels();");break;
                case "CCategory": code.append("table.getLocalCategoryBox().getCategories();"); break;
                default: code.append("null;"); break;
            }
            code.append(System.lineSeparator());
        }
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateLHS(List<Condition> conditions, List<RuleVariable> vars)
    {
        StringBuilder code = new StringBuilder();
        code
                .append("@Override").append(System.lineSeparator())
                .append("public void evalLHS () {").append(System.lineSeparator());
        for(Condition condition:conditions)
        {
            code.append(generateCondition(condition, vars));
        }
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateCondition(Condition condition, List<RuleVariable> vars)
    {
        StringBuilder code = new StringBuilder();

        List<Alias> aliases = new ArrayList<>();
        aliases.add(new Alias(condition.getVariable().getName(), "item"));

        code.append("boolean flag;").append(System.lineSeparator());
        code.append("for( ").append(condition.getVariable().getType()).append(" item:").append(condition.getVariable().getName()).append(" ) {").append(System.lineSeparator());
        for(Constraint constraint:condition.getConstraints())
        {
            code.append(generateConstraint(constraint, condition.getVariable().getName(), vars, aliases));
        }
        code.append("}").append(System.lineSeparator());

        /*code.append("for(").append(condition.getVariable().getType()).append(" item:").append(condition.getVariable().getName()).append(") {").append(System.lineSeparator());
        code.append(generateConstraints(condition.getConstraints(), condition.getVariable().getName(), vars));
        code.append("}").append(System.lineSeparator());*/

        return code.toString();
    }

    private static String generateConstraint(Constraint constraint, String conditionVarName, List<RuleVariable> vars, List<Alias> aliases)
    {
        StringBuilder code = new StringBuilder();
        boolean constraintHasVars = false;
        RuleVariable currentVar = null;
        for(String part:constraint.getParts())
        {
            for(RuleVariable var:vars)
            {
                if(part.equals(var.getName()))
                {
                    constraintHasVars = true;
                    currentVar = var;
                    aliases.add(new Alias(part, var.getName()+ "_item"));
                    break;
                }
            }
        }
        //RuleVariable var = constraintHasVars(constraint, vars);
        if(constraintHasVars) {

            code.append("flag = false;").append(System.lineSeparator());
            code.append("for( ").append(currentVar.getType()).append(" ").append(replaceVarsWithAlias(currentVar.getName(), aliases)).append(":").append(currentVar.getName()).append(" ) {").append(System.lineSeparator());

            code.append("if(").append(getConstraintString(constraint, aliases)).append(" ) {").append(System.lineSeparator());
            code.append("flag = true;").append(System.lineSeparator());
            code.append("break;").append(System.lineSeparator());
            code.append("}").append(System.lineSeparator());
            code.append("if(!flag) {").append(System.lineSeparator());

            code
                    .append(conditionVarName).append(".remove(item);").append(System.lineSeparator())
                    .append("continue; ").append(System.lineSeparator())
                    .append("}").append(System.lineSeparator());

            code.append("}").append(System.lineSeparator());
        }
        else
        {
            code.append("if( !( ").append(getConstraintString(constraint, aliases)).append( ")) { ").append(System.lineSeparator());
            code
                    .append(conditionVarName).append(".remove(item);").append(System.lineSeparator())
                    .append("continue; ").append(System.lineSeparator())
                    .append("}").append(System.lineSeparator());
        }
        return code.toString();
    }

    private static String getConstraintString(Constraint constraint, List<Alias> aliases)
    {
        StringBuilder builder = new StringBuilder();
        for(String part:constraint.getParts())
        {
            builder.append(replaceVarsWithAlias(part, aliases)).append(" ");
        }
        return builder.toString();
    }

    private static String replaceVarsWithAlias(String var, List<Alias> aliases)
    {
        for(Alias alias:aliases)
        {
            if( var.equals(alias.getName()))
                return alias.getAlias();
        }
        return var;
    }
    /*private static RuleVariable constraintHasVars(Constraint constraint, List<RuleVariable> vars)
    {
        for(String part:constraint.getParts())
        {
            for(RuleVariable var:vars)
                if(part.equals(var.getName()))
                {
                    return var;
                }
        }
        return null;
    }
    /*private static String generateConstraint(Constraint constraints, String varName, List<RuleVariable> vars)
    {
        StringBuilder code = new StringBuilder();
        for(Constraint constraint:constraints)
        {

        }
        return code.toString();
    }*/
}
