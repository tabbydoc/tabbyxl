/*
 * Copyright 2018 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.icc.cells.ssdc.crl2j;

import ru.icc.cells.ssdc.crl2j.rulemodel.*;
import ru.icc.cells.ssdc.crl2j.rulemodel.actions.*;
import ru.icc.cells.ssdc.crl2j.rulemodel.Condition;
import ru.icc.cells.ssdc.crl2j.compiler.CharSequenceCompiler;
import ru.icc.cells.ssdc.crl2j.compiler.CharSequenceCompilerException;
import ru.icc.cells.ssdc.crl2j.synthesis.RuleProgramPrototype;
import ru.icc.cells.ssdc.model.CTable;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;

public class RuleCodeGen {

    private static final String PACK = "ru.icc.cells.ssdc.crl2j.synthesis";

    private static List<Class<? extends RuleProgramPrototype>> classes = new ArrayList<>();

    public static void compileAllRules(Ruleset ruleset) {

        CharSequenceCompiler compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
        try {
            classes = compileClasses(ruleset, compiler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fireAllRules(CTable table) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for(Class<? extends RuleProgramPrototype> ruleClass:classes) {
            RuleProgramPrototype ruleObject = ruleClass.getConstructor(new Class[] { CTable.class }).newInstance(new Object[] { table });
            ruleObject.eval();
        }

    }

    private static List<Class<? extends RuleProgramPrototype>> compileClasses(Ruleset ruleset, CharSequenceCompiler compiler) throws CharSequenceCompilerException {
        List<Class<? extends RuleProgramPrototype>> ruleClasses = new ArrayList<>();

        for(Rule rule: ruleset.getRules())
        {
            //System.out.println(fetchCodeFromRule(rule, ruleset.getImports()));
            CharSequence code = fetchCodeFromRule(rule, ruleset.getImports());
            System.out.println(code);
            Class<? extends RuleProgramPrototype> ruleClass = compiler.compile(getRuleClassName(rule), code, null, new Class<?>[]{ RuleProgramPrototype.class });
            ruleClasses.add(ruleClass);
        }

        return ruleClasses;
    }

    private static String getRuleClassName(Rule rule) {

        return String.format("%s.Rule%d", PACK, rule.getNum());

    }

    private static List<? extends RuleProgramPrototype> getRuleObjects(List<Class<? extends RuleProgramPrototype>> ruleClasses, CTable table) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<RuleProgramPrototype> ruleObjects = new ArrayList<>();
        for(Class<? extends RuleProgramPrototype> c:ruleClasses)
        {
            RuleProgramPrototype obj = c.getConstructor(new Class[]{ CTable.class }).newInstance(new Object[] { table });
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
        code.append("public class Rule").append(rule.getNum()).append(" extends RuleProgramPrototype {").append(lineSep).append(lineSep);

        // append vars
        code.append(generateVars(rule.getVariables())).append(lineSep);

        // append Actions Objects

        code.append(generateActionsObjects(rule.getActions())).append(lineSep);

        // make constructor
        code.append(generateConstructor(rule)).append(lineSep);

        // generate eval
        code.append(generateEval(rule)).append(lineSep);

        code.append("}").append(lineSep);
        //System.out.println(code.toString());
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
                .append("import ru.icc.cells.ssdc.crl2j.synthesis.RuleProgramPrototype;").append(lineSep);
        for(String item:imports)
        {
            code.append(item).append(lineSep);
        }
        return code.toString();
    }

    private static String generateVars(List<Variable> vars)
    {
        StringBuilder code = new StringBuilder();

        String lineSep = System.lineSeparator();

        //code.append("List<CCell> cells = new ArrayList<>();").append(System.lineSeparator());

        for(Variable variable:vars) {
            if (variable != null) {
                code.append("private ").append(variable.getType()).append(" ").append(variable.getIdentifier().toString()).append(";").append(lineSep);
            }
        }
        return code.toString();
    }

    private static String generateConstructor(Rule rule)
    {
        StringBuilder code = new StringBuilder();
        code.append("public Rule").append(rule.getNum()).append(" (CTable table) {").append(System.lineSeparator());
        code.append("super(table);").append(System.lineSeparator());

        code.append(addActionsObjectsToConstructor(rule.getActions()));
        //code.append("table.getCells().forEachRemaining(cells::add);").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String addActionsObjectsToConstructor(List<Action> actions) {

        StringBuilder code = new StringBuilder();

        for(Action action:actions) {
            if(action != null)
                code.append(action.getName()).append(action.getId()).append(" = new ").append(action.getName()).append("();").append(System.lineSeparator());
        }

        return code.toString();
    }

    private static String generateEval(Rule rule)
    {
        StringBuilder code = new StringBuilder();

        code
                .append("@Override").append(System.lineSeparator())
                .append("public void eval () {").append(System.lineSeparator()).append(System.lineSeparator());


        code.append(generateCondition(rule.getConditions().iterator(), rule.getActions().iterator(), "  ")).append(System.lineSeparator());

        //code.append(generateActionsExecute(rule.getActions())).append(System.lineSeparator());

        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateCondition(Iterator<Condition> conditions, Iterator<Action> actions, String indent)
    {
        StringBuilder code = new StringBuilder();

        Condition currentCondition = conditions.next();

        if(currentCondition.getVariable() != null) {

            code.append(indent).append("Iterator<").append(currentCondition.getVariable().getType()).append("> $iterator").append(currentCondition.getId()).append(" = ");

            switch (currentCondition.getVariable().getType()) {

                case "CCell":
                    code.append("getTable().getCells();");
                    break;
                case "CLabel":
                    code.append("getTable().getLabels();");
                    break;
                case "CEntry":
                    code.append("getTable().getEntries();");
                    break;
                case "CCategory":
                    code.append("getTable().getLocalCategoryBox().getCategories();");
                    break;
                default:
                    break;
            }
        }

            code.append(System.lineSeparator());

        if (currentCondition.getType() == "condition") {
            code.append(indent).append("while ( $iterator").append(currentCondition.getId()).append(".hasNext() ) {").append(System.lineSeparator());

            code.append(indent + "    ").append(currentCondition.getVariable().getIdentifier()).append(" = $iterator").append(currentCondition.getId()).append(".next();").append(System.lineSeparator());
            code.append(indent + "    ").append("if ( ");

            if(currentCondition.getConstraints().size()!=0) {
                code.append(generateConstraints(currentCondition.getConstraints(), currentCondition.getVariable().getIdentifier()));
            } else {
                code.append("true");
            }

            code.append(" ) {").append(System.lineSeparator());

            for(Assignment assignment:currentCondition.getAssignments()) {
                code.append(indent + "        ").append(generateAssignment(assignment, currentCondition.getVariable().getIdentifier()));
            }

            if (conditions.hasNext()) {
                code.append(generateCondition(conditions, actions, indent + "        "));
            } else {
                code.append(generateActionsAddSet(actions, indent + "       "));
            }

            code.append(indent + "    ").append("}").append(System.lineSeparator());
            code.append(indent).append("}").append(System.lineSeparator());
        }
        else if (currentCondition.getType() == "no_condition") {

            code.append(indent).append("boolean $flag").append(currentCondition.getId()).append(" = true;").append(System.lineSeparator());
            code.append(indent).append("while ( $iterator").append(currentCondition.getId()).append(".hasNext() ) {").append(System.lineSeparator());

            code.append(indent + "    ").append(currentCondition.getVariable().getIdentifier()).append(" = $iterator").append(currentCondition.getId()).append(".next();").append(System.lineSeparator());
            code.append(indent + "    ").append("if ( ");

            if(currentCondition.getConstraints().size()!=0) {
                code.append(generateConstraints(currentCondition.getConstraints(), currentCondition.getVariable().getIdentifier()));
            } else {
                code.append("false");
            }

            code.append(" ) {").append(System.lineSeparator());


            code.append(indent + "        ").append("$flag").append(currentCondition.getId()).append(" = false;").append(System.lineSeparator());
            code.append(indent + "        ").append("break;").append(System.lineSeparator());

            code.append(indent + "    ").append("}").append(System.lineSeparator());

            code.append(indent).append("}").append(System.lineSeparator());

            code.append(indent).append("if ( $flag").append(currentCondition.getId()).append(" ) {").append(System.lineSeparator());

            if(conditions.hasNext()) {
                code.append(generateCondition(conditions, actions, indent + "        "));
            } else {
                code.append(generateActionsAddSet(actions, indent + "       "));
            }

            code.append(indent).append("}").append(System.lineSeparator());
        }

        return code.toString();
    }

    private static String generateAssignment(Assignment assignment, String conditionVarName) {

        StringBuilder code = new StringBuilder();

        code.append("String ").append(assignment.getIdentifier()).append(" = String.valueOf( ").append(buildExpression(assignment.getExpression(), conditionVarName)).append(" );").append(System.lineSeparator());

        return code.toString();
    }

    public static String buildExpression (List<String> expression, String variableName) {

        StringBuilder code = new StringBuilder();
        FieldAliases aliases = new FieldAliases();

        for ( int i=0; i<expression.size(); i++ ) {
            if(aliases.getAliases().containsKey(expression.get(i))) {

                if (i<2) {
                    code.append(variableName).append(".").append(aliases.getAliases().get(expression.get(i)));
                }
                else {
                    if( !expression.get(i-1).equals(".") ) {
                        code.append(variableName).append(".").append(aliases.getAliases().get(expression.get(i)));
                    }
                    else
                    {
                        code.append(aliases.getAliases().get(expression.get(i)));
                    }
                }
                if( i > expression.size()-3) {
                    code.append("()");
                }
                else
                {
                    if(expression.get(i+1).equals("[") && expression.get(i+3).equals("]")) {
                        code.append("(").append(expression.get(i + 2)).append(")");
                        i=i+3;
                    }
                    else
                        code.append("()");
                }
            }
            else {
                code.append(expression.get(i));
            }
        }

        return code.toString();
    }

    private static String generateConstraints(List<Constraint> constraints, String conditionVarName) {

        StringBuilder code = new StringBuilder();

        for( int i=0; i<constraints.size(); i++ ) {
            code.append("( ").append(buildExpression(constraints.get(i).getParts(), conditionVarName)).append(" )");
            if(i<constraints.size()-1) code.append(" && ");
        }

        return code.toString();

    }

    private static String generateActionsObjects(List<Action> actions) {

        StringBuilder code = new StringBuilder();

        for(Action action:actions) {
            if(action != null)
                code.append("private ").append(action.getName()).append(" ").append(action.getName()).append(action.getId()).append(";").append(System.lineSeparator());
        }

        return code.toString();
    }

    private static String generateActionsAddSet(Iterator<Action> actions, String indent) {

        StringBuilder code = new StringBuilder();
        Action currentAction;

        while(actions.hasNext()) {
            currentAction = actions.next();
            if(currentAction != null) {
                code.append(indent).append(currentAction.generateAddSet()).append(";").append(System.lineSeparator());
            }
        }

        return code.toString();

    }

    private static String generateActionsExecute(List<Action> actions) {

        StringBuilder code = new StringBuilder();

        for(Action action:actions) {
            if(action != null)
                code.append(action.generateExecute()).append(";").append(System.lineSeparator());
        }

        return code.toString();
    }

}
