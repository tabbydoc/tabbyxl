package ru.icc.cells.ssdc.interpreeter.output;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        crl_gramLexer lex = new crl_gramLexer(new ANTLRFileStream("C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        crl_gramParser g = new crl_gramParser(tokens);
        try {
            g.crl();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}