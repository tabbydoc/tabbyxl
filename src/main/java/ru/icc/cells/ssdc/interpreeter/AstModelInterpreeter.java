package ru.icc.cells.ssdc.interpreeter;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import ru.icc.cells.ssdc.interpreeter.AstModel.AstModel;
import ru.icc.cells.ssdc.interpreeter.AstModel.Condition;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CEntry;
import ru.icc.cells.ssdc.model.CTable;

import java.util.Iterator;
import java.util.List;

public class AstModelInterpreeter {

    private static String classPath=System.getProperty("user.dir");

    private static CCell currentCell;

    public static CCell getCurrentCell() {
        return currentCell;
    }

    public AstModelInterpreeter() {}

    public static void fireAllRules(CTable table, AstModel model)
    {
        System.out.println("Here...");
        for(Rule rule:model.getRules())
        {
            System.out.println(String.format("Rule #%d",rule.getNum()));

            JShell jShell=JShell.create();
            jShell.addToClasspath(classPath+"/src/main/java");

            List<SnippetEvent> events;

            for(String s:model.getImports())
            {
                events=jShell.eval(s);
                for(SnippetEvent e:events)
                {
                    System.out.println(s);
                    System.out.println(String.format("Status: %s, Value %s",e.status(),e.value()));
                }
            }

            for(Condition condition:rule.getConditions())
            {
                if(condition.getQuery()=="cell")
                {
                    Iterator<CCell> cells=table.getCells();
                    
                }
            }
            jShell.close();
        }
    }
}
