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
import ru.icc.td.tabbyxl.crl2j.CRL2JEngine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class MvnProjectGenerator {

    private static final String groupId = "generated";
    private static final String artifactId = "SpreadsheetTableCanonicalizer";
    private static final String mainClassName = "SpreadsheetTableCanonicalizer";
    private static final String nameOfPackage = "generated";

    private MvnProjectGenerator() {}

    public static void generate(File crlFile, Path projectPath) throws IOException, RecognitionException {

        // Generate source code of the table consumers

        List<JavaFile> javaFiles = generateJavaFiles(crlFile);

        // Create or clean the project directory

        if (Files.notExists(projectPath))
            Files.createDirectory(projectPath);
        else
            FileUtils.cleanDirectory(projectPath.toFile());

        // Create or clean the source code directory

        Path sourceCodePath = projectPath.resolve("src").resolve("main").resolve("java");

        if (Files.exists(sourceCodePath))
            FileUtils.cleanDirectory(sourceCodePath.toFile());
        else
            Files.createDirectories(sourceCodePath);

        // Write the generated source code of the table consumers

        writeTableConsumerFiles(javaFiles, sourceCodePath);

        // Add pom file to the project

        writePomFile(projectPath);

        // Add main-class to the project

        writeMainClassFile(sourceCodePath);
    }

    private static List<JavaFile> generateJavaFiles(File crlFile) throws IOException, RecognitionException {
        // Generate source code of the table consumers from rules

        final CRL2JEngine crl2jEngine = new CRL2JEngine(nameOfPackage);
        crl2jEngine.loadRules(crlFile);

        return crl2jEngine.getJavaFiles();
    }

    private static void writeTableConsumerFiles(List<JavaFile> javaFiles, Path sourceCodePath) throws IOException {
        for (JavaFile javaFile : javaFiles)
            javaFile.writeTo(sourceCodePath);
    }

    private static final Class THIS_CLASS = MvnProjectGenerator.class;

    private static void writePomFile(Path projectPath) throws IOException {

        // Read pom-file template

        ClassLoader classLoader = THIS_CLASS.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mvngen/pom.template");
        String pomTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Read pom properties

        String mainClass = String.format("%s.%s", groupId, artifactId);

        Properties properties = new Properties();
        properties.load(classLoader.getResourceAsStream("pom.properties"));
        String tabbyxlGroupId = properties.getProperty("groupId");
        String tabbyxlArtifactId = properties.getProperty("artifactId");
        String tabbyxlVersion = properties.getProperty("version");

        // Get the path to the tabbyxl classes
        String path = THIS_CLASS.getProtectionDomain().getCodeSource().getLocation().getPath().replaceFirst("/", "");
        Path tabbyxlPath = Paths.get(path);

        // Fill pom-file template by using the appropriate properties

        String pomContent = String.format(pomTemplate,
                groupId, artifactId,
                mainClass,
                tabbyxlPath.toAbsolutePath(),
                tabbyxlGroupId, tabbyxlArtifactId, tabbyxlVersion);

        // Write pom-file

        final Path pathToPomFile = projectPath.resolve("pom.xml");
        FileOutputStream fos = new FileOutputStream(pathToPomFile.toFile());
        OutputStreamWriter streamWriter = new OutputStreamWriter(fos);
        streamWriter.write(pomContent);
        streamWriter.flush();
        streamWriter.close();
    }

    private static void writeMainClassFile(Path sourceCodePath) throws IOException {

        // Read Main-class template

        ClassLoader classLoader = THIS_CLASS.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mvngen/main-class.template");
        String mainClassTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Write Main-class

        Files.createDirectories(sourceCodePath);
        Path filePath = sourceCodePath.resolve(String.format("%s.java", mainClassName));
        Files.createFile(filePath);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath.toFile()));
        writer.write(mainClassTemplate);
        writer.flush();
        writer.close();
    }
}
