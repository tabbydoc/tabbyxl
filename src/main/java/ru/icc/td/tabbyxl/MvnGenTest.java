package ru.icc.td.tabbyxl;

import org.antlr.runtime.RecognitionException;
import ru.icc.td.tabbyxl.crl2j.MvnProjectGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MvnGenTest {

    public static void main(String[] args) {

        Path projectRoot = Paths.get("d:\\Work\\TestMvnGenerator");
        String groupId = "ru.zkln";
        String artifactId = "TestMvnGen";
        File rulesetFile = Paths.get("D:\\Work\\TabbyDOC\\Tango2018b\\results\\crl2j\\rules.crl").toFile();

        MvnProjectGenerator mvnProjectGenerator = new MvnProjectGenerator(projectRoot);
        mvnProjectGenerator.setGroupID(groupId);
        mvnProjectGenerator.setArtifactID(artifactId);
        mvnProjectGenerator.setRuleSetFile(rulesetFile);

        try {
            mvnProjectGenerator.generate();
        } catch (IOException|RecognitionException e) {
            e.printStackTrace();
        }
    }
}
