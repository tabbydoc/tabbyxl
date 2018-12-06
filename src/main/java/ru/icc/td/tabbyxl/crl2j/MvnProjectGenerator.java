package ru.icc.td.tabbyxl.crl2j;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import ru.icc.td.tabbyxl.crl2j.parsing.crl_gramLexer;
import ru.icc.td.tabbyxl.crl2j.parsing.crl_gramParser;
import ru.icc.td.tabbyxl.crl2j.rulemodel.Rule;
import ru.icc.td.tabbyxl.crl2j.rulemodel.Ruleset;
import ru.icc.td.tabbyxl.crl2j.synthesis.RuleProgramPrototype;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MvnProjectGenerator {

    private final String pomSample = "src\\main\\resources\\pom_sample.xml";

    private File ruleSetFile;
    private Path root;
    private String groupID;
    private String artifactID;
    private Path pomFile;
    private Path tabbyxlPath = Paths.get("d:/Work/TabbyDOC/tabbyxl2-1/target/TabbyXL2-1.0.1-jar-with-dependencies.jar");

    public MvnProjectGenerator(Path root) {
        this.root = root;
        //this.pomFile = root.resolve("pom.xml");
    }

    public void generate() throws IOException, RecognitionException {

        if (Files.notExists(root)) {
            Files.createDirectory(root);
        }
        else {
            FileUtils.cleanDirectory(root.toFile());
        }

        writePomFile();
        writeProgramFile();
        writeRuleClasses();

    }

    private void writePomFile () throws IOException {

        pomFile = root.resolve("pomx.xml");
        //tabbyxlPath = Paths.get(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        tabbyxlPath = Paths.get("D:\\Work\\TabbyDOC\\tabbyxl2-1\\target\\TabbyXL2-1.0.1-jar-with-dependencies.jar");

        FileInputStream inputStream = new FileInputStream(pomSample);
        String pomContent = IOUtils.toString(inputStream);
        inputStream.close();

        pomContent = String.format(pomContent, tabbyxlPath.toAbsolutePath(), groupID, artifactID, String.format("%s.Program", groupID));

        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(pomFile.toFile()));
        streamWriter.write(pomContent);
        streamWriter.flush();
        streamWriter.close();

    }

    private void writeProgramFile() throws IOException {

        Path packagePath = root.resolve("src").resolve("main").resolve("java");

        for (String part:groupID.split("\\.")) {
            packagePath = packagePath.resolve(part);
        }
        Files.createDirectories(packagePath);

        Path filePath = packagePath.resolve("Program.java");
        Files.createFile(filePath);

        String lineSep = System.lineSeparator();
        String indent = "   ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("package ").append(groupID).append(";").append(lineSep)
                .append(lineSep)
                .append("import ru.icc.td.tabbyxl.model.*;").append(lineSep)
                .append(lineSep)
                .append("public class Program {").append(lineSep)
                .append(indent).append("public static void main(String[] args) {").append(lineSep)
                .append(lineSep)
                .append(indent).append("}").append(lineSep)
                .append("}");

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath.toFile()));
        writer.write(stringBuilder.toString());
        writer.flush();
        writer.close();
    }

    private void writeRuleClasses() throws IOException, RecognitionException {

        ANTLRFileStream fileStream = new ANTLRFileStream(ruleSetFile.getPath());
        crl_gramLexer lexer = new crl_gramLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        crl_gramParser parser = new crl_gramParser(tokenStream);
        CommonTree tree = parser.crl().getTree();

        RuleModelBuilder modelBuilder = new RuleModelBuilder();
        modelBuilder.buildModel(tree);
        Ruleset ruleset = modelBuilder.getRuleset();

        Path rulesPath = root.resolve("src").resolve("main").resolve("java");
        for (String path:groupID.split("\\.")) {
            rulesPath = rulesPath.resolve(path);
        }
        rulesPath = rulesPath.resolve("rules");

        Files.createDirectory(rulesPath);

        for (Rule rule:ruleset.getRules()) {

            Path rulePath = rulesPath.resolve(String.format("Rule%d.java", rule.getNum()));

            Files.createFile(rulePath);

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(rulePath.toFile()));

            String code = RuleCodeGen.fetchCodeFromRule(rule, ruleset.getImports()).toString();
            writer.write(code);

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
