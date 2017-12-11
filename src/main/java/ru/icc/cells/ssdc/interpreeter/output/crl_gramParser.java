// $ANTLR 3.4 C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g 2017-12-11 20:24:54
package ru.icc.cells.ssdc.interpreeter.output;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class crl_gramParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Action", "Actions", "Add_label", "Assignment", "Breackits", "Char_lit", "Condition", "Conditions", "Constraint", "DIGIT", "EOL", "Group", "IDENT", "Identifier", "Import_item", "J_Expression", "J_expr", "J_int_literal", "Java_string_expr", "LETTER", "Merge", "New_entry", "New_label", "Other_literals", "Print", "RULES", "SETTING", "Set_category", "Set_indent", "Set_mark", "Set_parent", "Set_text", "Set_value", "Split", "String_lit", "Update", "WS", "'\"'", "'*'", "','", "'.'", "':'", "';'", "'add label'", "'as'", "'end'", "'group'", "'import'", "'lock-on-active'", "'merge'", "'new entry'", "'new label'", "'of'", "'package'", "'print'", "'printf'", "'rule #'", "'set category'", "'set indent'", "'set mark'", "'set parent'", "'set text'", "'set value'", "'split'", "'then'", "'to'", "'update'", "'when'", "'with'"
    };

    public static final int EOF=-1;
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
    public static final int Action=4;
    public static final int Actions=5;
    public static final int Add_label=6;
    public static final int Assignment=7;
    public static final int Breackits=8;
    public static final int Char_lit=9;
    public static final int Condition=10;
    public static final int Conditions=11;
    public static final int Constraint=12;
    public static final int DIGIT=13;
    public static final int EOL=14;
    public static final int Group=15;
    public static final int IDENT=16;
    public static final int Identifier=17;
    public static final int Import_item=18;
    public static final int J_Expression=19;
    public static final int J_expr=20;
    public static final int J_int_literal=21;
    public static final int Java_string_expr=22;
    public static final int LETTER=23;
    public static final int Merge=24;
    public static final int New_entry=25;
    public static final int New_label=26;
    public static final int Other_literals=27;
    public static final int Print=28;
    public static final int RULES=29;
    public static final int SETTING=30;
    public static final int Set_category=31;
    public static final int Set_indent=32;
    public static final int Set_mark=33;
    public static final int Set_parent=34;
    public static final int Set_text=35;
    public static final int Set_value=36;
    public static final int Split=37;
    public static final int String_lit=38;
    public static final int Update=39;
    public static final int WS=40;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public crl_gramParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public crl_gramParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return crl_gramParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g"; }


    public static class crl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public CommonTree getTree() { return tree; }
    };


    // $ANTLR start "crl"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:54:1: crl : ( import_stmt )* ( crl_rule )+ -> ^( SETTING ( import_stmt )* ) ^( RULES ( crl_rule )+ ) ;
    public final crl_gramParser.crl_return crl() throws RecognitionException {
        crl_gramParser.crl_return retval = new crl_gramParser.crl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.import_stmt_return import_stmt1 =null;

        crl_gramParser.crl_rule_return crl_rule2 =null;


        RewriteRuleSubtreeStream stream_crl_rule=new RewriteRuleSubtreeStream(adaptor,"rule crl_rule");
        RewriteRuleSubtreeStream stream_import_stmt=new RewriteRuleSubtreeStream(adaptor,"rule import_stmt");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:2: ( ( import_stmt )* ( crl_rule )+ -> ^( SETTING ( import_stmt )* ) ^( RULES ( crl_rule )+ ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:4: ( import_stmt )* ( crl_rule )+
            {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:4: ( import_stmt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==51||LA1_0==57) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:4: import_stmt
            	    {
            	    pushFollow(FOLLOW_import_stmt_in_crl169);
            	    import_stmt1=import_stmt();

            	    state._fsp--;

            	    stream_import_stmt.add(import_stmt1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:17: ( crl_rule )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==60) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:17: crl_rule
            	    {
            	    pushFollow(FOLLOW_crl_rule_in_crl172);
            	    crl_rule2=crl_rule();

            	    state._fsp--;

            	    stream_crl_rule.add(crl_rule2.getTree());

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


            // AST REWRITE
            // elements: import_stmt, crl_rule
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 55:27: -> ^( SETTING ( import_stmt )* ) ^( RULES ( crl_rule )+ )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:30: ^( SETTING ( import_stmt )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SETTING, "SETTING")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:40: ( import_stmt )*
                while ( stream_import_stmt.hasNext() ) {
                    adaptor.addChild(root_1, stream_import_stmt.nextTree());

                }
                stream_import_stmt.reset();

                adaptor.addChild(root_0, root_1);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:54: ^( RULES ( crl_rule )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RULES, "RULES")
                , root_1);

                if ( !(stream_crl_rule.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_crl_rule.hasNext() ) {
                    adaptor.addChild(root_1, stream_crl_rule.nextTree());

                }
                stream_crl_rule.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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


    public static class import_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_stmt"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:59:1: import_stmt : i= import_item -> Import_item[$i.value] ;
    public final crl_gramParser.import_stmt_return import_stmt() throws RecognitionException {
        crl_gramParser.import_stmt_return retval = new crl_gramParser.import_stmt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.import_item_return i =null;


        RewriteRuleSubtreeStream stream_import_item=new RewriteRuleSubtreeStream(adaptor,"rule import_item");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:60:2: (i= import_item -> Import_item[$i.value] )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:60:4: i= import_item
            {
            pushFollow(FOLLOW_import_item_in_import_stmt205);
            i=import_item();

            state._fsp--;

            stream_import_item.add(i.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 60:18: -> Import_item[$i.value]
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(Import_item, (i!=null?i.value:null))
                );

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "import_stmt"


    public static class import_item_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_item"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:62:1: import_item returns [String value] : t= ( 'import' | 'package' ) t1= identifier ( ';' )? EOL ;
    public final crl_gramParser.import_item_return import_item() throws RecognitionException {
        crl_gramParser.import_item_return retval = new crl_gramParser.import_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken t=null;
        CommonToken char_literal3=null;
        CommonToken EOL4=null;
        crl_gramParser.identifier_return t1 =null;


        CommonTree t_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree EOL4_tree=null;

         retval.value =""; 
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:65:2: (t= ( 'import' | 'package' ) t1= identifier ( ';' )? EOL )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:65:4: t= ( 'import' | 'package' ) t1= identifier ( ';' )? EOL
            {
            root_0 = (CommonTree)adaptor.nil();


            t=(CommonToken)input.LT(1);

            if ( input.LA(1)==51||input.LA(1)==57 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(t)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


             retval.value+=(t!=null?t.getText():null)+" "; 

            pushFollow(FOLLOW_identifier_in_import_item247);
            t1=identifier();

            state._fsp--;

            adaptor.addChild(root_0, t1.getTree());

             retval.value+=(t1!=null?t1.value:null); 

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:40: ( ';' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==46) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:40: ';'
                    {
                    char_literal3=(CommonToken)match(input,46,FOLLOW_46_in_import_item251); 
                    char_literal3_tree = 
                    (CommonTree)adaptor.create(char_literal3)
                    ;
                    adaptor.addChild(root_0, char_literal3_tree);


                    }
                    break;

            }


            EOL4=(CommonToken)match(input,EOL,FOLLOW_EOL_in_import_item254); 
            EOL4_tree = 
            (CommonTree)adaptor.create(EOL4)
            ;
            adaptor.addChild(root_0, EOL4_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

             retval.value+=";"; 
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
    // $ANTLR end "import_item"


    public static class crl_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "crl_rule"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:68:1: crl_rule : 'rule #' J_int_literal ( 'lock-on-active' )? EOL 'when' EOL ( condition )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) ) ;
    public final crl_gramParser.crl_rule_return crl_rule() throws RecognitionException {
        crl_gramParser.crl_rule_return retval = new crl_gramParser.crl_rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal5=null;
        CommonToken J_int_literal6=null;
        CommonToken string_literal7=null;
        CommonToken EOL8=null;
        CommonToken string_literal9=null;
        CommonToken EOL10=null;
        CommonToken string_literal12=null;
        CommonToken EOL13=null;
        CommonToken string_literal15=null;
        CommonToken EOL16=null;
        crl_gramParser.condition_return condition11 =null;

        crl_gramParser.action_return action14 =null;


        CommonTree string_literal5_tree=null;
        CommonTree J_int_literal6_tree=null;
        CommonTree string_literal7_tree=null;
        CommonTree EOL8_tree=null;
        CommonTree string_literal9_tree=null;
        CommonTree EOL10_tree=null;
        CommonTree string_literal12_tree=null;
        CommonTree EOL13_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree EOL16_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:69:2: ( 'rule #' J_int_literal ( 'lock-on-active' )? EOL 'when' EOL ( condition )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:69:4: 'rule #' J_int_literal ( 'lock-on-active' )? EOL 'when' EOL ( condition )+ 'then' EOL ( action )+ 'end' ( EOL )?
            {
            string_literal5=(CommonToken)match(input,60,FOLLOW_60_in_crl_rule264);  
            stream_60.add(string_literal5);


            J_int_literal6=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_crl_rule266);  
            stream_J_int_literal.add(J_int_literal6);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:69:27: ( 'lock-on-active' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==52) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:69:27: 'lock-on-active'
                    {
                    string_literal7=(CommonToken)match(input,52,FOLLOW_52_in_crl_rule268);  
                    stream_52.add(string_literal7);


                    }
                    break;

            }


            EOL8=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule271);  
            stream_EOL.add(EOL8);


            string_literal9=(CommonToken)match(input,71,FOLLOW_71_in_crl_rule275);  
            stream_71.add(string_literal9);


            EOL10=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule277);  
            stream_EOL.add(EOL10);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:71:3: ( condition )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Identifier) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:71:3: condition
            	    {
            	    pushFollow(FOLLOW_condition_in_crl_rule282);
            	    condition11=condition();

            	    state._fsp--;

            	    stream_condition.add(condition11.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            string_literal12=(CommonToken)match(input,68,FOLLOW_68_in_crl_rule287);  
            stream_68.add(string_literal12);


            EOL13=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule289);  
            stream_EOL.add(EOL13);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:73:3: ( action )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==47||LA6_0==50||(LA6_0 >= 53 && LA6_0 <= 55)||(LA6_0 >= 58 && LA6_0 <= 59)||(LA6_0 >= 61 && LA6_0 <= 65)||LA6_0==67||LA6_0==70) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:73:3: action
            	    {
            	    pushFollow(FOLLOW_action_in_crl_rule293);
            	    action14=action();

            	    state._fsp--;

            	    stream_action.add(action14.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            string_literal15=(CommonToken)match(input,49,FOLLOW_49_in_crl_rule298);  
            stream_49.add(string_literal15);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:9: ( EOL )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==EOL) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:9: EOL
                    {
                    EOL16=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule300);  
                    stream_EOL.add(EOL16);


                    }
                    break;

            }


            // AST REWRITE
            // elements: action, condition, J_int_literal
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 74:14: -> ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:17: ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_J_int_literal.nextNode()
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:33: ^( Conditions ( condition )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Conditions, "Conditions")
                , root_2);

                if ( !(stream_condition.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_condition.hasNext() ) {
                    adaptor.addChild(root_2, stream_condition.nextTree());

                }
                stream_condition.reset();

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:58: ^( Actions ( action )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Actions, "Actions")
                , root_2);

                if ( !(stream_action.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
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

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "crl_rule"


    public static class condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:76:1: condition : query identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query identifier ( constraint )* ( assignment )* ) ;
    public final crl_gramParser.condition_return condition() throws RecognitionException {
        crl_gramParser.condition_return retval = new crl_gramParser.condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken char_literal19=null;
        CommonToken char_literal21=null;
        CommonToken char_literal23=null;
        CommonToken EOL25=null;
        crl_gramParser.query_return query17 =null;

        crl_gramParser.identifier_return identifier18 =null;

        crl_gramParser.constraint_return constraint20 =null;

        crl_gramParser.constraint_return constraint22 =null;

        crl_gramParser.assignment_return assignment24 =null;


        CommonTree char_literal19_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree EOL25_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_query=new RewriteRuleSubtreeStream(adaptor,"rule query");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:2: ( query identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query identifier ( constraint )* ( assignment )* ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:4: query identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL
            {
            pushFollow(FOLLOW_query_in_condition331);
            query17=query();

            state._fsp--;

            stream_query.add(query17.getTree());

            pushFollow(FOLLOW_identifier_in_condition333);
            identifier18=identifier();

            state._fsp--;

            stream_identifier.add(identifier18.getTree());

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:21: ( ':' constraint ( ',' constraint )* ( ',' assignment )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==45) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:22: ':' constraint ( ',' constraint )* ( ',' assignment )*
                    {
                    char_literal19=(CommonToken)match(input,45,FOLLOW_45_in_condition336);  
                    stream_45.add(char_literal19);


                    pushFollow(FOLLOW_constraint_in_condition338);
                    constraint20=constraint();

                    state._fsp--;

                    stream_constraint.add(constraint20.getTree());

                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:37: ( ',' constraint )*
                    loop8:
                    do {
                        int alt8=2;
                        alt8 = dfa8.predict(input);
                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:38: ',' constraint
                    	    {
                    	    char_literal21=(CommonToken)match(input,43,FOLLOW_43_in_condition341);  
                    	    stream_43.add(char_literal21);


                    	    pushFollow(FOLLOW_constraint_in_condition343);
                    	    constraint22=constraint();

                    	    state._fsp--;

                    	    stream_constraint.add(constraint22.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:55: ( ',' assignment )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==43) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:56: ',' assignment
                    	    {
                    	    char_literal23=(CommonToken)match(input,43,FOLLOW_43_in_condition348);  
                    	    stream_43.add(char_literal23);


                    	    pushFollow(FOLLOW_assignment_in_condition350);
                    	    assignment24=assignment();

                    	    state._fsp--;

                    	    stream_assignment.add(assignment24.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            EOL25=(CommonToken)match(input,EOL,FOLLOW_EOL_in_condition357);  
            stream_EOL.add(EOL25);


            // AST REWRITE
            // elements: identifier, query, assignment, constraint
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 78:3: -> ^( Condition query identifier ( constraint )* ( assignment )* )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:78:6: ^( Condition query identifier ( constraint )* ( assignment )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Condition, "Condition")
                , root_1);

                adaptor.addChild(root_1, stream_query.nextTree());

                adaptor.addChild(root_1, stream_identifier.nextTree());

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:78:35: ( constraint )*
                while ( stream_constraint.hasNext() ) {
                    adaptor.addChild(root_1, stream_constraint.nextTree());

                }
                stream_constraint.reset();

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:78:47: ( assignment )*
                while ( stream_assignment.hasNext() ) {
                    adaptor.addChild(root_1, stream_assignment.nextTree());

                }
                stream_assignment.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "condition"


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:80:1: query : Identifier ;
    public final crl_gramParser.query_return query() throws RecognitionException {
        crl_gramParser.query_return retval = new crl_gramParser.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken Identifier26=null;

        CommonTree Identifier26_tree=null;

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:81:2: ( Identifier )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:81:4: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();


            Identifier26=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_query386); 
            Identifier26_tree = 
            (CommonTree)adaptor.create(Identifier26)
            ;
            adaptor.addChild(root_0, Identifier26_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:84:1: constraint : j_expr -> ( ^( Constraint j_expr ) )+ ;
    public final crl_gramParser.constraint_return constraint() throws RecognitionException {
        crl_gramParser.constraint_return retval = new crl_gramParser.constraint_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.j_expr_return j_expr27 =null;


        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:85:2: ( j_expr -> ( ^( Constraint j_expr ) )+ )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:85:4: j_expr
            {
            pushFollow(FOLLOW_j_expr_in_constraint399);
            j_expr27=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr27.getTree());

            // AST REWRITE
            // elements: j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 85:11: -> ( ^( Constraint j_expr ) )+
            {
                if ( !(stream_j_expr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_j_expr.hasNext() ) {
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:85:14: ^( Constraint j_expr )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(Constraint, "Constraint")
                    , root_1);

                    adaptor.addChild(root_1, stream_j_expr.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_j_expr.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:87:1: assignment : identifier ':' j_expr_ -> ^( Assignment identifier j_expr_ ) ;
    public final crl_gramParser.assignment_return assignment() throws RecognitionException {
        crl_gramParser.assignment_return retval = new crl_gramParser.assignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken char_literal29=null;
        crl_gramParser.identifier_return identifier28 =null;

        crl_gramParser.j_expr__return j_expr_30 =null;


        CommonTree char_literal29_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_j_expr_=new RewriteRuleSubtreeStream(adaptor,"rule j_expr_");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:88:2: ( identifier ':' j_expr_ -> ^( Assignment identifier j_expr_ ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:88:4: identifier ':' j_expr_
            {
            pushFollow(FOLLOW_identifier_in_assignment418);
            identifier28=identifier();

            state._fsp--;

            stream_identifier.add(identifier28.getTree());

            char_literal29=(CommonToken)match(input,45,FOLLOW_45_in_assignment420);  
            stream_45.add(char_literal29);


            pushFollow(FOLLOW_j_expr__in_assignment422);
            j_expr_30=j_expr_();

            state._fsp--;

            stream_j_expr_.add(j_expr_30.getTree());

            // AST REWRITE
            // elements: identifier, j_expr_
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 88:27: -> ^( Assignment identifier j_expr_ )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:88:30: ^( Assignment identifier j_expr_ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Assignment, "Assignment")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                adaptor.addChild(root_1, stream_j_expr_.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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


    public static class j_expr_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "j_expr"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:106:1: j_expr returns [String value] : (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+ ;
    public final crl_gramParser.j_expr_return j_expr() throws RecognitionException {
        crl_gramParser.j_expr_return retval = new crl_gramParser.j_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken i=null;

        CommonTree i_tree=null;

         retval.value =""; 
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:108:2: ( (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+ )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:108:5: (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:108:5: (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= Action && LA11_0 <= DIGIT)||(LA11_0 >= Group && LA11_0 <= WS)||LA11_0==42||LA11_0==44||(LA11_0 >= 46 && LA11_0 <= 68)||(LA11_0 >= 70 && LA11_0 <= 72)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:108:7: i=~ ( ',' | '\"' | ':' | 'to' | EOL )
            	    {
            	    i=(CommonToken)input.LT(1);

            	    if ( (input.LA(1) >= Action && input.LA(1) <= DIGIT)||(input.LA(1) >= Group && input.LA(1) <= WS)||input.LA(1)==42||input.LA(1)==44||(input.LA(1) >= 46 && input.LA(1) <= 68)||(input.LA(1) >= 70 && input.LA(1) <= 72) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (CommonTree)adaptor.create(i)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	     retval.value+=(i!=null?i.getText():null); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "j_expr"


    public static class j_expr__return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "j_expr_"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:111:1: j_expr_ : j= j_expr -> ^( J_expr[$j.value] ) ;
    public final crl_gramParser.j_expr__return j_expr_() throws RecognitionException {
        crl_gramParser.j_expr__return retval = new crl_gramParser.j_expr__return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.j_expr_return j =null;


        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:112:2: (j= j_expr -> ^( J_expr[$j.value] ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:112:4: j= j_expr
            {
            pushFollow(FOLLOW_j_expr_in_j_expr_492);
            j=j_expr();

            state._fsp--;

            stream_j_expr.add(j.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 112:13: -> ^( J_expr[$j.value] )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:112:16: ^( J_expr[$j.value] )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(J_expr, (j!=null?j.value:null))
                , root_1);

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "j_expr_"


    public static class action_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:115:1: action : action_ EOL -> action_ ;
    public final crl_gramParser.action_return action() throws RecognitionException {
        crl_gramParser.action_return retval = new crl_gramParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken EOL32=null;
        crl_gramParser.action__return action_31 =null;


        CommonTree EOL32_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleSubtreeStream stream_action_=new RewriteRuleSubtreeStream(adaptor,"rule action_");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:116:2: ( action_ EOL -> action_ )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:116:4: action_ EOL
            {
            pushFollow(FOLLOW_action__in_action511);
            action_31=action_();

            state._fsp--;

            stream_action_.add(action_31.getTree());

            EOL32=(CommonToken)match(input,EOL,FOLLOW_EOL_in_action513);  
            stream_EOL.add(EOL32);


            // AST REWRITE
            // elements: action_
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 116:16: -> action_
            {
                adaptor.addChild(root_0, stream_action_.nextTree());

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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


    public static class action__return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action_"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:118:1: action_ : ( set_mark | set_text | set_indent | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update );
    public final crl_gramParser.action__return action_() throws RecognitionException {
        crl_gramParser.action__return retval = new crl_gramParser.action__return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.set_mark_return set_mark33 =null;

        crl_gramParser.set_text_return set_text34 =null;

        crl_gramParser.set_indent_return set_indent35 =null;

        crl_gramParser.split_return split36 =null;

        crl_gramParser.merge_return merge37 =null;

        crl_gramParser.new_label_return new_label38 =null;

        crl_gramParser.add_label_return add_label39 =null;

        crl_gramParser.set_category_return set_category40 =null;

        crl_gramParser.set_parent_return set_parent41 =null;

        crl_gramParser.new_entry_return new_entry42 =null;

        crl_gramParser.group_return group43 =null;

        crl_gramParser.c_print_return c_print44 =null;

        crl_gramParser.update_return update45 =null;



        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:119:2: ( set_mark | set_text | set_indent | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update )
            int alt12=13;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt12=1;
                }
                break;
            case 65:
                {
                alt12=2;
                }
                break;
            case 62:
                {
                alt12=3;
                }
                break;
            case 67:
                {
                alt12=4;
                }
                break;
            case 53:
                {
                alt12=5;
                }
                break;
            case 55:
                {
                alt12=6;
                }
                break;
            case 47:
                {
                alt12=7;
                }
                break;
            case 61:
                {
                alt12=8;
                }
                break;
            case 64:
                {
                alt12=9;
                }
                break;
            case 54:
                {
                alt12=10;
                }
                break;
            case 50:
                {
                alt12=11;
                }
                break;
            case 58:
            case 59:
                {
                alt12=12;
                }
                break;
            case 70:
                {
                alt12=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:119:4: set_mark
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_mark_in_action_527);
                    set_mark33=set_mark();

                    state._fsp--;

                    adaptor.addChild(root_0, set_mark33.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:120:4: set_text
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_text_in_action_532);
                    set_text34=set_text();

                    state._fsp--;

                    adaptor.addChild(root_0, set_text34.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:121:4: set_indent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_indent_in_action_537);
                    set_indent35=set_indent();

                    state._fsp--;

                    adaptor.addChild(root_0, set_indent35.getTree());

                    }
                    break;
                case 4 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:122:4: split
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_split_in_action_542);
                    split36=split();

                    state._fsp--;

                    adaptor.addChild(root_0, split36.getTree());

                    }
                    break;
                case 5 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:123:4: merge
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_merge_in_action_547);
                    merge37=merge();

                    state._fsp--;

                    adaptor.addChild(root_0, merge37.getTree());

                    }
                    break;
                case 6 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:124:4: new_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_new_label_in_action_552);
                    new_label38=new_label();

                    state._fsp--;

                    adaptor.addChild(root_0, new_label38.getTree());

                    }
                    break;
                case 7 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:125:4: add_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_add_label_in_action_557);
                    add_label39=add_label();

                    state._fsp--;

                    adaptor.addChild(root_0, add_label39.getTree());

                    }
                    break;
                case 8 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:126:4: set_category
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_category_in_action_562);
                    set_category40=set_category();

                    state._fsp--;

                    adaptor.addChild(root_0, set_category40.getTree());

                    }
                    break;
                case 9 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:127:4: set_parent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_parent_in_action_567);
                    set_parent41=set_parent();

                    state._fsp--;

                    adaptor.addChild(root_0, set_parent41.getTree());

                    }
                    break;
                case 10 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:128:4: new_entry
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_new_entry_in_action_572);
                    new_entry42=new_entry();

                    state._fsp--;

                    adaptor.addChild(root_0, new_entry42.getTree());

                    }
                    break;
                case 11 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:129:4: group
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_group_in_action_577);
                    group43=group();

                    state._fsp--;

                    adaptor.addChild(root_0, group43.getTree());

                    }
                    break;
                case 12 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:130:4: c_print
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_c_print_in_action_582);
                    c_print44=c_print();

                    state._fsp--;

                    adaptor.addChild(root_0, c_print44.getTree());

                    }
                    break;
                case 13 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:131:4: update
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_update_in_action_587);
                    update45=update();

                    state._fsp--;

                    adaptor.addChild(root_0, update45.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "action_"


    public static class set_mark_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_mark"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:133:1: set_mark : 'set mark' j_expr 'to' identifier -> ^( Set_mark identifier j_expr ) ;
    public final crl_gramParser.set_mark_return set_mark() throws RecognitionException {
        crl_gramParser.set_mark_return retval = new crl_gramParser.set_mark_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal46=null;
        CommonToken string_literal48=null;
        crl_gramParser.j_expr_return j_expr47 =null;

        crl_gramParser.identifier_return identifier49 =null;


        CommonTree string_literal46_tree=null;
        CommonTree string_literal48_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:134:2: ( 'set mark' j_expr 'to' identifier -> ^( Set_mark identifier j_expr ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:134:4: 'set mark' j_expr 'to' identifier
            {
            string_literal46=(CommonToken)match(input,63,FOLLOW_63_in_set_mark597);  
            stream_63.add(string_literal46);


            pushFollow(FOLLOW_j_expr_in_set_mark599);
            j_expr47=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr47.getTree());

            string_literal48=(CommonToken)match(input,69,FOLLOW_69_in_set_mark601);  
            stream_69.add(string_literal48);


            pushFollow(FOLLOW_identifier_in_set_mark603);
            identifier49=identifier();

            state._fsp--;

            stream_identifier.add(identifier49.getTree());

            // AST REWRITE
            // elements: j_expr, identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 134:38: -> ^( Set_mark identifier j_expr )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:134:41: ^( Set_mark identifier j_expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_mark, "Set_mark")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                adaptor.addChild(root_1, stream_j_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:136:1: set_text : 'set text' j_expr 'to' identifier -> ^( Set_text identifier j_expr ) ;
    public final crl_gramParser.set_text_return set_text() throws RecognitionException {
        crl_gramParser.set_text_return retval = new crl_gramParser.set_text_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal50=null;
        CommonToken string_literal52=null;
        crl_gramParser.j_expr_return j_expr51 =null;

        crl_gramParser.identifier_return identifier53 =null;


        CommonTree string_literal50_tree=null;
        CommonTree string_literal52_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:137:2: ( 'set text' j_expr 'to' identifier -> ^( Set_text identifier j_expr ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:137:4: 'set text' j_expr 'to' identifier
            {
            string_literal50=(CommonToken)match(input,65,FOLLOW_65_in_set_text623);  
            stream_65.add(string_literal50);


            pushFollow(FOLLOW_j_expr_in_set_text625);
            j_expr51=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr51.getTree());

            string_literal52=(CommonToken)match(input,69,FOLLOW_69_in_set_text627);  
            stream_69.add(string_literal52);


            pushFollow(FOLLOW_identifier_in_set_text629);
            identifier53=identifier();

            state._fsp--;

            stream_identifier.add(identifier53.getTree());

            // AST REWRITE
            // elements: identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 137:38: -> ^( Set_text identifier j_expr )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:137:41: ^( Set_text identifier j_expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_text, "Set_text")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                adaptor.addChild(root_1, stream_j_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:139:1: set_indent : 'set indent' J_int_literal 'to' identifier -> ^( Set_indent identifier J_int_literal ) ;
    public final crl_gramParser.set_indent_return set_indent() throws RecognitionException {
        crl_gramParser.set_indent_return retval = new crl_gramParser.set_indent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal54=null;
        CommonToken J_int_literal55=null;
        CommonToken string_literal56=null;
        crl_gramParser.identifier_return identifier57 =null;


        CommonTree string_literal54_tree=null;
        CommonTree J_int_literal55_tree=null;
        CommonTree string_literal56_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:140:2: ( 'set indent' J_int_literal 'to' identifier -> ^( Set_indent identifier J_int_literal ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:140:4: 'set indent' J_int_literal 'to' identifier
            {
            string_literal54=(CommonToken)match(input,62,FOLLOW_62_in_set_indent649);  
            stream_62.add(string_literal54);


            J_int_literal55=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_set_indent651);  
            stream_J_int_literal.add(J_int_literal55);


            string_literal56=(CommonToken)match(input,69,FOLLOW_69_in_set_indent653);  
            stream_69.add(string_literal56);


            pushFollow(FOLLOW_identifier_in_set_indent655);
            identifier57=identifier();

            state._fsp--;

            stream_identifier.add(identifier57.getTree());

            // AST REWRITE
            // elements: J_int_literal, identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 140:47: -> ^( Set_indent identifier J_int_literal )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:140:50: ^( Set_indent identifier J_int_literal )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_indent, "Set_indent")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                adaptor.addChild(root_1, 
                stream_J_int_literal.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:142:1: split : 'split' identifier -> ^( Split identifier ) ;
    public final crl_gramParser.split_return split() throws RecognitionException {
        crl_gramParser.split_return retval = new crl_gramParser.split_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal58=null;
        crl_gramParser.identifier_return identifier59 =null;


        CommonTree string_literal58_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:143:2: ( 'split' identifier -> ^( Split identifier ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:143:4: 'split' identifier
            {
            string_literal58=(CommonToken)match(input,67,FOLLOW_67_in_split675);  
            stream_67.add(string_literal58);


            pushFollow(FOLLOW_identifier_in_split677);
            identifier59=identifier();

            state._fsp--;

            stream_identifier.add(identifier59.getTree());

            // AST REWRITE
            // elements: identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 143:23: -> ^( Split identifier )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:143:26: ^( Split identifier )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Split, "Split")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:145:1: merge : 'merge' i1= identifier 'with' i2= identifier -> ^( Merge $i1 $i2) ;
    public final crl_gramParser.merge_return merge() throws RecognitionException {
        crl_gramParser.merge_return retval = new crl_gramParser.merge_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal60=null;
        CommonToken string_literal61=null;
        crl_gramParser.identifier_return i1 =null;

        crl_gramParser.identifier_return i2 =null;


        CommonTree string_literal60_tree=null;
        CommonTree string_literal61_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:146:2: ( 'merge' i1= identifier 'with' i2= identifier -> ^( Merge $i1 $i2) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:146:4: 'merge' i1= identifier 'with' i2= identifier
            {
            string_literal60=(CommonToken)match(input,53,FOLLOW_53_in_merge695);  
            stream_53.add(string_literal60);


            pushFollow(FOLLOW_identifier_in_merge699);
            i1=identifier();

            state._fsp--;

            stream_identifier.add(i1.getTree());

            string_literal61=(CommonToken)match(input,72,FOLLOW_72_in_merge701);  
            stream_72.add(string_literal61);


            pushFollow(FOLLOW_identifier_in_merge705);
            i2=identifier();

            state._fsp--;

            stream_identifier.add(i2.getTree());

            // AST REWRITE
            // elements: i2, i1
            // token labels: 
            // rule labels: i1, i2, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_i1=new RewriteRuleSubtreeStream(adaptor,"rule i1",i1!=null?i1.tree:null);
            RewriteRuleSubtreeStream stream_i2=new RewriteRuleSubtreeStream(adaptor,"rule i2",i2!=null?i2.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 146:47: -> ^( Merge $i1 $i2)
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:146:50: ^( Merge $i1 $i2)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Merge, "Merge")
                , root_1);

                adaptor.addChild(root_1, stream_i1.nextTree());

                adaptor.addChild(root_1, stream_i2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:148:1: new_entry : 'new entry' identifier ( 'as' j_expr )? -> ^( New_entry identifier ( j_expr )? ) ;
    public final crl_gramParser.new_entry_return new_entry() throws RecognitionException {
        crl_gramParser.new_entry_return retval = new crl_gramParser.new_entry_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal62=null;
        CommonToken string_literal64=null;
        crl_gramParser.identifier_return identifier63 =null;

        crl_gramParser.j_expr_return j_expr65 =null;


        CommonTree string_literal62_tree=null;
        CommonTree string_literal64_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:149:2: ( 'new entry' identifier ( 'as' j_expr )? -> ^( New_entry identifier ( j_expr )? ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:149:4: 'new entry' identifier ( 'as' j_expr )?
            {
            string_literal62=(CommonToken)match(input,54,FOLLOW_54_in_new_entry727);  
            stream_54.add(string_literal62);


            pushFollow(FOLLOW_identifier_in_new_entry729);
            identifier63=identifier();

            state._fsp--;

            stream_identifier.add(identifier63.getTree());

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:149:27: ( 'as' j_expr )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==48) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:149:28: 'as' j_expr
                    {
                    string_literal64=(CommonToken)match(input,48,FOLLOW_48_in_new_entry732);  
                    stream_48.add(string_literal64);


                    pushFollow(FOLLOW_j_expr_in_new_entry734);
                    j_expr65=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr65.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: j_expr, identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 149:42: -> ^( New_entry identifier ( j_expr )? )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:149:45: ^( New_entry identifier ( j_expr )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(New_entry, "New_entry")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:149:68: ( j_expr )?
                if ( stream_j_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_j_expr.nextTree());

                }
                stream_j_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:151:1: set_value : 'set value' j_expr 'to' identifier -> ^( Set_value j_expr identifier ) ;
    public final crl_gramParser.set_value_return set_value() throws RecognitionException {
        crl_gramParser.set_value_return retval = new crl_gramParser.set_value_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal66=null;
        CommonToken string_literal68=null;
        crl_gramParser.j_expr_return j_expr67 =null;

        crl_gramParser.identifier_return identifier69 =null;


        CommonTree string_literal66_tree=null;
        CommonTree string_literal68_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:152:2: ( 'set value' j_expr 'to' identifier -> ^( Set_value j_expr identifier ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:152:4: 'set value' j_expr 'to' identifier
            {
            string_literal66=(CommonToken)match(input,66,FOLLOW_66_in_set_value757);  
            stream_66.add(string_literal66);


            pushFollow(FOLLOW_j_expr_in_set_value759);
            j_expr67=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr67.getTree());

            string_literal68=(CommonToken)match(input,69,FOLLOW_69_in_set_value761);  
            stream_69.add(string_literal68);


            pushFollow(FOLLOW_identifier_in_set_value763);
            identifier69=identifier();

            state._fsp--;

            stream_identifier.add(identifier69.getTree());

            // AST REWRITE
            // elements: j_expr, identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 152:39: -> ^( Set_value j_expr identifier )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:152:42: ^( Set_value j_expr identifier )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_value, "Set_value")
                , root_1);

                adaptor.addChild(root_1, stream_j_expr.nextTree());

                adaptor.addChild(root_1, stream_identifier.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:154:1: set_category : 'set category' i1= identifier 'to' i2= identifier -> ^( Set_category $i1 $i2) ;
    public final crl_gramParser.set_category_return set_category() throws RecognitionException {
        crl_gramParser.set_category_return retval = new crl_gramParser.set_category_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal70=null;
        CommonToken string_literal71=null;
        crl_gramParser.identifier_return i1 =null;

        crl_gramParser.identifier_return i2 =null;


        CommonTree string_literal70_tree=null;
        CommonTree string_literal71_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:155:2: ( 'set category' i1= identifier 'to' i2= identifier -> ^( Set_category $i1 $i2) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:155:4: 'set category' i1= identifier 'to' i2= identifier
            {
            string_literal70=(CommonToken)match(input,61,FOLLOW_61_in_set_category783);  
            stream_61.add(string_literal70);


            pushFollow(FOLLOW_identifier_in_set_category787);
            i1=identifier();

            state._fsp--;

            stream_identifier.add(i1.getTree());

            string_literal71=(CommonToken)match(input,69,FOLLOW_69_in_set_category789);  
            stream_69.add(string_literal71);


            pushFollow(FOLLOW_identifier_in_set_category793);
            i2=identifier();

            state._fsp--;

            stream_identifier.add(i2.getTree());

            // AST REWRITE
            // elements: i1, i2
            // token labels: 
            // rule labels: i1, i2, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_i1=new RewriteRuleSubtreeStream(adaptor,"rule i1",i1!=null?i1.tree:null);
            RewriteRuleSubtreeStream stream_i2=new RewriteRuleSubtreeStream(adaptor,"rule i2",i2!=null?i2.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 155:52: -> ^( Set_category $i1 $i2)
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:155:55: ^( Set_category $i1 $i2)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_category, "Set_category")
                , root_1);

                adaptor.addChild(root_1, stream_i1.nextTree());

                adaptor.addChild(root_1, stream_i2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:157:1: set_parent : 'set parent' i1= identifier 'to' i2= identifier -> ^( Set_parent $i1 $i2) ;
    public final crl_gramParser.set_parent_return set_parent() throws RecognitionException {
        crl_gramParser.set_parent_return retval = new crl_gramParser.set_parent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal72=null;
        CommonToken string_literal73=null;
        crl_gramParser.identifier_return i1 =null;

        crl_gramParser.identifier_return i2 =null;


        CommonTree string_literal72_tree=null;
        CommonTree string_literal73_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:158:2: ( 'set parent' i1= identifier 'to' i2= identifier -> ^( Set_parent $i1 $i2) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:158:4: 'set parent' i1= identifier 'to' i2= identifier
            {
            string_literal72=(CommonToken)match(input,64,FOLLOW_64_in_set_parent815);  
            stream_64.add(string_literal72);


            pushFollow(FOLLOW_identifier_in_set_parent819);
            i1=identifier();

            state._fsp--;

            stream_identifier.add(i1.getTree());

            string_literal73=(CommonToken)match(input,69,FOLLOW_69_in_set_parent821);  
            stream_69.add(string_literal73);


            pushFollow(FOLLOW_identifier_in_set_parent825);
            i2=identifier();

            state._fsp--;

            stream_identifier.add(i2.getTree());

            // AST REWRITE
            // elements: i1, i2
            // token labels: 
            // rule labels: i1, i2, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_i1=new RewriteRuleSubtreeStream(adaptor,"rule i1",i1!=null?i1.tree:null);
            RewriteRuleSubtreeStream stream_i2=new RewriteRuleSubtreeStream(adaptor,"rule i2",i2!=null?i2.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 158:50: -> ^( Set_parent $i1 $i2)
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:158:53: ^( Set_parent $i1 $i2)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_parent, "Set_parent")
                , root_1);

                adaptor.addChild(root_1, stream_i1.nextTree());

                adaptor.addChild(root_1, stream_i2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:160:1: group : 'group' i1= identifier 'with' i2= identifier -> ^( Group $i1 $i2) ;
    public final crl_gramParser.group_return group() throws RecognitionException {
        crl_gramParser.group_return retval = new crl_gramParser.group_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal74=null;
        CommonToken string_literal75=null;
        crl_gramParser.identifier_return i1 =null;

        crl_gramParser.identifier_return i2 =null;


        CommonTree string_literal74_tree=null;
        CommonTree string_literal75_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:161:2: ( 'group' i1= identifier 'with' i2= identifier -> ^( Group $i1 $i2) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:161:4: 'group' i1= identifier 'with' i2= identifier
            {
            string_literal74=(CommonToken)match(input,50,FOLLOW_50_in_group847);  
            stream_50.add(string_literal74);


            pushFollow(FOLLOW_identifier_in_group851);
            i1=identifier();

            state._fsp--;

            stream_identifier.add(i1.getTree());

            string_literal75=(CommonToken)match(input,72,FOLLOW_72_in_group853);  
            stream_72.add(string_literal75);


            pushFollow(FOLLOW_identifier_in_group857);
            i2=identifier();

            state._fsp--;

            stream_identifier.add(i2.getTree());

            // AST REWRITE
            // elements: i2, i1
            // token labels: 
            // rule labels: i1, i2, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_i1=new RewriteRuleSubtreeStream(adaptor,"rule i1",i1!=null?i1.tree:null);
            RewriteRuleSubtreeStream stream_i2=new RewriteRuleSubtreeStream(adaptor,"rule i2",i2!=null?i2.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 161:47: -> ^( Group $i1 $i2)
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:161:50: ^( Group $i1 $i2)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Group, "Group")
                , root_1);

                adaptor.addChild(root_1, stream_i1.nextTree());

                adaptor.addChild(root_1, stream_i2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:163:1: add_label : 'add label' i1= identifier ( 'of' i2= identifier )? 'to' i3= identifier -> ^( Add_label $i1 ( $i2)? $i3) ;
    public final crl_gramParser.add_label_return add_label() throws RecognitionException {
        crl_gramParser.add_label_return retval = new crl_gramParser.add_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal76=null;
        CommonToken string_literal77=null;
        CommonToken string_literal78=null;
        crl_gramParser.identifier_return i1 =null;

        crl_gramParser.identifier_return i2 =null;

        crl_gramParser.identifier_return i3 =null;


        CommonTree string_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree string_literal78_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:164:2: ( 'add label' i1= identifier ( 'of' i2= identifier )? 'to' i3= identifier -> ^( Add_label $i1 ( $i2)? $i3) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:164:4: 'add label' i1= identifier ( 'of' i2= identifier )? 'to' i3= identifier
            {
            string_literal76=(CommonToken)match(input,47,FOLLOW_47_in_add_label879);  
            stream_47.add(string_literal76);


            pushFollow(FOLLOW_identifier_in_add_label883);
            i1=identifier();

            state._fsp--;

            stream_identifier.add(i1.getTree());

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:164:30: ( 'of' i2= identifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==56) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:164:31: 'of' i2= identifier
                    {
                    string_literal77=(CommonToken)match(input,56,FOLLOW_56_in_add_label886);  
                    stream_56.add(string_literal77);


                    pushFollow(FOLLOW_identifier_in_add_label890);
                    i2=identifier();

                    state._fsp--;

                    stream_identifier.add(i2.getTree());

                    }
                    break;

            }


            string_literal78=(CommonToken)match(input,69,FOLLOW_69_in_add_label894);  
            stream_69.add(string_literal78);


            pushFollow(FOLLOW_identifier_in_add_label898);
            i3=identifier();

            state._fsp--;

            stream_identifier.add(i3.getTree());

            // AST REWRITE
            // elements: i3, i2, i1
            // token labels: 
            // rule labels: i1, i2, i3, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_i1=new RewriteRuleSubtreeStream(adaptor,"rule i1",i1!=null?i1.tree:null);
            RewriteRuleSubtreeStream stream_i2=new RewriteRuleSubtreeStream(adaptor,"rule i2",i2!=null?i2.tree:null);
            RewriteRuleSubtreeStream stream_i3=new RewriteRuleSubtreeStream(adaptor,"rule i3",i3!=null?i3.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 164:71: -> ^( Add_label $i1 ( $i2)? $i3)
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:164:74: ^( Add_label $i1 ( $i2)? $i3)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Add_label, "Add_label")
                , root_1);

                adaptor.addChild(root_1, stream_i1.nextTree());

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:164:91: ( $i2)?
                if ( stream_i2.hasNext() ) {
                    adaptor.addChild(root_1, stream_i2.nextTree());

                }
                stream_i2.reset();

                adaptor.addChild(root_1, stream_i3.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:166:1: new_label : 'new label' identifier ( 'as' j_expr )? -> ^( New_label identifier ( j_expr )? ) ;
    public final crl_gramParser.new_label_return new_label() throws RecognitionException {
        crl_gramParser.new_label_return retval = new crl_gramParser.new_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal79=null;
        CommonToken string_literal81=null;
        crl_gramParser.identifier_return identifier80 =null;

        crl_gramParser.j_expr_return j_expr82 =null;


        CommonTree string_literal79_tree=null;
        CommonTree string_literal81_tree=null;
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:2: ( 'new label' identifier ( 'as' j_expr )? -> ^( New_label identifier ( j_expr )? ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:4: 'new label' identifier ( 'as' j_expr )?
            {
            string_literal79=(CommonToken)match(input,55,FOLLOW_55_in_new_label924);  
            stream_55.add(string_literal79);


            pushFollow(FOLLOW_identifier_in_new_label926);
            identifier80=identifier();

            state._fsp--;

            stream_identifier.add(identifier80.getTree());

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:27: ( 'as' j_expr )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==48) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:28: 'as' j_expr
                    {
                    string_literal81=(CommonToken)match(input,48,FOLLOW_48_in_new_label929);  
                    stream_48.add(string_literal81);


                    pushFollow(FOLLOW_j_expr_in_new_label931);
                    j_expr82=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr82.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 167:42: -> ^( New_label identifier ( j_expr )? )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:45: ^( New_label identifier ( j_expr )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(New_label, "New_label")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:68: ( j_expr )?
                if ( stream_j_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_j_expr.nextTree());

                }
                stream_j_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:169:1: update : 'update' identifier -> ^( Update identifier ) ;
    public final crl_gramParser.update_return update() throws RecognitionException {
        crl_gramParser.update_return retval = new crl_gramParser.update_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal83=null;
        crl_gramParser.identifier_return identifier84 =null;


        CommonTree string_literal83_tree=null;
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:170:2: ( 'update' identifier -> ^( Update identifier ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:170:4: 'update' identifier
            {
            string_literal83=(CommonToken)match(input,70,FOLLOW_70_in_update954);  
            stream_70.add(string_literal83);


            pushFollow(FOLLOW_identifier_in_update956);
            identifier84=identifier();

            state._fsp--;

            stream_identifier.add(identifier84.getTree());

            // AST REWRITE
            // elements: identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 170:24: -> ^( Update identifier )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:170:27: ^( Update identifier )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Update, "Update")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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


    public static class c_print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "c_print"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:172:1: c_print : ( 'print' | 'printf' ) j_expr -> ^( Print j_expr ) ;
    public final crl_gramParser.c_print_return c_print() throws RecognitionException {
        crl_gramParser.c_print_return retval = new crl_gramParser.c_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal85=null;
        CommonToken string_literal86=null;
        crl_gramParser.j_expr_return j_expr87 =null;


        CommonTree string_literal85_tree=null;
        CommonTree string_literal86_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:173:2: ( ( 'print' | 'printf' ) j_expr -> ^( Print j_expr ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:173:4: ( 'print' | 'printf' ) j_expr
            {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:173:4: ( 'print' | 'printf' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==58) ) {
                alt16=1;
            }
            else if ( (LA16_0==59) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:173:5: 'print'
                    {
                    string_literal85=(CommonToken)match(input,58,FOLLOW_58_in_c_print975);  
                    stream_58.add(string_literal85);


                    }
                    break;
                case 2 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:173:13: 'printf'
                    {
                    string_literal86=(CommonToken)match(input,59,FOLLOW_59_in_c_print977);  
                    stream_59.add(string_literal86);


                    }
                    break;

            }


            pushFollow(FOLLOW_j_expr_in_c_print980);
            j_expr87=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr87.getTree());

            // AST REWRITE
            // elements: j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 173:30: -> ^( Print j_expr )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:173:33: ^( Print j_expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Print, "Print")
                , root_1);

                adaptor.addChild(root_1, stream_j_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "c_print"


    public static class identifier_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "identifier"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:176:1: identifier returns [String value] : t1= Identifier ( '.' t2= Identifier )* ( '.' '*' )? -> IDENT[$value] ;
    public final crl_gramParser.identifier_return identifier() throws RecognitionException {
        crl_gramParser.identifier_return retval = new crl_gramParser.identifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken t1=null;
        CommonToken t2=null;
        CommonToken char_literal88=null;
        CommonToken char_literal89=null;
        CommonToken char_literal90=null;

        CommonTree t1_tree=null;
        CommonTree t2_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree char_literal90_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");

         retval.value =""; 
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:178:2: (t1= Identifier ( '.' t2= Identifier )* ( '.' '*' )? -> IDENT[$value] )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:178:5: t1= Identifier ( '.' t2= Identifier )* ( '.' '*' )?
            {
            t1=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_identifier1011);  
            stream_Identifier.add(t1);


             retval.value+=(t1!=null?t1.getText():null); 

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:178:41: ( '.' t2= Identifier )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==44) ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1==Identifier) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:178:42: '.' t2= Identifier
            	    {
            	    char_literal88=(CommonToken)match(input,44,FOLLOW_44_in_identifier1016);  
            	    stream_44.add(char_literal88);


            	    t2=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_identifier1020);  
            	    stream_Identifier.add(t2);


            	     retval.value+="."+(t2!=null?t2.getText():null); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:178:88: ( '.' '*' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==44) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:178:89: '.' '*'
                    {
                    char_literal89=(CommonToken)match(input,44,FOLLOW_44_in_identifier1027);  
                    stream_44.add(char_literal89);


                    char_literal90=(CommonToken)match(input,42,FOLLOW_42_in_identifier1029);  
                    stream_42.add(char_literal90);


                     retval.value+=".*"; 

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
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:117: -> IDENT[$value]
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(IDENT, retval.value)
                );

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "identifier"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\10\uffff";
    static final String DFA8_eofS =
        "\10\uffff";
    static final String DFA8_minS =
        "\1\16\1\4\1\uffff\1\4\1\uffff\3\4";
    static final String DFA8_maxS =
        "\1\53\1\110\1\uffff\1\110\1\uffff\3\110";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\3\uffff";
    static final String DFA8_specialS =
        "\10\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\34\uffff\1\1",
            "\12\4\1\uffff\2\4\1\3\27\4\1\uffff\1\4\1\uffff\1\4\1\uffff"+
            "\27\4\1\uffff\3\4",
            "",
            "\45\4\1\uffff\2\4\1\5\1\2\27\4\1\uffff\3\4",
            "",
            "\15\4\1\6\27\4\1\uffff\1\7\2\4\1\uffff\27\4\1\uffff\3\4",
            "\45\4\1\uffff\2\4\1\5\1\2\27\4\1\uffff\3\4",
            "\45\4\1\uffff\3\4\1\2\27\4\1\uffff\3\4"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 77:37: ( ',' constraint )*";
        }
    }
 

    public static final BitSet FOLLOW_import_stmt_in_crl169 = new BitSet(new long[]{0x1208000000000000L});
    public static final BitSet FOLLOW_crl_rule_in_crl172 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_import_item_in_import_stmt205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_import_item235 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_import_item247 = new BitSet(new long[]{0x0000400000004000L});
    public static final BitSet FOLLOW_46_in_import_item251 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_import_item254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_crl_rule264 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_J_int_literal_in_crl_rule266 = new BitSet(new long[]{0x0010000000004000L});
    public static final BitSet FOLLOW_52_in_crl_rule268 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_crl_rule275 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule277 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_condition_in_crl_rule282 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_crl_rule287 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule289 = new BitSet(new long[]{0xECE4800000000000L,0x000000000000004BL});
    public static final BitSet FOLLOW_action_in_crl_rule293 = new BitSet(new long[]{0xECE6800000000000L,0x000000000000004BL});
    public static final BitSet FOLLOW_49_in_crl_rule298 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_EOL_in_crl_rule300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_condition331 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_condition333 = new BitSet(new long[]{0x0000200000004000L});
    public static final BitSet FOLLOW_45_in_condition336 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_constraint_in_condition338 = new BitSet(new long[]{0x0000080000004000L});
    public static final BitSet FOLLOW_43_in_condition341 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_constraint_in_condition343 = new BitSet(new long[]{0x0000080000004000L});
    public static final BitSet FOLLOW_43_in_condition348 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_assignment_in_condition350 = new BitSet(new long[]{0x0000080000004000L});
    public static final BitSet FOLLOW_EOL_in_condition357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_query386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_j_expr_in_constraint399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_assignment418 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_assignment420 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr__in_assignment422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_j_expr462 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF2L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr_in_j_expr_492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action__in_action511 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOL_in_action513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_mark_in_action_527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_text_in_action_532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_indent_in_action_537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_in_action_542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_merge_in_action_547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_label_in_action_552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_label_in_action_557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_category_in_action_562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_parent_in_action_567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_entry_in_action_572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_action_577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_c_print_in_action_582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_update_in_action_587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_set_mark597 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr_in_set_mark599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_mark601 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_mark603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_set_text623 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr_in_set_text625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_text627 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_text629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_set_indent649 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_J_int_literal_in_set_indent651 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_indent653 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_indent655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_split675 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_split677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_merge695 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_merge699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_merge701 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_merge705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_new_entry727 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_new_entry729 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_new_entry732 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr_in_new_entry734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_set_value757 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr_in_set_value759 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_value761 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_value763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_set_category783 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_category787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_category789 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_category793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_set_parent815 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_parent819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_set_parent821 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_set_parent825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_group847 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_group851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_group853 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_group857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_add_label879 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_add_label883 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_add_label886 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_add_label890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_add_label894 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_add_label898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_new_label924 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_new_label926 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_new_label929 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr_in_new_label931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_update954 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_update956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_c_print975 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_59_in_c_print977 = new BitSet(new long[]{0xFFFFD5FFFFFFBFF0L,0x00000000000001DFL});
    public static final BitSet FOLLOW_j_expr_in_c_print980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier1011 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_identifier1016 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_Identifier_in_identifier1020 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_identifier1027 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_identifier1029 = new BitSet(new long[]{0x0000000000000002L});

}