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

public final class CRL2JEngine {

    private static final String filledLine = StringUtils.repeat("=", 100);
    private static final CharSequenceCompiler compiler;

    static {
        compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
    }

    private List<Rule> rules;
    private List<String> classSourceCodes = new ArrayList<>();
    private List<Class<? extends RuleProgramPrototype>> classes = new ArrayList<>();

    public static final String PACKAGE_NAME_BY_DEFAULT = "ru.icc.td.tabbyxl.crl2j.synthesis";
    private String packageName;

    public CRL2JEngine() {
        this(PACKAGE_NAME_BY_DEFAULT);
    }

    public CRL2JEngine(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

    private void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    private CommonTree ast;

    private void parseRuleset(File crlFile) throws IOException, RecognitionException {

        ANTLRFileStream fileStream = new ANTLRFileStream(crlFile.getPath());
        CRLLexer lexer = new CRLLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CRLParser parser = new CRLParser(tokenStream);
        ast = (CommonTree) parser.crl().getTree();
    }

    private void translateRuleset() {

        List<String> imports = RuleGen.createImports(ast);
        CodeGenerator.addImportStatements(imports);
        rules = RuleGen.createRules(ast);

        //Ruleset ruleset = Ruleset.createInstance(ast);

        System.out.println("This Java source code was generated from the ruleset");
        System.out.println();
        System.out.println(filledLine);

        for (Rule rule : rules) {
            CodeGenerator codeGenerator = new CodeGenerator(rule, getPackageName());
            String classSourceCode = codeGenerator.fetchSourceCode();

            // Print the source code generated from a rule
            System.out.println(classSourceCode);
            System.out.println(filledLine);

            classSourceCodes.add(classSourceCode);
        }
    }

    private void compileRuleset() {
        try {
            int i = 0;
            for (String classSourceCode : classSourceCodes) {
                i++;
                String s = String.format("%s.Rule%d", getPackageName(), i);
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

    public List<String> getClassSourceCodes() {
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
