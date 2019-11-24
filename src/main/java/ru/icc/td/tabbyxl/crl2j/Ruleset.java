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
import ru.icc.td.tabbyxl.model.COwned;

import java.util.ArrayList;
import java.util.List;

final class Ruleset {

    private List<StaticImportDescriptor> staticImportDescriptors = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();

    public List<StaticImportDescriptor> getStaticImportDescriptors() {
        return staticImportDescriptors;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public Ruleset(Tree ast) {
        staticImportDescriptors.addAll(Constructor.createStaticImportDescriptors(ast));
        try {
            rules.addAll(Constructor.createRules(ast));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static final class Constructor {

        static List<StaticImportDescriptor> createStaticImportDescriptors(Tree ast) {

            List<StaticImportDescriptor> staticImportDescriptors = new ArrayList<>();

            for (int i = 0; i < ast.getChildCount(); i++) {
                Tree subtree = ast.getChild(i);

                if (subtree.getText().equals("IMPORTS")) {
                    for (int j = 0; j < subtree.getChildCount(); j++) {
                        String statement = subtree.getChild(j).getText();
                        StaticImportDescriptor importDesc = StaticImportDescriptor.parseStaticImportStatement(statement);
                        if (null != importDesc)
                            staticImportDescriptors.add(importDesc);
                    }
                }
            }

            return staticImportDescriptors;
        }

        static List<Rule> createRules(Tree ast) throws ClassNotFoundException {

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

        static Rule createRule(Tree tree) throws ClassNotFoundException {

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

        static Condition createCondition(Tree tree, int id) throws ClassNotFoundException {

            Condition condition = new Condition();

            condition.setId(id);
            condition.setQuantifier(Condition.Quantifier.valueOf(tree.getChild(0).getText()));

            String simpleClassName = tree.getChild(1).getText();
            Class<COwned> queriedDataType = (Class<COwned>) Class.forName("ru.icc.td.tabbyxl.model." + simpleClassName);
            condition.setDataType(queriedDataType);

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

        static Constraint createConstraint(Tree tree) {

            Constraint constraint = new Constraint();

            for (int i = 0; i < tree.getChildCount(); i++) {
                constraint.addToken(tree.getChild(i).getText());
            }

            return constraint;
        }

        static Assignment createAssignment(Tree tree) {

            Assignment assignment = new Assignment();

            assignment.setIdentifier(tree.getChild(0).getText());

            for (int i = 0; i < tree.getChild(1).getChildCount(); i++) {
                assignment.addExpression(tree.getChild(1).getChild(i).getText());
            }

            return assignment;
        }

        static Action createAction(Tree tree) {

            Action action = new Action();
            action.setMethodName(tree.getText());

            List<Operand> operands = new ArrayList<>();

            for (int i = 0; i < tree.getChildCount(); i++) {
                Tree subTree = tree.getChild(i);

                Operand operand = new Operand();
                for (int j = 0; j < subTree.getChildCount(); j++) {
                    operand.addToken(subTree.getChild(j).getText());
                }

                operands.add(operand);
            }

            action.setOperands(operands);

            return action;
        }
    }
}
