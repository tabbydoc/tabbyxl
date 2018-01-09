package ru.icc.cells.ssdc.interpreeter;

import ru.icc.cells.ssdc.interpreeter.AstModel.*;
import ru.icc.cells.ssdc.interpreeter.AstModel.actions.*;
import ru.icc.cells.ssdc.interpreeter.AstModel.Condition;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompiler;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompilerException;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CTable;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;

public class AstModelInterpreeter {

    private static final String PACK = "ru.icc.cells.ssdc.interpreeter";

    private static List<Class<? extends RuleClassPrototype>> classes = new ArrayList<>();

    public static void compileAllRules(Model model) {

        CharSequenceCompiler compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
        try {
            classes = compileClasses(model, compiler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fireAllRules(CTable table, Model model) throws Exception, CharSequenceCompilerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for(Class<? extends RuleClassPrototype> ruleClass:classes) {
            RuleClassPrototype ruleObject = ruleClass.getConstructor(new Class[] { CTable.class }).newInstance(new Object[] { table });
            ruleObject.eval();
        }

    }

    private static List<Class<? extends RuleClassPrototype>> compileClasses(Model model, CharSequenceCompiler compiler) throws CharSequenceCompilerException, Exception {
        List<Class<? extends RuleClassPrototype>> ruleClasses = new ArrayList<>();

        for(Rule rule:model.getRules())
        {
            Class<? extends RuleClassPrototype> ruleClass = compiler.compile(getRuleClassName(rule), fetchCodeFromRule(rule, model.getImports()), null, new Class<?>[]{ RuleClassPrototype.class });
            ruleClasses.add(ruleClass);
        }

        return ruleClasses;
    }

    /*private static String getRuleClassName(Rule rule) {

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

    private static CharSequence fetchCodeFromRule(Rule rule, List<String> imports) throws Exception
    {
        StringBuilder code = new StringBuilder();
        String lineSep = System.lineSeparator();

        // import classes
        code.append(generateImports(imports)).append(lineSep);

        // begin class
        code.append("public class Rule").append(rule.getNum()).append(" extends RuleClassPrototype {").append(lineSep).append(lineSep);

        // append vars
        code.append(generateVars(rule.getVariables())).append(lineSep);

        // append Actions Objects

        code.append(generateActionsObjects(rule.getActions())).append(lineSep);

        // make constructor
        code.append(generateConstructor(rule)).append(lineSep);

        // generate eval
        code.append(generateEval(rule)).append(lineSep);


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

    private static String generateVars(List<RuleVariable> vars) throws Exception
    {
        StringBuilder code = new StringBuilder();

        String lineSep = System.lineSeparator();

        //code.append("List<CCell> cells = new ArrayList<>();").append(System.lineSeparator());

        for(RuleVariable variable:vars) {
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
                code.append(generateActions(actions, indent + "    "));
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
                code.append(generateActions(actions, indent + "    "));
            }

            code.append(indent).append("}").append(System.lineSeparator());
        }

        return code.toString();
    }

    private static String generateAssignment(Assignment assignment, String conditionVarName) {

        StringBuilder code = new StringBuilder();

        code.append("String ").append(assignment.getIdentifier()).append(" = ").append(buildExpression(assignment.getExpression(), conditionVarName)).append(";").append(System.lineSeparator());

        return code.toString();
    }

    public static String buildExpression (List<String> expression, String variableName) {

        StringBuilder code = new StringBuilder();
        FieldAlias aliases = new FieldAlias();

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
            code.append(buildExpression(constraints.get(i).getParts(), conditionVarName));
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

    private static String generateActions(Iterator<Action> actions, String indent) {

        StringBuilder code = new StringBuilder();
        Action currentAction;

        while(actions.hasNext()) {
            currentAction = actions.next();
            if(currentAction != null) {
                code.append(indent).append(currentAction.generateCallingAction()).append(";").append(System.lineSeparator());
            }
        }

        return code.toString();

    }

/*    private static String buildConstraint(Constraint constraint, Iterator<RuleVariable> replacementVars, int flagIterator, List<Alias> aliases)
    {
        StringBuilder code = new StringBuilder();
        if(replacementVars.hasNext())
        {
            RuleVariable currentVar = replacementVars.next();
            code.append("for( ").append(currentVar.getType()).append(" ").append(replaceVarsWithAlias(currentVar.getIdentifier().toString(), aliases)).append(":").append(currentVar.getIdentifier().toString()).append(" ) {").append(System.lineSeparator());

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

        /*code.append("@Override").append(System.lineSeparator());
        code.append("public void evalRHS() {").append(System.lineSeparator());

        for(Action action:actions) {
            code.append(generateAction(action));
            code.append(action.fetchCode());
        }

        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateAction(Action action)
    {
        StringBuilder code = new StringBuilder();

        switch (action.getName())
        {
            case "Set_text": code.append(generateSetText((SetText) action)); break;
            case "Set_indent": code.append(generateSetIndent((SetIndent) action)); break;
            case "Split": code.append(generateSplit((Split) action)); break;
            case "Merge": code.append(generateMerge((Merge) action)); break;
            case "New_entry": code.append(generateNewEntry((NewEntry) action)); break;
            case "New_label": code.append(generateNewLabel((NewLabel) action)); break;
            case "Set_mark": code.append(generateSetMark((SetMark) action)); break;
            /*case "New_label": code.append(generateNewLabel(action.getParams())); break;
            case "New_entry": code.append(generateNewEntry(action.getParams())); break;
        }

        return code.toString();
    }

    private static String generateSetText(SetText action) {
        StringBuilder code = new StringBuilder();

        code.append("for(CCell cell:").append(action.getIdentifier()).append(") {").append(System.lineSeparator());
        code.append("cell.setText(").append(action.getStringExpression()).append(");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateSetIndent(SetIndent action) {
        StringBuilder code = new StringBuilder();

        code.append("for(CCell cell:").append(action.getIdentifier()).append(") {").append(System.lineSeparator());
        code.append("cell.setIndent(").append(action.getIndent()).append(");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateSplit(Split action) {
        StringBuilder code = new StringBuilder();

        code.append("for(CCell cell:)").append(action.getIdentifier()).append(") {").append(System.lineSeparator());
        code.append("for(CCell newCell:cell.split()) {").append(System.lineSeparator());
        code.append("table.addCell(newCell);").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        code.append("table.removeCell( cell );").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateMerge(Merge action) {
        StringBuilder code = new StringBuilder();

        code.append("for ( CCell cell1:").append(action.getIdentifier1()).append(" ) {").append(System.lineSeparator());
        code.append("for ( CCell cell2:").append(action.getIdentifier2()).append(" ) {").append(System.lineSeparator());
        code.append("cell1.merge( cell2 );").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        code.append("table.removeCell(cell1);").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }

    private static String generateNewEntry(NewEntry action)
    {
        StringBuilder code = new StringBuilder();

        code.append("for ( CCell item:").append(action.getIdentifier()).append(" ) {").append(System.lineSeparator());
        code.append("item.newEntry(").append(action.getStringExpression()).append(");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateNewLabel(NewLabel action)
    {
        StringBuilder code = new StringBuilder();

        code.append("for ( CCell item:").append(action.getIdentifier()).append(" ) {").append(System.lineSeparator());
        code.append("item.newLabel(").append(action.getStringExpression()).append(");").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());
        return code.toString();
    }

    private static String generateSetMark(SetMark action)
    {
        StringBuilder code = new StringBuilder();

        code.append("for ( CCell cell:").append(action.getIdentifier()).append(" ) {").append(System.lineSeparator());
        code.append("cell.setMark( ").append(action.getStringExpression()).append(" );").append(System.lineSeparator());
        code.append("}").append(System.lineSeparator());

        return code.toString();
    }*/

}
