package ru.icc.cells.ssdc.interpreeter;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import ru.icc.cells.ssdc.interpreeter.AstModel.AstModel;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CTable;

import java.util.List;

public class AstModelInterpreeter {

    private static String classPath=System.getProperty("user.dir");
    public static String getClassPath() { return classPath; }

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
            System.out.println(rule.getNum());

            JShell jShell=JShell.create();
            List<SnippetEvent> events = jShell.eval("boolean flag=true;");
            for(SnippetEvent e:events)
            {
                System.out.println(String.format("Status: %s, Value %s",e.status(),e.value()));
            }

            //Iterator<CCell> cells = table.getCells();
            /*try (JShell jshell = JShell.create()) {


                List<SnippetEvent> events;
                jshell.addToClasspath(getClassPath());

                events = jshell.eval("import src.main.java.ru.icc.cells.ssdc.model.*;");
                for (SnippetEvent e : events) {
                    System.out.println(String.format("Status: %s, Value: %s", e.status(), e.value()));
                }

                events = jshell.eval("String test=\"test string\"");
                for (SnippetEvent e : events) {
                    System.out.println(String.format("Status: %s, Value: %s", e.status(), e.value()));
                }*/
               // int cellsCount = 0;
            /*while(cells.hasNext())
            {
                currentCell=cells.next();
                cellsCount++;
            }*/
                //System.out.println(String.format("Cells count is %d", cellsCount));
               // jshell.close();
           // }
        }
    }
}
