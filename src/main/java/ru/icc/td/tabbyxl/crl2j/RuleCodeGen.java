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
import ru.icc.td.tabbyxl.crl2j.parsing.CrlLexer;
import ru.icc.td.tabbyxl.crl2j.parsing.CrlParser;
import ru.icc.td.tabbyxl.crl2j.rulemodel.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class RuleCodeGen {

    private List<String> imports = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();
    private String pack = "ru.icc.td.tabbyxl.crl2j.synthesis";

    private final String LINE_SEP = System.lineSeparator();
    private final String INDENT = "    ";

    private Translator translator;

    public String getPack() {
        return pack;
    }
    public void setPack(String pack) { this.pack = pack; }

    public int getRulesCount() { return rules.size(); }

    public void loadRuleset (File ruleset) throws IOException, RecognitionException {

        ANTLRFileStream fileStream = new ANTLRFileStream(ruleset.getPath());
        CrlLexer lexer = new CrlLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CrlParser parser = new CrlParser(tokenStream);
        CommonTree ast = (CommonTree) parser.crl().getTree();

        imports = RuleModelBuilder.buildImports(ast);
        rules = RuleModelBuilder.buildRules(ast);

        // print rules
        System.out.println("This Java source code was generated from the ruleset");
        System.out.println();
        for (Rule rule: rules) {
            System.out.println(fetchCodeFromRule(rule));
        }
        System.out.println();

    }

    public List<String> generateCodeFromAllRules() {

        List<String> result = new ArrayList<>();
        for (Rule rule: rules) {
            result.add(fetchCodeFromRule(rule));
        }

        return result;
    }

    private String fetchCodeFromRule(Rule rule) {

        StringBuilder code = new StringBuilder();
        translator = new Translator(rule.getConditions(), imports);

        // set package
        code.append("package ").append(pack).append(";").append(LINE_SEP)
            .append(LINE_SEP);

        // add imports
        code.append("import ru.icc.td.tabbyxl.crl2j.synthesis.RuleProgramPrototype;").append(LINE_SEP);
        for (String importItem: imports) {
            code.append(importItem).append(";").append(LINE_SEP);
        }
        code.append("import java.util.*;").append(LINE_SEP);
        code.append(LINE_SEP);

        // begin class
        code.append("public class Rule").append(rule.getId()).append(" extends RuleProgramPrototype {").append(LINE_SEP);

        // append constructor
        code.append(generateConstructor(rule.getId())).append(LINE_SEP);

        // override method eval()
        code.append(generateEval(rule)).append(LINE_SEP);

        // finish class
        code.append("}");

        return code.toString();
    }

    private String generateConstructor (int id) {
        StringBuilder code = new StringBuilder();

        code
                .append(fetchIndent(1)).append("public Rule").append(id).append(" (CTable table) {").append(LINE_SEP)
                .append(fetchIndent(2)).append("super(table);").append(LINE_SEP)
                .append(fetchIndent(1)).append("}").append(LINE_SEP);

        return code.toString();
    }

    private String generateEval(Rule rule) {
        StringBuilder code = new StringBuilder();

        code
                .append(fetchIndent(1)).append("@Override").append(LINE_SEP)
                .append(fetchIndent(1)).append("public void eval () {").append(LINE_SEP)
                .append(generateCondition(rule.getConditions().iterator(), rule.getActions().iterator(), 2)).append(LINE_SEP)
                .append(fetchIndent(1)).append("}").append(LINE_SEP);

        return code.toString();
    }

    private String generateCondition(Iterator<Condition> conditions, Iterator<Action> actions, int level) {
        StringBuilder code = new StringBuilder();

        Condition currentCondition = conditions.next();

        code.append(fetchIndent(level)).append("Iterator<").append(currentCondition.getDataType()).append("> ").append(currentCondition.getIdentifier()).append("Iterator = ");

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

        code.append(LINE_SEP);

        if (!currentCondition.isNotExistsCondition()) {
            code
                    .append(fetchIndent(level)).append("while ( ").append(currentCondition.getIdentifier()).append("Iterator.hasNext() ) {").append(LINE_SEP)
                    .append(fetchIndent(level + 1)).append(currentCondition.getDataType()).append(" ").append(currentCondition.getIdentifier()).append(" = ").append(currentCondition.getIdentifier()).append("Iterator.next();").append(LINE_SEP);

            code.append(fetchIndent(level + 1)).append("if ( ");

            if(currentCondition.getConstraints().size()!=0) {
                code.append(generateConstraints(currentCondition.getConstraints(), currentCondition.getIdentifier()));
            } else {
                code.append("true");
            }

            code.append(" ) {").append(LINE_SEP);

            for(Assignment assignment:currentCondition.getAssignments()) {
                code.append(fetchIndent(level + 2)).append(generateAssignment(assignment, currentCondition.getIdentifier()));
            }

            if (conditions.hasNext()) {
                code.append(generateCondition(conditions, actions, level + 2));
            } else {
                code.append(generateActions(actions, level + 2));
            }

            code.append(fetchIndent(level + 1)).append("}").append(LINE_SEP);
            code.append(fetchIndent(level)).append("}").append(LINE_SEP);
        }
        else {

            code.append(fetchIndent(level)).append("boolean $flag").append(currentCondition.getId()).append(" = true;").append(LINE_SEP);
            code.append(fetchIndent(level)).append("while ( ").append(currentCondition.getIdentifier()).append("Iterator.hasNext() ) {").append(LINE_SEP);

            code.append(fetchIndent(level + 1)).append(currentCondition.getDataType()).append(" ").append(currentCondition.getIdentifier()).append(" = ").append(currentCondition.getIdentifier()).append("Iterator.next();").append(System.lineSeparator());

            code.append(fetchIndent(level + 1)).append("if ( ");

            if(currentCondition.getConstraints().size()!=0) {
                code.append(generateConstraints(currentCondition.getConstraints(), currentCondition.getIdentifier()));
            } else {
                code.append("false");
            }

            code.append(" ) {").append(System.lineSeparator());


            code.append(fetchIndent(level + 2)).append("$flag").append(currentCondition.getId()).append(" = false;").append(System.lineSeparator());
            code.append(fetchIndent(level + 2)).append("break;").append(System.lineSeparator());

            code.append(fetchIndent(level + 1)).append("}").append(System.lineSeparator());

            code.append(fetchIndent(level)).append("}").append(System.lineSeparator());

            code.append(fetchIndent(level)).append("if ( $flag").append(currentCondition.getId()).append(" ) {").append(System.lineSeparator());

            if(conditions.hasNext()) {
                code.append(generateCondition(conditions, actions, level + 1));
            } else {
                code.append(generateActions(actions, level + 1));
            }

            code.append(fetchIndent(level)).append("}").append(System.lineSeparator());
        }

        return code.toString();
    }

    private String generateConstraints(List<Constraint> constraints, String conditionVarName) {

        StringBuilder code = new StringBuilder();

        for( int i=0; i<constraints.size(); i++ ) {

            code.append("( ").append(translator.translateExpressions(constraints.get(i).getExpressions(), conditionVarName)).append(" )");

            if(i<constraints.size()-1) code.append(" && ");
        }

        return code.toString();

    }

    private String generateAssignment(Assignment assignment, String conditionVarName) {

        StringBuilder code = new StringBuilder();

        code.append("String ").append(assignment.getIdentifier()).append(" = String.valueOf( ").append(translator.translateExpressions(assignment.getExpressions(), conditionVarName)).append(" );").append(LINE_SEP);

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
                    .append(translator.translateExpressions(operands.get(0).getExpressions(), ""))
                    .append(".").append(action.getType()).append("(");
            if (operands.size()>1) {
                for (int i = 1; i < operands.size(); i ++) {
                    code.append(translator.translateExpressions(operands.get(i).getExpressions(), ""));
                    if (i < operands.size() - 1) code.append(", ");
                }
            }
            code.append(");").append(LINE_SEP);

            if (action.getType().equals(Action.Type.split) || action.getType().equals(Action.Type.merge))
                code.append(fetchIndent(level)).append(updateIterators("CCell", level));
        }

        return code.toString();
    }

    private String fetchIndent(int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i ++) {
            indent.append(INDENT);
        }
        return indent.toString();
    }

    public String updateIterators(String className, int level) {

        StringBuilder code = new StringBuilder();

        Iterator<String> keys = translator.getVariables().keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            if (translator.getVariables().get(key).equals(className)) {
                code.append(fetchIndent(level)).append(key).append("Iterator = getTable().");

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

                code.append(System.lineSeparator());
            }
        }

        return code.toString();

    }
}
