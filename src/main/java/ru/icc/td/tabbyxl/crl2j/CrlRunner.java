package ru.icc.td.tabbyxl.crl2j;

import org.antlr.runtime.RecognitionException;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompiler;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompilerException;
import ru.icc.td.tabbyxl.crl2j.synthesis.RuleProgramPrototype;
import ru.icc.td.tabbyxl.model.CTable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CrlRunner {

    private RuleCodeGen ruleCodeGen;
    private CharSequenceCompiler compiler;
    private List<String> rules = new ArrayList<>();
    private List<Class<? extends RuleProgramPrototype>> classes = new ArrayList<>();

    public void loadCrl2j(File rulesetFile) {

        ruleCodeGen = new RuleCodeGen();
        compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);

        try {
            ruleCodeGen.loadRuleset(rulesetFile);

            rules = ruleCodeGen.generateCodeFromAllRules();

            int i = 0;
            for (String rule : rules) {
                i++;
                Class<? extends RuleProgramPrototype> ruleClass = compiler.compile(String.format("%s.Rule%d", ruleCodeGen.getPACK(), i), rule, null, new Class<?>[]{RuleProgramPrototype.class});
                classes.add(ruleClass);
            }
        } catch (IOException|RecognitionException|CharSequenceCompilerException e) {
            e.printStackTrace();
        }
    }

    public void fireAllRules(CTable table) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Class<? extends RuleProgramPrototype> ruleClass: classes) {
            RuleProgramPrototype ruleObject = ruleClass.getConstructor(new Class[] {CTable.class}).newInstance(new Object[] { table });
            ruleObject.eval();
        }
    }
}
