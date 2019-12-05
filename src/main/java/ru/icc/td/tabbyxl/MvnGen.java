package ru.icc.td.tabbyxl;

import org.antlr.runtime.RecognitionException;
import ru.icc.td.tabbyxl.crl2j.mvngen.MvnProjectGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MvnGen {

    public static void main(String[] args) {
        try {

            File crlFile = new File(args[0]);
            Path resultDirectory = Paths.get(args[1]);
            MvnProjectGenerator.generate(crlFile, resultDirectory);

        } catch (IOException | RecognitionException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
