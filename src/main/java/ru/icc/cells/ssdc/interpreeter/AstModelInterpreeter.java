package ru.icc.cells.ssdc.interpreeter;

import ru.icc.cells.ssdc.interpreeter.AstModel.AstModel;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;
import ru.icc.cells.ssdc.model.CCell;
import ru.icc.cells.ssdc.model.CTable;

import java.lang.*;

import static java.lang.System.*;

public class AstModelInterpreeter {

    private static String classPath;

    private static CCell currentCell;

    public static void setCurrentCell(CCell cell) { currentCell=cell; }
    public static CCell getCurrentCell() {
        return currentCell;
    }

    public static void fireAllRules(CTable table, AstModel model){

        for(Rule rule:model.getRules())
        {

            out.println(rule.gerenateClass(model.getImports()));
        }
    }
}
