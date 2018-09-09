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

package ru.icc.td.tabbyxl2.crl2j;

import org.antlr.runtime.tree.Tree;
import ru.icc.td.tabbyxl2.crl2j.rulemodel.Condition;
import ru.icc.td.tabbyxl2.crl2j.rulemodel.*;
import ru.icc.td.tabbyxl2.crl2j.rulemodel.actions.*;

public class RuleModelBuilder {

    private Ruleset ruleset;

    public Ruleset getRuleset() {
        return ruleset;
    }

    public RuleModelBuilder() {
        ruleset = new Ruleset();
    }

    public void buildModel(Tree ast) {
        try {
            for (int i = 0; i < ast.getChildCount(); i++) {
                if (ast.getChild(i).getText() == "Imports") buildImports(ast.getChild(i));
                else if (ast.getChild(i).getText() == "RULES")
                    buildAllRules(ast.getChild(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildImports(Tree subTree) {
        for (int i = 0; i < subTree.getChildCount(); i++) {
            ruleset.addImport(subTree.getChild(i).getText());
        }
    }

    private void buildAllRules(Tree subTree) {
        for (int i = 0; i < subTree.getChildCount(); i++) {
            ruleset.addRule(buildRule(subTree.getChild(i)));
        }
    }

    private Rule buildRule(Tree subTree) {
        Rule rule = new Rule(Integer.parseInt(subTree.getText()));

        for (int i = 0; i < subTree.getChildCount(); i++) {
            if (subTree.getChild(i).getText() == "Conditions") {
                addConditionsToRule(subTree.getChild(i), rule);
            } else if (subTree.getChild(i).getText() == "Actions") {
                addActionsToRule(subTree.getChild(i), rule);
            }
        }

        return rule;
    }

    private void addConditionsToRule(Tree subTree, Rule rule) {
        for (int i = 0; i < subTree.getChildCount(); i++) {
            if (subTree.getChild(i).getText() == "Condition" || subTree.getChild(i).getText() == "No_condition") {
                Condition condition = buildCondition(i + 1, subTree.getChild(i));
                rule.addCondition(condition);
                if (condition.getVariable() != null)
                    rule.addVariable(condition.getVariable());
            }
        }
    }

    private Condition buildCondition(int id, Tree subTree) {
        Condition condition = new Condition(id);

        switch (subTree.getChild(0).getText()) {
            case "cell":
                condition.setType("condition");
                condition.setVariable(new Variable("CCell", subTree.getChild(1).getText()));
                break;
            case "label":
                condition.setType("condition");
                condition.setVariable(new Variable("CLabel", subTree.getChild(1).getText()));
                break;
            case "entry":
                condition.setType("condition");
                condition.setVariable(new Variable("CEntry", subTree.getChild(1).getText()));
                break;
            case "category":
                condition.setType("condition");
                condition.setVariable(new Variable("Category", subTree.getChild(1).getText()));
                break;
            case "no cells":
                condition.setType("no_condition");
                condition.setVariable(new Variable("CCell", "$id" + condition.getId()));
                break;
            case "no labels":
                condition.setType("no_condition");
                condition.setVariable(new Variable("CLabel", "$id" + condition.getId()));
                break;
            case "no entries":
                condition.setType("no_condition");
                condition.setVariable(new Variable("CEntry", "$id" + condition.getId()));
                break;
            case "no categories":
                condition.setType("no_condition");
                condition.setVariable(new Variable("CCategory", "$id" + condition.getId()));
                break;
            default:
                condition.setType(subTree.getChild(0).getText());
        }

        for (int i = 0; i < subTree.getChildCount(); i++) {
            if (subTree.getChild(i).getText() == "Constraint") {
                addConstraintToCondition(subTree.getChild(i), condition);
            } else if (subTree.getChild(i).getText() == "Assignment") {
                addAssignmentToCondition(subTree.getChild(i), condition);
            }
        }

        return condition;
    }

    /*private NoCondition buildNoCondition(int id, Tree subTree) {

        NoCondition noCondition = new NoCondition(id, subTree.getChild(0).getText());

        for(int i=1; i<subTree.getChildCount(); i++) {
            if(subTree.getChild(i).getText()=="Constraint") addConstraintToCondition(subTree.getChild(i), noCondition);
            else if(subTree.getChild(i).getText()=="Assignment") addAssignmentToCondition(subTree.getChild(i), noCondition);
        }

        return noCondition;
    }*/

    private void addConstraintToCondition(Tree subTree, Condition condition) {
        Constraint constraint = new Constraint();
        for (int i = 0; i < subTree.getChildCount(); i++)
            constraint.addPart(subTree.getChild(i).getText());
        condition.addConstraint(constraint);
    }

    private void addAssignmentToCondition(Tree subTree, Condition condition) {
        Assignment assignment = new Assignment(subTree.getChild(0).getChild(0).getText());

        for (int i = 0; i < subTree.getChild(1).getChildCount(); i++)
            assignment.addExpressionPart(subTree.getChild(1).getChild(i).getText());

        condition.addAssignment(assignment);
    }


    private void addActionsToRule(Tree subTree, Rule rule) {

        for (int i = 0; i < subTree.getChildCount(); i++) {
            rule.addAction(buildAction(subTree.getChild(i), i + 1));
        }

    }

    private Action buildAction(Tree subTree, int id) {

        switch (subTree.getText()) {
            case "SetMarkAction":
                return buildSetMarkAction(id, subTree);
            case "SetTextAction":
                return buildSetTextAction(id, subTree);
            case "SetIndentAction":
                return buildSetIndentAction(id, subTree);
            case "SetValueAction":
                return buildSetValueAction(id, subTree);
            case "SetCategoryAction":
                return buildSetCategoryAction(id, subTree);
            case "SetParentAction":
                return buildSetParentAction(id, subTree);
            case "SplitAction":
                return buildSplitAction(id, subTree);
            case "MergeAction":
                return buildMergeAction(id, subTree);
            case "GroupAction":
                return buildGroupAction(id, subTree);
            case "NewEntryAction":
                return buildNewEntryAction(id, subTree);
            case "NewLabelAction":
                return buildNewLabelAction(id, subTree);
            case "AddLabelAction":
                return buildAddLabelAction(id, subTree);
            case "PrintAction":
                return buildPrintAction(id, subTree);
            default:
                return null;
        }
    }

    private Identifier buildIdentifier(Tree subTree) {

        Identifier identifier = new Identifier();

        for (int i = 0; i < subTree.getChildCount(); i++) {
            identifier.addPart(subTree.getChild(i).getText());
        }

        return identifier;
    }

    private SetMarkAction buildSetMarkAction(int id, Tree subTree) {

        SetMarkAction action = new SetMarkAction(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        for (int i = 0; i < subTree.getChild(1).getChildCount(); i++)
            action.addStringToExpression(subTree.getChild(1).getChild(i).getText());

        return action;
    }

    private SetTextAction buildSetTextAction(int id, Tree subTree) {

        SetTextAction action = new SetTextAction(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        for (int i = 0; i < subTree.getChild(1).getChildCount(); i++) {
            action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
        }

        return action;
    }

    private SetIndentAction buildSetIndentAction(int id, Tree subTree) {

        SetIndentAction action = new SetIndentAction(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        for (int i = 0; i < subTree.getChild(1).getChildCount(); i++)
            action.addIndentPart(subTree.getChild(1).getChild(i).getText());

        return action;
    }

    private SplitAction buildSplitAction(int id, Tree subTree) {

        SplitAction action = new SplitAction(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        return action;
    }

    private MergeAction buildMergeAction(int id, Tree subTree) {

        MergeAction action = new MergeAction(id, subTree.getText());

        action.setIdentifier1(subTree.getChild(0).getChild(0).getText());
        action.setIdentifier2(subTree.getChild(1).getChild(0).getText());

        return action;
    }

    private NewEntryAction buildNewEntryAction(int id, Tree subTree) {

        NewEntryAction action = new NewEntryAction(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        if (subTree.getChildCount() > 1) {

            for (int i = 0; i < subTree.getChild(1).getChildCount(); i++) {
                action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
            }
        }

        return action;
    }

    private NewLabelAction buildNewLabelAction(int id, Tree subTree) {

        NewLabelAction action = new NewLabelAction(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        if (subTree.getChildCount() > 1) {
            for (int i = 0; i < subTree.getChild(1).getChildCount(); i++) {
                action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
            }
        }

        return action;
    }

    private SetValueAction buildSetValueAction(int id, Tree subTree) {

        SetValueAction action = new SetValueAction(id, subTree.getText());

        action.setIdentifier(buildIdentifier(subTree.getChild(0)));

        if (subTree.getChildCount() > 1) {
            for (int i = 0; i < subTree.getChild(1).getChildCount(); i++) {
                action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
            }
        }

        return action;
    }

    private SetCategoryAction buildSetCategoryAction(int id, Tree subTree) {

        SetCategoryAction action = new SetCategoryAction(id, subTree.getText());

        action.setIdentifier1(buildIdentifier(subTree.getChild(0)));
        action.setIdentifier2(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private SetParentAction buildSetParentAction(int id, Tree subTree) {

        SetParentAction action = new SetParentAction(id, subTree.getText());

        action.setParent(buildIdentifier(subTree.getChild(0)));
        action.setChild(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private GroupAction buildGroupAction(int id, Tree subTree) {

        GroupAction action = new GroupAction(id, subTree.getText());

        action.setIdentifier1(buildIdentifier(subTree.getChild(0)));
        action.setIdentifier2(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private AddLabelAction buildAddLabelAction(int id, Tree subTree) {

        AddLabelAction action = new AddLabelAction(id, subTree.getText());

        if (subTree.getChildCount() > 2) {
            action.setLabelIdentifier(buildIdentifier(subTree.getChild(0)));
            action.setCategoryIdentifier(buildIdentifier(subTree.getChild(1)));
            action.setDestinationIdentifier(buildIdentifier(subTree.getChild(2)));
        } else {
            action.setLabelIdentifier(buildIdentifier(subTree.getChild(0)));
            action.setDestinationIdentifier(buildIdentifier(subTree.getChild(1)));
        }

        return action;
    }

    private PrintAction buildPrintAction(int id, Tree subTree) {

        PrintAction action = new PrintAction(id, subTree.getText());

        if (subTree.getChildCount() > 0) {
            for (int i = 0; i < subTree.getChildCount(); i++) {
                action.addPartToExpression(subTree.getChild(i).getText());
            }
        }

        return action;
    }
}
