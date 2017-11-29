package ru.icc.cells.ssdc.interpreeter;

import ru.icc.cells.ssdc.interpreeter.AstModel.Model;
import ru.icc.cells.ssdc.interpreeter.AstModel.Rule;
import ru.icc.cells.ssdc.interpreeter.AstModel.RuleClassInterface;
import ru.icc.cells.ssdc.interpreeter.AstModel.RuleClassPrototype;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompiler;
import ru.icc.cells.ssdc.interpreeter.compiler.CharSequenceCompilerException;
import ru.icc.cells.ssdc.model.CTable;

import javax.tools.DiagnosticCollector;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

public class AstModelInterpreeter {

    public static void fireAllRules(CTable table, Model model){
        CharSequenceCompiler compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
        for(Rule rule:model.getRules())
        {
            try
            {
                System.out.println(rule.gerenateClass(model.getImports()));
                Class<? extends RuleClassPrototype> ruleClass = compiler.compile(rule.getRuleClassName(), rule.gerenateClass(model.getImports()), null, new Class<?>[]{ RuleClassPrototype.class });
                RuleClassPrototype obj = ruleClass.getConstructor(new Class[] { String.class }).newInstance(new Object[]{"aaaaa"});
                System.out.println(obj.getClass().getCanonicalName());
                System.out.println(obj.sayHello());

            } catch (CharSequenceCompilerException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
