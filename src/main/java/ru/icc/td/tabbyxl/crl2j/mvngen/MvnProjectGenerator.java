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

    private File crlFile;
    private Path root;

    private Path tabbyxlPath;
    private Path outputPath;

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
        writeTableConsumerFiles(javaFiles);

        writePomFile();
        writeMainClassFile();
    }

    //private List<JavaFile> javaFiles;

    private List<JavaFile> generateSourceCode() throws IOException, RecognitionException {
        // Generate source code of the table consumers from rules

        final CRL2JEngine crl2jEngine = new CRL2JEngine(nameOfPackage);
        crl2jEngine.loadRules(crlFile);

        return crl2jEngine.getJavaFiles();
    }

    private void writeTableConsumerFiles(List<JavaFile> javaFiles) throws IOException, RecognitionException {
        // Write source code

        for (JavaFile javaFile : javaFiles)
            javaFile.writeTo(outputPath);
    }

    private void writePomFile() throws IOException {

        // Read pom-file template

        ClassLoader classLoader = getClass().getClassLoader();
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

    private void writeMainClassFile() throws IOException {

        // Read Main-class template

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mvngen/main-class.template");
        String mainClassTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Write Main-class

        Files.createDirectories(outputPath);
        Path filePath = outputPath.resolve(String.format("%s.java", mainClassName));
        Files.createFile(filePath);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath.toFile()));
        writer.write(mainClassTemplate);
        writer.flush();
        writer.close();
    }

}
