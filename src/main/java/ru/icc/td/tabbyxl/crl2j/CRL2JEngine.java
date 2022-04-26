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
import ru.icc.td.tabbyxl.crl2j.parser.CRLLexer;
import ru.icc.td.tabbyxl.crl2j.parser.CRLParser;
import ru.icc.td.tabbyxl.crl2j.parser.ASTPrinter;
import ru.icc.td.tabbyxl.model.CTable;

import javax.tools.JavaFileObject;
import java.io.File;
import java.io.IOException;
import java.util.*;

public final class CRL2JEngine {

    private static final String filledLine = StringUtils.repeat("=", 100);
    private static final CharSequenceCompiler compiler;
    public static final String PACKAGE_NAME_BY_DEFAULT = "generated";

    static {
        compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);
    }

    private Map<String, JavaFileObject> sourceCodeUnits;
    private SortedSet<TableConsumer> tableConsumers = new TreeSet<>();

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

    private Tree parse(File crlFile) throws IOException, RecognitionException {

        ANTLRFileStream fileStream = new ANTLRFileStream(crlFile.getPath());

        // Tokenize CRL

        CRLLexer lexer = new CRLLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // Parse CRL

        CRLParser parser = new CRLParser(tokenStream);

        return (Tree) parser.ruleset().getTree();
    }

    private void generateJavaFiles(Tree ast) {

        // Analyze and interpret AST to create a Ruleset model

        Ruleset ruleset = new Ruleset(ast);

        // Generate Java source code from the Ruleset model

        CodeGenerator codeGenerator = new CodeGenerator(getPackageName(), ruleset);
        sourceCodeUnits = codeGenerator.generateSourceCode();
    }

    private void createTableConsumers(Map<String, JavaFileObject> sourceCodeUnits) throws CharSequenceCompilerException {
        try {

            for (String qualifiedClassName : sourceCodeUnits.keySet()) {
                Class<TableConsumer>[] prototype = new Class[]{TableConsumer.class};
                JavaFileObject sourceCodeUnit = sourceCodeUnits.get(qualifiedClassName);
                CharSequence sourceCode = sourceCodeUnit.getCharContent(true);
                Class<TableConsumer> clazz = compiler.compile(qualifiedClassName, sourceCode, null, prototype);

                TableConsumer instance = clazz.newInstance();
                tableConsumers.add(instance);
            }

        } catch (IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    public void loadRules(File crlFile) throws IOException, RecognitionException {

        // Parse the CRL ruleset to AST

        Tree ast = parse(crlFile);

        if (false) {
            System.out.println("This AST was produced from the ruleset");
            System.out.println(ASTPrinter.trace(ast));
            System.out.println(filledLine);
            System.out.println();
        }

        // Interpret AST to create Java files

        generateJavaFiles(ast);

        if (true) {
            System.out.println("This Java source code was generated from the ruleset");
            System.out.println(filledLine);
            System.out.println();

            for (JavaFileObject sourceCodeUnit : sourceCodeUnits.values()) {
                System.out.println(sourceCodeUnit.getCharContent(true));
                System.out.println(filledLine);
                System.out.println();
            }
        }

        // Compile Java files to Java classes and create their instances

        try {
            createTableConsumers(sourceCodeUnits);
        } catch (CharSequenceCompilerException e) {
            System.err.println("The generated java files could not be compiled");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Map<String, JavaFileObject> getSourceCodeUnits() {
        return sourceCodeUnits;
    }

    public void processTable(CTable table) {
        tableConsumers.forEach(tc -> tc.accept(table));
    }
}
