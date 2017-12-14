package ru.icc.cells.ssdc.interpreeter.output;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        crl_gramLexer lex = new crl_gramLexer(new ANTLRFileStream("C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        crl_gramParser g = new crl_gramParser(tokens, null);
        try {
            g.crl();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}