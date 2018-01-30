package ru.icc.cells.ssdc.interpreeter;

import org.antlr.runtime.tree.Tree;
import ru.icc.cells.ssdc.interpreeter.RuleObjectModel.*;
import ru.icc.cells.ssdc.interpreeter.RuleObjectModel.actions.*;
import ru.icc.cells.ssdc.interpreeter.RuleObjectModel.Condition;

public class AstModelBuilder {

    private Model model;

    public Model getModel() {
        return model;
    }

    public AstModelBuilder()
    {
        model=new Model();
    }

    public void buildModel(Tree ast)
    {
        try
        {
            for(int i=0;i<ast.getChildCount();i++)
            {
                if(ast.getChild(i).getText()=="Imports") buildImports(ast.getChild(i));
                else if(ast.getChild(i).getText()=="RULES")
                    buildAllRules(ast.getChild(i));
            }
        }catch (Exception e) { e.printStackTrace(); }
    }

    private void buildImports(Tree subTree)
    {
        for(int i=0;i<subTree.getChildCount();i++)
        {
            model.addImport(subTree.getChild(i).getText());
        }
    }

    private void buildAllRules(Tree subTree)
    {
        for(int i=0;i<subTree.getChildCount();i++)
        {
            model.addRule(buildRule(subTree.getChild(i)));
        }
    }

    private Rule buildRule(Tree subTree)
    {
        Rule newRule=new Rule(Integer.parseInt(subTree.getText()));

        for(int i=0;i<subTree.getChildCount();i++)
        {
            if(subTree.getChild(i).getText() == "Conditions")
            {
                addConditionsToRule(subTree.getChild(i), newRule);
            }
            else if(subTree.getChild(i).getText() == "Actions")
            {
                addActionsToRule(subTree.getChild(i), newRule);
            }
        }

        return newRule;
    }

    private void addConditionsToRule(Tree subTree, Rule rule)
    {
        for (int i=0;i<subTree.getChildCount();i++)
        {
            if(subTree.getChild(i).getText() == "Condition" || subTree.getChild(i).getText() == "No_condition") {
                Condition condition = buildCondition(i+1, subTree.getChild(i));
                rule.addCondition(condition);
                if (condition.getVariable() != null)
                    rule.addVariable(condition.getVariable());
            }
        }
    }

    private Condition buildCondition(int id, Tree subTree)
    {
        Condition condition = new Condition(id);

        switch (subTree.getChild(0).getText()) {
            case "cell": condition.setType("condition"); condition.setVariable(new RuleVariable("CCell", subTree.getChild(1).getText()));
                break;
            case "label": condition.setType("condition"); condition.setVariable(new RuleVariable("CLabel", subTree.getChild(1).getText()));
                break;
            case "entry": condition.setType("condition"); condition.setVariable(new RuleVariable("CEntry", subTree.getChild(1).getText()));
                break;
            case "category": condition.setType("condition"); condition.setVariable(new RuleVariable("Category", subTree.getChild(1).getText()));
                break;
            case "no cells": condition.setType("no_condition"); condition.setVariable(new RuleVariable("CCell", "$id"+condition.getId()));
                break;
            case "no labels": condition.setType("no_condition"); condition.setVariable(new RuleVariable("CLabel", "$id"+condition.getId()));
                break;
            case "no entries": condition.setType("no_condition"); condition.setVariable(new RuleVariable("CEntry", "$id"+condition.getId()));
                break;
            case "no categories": condition.setType("no_condition"); condition.setVariable(new RuleVariable("CCategory", "$id"+condition.getId()));
                break;
            default: condition.setType(subTree.getChild(0).getText());
        }

        for (int i=0; i<subTree.getChildCount(); i++)
        {
            if (subTree.getChild(i).getText() == "Constraint") {
                addConstraintToCondition(subTree.getChild(i), condition);
            }
            else if (subTree.getChild(i).getText() == "Assignment") {
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

    private void addConstraintToCondition(Tree subTree, Condition condition)
    {
        Constraint constraint=new Constraint();
        for(int i=0; i<subTree.getChildCount();i++)
            constraint.addPart(subTree.getChild(i).getText());
        condition.addConstraint(constraint);
    }

    private void addAssignmentToCondition(Tree subTree, Condition condition)
    {
        Assignment assignment=new Assignment(subTree.getChild(0).getChild(0).getText());

        for(int i=0; i<subTree.getChild(1).getChildCount(); i++)
            assignment.addExpressionPart(subTree.getChild(1).getChild(i).getText());

        condition.addAssignment(assignment);
    }


    private void addActionsToRule(Tree subTree, Rule rule) {

        for (int i=0; i<subTree.getChildCount(); i++) {
            rule.addAction(buildAction(subTree.getChild(i), i+1));
        }

    }

    private Action buildAction(Tree subTree, int id) {

        switch (subTree.getText())
        {
            case "Set_mark": return buildSetMark(id, subTree);
            case "Set_text": return buildSetText(id, subTree);
            case "Set_indent": return buildSetIndent(id, subTree);
            case "Set_value": return buildSetValue(id, subTree);
            case "Set_category": return buildSetCategory(id, subTree);
            case "Set_parent": return buildSetParent(id, subTree);
            case "Split": return buildSplit(id, subTree);
            case "Merge": return buildMerge(id, subTree);
            case "Group": return buildGroup(id, subTree);
            case "New_entry": return buildNewEntry(id, subTree);
            case "New_label": return buildNewLabel(id, subTree);
            case "Add_label": return buildAddLabel(id, subTree);
            case "Print": return buildPrint(id, subTree);
            default: return null;
        }
    }

    private Identifier buildIdentifier(Tree subTree) {

        Identifier identifier = new Identifier();

        for(int i=0; i<subTree.getChildCount(); i++) {
            identifier.addPart(subTree.getChild(i).getText());
        }

        return identifier;
    }

    private SetMark buildSetMark(int id, Tree subTree) {

        SetMark setMark = new SetMark(id, subTree.getText());

        setMark.setIdentifier(subTree.getChild(0).getChild(0).getText());
        //setMark.setStringExpression(subTree.getChild(1).getChild(0).getText());

        for(int i=0; i<subTree.getChild(1).getChildCount(); i++)
            setMark.addStringToExpression(subTree.getChild(1).getChild(i).getText());

        return setMark;
    }

    private SetText buildSetText(int id, Tree subTree) {

        SetText action = new SetText(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        for(int i=0; i<subTree.getChild(1).getChildCount(); i++) {
            action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
        }

        return action;
    }

    private SetIndent buildSetIndent(int id, Tree subTree) {

        SetIndent action = new SetIndent(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());
        //action.setIndent(subTree.getChild(1).getChild(0).getText());

        for(int i=0; i<subTree.getChild(1).getChildCount(); i++)
            action.addIndentPart(subTree.getChild(1).getChild(i).getText());

        return action;
    }

    private Split buildSplit(int id, Tree subTree) {

        Split action = new Split(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        return action;
    }

    private Merge buildMerge(int id, Tree subTree) {

        Merge action = new Merge(id, subTree.getText());

        action.setIdentifier1(subTree.getChild(0).getChild(0).getText());
        action.setIdentifier2(subTree.getChild(1).getChild(0).getText());

        return action;
    }

    private NewEntry buildNewEntry(int id, Tree subTree) {

        NewEntry action = new NewEntry(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        //if(subTree.getChildCount()>1) action.setStringExpression(subTree.getChild(1).getChild(0).getText());
        if( subTree.getChildCount() > 1 ) {

            for ( int i=0; i<subTree.getChild(1).getChildCount(); i++) {
                action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
            }
        }

        return action;
    }

    private NewLabel buildNewLabel(int id, Tree subTree) {

        NewLabel action = new NewLabel(id, subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        //if(subTree.getChildCount()>1) action.setStringExpression(subTree.getChild(1).getChild(0).getText());

        if( subTree.getChildCount() > 1 ) {
            for (int i = 0; i < subTree.getChild(1).getChildCount(); i++) {
                action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
            }
        }

        return action;
    }

    private SetValue buildSetValue(int id, Tree subTree) {

        SetValue action = new SetValue(id, subTree.getText());

        action.setIdentifier(buildIdentifier(subTree.getChild(0)));
        //action.setStringExpression(subTree.getChild(1).getText());

        if( subTree.getChildCount() > 1 ) {
            for (int i = 0; i < subTree.getChild(1).getChildCount(); i++) {
                action.addStringToExpression(subTree.getChild(1).getChild(i).getText());
            }
        }

        return action;
    }

    private SetCategory buildSetCategory(int id, Tree subTree) {

        SetCategory action = new SetCategory(id, subTree.getText());

        action.setIdentifier1(buildIdentifier(subTree.getChild(0)));
        action.setIdentifier2(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private SetParent buildSetParent(int id, Tree subTree) {

        SetParent action = new SetParent(id, subTree.getText());

        action.setParent(buildIdentifier(subTree.getChild(0)));
        action.setChild(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private Group buildGroup(int id, Tree subTree) {

        Group action = new Group(id, subTree.getText());

        action.setIdentifier1(buildIdentifier(subTree.getChild(0)));
        action.setIdentifier2(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private AddLabel buildAddLabel(int id, Tree subTree) {

        AddLabel action = new AddLabel(id, subTree.getText());

        if(subTree.getChildCount()>2) {
            action.setLabelIdentifier(buildIdentifier(subTree.getChild(0)));
            action.setCategoryIdentifier(buildIdentifier(subTree.getChild(1)));
            action.setDestinationIdentifier(buildIdentifier(subTree.getChild(2)));
        }
        else {
            action.setLabelIdentifier(buildIdentifier(subTree.getChild(0)));
            action.setDestinationIdentifier(buildIdentifier(subTree.getChild(1)));
        }

        return action;
    }

    private Print buildPrint(int id, Tree subTree) {

        Print action = new Print(id, subTree.getText());

        if(subTree.getChildCount()>0)
        {
            for(int i=0; i<subTree.getChildCount(); i++) {
                action.addPartToExpression(subTree.getChild(i).getText());
            }
        }

        return action;
    }
}
