/*
 * Copyright 2018-19 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.icc.td.tabbyxl.crl2j;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.lang.StringUtils;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompiler;
import ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompilerException;
import ru.icc.td.tabbyxl.crl2j.parsing.CRLLexer;
import ru.icc.td.tabbyxl.crl2j.parsing.CRLParser;
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
    public static final String PACKAGE_NAME_BY_DEFAULT = "ru.icc.td.tabbyxl.crl2j.synthesis";

    static {
        compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
    }

    private List<String> sourceCode;
    private List<Class<? extends RuleProgramPrototype>> classes;

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

    private Tree parse(File crlFile) throws IOException, RecognitionException {

        ANTLRFileStream fileStream = new ANTLRFileStream(crlFile.getPath());

        // Tokenize CRL
        CRLLexer lexer = new CRLLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // Parse CRL
        CRLParser parser = new CRLParser(tokenStream);

        return (Tree) parser.crl().getTree();
    }

    private List<String> translate(Tree ast) {

        // Analyze AST to create a Ruleset model
        Ruleset ruleset = Ruleset.createInstance(ast);

        // Generate Java source code from the Ruleset model
        CodeGenerator codeGenerator = new CodeGenerator(getPackageName(), ruleset);

        return codeGenerator.fetchSourceCode();
    }

    private List<Class<? extends RuleProgramPrototype>> compile(List<String> sourceCode) {
        List<Class<? extends RuleProgramPrototype>> clazzes = null;

        try {
            int size = sourceCode.size();
            clazzes = new ArrayList<>(size);

            int i = 0;
            for (String classSourceCode : sourceCode) {
                i++;
                String s = String.format("%s.Rule%d", getPackageName(), i);
                Class<?>[] prototype = new Class<?>[]{RuleProgramPrototype.class};
                Class<? extends RuleProgramPrototype> clazz = compiler.compile(s, classSourceCode, null, prototype);
                clazzes.add(clazz);
            }
        } catch (CharSequenceCompilerException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            return clazzes;
        }
    }

    public void loadRules(File crlFile) throws IOException, RecognitionException {

        // Parse CRL to AST
        Tree ast = parse(crlFile);

        // Translate AST to Java source code:
        sourceCode = translate(ast);

        System.out.println("This Java source code was generated from the ruleset");
        System.out.println(filledLine);
        System.out.println();

        for (String code : sourceCode) {
            System.out.println(code);
            System.out.println(filledLine);
            System.out.println();
        }

        // Compile Java source code to Java classes
        classes = compile(sourceCode);
    }

    public List<String> getSourceCode() {
        return sourceCode;
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
