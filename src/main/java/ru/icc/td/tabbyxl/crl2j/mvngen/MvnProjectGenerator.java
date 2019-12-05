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
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class MvnProjectGenerator {

    private static final String groupId = "generated";
    private static final String artifactId = "SpreadsheetTableCanonicalizer";

    private static final String packageName = "generated";
    private static final String mainClassName = "SpreadsheetTableCanonicalizer";

    private static final Class THIS_CLASS = MvnProjectGenerator.class;

    private MvnProjectGenerator() {}

    public static void generate(File crlFile, Path projectPath) throws IOException, RecognitionException {

        // Generate source code of the table consumers

        List<JavaFile> javaFiles = generateJavaFiles(crlFile);

        // Create or clean the project directory

        if (Files.notExists(projectPath))
            Files.createDirectory(projectPath);
        else
            FileUtils.cleanDirectory(projectPath.toFile());

        // Create the source code directory

        Path sourceCodePath = projectPath.resolve("src").resolve("main").resolve("java");
        Files.createDirectories(sourceCodePath);

        // Write the generated source code of the table consumers

        writeTableConsumerFiles(javaFiles, sourceCodePath);

        // Add main-class to the project

        writeMainClassFile(sourceCodePath);

        // Add pom file to the project

        writePomFile(projectPath);
    }

    private static List<JavaFile> generateJavaFiles(File crlFile) throws IOException, RecognitionException {

        // Generate source code of the table consumers from rules

        final CRL2JEngine crl2jEngine = new CRL2JEngine(packageName);
        crl2jEngine.loadRules(crlFile);

        return crl2jEngine.getJavaFiles();
    }

    private static void writeTableConsumerFiles(List<JavaFile> javaFiles, Path sourceCodePath) throws IOException {
        for (JavaFile javaFile : javaFiles)
            javaFile.writeTo(sourceCodePath);
    }

    private static void writeMainClassFile(Path sourceCodePath) throws IOException {

        // Read Main-class template

        ClassLoader classLoader = THIS_CLASS.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("mvngen/main-class.template");
        String mainClassTemplate = IOUtils.toString(in);
        in.close();

        // Write Main-class

        Files.createDirectories(sourceCodePath);
        Path filePath = sourceCodePath.resolve(mainClassName + ".java");
        Files.createFile(filePath);
        FileOutputStream out = new FileOutputStream(filePath.toFile());
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write(mainClassTemplate);
        writer.flush();
        writer.close();
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

        String path = null;
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
