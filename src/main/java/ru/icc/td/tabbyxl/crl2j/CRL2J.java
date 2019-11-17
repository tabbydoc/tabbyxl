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

    private static final Translator translator;
    private static final CharSequenceCompiler compiler;
    private List<String> rules = new ArrayList<>();
    private List<Class<? extends RuleProgramPrototype>> classes = new ArrayList<>();

    static {
        translator = new Translator();
        compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
    }

    private void translate(File rulesetFile) {
        rules = translator.translateRuleset();
    }

    public void compile(File crlFile) {

        //translator = new Translator();
        //compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);

        try {
            translator.loadRuleset(crlFile);

            rules = translator.translateRuleset();

            int i = 0;
            for (String rule : rules) {
                i++;
                String s = String.format("%s.Rule%d", translator.getPack(), i);
                Class<?>[] c = new Class<?>[]{RuleProgramPrototype.class};
                Class<? extends RuleProgramPrototype> ruleClass = compiler.compile(s, rule, null, c);
                classes.add(ruleClass);
            }
        } catch (IOException | RecognitionException | CharSequenceCompilerException e) {
            e.printStackTrace();
        }
    }

    public void execute(CTable table)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Class<? extends RuleProgramPrototype> ruleClass: classes) {
            Class<? extends RuleProgramPrototype>[] c = new Class[]{CTable.class};
            Constructor<? extends RuleProgramPrototype> constructor = ruleClass.getConstructor(c);
            RuleProgramPrototype ruleObject = constructor.newInstance(new Object[]{table});
            ruleObject.eval();
        }
    }
}
