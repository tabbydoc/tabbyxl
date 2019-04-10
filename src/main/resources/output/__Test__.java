import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        CrlLexer lex = new CrlLexer(new ANTLRFileStream("D:\\Work\\TabbyDOC\\Tango2018b\\results\\crl2j\\rules.crl", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        CrlParser g = new CrlParser(tokens, 49100, null);
        try {
            g.crl();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}