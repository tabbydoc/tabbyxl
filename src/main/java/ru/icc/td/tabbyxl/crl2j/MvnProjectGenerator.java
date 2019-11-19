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
    private static final String indent = StringUtils.repeat(" ", 4);

    private static final String pomTemplateFileName = "pom_template.xml";
    private static final String groupId = "generated";
    private static final String artifactId = "SpreadsheetDataCanonicalizer";

    private File crlFile;
    private Path root;

    private Path tabbyxlPath;
    private Path packagePath;

    private int rulesCount;

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

        writePomFile();
        writeRuleClasses();
        writeMainClassFile();
    }

    private void writePomFile() throws IOException {

        final Path pathToPomFile = root.resolve("pom.xml");

        final ClassLoader classLoader = getClass().getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream(pomTemplateFileName);
        String pomTemplate = IOUtils.toString(inputStream);
        inputStream.close();

        String mainClass = String.format("%s.%s", groupId, artifactId);

        // TODO Можно ли считать эти свойства с POM-файла напрямую?
        Properties properties = new Properties();
        properties.load(classLoader.getResourceAsStream("tabbyxl.properties"));
        String tabbyxlGroupId = properties.getProperty("groupId");
        String tabbyxlArtifactId = properties.getProperty("artifactId");
        String tabbyxlVersion = properties.getProperty("version");

        pomTemplate = String.format(pomTemplate,
                groupId, artifactId,
                mainClass,
                tabbyxlPath.toAbsolutePath(),
                tabbyxlGroupId, tabbyxlArtifactId, tabbyxlVersion);

        FileOutputStream fos = new FileOutputStream(pathToPomFile.toFile());
        OutputStreamWriter streamWriter = new OutputStreamWriter(fos);
        streamWriter.write(pomTemplate);
        streamWriter.flush();
        streamWriter.close();
    }

    private void writeMainClassFile() throws IOException {

        Path outPath = packagePath.resolve(groupId.replace(".", File.separator));
        Files.createDirectories(outPath);

        Path filePath = outPath.resolve(String.format("%s.java", artifactId));
        Files.createFile(filePath);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("package ").append(groupId).append(";").append(newLine)
                .append(newLine)
                .append("import ru.icc.td.tabbyxl.DataLoader;").append(newLine)
                .append("import ru.icc.td.tabbyxl.model.*;").append(newLine)
                .append("import ").append(groupId).append(".rules.*;").append(newLine)
                .append(newLine)
                .append("import java.io.File;").append(newLine)
                .append("import java.io.IOException;").append(newLine)
                .append(newLine)
                .append("public class ") .append(artifactId).append(" {").append(newLine)
                .append(indent).append("public static void main(String[] args) {").append(newLine)
                .append(newLine)
                .append(indent).append(indent).append("try {").append(newLine)
                .append(indent).append(indent).append(indent).append("String inputExcelFilePath = args[0];").append(newLine)
                .append(indent).append(indent).append(indent).append("File inputExcelFile = new File(inputExcelFilePath);").append(newLine)
                .append(newLine)
                .append(indent).append(indent).append(indent).append("DataLoader dataLoader = DataLoader.getInstance();").append(newLine)
                .append(indent).append(indent).append(indent).append("dataLoader.loadWorkbook(inputExcelFile);").append(newLine)
                .append(newLine)
                .append(indent).append(indent).append(indent).append("for (int i = 0; i < dataLoader.numOfSheets(); i++) {").append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append("dataLoader.goToSheet(i);").append(newLine)
                .append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append("while (true) {").append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append(indent).append("CTable table = dataLoader.nextTable();").append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append(indent).append("if (null == table) break;").append(newLine)
                .append(newLine);

        for (int i = 1; i < rulesCount + 1; i ++) {
            stringBuilder
                    .append(indent).append(indent).append(indent).append(indent).append(indent)
                    .append("Rule").append(i).append(" rule").append(i).append(" = new Rule").append(i).append("(table);").append(newLine)
                    .append(indent).append(indent).append(indent).append(indent).append(indent)
                    .append("rule").append(i).append(".eval();").append(newLine)
                    .append(newLine);
        }

        stringBuilder
                .append(indent).append(indent).append(indent).append(indent).append(indent)
                .append("Tables.recoverCellBorders(table);").append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append(indent)
                .append("table.update();").append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append(indent)
                .append("System.out.println(table.trace());").append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append(indent)
                .append("table.toCanonicalForm().print();").append(newLine)
                .append(indent).append(indent).append(indent).append(indent).append("}").append(newLine)
                .append(indent).append(indent).append(indent).append("}").append(newLine)
                .append(indent).append(indent).append("} catch (IOException e) {").append(newLine)
                .append(indent).append(indent).append(indent).append("e.printStackTrace();").append(newLine)
                .append(indent).append(indent).append("}").append(newLine);

        stringBuilder
                .append(indent).append("}").append(newLine)
                .append("}");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath.toFile()));
        writer.write(stringBuilder.toString());
        writer.flush();
        writer.close();
    }

    private void writeRuleClasses() throws IOException, RecognitionException {

        Path outputDir = packagePath.resolve(groupId.replace(".", File.separator)).resolve("rules");

        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        } else {
            FileUtils.cleanDirectory(outputDir.toFile());
        }

        final String packageName = String.format("%s.rules", groupId);
        final CRL2JEngine crl2jEngine = new CRL2JEngine(packageName);

        crl2jEngine.loadRules(crlFile);
        List<String> classSourceCodes = crl2jEngine.getSourceCode();
        rulesCount = classSourceCodes.size();

        int index = 0;
        for (String sourceCodeString: classSourceCodes) {
            index ++;
            File outputFile = outputDir.resolve(String.format("Rule%d.java", index)).toFile();
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFile));
            writer.write(sourceCodeString);
            writer.flush();
            writer.close();
        }
    }
}
