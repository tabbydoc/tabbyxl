package ru.icc.cells.ssdc.engine.parsing;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        crl_gramLexer lex = new crl_gramLexer(new ANTLRFileStream("D:\\TabbyXLExperimentData\\data\\rules.dslr", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        crl_gramParser g = new crl_gramParser(tokens, 49100, null);
        try {
            g.crl();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}