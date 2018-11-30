package ru.icc.cells.ssdc;

import org.antlr.runtime.RecognitionException;
import ru.icc.cells.ssdc.crl2j.MavenGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MvnGenTest {

    public static void main(String[] args) {

        Path projectRoot = Paths.get("d:\\Work\\TestMvnGenerator");
        String groupId = "ru.zkln";
        String artifactId = "TestMvnGen";

        MavenGenerator mavenGenerator = new MavenGenerator(projectRoot);
        mavenGenerator.setGroupID(groupId);
        mavenGenerator.setArtifactID(artifactId);

        try {
            mavenGenerator.generate();
        } catch (IOException|RecognitionException e) {
            e.printStackTrace();
        }
    }
}
