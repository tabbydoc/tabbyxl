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

    private static final String pomSample = "pom_sample.xml";

    private static final String newLine = System.lineSeparator();
    private static final String indent = StringUtils.repeat(" ", 4);

    private File ruleSetFile;
    private Path root;
    private String groupID;
    private String artifactID;
    private Path pomFile;
    private Path tabbyxlPath;
    private Path packagePath;

    private CodeGenerator codeGenerator;

    private int rulesCount;

    public MvnProjectGenerator(Path root) {
        this.root = root;
        packagePath = root.resolve("src").resolve("main").resolve("java");
        tabbyxlPath = Paths.get(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath().replaceFirst("/", ""));
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

    private void writePomFile () throws IOException {

        pomFile = root.resolve("pom.xml");

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(pomSample);
        String pomContent = IOUtils.toString(inputStream);
        inputStream.close();

        Properties tabbyProperties = new Properties();
        tabbyProperties.load(this.getClass().getClassLoader().getResourceAsStream("tabbyxl.properties"));

        String tabbyGroupId = tabbyProperties.getProperty("groupId");
        String tabbyArtifactId = tabbyProperties.getProperty("artifactId");
        String tabbyVersion = tabbyProperties.getProperty("version");

        pomContent = String.format(pomContent, tabbyxlPath.toAbsolutePath(), groupID, artifactID, String.format("%s.%s", groupID, artifactID), tabbyGroupId, tabbyArtifactId, tabbyVersion);

        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(pomFile.toFile()));
        streamWriter.write(pomContent);
        streamWriter.flush();
        streamWriter.close();

    }

    private void writeMainClassFile() throws IOException {

        Path outPath = packagePath.resolve(groupID.replace(".", File.separator));
        Files.createDirectories(outPath);

        Path filePath = outPath.resolve(String.format("%s.java", artifactID));
        Files.createFile(filePath);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("package ").append(groupID).append(";").append(newLine)
                .append(newLine)
                .append("import ru.icc.td.tabbyxl.DataLoader;").append(newLine)
                .append("import ru.icc.td.tabbyxl.model.*;").append(newLine)
                .append("import ").append(groupID).append(".rules.*;").append(newLine)
                .append(newLine)
                .append("import java.io.File;").append(newLine)
                .append("import java.io.IOException;").append(newLine)
                .append(newLine)
                .append("public class ") .append(artifactID).append(" {").append(newLine)
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

        codeGenerator = new CodeGenerator();
        codeGenerator.loadRuleset(ruleSetFile);
        codeGenerator.setPack(String.format("%s.rules", groupID));

        Path outputDir = packagePath.resolve(groupID.replace(".", File.separator)).resolve("rules");
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        } else {
            FileUtils.cleanDirectory(outputDir.toFile());
        }

        List<String> rules = codeGenerator.generateCodeFromAllRules();
        rulesCount = rules.size();

        int index = 0;
        for (String rule: rules) {
            index ++;
            File outputFile = outputDir.resolve(String.format("Rule%d.java", index)).toFile();
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFile));
            writer.write(rule);
            writer.flush();
            writer.close();
        }
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String value) {
        this.groupID = value;
    }

    public String getArtifactID() {
        return artifactID;
    }

    public void setArtifactID(String artifactID) {
        this.artifactID = artifactID;
    }

    public void setRuleSetFile(File ruleSetFile) {
        this.ruleSetFile = ruleSetFile;
    }
}
