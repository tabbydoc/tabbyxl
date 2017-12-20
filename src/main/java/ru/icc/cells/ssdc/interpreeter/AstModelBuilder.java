package ru.icc.cells.ssdc.interpreeter;

import org.antlr.runtime.tree.Tree;
import ru.icc.cells.ssdc.interpreeter.AstModel.*;
import ru.icc.cells.ssdc.interpreeter.AstModel.actions.*;
import ru.icc.cells.ssdc.interpreeter.AstModel.Condition;
import ru.icc.cells.ssdc.interpreeter.AstModel.NoCondition;

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
            if(subTree.getChild(i).getText() == "Condition") {
                Condition condition = buildCondition(i+1, subTree.getChild(i));
                rule.addCondition(condition);
                rule.addVariable(condition.getVariable());
            }
            /*else if(subTree.getChild(i).getText() == "No_condiiton") {
                NoCondition noCondition = buildNoCondition(i+1, subTree.getChild(i));
                rule.addCondition(noCondition);
            }*/
        }
    }

    private Condition buildCondition(int id, Tree subTree)
    {

        Condition condition=new Condition(id, new RuleVariable(subTree.getChild(0).getText(), subTree.getChild(1).getText()));

        if(subTree.getChildCount()>2)
        {
            for(int i=2;i<subTree.getChildCount();i++)
            {
                if(subTree.getChild(i).getText()=="Constraint") addConstraintToCondition(subTree.getChild(i), condition);
                else if(subTree.getChild(i).getText()=="Assignment") addAssignmentToCondition(subTree.getChild(i),condition);
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
        Assignment assignment=new Assignment(subTree.getChild(0).getText(), subTree.getChild(1).getText());
        condition.addAssignment(assignment);
    }


    private void addActionsToRule(Tree subTree, Rule rule) {

        for (int i=0; i<subTree.getChildCount(); i++) {
            rule.addAction(buildAction(subTree.getChild(i)));
        }

    }

    private Action buildAction(Tree subTree) {

        switch (subTree.getText())
        {
            case "Set_mark": return buildSetMark(subTree);
            case "Set_text": return buildSetText(subTree);
            case "Set_indent": return buildSetIndent(subTree);
            case "Set_value": return buildSetValue(subTree);
            case "Set_category": return buildSetCategory(subTree);
            case "Set_parent": return buildSetParent(subTree);
            case "Split": return buildSplit(subTree);
            case "Merge": return buildMerge(subTree);
            case "Group": return buildGroup(subTree);
            case "New_entry": return buildNewEntry(subTree);
            case "New_label": return buildNewLabel(subTree);
            case "Add_label": return buildAddLabel(subTree);
            default: return new Action(subTree.getText());
        }
    }

    private Identifier buildIdentifier(Tree subTree) {

        Identifier identifier = new Identifier();

        for(int i=0; i<subTree.getChildCount(); i++) {
            identifier.addPart(subTree.getChild(i).getText());
        }

        return identifier;
    }

    private SetMark buildSetMark(Tree subTree) {

        SetMark setMark = new SetMark(subTree.getText());

        setMark.setIdentifier(subTree.getChild(0).getChild(0).getText());
        setMark.setStringExpression(subTree.getChild(1).getChild(0).getText());

        return setMark;
    }

    private SetText buildSetText(Tree subTree) {

        SetText action = new SetText(subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());
        action.setStringExpression(subTree.getChild(1).getChild(0).getText());

        return action;
    }

    private SetIndent buildSetIndent(Tree subTree) {

        SetIndent action = new SetIndent(subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());
        action.setIndent(subTree.getChild(1).getChild(0).getText());

        return action;
    }

    private Split buildSplit(Tree subTree) {

        Split action = new Split(subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        return action;
    }

    private Merge buildMerge(Tree subTree) {

        Merge action = new Merge(subTree.getText());

        action.setIdentifier1(subTree.getChild(0).getChild(0).getText());
        action.setIdentifier2(subTree.getChild(1).getChild(0).getText());

        return action;
    }

    private NewEntry buildNewEntry(Tree subTree) {

        NewEntry action = new NewEntry(subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        if(subTree.getChildCount()>1) action.setStringExpression(subTree.getChild(1).getChild(0).getText());

        return action;
    }

    private NewLabel buildNewLabel(Tree subTree) {

        NewLabel action = new NewLabel(subTree.getText());

        action.setIdentifier(subTree.getChild(0).getChild(0).getText());

        if(subTree.getChildCount()>1) action.setStringExpression(subTree.getChild(1).getChild(0).getText());

        return action;
    }

    private SetValue buildSetValue(Tree subTree) {

        SetValue action = new SetValue(subTree.getText());

        action.setIdentifier(buildIdentifier(subTree.getChild(0)));
        action.setStringExpression(subTree.getChild(1).getText());

        return action;
    }

    private SetCategory buildSetCategory(Tree subTree) {

        SetCategory action = new SetCategory(subTree.getText());

        action.setIdentifier1(buildIdentifier(subTree.getChild(0)));
        action.setIdentifier2(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private SetParent buildSetParent(Tree subTree) {

        SetParent action = new SetParent(subTree.getText());

        action.setParent(buildIdentifier(subTree.getChild(0)));
        action.setChild(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private Group buildGroup(Tree subTree) {

        Group action = new Group(subTree.getText());

        action.setIdentifier1(buildIdentifier(subTree.getChild(0)));
        action.setIdentifier2(buildIdentifier(subTree.getChild(1)));

        return action;
    }

    private AddLabel buildAddLabel(Tree subTree) {

        AddLabel action = new AddLabel(subTree.getText());

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
}
