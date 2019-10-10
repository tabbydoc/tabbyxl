// $ANTLR 3.4 D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g 2019-06-20 08:40:29

package ru.icc.td.tabbyxl.crl2j.parsing;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class CrlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTIONS", "ASSIGNMENT", "BRACKET", "CHAR", "COMMENT", "CONDITION", "CONDITIONS", "CONSTRAINT", "CONSTRAINTS", "EOL", "ESC_SEQ", "EXPONENT", "EXPRESSION", "FLOAT", "HEX_DIGIT", "ID", "IDENTIFIER", "IMPORT", "IMPORTS", "INT", "OCTAL_ESC", "OPERAND", "OPERATOR", "QUERY", "RULE", "RULES", "STRING", "TYPE", "UNICODE_ESC", "WS", "','", "'.'", "'.*'", "':'", "';'", "'add label'", "'as'", "'categories'", "'category'", "'cell'", "'cells'", "'end'", "'entries'", "'entry'", "'group'", "'import'", "'label'", "'labels'", "'merge'", "'new entry'", "'new label'", "'no'", "'of'", "'print'", "'printf'", "'rule #'", "'set category'", "'set indent'", "'set mark'", "'set parent'", "'set text'", "'set value'", "'split'", "'then'", "'to'", "'update'", "'when'", "'with'"
    };

    public static final int EOF=-1;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
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
    public static final int ACTION=4;
    public static final int ACTIONS=5;
    public static final int ASSIGNMENT=6;
    public static final int BRACKET=7;
    public static final int CHAR=8;
    public static final int COMMENT=9;
    public static final int CONDITION=10;
    public static final int CONDITIONS=11;
    public static final int CONSTRAINT=12;
    public static final int CONSTRAINTS=13;
    public static final int EOL=14;
    public static final int ESC_SEQ=15;
    public static final int EXPONENT=16;
    public static final int EXPRESSION=17;
    public static final int FLOAT=18;
    public static final int HEX_DIGIT=19;
    public static final int ID=20;
    public static final int IDENTIFIER=21;
    public static final int IMPORT=22;
    public static final int IMPORTS=23;
    public static final int INT=24;
    public static final int OCTAL_ESC=25;
    public static final int OPERAND=26;
    public static final int OPERATOR=27;
    public static final int QUERY=28;
    public static final int RULE=29;
    public static final int RULES=30;
    public static final int STRING=31;
    public static final int TYPE=32;
    public static final int UNICODE_ESC=33;
    public static final int WS=34;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CrlParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CrlParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return CrlParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g"; }


    public static class crl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "crl"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:41:1: crl : ( importing )* ( rule )* -> ^( IMPORTS ( importing )* ) ^( RULES ( rule )* ) ;
    public final CrlParser.crl_return crl() throws RecognitionException {
        CrlParser.crl_return retval = new CrlParser.crl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CrlParser.importing_return importing1 =null;

        CrlParser.rule_return rule2 =null;


        RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");
        RewriteRuleSubtreeStream stream_importing=new RewriteRuleSubtreeStream(adaptor,"rule importing");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:42:2: ( ( importing )* ( rule )* -> ^( IMPORTS ( importing )* ) ^( RULES ( rule )* ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:42:4: ( importing )* ( rule )*
            {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:42:4: ( importing )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==50) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:42:4: importing
            	    {
            	    pushFollow(FOLLOW_importing_in_crl135);
            	    importing1=importing();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_importing.add(importing1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:43:3: ( rule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==60) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:43:3: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_crl140);
            	    rule2=rule();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_rule.add(rule2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // AST REWRITE
            // elements: rule, importing
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 44:3: -> ^( IMPORTS ( importing )* ) ^( RULES ( rule )* )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:44:6: ^( IMPORTS ( importing )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPORTS, "IMPORTS")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:44:16: ( importing )*
                while ( stream_importing.hasNext() ) {
                    adaptor.addChild(root_1, stream_importing.nextTree());

                }
                stream_importing.reset();

                adaptor.addChild(root_0, root_1);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:44:28: ^( RULES ( rule )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RULES, "RULES")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:44:36: ( rule )*
                while ( stream_rule.hasNext() ) {
                    adaptor.addChild(root_1, stream_rule.nextTree());

                }
                stream_rule.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "crl"


    protected static class importing_scope {
        String value;
    }
    protected Stack importing_stack = new Stack();


    public static class importing_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "importing"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:47:1: importing : 'import' id= ID ( '.' id= ID )* ( '.*' )? ( ';' )? EOL -> IMPORT[$importing::value] ;
    public final CrlParser.importing_return importing() throws RecognitionException {
        importing_stack.push(new importing_scope());
        CrlParser.importing_return retval = new CrlParser.importing_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken id=null;
        CommonToken string_literal3=null;
        CommonToken char_literal4=null;
        CommonToken string_literal5=null;
        CommonToken char_literal6=null;
        CommonToken EOL7=null;

        CommonTree id_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree char_literal4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree EOL7_tree=null;
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

         ((importing_scope)importing_stack.peek()).value = "import "; 
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:2: ( 'import' id= ID ( '.' id= ID )* ( '.*' )? ( ';' )? EOL -> IMPORT[$importing::value] )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:4: 'import' id= ID ( '.' id= ID )* ( '.*' )? ( ';' )? EOL
            {
            string_literal3=(CommonToken)match(input,50,FOLLOW_50_in_importing179); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(string_literal3);


            id=(CommonToken)match(input,ID,FOLLOW_ID_in_importing185); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(id);


            if ( state.backtracking==0 ) { ((importing_scope)importing_stack.peek()).value+=(id!=null?id.getText():null); }

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:54: ( '.' id= ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==36) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:55: '.' id= ID
            	    {
            	    char_literal4=(CommonToken)match(input,36,FOLLOW_36_in_importing190); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_36.add(char_literal4);


            	    id=(CommonToken)match(input,ID,FOLLOW_ID_in_importing196); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(id);


            	    if ( state.backtracking==0 ) { ((importing_scope)importing_stack.peek()).value+="."+(id!=null?id.getText():null); }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:107: ( '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==37) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:108: '.*'
                    {
                    string_literal5=(CommonToken)match(input,37,FOLLOW_37_in_importing204); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_37.add(string_literal5);


                    if ( state.backtracking==0 ) { ((importing_scope)importing_stack.peek()).value+=".*"; }

                    }
                    break;

            }


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:144: ( ';' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==39) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:52:144: ';'
                    {
                    char_literal6=(CommonToken)match(input,39,FOLLOW_39_in_importing210); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal6);


                    }
                    break;

            }


            EOL7=(CommonToken)match(input,EOL,FOLLOW_EOL_in_importing213); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL7);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 53:3: -> IMPORT[$importing::value]
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(IMPORT, ((importing_scope)importing_stack.peek()).value)
                );

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            importing_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "importing"


    public static class rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rule"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:56:1: rule : 'rule #' num= INT EOL 'when' EOL ( condition )* 'then' EOL ( action )* 'end' ( EOL )? -> ^( RULE[$num] ^( CONDITIONS ( condition )* ) ^( ACTIONS ( action )* ) ) ;
    public final CrlParser.rule_return rule() throws RecognitionException {
        CrlParser.rule_return retval = new CrlParser.rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken num=null;
        CommonToken string_literal8=null;
        CommonToken EOL9=null;
        CommonToken string_literal10=null;
        CommonToken EOL11=null;
        CommonToken string_literal13=null;
        CommonToken EOL14=null;
        CommonToken string_literal16=null;
        CommonToken EOL17=null;
        CrlParser.condition_return condition12 =null;

        CrlParser.action_return action15 =null;


        CommonTree num_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree EOL9_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree EOL11_tree=null;
        CommonTree string_literal13_tree=null;
        CommonTree EOL14_tree=null;
        CommonTree string_literal16_tree=null;
        CommonTree EOL17_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:57:2: ( 'rule #' num= INT EOL 'when' EOL ( condition )* 'then' EOL ( action )* 'end' ( EOL )? -> ^( RULE[$num] ^( CONDITIONS ( condition )* ) ^( ACTIONS ( action )* ) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:57:4: 'rule #' num= INT EOL 'when' EOL ( condition )* 'then' EOL ( action )* 'end' ( EOL )?
            {
            string_literal8=(CommonToken)match(input,60,FOLLOW_60_in_rule235); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_60.add(string_literal8);


            num=(CommonToken)match(input,INT,FOLLOW_INT_in_rule239); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(num);


            EOL9=(CommonToken)match(input,EOL,FOLLOW_EOL_in_rule241); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL9);


            string_literal10=(CommonToken)match(input,71,FOLLOW_71_in_rule245); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal10);


            EOL11=(CommonToken)match(input,EOL,FOLLOW_EOL_in_rule247); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL11);


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:59:4: ( condition )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 42 && LA6_0 <= 45)||(LA6_0 >= 47 && LA6_0 <= 48)||(LA6_0 >= 51 && LA6_0 <= 52)||LA6_0==56) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:59:4: condition
            	    {
            	    pushFollow(FOLLOW_condition_in_rule252);
            	    condition12=condition();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_condition.add(condition12.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            string_literal13=(CommonToken)match(input,68,FOLLOW_68_in_rule257); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_68.add(string_literal13);


            EOL14=(CommonToken)match(input,EOL,FOLLOW_EOL_in_rule259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL14);


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:61:4: ( action )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==40||LA7_0==49||(LA7_0 >= 53 && LA7_0 <= 55)||(LA7_0 >= 58 && LA7_0 <= 59)||(LA7_0 >= 61 && LA7_0 <= 67)||LA7_0==70) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:61:4: action
            	    {
            	    pushFollow(FOLLOW_action_in_rule264);
            	    action15=action();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_action.add(action15.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            string_literal16=(CommonToken)match(input,46,FOLLOW_46_in_rule269); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(string_literal16);


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:62:9: ( EOL )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==EOL) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:62:9: EOL
                    {
                    EOL17=(CommonToken)match(input,EOL,FOLLOW_EOL_in_rule271); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EOL.add(EOL17);


                    }
                    break;

            }


            // AST REWRITE
            // elements: condition, action
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 63:3: -> ^( RULE[$num] ^( CONDITIONS ( condition )* ) ^( ACTIONS ( action )* ) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:6: ^( RULE[$num] ^( CONDITIONS ( condition )* ) ^( ACTIONS ( action )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RULE, num)
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:19: ^( CONDITIONS ( condition )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONDITIONS, "CONDITIONS")
                , root_2);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:32: ( condition )*
                while ( stream_condition.hasNext() ) {
                    adaptor.addChild(root_2, stream_condition.nextTree());

                }
                stream_condition.reset();

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:44: ^( ACTIONS ( action )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTIONS, "ACTIONS")
                , root_2);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:54: ( action )*
                while ( stream_action.hasNext() ) {
                    adaptor.addChild(root_2, stream_action.nextTree());

                }
                stream_action.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rule"


    protected static class condition_scope {
        String type;
        String id;
    }
    protected Stack condition_stack = new Stack();


    public static class condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:66:1: condition : ( 'no' )? query (ident= ID )? ( ':' ( ( constraint ( ',' constraint )* ( ',' assignment )? ) | assignment ) )? EOL -> ^( CONDITION TYPE[$condition::type] query IDENTIFIER[$condition::id] ^( CONSTRAINTS ( ^( CONSTRAINT constraint ) )* ) ^( ASSIGNMENT ( assignment )? ) ) ;
    public final CrlParser.condition_return condition() throws RecognitionException {
        condition_stack.push(new condition_scope());
        CrlParser.condition_return retval = new CrlParser.condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken ident=null;
        CommonToken string_literal18=null;
        CommonToken char_literal20=null;
        CommonToken char_literal22=null;
        CommonToken char_literal24=null;
        CommonToken EOL27=null;
        CrlParser.query_return query19 =null;

        CrlParser.constraint_return constraint21 =null;

        CrlParser.constraint_return constraint23 =null;

        CrlParser.assignment_return assignment25 =null;

        CrlParser.assignment_return assignment26 =null;


        CommonTree ident_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree EOL27_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_query=new RewriteRuleSubtreeStream(adaptor,"rule query");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
         
        	((condition_scope)condition_stack.peek()).type = "ForAll"; 
        	((condition_scope)condition_stack.peek()).id = null;

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:75:2: ( ( 'no' )? query (ident= ID )? ( ':' ( ( constraint ( ',' constraint )* ( ',' assignment )? ) | assignment ) )? EOL -> ^( CONDITION TYPE[$condition::type] query IDENTIFIER[$condition::id] ^( CONSTRAINTS ( ^( CONSTRAINT constraint ) )* ) ^( ASSIGNMENT ( assignment )? ) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:75:4: ( 'no' )? query (ident= ID )? ( ':' ( ( constraint ( ',' constraint )* ( ',' assignment )? ) | assignment ) )? EOL
            {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:75:4: ( 'no' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==56) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:75:5: 'no'
                    {
                    string_literal18=(CommonToken)match(input,56,FOLLOW_56_in_condition318); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(string_literal18);


                    if ( state.backtracking==0 ) { ((condition_scope)condition_stack.peek()).type = "NotExists"; }

                    }
                    break;

            }


            pushFollow(FOLLOW_query_in_condition327);
            query19=query();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_query.add(query19.getTree());

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:77:3: (ident= ID )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:77:5: ident= ID
                    {
                    ident=(CommonToken)match(input,ID,FOLLOW_ID_in_condition338); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ident);


                    if ( state.backtracking==0 ) { ((condition_scope)condition_stack.peek()).id = (ident!=null?ident.getText():null); }

                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((condition_scope)condition_stack.peek()).id = ( (((condition_scope)condition_stack.peek()).id == null)? "null":((condition_scope)condition_stack.peek()).id ); }

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:78:3: ( ':' ( ( constraint ( ',' constraint )* ( ',' assignment )? ) | assignment ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:79:3: ':' ( ( constraint ( ',' constraint )* ( ',' assignment )? ) | assignment )
                    {
                    char_literal20=(CommonToken)match(input,38,FOLLOW_38_in_condition354); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal20);


                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:3: ( ( constraint ( ',' constraint )* ( ',' assignment )? ) | assignment )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ID) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==38) ) {
                            alt13=2;
                        }
                        else if ( ((LA13_1 >= ACTION && LA13_1 <= 37)||(LA13_1 >= 39 && LA13_1 <= 72)) ) {
                            alt13=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( ((LA13_0 >= ACTION && LA13_0 <= CONSTRAINTS)||(LA13_0 >= ESC_SEQ && LA13_0 <= HEX_DIGIT)||(LA13_0 >= IDENTIFIER && LA13_0 <= WS)||(LA13_0 >= 36 && LA13_0 <= 37)||(LA13_0 >= 39 && LA13_0 <= 72)) ) {
                        alt13=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;

                    }
                    switch (alt13) {
                        case 1 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:5: ( constraint ( ',' constraint )* ( ',' assignment )? )
                            {
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:5: ( constraint ( ',' constraint )* ( ',' assignment )? )
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:6: constraint ( ',' constraint )* ( ',' assignment )?
                            {
                            pushFollow(FOLLOW_constraint_in_condition362);
                            constraint21=constraint();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_constraint.add(constraint21.getTree());

                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:17: ( ',' constraint )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==35) ) {
                                    int LA11_1 = input.LA(2);

                                    if ( (LA11_1==ID) ) {
                                        int LA11_3 = input.LA(3);

                                        if ( ((LA11_3 >= ACTION && LA11_3 <= 37)||(LA11_3 >= 39 && LA11_3 <= 72)) ) {
                                            alt11=1;
                                        }


                                    }
                                    else if ( ((LA11_1 >= ACTION && LA11_1 <= CONSTRAINTS)||(LA11_1 >= ESC_SEQ && LA11_1 <= HEX_DIGIT)||(LA11_1 >= IDENTIFIER && LA11_1 <= WS)||(LA11_1 >= 36 && LA11_1 <= 37)||(LA11_1 >= 39 && LA11_1 <= 72)) ) {
                                        alt11=1;
                                    }


                                }


                                switch (alt11) {
                            	case 1 :
                            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:18: ',' constraint
                            	    {
                            	    char_literal22=(CommonToken)match(input,35,FOLLOW_35_in_condition365); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_35.add(char_literal22);


                            	    pushFollow(FOLLOW_constraint_in_condition367);
                            	    constraint23=constraint();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_constraint.add(constraint23.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:35: ( ',' assignment )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0==35) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:36: ',' assignment
                                    {
                                    char_literal24=(CommonToken)match(input,35,FOLLOW_35_in_condition372); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_35.add(char_literal24);


                                    pushFollow(FOLLOW_assignment_in_condition374);
                                    assignment25=assignment();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_assignment.add(assignment25.getTree());

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:80:57: assignment
                            {
                            pushFollow(FOLLOW_assignment_in_condition382);
                            assignment26=assignment();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_assignment.add(assignment26.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            EOL27=(CommonToken)match(input,EOL,FOLLOW_EOL_in_condition391); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL27);


            // AST REWRITE
            // elements: assignment, constraint, query
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 82:3: -> ^( CONDITION TYPE[$condition::type] query IDENTIFIER[$condition::id] ^( CONSTRAINTS ( ^( CONSTRAINT constraint ) )* ) ^( ASSIGNMENT ( assignment )? ) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:82:6: ^( CONDITION TYPE[$condition::type] query IDENTIFIER[$condition::id] ^( CONSTRAINTS ( ^( CONSTRAINT constraint ) )* ) ^( ASSIGNMENT ( assignment )? ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONDITION, "CONDITION")
                , root_1);

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(TYPE, ((condition_scope)condition_stack.peek()).type)
                );

                adaptor.addChild(root_1, stream_query.nextTree());

                adaptor.addChild(root_1, 
                (CommonTree)adaptor.create(IDENTIFIER, ((condition_scope)condition_stack.peek()).id)
                );

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:82:75: ^( CONSTRAINTS ( ^( CONSTRAINT constraint ) )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONSTRAINTS, "CONSTRAINTS")
                , root_2);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:82:89: ( ^( CONSTRAINT constraint ) )*
                while ( stream_constraint.hasNext() ) {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:82:89: ^( CONSTRAINT constraint )
                    {
                    CommonTree root_3 = (CommonTree)adaptor.nil();
                    root_3 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(CONSTRAINT, "CONSTRAINT")
                    , root_3);

                    adaptor.addChild(root_3, stream_constraint.nextTree());

                    adaptor.addChild(root_2, root_3);
                    }

                }
                stream_constraint.reset();

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:82:116: ^( ASSIGNMENT ( assignment )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNMENT, "ASSIGNMENT")
                , root_2);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:82:129: ( assignment )?
                if ( stream_assignment.hasNext() ) {
                    adaptor.addChild(root_2, stream_assignment.nextTree());

                }
                stream_assignment.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            condition_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "condition"


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:85:1: query : ( ( 'cell' | 'cells' ) -> QUERY[\"CCell\"] | ( 'label' | 'labels' ) -> QUERY[\"CLabel\"] | ( 'entry' | 'entries' ) -> QUERY[\"CEntry\"] | ( 'category' | 'categories' ) -> QUERY[\"CCAtegory\"] );
    public final CrlParser.query_return query() throws RecognitionException {
        CrlParser.query_return retval = new CrlParser.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal28=null;
        CommonToken string_literal29=null;
        CommonToken string_literal30=null;
        CommonToken string_literal31=null;
        CommonToken string_literal32=null;
        CommonToken string_literal33=null;
        CommonToken string_literal34=null;
        CommonToken string_literal35=null;

        CommonTree string_literal28_tree=null;
        CommonTree string_literal29_tree=null;
        CommonTree string_literal30_tree=null;
        CommonTree string_literal31_tree=null;
        CommonTree string_literal32_tree=null;
        CommonTree string_literal33_tree=null;
        CommonTree string_literal34_tree=null;
        CommonTree string_literal35_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:86:2: ( ( 'cell' | 'cells' ) -> QUERY[\"CCell\"] | ( 'label' | 'labels' ) -> QUERY[\"CLabel\"] | ( 'entry' | 'entries' ) -> QUERY[\"CEntry\"] | ( 'category' | 'categories' ) -> QUERY[\"CCAtegory\"] )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 44:
            case 45:
                {
                alt19=1;
                }
                break;
            case 51:
            case 52:
                {
                alt19=2;
                }
                break;
            case 47:
            case 48:
                {
                alt19=3;
                }
                break;
            case 42:
            case 43:
                {
                alt19=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }

            switch (alt19) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:86:4: ( 'cell' | 'cells' )
                    {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:86:4: ( 'cell' | 'cells' )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==44) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==45) ) {
                        alt15=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;

                    }
                    switch (alt15) {
                        case 1 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:86:5: 'cell'
                            {
                            string_literal28=(CommonToken)match(input,44,FOLLOW_44_in_query440); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_44.add(string_literal28);


                            }
                            break;
                        case 2 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:86:12: 'cells'
                            {
                            string_literal29=(CommonToken)match(input,45,FOLLOW_45_in_query442); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_45.add(string_literal29);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 86:21: -> QUERY[\"CCell\"]
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(QUERY, "CCell")
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:4: ( 'label' | 'labels' )
                    {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:4: ( 'label' | 'labels' )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==51) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==52) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;

                    }
                    switch (alt16) {
                        case 1 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:5: 'label'
                            {
                            string_literal30=(CommonToken)match(input,51,FOLLOW_51_in_query454); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_51.add(string_literal30);


                            }
                            break;
                        case 2 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:13: 'labels'
                            {
                            string_literal31=(CommonToken)match(input,52,FOLLOW_52_in_query456); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_52.add(string_literal31);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 87:23: -> QUERY[\"CLabel\"]
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(QUERY, "CLabel")
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:88:4: ( 'entry' | 'entries' )
                    {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:88:4: ( 'entry' | 'entries' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==48) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==47) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;

                    }
                    switch (alt17) {
                        case 1 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:88:5: 'entry'
                            {
                            string_literal32=(CommonToken)match(input,48,FOLLOW_48_in_query468); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_48.add(string_literal32);


                            }
                            break;
                        case 2 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:88:13: 'entries'
                            {
                            string_literal33=(CommonToken)match(input,47,FOLLOW_47_in_query470); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_47.add(string_literal33);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 88:24: -> QUERY[\"CEntry\"]
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(QUERY, "CEntry")
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:89:4: ( 'category' | 'categories' )
                    {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:89:4: ( 'category' | 'categories' )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==43) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==42) ) {
                        alt18=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;

                    }
                    switch (alt18) {
                        case 1 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:89:5: 'category'
                            {
                            string_literal34=(CommonToken)match(input,43,FOLLOW_43_in_query482); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_43.add(string_literal34);


                            }
                            break;
                        case 2 :
                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:89:16: 'categories'
                            {
                            string_literal35=(CommonToken)match(input,42,FOLLOW_42_in_query484); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_42.add(string_literal35);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 89:30: -> QUERY[\"CCAtegory\"]
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(QUERY, "CCAtegory")
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    public static class constraint_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constraint"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:92:1: constraint : (~ ( ',' | EOL | ':' ) )+ ;
    public final CrlParser.constraint_return constraint() throws RecognitionException {
        CrlParser.constraint_return retval = new CrlParser.constraint_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set36=null;

        CommonTree set36_tree=null;

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:93:2: ( (~ ( ',' | EOL | ':' ) )+ )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:93:4: (~ ( ',' | EOL | ':' ) )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:93:4: (~ ( ',' | EOL | ':' ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= ACTION && LA20_0 <= CONSTRAINTS)||(LA20_0 >= ESC_SEQ && LA20_0 <= WS)||(LA20_0 >= 36 && LA20_0 <= 37)||(LA20_0 >= 39 && LA20_0 <= 72)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            	    {
            	    set36=(CommonToken)input.LT(1);

            	    if ( (input.LA(1) >= ACTION && input.LA(1) <= CONSTRAINTS)||(input.LA(1) >= ESC_SEQ && input.LA(1) <= WS)||(input.LA(1) >= 36 && input.LA(1) <= 37)||(input.LA(1) >= 39 && input.LA(1) <= 72) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, 
            	        (CommonTree)adaptor.create(set36)
            	        );
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constraint"


    public static class assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignment"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:96:1: assignment : id= ID ':' expression -> IDENTIFIER[$id] ^( EXPRESSION expression ) ;
    public final CrlParser.assignment_return assignment() throws RecognitionException {
        CrlParser.assignment_return retval = new CrlParser.assignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken id=null;
        CommonToken char_literal37=null;
        CrlParser.expression_return expression38 =null;


        CommonTree id_tree=null;
        CommonTree char_literal37_tree=null;
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:97:2: (id= ID ':' expression -> IDENTIFIER[$id] ^( EXPRESSION expression ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:97:4: id= ID ':' expression
            {
            id=(CommonToken)match(input,ID,FOLLOW_ID_in_assignment528); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(id);


            char_literal37=(CommonToken)match(input,38,FOLLOW_38_in_assignment530); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal37);


            pushFollow(FOLLOW_expression_in_assignment532);
            expression38=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression38.getTree());

            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 98:3: -> IDENTIFIER[$id] ^( EXPRESSION expression )
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(IDENTIFIER, id)
                );

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:98:22: ^( EXPRESSION expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXPRESSION, "EXPRESSION")
                , root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignment"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:101:1: expression : ( ESC_SEQ |~ ( EOL ) )+ ;
    public final CrlParser.expression_return expression() throws RecognitionException {
        CrlParser.expression_return retval = new CrlParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set39=null;

        CommonTree set39_tree=null;

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:102:2: ( ( ESC_SEQ |~ ( EOL ) )+ )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:102:4: ( ESC_SEQ |~ ( EOL ) )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:102:4: ( ESC_SEQ |~ ( EOL ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= ACTION && LA21_0 <= CONSTRAINTS)||(LA21_0 >= ESC_SEQ && LA21_0 <= 72)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            	    {
            	    set39=(CommonToken)input.LT(1);

            	    if ( (input.LA(1) >= ACTION && input.LA(1) <= CONSTRAINTS)||(input.LA(1) >= ESC_SEQ && input.LA(1) <= 72) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, 
            	        (CommonTree)adaptor.create(set39)
            	        );
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class action_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:105:1: action : ( set_mark | set_text | set_indent | split | merge | new_entry | set_value | set_category | set_parent | group | add_label | new_label | update | print );
    public final CrlParser.action_return action() throws RecognitionException {
        CrlParser.action_return retval = new CrlParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CrlParser.set_mark_return set_mark40 =null;

        CrlParser.set_text_return set_text41 =null;

        CrlParser.set_indent_return set_indent42 =null;

        CrlParser.split_return split43 =null;

        CrlParser.merge_return merge44 =null;

        CrlParser.new_entry_return new_entry45 =null;

        CrlParser.set_value_return set_value46 =null;

        CrlParser.set_category_return set_category47 =null;

        CrlParser.set_parent_return set_parent48 =null;

        CrlParser.group_return group49 =null;

        CrlParser.add_label_return add_label50 =null;

        CrlParser.new_label_return new_label51 =null;

        CrlParser.update_return update52 =null;

        CrlParser.print_return print53 =null;



        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:106:2: ( set_mark | set_text | set_indent | split | merge | new_entry | set_value | set_category | set_parent | group | add_label | new_label | update | print )
            int alt22=14;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt22=1;
                }
                break;
            case 65:
                {
                alt22=2;
                }
                break;
            case 62:
                {
                alt22=3;
                }
                break;
            case 67:
                {
                alt22=4;
                }
                break;
            case 53:
                {
                alt22=5;
                }
                break;
            case 54:
                {
                alt22=6;
                }
                break;
            case 66:
                {
                alt22=7;
                }
                break;
            case 61:
                {
                alt22=8;
                }
                break;
            case 64:
                {
                alt22=9;
                }
                break;
            case 49:
                {
                alt22=10;
                }
                break;
            case 40:
                {
                alt22=11;
                }
                break;
            case 55:
                {
                alt22=12;
                }
                break;
            case 70:
                {
                alt22=13;
                }
                break;
            case 58:
            case 59:
                {
                alt22=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:106:4: set_mark
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_mark_in_action580);
                    set_mark40=set_mark();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_mark40.getTree());

                    }
                    break;
                case 2 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:107:4: set_text
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_text_in_action585);
                    set_text41=set_text();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_text41.getTree());

                    }
                    break;
                case 3 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:108:4: set_indent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_indent_in_action590);
                    set_indent42=set_indent();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_indent42.getTree());

                    }
                    break;
                case 4 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:4: split
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_split_in_action595);
                    split43=split();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, split43.getTree());

                    }
                    break;
                case 5 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:110:4: merge
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_merge_in_action600);
                    merge44=merge();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, merge44.getTree());

                    }
                    break;
                case 6 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:111:4: new_entry
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_new_entry_in_action605);
                    new_entry45=new_entry();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, new_entry45.getTree());

                    }
                    break;
                case 7 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:112:4: set_value
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_value_in_action610);
                    set_value46=set_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_value46.getTree());

                    }
                    break;
                case 8 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:113:4: set_category
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_category_in_action615);
                    set_category47=set_category();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_category47.getTree());

                    }
                    break;
                case 9 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:114:4: set_parent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_parent_in_action620);
                    set_parent48=set_parent();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_parent48.getTree());

                    }
                    break;
                case 10 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:115:4: group
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_group_in_action625);
                    group49=group();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, group49.getTree());

                    }
                    break;
                case 11 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:116:4: add_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_add_label_in_action630);
                    add_label50=add_label();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, add_label50.getTree());

                    }
                    break;
                case 12 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:117:4: new_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_new_label_in_action635);
                    new_label51=new_label();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, new_label51.getTree());

                    }
                    break;
                case 13 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:118:4: update
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_update_in_action640);
                    update52=update();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, update52.getTree());

                    }
                    break;
                case 14 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:119:4: print
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_print_in_action645);
                    print53=print();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, print53.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "action"


    public static class operand_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "operand"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:122:1: operand : ( STRING | ESC_SEQ |~ ( 'to' | 'with' | 'as' | 'of' | EOL ) )+ ;
    public final CrlParser.operand_return operand() throws RecognitionException {
        CrlParser.operand_return retval = new CrlParser.operand_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set54=null;

        CommonTree set54_tree=null;

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:123:2: ( ( STRING | ESC_SEQ |~ ( 'to' | 'with' | 'as' | 'of' | EOL ) )+ )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:123:4: ( STRING | ESC_SEQ |~ ( 'to' | 'with' | 'as' | 'of' | EOL ) )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:123:4: ( STRING | ESC_SEQ |~ ( 'to' | 'with' | 'as' | 'of' | EOL ) )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= ACTION && LA23_0 <= CONSTRAINTS)||(LA23_0 >= ESC_SEQ && LA23_0 <= 40)||(LA23_0 >= 42 && LA23_0 <= 56)||(LA23_0 >= 58 && LA23_0 <= 68)||(LA23_0 >= 70 && LA23_0 <= 71)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            	    {
            	    set54=(CommonToken)input.LT(1);

            	    if ( (input.LA(1) >= ACTION && input.LA(1) <= CONSTRAINTS)||(input.LA(1) >= ESC_SEQ && input.LA(1) <= 40)||(input.LA(1) >= 42 && input.LA(1) <= 56)||(input.LA(1) >= 58 && input.LA(1) <= 68)||(input.LA(1) >= 70 && input.LA(1) <= 71) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, 
            	        (CommonTree)adaptor.create(set54)
            	        );
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "operand"


    public static class set_mark_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_mark"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:126:1: set_mark : 'set mark' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setMark\"] ^( OPERAND $op2) ^( OPERAND $op1) ) ;
    public final CrlParser.set_mark_return set_mark() throws RecognitionException {
        CrlParser.set_mark_return retval = new CrlParser.set_mark_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal55=null;
        CommonToken string_literal56=null;
        CommonToken EOL57=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal55_tree=null;
        CommonTree string_literal56_tree=null;
        CommonTree EOL57_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:127:2: ( 'set mark' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setMark\"] ^( OPERAND $op2) ^( OPERAND $op1) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:127:4: 'set mark' op1= operand 'to' op2= operand EOL
            {
            string_literal55=(CommonToken)match(input,63,FOLLOW_63_in_set_mark691); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal55);


            pushFollow(FOLLOW_operand_in_set_mark697);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal56=(CommonToken)match(input,69,FOLLOW_69_in_set_mark699); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal56);


            pushFollow(FOLLOW_operand_in_set_mark705);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL57=(CommonToken)match(input,EOL,FOLLOW_EOL_in_set_mark707); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL57);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 128:3: -> ^( ACTION[\"setMark\"] ^( OPERAND $op2) ^( OPERAND $op1) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:128:6: ^( ACTION[\"setMark\"] ^( OPERAND $op2) ^( OPERAND $op1) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "setMark")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:128:26: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:128:42: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "set_mark"


    public static class set_text_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_text"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:131:1: set_text : 'set text' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setText\"] ^( OPERAND $op2) ^( OPERAND $op1) ) ;
    public final CrlParser.set_text_return set_text() throws RecognitionException {
        CrlParser.set_text_return retval = new CrlParser.set_text_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal58=null;
        CommonToken string_literal59=null;
        CommonToken EOL60=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal58_tree=null;
        CommonTree string_literal59_tree=null;
        CommonTree EOL60_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:132:2: ( 'set text' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setText\"] ^( OPERAND $op2) ^( OPERAND $op1) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:132:4: 'set text' op1= operand 'to' op2= operand EOL
            {
            string_literal58=(CommonToken)match(input,65,FOLLOW_65_in_set_text742); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(string_literal58);


            pushFollow(FOLLOW_operand_in_set_text748);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal59=(CommonToken)match(input,69,FOLLOW_69_in_set_text750); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal59);


            pushFollow(FOLLOW_operand_in_set_text756);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL60=(CommonToken)match(input,EOL,FOLLOW_EOL_in_set_text758); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL60);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 133:3: -> ^( ACTION[\"setText\"] ^( OPERAND $op2) ^( OPERAND $op1) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:133:6: ^( ACTION[\"setText\"] ^( OPERAND $op2) ^( OPERAND $op1) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "setText")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:133:26: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:133:42: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "set_text"


    public static class set_indent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_indent"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:136:1: set_indent : 'set indent' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setIndent\"] ^( OPERAND $op2) ^( OPERAND $op1) ) ;
    public final CrlParser.set_indent_return set_indent() throws RecognitionException {
        CrlParser.set_indent_return retval = new CrlParser.set_indent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal61=null;
        CommonToken string_literal62=null;
        CommonToken EOL63=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal61_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree EOL63_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:137:2: ( 'set indent' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setIndent\"] ^( OPERAND $op2) ^( OPERAND $op1) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:137:4: 'set indent' op1= operand 'to' op2= operand EOL
            {
            string_literal61=(CommonToken)match(input,62,FOLLOW_62_in_set_indent793); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(string_literal61);


            pushFollow(FOLLOW_operand_in_set_indent799);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal62=(CommonToken)match(input,69,FOLLOW_69_in_set_indent801); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal62);


            pushFollow(FOLLOW_operand_in_set_indent807);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL63=(CommonToken)match(input,EOL,FOLLOW_EOL_in_set_indent809); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL63);


            // AST REWRITE
            // elements: op2, op1
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 138:3: -> ^( ACTION[\"setIndent\"] ^( OPERAND $op2) ^( OPERAND $op1) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:138:6: ^( ACTION[\"setIndent\"] ^( OPERAND $op2) ^( OPERAND $op1) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "setIndent")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:138:28: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:138:44: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "set_indent"


    public static class split_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:141:1: split : 'split' operand EOL -> ^( ACTION[\"split\"] ^( OPERAND operand ) ) ;
    public final CrlParser.split_return split() throws RecognitionException {
        CrlParser.split_return retval = new CrlParser.split_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal64=null;
        CommonToken EOL66=null;
        CrlParser.operand_return operand65 =null;


        CommonTree string_literal64_tree=null;
        CommonTree EOL66_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:142:2: ( 'split' operand EOL -> ^( ACTION[\"split\"] ^( OPERAND operand ) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:142:4: 'split' operand EOL
            {
            string_literal64=(CommonToken)match(input,67,FOLLOW_67_in_split844); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(string_literal64);


            pushFollow(FOLLOW_operand_in_split846);
            operand65=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(operand65.getTree());

            EOL66=(CommonToken)match(input,EOL,FOLLOW_EOL_in_split848); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL66);


            // AST REWRITE
            // elements: operand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 143:3: -> ^( ACTION[\"split\"] ^( OPERAND operand ) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:143:6: ^( ACTION[\"split\"] ^( OPERAND operand ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "split")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:143:25: ^( OPERAND operand )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_operand.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split"


    public static class merge_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "merge"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:146:1: merge : 'merge' op1= operand 'with' op2= operand EOL -> ^( ACTION[\"merge\"] ^( OPERAND $op2) ^( OPERAND $op1) ) ;
    public final CrlParser.merge_return merge() throws RecognitionException {
        CrlParser.merge_return retval = new CrlParser.merge_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal67=null;
        CommonToken string_literal68=null;
        CommonToken EOL69=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal67_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree EOL69_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:147:2: ( 'merge' op1= operand 'with' op2= operand EOL -> ^( ACTION[\"merge\"] ^( OPERAND $op2) ^( OPERAND $op1) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:147:4: 'merge' op1= operand 'with' op2= operand EOL
            {
            string_literal67=(CommonToken)match(input,53,FOLLOW_53_in_merge876); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_53.add(string_literal67);


            pushFollow(FOLLOW_operand_in_merge882);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal68=(CommonToken)match(input,72,FOLLOW_72_in_merge884); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(string_literal68);


            pushFollow(FOLLOW_operand_in_merge890);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL69=(CommonToken)match(input,EOL,FOLLOW_EOL_in_merge892); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL69);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:3: -> ^( ACTION[\"merge\"] ^( OPERAND $op2) ^( OPERAND $op1) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:148:6: ^( ACTION[\"merge\"] ^( OPERAND $op2) ^( OPERAND $op1) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "merge")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:148:24: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:148:40: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "merge"


    public static class new_entry_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "new_entry"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:151:1: new_entry : 'new entry' op1= operand ( 'as' op2= operand )? EOL -> ^( ACTION[\"newEntry\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? ) ;
    public final CrlParser.new_entry_return new_entry() throws RecognitionException {
        CrlParser.new_entry_return retval = new CrlParser.new_entry_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal70=null;
        CommonToken string_literal71=null;
        CommonToken EOL72=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal70_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree EOL72_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:152:2: ( 'new entry' op1= operand ( 'as' op2= operand )? EOL -> ^( ACTION[\"newEntry\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:152:4: 'new entry' op1= operand ( 'as' op2= operand )? EOL
            {
            string_literal70=(CommonToken)match(input,54,FOLLOW_54_in_new_entry927); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_54.add(string_literal70);


            pushFollow(FOLLOW_operand_in_new_entry933);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:152:30: ( 'as' op2= operand )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==41) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:152:31: 'as' op2= operand
                    {
                    string_literal71=(CommonToken)match(input,41,FOLLOW_41_in_new_entry936); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(string_literal71);


                    pushFollow(FOLLOW_operand_in_new_entry942);
                    op2=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

                    }
                    break;

            }


            EOL72=(CommonToken)match(input,EOL,FOLLOW_EOL_in_new_entry946); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL72);


            // AST REWRITE
            // elements: op2, op1
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 153:3: -> ^( ACTION[\"newEntry\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:153:6: ^( ACTION[\"newEntry\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "newEntry")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:153:27: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:153:43: ( ^( OPERAND $op2) )?
                if ( stream_op2.hasNext() ) {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:153:43: ^( OPERAND $op2)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(OPERAND, "OPERAND")
                    , root_2);

                    adaptor.addChild(root_2, stream_op2.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_op2.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "new_entry"


    public static class set_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_value"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:156:1: set_value : 'set value' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setValue\"] ^( OPERAND $op2) ^( OPERAND $op1) ) ;
    public final CrlParser.set_value_return set_value() throws RecognitionException {
        CrlParser.set_value_return retval = new CrlParser.set_value_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal73=null;
        CommonToken string_literal74=null;
        CommonToken EOL75=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal73_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree EOL75_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:157:2: ( 'set value' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setValue\"] ^( OPERAND $op2) ^( OPERAND $op1) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:157:4: 'set value' op1= operand 'to' op2= operand EOL
            {
            string_literal73=(CommonToken)match(input,66,FOLLOW_66_in_set_value982); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_66.add(string_literal73);


            pushFollow(FOLLOW_operand_in_set_value988);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal74=(CommonToken)match(input,69,FOLLOW_69_in_set_value990); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal74);


            pushFollow(FOLLOW_operand_in_set_value996);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL75=(CommonToken)match(input,EOL,FOLLOW_EOL_in_set_value998); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL75);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 158:3: -> ^( ACTION[\"setValue\"] ^( OPERAND $op2) ^( OPERAND $op1) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:158:6: ^( ACTION[\"setValue\"] ^( OPERAND $op2) ^( OPERAND $op1) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "setValue")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:158:27: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:158:43: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "set_value"


    public static class set_category_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_category"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:161:1: set_category : 'set category' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setCategory\"] ^( OPERAND $op2) ^( OPERAND $op1) ) ;
    public final CrlParser.set_category_return set_category() throws RecognitionException {
        CrlParser.set_category_return retval = new CrlParser.set_category_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal76=null;
        CommonToken string_literal77=null;
        CommonToken EOL78=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree EOL78_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:162:2: ( 'set category' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setCategory\"] ^( OPERAND $op2) ^( OPERAND $op1) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:162:4: 'set category' op1= operand 'to' op2= operand EOL
            {
            string_literal76=(CommonToken)match(input,61,FOLLOW_61_in_set_category1033); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(string_literal76);


            pushFollow(FOLLOW_operand_in_set_category1039);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal77=(CommonToken)match(input,69,FOLLOW_69_in_set_category1041); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal77);


            pushFollow(FOLLOW_operand_in_set_category1047);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL78=(CommonToken)match(input,EOL,FOLLOW_EOL_in_set_category1049); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL78);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 163:3: -> ^( ACTION[\"setCategory\"] ^( OPERAND $op2) ^( OPERAND $op1) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:163:6: ^( ACTION[\"setCategory\"] ^( OPERAND $op2) ^( OPERAND $op1) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "setCategory")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:163:30: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:163:46: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "set_category"


    public static class set_parent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_parent"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:166:1: set_parent : 'set parent' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setParent\"] ^( OPERAND $op2) ^( OPERAND $op1) ) ;
    public final CrlParser.set_parent_return set_parent() throws RecognitionException {
        CrlParser.set_parent_return retval = new CrlParser.set_parent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal79=null;
        CommonToken string_literal80=null;
        CommonToken EOL81=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal79_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree EOL81_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:167:2: ( 'set parent' op1= operand 'to' op2= operand EOL -> ^( ACTION[\"setParent\"] ^( OPERAND $op2) ^( OPERAND $op1) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:167:4: 'set parent' op1= operand 'to' op2= operand EOL
            {
            string_literal79=(CommonToken)match(input,64,FOLLOW_64_in_set_parent1084); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(string_literal79);


            pushFollow(FOLLOW_operand_in_set_parent1090);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal80=(CommonToken)match(input,69,FOLLOW_69_in_set_parent1092); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal80);


            pushFollow(FOLLOW_operand_in_set_parent1098);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL81=(CommonToken)match(input,EOL,FOLLOW_EOL_in_set_parent1100); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL81);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 168:3: -> ^( ACTION[\"setParent\"] ^( OPERAND $op2) ^( OPERAND $op1) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:168:6: ^( ACTION[\"setParent\"] ^( OPERAND $op2) ^( OPERAND $op1) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "setParent")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:168:28: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:168:44: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "set_parent"


    public static class group_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:1: group : 'group' op1= operand 'with' op2= operand EOL -> ^( ACTION[\"group\"] ^( OPERAND $op1) ^( OPERAND $op2) ) ;
    public final CrlParser.group_return group() throws RecognitionException {
        CrlParser.group_return retval = new CrlParser.group_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal82=null;
        CommonToken string_literal83=null;
        CommonToken EOL84=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal82_tree=null;
        CommonTree string_literal83_tree=null;
        CommonTree EOL84_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:172:2: ( 'group' op1= operand 'with' op2= operand EOL -> ^( ACTION[\"group\"] ^( OPERAND $op1) ^( OPERAND $op2) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:172:4: 'group' op1= operand 'with' op2= operand EOL
            {
            string_literal82=(CommonToken)match(input,49,FOLLOW_49_in_group1135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_49.add(string_literal82);


            pushFollow(FOLLOW_operand_in_group1141);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            string_literal83=(CommonToken)match(input,72,FOLLOW_72_in_group1143); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(string_literal83);


            pushFollow(FOLLOW_operand_in_group1149);
            op2=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

            EOL84=(CommonToken)match(input,EOL,FOLLOW_EOL_in_group1151); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL84);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 173:3: -> ^( ACTION[\"group\"] ^( OPERAND $op1) ^( OPERAND $op2) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:173:6: ^( ACTION[\"group\"] ^( OPERAND $op1) ^( OPERAND $op2) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "group")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:173:24: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:173:40: ^( OPERAND $op2)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op2.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group"


    public static class add_label_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add_label"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:176:1: add_label : 'add label' op1= operand ( 'of' op2= operand )? 'to' op3= operand EOL -> ^( ACTION[\"addLabel\"] ^( OPERAND $op3) ^( OPERAND $op1) ( ^( OPERAND $op2) )? ) ;
    public final CrlParser.add_label_return add_label() throws RecognitionException {
        CrlParser.add_label_return retval = new CrlParser.add_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal85=null;
        CommonToken string_literal86=null;
        CommonToken string_literal87=null;
        CommonToken EOL88=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;

        CrlParser.operand_return op3 =null;


        CommonTree string_literal85_tree=null;
        CommonTree string_literal86_tree=null;
        CommonTree string_literal87_tree=null;
        CommonTree EOL88_tree=null;
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:177:2: ( 'add label' op1= operand ( 'of' op2= operand )? 'to' op3= operand EOL -> ^( ACTION[\"addLabel\"] ^( OPERAND $op3) ^( OPERAND $op1) ( ^( OPERAND $op2) )? ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:177:4: 'add label' op1= operand ( 'of' op2= operand )? 'to' op3= operand EOL
            {
            string_literal85=(CommonToken)match(input,40,FOLLOW_40_in_add_label1186); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(string_literal85);


            pushFollow(FOLLOW_operand_in_add_label1192);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:177:30: ( 'of' op2= operand )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==57) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:177:31: 'of' op2= operand
                    {
                    string_literal86=(CommonToken)match(input,57,FOLLOW_57_in_add_label1195); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal86);


                    pushFollow(FOLLOW_operand_in_add_label1201);
                    op2=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

                    }
                    break;

            }


            string_literal87=(CommonToken)match(input,69,FOLLOW_69_in_add_label1205); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal87);


            pushFollow(FOLLOW_operand_in_add_label1211);
            op3=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op3.getTree());

            EOL88=(CommonToken)match(input,EOL,FOLLOW_EOL_in_add_label1213); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL88);


            // AST REWRITE
            // elements: op2, op3, op1
            // token labels: 
            // rule labels: op2, op1, op3, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_op3=new RewriteRuleSubtreeStream(adaptor,"rule op3",op3!=null?op3.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:3: -> ^( ACTION[\"addLabel\"] ^( OPERAND $op3) ^( OPERAND $op1) ( ^( OPERAND $op2) )? )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:178:6: ^( ACTION[\"addLabel\"] ^( OPERAND $op3) ^( OPERAND $op1) ( ^( OPERAND $op2) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "addLabel")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:178:27: ^( OPERAND $op3)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op3.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:178:43: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:178:59: ( ^( OPERAND $op2) )?
                if ( stream_op2.hasNext() ) {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:178:59: ^( OPERAND $op2)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(OPERAND, "OPERAND")
                    , root_2);

                    adaptor.addChild(root_2, stream_op2.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_op2.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "add_label"


    public static class new_label_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "new_label"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:181:1: new_label : 'new label' op1= operand ( 'as' op2= operand )? EOL -> ^( ACTION[\"newLabel\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? ) ;
    public final CrlParser.new_label_return new_label() throws RecognitionException {
        CrlParser.new_label_return retval = new CrlParser.new_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal89=null;
        CommonToken string_literal90=null;
        CommonToken EOL91=null;
        CrlParser.operand_return op1 =null;

        CrlParser.operand_return op2 =null;


        CommonTree string_literal89_tree=null;
        CommonTree string_literal90_tree=null;
        CommonTree EOL91_tree=null;
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:182:2: ( 'new label' op1= operand ( 'as' op2= operand )? EOL -> ^( ACTION[\"newLabel\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:182:4: 'new label' op1= operand ( 'as' op2= operand )? EOL
            {
            string_literal89=(CommonToken)match(input,55,FOLLOW_55_in_new_label1256); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_55.add(string_literal89);


            pushFollow(FOLLOW_operand_in_new_label1262);
            op1=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(op1.getTree());

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:182:30: ( 'as' op2= operand )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==41) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:182:31: 'as' op2= operand
                    {
                    string_literal90=(CommonToken)match(input,41,FOLLOW_41_in_new_label1265); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(string_literal90);


                    pushFollow(FOLLOW_operand_in_new_label1271);
                    op2=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(op2.getTree());

                    }
                    break;

            }


            EOL91=(CommonToken)match(input,EOL,FOLLOW_EOL_in_new_label1275); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL91);


            // AST REWRITE
            // elements: op1, op2
            // token labels: 
            // rule labels: op2, op1, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_op2=new RewriteRuleSubtreeStream(adaptor,"rule op2",op2!=null?op2.tree:null);
            RewriteRuleSubtreeStream stream_op1=new RewriteRuleSubtreeStream(adaptor,"rule op1",op1!=null?op1.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 183:3: -> ^( ACTION[\"newLabel\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:6: ^( ACTION[\"newLabel\"] ^( OPERAND $op1) ( ^( OPERAND $op2) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "newLabel")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:27: ^( OPERAND $op1)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_op1.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:43: ( ^( OPERAND $op2) )?
                if ( stream_op2.hasNext() ) {
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:43: ^( OPERAND $op2)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(OPERAND, "OPERAND")
                    , root_2);

                    adaptor.addChild(root_2, stream_op2.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_op2.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "new_label"


    public static class update_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "update"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:186:1: update : 'update' operand EOL -> ^( ACTION[\"update\"] ^( OPERAND operand ) ) ;
    public final CrlParser.update_return update() throws RecognitionException {
        CrlParser.update_return retval = new CrlParser.update_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal92=null;
        CommonToken EOL94=null;
        CrlParser.operand_return operand93 =null;


        CommonTree string_literal92_tree=null;
        CommonTree EOL94_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:187:2: ( 'update' operand EOL -> ^( ACTION[\"update\"] ^( OPERAND operand ) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:187:4: 'update' operand EOL
            {
            string_literal92=(CommonToken)match(input,70,FOLLOW_70_in_update1311); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal92);


            pushFollow(FOLLOW_operand_in_update1313);
            operand93=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(operand93.getTree());

            EOL94=(CommonToken)match(input,EOL,FOLLOW_EOL_in_update1315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL94);


            // AST REWRITE
            // elements: operand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 188:3: -> ^( ACTION[\"update\"] ^( OPERAND operand ) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:188:6: ^( ACTION[\"update\"] ^( OPERAND operand ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, "update")
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:188:25: ^( OPERAND operand )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_operand.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "update"


    public static class print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "print"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:1: print : name= ( 'print' | 'printf' ) operand EOL -> ^( ACTION[$name] ^( OPERAND operand ) ) ;
    public final CrlParser.print_return print() throws RecognitionException {
        CrlParser.print_return retval = new CrlParser.print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken name=null;
        CommonToken string_literal95=null;
        CommonToken string_literal96=null;
        CommonToken EOL98=null;
        CrlParser.operand_return operand97 =null;


        CommonTree name_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree string_literal96_tree=null;
        CommonTree EOL98_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:192:2: (name= ( 'print' | 'printf' ) operand EOL -> ^( ACTION[$name] ^( OPERAND operand ) ) )
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:192:4: name= ( 'print' | 'printf' ) operand EOL
            {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:192:11: ( 'print' | 'printf' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==58) ) {
                alt27=1;
            }
            else if ( (LA27_0==59) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:192:12: 'print'
                    {
                    string_literal95=(CommonToken)match(input,58,FOLLOW_58_in_print1347); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(string_literal95);


                    }
                    break;
                case 2 :
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:192:20: 'printf'
                    {
                    string_literal96=(CommonToken)match(input,59,FOLLOW_59_in_print1349); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(string_literal96);


                    }
                    break;

            }


            pushFollow(FOLLOW_operand_in_print1352);
            operand97=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(operand97.getTree());

            EOL98=(CommonToken)match(input,EOL,FOLLOW_EOL_in_print1354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOL.add(EOL98);


            // AST REWRITE
            // elements: operand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 193:3: -> ^( ACTION[$name] ^( OPERAND operand ) )
            {
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:193:6: ^( ACTION[$name] ^( OPERAND operand ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ACTION, name)
                , root_1);

                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:193:22: ^( OPERAND operand )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(OPERAND, "OPERAND")
                , root_2);

                adaptor.addChild(root_2, stream_operand.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "print"

    // Delegated rules


 

    public static final BitSet FOLLOW_importing_in_crl135 = new BitSet(new long[]{0x1004000000000002L});
    public static final BitSet FOLLOW_rule_in_crl140 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_50_in_importing179 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_importing185 = new BitSet(new long[]{0x000000B000004000L});
    public static final BitSet FOLLOW_36_in_importing190 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_importing196 = new BitSet(new long[]{0x000000B000004000L});
    public static final BitSet FOLLOW_37_in_importing204 = new BitSet(new long[]{0x0000008000004000L});
    public static final BitSet FOLLOW_39_in_importing210 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_importing213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule235 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_INT_in_rule239 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_rule241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_rule245 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_rule247 = new BitSet(new long[]{0x0119BC0000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_condition_in_rule252 = new BitSet(new long[]{0x0119BC0000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_rule257 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_rule259 = new BitSet(new long[]{0xECE2410000000000L,0x000000000000004FL});
    public static final BitSet FOLLOW_action_in_rule264 = new BitSet(new long[]{0xECE2410000000000L,0x000000000000004FL});
    public static final BitSet FOLLOW_46_in_rule269 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_EOL_in_rule271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_condition318 = new BitSet(new long[]{0x0019BC0000000000L});
    public static final BitSet FOLLOW_query_in_condition327 = new BitSet(new long[]{0x0000004000104000L});
    public static final BitSet FOLLOW_ID_in_condition338 = new BitSet(new long[]{0x0000004000004000L});
    public static final BitSet FOLLOW_38_in_condition354 = new BitSet(new long[]{0xFFFFFFB7FFFFBFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_constraint_in_condition362 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_35_in_condition365 = new BitSet(new long[]{0xFFFFFFB7FFFFBFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_constraint_in_condition367 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_35_in_condition372 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_assignment_in_condition374 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_assignment_in_condition382 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_condition391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_query440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_query442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_query454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_query456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_query468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_query470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_query482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_query484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignment528 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_assignment530 = new BitSet(new long[]{0xFFFFFFFFFFFFBFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_expression_in_assignment532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_mark_in_action580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_text_in_action585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_indent_in_action590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_in_action595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_merge_in_action600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_entry_in_action605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_value_in_action610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_category_in_action615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_parent_in_action620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_action625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_label_in_action630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_label_in_action635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_update_in_action640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_action645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_set_mark691 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_mark697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_mark699 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_mark705 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_set_mark707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_set_text742 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_text748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_text750 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_text756 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_set_text758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_set_indent793 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_indent799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_indent801 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_indent807 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_set_indent809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_split844 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_split846 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_split848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_merge876 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_merge882 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_merge884 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_merge890 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_merge892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_new_entry927 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_new_entry933 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_41_in_new_entry936 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_new_entry942 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_new_entry946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_set_value982 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_value988 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_value990 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_value996 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_set_value998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_set_category1033 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_category1039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_category1041 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_category1047 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_set_category1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_set_parent1084 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_parent1090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_parent1092 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_set_parent1098 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_set_parent1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_group1135 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_group1141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_group1143 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_group1149 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_group1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_add_label1186 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_add_label1192 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_57_in_add_label1195 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_add_label1201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_add_label1205 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_add_label1211 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_add_label1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_new_label1256 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_new_label1262 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_41_in_new_label1265 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_new_label1271 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_new_label1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_update1311 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_update1313 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_update1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_print1347 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_59_in_print1349 = new BitSet(new long[]{0xFDFFFDFFFFFFBFF0L,0x00000000000000DFL});
    public static final BitSet FOLLOW_operand_in_print1352 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_print1354 = new BitSet(new long[]{0x0000000000000002L});

}