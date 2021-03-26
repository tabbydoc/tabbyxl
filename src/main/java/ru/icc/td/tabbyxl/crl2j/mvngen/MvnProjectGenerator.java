/*
 * Copyright 2019 Alexey O. Shigarov (shigarov@icc.ru) and Vasiliy V. Khristyuk
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

package ru.icc.td.tabbyxl.crl2j.mvngen;

import com.squareup.javapoet.*;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import ru.icc.td.tabbyxl.crl2j.CRL2JEngine;
import ru.icc.td.tabbyxl.model.CTable;

import javax.lang.model.element.Modifier;
import javax.tools.JavaFileObject;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Map;
import java.util.Properties;

public final class MvnProjectGenerator {

    private static final String groupId = "generated";
    private static final String artifactId = "MyExtractor";

    private static final String packageName = ""; // Do not change this initialization
    private static final String mainClassName = "SpreadsheetDataExtractorApp";

    private static final Class THIS_CLASS = MvnProjectGenerator.class;

    private MvnProjectGenerator() {
    }

    public static void generate(File crlFile, Path projectPath) throws IOException, RecognitionException {

        // Generate source code of the table consumers

        Map<String, JavaFileObject> sourceCodeUnits = generateSourceCode(crlFile);
        System.out.println("The source code was generated");

        // Create or clean the project directory

        if (Files.notExists(projectPath)) {
            Files.createDirectory(projectPath);
            System.out.println("The project directory was created");
        } else {
            FileUtils.cleanDirectory(projectPath.toFile());
            System.out.println("The project directory was cleaned");
        }

        // Create the source code directory

        Path sourceCodePath = projectPath.resolve("src").resolve("main").resolve("java");
        Files.createDirectories(sourceCodePath.resolve(packageName));

        // Write the generated source code of the table consumers

        writeSourceCode(sourceCodeUnits, sourceCodePath);
        System.out.println("The source code was written in java files");

        // Create main-class and add it to the project

        JavaFileObject mainClassFile = generateMainClassSourceCode(sourceCodeUnits);
        writeMainClassSourceCode(mainClassFile, sourceCodePath);
        System.out.println("The main-class was added");

        // Create pom-file and add it to the project

        writePomFile(projectPath);
        System.out.println("The pom file was added");

        System.out.printf("Your project was created successfully in \"%s\"", projectPath);
    }

    private static Map<String, JavaFileObject> generateSourceCode(File crlFile) throws RecognitionException {

        // Generate source code of the table consumers from rules

        final CRL2JEngine crl2jEngine = new CRL2JEngine(packageName);
        try {
            crl2jEngine.loadRules(crlFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return crl2jEngine.getSourceCodeUnits();
    }

    private static void writeSourceCode(Map<String, JavaFileObject> sourceCodeUnits, Path sourceCodePath) {
        try {
            for (String qualifiedClassName : sourceCodeUnits.keySet()) {

                JavaFileObject sourceCodeUnit = sourceCodeUnits.get(qualifiedClassName);
                String sourceCode = sourceCodeUnit.getCharContent(true).toString();

                File sourceCodeFile = sourceCodePath.resolve(sourceCodeUnit.getName()).toFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(sourceCodeFile, false));
                writer.write(sourceCode);

                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static JavaFileObject generateMainClassSourceCode(Map<String, JavaFileObject> sourceCodeUnits) {

        CodeBlock codeBlock = CodeBlock
                .builder()
                .addStatement("$T inputExcelFile = new File(args[0])", File.class)
                .addStatement("$T tables = extr.extract(inputExcelFile)", CTable[].class)
                .beginControlFlow("for ($T table : tables)", CTable.class)
                .addStatement("System.out.println(table.trace())")
                .addStatement("table.toCanonicalForm().print()")
                .endControlFlow()
                .build();

        MethodSpec mainMethodSpec = MethodSpec
                .methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(String[].class, "args")
                .addException(IOException.class)
                .addCode(codeBlock)
                .build();

        FieldSpec extractorFieldSpec = FieldSpec
                .builder(SpreadsheetTableExtractor.class, "extr")
                .addModifiers(Modifier.STATIC, Modifier.FINAL)
                .initializer("new $T()", SpreadsheetTableExtractor.class)
                .build();

        CodeBlock.Builder builder = CodeBlock.builder();
        for (String qualifiedClassName : sourceCodeUnits.keySet()) {
            builder.addStatement("extr.register(new $L())", qualifiedClassName);
        }
        CodeBlock staticCodeBlock = builder.build();

        TypeSpec typeSpec = TypeSpec.
                classBuilder(mainClassName)
                .addField(extractorFieldSpec)
                .addStaticBlock(staticCodeBlock)
                .addMethod(mainMethodSpec)
                .build();

        JavaFile mainClassFile = JavaFile
                .builder(packageName, typeSpec)
                .skipJavaLangImports(true)
                .indent("    ")
                .addFileComment("This source code was generated by TabbyXL (http://tabbydoc.github.io)")
                .build();

        return mainClassFile.toJavaFileObject();
    }

    private static void writeMainClassSourceCode(JavaFileObject mainClassSourceCode, Path sourceCodePath) {
        try {
            String sourceCode = mainClassSourceCode.getCharContent(true).toString();
            File sourceCodeFile = sourceCodePath.resolve(mainClassSourceCode.getName()).toFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(sourceCodeFile, false));
            writer.write(sourceCode);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static void writePomFile(Path projectPath) throws IOException {

        // Read pom-file template

        ClassLoader classLoader = THIS_CLASS.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mvngen/pom.template");
        String pomTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Read pom properties

        Properties properties = new Properties();
        properties.load(classLoader.getResourceAsStream("pom.properties"));
        String tabbyxlGroupId = properties.getProperty("groupId");
        String tabbyxlArtifactId = properties.getProperty("artifactId");
        String tabbyxlVersion = properties.getProperty("version");

        // Get the path to the tabbyxl classes

        String path;
        try {
            path = new File(THIS_CLASS.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            path = "";
        }
        Path tabbyxlPath = Paths.get(path);

        // Fill pom-file template by using the appropriate properties

        String pomContent = String.format(
                pomTemplate,
                groupId, artifactId,
                mainClassName,
                tabbyxlPath.toAbsolutePath(),
                tabbyxlGroupId,
                tabbyxlArtifactId,
                tabbyxlVersion
        );

        // Write pom-file

        final Path pathToPomFile = projectPath.resolve("pom.xml");
        FileOutputStream out = new FileOutputStream(pathToPomFile.toFile());
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write(pomContent);
        writer.flush();
        writer.close();
    }

}
