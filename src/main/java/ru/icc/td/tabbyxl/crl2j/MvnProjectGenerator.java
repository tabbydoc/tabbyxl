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

import org.antlr.runtime.RecognitionException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class MvnProjectGenerator {

    private static final String newLine = System.lineSeparator();

    private static final String groupId = "generated";
    private static final String artifactId = "SpreadsheetDataCanonicalizer";

    private File crlFile;
    private Path root;

    private Path tabbyxlPath;
    private Path packagePath;

    private int numOfRules;

    public MvnProjectGenerator(Path root, File crlFile) {
        this.root = root;
        packagePath = root.resolve("src").resolve("main").resolve("java");
        tabbyxlPath = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath().replaceFirst("/", ""));

        this.crlFile = crlFile;
    }

    public void generate() throws IOException, RecognitionException {

        if (Files.notExists(root)) {
            Files.createDirectory(root);
        }
        else {
            FileUtils.cleanDirectory(root.toFile());
        }

        writeRuleClasses();
        writePomFile();
        writeMainClassFile();
    }

    private void writeRuleClasses() throws IOException, RecognitionException {

        // Generate source code

        String nameOfPackage = groupId.concat(".rules");
        final CRL2JEngine crl2jEngine = new CRL2JEngine(nameOfPackage);
        crl2jEngine.loadRules(crlFile);
        List<String> sourceCode = crl2jEngine.getSourceCode();

        // Clean or create the output directory

        Path outputDir = packagePath.resolve(groupId.replace(".", File.separator)).resolve("rules");

        if (Files.exists(outputDir)) {
            FileUtils.cleanDirectory(outputDir.toFile());
        } else {
            Files.createDirectories(outputDir);
        }

        // Write source code

        int index = 0;
        for (String sc: sourceCode) {
            index ++;

            String fileName = String.format("Rule%d.java", index);
            File outputFile = outputDir.resolve(fileName).toFile();
            FileOutputStream fos = new FileOutputStream(outputFile);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            writer.write(sc);
            writer.flush();
            writer.close();
        }

        numOfRules = sourceCode.size();
    }

    private void writePomFile() throws IOException {

        // Read POM template

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("pom_template.txt");
        String pomTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Fill POM template by properties

        String mainClass = String.format("%s.%s", groupId, artifactId);
        // TODO Можно ли считать эти свойства с POM-файла напрямую?
        Properties properties = new Properties();
        properties.load(classLoader.getResourceAsStream("tabbyxl.properties"));
        String tabbyxlGroupId = properties.getProperty("groupId");
        String tabbyxlArtifactId = properties.getProperty("artifactId");
        String tabbyxlVersion = properties.getProperty("version");

        String pomContent = String.format(pomTemplate,
                groupId, artifactId,
                mainClass,
                tabbyxlPath.toAbsolutePath(),
                tabbyxlGroupId, tabbyxlArtifactId, tabbyxlVersion);

        // Write POM file

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
        InputStream inputStream = classLoader.getResourceAsStream("main_class_template.txt");
        String mainClassTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        // Fill Main-class template by properties

        StringBuilder sb = new StringBuilder();
        String indent = StringUtils.repeat(" ", 20);
        for (int i = 1; i < numOfRules + 1; i ++) {
            sb
                    .append(indent)
                    .append("new Rule")
                    .append(i)
                    .append("(table).eval();")
                    .append(newLine);
        }
        String mainClassContent = String.format(mainClassTemplate, sb);

        // Write Main-class

        Path outPath = packagePath.resolve(groupId.replace(".", File.separator));
        Files.createDirectories(outPath);
        Path filePath = outPath.resolve(String.format("%s.java", artifactId));
        Files.createFile(filePath);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath.toFile()));
        writer.write(mainClassContent);
        writer.flush();
        writer.close();
    }

}
