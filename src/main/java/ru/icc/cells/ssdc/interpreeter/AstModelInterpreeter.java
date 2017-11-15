package ru.icc.cells.ssdc.interpreeter;

import jdk.jshell.*;
import ru.icc.cells.ssdc.TabbyXL;
import ru.icc.cells.ssdc.interpreeter.AstModel.AstModel;
import ru.icc.cells.ssdc.interpreeter.AstModel.Condition;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CTable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;

import static java.lang.System.*;

public class AstModelInterpreeter {

    private static String classPath;

    private static CCell currentCell;

    public static void setCurrentCell(CCell cell) { currentCell=cell; }
    public static CCell getCurrentCell() {
        return currentCell;
    }

    public static void fireAllRules(CTable table, AstModel model)
    {
        out.println("Here...");

        classPath = TabbyXL.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        out.println(classPath);

        for(Rule rule:model.getRules())
        {
            out.println(String.format("Rule #%d",rule.getNum()));

            try (JShell jShell = JShell.builder().build())
            {
                out.println("JShell created");

                List<SnippetEvent> events;

                out.println(String.format("Try add classpath: %s",classPath));
                jShell.addToClasspath(classPath);

                out.println("Classpath added");

                out.println("Try to add module");
                events = jShell.eval("/env --add-modules TabbyXL");
                for(SnippetEvent e:events)
                {
                    out.println(String.format("Status: %s, Value %s",e.status(),e.value()));
                    out.println(String.format("JShell exception: %s", e.exception()));

                }

                out.println("Try import class");

                jShell.eval("import java.util.*;");
                //jShell.eval("import ru.icc.cells.ssdc.interpreeter.AstModelInterpreeter;");
                jShell.eval("import static ru.icc.cells.ssdc.interpreeter.AstModelInterpreeter.*;");

                for(String s:model.getImports())
                {
                    jShell.eval(s);
                }

                out.println("Imports to JShell:");
                Collection<ImportSnippet> imports = jShell.imports().collect(Collectors.toList());
                for(ImportSnippet t:imports)
                {
                    out.println(t.fullname());
                }

                for(Condition condition:rule.getConditions())
                {
                    //if(condition.getQuery()=="cell")
                    //{
                    Iterator<CCell> cells=table.getCells();
                    fireCondition(cells, condition, jShell);
                    //}
                }
                jShell.close();
            }
        }
    }

    private static void fireCondition(Iterator<CCell> cells, Condition condition, JShell jshell)
    {
        out.println("Create condition's var:");
        List<SnippetEvent> events;
        events=jshell.eval(String.format("List<CCell> %s = new ArrayList<>();", condition.getIdentifier()));
        out.println(String.format("List<CCell> %s = new ArrayList<>();", condition.getIdentifier()));
        //events=jshell.eval(condition.getIdentifier()+";");
        for(SnippetEvent e:events)
        {
            out.println(String.format("Status: %s, Value %s",e.status(),e.value()));
            out.println(String.format("JShell exception: %s", e.exception()));

        }
        out.println();

        jshell.eval("CCell cell;");

        while (cells.hasNext())
        {
            setCurrentCell(cells.next());

            jshell.eval("CCell cell = getCurrentCell();");
            events = jshell.eval("cell.getId();");

            for(SnippetEvent e:events)
            {
                out.println(String.format("Status: %s, Value %s",e.status(),e.value()));
            }
        }
    }
}
