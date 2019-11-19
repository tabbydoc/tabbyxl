/*
 * Copyright 2018-19 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
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

import org.antlr.runtime.tree.Tree;
import ru.icc.td.tabbyxl.crl2j.rulemodel.*;

import java.util.ArrayList;
import java.util.List;

public final class Ruleset {

    private List<String> importStatements = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();

    public List<String> getImportStatements() {
        return importStatements;
    }

    public List<Rule> getRules() {
        return rules;
    }

    private Ruleset() {}

    public static Ruleset createInstance(Tree ast) {

        // TODO Check a param (AST-tree)

        Ruleset ruleset = new Ruleset();
        ruleset.importStatements.addAll(ASTAnalysis.createImports(ast));
        ruleset.rules.addAll(ASTAnalysis.createRules(ast));

        return ruleset;
    }

    private static class ASTAnalysis {

        static List<String> createImports(Tree ast) {

            List<String> imports = new ArrayList<>();

            for (int i = 0; i < ast.getChildCount(); i++) {
                Tree subtree = ast.getChild(i);

                if (subtree.getText().equals("IMPORTS")) {
                    for (int j = 0; j < subtree.getChildCount(); j++) {
                        imports.add(subtree.getChild(j).getText());
                    }
                }
            }

            return imports;
        }

        static List<Rule> createRules(Tree ast) {

            List<Rule> rules = new ArrayList<>();

            for (int i = 0; i < ast.getChildCount(); i++) {
                Tree subTree = ast.getChild(i);

                if (subTree.getText().equals("RULES")) {
                    for (int j = 0; j < subTree.getChildCount(); j++) {
                        rules.add(createRule(subTree.getChild(j)));
                    }
                }
            }

            return rules;
        }

        private static Rule createRule(Tree tree) {

            Rule rule = new Rule();

            rule.setId(Integer.parseInt(tree.getText()));

            for (int i = 0; i < tree.getChildCount(); i++) {
                Tree subtree = tree.getChild(i);

                if (subtree.getText().equals("CONDITIONS")) {

                    for (int j = 0; j < subtree.getChildCount(); j++) {
                        rule.addCondition(createCondition(subtree.getChild(j), j + 1));
                    }
                } else if (subtree.getText().equals("ACTIONS")) {

                    for (int j = 0; j < subtree.getChildCount(); j++) {
                        rule.addAction(createAction(subtree.getChild(j)));
                    }
                }
            }

            return rule;
        }

        private static Condition createCondition(Tree tree, int id) {

            Condition condition = new Condition();

            condition.setId(id);
            condition.setConditionType(Condition.ConditionType.valueOf(tree.getChild(0).getText()));
            condition.setDataType(Condition.DataType.valueOf(tree.getChild(1).getText()));

            if (tree.getChild(2).getText().equals("null")) {
                condition.setIdentifier("id" + id);
            } else {
                condition.setIdentifier(tree.getChild(2).getText());
            }

            Tree constraintsTree = tree.getChild(3);
            for (int i = 0; i < constraintsTree.getChildCount(); i++) {
                Tree subTree = constraintsTree.getChild(i);
                condition.addConstraint(createConstraint(subTree));
            }

            Tree assignmentTree = tree.getChild(4);
            if (assignmentTree.getChildCount() > 0)
                condition.addAssignment(createAssignment(assignmentTree));

            return condition;
        }

        private static Constraint createConstraint(Tree tree) {

            Constraint constraint = new Constraint();

            for (int i = 0; i < tree.getChildCount(); i++) {
                constraint.addExpression(tree.getChild(i).getText());
            }

            return constraint;
        }

        private static Assignment createAssignment(Tree tree) {

            Assignment assignment = new Assignment();

            assignment.setIdentifier(tree.getChild(0).getText());

            for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
                assignment.addExpression(tree.getChild(1).getChild(i).getText());
            }

            return assignment;
        }

        private static Action createAction(Tree tree) {

            Action action = new Action();
            action.setType(Action.Type.valueOf(tree.getText()));

            List<Operand> operands = new ArrayList<>();

            for (int i = 0; i < tree.getChildCount(); i++) {
                Tree subTree = tree.getChild(i);

                List<String> expressions = new ArrayList<>();
                for (int j = 0; j < subTree.getChildCount(); j++) {
                    expressions.add(subTree.getChild(j).getText());
                }
                Operand operand = new Operand();
                operand.setExpressions(expressions);
                operands.add(operand);
            }

            action.setOperands(operands);

            return action;
        }
    }
}
