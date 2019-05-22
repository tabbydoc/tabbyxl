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

import org.antlr.runtime.tree.Tree;

import ru.icc.td.tabbyxl.crl2j.rulemodel.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RuleModelBuilder {

    public static List<String> buildImports(Tree ast) {

        List<String> imports = new ArrayList<>();

        for (int i = 0; i < ast.getChildCount(); i ++) {

            Tree subtree = ast.getChild(i);
            if (subtree.getText().equals("Imports")) {

                for (int j = 0; j < subtree.getChildCount(); j ++) {
                    imports.add(subtree.getChild(j).getText());
                }
            }
        }

        return imports;
    }

    public static List<Rule> buildRules(Tree ast) {

        List<Rule> rules = new ArrayList<>();

        for (int i = 0; i < ast.getChildCount(); i ++) {
            Tree subtree = ast.getChild(i);

            if (subtree.getText().equals("RULES")) {

                for (int j = 0; j < subtree.getChildCount(); j ++) {

                    rules.add(buildRule(subtree.getChild(j)));
                }
            }
        }

        return rules;
    }

    private static Rule buildRule(Tree tree) {

        Rule rule = new Rule();

        rule.setId(Integer.parseInt(tree.getText()));

        for (int i = 0; i < tree.getChildCount(); i ++) {

            Tree subtree = tree.getChild(i);
            if (subtree.getText().equals("Conditions")) {

                for (int j = 0; j < subtree.getChildCount(); j ++) {
                    rule.addCondition(buildCondition(subtree.getChild(j), j + 1));
                }
            } else if (subtree.getText().equals("Actions")) {

                for (int j = 0; j < subtree.getChildCount(); j ++) {
                    rule.addAction(buildAction(subtree.getChild(j)));
                }
            }
        }

        return rule;
    }

    private static Condition buildCondition(Tree tree, int id) {

        Condition condition = new Condition();

        condition.setId(id);

        switch (tree.getChild(0).getText()) {
            case("cell"):
                condition.setDataType(Condition.DataType.CCell);
                break;
            case("no cells"):
                condition.setDataType(Condition.DataType.CCell);
                condition.setNotExistsCondition(true);
                break;
            case("label"):
                condition.setDataType(Condition.DataType.CLabel);
                break;
            case("no labels"):
                condition.setDataType(Condition.DataType.CLabel);
                condition.setNotExistsCondition(true);
                break;
            case("entry"):
                condition.setDataType(Condition.DataType.CEntry);
                break;
            case("no entries"):
                condition.setDataType(Condition.DataType.CEntry);
                condition.setNotExistsCondition(true);
                break;
            case("category"):
                condition.setDataType(Condition.DataType.CCategory);
                break;
            case("no categories"):
                condition.setDataType(Condition.DataType.CCategory);
                condition.setNotExistsCondition(true);
                break;
            default: break;
        }

        if (tree.getText().equals("Condition")) {
            condition.setIdentifier(tree.getChild(1).getText());
        } else {
            condition.setIdentifier(String.format("ident%s", id));
        }

        for (int i = 0; i < tree.getChildCount(); i ++) {
            Tree subTree = tree.getChild(i);
            if (subTree.getText().equals("Constraint")) {
                condition.addConstraint(buildConstraint(subTree));
            } else if (subTree.getText().equals("Assignment")) {
                condition.addAssignment(buildAssignment(subTree));
            }
        }

        return condition;
    }

    private static Constraint buildConstraint(Tree tree) {

        Constraint constraint = new Constraint();

        for (int i = 0; i < tree.getChildCount(); i ++) {
            constraint.addExpression(tree.getChild(i).getText());
        }

        return constraint;
    }

    private static Assignment buildAssignment(Tree tree) {

        Assignment assignment = new Assignment();

        assignment.setIdentifier(tree.getChild(0).getChild(0).getText());

        for (int i = 0; i < tree.getChild(1).getChildCount(); i ++) {
            assignment.addExpression(tree.getChild(1).getChild(i).getText());
        }

        return assignment;
    }

    private static Action buildAction(Tree tree) {

        Action action = new Action();
        action.setType(Action.Type.valueOf(tree.getText()));

        List<Operand> operands = new ArrayList<>();

        for (int i = 0; i < tree.getChildCount(); i ++) {
            Tree subTree = tree.getChild(i);

            List<String> expressions = new ArrayList<>();
            for (int j = 0; j < subTree.getChildCount(); j ++) {
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
