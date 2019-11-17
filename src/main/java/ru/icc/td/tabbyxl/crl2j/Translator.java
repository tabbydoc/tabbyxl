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

package ru.icc.td.tabbyxl.crl2j;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.lang.StringUtils;
import ru.icc.td.tabbyxl.crl2j.parsing.CRLLexer;
import ru.icc.td.tabbyxl.crl2j.parsing.CRLParser;
import ru.icc.td.tabbyxl.crl2j.rulemodel.*;
import ru.icc.td.tabbyxl.model.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

public final class Translator {

    private List<String> imports = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();
    private String pack = "ru.icc.td.tabbyxl.crl2j.synthesis";

    private static final String newLine = System.lineSeparator();
    private static final String indent = StringUtils.repeat(" ", 4);
    private static final String filler = StringUtils.repeat("=", 100);

    //private Translator0 translator0;

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public void loadRuleset(File crlFile) throws IOException, RecognitionException {

        ANTLRFileStream fileStream = new ANTLRFileStream(crlFile.getPath());
        CRLLexer lexer = new CRLLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CRLParser parser = new CRLParser(tokenStream);
        CommonTree ast = (CommonTree) parser.crl().getTree();

        imports = RuleModelBuilder.buildImports(ast);
        rules = RuleModelBuilder.buildRules(ast);
    }

    public List<String> translateRuleset() {

        System.out.println("This Java source code was generated from the ruleset");
        System.out.println();
        System.out.println(filler);

        List<String> result = new ArrayList<>();

        for (Rule rule : rules) {
            String sourceCode = translateRule(rule);

            // Print the source code generated from a ruleset
            System.out.println(sourceCode);
            System.out.println(filler);

            result.add(sourceCode);
        }

        return result;
    }

    private String translateRule(Rule rule) {
        return new RuleTranslator(rule).fetchSourceCode();
    }

    private class RuleTranslator {
        private final HashMap<String, String> variables = new HashMap<>();
        private final List<Class> classes = new ArrayList<>();
        private final List<Field> fields = new ArrayList<>();

        private final Rule rule;

        private RuleTranslator(Rule rule) {
            this.rule = rule;

            List<Condition> conditions = rule.getConditions();

            for (Condition condition: conditions) {
                variables.put(condition.getIdentifier(), condition.getDataType().toString());
            }

            // TODO Добавить необходимые классы в список classes
            classes.add(CCell.class);
            classes.add(COwned.class);
            classes.add(CItem.class);
            classes.add(CEntry.class);
            classes.add(CLabel.class);
            classes.add(CCategory.class);

            for (Class c: classes) {
                fields.addAll(Arrays.asList(c.getDeclaredFields()));
            }
        }

        private String fetchSourceCode() {

            StringBuilder sourceCode = new StringBuilder();

            // Add a package
            sourceCode.append(fetchPackageStatement());

            // Add imports
            sourceCode.append(fetchMandatoryImportStatements());
            String ruleImportStatements = fetchRuleImportStatements();
            if (null != ruleImportStatements)
                sourceCode.append(ruleImportStatements);
            sourceCode.append(newLine);

            // Add a class declaration
            sourceCode.append(fetchClassDeclaration());

            //translator0 = new Translator0(rule.getConditions());

            // Add a constructor
            sourceCode.append(fetchConstructor());
            sourceCode.append(newLine);

            // Add "eval()" method
            sourceCode.append(fetchEvalMethod());

            // Finish class
            sourceCode.append("}").append(newLine);

            return sourceCode.toString();
        }

        private String fetchPackageStatement() {
            return new StringBuilder()
                    .append("package ")
                    .append(pack)
                    .append(";")
                    .append(newLine)
                    .append(newLine)
                    .toString();
        }

        private String fetchMandatoryImportStatements() {
            return new StringBuilder()
                    .append("import ru.icc.td.tabbyxl.crl2j.synthesis.RuleProgramPrototype;").append(newLine)
                    .append("import ru.icc.td.tabbyxl.model.*;").append(newLine)
                    .append("import ru.icc.td.tabbyxl.model.style.*;").append(newLine)
                    .append("import static ru.icc.td.tabbyxl.model.NerTag.*;").append(newLine)
                    .append("import static ru.icc.td.tabbyxl.model.TypeTag.*;").append(newLine)
                    .append("import java.util.*;").append(newLine)
                    .toString();
        }

        private String fetchRuleImportStatements() {
            if (imports.isEmpty()) return null;

            StringBuilder sb = new StringBuilder();
            for (String importItem : imports)
                sb.append(importItem).append(";").append(newLine);

            return sb.toString();
        }

        private String fetchClassDeclaration() {
            return new StringBuilder()
                    .append("public class Rule")
                    .append(rule.getId())
                    .append(" extends RuleProgramPrototype {")
                    .append(newLine)
                    .toString();
        }

        private String fetchConstructor() {
            return new StringBuilder()
                    .append(fetchIndent(1))
                    .append("public Rule")
                    .append(rule.getId())
                    .append(" (CTable table) {")
                    .append(newLine)
                    .append(fetchIndent(2))
                    .append("super(table);")
                    .append(newLine)
                    .append(fetchIndent(1))
                    .append("}")
                    .append(newLine)
                    .toString();
        }

        private String fetchEvalMethod() {
            StringBuilder code = new StringBuilder();

            code
                    .append(fetchIndent(1))
                    .append("@Override").append(newLine)
                    .append(fetchIndent(1))
                    .append("public void eval () {").append(newLine)
                    .append(generateCondition(rule.getConditions().iterator(), rule.getActions().iterator(), 2))
                    .append(fetchIndent(1))
                    .append("}").append(newLine);

            return code.toString();
        }

        private String generateCondition(Iterator<Condition> conditions, Iterator<Action> actions, int level) {
            StringBuilder code = new StringBuilder();

            Condition currentCondition = conditions.next();

            code
                    .append(fetchIndent(level))
                    .append("Iterator<")
                    .append(currentCondition.getDataType())
                    .append("> ")
                    .append(currentCondition.getIdentifier())
                    .append("Iterator = ");

            switch (currentCondition.getDataType()) {

                case CCell:
                    code.append("getTable().getCells();");
                    break;
                case CLabel:
                    code.append("getTable().getLabels();");
                    break;
                case CEntry:
                    code.append("getTable().getEntries();");
                    break;
                case CCategory:
                    code.append("getTable().getLocalCategoryBox().getCategories();");
                    break;
                default:
                    break;
            }

            code.append(newLine);

            if (!currentCondition.isNotExistsCondition()) {
                code
                        .append(fetchIndent(level))
                        .append("while ( ")
                        .append(currentCondition.getIdentifier())
                        .append("Iterator.hasNext() ) {").append(newLine)
                        .append(fetchIndent(level + 1))
                        .append(currentCondition.getDataType())
                        .append(" ")
                        .append(currentCondition.getIdentifier())
                        .append(" = ")
                        .append(currentCondition.getIdentifier())
                        .append("Iterator.next();").append(newLine);

                code.append(fetchIndent(level + 1)).append("if ( ");

                if (currentCondition.getConstraints().size() != 0) {
                    code.append(generateConstraints(currentCondition.getConstraints(), currentCondition.getIdentifier()));
                } else {
                    code.append("true");
                }

                code.append(" ) {").append(newLine);

                for (Assignment assignment : currentCondition.getAssignments()) {
                    code.append(fetchIndent(level + 2)).append(generateAssignment(assignment, currentCondition.getIdentifier()));
                }

                if (conditions.hasNext()) {
                    code.append(generateCondition(conditions, actions, level + 2));
                } else {
                    code.append(generateActions(actions, level + 2));
                }

                code.append(fetchIndent(level + 1)).append("}").append(newLine);
                code.append(fetchIndent(level)).append("}").append(newLine);
            } else {

                code
                        .append(fetchIndent(level))
                        .append("boolean $flag")
                        .append(currentCondition.getId())
                        .append(" = true;").append(newLine);

                code
                        .append(fetchIndent(level))
                        .append("while ( ")
                        .append(currentCondition.getIdentifier())
                        .append("Iterator.hasNext() ) {").append(newLine);

                code
                        .append(fetchIndent(level + 1))
                        .append(currentCondition.getDataType())
                        .append(" ")
                        .append(currentCondition.getIdentifier())
                        .append(" = ")
                        .append(currentCondition.getIdentifier())
                        .append("Iterator.next();").append(newLine);

                code
                        .append(fetchIndent(level + 1))
                        .append("if ( ");

                if (currentCondition.getConstraints().size() != 0) {
                    code.append(generateConstraints(currentCondition.getConstraints(), currentCondition.getIdentifier()));
                } else {
                    code.append("false");
                }

                code
                        .append(" ) {").append(newLine);

                code
                        .append(fetchIndent(level + 2))
                        .append("$flag")
                        .append(currentCondition.getId())
                        .append(" = false;").append(newLine);

                code
                        .append(fetchIndent(level + 2))
                        .append("break;")
                        .append(newLine);

                code
                        .append(fetchIndent(level + 1))
                        .append("}").append(newLine);

                code
                        .append(fetchIndent(level))
                        .append("}").append(newLine);

                code
                        .append(fetchIndent(level))
                        .append("if ( $flag")
                        .append(currentCondition.getId())
                        .append(" ) {").append(newLine);

                if (conditions.hasNext()) {
                    code.append(generateCondition(conditions, actions, level + 1));
                } else {
                    code.append(generateActions(actions, level + 1));
                }

                code.append(fetchIndent(level)).append("}").append(newLine);
            }

            return code.toString();
        }

        private String generateConstraints(List<Constraint> constraints, String conditionVarName) {

            StringBuilder code = new StringBuilder();

            for (int i = 0; i < constraints.size(); i++) {

                code
                        .append("( ")
                        .append(translateExpressions(constraints.get(i).getExpressions(), conditionVarName))
                        .append(" )");

                if (i < constraints.size() - 1) code.append(" && ");
            }

            return code.toString();

        }

        private String generateAssignment(Assignment assignment, String conditionVarName) {

            StringBuilder code = new StringBuilder();

            code
                    .append("String ")
                    .append(assignment.getIdentifier())
                    .append(" = String.valueOf( ")
                    .append(translateExpressions(assignment.getExpressions(), conditionVarName))
                    .append(" );").append(newLine);

            return code.toString();
        }

        private String generateActions(Iterator<Action> actions, int level) {

            StringBuilder code = new StringBuilder();

            while (actions.hasNext()) {
                Action action = actions.next();

                if (action.getType().equals(Action.Type.update)) continue;

                List<Operand> operands = action.getOperands();

                code
                        .append(fetchIndent(level))
                        .append(translateExpressions(operands.get(0).getExpressions(), ""))
                        .append(".")
                        .append(action.getType())
                        .append("(");

                if (operands.size() > 1) {
                    for (int i = 1; i < operands.size(); i++) {
                        code.append(translateExpressions(operands.get(i).getExpressions(), ""));
                        if (i < operands.size() - 1) code.append(", ");
                    }
                }

                code.append(");").append(newLine);

                if (action.getType().equals(Action.Type.split) || action.getType().equals(Action.Type.merge))
                    code.append(fetchIndent(level)).append(updateIterators("CCell", level));
            }

            return code.toString();
        }

        private String fetchIndent(int level) {
            StringBuilder indent = new StringBuilder();
            for (int i = 0; i < level; i++) {
                indent.append(Translator.indent);
            }
            return indent.toString();
        }

        public String updateIterators(String className, int level) {

            StringBuilder code = new StringBuilder();

            Iterator<String> keys = variables.keySet().iterator();

            while (keys.hasNext()) {
                String key = keys.next();
                if (variables.get(key).equals(className)) {

                    code
                            .append(fetchIndent(level))
                            .append(key)
                            .append("Iterator = getTable().");

                    switch (className) {
                        case "CCell":
                            code.append("getCells();");
                            break;
                        case "CLabel":
                            code.append("getLabels();");
                            break;
                        case "CEntry":
                            code.append("getEntries();");
                            break;
                        case "CCategory":
                            code.append("getLocalCategoryBox().getCategories();");
                            break;
                        default:
                            break;
                    }

                    code.append(newLine);
                }
            }

            return code.toString();
        }

        String translateExpressions(List<String> expressions, String variable) {

            StringBuilder code = new StringBuilder();

            for (int i = 0; i < expressions.size(); i ++) {

                String expression = expressions.get(i);
                boolean fieldFounded = false;
                String methodName = "";

                for (Field field: fields) {

                    if (field.isEnumConstant()) continue;

                    if (field.getName().equals(expression)) {

                        fieldFounded = true;
                        String fieldType = field.getType().getName();

                        String e1 = expression.substring(0, 1).toUpperCase();
                        String e2 = expression.substring(1, expression.length());

                        if ( !fieldType.equals("boolean"))
                            methodName = String.format("get%s%s", e1, e2);
                        else
                            methodName = String.format("is%s%s", e1, e2);

                        break;
                    }
                }

                if (fieldFounded) {
                    if (i < 2) {
                        code.append(variable).append(".").append(methodName);
                    } else {
                        if(!expressions.get(i - 1).equals("."))
                            code.append(variable).append(".").append(methodName);
                        else
                            code.append(methodName);
                    }

                    if( i > expressions.size() - 3) {
                        code.append("()");
                    } else {
                        if(expressions.get(i + 1).equals("[") && expressions.get(i + 3).equals("]")) {
                            code.append("(").append(expressions.get(i + 2)).append(")");
                            i = i + 3;
                        } else {
                            code.append("()");
                        }
                    }
                } else {
                    code.append(expression);
                }

            }

            return code.toString();
        }
    }

}
