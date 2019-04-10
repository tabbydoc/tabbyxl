// $ANTLR 3.4 D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g 2019-04-09 23:00:28

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class CrlParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADV_IDENT", "ADV_IDENT1", "ADV_IDENT2", "Action", "Actions", "AddLabelAction", "Assignment", "Breackits", "CATEGORY", "Char_lit", "Condition", "Conditions", "Constraint", "DIGIT", "EOL", "GroupAction", "IDENT", "IDENT1", "IDENT2", "INT", "Identifier", "Import_item", "Imports", "J_expr", "J_int_literal", "LABEL", "LETTER", "MergeAction", "NewEntryAction", "NewLabelAction", "No_condition", "Other_literals", "Package", "PrintAction", "RULES", "STRING", "SetCategoryAction", "SetIndentAction", "SetMarkAction", "SetParentAction", "SetTextAction", "SetValueAction", "SplitAction", "String_lit", "UpdateAction", "WS", "'\"'", "'*'", "','", "'.'", "':'", "';'", "'['", "']'", "'add label'", "'as'", "'category'", "'cell'", "'end'", "'entry'", "'group'", "'import'", "'label'", "'lock-on-active'", "'merge'", "'new entry'", "'new label'", "'no categories'", "'no cells'", "'no entries'", "'no labels'", "'no-loop false'", "'no-loop true'", "'of'", "'package'", "'print'", "'printf'", "'rule #'", "'set category'", "'set indent'", "'set mark'", "'set parent'", "'set text'", "'set value'", "'split'", "'then'", "'to'", "'update'", "'when'", "'with'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "no_query", "j_expr", "crl", "split", "import_stmt", 
    "set_text", "set_value", "set_parent", "advanced_identifier", "index", 
    "merge", "update", "import_unit", "condition", "import_item", "group", 
    "action", "set_mark", "set_category", "crl_rule", "package_stmt", "new_entry", 
    "action_", "assignment", "new_label", "query", "condition_unit", "add_label", 
    "set_indent", "no_condition", "c_print", "constraint", "useless"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public CrlParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public CrlParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public CrlParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


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
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:62:1: crl : ( package_stmt )? ( import_stmt )* ( crl_rule )+ -> ^( Imports ( import_stmt )* ) ^( RULES ( crl_rule )+ ) ;
    public final CrlParser.crl_return crl() throws RecognitionException {
        CrlParser.crl_return retval = new CrlParser.crl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CrlParser.package_stmt_return package_stmt1 =null;

        CrlParser.import_stmt_return import_stmt2 =null;

        CrlParser.crl_rule_return crl_rule3 =null;


        RewriteRuleSubtreeStream stream_crl_rule=new RewriteRuleSubtreeStream(adaptor,"rule crl_rule");
        RewriteRuleSubtreeStream stream_import_stmt=new RewriteRuleSubtreeStream(adaptor,"rule import_stmt");
        RewriteRuleSubtreeStream stream_package_stmt=new RewriteRuleSubtreeStream(adaptor,"rule package_stmt");
        try { dbg.enterRule(getGrammarFileName(), "crl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(62, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:2: ( ( package_stmt )? ( import_stmt )* ( crl_rule )+ -> ^( Imports ( import_stmt )* ) ^( RULES ( crl_rule )+ ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:4: ( package_stmt )? ( import_stmt )* ( crl_rule )+
            {
            dbg.location(63,4);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:4: ( package_stmt )?
            int alt1=2;
            try { dbg.enterSubRule(1);
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            try {
                isCyclicDecision = true;
                alt1 = dfa1.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:4: package_stmt
                    {
                    dbg.location(63,4);
                    pushFollow(FOLLOW_package_stmt_in_crl201);
                    package_stmt1=package_stmt();

                    state._fsp--;

                    stream_package_stmt.add(package_stmt1.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(1);}

            dbg.location(63,18);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:18: ( import_stmt )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==65||LA2_0==78) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:18: import_stmt
            	    {
            	    dbg.location(63,18);
            	    pushFollow(FOLLOW_import_stmt_in_crl204);
            	    import_stmt2=import_stmt();

            	    state._fsp--;

            	    stream_import_stmt.add(import_stmt2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(63,31);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:31: ( crl_rule )+
            int cnt3=0;
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==81) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:31: crl_rule
            	    {
            	    dbg.location(63,31);
            	    pushFollow(FOLLOW_crl_rule_in_crl207);
            	    crl_rule3=crl_rule();

            	    state._fsp--;

            	    stream_crl_rule.add(crl_rule3.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt3++;
            } while (true);
            } finally {dbg.exitSubRule(3);}


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
            // 63:41: -> ^( Imports ( import_stmt )* ) ^( RULES ( crl_rule )+ )
            {
                dbg.location(63,44);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:44: ^( Imports ( import_stmt )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(63,46);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Imports, "Imports")
                , root_1);

                dbg.location(63,54);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:54: ( import_stmt )*
                while ( stream_import_stmt.hasNext() ) {
                    dbg.location(63,54);
                    adaptor.addChild(root_1, stream_import_stmt.nextTree());

                }
                stream_import_stmt.reset();

                adaptor.addChild(root_0, root_1);
                }
                dbg.location(63,68);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:63:68: ^( RULES ( crl_rule )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(63,70);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RULES, "RULES")
                , root_1);

                dbg.location(63,76);
                if ( !(stream_crl_rule.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_crl_rule.hasNext() ) {
                    dbg.location(63,76);
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
        dbg.location(64, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "crl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "crl"


    public static class package_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "package_stmt"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:66:1: package_stmt : 'package' import_item ;
    public final CrlParser.package_stmt_return package_stmt() throws RecognitionException {
        CrlParser.package_stmt_return retval = new CrlParser.package_stmt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal4=null;
        CrlParser.import_item_return import_item5 =null;


        CommonTree string_literal4_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "package_stmt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:67:2: ( 'package' import_item )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:67:4: 'package' import_item
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(67,4);
            string_literal4=(CommonToken)match(input,78,FOLLOW_78_in_package_stmt236); 
            string_literal4_tree = 
            (CommonTree)adaptor.create(string_literal4)
            ;
            adaptor.addChild(root_0, string_literal4_tree);

            dbg.location(67,14);
            pushFollow(FOLLOW_import_item_in_package_stmt238);
            import_item5=import_item();

            state._fsp--;

            adaptor.addChild(root_0, import_item5.getTree());

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
        dbg.location(68, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "package_stmt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "package_stmt"


    public static class import_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_stmt"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:71:1: import_stmt : i= import_unit -> Import_item[$i.value] ;
    public final CrlParser.import_stmt_return import_stmt() throws RecognitionException {
        CrlParser.import_stmt_return retval = new CrlParser.import_stmt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CrlParser.import_unit_return i =null;


        RewriteRuleSubtreeStream stream_import_unit=new RewriteRuleSubtreeStream(adaptor,"rule import_unit");
        try { dbg.enterRule(getGrammarFileName(), "import_stmt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(71, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:72:2: (i= import_unit -> Import_item[$i.value] )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:72:4: i= import_unit
            {
            dbg.location(72,5);
            pushFollow(FOLLOW_import_unit_in_import_stmt254);
            i=import_unit();

            state._fsp--;

            stream_import_unit.add(i.getTree());

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
            // 72:18: -> Import_item[$i.value]
            {
                dbg.location(72,21);
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
        dbg.location(73, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "import_stmt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "import_stmt"


    public static class import_unit_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_unit"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:75:1: import_unit returns [String value] : t= ( 'import' | 'package' ) t1= import_item ( ';' )? EOL ;
    public final CrlParser.import_unit_return import_unit() throws RecognitionException {
        CrlParser.import_unit_return retval = new CrlParser.import_unit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken t=null;
        CommonToken char_literal6=null;
        CommonToken EOL7=null;
        CrlParser.import_item_return t1 =null;


        CommonTree t_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree EOL7_tree=null;

         retval.value =""; 
        try { dbg.enterRule(getGrammarFileName(), "import_unit");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(75, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:78:2: (t= ( 'import' | 'package' ) t1= import_item ( ';' )? EOL )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:78:4: t= ( 'import' | 'package' ) t1= import_item ( ';' )? EOL
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(78,5);
            t=(CommonToken)input.LT(1);

            if ( input.LA(1)==65||input.LA(1)==78 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(t)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(78,27);
             retval.value+=(t!=null?t.getText():null)+" "; 
            dbg.location(78,54);
            pushFollow(FOLLOW_import_item_in_import_unit296);
            t1=import_item();

            state._fsp--;

            adaptor.addChild(root_0, t1.getTree());
            dbg.location(78,67);
             retval.value+=(t1!=null?t1.value:null); 
            dbg.location(78,90);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:78:90: ( ';' )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==55) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:78:90: ';'
                    {
                    dbg.location(78,90);
                    char_literal6=(CommonToken)match(input,55,FOLLOW_55_in_import_unit300); 
                    char_literal6_tree = 
                    (CommonTree)adaptor.create(char_literal6)
                    ;
                    adaptor.addChild(root_0, char_literal6_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}

            dbg.location(78,95);
            EOL7=(CommonToken)match(input,EOL,FOLLOW_EOL_in_import_unit303); 
            EOL7_tree = 
            (CommonTree)adaptor.create(EOL7)
            ;
            adaptor.addChild(root_0, EOL7_tree);


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
        dbg.location(79, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "import_unit");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "import_unit"


    public static class import_item_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_item"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:81:1: import_item returns [String value] : i1= Identifier ( '.' i2= Identifier )* ( '.' '*' )? ;
    public final CrlParser.import_item_return import_item() throws RecognitionException {
        CrlParser.import_item_return retval = new CrlParser.import_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken i1=null;
        CommonToken i2=null;
        CommonToken char_literal8=null;
        CommonToken char_literal9=null;
        CommonToken char_literal10=null;

        CommonTree i1_tree=null;
        CommonTree i2_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree char_literal9_tree=null;
        CommonTree char_literal10_tree=null;

         retval.value =""; 
        try { dbg.enterRule(getGrammarFileName(), "import_item");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(81, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:83:2: (i1= Identifier ( '.' i2= Identifier )* ( '.' '*' )? )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:83:5: i1= Identifier ( '.' i2= Identifier )* ( '.' '*' )?
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(83,7);
            i1=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_import_item327); 
            i1_tree = 
            (CommonTree)adaptor.create(i1)
            ;
            adaptor.addChild(root_0, i1_tree);

            dbg.location(83,19);
             retval.value+=(i1!=null?i1.getText():null); 
            dbg.location(83,41);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:83:41: ( '.' i2= Identifier )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==53) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==Identifier) ) {
                        alt5=1;
                    }


                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:83:42: '.' i2= Identifier
            	    {
            	    dbg.location(83,42);
            	    char_literal8=(CommonToken)match(input,53,FOLLOW_53_in_import_item332); 
            	    char_literal8_tree = 
            	    (CommonTree)adaptor.create(char_literal8)
            	    ;
            	    adaptor.addChild(root_0, char_literal8_tree);

            	    dbg.location(83,48);
            	    i2=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_import_item336); 
            	    i2_tree = 
            	    (CommonTree)adaptor.create(i2)
            	    ;
            	    adaptor.addChild(root_0, i2_tree);

            	    dbg.location(83,60);
            	     retval.value+="."+(i2!=null?i2.getText():null); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}

            dbg.location(83,88);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:83:88: ( '.' '*' )?
            int alt6=2;
            try { dbg.enterSubRule(6);
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==53) ) {
                alt6=1;
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:83:89: '.' '*'
                    {
                    dbg.location(83,89);
                    char_literal9=(CommonToken)match(input,53,FOLLOW_53_in_import_item343); 
                    char_literal9_tree = 
                    (CommonTree)adaptor.create(char_literal9)
                    ;
                    adaptor.addChild(root_0, char_literal9_tree);

                    dbg.location(83,93);
                    char_literal10=(CommonToken)match(input,51,FOLLOW_51_in_import_item345); 
                    char_literal10_tree = 
                    (CommonTree)adaptor.create(char_literal10)
                    ;
                    adaptor.addChild(root_0, char_literal10_tree);

                    dbg.location(83,97);
                     retval.value+=".*"; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(6);}


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
        dbg.location(84, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "import_item");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "import_item"


    public static class crl_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "crl_rule"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:86:1: crl_rule : 'rule #' J_int_literal ( useless )? EOL 'when' EOL ( condition_unit )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) ) ;
    public final CrlParser.crl_rule_return crl_rule() throws RecognitionException {
        CrlParser.crl_rule_return retval = new CrlParser.crl_rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal11=null;
        CommonToken J_int_literal12=null;
        CommonToken EOL14=null;
        CommonToken string_literal15=null;
        CommonToken EOL16=null;
        CommonToken string_literal18=null;
        CommonToken EOL19=null;
        CommonToken string_literal21=null;
        CommonToken EOL22=null;
        CrlParser.useless_return useless13 =null;

        CrlParser.condition_unit_return condition_unit17 =null;

        CrlParser.action_return action20 =null;


        CommonTree string_literal11_tree=null;
        CommonTree J_int_literal12_tree=null;
        CommonTree EOL14_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree EOL16_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree EOL19_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree EOL22_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_useless=new RewriteRuleSubtreeStream(adaptor,"rule useless");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        RewriteRuleSubtreeStream stream_condition_unit=new RewriteRuleSubtreeStream(adaptor,"rule condition_unit");
        try { dbg.enterRule(getGrammarFileName(), "crl_rule");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(86, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:2: ( 'rule #' J_int_literal ( useless )? EOL 'when' EOL ( condition_unit )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:4: 'rule #' J_int_literal ( useless )? EOL 'when' EOL ( condition_unit )+ 'then' EOL ( action )+ 'end' ( EOL )?
            {
            dbg.location(87,4);
            string_literal11=(CommonToken)match(input,81,FOLLOW_81_in_crl_rule362);  
            stream_81.add(string_literal11);

            dbg.location(87,13);
            J_int_literal12=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_crl_rule364);  
            stream_J_int_literal.add(J_int_literal12);

            dbg.location(87,27);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:27: ( useless )?
            int alt7=2;
            try { dbg.enterSubRule(7);
            try { dbg.enterDecision(7, decisionCanBacktrack[7]);

            int LA7_0 = input.LA(1);

            if ( (LA7_0==67||(LA7_0 >= 75 && LA7_0 <= 76)) ) {
                alt7=1;
            }
            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:87:27: useless
                    {
                    dbg.location(87,27);
                    pushFollow(FOLLOW_useless_in_crl_rule366);
                    useless13=useless();

                    state._fsp--;

                    stream_useless.add(useless13.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(7);}

            dbg.location(87,36);
            EOL14=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule369);  
            stream_EOL.add(EOL14);

            dbg.location(88,3);
            string_literal15=(CommonToken)match(input,92,FOLLOW_92_in_crl_rule373);  
            stream_92.add(string_literal15);

            dbg.location(88,10);
            EOL16=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule375);  
            stream_EOL.add(EOL16);

            dbg.location(89,3);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:89:3: ( condition_unit )+
            int cnt8=0;
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 60 && LA8_0 <= 61)||LA8_0==63||LA8_0==66||(LA8_0 >= 71 && LA8_0 <= 74)) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:89:3: condition_unit
            	    {
            	    dbg.location(89,3);
            	    pushFollow(FOLLOW_condition_unit_in_crl_rule380);
            	    condition_unit17=condition_unit();

            	    state._fsp--;

            	    stream_condition_unit.add(condition_unit17.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt8++;
            } while (true);
            } finally {dbg.exitSubRule(8);}

            dbg.location(90,3);
            string_literal18=(CommonToken)match(input,89,FOLLOW_89_in_crl_rule385);  
            stream_89.add(string_literal18);

            dbg.location(90,10);
            EOL19=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule387);  
            stream_EOL.add(EOL19);

            dbg.location(91,3);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:91:3: ( action )+
            int cnt9=0;
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==58||LA9_0==64||(LA9_0 >= 68 && LA9_0 <= 70)||(LA9_0 >= 79 && LA9_0 <= 80)||(LA9_0 >= 82 && LA9_0 <= 88)||LA9_0==91) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:91:3: action
            	    {
            	    dbg.location(91,3);
            	    pushFollow(FOLLOW_action_in_crl_rule391);
            	    action20=action();

            	    state._fsp--;

            	    stream_action.add(action20.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt9++;
            } while (true);
            } finally {dbg.exitSubRule(9);}

            dbg.location(92,3);
            string_literal21=(CommonToken)match(input,62,FOLLOW_62_in_crl_rule396);  
            stream_62.add(string_literal21);

            dbg.location(92,9);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:92:9: ( EOL )?
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==EOL) ) {
                alt10=1;
            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:92:9: EOL
                    {
                    dbg.location(92,9);
                    EOL22=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule398);  
                    stream_EOL.add(EOL22);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}


            // AST REWRITE
            // elements: J_int_literal, action, condition_unit
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 92:14: -> ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) )
            {
                dbg.location(92,17);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:92:17: ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(92,19);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_J_int_literal.nextNode()
                , root_1);

                dbg.location(92,33);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:92:33: ^( Conditions ( condition_unit )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(92,35);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Conditions, "Conditions")
                , root_2);

                dbg.location(92,46);
                if ( !(stream_condition_unit.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_condition_unit.hasNext() ) {
                    dbg.location(92,46);
                    adaptor.addChild(root_2, stream_condition_unit.nextTree());

                }
                stream_condition_unit.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(92,63);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:92:63: ^( Actions ( action )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(92,65);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Actions, "Actions")
                , root_2);

                dbg.location(92,73);
                if ( !(stream_action.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_action.hasNext() ) {
                    dbg.location(92,73);
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
        dbg.location(93, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "crl_rule");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "crl_rule"


    public static class condition_unit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition_unit"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:95:1: condition_unit : ( condition | no_condition );
    public final CrlParser.condition_unit_return condition_unit() throws RecognitionException {
        CrlParser.condition_unit_return retval = new CrlParser.condition_unit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CrlParser.condition_return condition23 =null;

        CrlParser.no_condition_return no_condition24 =null;



        try { dbg.enterRule(getGrammarFileName(), "condition_unit");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(95, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:96:2: ( condition | no_condition )
            int alt11=2;
            try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            int LA11_0 = input.LA(1);

            if ( ((LA11_0 >= 60 && LA11_0 <= 61)||LA11_0==63||LA11_0==66) ) {
                alt11=1;
            }
            else if ( ((LA11_0 >= 71 && LA11_0 <= 74)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:96:4: condition
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(96,4);
                    pushFollow(FOLLOW_condition_in_condition_unit430);
                    condition23=condition();

                    state._fsp--;

                    adaptor.addChild(root_0, condition23.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:96:14: no_condition
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(96,14);
                    pushFollow(FOLLOW_no_condition_in_condition_unit432);
                    no_condition24=no_condition();

                    state._fsp--;

                    adaptor.addChild(root_0, no_condition24.getTree());

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
        dbg.location(97, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "condition_unit");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "condition_unit"


    public static class condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:99:1: condition : query Identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query Identifier ( constraint )* ( assignment )* ) ;
    public final CrlParser.condition_return condition() throws RecognitionException {
        CrlParser.condition_return retval = new CrlParser.condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken Identifier26=null;
        CommonToken char_literal27=null;
        CommonToken char_literal29=null;
        CommonToken char_literal31=null;
        CommonToken EOL33=null;
        CrlParser.query_return query25 =null;

        CrlParser.constraint_return constraint28 =null;

        CrlParser.constraint_return constraint30 =null;

        CrlParser.assignment_return assignment32 =null;


        CommonTree Identifier26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree EOL33_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_query=new RewriteRuleSubtreeStream(adaptor,"rule query");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
        try { dbg.enterRule(getGrammarFileName(), "condition");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(99, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:2: ( query Identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query Identifier ( constraint )* ( assignment )* ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:4: query Identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL
            {
            dbg.location(100,4);
            pushFollow(FOLLOW_query_in_condition443);
            query25=query();

            state._fsp--;

            stream_query.add(query25.getTree());
            dbg.location(100,10);
            Identifier26=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_condition445);  
            stream_Identifier.add(Identifier26);

            dbg.location(100,21);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:21: ( ':' constraint ( ',' constraint )* ( ',' assignment )* )?
            int alt14=2;
            try { dbg.enterSubRule(14);
            try { dbg.enterDecision(14, decisionCanBacktrack[14]);

            int LA14_0 = input.LA(1);

            if ( (LA14_0==54) ) {
                alt14=1;
            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:22: ':' constraint ( ',' constraint )* ( ',' assignment )*
                    {
                    dbg.location(100,22);
                    char_literal27=(CommonToken)match(input,54,FOLLOW_54_in_condition448);  
                    stream_54.add(char_literal27);

                    dbg.location(100,26);
                    pushFollow(FOLLOW_constraint_in_condition450);
                    constraint28=constraint();

                    state._fsp--;

                    stream_constraint.add(constraint28.getTree());
                    dbg.location(100,37);
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:37: ( ',' constraint )*
                    try { dbg.enterSubRule(12);

                    loop12:
                    do {
                        int alt12=2;
                        try { dbg.enterDecision(12, decisionCanBacktrack[12]);

                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==52) ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1==Identifier) ) {
                                int LA12_3 = input.LA(3);

                                if ( ((LA12_3 >= ADV_IDENT && LA12_3 <= WS)||(LA12_3 >= 51 && LA12_3 <= 53)||(LA12_3 >= 55 && LA12_3 <= 76)||(LA12_3 >= 78 && LA12_3 <= 89)||(LA12_3 >= 91 && LA12_3 <= 93)) ) {
                                    alt12=1;
                                }


                            }
                            else if ( ((LA12_1 >= ADV_IDENT && LA12_1 <= DIGIT)||(LA12_1 >= GroupAction && LA12_1 <= INT)||(LA12_1 >= Import_item && LA12_1 <= WS)||LA12_1==51||LA12_1==53||(LA12_1 >= 55 && LA12_1 <= 76)||(LA12_1 >= 78 && LA12_1 <= 89)||(LA12_1 >= 91 && LA12_1 <= 93)) ) {
                                alt12=1;
                            }


                        }


                        } finally {dbg.exitDecision(12);}

                        switch (alt12) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:38: ',' constraint
                    	    {
                    	    dbg.location(100,38);
                    	    char_literal29=(CommonToken)match(input,52,FOLLOW_52_in_condition453);  
                    	    stream_52.add(char_literal29);

                    	    dbg.location(100,42);
                    	    pushFollow(FOLLOW_constraint_in_condition455);
                    	    constraint30=constraint();

                    	    state._fsp--;

                    	    stream_constraint.add(constraint30.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(12);}

                    dbg.location(100,55);
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:55: ( ',' assignment )*
                    try { dbg.enterSubRule(13);

                    loop13:
                    do {
                        int alt13=2;
                        try { dbg.enterDecision(13, decisionCanBacktrack[13]);

                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==52) ) {
                            alt13=1;
                        }


                        } finally {dbg.exitDecision(13);}

                        switch (alt13) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:100:56: ',' assignment
                    	    {
                    	    dbg.location(100,56);
                    	    char_literal31=(CommonToken)match(input,52,FOLLOW_52_in_condition460);  
                    	    stream_52.add(char_literal31);

                    	    dbg.location(100,60);
                    	    pushFollow(FOLLOW_assignment_in_condition462);
                    	    assignment32=assignment();

                    	    state._fsp--;

                    	    stream_assignment.add(assignment32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(13);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(14);}

            dbg.location(100,76);
            EOL33=(CommonToken)match(input,EOL,FOLLOW_EOL_in_condition469);  
            stream_EOL.add(EOL33);


            // AST REWRITE
            // elements: query, constraint, Identifier, assignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 101:3: -> ^( Condition query Identifier ( constraint )* ( assignment )* )
            {
                dbg.location(101,6);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:101:6: ^( Condition query Identifier ( constraint )* ( assignment )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(101,8);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Condition, "Condition")
                , root_1);

                dbg.location(101,18);
                adaptor.addChild(root_1, stream_query.nextTree());
                dbg.location(101,24);
                adaptor.addChild(root_1, 
                stream_Identifier.nextNode()
                );
                dbg.location(101,35);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:101:35: ( constraint )*
                while ( stream_constraint.hasNext() ) {
                    dbg.location(101,35);
                    adaptor.addChild(root_1, stream_constraint.nextTree());

                }
                stream_constraint.reset();
                dbg.location(101,47);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:101:47: ( assignment )*
                while ( stream_assignment.hasNext() ) {
                    dbg.location(101,47);
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
        dbg.location(102, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "condition");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "condition"


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:104:1: query : ( 'cell' | 'entry' | 'label' | 'category' );
    public final CrlParser.query_return query() throws RecognitionException {
        CrlParser.query_return retval = new CrlParser.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set34=null;

        CommonTree set34_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "query");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(104, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:105:2: ( 'cell' | 'entry' | 'label' | 'category' )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(105,2);
            set34=(CommonToken)input.LT(1);

            if ( (input.LA(1) >= 60 && input.LA(1) <= 61)||input.LA(1)==63||input.LA(1)==66 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set34)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


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
        dbg.location(106, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "query");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "query"


    public static class no_condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "no_condition"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:108:1: no_condition : no_query ( ':' constraint ( ',' constraint )* )? EOL -> ^( No_condition no_query ( constraint )* ) ;
    public final CrlParser.no_condition_return no_condition() throws RecognitionException {
        CrlParser.no_condition_return retval = new CrlParser.no_condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken char_literal36=null;
        CommonToken char_literal38=null;
        CommonToken EOL40=null;
        CrlParser.no_query_return no_query35 =null;

        CrlParser.constraint_return constraint37 =null;

        CrlParser.constraint_return constraint39 =null;


        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree EOL40_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_no_query=new RewriteRuleSubtreeStream(adaptor,"rule no_query");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
        try { dbg.enterRule(getGrammarFileName(), "no_condition");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(108, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:2: ( no_query ( ':' constraint ( ',' constraint )* )? EOL -> ^( No_condition no_query ( constraint )* ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:4: no_query ( ':' constraint ( ',' constraint )* )? EOL
            {
            dbg.location(109,4);
            pushFollow(FOLLOW_no_query_in_no_condition518);
            no_query35=no_query();

            state._fsp--;

            stream_no_query.add(no_query35.getTree());
            dbg.location(109,13);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:13: ( ':' constraint ( ',' constraint )* )?
            int alt16=2;
            try { dbg.enterSubRule(16);
            try { dbg.enterDecision(16, decisionCanBacktrack[16]);

            int LA16_0 = input.LA(1);

            if ( (LA16_0==54) ) {
                alt16=1;
            }
            } finally {dbg.exitDecision(16);}

            switch (alt16) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:14: ':' constraint ( ',' constraint )*
                    {
                    dbg.location(109,14);
                    char_literal36=(CommonToken)match(input,54,FOLLOW_54_in_no_condition521);  
                    stream_54.add(char_literal36);

                    dbg.location(109,18);
                    pushFollow(FOLLOW_constraint_in_no_condition523);
                    constraint37=constraint();

                    state._fsp--;

                    stream_constraint.add(constraint37.getTree());
                    dbg.location(109,29);
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:29: ( ',' constraint )*
                    try { dbg.enterSubRule(15);

                    loop15:
                    do {
                        int alt15=2;
                        try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==52) ) {
                            alt15=1;
                        }


                        } finally {dbg.exitDecision(15);}

                        switch (alt15) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:30: ',' constraint
                    	    {
                    	    dbg.location(109,30);
                    	    char_literal38=(CommonToken)match(input,52,FOLLOW_52_in_no_condition526);  
                    	    stream_52.add(char_literal38);

                    	    dbg.location(109,34);
                    	    pushFollow(FOLLOW_constraint_in_no_condition528);
                    	    constraint39=constraint();

                    	    state._fsp--;

                    	    stream_constraint.add(constraint39.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(15);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(16);}

            dbg.location(109,50);
            EOL40=(CommonToken)match(input,EOL,FOLLOW_EOL_in_no_condition535);  
            stream_EOL.add(EOL40);


            // AST REWRITE
            // elements: constraint, no_query
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 109:54: -> ^( No_condition no_query ( constraint )* )
            {
                dbg.location(109,57);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:57: ^( No_condition no_query ( constraint )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(109,59);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(No_condition, "No_condition")
                , root_1);

                dbg.location(109,72);
                adaptor.addChild(root_1, stream_no_query.nextTree());
                dbg.location(109,81);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:109:81: ( constraint )*
                while ( stream_constraint.hasNext() ) {
                    dbg.location(109,81);
                    adaptor.addChild(root_1, stream_constraint.nextTree());

                }
                stream_constraint.reset();

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
        dbg.location(110, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "no_condition");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "no_condition"


    public static class no_query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "no_query"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:112:1: no_query : ( 'no cells' | 'no labels' | 'no entries' | 'no categories' );
    public final CrlParser.no_query_return no_query() throws RecognitionException {
        CrlParser.no_query_return retval = new CrlParser.no_query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set41=null;

        CommonTree set41_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "no_query");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(112, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:113:2: ( 'no cells' | 'no labels' | 'no entries' | 'no categories' )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(113,2);
            set41=(CommonToken)input.LT(1);

            if ( (input.LA(1) >= 71 && input.LA(1) <= 74) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set41)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


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
        dbg.location(114, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "no_query");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "no_query"


    public static class constraint_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constraint"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:116:1: constraint : j_expr -> ^( Constraint j_expr ) ;
    public final CrlParser.constraint_return constraint() throws RecognitionException {
        CrlParser.constraint_return retval = new CrlParser.constraint_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CrlParser.j_expr_return j_expr42 =null;


        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "constraint");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(116, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:117:2: ( j_expr -> ^( Constraint j_expr ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:117:4: j_expr
            {
            dbg.location(117,4);
            pushFollow(FOLLOW_j_expr_in_constraint576);
            j_expr42=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr42.getTree());

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
            // 117:11: -> ^( Constraint j_expr )
            {
                dbg.location(117,14);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:117:14: ^( Constraint j_expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(117,16);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Constraint, "Constraint")
                , root_1);

                dbg.location(117,27);
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
        dbg.location(118, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "constraint");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "constraint"


    public static class assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignment"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:120:1: assignment : Identifier ':' j_expr -> ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) ) ;
    public final CrlParser.assignment_return assignment() throws RecognitionException {
        CrlParser.assignment_return retval = new CrlParser.assignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken Identifier43=null;
        CommonToken char_literal44=null;
        CrlParser.j_expr_return j_expr45 =null;


        CommonTree Identifier43_tree=null;
        CommonTree char_literal44_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(120, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:121:2: ( Identifier ':' j_expr -> ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:121:4: Identifier ':' j_expr
            {
            dbg.location(121,4);
            Identifier43=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_assignment596);  
            stream_Identifier.add(Identifier43);

            dbg.location(121,15);
            char_literal44=(CommonToken)match(input,54,FOLLOW_54_in_assignment598);  
            stream_54.add(char_literal44);

            dbg.location(121,19);
            pushFollow(FOLLOW_j_expr_in_assignment600);
            j_expr45=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr45.getTree());

            // AST REWRITE
            // elements: j_expr, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 121:26: -> ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) )
            {
                dbg.location(121,29);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:121:29: ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(121,31);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Assignment, "Assignment")
                , root_1);

                dbg.location(121,42);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:121:42: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(121,44);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                dbg.location(121,50);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(121,62);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:121:62: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(121,64);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

                dbg.location(121,71);
                adaptor.addChild(root_2, stream_j_expr.nextTree());

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
        dbg.location(122, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:124:1: j_expr returns [String value] : (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+ ;
    public final CrlParser.j_expr_return j_expr() throws RecognitionException {
        CrlParser.j_expr_return retval = new CrlParser.j_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken i=null;

        CommonTree i_tree=null;

         retval.value =""; 
        try { dbg.enterRule(getGrammarFileName(), "j_expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(124, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:126:2: ( (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+ )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:126:5: (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(126,5);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:126:5: (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+
            int cnt17=0;
            try { dbg.enterSubRule(17);

            loop17:
            do {
                int alt17=2;
                try { dbg.enterDecision(17, decisionCanBacktrack[17]);

                int LA17_0 = input.LA(1);

                if ( ((LA17_0 >= ADV_IDENT && LA17_0 <= DIGIT)||(LA17_0 >= GroupAction && LA17_0 <= WS)||LA17_0==51||LA17_0==53||(LA17_0 >= 55 && LA17_0 <= 76)||(LA17_0 >= 78 && LA17_0 <= 89)||(LA17_0 >= 91 && LA17_0 <= 93)) ) {
                    alt17=1;
                }


                } finally {dbg.exitDecision(17);}

                switch (alt17) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:126:7: i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL )
            	    {
            	    dbg.location(126,8);
            	    i=(CommonToken)input.LT(1);

            	    if ( (input.LA(1) >= ADV_IDENT && input.LA(1) <= DIGIT)||(input.LA(1) >= GroupAction && input.LA(1) <= WS)||input.LA(1)==51||input.LA(1)==53||(input.LA(1) >= 55 && input.LA(1) <= 76)||(input.LA(1) >= 78 && input.LA(1) <= 89)||(input.LA(1) >= 91 && input.LA(1) <= 93) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (CommonTree)adaptor.create(i)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(126,39);
            	     retval.value+=(i!=null?i.getText():null); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt17++;
            } while (true);
            } finally {dbg.exitSubRule(17);}


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
        dbg.location(127, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "j_expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "j_expr"


    public static class action_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:129:1: action : action_ EOL -> action_ ;
    public final CrlParser.action_return action() throws RecognitionException {
        CrlParser.action_return retval = new CrlParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken EOL47=null;
        CrlParser.action__return action_46 =null;


        CommonTree EOL47_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleSubtreeStream stream_action_=new RewriteRuleSubtreeStream(adaptor,"rule action_");
        try { dbg.enterRule(getGrammarFileName(), "action");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(129, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:130:2: ( action_ EOL -> action_ )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:130:4: action_ EOL
            {
            dbg.location(130,4);
            pushFollow(FOLLOW_action__in_action673);
            action_46=action_();

            state._fsp--;

            stream_action_.add(action_46.getTree());
            dbg.location(130,12);
            EOL47=(CommonToken)match(input,EOL,FOLLOW_EOL_in_action675);  
            stream_EOL.add(EOL47);


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
            // 130:16: -> action_
            {
                dbg.location(130,19);
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
        dbg.location(131, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "action");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "action"


    public static class action__return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action_"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:133:1: action_ : ( set_mark | set_text | set_indent | set_value | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update );
    public final CrlParser.action__return action_() throws RecognitionException {
        CrlParser.action__return retval = new CrlParser.action__return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CrlParser.set_mark_return set_mark48 =null;

        CrlParser.set_text_return set_text49 =null;

        CrlParser.set_indent_return set_indent50 =null;

        CrlParser.set_value_return set_value51 =null;

        CrlParser.split_return split52 =null;

        CrlParser.merge_return merge53 =null;

        CrlParser.new_label_return new_label54 =null;

        CrlParser.add_label_return add_label55 =null;

        CrlParser.set_category_return set_category56 =null;

        CrlParser.set_parent_return set_parent57 =null;

        CrlParser.new_entry_return new_entry58 =null;

        CrlParser.group_return group59 =null;

        CrlParser.c_print_return c_print60 =null;

        CrlParser.update_return update61 =null;



        try { dbg.enterRule(getGrammarFileName(), "action_");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(133, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:134:2: ( set_mark | set_text | set_indent | set_value | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update )
            int alt18=14;
            try { dbg.enterDecision(18, decisionCanBacktrack[18]);

            switch ( input.LA(1) ) {
            case 84:
                {
                alt18=1;
                }
                break;
            case 86:
                {
                alt18=2;
                }
                break;
            case 83:
                {
                alt18=3;
                }
                break;
            case 87:
                {
                alt18=4;
                }
                break;
            case 88:
                {
                alt18=5;
                }
                break;
            case 68:
                {
                alt18=6;
                }
                break;
            case 70:
                {
                alt18=7;
                }
                break;
            case 58:
                {
                alt18=8;
                }
                break;
            case 82:
                {
                alt18=9;
                }
                break;
            case 85:
                {
                alt18=10;
                }
                break;
            case 69:
                {
                alt18=11;
                }
                break;
            case 64:
                {
                alt18=12;
                }
                break;
            case 79:
            case 80:
                {
                alt18=13;
                }
                break;
            case 91:
                {
                alt18=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(18);}

            switch (alt18) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:134:4: set_mark
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(134,4);
                    pushFollow(FOLLOW_set_mark_in_action_691);
                    set_mark48=set_mark();

                    state._fsp--;

                    adaptor.addChild(root_0, set_mark48.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:135:4: set_text
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(135,4);
                    pushFollow(FOLLOW_set_text_in_action_696);
                    set_text49=set_text();

                    state._fsp--;

                    adaptor.addChild(root_0, set_text49.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:136:4: set_indent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(136,4);
                    pushFollow(FOLLOW_set_indent_in_action_701);
                    set_indent50=set_indent();

                    state._fsp--;

                    adaptor.addChild(root_0, set_indent50.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:137:4: set_value
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(137,4);
                    pushFollow(FOLLOW_set_value_in_action_706);
                    set_value51=set_value();

                    state._fsp--;

                    adaptor.addChild(root_0, set_value51.getTree());

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:138:4: split
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(138,4);
                    pushFollow(FOLLOW_split_in_action_711);
                    split52=split();

                    state._fsp--;

                    adaptor.addChild(root_0, split52.getTree());

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:139:4: merge
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(139,4);
                    pushFollow(FOLLOW_merge_in_action_716);
                    merge53=merge();

                    state._fsp--;

                    adaptor.addChild(root_0, merge53.getTree());

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:140:4: new_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(140,4);
                    pushFollow(FOLLOW_new_label_in_action_721);
                    new_label54=new_label();

                    state._fsp--;

                    adaptor.addChild(root_0, new_label54.getTree());

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:141:4: add_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(141,4);
                    pushFollow(FOLLOW_add_label_in_action_726);
                    add_label55=add_label();

                    state._fsp--;

                    adaptor.addChild(root_0, add_label55.getTree());

                    }
                    break;
                case 9 :
                    dbg.enterAlt(9);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:142:4: set_category
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(142,4);
                    pushFollow(FOLLOW_set_category_in_action_731);
                    set_category56=set_category();

                    state._fsp--;

                    adaptor.addChild(root_0, set_category56.getTree());

                    }
                    break;
                case 10 :
                    dbg.enterAlt(10);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:143:4: set_parent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(143,4);
                    pushFollow(FOLLOW_set_parent_in_action_736);
                    set_parent57=set_parent();

                    state._fsp--;

                    adaptor.addChild(root_0, set_parent57.getTree());

                    }
                    break;
                case 11 :
                    dbg.enterAlt(11);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:144:4: new_entry
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(144,4);
                    pushFollow(FOLLOW_new_entry_in_action_741);
                    new_entry58=new_entry();

                    state._fsp--;

                    adaptor.addChild(root_0, new_entry58.getTree());

                    }
                    break;
                case 12 :
                    dbg.enterAlt(12);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:145:4: group
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(145,4);
                    pushFollow(FOLLOW_group_in_action_746);
                    group59=group();

                    state._fsp--;

                    adaptor.addChild(root_0, group59.getTree());

                    }
                    break;
                case 13 :
                    dbg.enterAlt(13);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:146:4: c_print
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(146,4);
                    pushFollow(FOLLOW_c_print_in_action_751);
                    c_print60=c_print();

                    state._fsp--;

                    adaptor.addChild(root_0, c_print60.getTree());

                    }
                    break;
                case 14 :
                    dbg.enterAlt(14);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:147:4: update
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(147,4);
                    pushFollow(FOLLOW_update_in_action_756);
                    update61=update();

                    state._fsp--;

                    adaptor.addChild(root_0, update61.getTree());

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
        dbg.location(148, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "action_");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "action_"


    public static class set_mark_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_mark"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:150:1: set_mark : 'set mark' j_expr 'to' Identifier -> ^( 'set mark' ^( IDENT Identifier ) ^( STRING j_expr ) ) ;
    public final CrlParser.set_mark_return set_mark() throws RecognitionException {
        CrlParser.set_mark_return retval = new CrlParser.set_mark_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal62=null;
        CommonToken string_literal64=null;
        CommonToken Identifier65=null;
        CrlParser.j_expr_return j_expr63 =null;


        CommonTree string_literal62_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree Identifier65_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "set_mark");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(150, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:151:2: ( 'set mark' j_expr 'to' Identifier -> ^( 'set mark' ^( IDENT Identifier ) ^( STRING j_expr ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:151:4: 'set mark' j_expr 'to' Identifier
            {
            dbg.location(151,4);
            string_literal62=(CommonToken)match(input,84,FOLLOW_84_in_set_mark768);  
            stream_84.add(string_literal62);

            dbg.location(151,15);
            pushFollow(FOLLOW_j_expr_in_set_mark770);
            j_expr63=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr63.getTree());
            dbg.location(151,22);
            string_literal64=(CommonToken)match(input,90,FOLLOW_90_in_set_mark772);  
            stream_90.add(string_literal64);

            dbg.location(151,27);
            Identifier65=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_set_mark774);  
            stream_Identifier.add(Identifier65);


            // AST REWRITE
            // elements: j_expr, Identifier, 84
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 151:38: -> ^( 'set mark' ^( IDENT Identifier ) ^( STRING j_expr ) )
            {
                dbg.location(151,41);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:151:41: ^( 'set mark' ^( IDENT Identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(151,43);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_84.nextNode()
                , root_1);

                dbg.location(151,54);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:151:54: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(151,56);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                dbg.location(151,62);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(151,74);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:151:74: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(151,76);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

                dbg.location(151,83);
                adaptor.addChild(root_2, stream_j_expr.nextTree());

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
        dbg.location(152, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "set_mark");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "set_mark"


    public static class set_text_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_text"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:154:1: set_text : 'set text' j_expr 'to' Identifier -> ^( 'set text' ^( IDENT Identifier ) ^( STRING j_expr ) ) ;
    public final CrlParser.set_text_return set_text() throws RecognitionException {
        CrlParser.set_text_return retval = new CrlParser.set_text_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal66=null;
        CommonToken string_literal68=null;
        CommonToken Identifier69=null;
        CrlParser.j_expr_return j_expr67 =null;


        CommonTree string_literal66_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree Identifier69_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "set_text");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(154, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:155:2: ( 'set text' j_expr 'to' Identifier -> ^( 'set text' ^( IDENT Identifier ) ^( STRING j_expr ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:155:4: 'set text' j_expr 'to' Identifier
            {
            dbg.location(155,4);
            string_literal66=(CommonToken)match(input,86,FOLLOW_86_in_set_text804);  
            stream_86.add(string_literal66);

            dbg.location(155,15);
            pushFollow(FOLLOW_j_expr_in_set_text806);
            j_expr67=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr67.getTree());
            dbg.location(155,22);
            string_literal68=(CommonToken)match(input,90,FOLLOW_90_in_set_text808);  
            stream_90.add(string_literal68);

            dbg.location(155,27);
            Identifier69=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_set_text810);  
            stream_Identifier.add(Identifier69);


            // AST REWRITE
            // elements: 86, Identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 155:38: -> ^( 'set text' ^( IDENT Identifier ) ^( STRING j_expr ) )
            {
                dbg.location(155,41);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:155:41: ^( 'set text' ^( IDENT Identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(155,43);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_86.nextNode()
                , root_1);

                dbg.location(155,54);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:155:54: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(155,56);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                dbg.location(155,62);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(155,74);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:155:74: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(155,76);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

                dbg.location(155,83);
                adaptor.addChild(root_2, stream_j_expr.nextTree());

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
        dbg.location(156, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "set_text");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "set_text"


    public static class set_indent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_indent"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:158:1: set_indent : 'set indent' J_int_literal 'to' Identifier -> ^( 'set indent' ^( IDENT Identifier ) ^( INT J_int_literal ) ) ;
    public final CrlParser.set_indent_return set_indent() throws RecognitionException {
        CrlParser.set_indent_return retval = new CrlParser.set_indent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal70=null;
        CommonToken J_int_literal71=null;
        CommonToken string_literal72=null;
        CommonToken Identifier73=null;

        CommonTree string_literal70_tree=null;
        CommonTree J_int_literal71_tree=null;
        CommonTree string_literal72_tree=null;
        CommonTree Identifier73_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");

        try { dbg.enterRule(getGrammarFileName(), "set_indent");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(158, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:159:2: ( 'set indent' J_int_literal 'to' Identifier -> ^( 'set indent' ^( IDENT Identifier ) ^( INT J_int_literal ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:159:4: 'set indent' J_int_literal 'to' Identifier
            {
            dbg.location(159,4);
            string_literal70=(CommonToken)match(input,83,FOLLOW_83_in_set_indent840);  
            stream_83.add(string_literal70);

            dbg.location(159,17);
            J_int_literal71=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_set_indent842);  
            stream_J_int_literal.add(J_int_literal71);

            dbg.location(159,31);
            string_literal72=(CommonToken)match(input,90,FOLLOW_90_in_set_indent844);  
            stream_90.add(string_literal72);

            dbg.location(159,36);
            Identifier73=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_set_indent846);  
            stream_Identifier.add(Identifier73);


            // AST REWRITE
            // elements: J_int_literal, 83, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 159:47: -> ^( 'set indent' ^( IDENT Identifier ) ^( INT J_int_literal ) )
            {
                dbg.location(159,50);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:159:50: ^( 'set indent' ^( IDENT Identifier ) ^( INT J_int_literal ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(159,52);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_83.nextNode()
                , root_1);

                dbg.location(159,65);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:159:65: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(159,67);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                dbg.location(159,73);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(159,85);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:159:85: ^( INT J_int_literal )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(159,87);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(INT, "INT")
                , root_2);

                dbg.location(159,91);
                adaptor.addChild(root_2, 
                stream_J_int_literal.nextNode()
                );

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
        dbg.location(160, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "set_indent");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "set_indent"


    public static class split_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:162:1: split : 'split' Identifier -> ^( 'split' ^( IDENT Identifier ) ) ;
    public final CrlParser.split_return split() throws RecognitionException {
        CrlParser.split_return retval = new CrlParser.split_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal74=null;
        CommonToken Identifier75=null;

        CommonTree string_literal74_tree=null;
        CommonTree Identifier75_tree=null;
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try { dbg.enterRule(getGrammarFileName(), "split");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(162, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:163:2: ( 'split' Identifier -> ^( 'split' ^( IDENT Identifier ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:163:4: 'split' Identifier
            {
            dbg.location(163,4);
            string_literal74=(CommonToken)match(input,88,FOLLOW_88_in_split876);  
            stream_88.add(string_literal74);

            dbg.location(163,12);
            Identifier75=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_split878);  
            stream_Identifier.add(Identifier75);


            // AST REWRITE
            // elements: 88, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 163:23: -> ^( 'split' ^( IDENT Identifier ) )
            {
                dbg.location(163,26);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:163:26: ^( 'split' ^( IDENT Identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(163,28);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_88.nextNode()
                , root_1);

                dbg.location(163,36);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:163:36: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(163,38);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                dbg.location(163,44);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

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
        dbg.location(164, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "split");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "split"


    public static class merge_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "merge"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:166:1: merge : 'merge' Identifier 'with' Identifier -> ^( 'merge' ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) ) ;
    public final CrlParser.merge_return merge() throws RecognitionException {
        CrlParser.merge_return retval = new CrlParser.merge_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal76=null;
        CommonToken Identifier77=null;
        CommonToken string_literal78=null;
        CommonToken Identifier79=null;

        CommonTree string_literal76_tree=null;
        CommonTree Identifier77_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree Identifier79_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");

        try { dbg.enterRule(getGrammarFileName(), "merge");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(166, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:167:2: ( 'merge' Identifier 'with' Identifier -> ^( 'merge' ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:167:4: 'merge' Identifier 'with' Identifier
            {
            dbg.location(167,4);
            string_literal76=(CommonToken)match(input,68,FOLLOW_68_in_merge902);  
            stream_68.add(string_literal76);

            dbg.location(167,12);
            Identifier77=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_merge904);  
            stream_Identifier.add(Identifier77);

            dbg.location(167,23);
            string_literal78=(CommonToken)match(input,93,FOLLOW_93_in_merge906);  
            stream_93.add(string_literal78);

            dbg.location(167,30);
            Identifier79=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_merge908);  
            stream_Identifier.add(Identifier79);


            // AST REWRITE
            // elements: Identifier, 68, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 167:41: -> ^( 'merge' ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) )
            {
                dbg.location(167,44);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:167:44: ^( 'merge' ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(167,46);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_68.nextNode()
                , root_1);

                dbg.location(167,54);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:167:54: ^( IDENT1 Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(167,56);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT1, "IDENT1")
                , root_2);

                dbg.location(167,63);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(167,75);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:167:75: ^( IDENT2 Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(167,77);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT2, "IDENT2")
                , root_2);

                dbg.location(167,84);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

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
        dbg.location(168, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "merge");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "merge"


    public static class new_entry_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "new_entry"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:170:1: new_entry : 'new entry' Identifier ( 'as' j_expr )? -> ^( 'new entry' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) ;
    public final CrlParser.new_entry_return new_entry() throws RecognitionException {
        CrlParser.new_entry_return retval = new CrlParser.new_entry_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal80=null;
        CommonToken Identifier81=null;
        CommonToken string_literal82=null;
        CrlParser.j_expr_return j_expr83 =null;


        CommonTree string_literal80_tree=null;
        CommonTree Identifier81_tree=null;
        CommonTree string_literal82_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "new_entry");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(170, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:2: ( 'new entry' Identifier ( 'as' j_expr )? -> ^( 'new entry' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:4: 'new entry' Identifier ( 'as' j_expr )?
            {
            dbg.location(171,4);
            string_literal80=(CommonToken)match(input,69,FOLLOW_69_in_new_entry938);  
            stream_69.add(string_literal80);

            dbg.location(171,16);
            Identifier81=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_new_entry940);  
            stream_Identifier.add(Identifier81);

            dbg.location(171,27);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:27: ( 'as' j_expr )?
            int alt19=2;
            try { dbg.enterSubRule(19);
            try { dbg.enterDecision(19, decisionCanBacktrack[19]);

            int LA19_0 = input.LA(1);

            if ( (LA19_0==59) ) {
                alt19=1;
            }
            } finally {dbg.exitDecision(19);}

            switch (alt19) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:28: 'as' j_expr
                    {
                    dbg.location(171,28);
                    string_literal82=(CommonToken)match(input,59,FOLLOW_59_in_new_entry943);  
                    stream_59.add(string_literal82);

                    dbg.location(171,33);
                    pushFollow(FOLLOW_j_expr_in_new_entry945);
                    j_expr83=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr83.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(19);}


            // AST REWRITE
            // elements: j_expr, Identifier, 69
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 171:42: -> ^( 'new entry' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
            {
                dbg.location(171,45);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:45: ^( 'new entry' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(171,47);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_69.nextNode()
                , root_1);

                dbg.location(171,59);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:59: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(171,61);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                dbg.location(171,67);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(171,79);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:79: ( ^( STRING j_expr ) )?
                if ( stream_j_expr.hasNext() ) {
                    dbg.location(171,79);
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:171:79: ^( STRING j_expr )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    dbg.location(171,81);
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(STRING, "STRING")
                    , root_2);

                    dbg.location(171,88);
                    adaptor.addChild(root_2, stream_j_expr.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

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
        dbg.location(172, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "new_entry");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "new_entry"


    public static class set_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_value"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:174:1: set_value : 'set value' j_expr 'to' advanced_identifier -> ^( 'set value' ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) ) ;
    public final CrlParser.set_value_return set_value() throws RecognitionException {
        CrlParser.set_value_return retval = new CrlParser.set_value_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal84=null;
        CommonToken string_literal86=null;
        CrlParser.j_expr_return j_expr85 =null;

        CrlParser.advanced_identifier_return advanced_identifier87 =null;


        CommonTree string_literal84_tree=null;
        CommonTree string_literal86_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "set_value");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(174, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:175:2: ( 'set value' j_expr 'to' advanced_identifier -> ^( 'set value' ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:175:4: 'set value' j_expr 'to' advanced_identifier
            {
            dbg.location(175,4);
            string_literal84=(CommonToken)match(input,87,FOLLOW_87_in_set_value979);  
            stream_87.add(string_literal84);

            dbg.location(175,16);
            pushFollow(FOLLOW_j_expr_in_set_value981);
            j_expr85=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr85.getTree());
            dbg.location(175,23);
            string_literal86=(CommonToken)match(input,90,FOLLOW_90_in_set_value983);  
            stream_90.add(string_literal86);

            dbg.location(175,28);
            pushFollow(FOLLOW_advanced_identifier_in_set_value985);
            advanced_identifier87=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier87.getTree());

            // AST REWRITE
            // elements: 87, advanced_identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 175:48: -> ^( 'set value' ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) )
            {
                dbg.location(175,51);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:175:51: ^( 'set value' ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(175,53);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_87.nextNode()
                , root_1);

                dbg.location(175,65);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:175:65: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(175,67);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

                dbg.location(175,77);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(175,98);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:175:98: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(175,100);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

                dbg.location(175,107);
                adaptor.addChild(root_2, stream_j_expr.nextTree());

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
        dbg.location(176, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "set_value");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "set_value"


    public static class set_category_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_category"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:178:1: set_category : 'set category' j_expr 'to' advanced_identifier -> ^( 'set category' ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) ) ;
    public final CrlParser.set_category_return set_category() throws RecognitionException {
        CrlParser.set_category_return retval = new CrlParser.set_category_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal88=null;
        CommonToken string_literal90=null;
        CrlParser.j_expr_return j_expr89 =null;

        CrlParser.advanced_identifier_return advanced_identifier91 =null;


        CommonTree string_literal88_tree=null;
        CommonTree string_literal90_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "set_category");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(178, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:179:2: ( 'set category' j_expr 'to' advanced_identifier -> ^( 'set category' ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:179:4: 'set category' j_expr 'to' advanced_identifier
            {
            dbg.location(179,4);
            string_literal88=(CommonToken)match(input,82,FOLLOW_82_in_set_category1015);  
            stream_82.add(string_literal88);

            dbg.location(179,19);
            pushFollow(FOLLOW_j_expr_in_set_category1017);
            j_expr89=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr89.getTree());
            dbg.location(179,26);
            string_literal90=(CommonToken)match(input,90,FOLLOW_90_in_set_category1019);  
            stream_90.add(string_literal90);

            dbg.location(179,31);
            pushFollow(FOLLOW_advanced_identifier_in_set_category1021);
            advanced_identifier91=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier91.getTree());

            // AST REWRITE
            // elements: advanced_identifier, j_expr, 82
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 179:51: -> ^( 'set category' ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) )
            {
                dbg.location(179,54);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:179:54: ^( 'set category' ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(179,56);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_82.nextNode()
                , root_1);

                dbg.location(179,71);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:179:71: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(179,73);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

                dbg.location(179,83);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(179,104);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:179:104: ^( CATEGORY j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(179,106);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CATEGORY, "CATEGORY")
                , root_2);

                dbg.location(179,115);
                adaptor.addChild(root_2, stream_j_expr.nextTree());

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
        dbg.location(180, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "set_category");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "set_category"


    public static class set_parent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_parent"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:182:1: set_parent : 'set parent' advanced_identifier 'to' advanced_identifier -> ^( 'set parent' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) ;
    public final CrlParser.set_parent_return set_parent() throws RecognitionException {
        CrlParser.set_parent_return retval = new CrlParser.set_parent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal92=null;
        CommonToken string_literal94=null;
        CrlParser.advanced_identifier_return advanced_identifier93 =null;

        CrlParser.advanced_identifier_return advanced_identifier95 =null;


        CommonTree string_literal92_tree=null;
        CommonTree string_literal94_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        try { dbg.enterRule(getGrammarFileName(), "set_parent");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(182, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:2: ( 'set parent' advanced_identifier 'to' advanced_identifier -> ^( 'set parent' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:4: 'set parent' advanced_identifier 'to' advanced_identifier
            {
            dbg.location(183,4);
            string_literal92=(CommonToken)match(input,85,FOLLOW_85_in_set_parent1051);  
            stream_85.add(string_literal92);

            dbg.location(183,17);
            pushFollow(FOLLOW_advanced_identifier_in_set_parent1053);
            advanced_identifier93=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier93.getTree());
            dbg.location(183,37);
            string_literal94=(CommonToken)match(input,90,FOLLOW_90_in_set_parent1055);  
            stream_90.add(string_literal94);

            dbg.location(183,42);
            pushFollow(FOLLOW_advanced_identifier_in_set_parent1057);
            advanced_identifier95=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier95.getTree());

            // AST REWRITE
            // elements: advanced_identifier, advanced_identifier, 85
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 183:62: -> ^( 'set parent' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
            {
                dbg.location(183,65);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:65: ^( 'set parent' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(183,67);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_85.nextNode()
                , root_1);

                dbg.location(183,80);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:80: ^( ADV_IDENT1 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(183,82);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT1, "ADV_IDENT1")
                , root_2);

                dbg.location(183,93);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(183,114);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:183:114: ^( ADV_IDENT2 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(183,116);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT2, "ADV_IDENT2")
                , root_2);

                dbg.location(183,127);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

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
        dbg.location(184, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "set_parent");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "set_parent"


    public static class group_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:186:1: group : 'group' advanced_identifier 'with' advanced_identifier -> ^( 'group' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) ;
    public final CrlParser.group_return group() throws RecognitionException {
        CrlParser.group_return retval = new CrlParser.group_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal96=null;
        CommonToken string_literal98=null;
        CrlParser.advanced_identifier_return advanced_identifier97 =null;

        CrlParser.advanced_identifier_return advanced_identifier99 =null;


        CommonTree string_literal96_tree=null;
        CommonTree string_literal98_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        try { dbg.enterRule(getGrammarFileName(), "group");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(186, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:187:2: ( 'group' advanced_identifier 'with' advanced_identifier -> ^( 'group' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:187:4: 'group' advanced_identifier 'with' advanced_identifier
            {
            dbg.location(187,4);
            string_literal96=(CommonToken)match(input,64,FOLLOW_64_in_group1087);  
            stream_64.add(string_literal96);

            dbg.location(187,12);
            pushFollow(FOLLOW_advanced_identifier_in_group1089);
            advanced_identifier97=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier97.getTree());
            dbg.location(187,32);
            string_literal98=(CommonToken)match(input,93,FOLLOW_93_in_group1091);  
            stream_93.add(string_literal98);

            dbg.location(187,39);
            pushFollow(FOLLOW_advanced_identifier_in_group1093);
            advanced_identifier99=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier99.getTree());

            // AST REWRITE
            // elements: 64, advanced_identifier, advanced_identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 187:59: -> ^( 'group' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
            {
                dbg.location(187,62);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:187:62: ^( 'group' ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(187,64);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_64.nextNode()
                , root_1);

                dbg.location(187,72);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:187:72: ^( ADV_IDENT1 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(187,74);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT1, "ADV_IDENT1")
                , root_2);

                dbg.location(187,85);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(187,106);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:187:106: ^( ADV_IDENT2 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(187,108);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT2, "ADV_IDENT2")
                , root_2);

                dbg.location(187,119);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

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
        dbg.location(188, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "group");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "group"


    public static class add_label_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add_label"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:190:1: add_label : 'add label' j_expr ( 'of' j_expr )? 'to' advanced_identifier -> ^( 'add label' ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) ) ;
    public final CrlParser.add_label_return add_label() throws RecognitionException {
        CrlParser.add_label_return retval = new CrlParser.add_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal100=null;
        CommonToken string_literal102=null;
        CommonToken string_literal104=null;
        CrlParser.j_expr_return j_expr101 =null;

        CrlParser.j_expr_return j_expr103 =null;

        CrlParser.advanced_identifier_return advanced_identifier105 =null;


        CommonTree string_literal100_tree=null;
        CommonTree string_literal102_tree=null;
        CommonTree string_literal104_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "add_label");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(190, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:2: ( 'add label' j_expr ( 'of' j_expr )? 'to' advanced_identifier -> ^( 'add label' ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:4: 'add label' j_expr ( 'of' j_expr )? 'to' advanced_identifier
            {
            dbg.location(191,4);
            string_literal100=(CommonToken)match(input,58,FOLLOW_58_in_add_label1123);  
            stream_58.add(string_literal100);

            dbg.location(191,16);
            pushFollow(FOLLOW_j_expr_in_add_label1125);
            j_expr101=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr101.getTree());
            dbg.location(191,23);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:23: ( 'of' j_expr )?
            int alt20=2;
            try { dbg.enterSubRule(20);
            try { dbg.enterDecision(20, decisionCanBacktrack[20]);

            int LA20_0 = input.LA(1);

            if ( (LA20_0==77) ) {
                alt20=1;
            }
            } finally {dbg.exitDecision(20);}

            switch (alt20) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:24: 'of' j_expr
                    {
                    dbg.location(191,24);
                    string_literal102=(CommonToken)match(input,77,FOLLOW_77_in_add_label1128);  
                    stream_77.add(string_literal102);

                    dbg.location(191,29);
                    pushFollow(FOLLOW_j_expr_in_add_label1130);
                    j_expr103=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr103.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(20);}

            dbg.location(191,38);
            string_literal104=(CommonToken)match(input,90,FOLLOW_90_in_add_label1134);  
            stream_90.add(string_literal104);

            dbg.location(191,43);
            pushFollow(FOLLOW_advanced_identifier_in_add_label1136);
            advanced_identifier105=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier105.getTree());

            // AST REWRITE
            // elements: 58, j_expr, advanced_identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 191:63: -> ^( 'add label' ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) )
            {
                dbg.location(191,66);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:66: ^( 'add label' ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(191,68);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_58.nextNode()
                , root_1);

                dbg.location(191,80);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:80: ^( LABEL j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(191,82);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(LABEL, "LABEL")
                , root_2);

                dbg.location(191,88);
                adaptor.addChild(root_2, stream_j_expr.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(191,96);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:96: ( ^( CATEGORY j_expr ) )?
                if ( stream_j_expr.hasNext() ) {
                    dbg.location(191,96);
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:96: ^( CATEGORY j_expr )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    dbg.location(191,98);
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(CATEGORY, "CATEGORY")
                    , root_2);

                    dbg.location(191,107);
                    adaptor.addChild(root_2, stream_j_expr.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_j_expr.reset();
                dbg.location(191,116);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:191:116: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(191,118);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

                dbg.location(191,128);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

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
        dbg.location(192, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "add_label");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "add_label"


    public static class new_label_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "new_label"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:194:1: new_label : 'new label' Identifier ( 'as' j_expr )? -> ^( 'new label' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) ;
    public final CrlParser.new_label_return new_label() throws RecognitionException {
        CrlParser.new_label_return retval = new CrlParser.new_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal106=null;
        CommonToken Identifier107=null;
        CommonToken string_literal108=null;
        CrlParser.j_expr_return j_expr109 =null;


        CommonTree string_literal106_tree=null;
        CommonTree Identifier107_tree=null;
        CommonTree string_literal108_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "new_label");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(194, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:2: ( 'new label' Identifier ( 'as' j_expr )? -> ^( 'new label' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:4: 'new label' Identifier ( 'as' j_expr )?
            {
            dbg.location(195,4);
            string_literal106=(CommonToken)match(input,70,FOLLOW_70_in_new_label1173);  
            stream_70.add(string_literal106);

            dbg.location(195,16);
            Identifier107=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_new_label1175);  
            stream_Identifier.add(Identifier107);

            dbg.location(195,27);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:27: ( 'as' j_expr )?
            int alt21=2;
            try { dbg.enterSubRule(21);
            try { dbg.enterDecision(21, decisionCanBacktrack[21]);

            int LA21_0 = input.LA(1);

            if ( (LA21_0==59) ) {
                alt21=1;
            }
            } finally {dbg.exitDecision(21);}

            switch (alt21) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:28: 'as' j_expr
                    {
                    dbg.location(195,28);
                    string_literal108=(CommonToken)match(input,59,FOLLOW_59_in_new_label1178);  
                    stream_59.add(string_literal108);

                    dbg.location(195,33);
                    pushFollow(FOLLOW_j_expr_in_new_label1180);
                    j_expr109=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr109.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(21);}


            // AST REWRITE
            // elements: 70, Identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 195:42: -> ^( 'new label' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
            {
                dbg.location(195,45);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:45: ^( 'new label' ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(195,47);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_70.nextNode()
                , root_1);

                dbg.location(195,59);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:59: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(195,61);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                dbg.location(195,67);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(195,79);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:79: ( ^( STRING j_expr ) )?
                if ( stream_j_expr.hasNext() ) {
                    dbg.location(195,79);
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:195:79: ^( STRING j_expr )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    dbg.location(195,81);
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(STRING, "STRING")
                    , root_2);

                    dbg.location(195,88);
                    adaptor.addChild(root_2, stream_j_expr.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

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
        dbg.location(196, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "new_label");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "new_label"


    public static class update_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "update"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:198:1: update : 'update' advanced_identifier -> ^( 'update' ^( ADV_IDENT advanced_identifier ) ) ;
    public final CrlParser.update_return update() throws RecognitionException {
        CrlParser.update_return retval = new CrlParser.update_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal110=null;
        CrlParser.advanced_identifier_return advanced_identifier111 =null;


        CommonTree string_literal110_tree=null;
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        try { dbg.enterRule(getGrammarFileName(), "update");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(198, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:199:2: ( 'update' advanced_identifier -> ^( 'update' ^( ADV_IDENT advanced_identifier ) ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:199:4: 'update' advanced_identifier
            {
            dbg.location(199,4);
            string_literal110=(CommonToken)match(input,91,FOLLOW_91_in_update1213);  
            stream_91.add(string_literal110);

            dbg.location(199,13);
            pushFollow(FOLLOW_advanced_identifier_in_update1215);
            advanced_identifier111=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier111.getTree());

            // AST REWRITE
            // elements: 91, advanced_identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 199:33: -> ^( 'update' ^( ADV_IDENT advanced_identifier ) )
            {
                dbg.location(199,36);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:199:36: ^( 'update' ^( ADV_IDENT advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(199,38);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_91.nextNode()
                , root_1);

                dbg.location(199,47);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:199:47: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(199,49);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

                dbg.location(199,59);
                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

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
        dbg.location(200, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "update");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "update"


    public static class c_print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "c_print"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:202:1: c_print : ( 'print' | 'printf' ) j_expr -> ^( PrintAction j_expr ) ;
    public final CrlParser.c_print_return c_print() throws RecognitionException {
        CrlParser.c_print_return retval = new CrlParser.c_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal112=null;
        CommonToken string_literal113=null;
        CrlParser.j_expr_return j_expr114 =null;


        CommonTree string_literal112_tree=null;
        CommonTree string_literal113_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try { dbg.enterRule(getGrammarFileName(), "c_print");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(202, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:203:2: ( ( 'print' | 'printf' ) j_expr -> ^( PrintAction j_expr ) )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:203:4: ( 'print' | 'printf' ) j_expr
            {
            dbg.location(203,4);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:203:4: ( 'print' | 'printf' )
            int alt22=2;
            try { dbg.enterSubRule(22);
            try { dbg.enterDecision(22, decisionCanBacktrack[22]);

            int LA22_0 = input.LA(1);

            if ( (LA22_0==79) ) {
                alt22=1;
            }
            else if ( (LA22_0==80) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(22);}

            switch (alt22) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:203:5: 'print'
                    {
                    dbg.location(203,5);
                    string_literal112=(CommonToken)match(input,79,FOLLOW_79_in_c_print1240);  
                    stream_79.add(string_literal112);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:203:13: 'printf'
                    {
                    dbg.location(203,13);
                    string_literal113=(CommonToken)match(input,80,FOLLOW_80_in_c_print1242);  
                    stream_80.add(string_literal113);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(22);}

            dbg.location(203,23);
            pushFollow(FOLLOW_j_expr_in_c_print1245);
            j_expr114=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr114.getTree());

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
            // 203:30: -> ^( PrintAction j_expr )
            {
                dbg.location(203,33);
                // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:203:33: ^( PrintAction j_expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(203,35);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PrintAction, "PrintAction")
                , root_1);

                dbg.location(203,47);
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
        dbg.location(204, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "c_print");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "c_print"


    public static class advanced_identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "advanced_identifier"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:206:1: advanced_identifier : Identifier ( '.' query ( index )? )? ;
    public final CrlParser.advanced_identifier_return advanced_identifier() throws RecognitionException {
        CrlParser.advanced_identifier_return retval = new CrlParser.advanced_identifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken Identifier115=null;
        CommonToken char_literal116=null;
        CrlParser.query_return query117 =null;

        CrlParser.index_return index118 =null;


        CommonTree Identifier115_tree=null;
        CommonTree char_literal116_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "advanced_identifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(206, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:207:2: ( Identifier ( '.' query ( index )? )? )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:207:4: Identifier ( '.' query ( index )? )?
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(207,4);
            Identifier115=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_advanced_identifier1265); 
            Identifier115_tree = 
            (CommonTree)adaptor.create(Identifier115)
            ;
            adaptor.addChild(root_0, Identifier115_tree);

            dbg.location(207,15);
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:207:15: ( '.' query ( index )? )?
            int alt24=2;
            try { dbg.enterSubRule(24);
            try { dbg.enterDecision(24, decisionCanBacktrack[24]);

            int LA24_0 = input.LA(1);

            if ( (LA24_0==53) ) {
                alt24=1;
            }
            } finally {dbg.exitDecision(24);}

            switch (alt24) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:207:16: '.' query ( index )?
                    {
                    dbg.location(207,16);
                    char_literal116=(CommonToken)match(input,53,FOLLOW_53_in_advanced_identifier1268); 
                    char_literal116_tree = 
                    (CommonTree)adaptor.create(char_literal116)
                    ;
                    adaptor.addChild(root_0, char_literal116_tree);

                    dbg.location(207,20);
                    pushFollow(FOLLOW_query_in_advanced_identifier1270);
                    query117=query();

                    state._fsp--;

                    adaptor.addChild(root_0, query117.getTree());
                    dbg.location(207,26);
                    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:207:26: ( index )?
                    int alt23=2;
                    try { dbg.enterSubRule(23);
                    try { dbg.enterDecision(23, decisionCanBacktrack[23]);

                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==56) ) {
                        alt23=1;
                    }
                    } finally {dbg.exitDecision(23);}

                    switch (alt23) {
                        case 1 :
                            dbg.enterAlt(1);

                            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:207:26: index
                            {
                            dbg.location(207,26);
                            pushFollow(FOLLOW_index_in_advanced_identifier1272);
                            index118=index();

                            state._fsp--;

                            adaptor.addChild(root_0, index118.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(23);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(24);}


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
        dbg.location(208, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "advanced_identifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "advanced_identifier"


    public static class index_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "index"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:227:1: index : '[' J_int_literal ']' -> J_int_literal ;
    public final CrlParser.index_return index() throws RecognitionException {
        CrlParser.index_return retval = new CrlParser.index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken char_literal119=null;
        CommonToken J_int_literal120=null;
        CommonToken char_literal121=null;

        CommonTree char_literal119_tree=null;
        CommonTree J_int_literal120_tree=null;
        CommonTree char_literal121_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");

        try { dbg.enterRule(getGrammarFileName(), "index");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(227, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:228:2: ( '[' J_int_literal ']' -> J_int_literal )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:228:4: '[' J_int_literal ']'
            {
            dbg.location(228,4);
            char_literal119=(CommonToken)match(input,56,FOLLOW_56_in_index1403);  
            stream_56.add(char_literal119);

            dbg.location(228,8);
            J_int_literal120=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_index1405);  
            stream_J_int_literal.add(J_int_literal120);

            dbg.location(228,22);
            char_literal121=(CommonToken)match(input,57,FOLLOW_57_in_index1407);  
            stream_57.add(char_literal121);


            // AST REWRITE
            // elements: J_int_literal
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 228:26: -> J_int_literal
            {
                dbg.location(228,29);
                adaptor.addChild(root_0, 
                stream_J_int_literal.nextNode()
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
        dbg.location(229, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "index");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "index"


    public static class useless_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "useless"
    // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:245:1: useless : ( 'lock-on-active' | 'no-loop true' | 'no-loop false' );
    public final CrlParser.useless_return useless() throws RecognitionException {
        CrlParser.useless_return retval = new CrlParser.useless_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set122=null;

        CommonTree set122_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "useless");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(245, 0);

        try {
            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:246:2: ( 'lock-on-active' | 'no-loop true' | 'no-loop false' )
            dbg.enterAlt(1);

            // D:\\Work\\TabbyDOC\\tabbyxl2-1\\src\\main\\resources\\Crl.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(246,2);
            set122=(CommonToken)input.LT(1);

            if ( input.LA(1)==67||(input.LA(1) >= 75 && input.LA(1) <= 76) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set122)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


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
        dbg.location(247, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "useless");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "useless"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\10\uffff";
    static final String DFA1_eofS =
        "\10\uffff";
    static final String DFA1_minS =
        "\1\101\1\30\1\uffff\1\22\1\30\1\uffff\2\22";
    static final String DFA1_maxS =
        "\1\121\1\30\1\uffff\1\121\1\63\1\uffff\2\121";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA1_specialS =
        "\10\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\14\uffff\1\1\2\uffff\1\2",
            "\1\3",
            "",
            "\1\2\42\uffff\1\4\1\uffff\1\2\11\uffff\1\5\14\uffff\1\5\2\uffff"+
            "\1\5",
            "\1\6\32\uffff\1\7",
            "",
            "\1\2\42\uffff\1\4\1\uffff\1\2\11\uffff\1\5\14\uffff\1\5\2\uffff"+
            "\1\5",
            "\1\2\44\uffff\1\2\11\uffff\1\5\14\uffff\1\5\2\uffff\1\5"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "63:4: ( package_stmt )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_package_stmt_in_crl201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000024002L});
    public static final BitSet FOLLOW_import_stmt_in_crl204 = new BitSet(new long[]{0x0000000000000000L,0x0000000000024002L});
    public static final BitSet FOLLOW_crl_rule_in_crl207 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_78_in_package_stmt236 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_import_item_in_package_stmt238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_unit_in_import_stmt254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_import_unit286 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_import_item_in_import_unit296 = new BitSet(new long[]{0x0080000000040000L});
    public static final BitSet FOLLOW_55_in_import_unit300 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_import_unit303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_import_item327 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_import_item332 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_import_item336 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_import_item343 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_import_item345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_crl_rule362 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_J_int_literal_in_crl_rule364 = new BitSet(new long[]{0x0000000000040000L,0x0000000000001808L});
    public static final BitSet FOLLOW_useless_in_crl_rule366 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule369 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_crl_rule373 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule375 = new BitSet(new long[]{0xB000000000000000L,0x0000000000000784L});
    public static final BitSet FOLLOW_condition_unit_in_crl_rule380 = new BitSet(new long[]{0xB000000000000000L,0x0000000002000784L});
    public static final BitSet FOLLOW_89_in_crl_rule385 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule387 = new BitSet(new long[]{0x0400000000000000L,0x0000000009FD8071L});
    public static final BitSet FOLLOW_action_in_crl_rule391 = new BitSet(new long[]{0x4400000000000000L,0x0000000009FD8071L});
    public static final BitSet FOLLOW_62_in_crl_rule396 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_EOL_in_crl_rule398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_in_condition_unit430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_condition_in_condition_unit432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_condition443 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_condition445 = new BitSet(new long[]{0x0040000000040000L});
    public static final BitSet FOLLOW_54_in_condition448 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_constraint_in_condition450 = new BitSet(new long[]{0x0010000000040000L});
    public static final BitSet FOLLOW_52_in_condition453 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_constraint_in_condition455 = new BitSet(new long[]{0x0010000000040000L});
    public static final BitSet FOLLOW_52_in_condition460 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_assignment_in_condition462 = new BitSet(new long[]{0x0010000000040000L});
    public static final BitSet FOLLOW_EOL_in_condition469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_query_in_no_condition518 = new BitSet(new long[]{0x0040000000040000L});
    public static final BitSet FOLLOW_54_in_no_condition521 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_constraint_in_no_condition523 = new BitSet(new long[]{0x0010000000040000L});
    public static final BitSet FOLLOW_52_in_no_condition526 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_constraint_in_no_condition528 = new BitSet(new long[]{0x0010000000040000L});
    public static final BitSet FOLLOW_EOL_in_no_condition535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_j_expr_in_constraint576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_assignment596 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_assignment598 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_assignment600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_j_expr644 = new BitSet(new long[]{0xFFABFFFFFFFBFFF2L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_action__in_action673 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_action675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_mark_in_action_691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_text_in_action_696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_indent_in_action_701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_value_in_action_706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_in_action_711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_merge_in_action_716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_label_in_action_721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_label_in_action_726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_category_in_action_731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_parent_in_action_736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_entry_in_action_741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_action_746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_c_print_in_action_751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_update_in_action_756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_set_mark768 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_mark770 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_set_mark772 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_set_mark774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_set_text804 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_text806 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_set_text808 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_set_text810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_set_indent840 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_J_int_literal_in_set_indent842 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_set_indent844 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_set_indent846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_split876 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_split878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_merge902 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_merge904 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_merge906 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_merge908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_new_entry938 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_new_entry940 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_new_entry943 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_new_entry945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_set_value979 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_value981 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_set_value983 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_value985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_set_category1015 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_category1017 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_set_category1019 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_category1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_set_parent1051 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_parent1053 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_set_parent1055 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_parent1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_group1087 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_group1089 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_group1091 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_group1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_add_label1123 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_add_label1125 = new BitSet(new long[]{0x0000000000000000L,0x0000000004002000L});
    public static final BitSet FOLLOW_77_in_add_label1128 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_add_label1130 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_add_label1134 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_add_label1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_new_label1173 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_new_label1175 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_new_label1178 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_new_label1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_update1213 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_update1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_c_print1240 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_80_in_c_print1242 = new BitSet(new long[]{0xFFABFFFFFFFBFFF0L,0x000000003BFFDFFFL});
    public static final BitSet FOLLOW_j_expr_in_c_print1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_advanced_identifier1265 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_advanced_identifier1268 = new BitSet(new long[]{0xB000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_query_in_advanced_identifier1270 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_index_in_advanced_identifier1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_index1403 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_J_int_literal_in_index1405 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_index1407 = new BitSet(new long[]{0x0000000000000002L});

}