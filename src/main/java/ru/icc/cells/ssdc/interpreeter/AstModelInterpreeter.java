package ru.icc.cells.ssdc.interpreeter;

import jdk.jshell.JShell;
import ru.icc.cells.ssdc.interpreeter.AstModel.AstModel;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CTable;

import java.util.Iterator;

public class AstModelInterpreeter {
    public AstModelInterpreeter() {}
    public static void fireAllRules(CTable table, AstModel model)
    {
        for(Rule rule:model.getRules())
        {
            Iterator<CCell> cells = table.getCells();
            JShell jshell = JShell.create();
            while(cells.hasNext())
            {

            }
        }
    }
}
