package ru.icc.cells.ssdc.interpreeter;

import ru.icc.cells.ssdc.interpreeter.AstModel.AstModel;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;
import ru.icc.cells.ssdc.interpreeter.RuleClassLoader;
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
            try {
                String classText = rule.gerenateClass(model.getImports());
                out.println(classText);

                RuleClassLoader ruleClassLoader = new RuleClassLoader(classText, ClassLoader.getSystemClassLoader());
                Class<?> ruleClass = ruleClassLoader.loadClass(String.format("Rule%d",rule.getNum()));
            /*try {
                Class clazz = ruleClassLoader.loadClass("RuleClass");
                java.lang.reflect.Method method = clazz.getMethod("getHello",null);
                //method.setAccessible(true);
                out.println(method.getReturnType());
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }*/
            } catch (ClassNotFoundException e) { e.printStackTrace(); }
        }
    }
}
