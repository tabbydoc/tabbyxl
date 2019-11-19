package ru.icc.td.tabbyxl;

import org.antlr.runtime.RecognitionException;
import ru.icc.td.tabbyxl.crl2j.MvnProjectGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MvnGenRunner {

    public static void main(String[] args) {

        try {
            Path resultDirectory = Paths.get(args[0]);
            File rulesetFile = new File(args[1]);

            MvnProjectGenerator mvnProjectGenerator = new MvnProjectGenerator(resultDirectory, rulesetFile);

            mvnProjectGenerator.generate();
        } catch (IOException | RecognitionException e) {
            e.printStackTrace();
        }
    }
}
