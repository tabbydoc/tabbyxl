package ru.icc.cells.ssdc.interpreeter;

import org.antlr.runtime.tree.Tree;
import ru.icc.cells.ssdc.interpreeter.AstModel.Assignment;
import ru.icc.cells.ssdc.interpreeter.AstModel.AstModel;
import ru.icc.cells.ssdc.interpreeter.AstModel.Condition;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;

public class AstModelBuilder {

    private AstModel model;

    public AstModel getModel() {
        return model;
    }

    public AstModelBuilder()
    {
        model=new AstModel();
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
        for(int i=0;i<subTree.getChildCount();i++)
        {
            Tree conditionBranch=subTree.getChild(i);
            Condition newCondition=new Condition(conditionBranch.getChild(0).getText(),conditionBranch.getChild(1).getText());
            if(conditionBranch.getChildCount()>2)
            {
                for(int j=2;j<conditionBranch.getChildCount();j++)
                {
                    if(conditionBranch.getChild(j).getText()=="Constraint")
                        newCondition.addConstraint(conditionBranch.getChild(j).getChild(0).getText());
                    else if(conditionBranch.getChild(j).getText()=="Assignment")
                    {
                        Assignment assignment =
                                new Assignment(conditionBranch.getChild(j).getChild(0).getText(),
                                        conditionBranch.getChild(j).getChild(1).getText());
                        newCondition.addAssignment(assignment);
                    }
                }
            }
            rule.addCondition(newCondition);
        }
    }
}
