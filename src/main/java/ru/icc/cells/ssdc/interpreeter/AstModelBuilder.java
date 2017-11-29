package ru.icc.cells.ssdc.interpreeter;

import org.antlr.runtime.tree.Tree;
import ru.icc.cells.ssdc.interpreeter.AstModel.*;

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
                if(ast.getChild(i).getText()=="SETTING") buildSetting(ast.getChild(i));
                else if(ast.getChild(i).getText()=="RULES")
                    buildAllRules(ast.getChild(i));
            }
        }catch (Exception e) { e.printStackTrace(); }
    }

    private void buildSetting(Tree subTree)
    {
        for(int i=0;i<subTree.getChildCount();i++)
        {
            model.addSetting(subTree.getChild(i).getText());
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
            if(subTree.getChild(i).getText()=="Conditions")
            {
                addConditionsToRule(subTree.getChild(i), newRule);
            }
        }
        return newRule;
    }

    private void addConditionsToRule(Tree subTree, Rule rule)
    {
        for (int i=0;i<subTree.getChildCount();i++)
        {
            rule.addCondition(buildCondition(i+1, subTree.getChild(i)));
        }
    }

    private Condition buildCondition(int id, Tree subTree)
    {
        Condition condition=new Condition(id, subTree.getChild(0).getText(), subTree.getChild(1).getText());
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
}
