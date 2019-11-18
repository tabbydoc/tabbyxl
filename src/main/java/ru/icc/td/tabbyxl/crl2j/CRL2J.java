package ru.icc.td.tabbyxl.crl2j;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.lang.StringUtils;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompiler;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompilerException;
import ru.icc.td.tabbyxl.crl2j.parsing.CRLLexer;
import ru.icc.td.tabbyxl.crl2j.parsing.CRLParser;
import ru.icc.td.tabbyxl.crl2j.rulemodel.Rule;
import ru.icc.td.tabbyxl.crl2j.synthesis.RuleProgramPrototype;
import ru.icc.td.tabbyxl.model.CTable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class CRL2J {

    private static final String filler;
    private static final CharSequenceCompiler compiler;

    static {
        filler = StringUtils.repeat("=", 100);
        compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
    }

    private List<Rule> rules;
    private List<String> classSourceCodes = new ArrayList<>();
    private List<Class<? extends RuleProgramPrototype>> classes = new ArrayList<>();

    private void parseRuleset(File crlFile) throws IOException, RecognitionException {

        ANTLRFileStream fileStream = new ANTLRFileStream(crlFile.getPath());
        CRLLexer lexer = new CRLLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CRLParser parser = new CRLParser(tokenStream);
        CommonTree ast = (CommonTree) parser.crl().getTree();

        Translator.addImportStatements(RuleModelBuilder.buildImports(ast));
        rules = RuleModelBuilder.buildRules(ast);
    }

    private void translateRuleset() {

        System.out.println("This Java source code was generated from the ruleset");
        System.out.println();
        System.out.println(filler);

        for (Rule rule : rules) {
            Translator translator = new Translator(rule);
            String classSourceCode = translator.fetchSourceCode();

            // Print the source code generated from a rule
            System.out.println(classSourceCode);
            System.out.println(filler);

            classSourceCodes.add(classSourceCode);
        }
    }

    private void compileRuleset() {
        try {
            int i = 0;
            for (String classSourceCode : classSourceCodes) {
                i++;
                String s = String.format("%s.Rule%d", Translator.getPackageStatement(), i);
                Class<?>[] prototype = new Class<?>[]{RuleProgramPrototype.class};
                Class<? extends RuleProgramPrototype> clazz = compiler.compile(s, classSourceCode, null, prototype);
                classes.add(clazz);
            }
        } catch (CharSequenceCompilerException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void loadRules(File crlFile) throws IOException, RecognitionException {
        parseRuleset(crlFile);
        translateRuleset();
        compileRuleset();
    }

    public List<String> getSourceCode() {
        return classSourceCodes;
    }

    public void processTable(CTable table)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Class<? extends RuleProgramPrototype> clazz: classes) {
            Constructor<? extends RuleProgramPrototype> constructor = clazz.getConstructor(CTable.class);
            RuleProgramPrototype instance = constructor.newInstance(table);
            instance.eval();
        }
    }
}
