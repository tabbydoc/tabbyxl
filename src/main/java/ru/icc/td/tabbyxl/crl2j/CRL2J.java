package ru.icc.td.tabbyxl.crl2j;

import org.antlr.runtime.RecognitionException;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompiler;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompilerException;
import ru.icc.td.tabbyxl.crl2j.synthesis.RuleProgramPrototype;
import ru.icc.td.tabbyxl.model.CTable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class CRL2J {

    private CodeGenerator codeGenerator;
    private CharSequenceCompiler compiler;
    private List<String> rules = new ArrayList<>();
    private List<Class<? extends RuleProgramPrototype>> classes = new ArrayList<>();

    public void translateRules(File rulesetFile) {

        codeGenerator = new CodeGenerator();
        compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);

        try {
            codeGenerator.loadRuleset(rulesetFile);

            rules = codeGenerator.generateCodeFromAllRules();

            int i = 0;
            for (String rule : rules) {
                i++;
                String s = String.format("%s.Rule%d", codeGenerator.getPack(), i);
                Class<?>[] c = new Class<?>[]{RuleProgramPrototype.class};
                Class<? extends RuleProgramPrototype> ruleClass = compiler.compile(s, rule, null, c);
                classes.add(ruleClass);
            }
        } catch (IOException | RecognitionException | CharSequenceCompilerException e) {
            e.printStackTrace();
        }
    }

    public void runRules(CTable table)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Class<? extends RuleProgramPrototype> ruleClass: classes) {
            Class<? extends RuleProgramPrototype>[] c = new Class[]{CTable.class};
            Constructor<? extends RuleProgramPrototype> constructor = ruleClass.getConstructor(c);
            RuleProgramPrototype ruleObject = constructor.newInstance(new Object[]{table});
            ruleObject.eval();
        }
    }
}
