// $ANTLR 3.4 D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g 2019-04-09 22:57:09

package ru.icc.td.tabbyxl.crl2j.parsing;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CrlLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int ADV_IDENT=4;
    public static final int ADV_IDENT1=5;
    public static final int ADV_IDENT2=6;
    public static final int Action=7;
    public static final int Actions=8;
    public static final int AddLabelAction=9;
    public static final int Assignment=10;
    public static final int Breackits=11;
    public static final int CATEGORY=12;
    public static final int Char_lit=13;
    public static final int Condition=14;
    public static final int Conditions=15;
    public static final int Constraint=16;
    public static final int DIGIT=17;
    public static final int EOL=18;
    public static final int GroupAction=19;
    public static final int IDENT=20;
    public static final int IDENT1=21;
    public static final int IDENT2=22;
    public static final int INT=23;
    public static final int Identifier=24;
    public static final int Import_item=25;
    public static final int Imports=26;
    public static final int J_expr=27;
    public static final int J_int_literal=28;
    public static final int LABEL=29;
    public static final int LETTER=30;
    public static final int MergeAction=31;
    public static final int NewEntryAction=32;
    public static final int NewLabelAction=33;
    public static final int No_condition=34;
    public static final int Other_literals=35;
    public static final int Package=36;
    public static final int PrintAction=37;
    public static final int RULES=38;
    public static final int STRING=39;
    public static final int SetCategoryAction=40;
    public static final int SetIndentAction=41;
    public static final int SetMarkAction=42;
    public static final int SetParentAction=43;
    public static final int SetTextAction=44;
    public static final int SetValueAction=45;
    public static final int SplitAction=46;
    public static final int String_lit=47;
    public static final int UpdateAction=48;
    public static final int WS=49;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CrlLexer() {} 
    public CrlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CrlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g"; }

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:8:7: ( '\"' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:8:9: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:9:7: ( '*' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:9:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:10:7: ( ',' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:10:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:11:7: ( '.' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:11:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:12:7: ( ':' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:12:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:13:7: ( ';' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:13:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:14:7: ( '[' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:14:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:15:7: ( ']' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:15:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:16:7: ( 'add label' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:16:9: 'add label'
            {
            match("add label"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:17:7: ( 'as' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:17:9: 'as'
            {
            match("as"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:18:7: ( 'category' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:18:9: 'category'
            {
            match("category"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:19:7: ( 'cell' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:19:9: 'cell'
            {
            match("cell"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:20:7: ( 'end' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:20:9: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:21:7: ( 'entry' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:21:9: 'entry'
            {
            match("entry"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:22:7: ( 'group' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:22:9: 'group'
            {
            match("group"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:23:7: ( 'import' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:23:9: 'import'
            {
            match("import"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:24:7: ( 'label' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:24:9: 'label'
            {
            match("label"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:25:7: ( 'lock-on-active' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:25:9: 'lock-on-active'
            {
            match("lock-on-active"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:26:7: ( 'merge' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:26:9: 'merge'
            {
            match("merge"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:27:7: ( 'new entry' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:27:9: 'new entry'
            {
            match("new entry"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:28:7: ( 'new label' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:28:9: 'new label'
            {
            match("new label"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:29:7: ( 'no categories' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:29:9: 'no categories'
            {
            match("no categories"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:30:7: ( 'no cells' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:30:9: 'no cells'
            {
            match("no cells"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:31:7: ( 'no entries' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:31:9: 'no entries'
            {
            match("no entries"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:32:7: ( 'no labels' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:32:9: 'no labels'
            {
            match("no labels"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:33:7: ( 'no-loop false' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:33:9: 'no-loop false'
            {
            match("no-loop false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:34:7: ( 'no-loop true' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:34:9: 'no-loop true'
            {
            match("no-loop true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:35:7: ( 'of' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:35:9: 'of'
            {
            match("of"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:36:7: ( 'package' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:36:9: 'package'
            {
            match("package"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:37:7: ( 'print' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:37:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:38:7: ( 'printf' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:38:9: 'printf'
            {
            match("printf"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:39:7: ( 'rule #' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:39:9: 'rule #'
            {
            match("rule #"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:40:7: ( 'set category' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:40:9: 'set category'
            {
            match("set category"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:41:7: ( 'set indent' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:41:9: 'set indent'
            {
            match("set indent"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:42:7: ( 'set mark' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:42:9: 'set mark'
            {
            match("set mark"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:43:7: ( 'set parent' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:43:9: 'set parent'
            {
            match("set parent"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:44:7: ( 'set text' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:44:9: 'set text'
            {
            match("set text"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:45:7: ( 'set value' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:45:9: 'set value'
            {
            match("set value"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:46:7: ( 'split' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:46:9: 'split'
            {
            match("split"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:47:7: ( 'then' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:47:9: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:48:7: ( 'to' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:48:9: 'to'
            {
            match("to"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:49:7: ( 'update' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:49:9: 'update'
            {
            match("update"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:50:7: ( 'when' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:50:9: 'when'
            {
            match("when"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:51:7: ( 'with' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:51:9: 'with'
            {
            match("with"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:211:2: ( ( ' ' | '\\t' )+ )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:211:5: ( ' ' | '\\t' )+
            {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:211:5: ( ' ' | '\\t' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "EOL"
    public final void mEOL() throws RecognitionException {
        try {
            int _type = EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:215:2: ( ( '\\n' | '\\r' )+ )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:215:4: ( '\\n' | '\\r' )+
            {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:215:4: ( '\\n' | '\\r' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\n'||LA2_0=='\r') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EOL"

    // $ANTLR start "J_int_literal"
    public final void mJ_int_literal() throws RecognitionException {
        try {
            int _type = J_int_literal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:218:2: ( ( DIGIT )+ )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:218:4: ( DIGIT )+
            {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:218:4: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "J_int_literal"

    // $ANTLR start "Other_literals"
    public final void mOther_literals() throws RecognitionException {
        try {
            int _type = Other_literals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:2: ( '=' | '!' | '?' | '|' | '>' | '<' | '==' | '>=' | '<=' | '!=' | '+' | '-' | '*' | '/' | '%' | '^' | '&' )
            int alt4=17;
            switch ( input.LA(1) ) {
            case '=':
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='=') ) {
                    alt4=7;
                }
                else {
                    alt4=1;
                }
                }
                break;
            case '!':
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2=='=') ) {
                    alt4=10;
                }
                else {
                    alt4=2;
                }
                }
                break;
            case '?':
                {
                alt4=3;
                }
                break;
            case '|':
                {
                alt4=4;
                }
                break;
            case '>':
                {
                int LA4_5 = input.LA(2);

                if ( (LA4_5=='=') ) {
                    alt4=8;
                }
                else {
                    alt4=5;
                }
                }
                break;
            case '<':
                {
                int LA4_6 = input.LA(2);

                if ( (LA4_6=='=') ) {
                    alt4=9;
                }
                else {
                    alt4=6;
                }
                }
                break;
            case '+':
                {
                alt4=11;
                }
                break;
            case '-':
                {
                alt4=12;
                }
                break;
            case '*':
                {
                alt4=13;
                }
                break;
            case '/':
                {
                alt4=14;
                }
                break;
            case '%':
                {
                alt4=15;
                }
                break;
            case '^':
                {
                alt4=16;
                }
                break;
            case '&':
                {
                alt4=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:4: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:8: '!'
                    {
                    match('!'); 

                    }
                    break;
                case 3 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:12: '?'
                    {
                    match('?'); 

                    }
                    break;
                case 4 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:16: '|'
                    {
                    match('|'); 

                    }
                    break;
                case 5 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:20: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 6 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:24: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 7 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:28: '=='
                    {
                    match("=="); 



                    }
                    break;
                case 8 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:33: '>='
                    {
                    match(">="); 



                    }
                    break;
                case 9 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:38: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 10 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:43: '!='
                    {
                    match("!="); 



                    }
                    break;
                case 11 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:48: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 12 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:52: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 13 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:56: '*'
                    {
                    match('*'); 

                    }
                    break;
                case 14 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:60: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 15 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:64: '%'
                    {
                    match('%'); 

                    }
                    break;
                case 16 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:68: '^'
                    {
                    match('^'); 

                    }
                    break;
                case 17 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:221:72: '&'
                    {
                    match('&'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Other_literals"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:224:2: ( ( '$' | '_' | LETTER | DIGIT ) ( '$' | '_' | LETTER | DIGIT )* )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:224:4: ( '$' | '_' | LETTER | DIGIT ) ( '$' | '_' | LETTER | DIGIT )*
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:224:26: ( '$' | '_' | LETTER | DIGIT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='$'||(LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "String_lit"
    public final void mString_lit() throws RecognitionException {
        try {
            int _type = String_lit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:231:2: ( '\"' ( . )* '\"' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:231:4: '\"' ( . )* '\"'
            {
            match('\"'); 

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:231:8: ( . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\"') ) {
                    alt6=2;
                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:231:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "String_lit"

    // $ANTLR start "Char_lit"
    public final void mChar_lit() throws RecognitionException {
        try {
            int _type = Char_lit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:235:2: ( '\\'' ( . ) '\\'' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:235:4: '\\'' ( . ) '\\''
            {
            match('\''); 

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:235:9: ( . )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:235:10: .
            {
            matchAny(); 

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Char_lit"

    // $ANTLR start "Breackits"
    public final void mBreackits() throws RecognitionException {
        try {
            int _type = Breackits;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:238:2: ( '(' | ')' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            {
            if ( (input.LA(1) >= '(' && input.LA(1) <= ')') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Breackits"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:250:2: ( '0' .. '9' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:253:2: ( 'A' .. 'Z' | 'a' .. 'z' )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    public void mTokens() throws RecognitionException {
        // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:8: ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | WS | EOL | J_int_literal | Other_literals | Identifier | String_lit | Char_lit | Breackits )
        int alt7=52;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:10: T__50
                {
                mT__50(); 


                }
                break;
            case 2 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:16: T__51
                {
                mT__51(); 


                }
                break;
            case 3 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:22: T__52
                {
                mT__52(); 


                }
                break;
            case 4 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:28: T__53
                {
                mT__53(); 


                }
                break;
            case 5 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:34: T__54
                {
                mT__54(); 


                }
                break;
            case 6 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:40: T__55
                {
                mT__55(); 


                }
                break;
            case 7 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:46: T__56
                {
                mT__56(); 


                }
                break;
            case 8 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:52: T__57
                {
                mT__57(); 


                }
                break;
            case 9 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:58: T__58
                {
                mT__58(); 


                }
                break;
            case 10 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:64: T__59
                {
                mT__59(); 


                }
                break;
            case 11 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:70: T__60
                {
                mT__60(); 


                }
                break;
            case 12 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:76: T__61
                {
                mT__61(); 


                }
                break;
            case 13 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:82: T__62
                {
                mT__62(); 


                }
                break;
            case 14 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:88: T__63
                {
                mT__63(); 


                }
                break;
            case 15 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:94: T__64
                {
                mT__64(); 


                }
                break;
            case 16 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:100: T__65
                {
                mT__65(); 


                }
                break;
            case 17 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:106: T__66
                {
                mT__66(); 


                }
                break;
            case 18 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:112: T__67
                {
                mT__67(); 


                }
                break;
            case 19 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:118: T__68
                {
                mT__68(); 


                }
                break;
            case 20 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:124: T__69
                {
                mT__69(); 


                }
                break;
            case 21 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:130: T__70
                {
                mT__70(); 


                }
                break;
            case 22 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:136: T__71
                {
                mT__71(); 


                }
                break;
            case 23 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:142: T__72
                {
                mT__72(); 


                }
                break;
            case 24 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:148: T__73
                {
                mT__73(); 


                }
                break;
            case 25 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:154: T__74
                {
                mT__74(); 


                }
                break;
            case 26 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:160: T__75
                {
                mT__75(); 


                }
                break;
            case 27 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:166: T__76
                {
                mT__76(); 


                }
                break;
            case 28 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:172: T__77
                {
                mT__77(); 


                }
                break;
            case 29 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:178: T__78
                {
                mT__78(); 


                }
                break;
            case 30 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:184: T__79
                {
                mT__79(); 


                }
                break;
            case 31 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:190: T__80
                {
                mT__80(); 


                }
                break;
            case 32 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:196: T__81
                {
                mT__81(); 


                }
                break;
            case 33 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:202: T__82
                {
                mT__82(); 


                }
                break;
            case 34 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:208: T__83
                {
                mT__83(); 


                }
                break;
            case 35 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:214: T__84
                {
                mT__84(); 


                }
                break;
            case 36 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:220: T__85
                {
                mT__85(); 


                }
                break;
            case 37 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:226: T__86
                {
                mT__86(); 


                }
                break;
            case 38 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:232: T__87
                {
                mT__87(); 


                }
                break;
            case 39 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:238: T__88
                {
                mT__88(); 


                }
                break;
            case 40 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:244: T__89
                {
                mT__89(); 


                }
                break;
            case 41 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:250: T__90
                {
                mT__90(); 


                }
                break;
            case 42 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:256: T__91
                {
                mT__91(); 


                }
                break;
            case 43 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:262: T__92
                {
                mT__92(); 


                }
                break;
            case 44 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:268: T__93
                {
                mT__93(); 


                }
                break;
            case 45 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:274: WS
                {
                mWS(); 


                }
                break;
            case 46 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:277: EOL
                {
                mEOL(); 


                }
                break;
            case 47 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:281: J_int_literal
                {
                mJ_int_literal(); 


                }
                break;
            case 48 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:295: Other_literals
                {
                mOther_literals(); 


                }
                break;
            case 49 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:310: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 50 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:321: String_lit
                {
                mString_lit(); 


                }
                break;
            case 51 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:332: Char_lit
                {
                mChar_lit(); 


                }
                break;
            case 52 :
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:1:341: Breackits
                {
                mBreackits(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\37\7\uffff\17\34\2\uffff\1\71\7\uffff\1\34\1\74\12\34"+
        "\1\111\6\34\1\120\3\34\1\uffff\1\71\1\34\1\uffff\2\34\1\127\7\34"+
        "\3\uffff\6\34\1\uffff\3\34\1\uffff\1\34\1\155\1\uffff\6\34\5\uffff"+
        "\3\34\1\uffff\1\34\1\u0083\1\34\1\u0085\1\u0086\1\34\1\uffff\1\u0088"+
        "\1\u0089\1\34\1\u008b\1\uffff\1\u008c\5\uffff\1\34\1\u0090\7\uffff"+
        "\1\u0091\1\uffff\1\34\2\uffff\1\34\2\uffff\1\u0094\3\uffff\1\34"+
        "\1\u0097\2\uffff\1\u0098\1\34\2\uffff\1\u009b\2\uffff\1\u009c\5"+
        "\uffff";
    static final String DFA7_eofS =
        "\u009f\uffff";
    static final String DFA7_minS =
        "\1\11\1\0\7\uffff\1\144\1\141\1\156\1\162\1\155\1\141\2\145\1\146"+
        "\1\141\1\165\1\145\1\150\1\160\1\150\2\uffff\1\44\7\uffff\1\144"+
        "\1\44\1\164\1\154\1\144\1\157\1\160\1\142\1\143\1\162\1\167\1\40"+
        "\1\44\1\143\1\151\1\154\1\164\1\154\1\145\1\44\1\144\1\145\1\164"+
        "\1\uffff\1\44\1\40\1\uffff\1\145\1\154\1\44\1\162\1\165\1\157\1"+
        "\145\1\153\1\147\1\40\1\143\1\154\1\uffff\1\153\1\156\1\145\1\40"+
        "\1\151\1\156\1\uffff\1\141\1\156\1\150\1\uffff\1\147\1\44\1\uffff"+
        "\1\171\1\160\1\162\1\154\1\55\2\145\1\141\2\uffff\1\157\1\141\1"+
        "\164\1\40\1\143\1\164\1\44\1\164\2\44\1\157\1\uffff\2\44\1\164\1"+
        "\44\1\uffff\1\44\4\uffff\1\157\1\147\1\44\7\uffff\1\44\1\uffff\1"+
        "\145\2\uffff\1\162\2\uffff\1\44\2\uffff\1\160\1\145\1\44\2\uffff"+
        "\1\44\1\171\1\uffff\1\40\1\44\2\uffff\1\44\1\146\4\uffff";
    static final String DFA7_maxS =
        "\1\174\1\uffff\7\uffff\1\163\1\145\1\156\1\162\1\155\1\157\1\145"+
        "\1\157\1\146\1\162\1\165\1\160\1\157\1\160\1\151\2\uffff\1\172\7"+
        "\uffff\1\144\1\172\1\164\1\154\1\164\1\157\1\160\1\142\1\143\1\162"+
        "\1\167\1\55\1\172\1\143\1\151\1\154\1\164\1\154\1\145\1\172\1\144"+
        "\1\145\1\164\1\uffff\1\172\1\40\1\uffff\1\145\1\154\1\172\1\162"+
        "\1\165\1\157\1\145\1\153\1\147\1\40\2\154\1\uffff\1\153\1\156\1"+
        "\145\1\40\1\151\1\156\1\uffff\1\141\1\156\1\150\1\uffff\1\147\1"+
        "\172\1\uffff\1\171\1\160\1\162\1\154\1\55\1\145\1\154\1\145\2\uffff"+
        "\1\157\1\141\1\164\1\40\1\166\1\164\1\172\1\164\2\172\1\157\1\uffff"+
        "\2\172\1\164\1\172\1\uffff\1\172\4\uffff\1\157\1\147\1\172\7\uffff"+
        "\1\172\1\uffff\1\145\2\uffff\1\162\2\uffff\1\172\2\uffff\1\160\1"+
        "\145\1\172\2\uffff\1\172\1\171\1\uffff\1\40\1\172\2\uffff\1\172"+
        "\1\164\4\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\17\uffff\1\55\1\56\1\uffff"+
        "\1\60\1\61\1\63\1\64\1\1\1\62\1\2\27\uffff\1\57\2\uffff\1\12\14"+
        "\uffff\1\34\6\uffff\1\51\3\uffff\1\11\2\uffff\1\15\10\uffff\1\30"+
        "\1\31\13\uffff\1\14\4\uffff\1\22\1\uffff\1\24\1\25\1\26\1\27\3\uffff"+
        "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\uffff\1\50\1\uffff\1\53\1"+
        "\54\1\uffff\1\16\1\17\1\uffff\1\21\1\23\3\uffff\1\36\1\47\2\uffff"+
        "\1\20\2\uffff\1\37\1\52\2\uffff\1\35\1\13\1\32\1\33";
    static final String DFA7_specialS =
        "\1\uffff\1\0\u009d\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\30\1\31\2\uffff\1\31\22\uffff\1\30\1\33\1\1\1\uffff\1\34"+
            "\2\33\1\35\2\36\1\2\1\33\1\3\1\33\1\4\1\33\12\32\1\5\1\6\4\33"+
            "\1\uffff\32\34\1\7\1\uffff\1\10\1\33\1\34\1\uffff\1\11\1\34"+
            "\1\12\1\34\1\13\1\34\1\14\1\34\1\15\2\34\1\16\1\17\1\20\1\21"+
            "\1\22\1\34\1\23\1\24\1\25\1\26\1\34\1\27\3\34\1\uffff\1\33",
            "\0\40",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\42\16\uffff\1\43",
            "\1\44\3\uffff\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51\15\uffff\1\52",
            "\1\53",
            "\1\54\11\uffff\1\55",
            "\1\56",
            "\1\57\20\uffff\1\60",
            "\1\61",
            "\1\62\12\uffff\1\63",
            "\1\64\6\uffff\1\65",
            "\1\66",
            "\1\67\1\70",
            "",
            "",
            "\1\34\13\uffff\12\72\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\73",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\75",
            "\1\76",
            "\1\77\17\uffff\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107\14\uffff\1\110",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\121",
            "\1\122",
            "\1\123",
            "",
            "\1\34\13\uffff\12\72\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\124",
            "",
            "\1\125",
            "\1\126",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137\1\uffff\1\140\6\uffff\1\141",
            "\1\142",
            "",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "",
            "\1\151",
            "\1\152",
            "\1\153",
            "",
            "\1\154",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164\6\uffff\1\165",
            "\1\166\3\uffff\1\167",
            "",
            "",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174\5\uffff\1\175\3\uffff\1\176\2\uffff\1\177\3\uffff\1"+
            "\u0080\1\uffff\1\u0081",
            "\1\u0082",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\u0084",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\u0087",
            "",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\u008a",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\5\34"+
            "\1\u008f\24\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "\1\u0092",
            "",
            "",
            "\1\u0093",
            "",
            "",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "",
            "\1\u0095",
            "\1\u0096",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "",
            "\1\34\13\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\u009d\15\uffff\1\u009e",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | WS | EOL | J_int_literal | Other_literals | Identifier | String_lit | Char_lit | Breackits );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_1 = input.LA(1);

                        s = -1;
                        if ( ((LA7_1 >= '\u0000' && LA7_1 <= '\uFFFF')) ) {s = 32;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}