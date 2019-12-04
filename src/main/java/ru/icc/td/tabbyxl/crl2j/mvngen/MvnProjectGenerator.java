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

package ru.icc.td.tabbyxl.crl2j.mvngen;

import com.squareup.javapoet.*;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import ru.icc.td.tabbyxl.crl2j.CRL2JEngine;
import ru.icc.td.tabbyxl.crl2j.TableConsumer;
import ru.icc.td.tabbyxl.model.CTable;

import javax.lang.model.element.Modifier;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class MvnProjectGenerator {

    private static final String newLine = System.lineSeparator();

    private static final String groupId = "generated";
    private static final String artifactId = "SpreadsheetDataConverter";
    private static final String nameOfPackage = "generated";

    private File crlFile;
    private Path root;

    private Path tabbyxlPath;
    private Path outputPath;

    private int numOfRules;

    public MvnProjectGenerator(Path root, File crlFile) {
        this.root = root;
        outputPath = root.resolve("src").resolve("main").resolve("java");
        tabbyxlPath = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath().replaceFirst("/", ""));

        this.crlFile = crlFile;
    }

    public void generate() throws IOException, RecognitionException {

        // Clean or create the output directory
        if (Files.notExists(root)) {
            Files.createDirectory(root);
        } else {
            FileUtils.cleanDirectory(root.toFile());
        }

        if (Files.exists(outputPath)) {
            FileUtils.cleanDirectory(outputPath.toFile());
        } else {
            Files.createDirectories(outputPath);
        }

        List<JavaFile> javaFiles = generateSourceCode();
        writeTableConsumers(javaFiles);

        generateTableCanonicalizer(javaFiles).writeTo(outputPath);

        writePomFile();
        writeMainClassFile();
    }


    //private List<JavaFile> javaFiles;

    private List<JavaFile> generateSourceCode() throws IOException, RecognitionException {
        // Generate source code

        final CRL2JEngine crl2jEngine = new CRL2JEngine(nameOfPackage);
        crl2jEngine.loadRules(crlFile);

        return crl2jEngine.getJavaFiles();
    }

    private void writeTableConsumers(List<JavaFile> javaFiles) throws IOException, RecognitionException {
        // Write source code

        for (JavaFile javaFile : javaFiles)
            javaFile.writeTo(outputPath);

        numOfRules = javaFiles.size();
    }

    private void writePomFile() throws IOException {

        // Read pom-file template

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("pom_template.txt");
        String pomTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Read pom properties

        String mainClass = String.format("%s.%s", groupId, artifactId);

        Properties properties = new Properties();
        properties.load(classLoader.getResourceAsStream("pom.properties"));
        String tabbyxlGroupId = properties.getProperty("groupId");
        String tabbyxlArtifactId = properties.getProperty("artifactId");
        String tabbyxlVersion = properties.getProperty("version");

        String pomContent = String.format(pomTemplate,
                groupId, artifactId,
                mainClass,
                tabbyxlPath.toAbsolutePath(),
                tabbyxlGroupId, tabbyxlArtifactId, tabbyxlVersion);

        // Write pom-file

        final Path pathToPomFile = root.resolve("pom.xml");
        FileOutputStream fos = new FileOutputStream(pathToPomFile.toFile());
        OutputStreamWriter streamWriter = new OutputStreamWriter(fos);
        streamWriter.write(pomContent);
        streamWriter.flush();
        streamWriter.close();
    }

    private JavaFile generateTableCanonicalizer(List<JavaFile> tableConsumerJavaFiles) {

        String arrayName = "consumers";
        Class arrayType = TableConsumer[].class;
        String varName = "consumer";
        Class varType = TableConsumer.class;

        // Create a static field and its initializer

        CodeBlock.Builder builder = CodeBlock.builder();

        builder.add("{");
        builder.add(System.lineSeparator());


        for (int i = 0; i < tableConsumerJavaFiles.size(); i++) {
            JavaFile tableConsumerJavaFile = tableConsumerJavaFiles.get(i);

            builder.add("    new $N()", tableConsumerJavaFile.typeSpec.name);
            if (i < tableConsumerJavaFiles.size() - 1)
                builder.add(",");
            builder.add(System.lineSeparator());
        }
        builder.add("}");

        CodeBlock initializerCodeBlock = builder.build();

        FieldSpec field = FieldSpec
                .builder(arrayType, arrayName, Modifier.STATIC)
                .initializer(initializerCodeBlock)
                .build();

        // Create a static method

        String paramName = "table";

        CodeBlock codeBlock = CodeBlock
                .builder()
                .beginControlFlow("for ($T $N : $N)", varType, varName, arrayName)
                .addStatement("$N.accept($N)", varName, paramName)
                .endControlFlow()
                .addStatement("$N.update()", paramName)
                .build();

        MethodSpec method = MethodSpec
                .methodBuilder("canonicalize")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(CTable.class, paramName)
                .addCode(codeBlock)
                .build();

        // Create a type

        TypeSpec typeSpec = TypeSpec
                .classBuilder("TableCanonicalizer")
                .addModifiers(Modifier.PUBLIC)
                .addField(field)
                .addMethod(method)
                .build();

        return JavaFile
                .builder(nameOfPackage, typeSpec)
                .indent("    ")
                .skipJavaLangImports(true)
                .addFileComment("This source code was generated by TabbyXL")
                .build();
    }

    private void writeMainClassFile() throws IOException {

        // Read Main-class template

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("main_class_template.txt");
        String mainClassTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Write Main-class

        StringBuilder sb = new StringBuilder();
        String indent = StringUtils.repeat(" ", 20);
        for (int i = 1; i <= numOfRules; i++) {
            sb
                    .append(indent)
                    .append("new ")
                    .append(TableConsumer.class.getSimpleName())
                    .append(i)
                    .append("()");

            if (i < numOfRules)
                sb.append("(),").append(newLine);
        }
        String mainClassContent = String.format(mainClassTemplate, sb);

        // Write Main-class

        Files.createDirectories(outputPath);
        Path filePath = outputPath.resolve(String.format("%s.java", artifactId));
        Files.createFile(filePath);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath.toFile()));
        writer.write(mainClassContent);
        writer.flush();
        writer.close();
    }

}
