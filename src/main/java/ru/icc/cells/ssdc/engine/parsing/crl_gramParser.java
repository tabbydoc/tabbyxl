// $ANTLR 3.4 C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g 2018-03-07 12:04:00
package ru.icc.cells.ssdc.engine.parsing;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class crl_gramParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADV_IDENT", "ADV_IDENT1", "ADV_IDENT2", "Action", "Actions", "Add_label", "Assignment", "Breackits", "CATEGORY", "Char_lit", "Condition", "Conditions", "Constraint", "DIGIT", "EOL", "Group", "IDENT", "IDENT1", "IDENT2", "INT", "Identifier", "Import_item", "Imports", "J_expr", "J_int_literal", "LABEL", "LETTER", "Merge", "New_entry", "New_label", "No_condition", "Other_literals", "Print", "RULES", "STRING", "Set_category", "Set_indent", "Set_mark", "Set_parent", "Set_text", "Set_value", "Split", "String_lit", "Update", "WS", "'\"'", "'*'", "','", "'.'", "':'", "';'", "'['", "']'", "'add label'", "'as'", "'category'", "'cell'", "'end'", "'entry'", "'group'", "'import'", "'label'", "'lock-on-active'", "'merge'", "'new entry'", "'new label'", "'no categories'", "'no cells'", "'no entries'", "'no labels'", "'no-loop false'", "'no-loop true'", "'of'", "'package'", "'print'", "'printf'", "'rule #'", "'set category'", "'set indent'", "'set mark'", "'set parent'", "'set text'", "'set value'", "'split'", "'then'", "'to'", "'update'", "'when'", "'with'"
    };

    public static final int EOF=-1;
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
    public static final int ADV_IDENT=4;
    public static final int ADV_IDENT1=5;
    public static final int ADV_IDENT2=6;
    public static final int Action=7;
    public static final int Actions=8;
    public static final int Add_label=9;
    public static final int Assignment=10;
    public static final int Breackits=11;
    public static final int CATEGORY=12;
    public static final int Char_lit=13;
    public static final int Condition=14;
    public static final int Conditions=15;
    public static final int Constraint=16;
    public static final int DIGIT=17;
    public static final int EOL=18;
    public static final int Group=19;
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
    public static final int Merge=31;
    public static final int New_entry=32;
    public static final int New_label=33;
    public static final int No_condition=34;
    public static final int Other_literals=35;
    public static final int Print=36;
    public static final int RULES=37;
    public static final int STRING=38;
    public static final int Set_category=39;
    public static final int Set_indent=40;
    public static final int Set_mark=41;
    public static final int Set_parent=42;
    public static final int Set_text=43;
    public static final int Set_value=44;
    public static final int Split=45;
    public static final int String_lit=46;
    public static final int Update=47;
    public static final int WS=48;

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
    public String getGrammarFileName() { return "C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g"; }


    public static class crl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public CommonTree getTree() { return tree; }
    };


    // $ANTLR start "crl"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:61:1: crl : ( import_stmt )* ( crl_rule )+ -> ^( Imports ( import_stmt )* ) ^( RULES ( crl_rule )+ ) ;
    public final crl_gramParser.crl_return crl() throws RecognitionException {
        crl_gramParser.crl_return retval = new crl_gramParser.crl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.import_stmt_return import_stmt1 =null;

        crl_gramParser.crl_rule_return crl_rule2 =null;


        RewriteRuleSubtreeStream stream_crl_rule=new RewriteRuleSubtreeStream(adaptor,"rule crl_rule");
        RewriteRuleSubtreeStream stream_import_stmt=new RewriteRuleSubtreeStream(adaptor,"rule import_stmt");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:2: ( ( import_stmt )* ( crl_rule )+ -> ^( Imports ( import_stmt )* ) ^( RULES ( crl_rule )+ ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:4: ( import_stmt )* ( crl_rule )+
            {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:4: ( import_stmt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==64||LA1_0==77) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:4: import_stmt
            	    {
            	    pushFollow(FOLLOW_import_stmt_in_crl197);
            	    import_stmt1=import_stmt();

            	    state._fsp--;

            	    stream_import_stmt.add(import_stmt1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:17: ( crl_rule )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==80) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:17: crl_rule
            	    {
            	    pushFollow(FOLLOW_crl_rule_in_crl200);
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
            // elements: crl_rule, import_stmt
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 62:27: -> ^( Imports ( import_stmt )* ) ^( RULES ( crl_rule )+ )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:30: ^( Imports ( import_stmt )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Imports, "Imports")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:40: ( import_stmt )*
                while ( stream_import_stmt.hasNext() ) {
                    adaptor.addChild(root_1, stream_import_stmt.nextTree());

                }
                stream_import_stmt.reset();

                adaptor.addChild(root_0, root_1);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:62:54: ^( RULES ( crl_rule )+ )
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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:66:1: import_stmt : i= import_unit -> Import_item[$i.value] ;
    public final crl_gramParser.import_stmt_return import_stmt() throws RecognitionException {
        crl_gramParser.import_stmt_return retval = new crl_gramParser.import_stmt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.import_unit_return i =null;


        RewriteRuleSubtreeStream stream_import_unit=new RewriteRuleSubtreeStream(adaptor,"rule import_unit");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:67:2: (i= import_unit -> Import_item[$i.value] )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:67:4: i= import_unit
            {
            pushFollow(FOLLOW_import_unit_in_import_stmt233);
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
            // 67:18: -> Import_item[$i.value]
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


    public static class import_unit_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_unit"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:70:1: import_unit returns [String value] : t= ( 'import' | 'package' ) t1= import_item ( ';' )? EOL ;
    public final crl_gramParser.import_unit_return import_unit() throws RecognitionException {
        crl_gramParser.import_unit_return retval = new crl_gramParser.import_unit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken t=null;
        CommonToken char_literal3=null;
        CommonToken EOL4=null;
        crl_gramParser.import_item_return t1 =null;


        CommonTree t_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree EOL4_tree=null;

         retval.value =""; 
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:73:2: (t= ( 'import' | 'package' ) t1= import_item ( ';' )? EOL )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:73:4: t= ( 'import' | 'package' ) t1= import_item ( ';' )? EOL
            {
            root_0 = (CommonTree)adaptor.nil();


            t=(CommonToken)input.LT(1);

            if ( input.LA(1)==64||input.LA(1)==77 ) {
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

            pushFollow(FOLLOW_import_item_in_import_unit275);
            t1=import_item();

            state._fsp--;

            adaptor.addChild(root_0, t1.getTree());

             retval.value+=(t1!=null?t1.value:null); 

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:73:90: ( ';' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==54) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:73:90: ';'
                    {
                    char_literal3=(CommonToken)match(input,54,FOLLOW_54_in_import_unit279); 
                    char_literal3_tree = 
                    (CommonTree)adaptor.create(char_literal3)
                    ;
                    adaptor.addChild(root_0, char_literal3_tree);


                    }
                    break;

            }


            EOL4=(CommonToken)match(input,EOL,FOLLOW_EOL_in_import_unit282); 
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
    // $ANTLR end "import_unit"


    public static class import_item_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_item"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:76:1: import_item returns [String value] : i1= Identifier ( '.' i2= Identifier )* ( '.' '*' )? ;
    public final crl_gramParser.import_item_return import_item() throws RecognitionException {
        crl_gramParser.import_item_return retval = new crl_gramParser.import_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken i1=null;
        CommonToken i2=null;
        CommonToken char_literal5=null;
        CommonToken char_literal6=null;
        CommonToken char_literal7=null;

        CommonTree i1_tree=null;
        CommonTree i2_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree char_literal7_tree=null;

         retval.value =""; 
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:78:2: (i1= Identifier ( '.' i2= Identifier )* ( '.' '*' )? )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:78:5: i1= Identifier ( '.' i2= Identifier )* ( '.' '*' )?
            {
            root_0 = (CommonTree)adaptor.nil();


            i1=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_import_item306); 
            i1_tree = 
            (CommonTree)adaptor.create(i1)
            ;
            adaptor.addChild(root_0, i1_tree);


             retval.value+=(i1!=null?i1.getText():null); 

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:78:41: ( '.' i2= Identifier )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==52) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==Identifier) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:78:42: '.' i2= Identifier
            	    {
            	    char_literal5=(CommonToken)match(input,52,FOLLOW_52_in_import_item311); 
            	    char_literal5_tree = 
            	    (CommonTree)adaptor.create(char_literal5)
            	    ;
            	    adaptor.addChild(root_0, char_literal5_tree);


            	    i2=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_import_item315); 
            	    i2_tree = 
            	    (CommonTree)adaptor.create(i2)
            	    ;
            	    adaptor.addChild(root_0, i2_tree);


            	     retval.value+="."+(i2!=null?i2.getText():null); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:78:88: ( '.' '*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==52) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:78:89: '.' '*'
                    {
                    char_literal6=(CommonToken)match(input,52,FOLLOW_52_in_import_item322); 
                    char_literal6_tree = 
                    (CommonTree)adaptor.create(char_literal6)
                    ;
                    adaptor.addChild(root_0, char_literal6_tree);


                    char_literal7=(CommonToken)match(input,50,FOLLOW_50_in_import_item324); 
                    char_literal7_tree = 
                    (CommonTree)adaptor.create(char_literal7)
                    ;
                    adaptor.addChild(root_0, char_literal7_tree);


                     retval.value+=".*"; 

                    }
                    break;

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
        return retval;
    }
    // $ANTLR end "import_item"


    public static class crl_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "crl_rule"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:81:1: crl_rule : 'rule #' J_int_literal ( useless )? EOL 'when' EOL ( condition_unit )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) ) ;
    public final crl_gramParser.crl_rule_return crl_rule() throws RecognitionException {
        crl_gramParser.crl_rule_return retval = new crl_gramParser.crl_rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal8=null;
        CommonToken J_int_literal9=null;
        CommonToken EOL11=null;
        CommonToken string_literal12=null;
        CommonToken EOL13=null;
        CommonToken string_literal15=null;
        CommonToken EOL16=null;
        CommonToken string_literal18=null;
        CommonToken EOL19=null;
        crl_gramParser.useless_return useless10 =null;

        crl_gramParser.condition_unit_return condition_unit14 =null;

        crl_gramParser.action_return action17 =null;


        CommonTree string_literal8_tree=null;
        CommonTree J_int_literal9_tree=null;
        CommonTree EOL11_tree=null;
        CommonTree string_literal12_tree=null;
        CommonTree EOL13_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree EOL16_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree EOL19_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleSubtreeStream stream_useless=new RewriteRuleSubtreeStream(adaptor,"rule useless");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        RewriteRuleSubtreeStream stream_condition_unit=new RewriteRuleSubtreeStream(adaptor,"rule condition_unit");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:82:2: ( 'rule #' J_int_literal ( useless )? EOL 'when' EOL ( condition_unit )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:82:4: 'rule #' J_int_literal ( useless )? EOL 'when' EOL ( condition_unit )+ 'then' EOL ( action )+ 'end' ( EOL )?
            {
            string_literal8=(CommonToken)match(input,80,FOLLOW_80_in_crl_rule341);  
            stream_80.add(string_literal8);


            J_int_literal9=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_crl_rule343);  
            stream_J_int_literal.add(J_int_literal9);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:82:27: ( useless )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==66||(LA6_0 >= 74 && LA6_0 <= 75)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:82:27: useless
                    {
                    pushFollow(FOLLOW_useless_in_crl_rule345);
                    useless10=useless();

                    state._fsp--;

                    stream_useless.add(useless10.getTree());

                    }
                    break;

            }


            EOL11=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule348);  
            stream_EOL.add(EOL11);


            string_literal12=(CommonToken)match(input,91,FOLLOW_91_in_crl_rule352);  
            stream_91.add(string_literal12);


            EOL13=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule354);  
            stream_EOL.add(EOL13);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:84:3: ( condition_unit )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= 59 && LA7_0 <= 60)||LA7_0==62||LA7_0==65||(LA7_0 >= 70 && LA7_0 <= 73)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:84:3: condition_unit
            	    {
            	    pushFollow(FOLLOW_condition_unit_in_crl_rule359);
            	    condition_unit14=condition_unit();

            	    state._fsp--;

            	    stream_condition_unit.add(condition_unit14.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            string_literal15=(CommonToken)match(input,88,FOLLOW_88_in_crl_rule364);  
            stream_88.add(string_literal15);


            EOL16=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule366);  
            stream_EOL.add(EOL16);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:86:3: ( action )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==57||LA8_0==63||(LA8_0 >= 67 && LA8_0 <= 69)||(LA8_0 >= 78 && LA8_0 <= 79)||(LA8_0 >= 81 && LA8_0 <= 87)||LA8_0==90) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:86:3: action
            	    {
            	    pushFollow(FOLLOW_action_in_crl_rule370);
            	    action17=action();

            	    state._fsp--;

            	    stream_action.add(action17.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            string_literal18=(CommonToken)match(input,61,FOLLOW_61_in_crl_rule375);  
            stream_61.add(string_literal18);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:87:9: ( EOL )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EOL) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:87:9: EOL
                    {
                    EOL19=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule377);  
                    stream_EOL.add(EOL19);


                    }
                    break;

            }


            // AST REWRITE
            // elements: condition_unit, J_int_literal, action
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 87:14: -> ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:87:17: ^( J_int_literal ^( Conditions ( condition_unit )+ ) ^( Actions ( action )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_J_int_literal.nextNode()
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:87:33: ^( Conditions ( condition_unit )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Conditions, "Conditions")
                , root_2);

                if ( !(stream_condition_unit.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_condition_unit.hasNext() ) {
                    adaptor.addChild(root_2, stream_condition_unit.nextTree());

                }
                stream_condition_unit.reset();

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:87:63: ^( Actions ( action )+ )
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


    public static class condition_unit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition_unit"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:90:1: condition_unit : ( condition | no_condition );
    public final crl_gramParser.condition_unit_return condition_unit() throws RecognitionException {
        crl_gramParser.condition_unit_return retval = new crl_gramParser.condition_unit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.condition_return condition20 =null;

        crl_gramParser.no_condition_return no_condition21 =null;



        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:91:2: ( condition | no_condition )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0 >= 59 && LA10_0 <= 60)||LA10_0==62||LA10_0==65) ) {
                alt10=1;
            }
            else if ( ((LA10_0 >= 70 && LA10_0 <= 73)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:91:4: condition
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_condition_in_condition_unit409);
                    condition20=condition();

                    state._fsp--;

                    adaptor.addChild(root_0, condition20.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:91:14: no_condition
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_no_condition_in_condition_unit411);
                    no_condition21=no_condition();

                    state._fsp--;

                    adaptor.addChild(root_0, no_condition21.getTree());

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
    // $ANTLR end "condition_unit"


    public static class condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:94:1: condition : query Identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query Identifier ( constraint )* ( assignment )* ) ;
    public final crl_gramParser.condition_return condition() throws RecognitionException {
        crl_gramParser.condition_return retval = new crl_gramParser.condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken Identifier23=null;
        CommonToken char_literal24=null;
        CommonToken char_literal26=null;
        CommonToken char_literal28=null;
        CommonToken EOL30=null;
        crl_gramParser.query_return query22 =null;

        crl_gramParser.constraint_return constraint25 =null;

        crl_gramParser.constraint_return constraint27 =null;

        crl_gramParser.assignment_return assignment29 =null;


        CommonTree Identifier23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree EOL30_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_query=new RewriteRuleSubtreeStream(adaptor,"rule query");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:2: ( query Identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query Identifier ( constraint )* ( assignment )* ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:4: query Identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL
            {
            pushFollow(FOLLOW_query_in_condition422);
            query22=query();

            state._fsp--;

            stream_query.add(query22.getTree());

            Identifier23=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_condition424);  
            stream_Identifier.add(Identifier23);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:21: ( ':' constraint ( ',' constraint )* ( ',' assignment )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==53) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:22: ':' constraint ( ',' constraint )* ( ',' assignment )*
                    {
                    char_literal24=(CommonToken)match(input,53,FOLLOW_53_in_condition427);  
                    stream_53.add(char_literal24);


                    pushFollow(FOLLOW_constraint_in_condition429);
                    constraint25=constraint();

                    state._fsp--;

                    stream_constraint.add(constraint25.getTree());

                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:37: ( ',' constraint )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==51) ) {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1==Identifier) ) {
                                int LA11_3 = input.LA(3);

                                if ( ((LA11_3 >= ADV_IDENT && LA11_3 <= WS)||(LA11_3 >= 50 && LA11_3 <= 52)||(LA11_3 >= 54 && LA11_3 <= 75)||(LA11_3 >= 77 && LA11_3 <= 88)||(LA11_3 >= 90 && LA11_3 <= 92)) ) {
                                    alt11=1;
                                }


                            }
                            else if ( ((LA11_1 >= ADV_IDENT && LA11_1 <= DIGIT)||(LA11_1 >= Group && LA11_1 <= INT)||(LA11_1 >= Import_item && LA11_1 <= WS)||LA11_1==50||LA11_1==52||(LA11_1 >= 54 && LA11_1 <= 75)||(LA11_1 >= 77 && LA11_1 <= 88)||(LA11_1 >= 90 && LA11_1 <= 92)) ) {
                                alt11=1;
                            }


                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:38: ',' constraint
                    	    {
                    	    char_literal26=(CommonToken)match(input,51,FOLLOW_51_in_condition432);  
                    	    stream_51.add(char_literal26);


                    	    pushFollow(FOLLOW_constraint_in_condition434);
                    	    constraint27=constraint();

                    	    state._fsp--;

                    	    stream_constraint.add(constraint27.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:55: ( ',' assignment )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==51) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:95:56: ',' assignment
                    	    {
                    	    char_literal28=(CommonToken)match(input,51,FOLLOW_51_in_condition439);  
                    	    stream_51.add(char_literal28);


                    	    pushFollow(FOLLOW_assignment_in_condition441);
                    	    assignment29=assignment();

                    	    state._fsp--;

                    	    stream_assignment.add(assignment29.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }


            EOL30=(CommonToken)match(input,EOL,FOLLOW_EOL_in_condition448);  
            stream_EOL.add(EOL30);


            // AST REWRITE
            // elements: query, Identifier, constraint, assignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 96:3: -> ^( Condition query Identifier ( constraint )* ( assignment )* )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:96:6: ^( Condition query Identifier ( constraint )* ( assignment )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Condition, "Condition")
                , root_1);

                adaptor.addChild(root_1, stream_query.nextTree());

                adaptor.addChild(root_1, 
                stream_Identifier.nextNode()
                );

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:96:35: ( constraint )*
                while ( stream_constraint.hasNext() ) {
                    adaptor.addChild(root_1, stream_constraint.nextTree());

                }
                stream_constraint.reset();

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:96:47: ( assignment )*
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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:99:1: query : ( 'cell' | 'entry' | 'label' | 'category' );
    public final crl_gramParser.query_return query() throws RecognitionException {
        crl_gramParser.query_return retval = new crl_gramParser.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set31=null;

        CommonTree set31_tree=null;

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:100:2: ( 'cell' | 'entry' | 'label' | 'category' )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set31=(CommonToken)input.LT(1);

            if ( (input.LA(1) >= 59 && input.LA(1) <= 60)||input.LA(1)==62||input.LA(1)==65 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set31)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
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
        return retval;
    }
    // $ANTLR end "query"


    public static class no_condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "no_condition"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:103:1: no_condition : no_query ( ':' constraint ( ',' constraint )* )? EOL -> ^( No_condition no_query ( constraint )* ) ;
    public final crl_gramParser.no_condition_return no_condition() throws RecognitionException {
        crl_gramParser.no_condition_return retval = new crl_gramParser.no_condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken char_literal33=null;
        CommonToken char_literal35=null;
        CommonToken EOL37=null;
        crl_gramParser.no_query_return no_query32 =null;

        crl_gramParser.constraint_return constraint34 =null;

        crl_gramParser.constraint_return constraint36 =null;


        CommonTree char_literal33_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree EOL37_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_no_query=new RewriteRuleSubtreeStream(adaptor,"rule no_query");
        RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:2: ( no_query ( ':' constraint ( ',' constraint )* )? EOL -> ^( No_condition no_query ( constraint )* ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:4: no_query ( ':' constraint ( ',' constraint )* )? EOL
            {
            pushFollow(FOLLOW_no_query_in_no_condition497);
            no_query32=no_query();

            state._fsp--;

            stream_no_query.add(no_query32.getTree());

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:13: ( ':' constraint ( ',' constraint )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==53) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:14: ':' constraint ( ',' constraint )*
                    {
                    char_literal33=(CommonToken)match(input,53,FOLLOW_53_in_no_condition500);  
                    stream_53.add(char_literal33);


                    pushFollow(FOLLOW_constraint_in_no_condition502);
                    constraint34=constraint();

                    state._fsp--;

                    stream_constraint.add(constraint34.getTree());

                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:29: ( ',' constraint )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==51) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:30: ',' constraint
                    	    {
                    	    char_literal35=(CommonToken)match(input,51,FOLLOW_51_in_no_condition505);  
                    	    stream_51.add(char_literal35);


                    	    pushFollow(FOLLOW_constraint_in_no_condition507);
                    	    constraint36=constraint();

                    	    state._fsp--;

                    	    stream_constraint.add(constraint36.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }


            EOL37=(CommonToken)match(input,EOL,FOLLOW_EOL_in_no_condition514);  
            stream_EOL.add(EOL37);


            // AST REWRITE
            // elements: no_query, constraint
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 104:54: -> ^( No_condition no_query ( constraint )* )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:57: ^( No_condition no_query ( constraint )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(No_condition, "No_condition")
                , root_1);

                adaptor.addChild(root_1, stream_no_query.nextTree());

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:104:81: ( constraint )*
                while ( stream_constraint.hasNext() ) {
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
        return retval;
    }
    // $ANTLR end "no_condition"


    public static class no_query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "no_query"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:107:1: no_query : ( 'no cells' | 'no labels' | 'no entries' | 'no categories' );
    public final crl_gramParser.no_query_return no_query() throws RecognitionException {
        crl_gramParser.no_query_return retval = new crl_gramParser.no_query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set38=null;

        CommonTree set38_tree=null;

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:108:2: ( 'no cells' | 'no labels' | 'no entries' | 'no categories' )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set38=(CommonToken)input.LT(1);

            if ( (input.LA(1) >= 70 && input.LA(1) <= 73) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set38)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
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
        return retval;
    }
    // $ANTLR end "no_query"


    public static class constraint_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constraint"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:111:1: constraint : j_expr -> ^( Constraint j_expr ) ;
    public final crl_gramParser.constraint_return constraint() throws RecognitionException {
        crl_gramParser.constraint_return retval = new crl_gramParser.constraint_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.j_expr_return j_expr39 =null;


        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:112:2: ( j_expr -> ^( Constraint j_expr ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:112:4: j_expr
            {
            pushFollow(FOLLOW_j_expr_in_constraint555);
            j_expr39=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr39.getTree());

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
            // 112:11: -> ^( Constraint j_expr )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:112:14: ^( Constraint j_expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Constraint, "Constraint")
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
    // $ANTLR end "constraint"


    public static class assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignment"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:115:1: assignment : Identifier ':' j_expr -> ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) ) ;
    public final crl_gramParser.assignment_return assignment() throws RecognitionException {
        crl_gramParser.assignment_return retval = new crl_gramParser.assignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken Identifier40=null;
        CommonToken char_literal41=null;
        crl_gramParser.j_expr_return j_expr42 =null;


        CommonTree Identifier40_tree=null;
        CommonTree char_literal41_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:116:2: ( Identifier ':' j_expr -> ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:116:4: Identifier ':' j_expr
            {
            Identifier40=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_assignment575);  
            stream_Identifier.add(Identifier40);


            char_literal41=(CommonToken)match(input,53,FOLLOW_53_in_assignment577);  
            stream_53.add(char_literal41);


            pushFollow(FOLLOW_j_expr_in_assignment579);
            j_expr42=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr42.getTree());

            // AST REWRITE
            // elements: Identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 116:26: -> ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:116:29: ^( Assignment ^( IDENT Identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Assignment, "Assignment")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:116:42: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:116:62: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "assignment"


    public static class j_expr_return extends ParserRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "j_expr"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:119:1: j_expr returns [String value] : (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+ ;
    public final crl_gramParser.j_expr_return j_expr() throws RecognitionException {
        crl_gramParser.j_expr_return retval = new crl_gramParser.j_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken i=null;

        CommonTree i_tree=null;

         retval.value =""; 
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:121:2: ( (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+ )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:121:5: (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:121:5: (i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= ADV_IDENT && LA16_0 <= DIGIT)||(LA16_0 >= Group && LA16_0 <= WS)||LA16_0==50||LA16_0==52||(LA16_0 >= 54 && LA16_0 <= 75)||(LA16_0 >= 77 && LA16_0 <= 88)||(LA16_0 >= 90 && LA16_0 <= 92)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:121:7: i=~ ( ',' | '\"' | ':' | 'to' | 'of' | EOL )
            	    {
            	    i=(CommonToken)input.LT(1);

            	    if ( (input.LA(1) >= ADV_IDENT && input.LA(1) <= DIGIT)||(input.LA(1) >= Group && input.LA(1) <= WS)||input.LA(1)==50||input.LA(1)==52||(input.LA(1) >= 54 && input.LA(1) <= 75)||(input.LA(1) >= 77 && input.LA(1) <= 88)||(input.LA(1) >= 90 && input.LA(1) <= 92) ) {
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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


    public static class action_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:124:1: action : action_ EOL -> action_ ;
    public final crl_gramParser.action_return action() throws RecognitionException {
        crl_gramParser.action_return retval = new crl_gramParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken EOL44=null;
        crl_gramParser.action__return action_43 =null;


        CommonTree EOL44_tree=null;
        RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
        RewriteRuleSubtreeStream stream_action_=new RewriteRuleSubtreeStream(adaptor,"rule action_");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:125:2: ( action_ EOL -> action_ )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:125:4: action_ EOL
            {
            pushFollow(FOLLOW_action__in_action652);
            action_43=action_();

            state._fsp--;

            stream_action_.add(action_43.getTree());

            EOL44=(CommonToken)match(input,EOL,FOLLOW_EOL_in_action654);  
            stream_EOL.add(EOL44);


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
            // 125:16: -> action_
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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:128:1: action_ : ( set_mark | set_text | set_indent | set_value | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update );
    public final crl_gramParser.action__return action_() throws RecognitionException {
        crl_gramParser.action__return retval = new crl_gramParser.action__return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        crl_gramParser.set_mark_return set_mark45 =null;

        crl_gramParser.set_text_return set_text46 =null;

        crl_gramParser.set_indent_return set_indent47 =null;

        crl_gramParser.set_value_return set_value48 =null;

        crl_gramParser.split_return split49 =null;

        crl_gramParser.merge_return merge50 =null;

        crl_gramParser.new_label_return new_label51 =null;

        crl_gramParser.add_label_return add_label52 =null;

        crl_gramParser.set_category_return set_category53 =null;

        crl_gramParser.set_parent_return set_parent54 =null;

        crl_gramParser.new_entry_return new_entry55 =null;

        crl_gramParser.group_return group56 =null;

        crl_gramParser.c_print_return c_print57 =null;

        crl_gramParser.update_return update58 =null;



        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:129:2: ( set_mark | set_text | set_indent | set_value | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update )
            int alt17=14;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt17=1;
                }
                break;
            case 85:
                {
                alt17=2;
                }
                break;
            case 82:
                {
                alt17=3;
                }
                break;
            case 86:
                {
                alt17=4;
                }
                break;
            case 87:
                {
                alt17=5;
                }
                break;
            case 67:
                {
                alt17=6;
                }
                break;
            case 69:
                {
                alt17=7;
                }
                break;
            case 57:
                {
                alt17=8;
                }
                break;
            case 81:
                {
                alt17=9;
                }
                break;
            case 84:
                {
                alt17=10;
                }
                break;
            case 68:
                {
                alt17=11;
                }
                break;
            case 63:
                {
                alt17=12;
                }
                break;
            case 78:
            case 79:
                {
                alt17=13;
                }
                break;
            case 90:
                {
                alt17=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:129:4: set_mark
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_mark_in_action_670);
                    set_mark45=set_mark();

                    state._fsp--;

                    adaptor.addChild(root_0, set_mark45.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:130:4: set_text
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_text_in_action_675);
                    set_text46=set_text();

                    state._fsp--;

                    adaptor.addChild(root_0, set_text46.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:131:4: set_indent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_indent_in_action_680);
                    set_indent47=set_indent();

                    state._fsp--;

                    adaptor.addChild(root_0, set_indent47.getTree());

                    }
                    break;
                case 4 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:132:4: set_value
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_value_in_action_685);
                    set_value48=set_value();

                    state._fsp--;

                    adaptor.addChild(root_0, set_value48.getTree());

                    }
                    break;
                case 5 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:133:4: split
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_split_in_action_690);
                    split49=split();

                    state._fsp--;

                    adaptor.addChild(root_0, split49.getTree());

                    }
                    break;
                case 6 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:134:4: merge
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_merge_in_action_695);
                    merge50=merge();

                    state._fsp--;

                    adaptor.addChild(root_0, merge50.getTree());

                    }
                    break;
                case 7 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:135:4: new_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_new_label_in_action_700);
                    new_label51=new_label();

                    state._fsp--;

                    adaptor.addChild(root_0, new_label51.getTree());

                    }
                    break;
                case 8 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:136:4: add_label
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_add_label_in_action_705);
                    add_label52=add_label();

                    state._fsp--;

                    adaptor.addChild(root_0, add_label52.getTree());

                    }
                    break;
                case 9 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:137:4: set_category
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_category_in_action_710);
                    set_category53=set_category();

                    state._fsp--;

                    adaptor.addChild(root_0, set_category53.getTree());

                    }
                    break;
                case 10 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:138:4: set_parent
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_set_parent_in_action_715);
                    set_parent54=set_parent();

                    state._fsp--;

                    adaptor.addChild(root_0, set_parent54.getTree());

                    }
                    break;
                case 11 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:139:4: new_entry
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_new_entry_in_action_720);
                    new_entry55=new_entry();

                    state._fsp--;

                    adaptor.addChild(root_0, new_entry55.getTree());

                    }
                    break;
                case 12 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:140:4: group
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_group_in_action_725);
                    group56=group();

                    state._fsp--;

                    adaptor.addChild(root_0, group56.getTree());

                    }
                    break;
                case 13 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:141:4: c_print
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_c_print_in_action_730);
                    c_print57=c_print();

                    state._fsp--;

                    adaptor.addChild(root_0, c_print57.getTree());

                    }
                    break;
                case 14 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:142:4: update
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_update_in_action_735);
                    update58=update();

                    state._fsp--;

                    adaptor.addChild(root_0, update58.getTree());

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
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:145:1: set_mark : 'set mark' j_expr 'to' Identifier -> ^( Set_mark ^( IDENT Identifier ) ^( STRING j_expr ) ) ;
    public final crl_gramParser.set_mark_return set_mark() throws RecognitionException {
        crl_gramParser.set_mark_return retval = new crl_gramParser.set_mark_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal59=null;
        CommonToken string_literal61=null;
        CommonToken Identifier62=null;
        crl_gramParser.j_expr_return j_expr60 =null;


        CommonTree string_literal59_tree=null;
        CommonTree string_literal61_tree=null;
        CommonTree Identifier62_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:146:2: ( 'set mark' j_expr 'to' Identifier -> ^( Set_mark ^( IDENT Identifier ) ^( STRING j_expr ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:146:4: 'set mark' j_expr 'to' Identifier
            {
            string_literal59=(CommonToken)match(input,83,FOLLOW_83_in_set_mark747);  
            stream_83.add(string_literal59);


            pushFollow(FOLLOW_j_expr_in_set_mark749);
            j_expr60=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr60.getTree());

            string_literal61=(CommonToken)match(input,89,FOLLOW_89_in_set_mark751);  
            stream_89.add(string_literal61);


            Identifier62=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_set_mark753);  
            stream_Identifier.add(Identifier62);


            // AST REWRITE
            // elements: Identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 146:38: -> ^( Set_mark ^( IDENT Identifier ) ^( STRING j_expr ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:146:41: ^( Set_mark ^( IDENT Identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_mark, "Set_mark")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:146:52: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:146:72: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "set_mark"


    public static class set_text_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_text"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:149:1: set_text : 'set text' j_expr 'to' Identifier -> ^( Set_text ^( IDENT Identifier ) ^( STRING j_expr ) ) ;
    public final crl_gramParser.set_text_return set_text() throws RecognitionException {
        crl_gramParser.set_text_return retval = new crl_gramParser.set_text_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal63=null;
        CommonToken string_literal65=null;
        CommonToken Identifier66=null;
        crl_gramParser.j_expr_return j_expr64 =null;


        CommonTree string_literal63_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree Identifier66_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:150:2: ( 'set text' j_expr 'to' Identifier -> ^( Set_text ^( IDENT Identifier ) ^( STRING j_expr ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:150:4: 'set text' j_expr 'to' Identifier
            {
            string_literal63=(CommonToken)match(input,85,FOLLOW_85_in_set_text783);  
            stream_85.add(string_literal63);


            pushFollow(FOLLOW_j_expr_in_set_text785);
            j_expr64=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr64.getTree());

            string_literal65=(CommonToken)match(input,89,FOLLOW_89_in_set_text787);  
            stream_89.add(string_literal65);


            Identifier66=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_set_text789);  
            stream_Identifier.add(Identifier66);


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
            // 150:38: -> ^( Set_text ^( IDENT Identifier ) ^( STRING j_expr ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:150:41: ^( Set_text ^( IDENT Identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_text, "Set_text")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:150:52: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:150:72: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "set_text"


    public static class set_indent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_indent"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:153:1: set_indent : 'set indent' J_int_literal 'to' Identifier -> ^( Set_indent ^( IDENT Identifier ) ^( INT J_int_literal ) ) ;
    public final crl_gramParser.set_indent_return set_indent() throws RecognitionException {
        crl_gramParser.set_indent_return retval = new crl_gramParser.set_indent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal67=null;
        CommonToken J_int_literal68=null;
        CommonToken string_literal69=null;
        CommonToken Identifier70=null;

        CommonTree string_literal67_tree=null;
        CommonTree J_int_literal68_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree Identifier70_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:154:2: ( 'set indent' J_int_literal 'to' Identifier -> ^( Set_indent ^( IDENT Identifier ) ^( INT J_int_literal ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:154:4: 'set indent' J_int_literal 'to' Identifier
            {
            string_literal67=(CommonToken)match(input,82,FOLLOW_82_in_set_indent819);  
            stream_82.add(string_literal67);


            J_int_literal68=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_set_indent821);  
            stream_J_int_literal.add(J_int_literal68);


            string_literal69=(CommonToken)match(input,89,FOLLOW_89_in_set_indent823);  
            stream_89.add(string_literal69);


            Identifier70=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_set_indent825);  
            stream_Identifier.add(Identifier70);


            // AST REWRITE
            // elements: Identifier, J_int_literal
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 154:47: -> ^( Set_indent ^( IDENT Identifier ) ^( INT J_int_literal ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:154:50: ^( Set_indent ^( IDENT Identifier ) ^( INT J_int_literal ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_indent, "Set_indent")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:154:63: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:154:83: ^( INT J_int_literal )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(INT, "INT")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "set_indent"


    public static class split_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:157:1: split : 'split' Identifier -> ^( Split ^( IDENT Identifier ) ) ;
    public final crl_gramParser.split_return split() throws RecognitionException {
        crl_gramParser.split_return retval = new crl_gramParser.split_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal71=null;
        CommonToken Identifier72=null;

        CommonTree string_literal71_tree=null;
        CommonTree Identifier72_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:158:2: ( 'split' Identifier -> ^( Split ^( IDENT Identifier ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:158:4: 'split' Identifier
            {
            string_literal71=(CommonToken)match(input,87,FOLLOW_87_in_split855);  
            stream_87.add(string_literal71);


            Identifier72=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_split857);  
            stream_Identifier.add(Identifier72);


            // AST REWRITE
            // elements: Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 158:23: -> ^( Split ^( IDENT Identifier ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:158:26: ^( Split ^( IDENT Identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Split, "Split")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:158:34: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "split"


    public static class merge_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "merge"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:161:1: merge : 'merge' Identifier 'with' Identifier -> ^( Merge ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) ) ;
    public final crl_gramParser.merge_return merge() throws RecognitionException {
        crl_gramParser.merge_return retval = new crl_gramParser.merge_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal73=null;
        CommonToken Identifier74=null;
        CommonToken string_literal75=null;
        CommonToken Identifier76=null;

        CommonTree string_literal73_tree=null;
        CommonTree Identifier74_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree Identifier76_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:162:2: ( 'merge' Identifier 'with' Identifier -> ^( Merge ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:162:4: 'merge' Identifier 'with' Identifier
            {
            string_literal73=(CommonToken)match(input,67,FOLLOW_67_in_merge881);  
            stream_67.add(string_literal73);


            Identifier74=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_merge883);  
            stream_Identifier.add(Identifier74);


            string_literal75=(CommonToken)match(input,92,FOLLOW_92_in_merge885);  
            stream_92.add(string_literal75);


            Identifier76=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_merge887);  
            stream_Identifier.add(Identifier76);


            // AST REWRITE
            // elements: Identifier, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 162:41: -> ^( Merge ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:162:44: ^( Merge ^( IDENT1 Identifier ) ^( IDENT2 Identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Merge, "Merge")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:162:52: ^( IDENT1 Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT1, "IDENT1")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:162:73: ^( IDENT2 Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT2, "IDENT2")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "merge"


    public static class new_entry_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "new_entry"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:165:1: new_entry : 'new entry' Identifier ( 'as' j_expr )? -> ^( New_entry ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) ;
    public final crl_gramParser.new_entry_return new_entry() throws RecognitionException {
        crl_gramParser.new_entry_return retval = new crl_gramParser.new_entry_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal77=null;
        CommonToken Identifier78=null;
        CommonToken string_literal79=null;
        crl_gramParser.j_expr_return j_expr80 =null;


        CommonTree string_literal77_tree=null;
        CommonTree Identifier78_tree=null;
        CommonTree string_literal79_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:2: ( 'new entry' Identifier ( 'as' j_expr )? -> ^( New_entry ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:4: 'new entry' Identifier ( 'as' j_expr )?
            {
            string_literal77=(CommonToken)match(input,68,FOLLOW_68_in_new_entry917);  
            stream_68.add(string_literal77);


            Identifier78=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_new_entry919);  
            stream_Identifier.add(Identifier78);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:27: ( 'as' j_expr )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==58) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:28: 'as' j_expr
                    {
                    string_literal79=(CommonToken)match(input,58,FOLLOW_58_in_new_entry922);  
                    stream_58.add(string_literal79);


                    pushFollow(FOLLOW_j_expr_in_new_entry924);
                    j_expr80=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr80.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: Identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 166:42: -> ^( New_entry ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:45: ^( New_entry ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(New_entry, "New_entry")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:57: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:77: ( ^( STRING j_expr ) )?
                if ( stream_j_expr.hasNext() ) {
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:166:77: ^( STRING j_expr )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(STRING, "STRING")
                    , root_2);

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
        return retval;
    }
    // $ANTLR end "new_entry"


    public static class set_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_value"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:169:1: set_value : 'set value' j_expr 'to' advanced_identifier -> ^( Set_value ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) ) ;
    public final crl_gramParser.set_value_return set_value() throws RecognitionException {
        crl_gramParser.set_value_return retval = new crl_gramParser.set_value_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal81=null;
        CommonToken string_literal83=null;
        crl_gramParser.j_expr_return j_expr82 =null;

        crl_gramParser.advanced_identifier_return advanced_identifier84 =null;


        CommonTree string_literal81_tree=null;
        CommonTree string_literal83_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:170:2: ( 'set value' j_expr 'to' advanced_identifier -> ^( Set_value ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:170:4: 'set value' j_expr 'to' advanced_identifier
            {
            string_literal81=(CommonToken)match(input,86,FOLLOW_86_in_set_value958);  
            stream_86.add(string_literal81);


            pushFollow(FOLLOW_j_expr_in_set_value960);
            j_expr82=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr82.getTree());

            string_literal83=(CommonToken)match(input,89,FOLLOW_89_in_set_value962);  
            stream_89.add(string_literal83);


            pushFollow(FOLLOW_advanced_identifier_in_set_value964);
            advanced_identifier84=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier84.getTree());

            // AST REWRITE
            // elements: j_expr, advanced_identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 170:48: -> ^( Set_value ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:170:51: ^( Set_value ^( ADV_IDENT advanced_identifier ) ^( STRING j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_value, "Set_value")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:170:63: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:170:96: ^( STRING j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STRING, "STRING")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "set_value"


    public static class set_category_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_category"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:173:1: set_category : 'set category' j_expr 'to' advanced_identifier -> ^( Set_category ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) ) ;
    public final crl_gramParser.set_category_return set_category() throws RecognitionException {
        crl_gramParser.set_category_return retval = new crl_gramParser.set_category_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal85=null;
        CommonToken string_literal87=null;
        crl_gramParser.j_expr_return j_expr86 =null;

        crl_gramParser.advanced_identifier_return advanced_identifier88 =null;


        CommonTree string_literal85_tree=null;
        CommonTree string_literal87_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:174:2: ( 'set category' j_expr 'to' advanced_identifier -> ^( Set_category ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:174:4: 'set category' j_expr 'to' advanced_identifier
            {
            string_literal85=(CommonToken)match(input,81,FOLLOW_81_in_set_category994);  
            stream_81.add(string_literal85);


            pushFollow(FOLLOW_j_expr_in_set_category996);
            j_expr86=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr86.getTree());

            string_literal87=(CommonToken)match(input,89,FOLLOW_89_in_set_category998);  
            stream_89.add(string_literal87);


            pushFollow(FOLLOW_advanced_identifier_in_set_category1000);
            advanced_identifier88=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier88.getTree());

            // AST REWRITE
            // elements: advanced_identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 174:51: -> ^( Set_category ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:174:54: ^( Set_category ^( ADV_IDENT advanced_identifier ) ^( CATEGORY j_expr ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_category, "Set_category")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:174:69: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:174:102: ^( CATEGORY j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CATEGORY, "CATEGORY")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "set_category"


    public static class set_parent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set_parent"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:177:1: set_parent : 'set parent' advanced_identifier 'to' advanced_identifier -> ^( Set_parent ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) ;
    public final crl_gramParser.set_parent_return set_parent() throws RecognitionException {
        crl_gramParser.set_parent_return retval = new crl_gramParser.set_parent_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal89=null;
        CommonToken string_literal91=null;
        crl_gramParser.advanced_identifier_return advanced_identifier90 =null;

        crl_gramParser.advanced_identifier_return advanced_identifier92 =null;


        CommonTree string_literal89_tree=null;
        CommonTree string_literal91_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:178:2: ( 'set parent' advanced_identifier 'to' advanced_identifier -> ^( Set_parent ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:178:4: 'set parent' advanced_identifier 'to' advanced_identifier
            {
            string_literal89=(CommonToken)match(input,84,FOLLOW_84_in_set_parent1030);  
            stream_84.add(string_literal89);


            pushFollow(FOLLOW_advanced_identifier_in_set_parent1032);
            advanced_identifier90=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier90.getTree());

            string_literal91=(CommonToken)match(input,89,FOLLOW_89_in_set_parent1034);  
            stream_89.add(string_literal91);


            pushFollow(FOLLOW_advanced_identifier_in_set_parent1036);
            advanced_identifier92=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier92.getTree());

            // AST REWRITE
            // elements: advanced_identifier, advanced_identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:62: -> ^( Set_parent ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:178:65: ^( Set_parent ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Set_parent, "Set_parent")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:178:78: ^( ADV_IDENT1 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT1, "ADV_IDENT1")
                , root_2);

                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:178:112: ^( ADV_IDENT2 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT2, "ADV_IDENT2")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "set_parent"


    public static class group_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:181:1: group : 'group' advanced_identifier 'with' advanced_identifier -> ^( Group ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) ;
    public final crl_gramParser.group_return group() throws RecognitionException {
        crl_gramParser.group_return retval = new crl_gramParser.group_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal93=null;
        CommonToken string_literal95=null;
        crl_gramParser.advanced_identifier_return advanced_identifier94 =null;

        crl_gramParser.advanced_identifier_return advanced_identifier96 =null;


        CommonTree string_literal93_tree=null;
        CommonTree string_literal95_tree=null;
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:182:2: ( 'group' advanced_identifier 'with' advanced_identifier -> ^( Group ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:182:4: 'group' advanced_identifier 'with' advanced_identifier
            {
            string_literal93=(CommonToken)match(input,63,FOLLOW_63_in_group1066);  
            stream_63.add(string_literal93);


            pushFollow(FOLLOW_advanced_identifier_in_group1068);
            advanced_identifier94=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier94.getTree());

            string_literal95=(CommonToken)match(input,92,FOLLOW_92_in_group1070);  
            stream_92.add(string_literal95);


            pushFollow(FOLLOW_advanced_identifier_in_group1072);
            advanced_identifier96=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier96.getTree());

            // AST REWRITE
            // elements: advanced_identifier, advanced_identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 182:59: -> ^( Group ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:182:62: ^( Group ^( ADV_IDENT1 advanced_identifier ) ^( ADV_IDENT2 advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Group, "Group")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:182:70: ^( ADV_IDENT1 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT1, "ADV_IDENT1")
                , root_2);

                adaptor.addChild(root_2, stream_advanced_identifier.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:182:104: ^( ADV_IDENT2 advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT2, "ADV_IDENT2")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "group"


    public static class add_label_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add_label"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:185:1: add_label : 'add label' j_expr ( 'of' j_expr )? 'to' advanced_identifier -> ^( Add_label ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) ) ;
    public final crl_gramParser.add_label_return add_label() throws RecognitionException {
        crl_gramParser.add_label_return retval = new crl_gramParser.add_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal97=null;
        CommonToken string_literal99=null;
        CommonToken string_literal101=null;
        crl_gramParser.j_expr_return j_expr98 =null;

        crl_gramParser.j_expr_return j_expr100 =null;

        crl_gramParser.advanced_identifier_return advanced_identifier102 =null;


        CommonTree string_literal97_tree=null;
        CommonTree string_literal99_tree=null;
        CommonTree string_literal101_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:2: ( 'add label' j_expr ( 'of' j_expr )? 'to' advanced_identifier -> ^( Add_label ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:4: 'add label' j_expr ( 'of' j_expr )? 'to' advanced_identifier
            {
            string_literal97=(CommonToken)match(input,57,FOLLOW_57_in_add_label1102);  
            stream_57.add(string_literal97);


            pushFollow(FOLLOW_j_expr_in_add_label1104);
            j_expr98=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr98.getTree());

            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:23: ( 'of' j_expr )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==76) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:24: 'of' j_expr
                    {
                    string_literal99=(CommonToken)match(input,76,FOLLOW_76_in_add_label1107);  
                    stream_76.add(string_literal99);


                    pushFollow(FOLLOW_j_expr_in_add_label1109);
                    j_expr100=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr100.getTree());

                    }
                    break;

            }


            string_literal101=(CommonToken)match(input,89,FOLLOW_89_in_add_label1113);  
            stream_89.add(string_literal101);


            pushFollow(FOLLOW_advanced_identifier_in_add_label1115);
            advanced_identifier102=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier102.getTree());

            // AST REWRITE
            // elements: j_expr, advanced_identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 186:63: -> ^( Add_label ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:66: ^( Add_label ^( LABEL j_expr ) ( ^( CATEGORY j_expr ) )? ^( ADV_IDENT advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Add_label, "Add_label")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:78: ^( LABEL j_expr )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(LABEL, "LABEL")
                , root_2);

                adaptor.addChild(root_2, stream_j_expr.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:94: ( ^( CATEGORY j_expr ) )?
                if ( stream_j_expr.hasNext() ) {
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:94: ^( CATEGORY j_expr )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(CATEGORY, "CATEGORY")
                    , root_2);

                    adaptor.addChild(root_2, stream_j_expr.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_j_expr.reset();

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:186:114: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "add_label"


    public static class new_label_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "new_label"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:189:1: new_label : 'new label' Identifier ( 'as' j_expr )? -> ^( New_label ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) ;
    public final crl_gramParser.new_label_return new_label() throws RecognitionException {
        crl_gramParser.new_label_return retval = new crl_gramParser.new_label_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal103=null;
        CommonToken Identifier104=null;
        CommonToken string_literal105=null;
        crl_gramParser.j_expr_return j_expr106 =null;


        CommonTree string_literal103_tree=null;
        CommonTree Identifier104_tree=null;
        CommonTree string_literal105_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:2: ( 'new label' Identifier ( 'as' j_expr )? -> ^( New_label ^( IDENT Identifier ) ( ^( STRING j_expr ) )? ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:4: 'new label' Identifier ( 'as' j_expr )?
            {
            string_literal103=(CommonToken)match(input,69,FOLLOW_69_in_new_label1152);  
            stream_69.add(string_literal103);


            Identifier104=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_new_label1154);  
            stream_Identifier.add(Identifier104);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:27: ( 'as' j_expr )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==58) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:28: 'as' j_expr
                    {
                    string_literal105=(CommonToken)match(input,58,FOLLOW_58_in_new_label1157);  
                    stream_58.add(string_literal105);


                    pushFollow(FOLLOW_j_expr_in_new_label1159);
                    j_expr106=j_expr();

                    state._fsp--;

                    stream_j_expr.add(j_expr106.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: Identifier, j_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 190:42: -> ^( New_label ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:45: ^( New_label ^( IDENT Identifier ) ( ^( STRING j_expr ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(New_label, "New_label")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:57: ^( IDENT Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IDENT, "IDENT")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:77: ( ^( STRING j_expr ) )?
                if ( stream_j_expr.hasNext() ) {
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:190:77: ^( STRING j_expr )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(STRING, "STRING")
                    , root_2);

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
        return retval;
    }
    // $ANTLR end "new_label"


    public static class update_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "update"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:193:1: update : 'update' advanced_identifier -> ^( Update ^( ADV_IDENT advanced_identifier ) ) ;
    public final crl_gramParser.update_return update() throws RecognitionException {
        crl_gramParser.update_return retval = new crl_gramParser.update_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal107=null;
        crl_gramParser.advanced_identifier_return advanced_identifier108 =null;


        CommonTree string_literal107_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleSubtreeStream stream_advanced_identifier=new RewriteRuleSubtreeStream(adaptor,"rule advanced_identifier");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:194:2: ( 'update' advanced_identifier -> ^( Update ^( ADV_IDENT advanced_identifier ) ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:194:4: 'update' advanced_identifier
            {
            string_literal107=(CommonToken)match(input,90,FOLLOW_90_in_update1192);  
            stream_90.add(string_literal107);


            pushFollow(FOLLOW_advanced_identifier_in_update1194);
            advanced_identifier108=advanced_identifier();

            state._fsp--;

            stream_advanced_identifier.add(advanced_identifier108.getTree());

            // AST REWRITE
            // elements: advanced_identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 194:33: -> ^( Update ^( ADV_IDENT advanced_identifier ) )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:194:36: ^( Update ^( ADV_IDENT advanced_identifier ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(Update, "Update")
                , root_1);

                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:194:45: ^( ADV_IDENT advanced_identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ADV_IDENT, "ADV_IDENT")
                , root_2);

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
        return retval;
    }
    // $ANTLR end "update"


    public static class c_print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "c_print"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:197:1: c_print : ( 'print' | 'printf' ) j_expr -> ^( Print j_expr ) ;
    public final crl_gramParser.c_print_return c_print() throws RecognitionException {
        crl_gramParser.c_print_return retval = new crl_gramParser.c_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken string_literal109=null;
        CommonToken string_literal110=null;
        crl_gramParser.j_expr_return j_expr111 =null;


        CommonTree string_literal109_tree=null;
        CommonTree string_literal110_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");
        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:198:2: ( ( 'print' | 'printf' ) j_expr -> ^( Print j_expr ) )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:198:4: ( 'print' | 'printf' ) j_expr
            {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:198:4: ( 'print' | 'printf' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==78) ) {
                alt21=1;
            }
            else if ( (LA21_0==79) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:198:5: 'print'
                    {
                    string_literal109=(CommonToken)match(input,78,FOLLOW_78_in_c_print1219);  
                    stream_78.add(string_literal109);


                    }
                    break;
                case 2 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:198:13: 'printf'
                    {
                    string_literal110=(CommonToken)match(input,79,FOLLOW_79_in_c_print1221);  
                    stream_79.add(string_literal110);


                    }
                    break;

            }


            pushFollow(FOLLOW_j_expr_in_c_print1224);
            j_expr111=j_expr();

            state._fsp--;

            stream_j_expr.add(j_expr111.getTree());

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
            // 198:30: -> ^( Print j_expr )
            {
                // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:198:33: ^( Print j_expr )
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


    public static class advanced_identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "advanced_identifier"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:201:1: advanced_identifier : Identifier ( '.' query ( index )? )? ;
    public final crl_gramParser.advanced_identifier_return advanced_identifier() throws RecognitionException {
        crl_gramParser.advanced_identifier_return retval = new crl_gramParser.advanced_identifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken Identifier112=null;
        CommonToken char_literal113=null;
        crl_gramParser.query_return query114 =null;

        crl_gramParser.index_return index115 =null;


        CommonTree Identifier112_tree=null;
        CommonTree char_literal113_tree=null;

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:202:2: ( Identifier ( '.' query ( index )? )? )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:202:4: Identifier ( '.' query ( index )? )?
            {
            root_0 = (CommonTree)adaptor.nil();


            Identifier112=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_advanced_identifier1244); 
            Identifier112_tree = 
            (CommonTree)adaptor.create(Identifier112)
            ;
            adaptor.addChild(root_0, Identifier112_tree);


            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:202:15: ( '.' query ( index )? )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==52) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:202:16: '.' query ( index )?
                    {
                    char_literal113=(CommonToken)match(input,52,FOLLOW_52_in_advanced_identifier1247); 
                    char_literal113_tree = 
                    (CommonTree)adaptor.create(char_literal113)
                    ;
                    adaptor.addChild(root_0, char_literal113_tree);


                    pushFollow(FOLLOW_query_in_advanced_identifier1249);
                    query114=query();

                    state._fsp--;

                    adaptor.addChild(root_0, query114.getTree());

                    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:202:26: ( index )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==55) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:202:26: index
                            {
                            pushFollow(FOLLOW_index_in_advanced_identifier1251);
                            index115=index();

                            state._fsp--;

                            adaptor.addChild(root_0, index115.getTree());

                            }
                            break;

                    }


                    }
                    break;

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
        return retval;
    }
    // $ANTLR end "advanced_identifier"


    public static class index_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "index"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:222:1: index : '[' J_int_literal ']' -> J_int_literal ;
    public final crl_gramParser.index_return index() throws RecognitionException {
        crl_gramParser.index_return retval = new crl_gramParser.index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken char_literal116=null;
        CommonToken J_int_literal117=null;
        CommonToken char_literal118=null;

        CommonTree char_literal116_tree=null;
        CommonTree J_int_literal117_tree=null;
        CommonTree char_literal118_tree=null;
        RewriteRuleTokenStream stream_J_int_literal=new RewriteRuleTokenStream(adaptor,"token J_int_literal");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:223:2: ( '[' J_int_literal ']' -> J_int_literal )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:223:4: '[' J_int_literal ']'
            {
            char_literal116=(CommonToken)match(input,55,FOLLOW_55_in_index1382);  
            stream_55.add(char_literal116);


            J_int_literal117=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_index1384);  
            stream_J_int_literal.add(J_int_literal117);


            char_literal118=(CommonToken)match(input,56,FOLLOW_56_in_index1386);  
            stream_56.add(char_literal118);


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
            // 223:26: -> J_int_literal
            {
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
        return retval;
    }
    // $ANTLR end "index"


    public static class useless_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "useless"
    // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:240:1: useless : ( 'lock-on-active' | 'no-loop true' | 'no-loop false' );
    public final crl_gramParser.useless_return useless() throws RecognitionException {
        crl_gramParser.useless_return retval = new crl_gramParser.useless_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonToken set119=null;

        CommonTree set119_tree=null;

        try {
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:241:2: ( 'lock-on-active' | 'no-loop true' | 'no-loop false' )
            // C:\\Users\\ZKLN\\Documents\\GitHub\\TabbyXL\\tabbyxl2\\src\\main\\resources\\crl_gram.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set119=(CommonToken)input.LT(1);

            if ( input.LA(1)==66||(input.LA(1) >= 74 && input.LA(1) <= 75) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set119)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
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
        return retval;
    }
    // $ANTLR end "useless"

    // Delegated rules


 

    public static final BitSet FOLLOW_import_stmt_in_crl197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000012001L});
    public static final BitSet FOLLOW_crl_rule_in_crl200 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_import_unit_in_import_stmt233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_import_unit265 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_import_item_in_import_unit275 = new BitSet(new long[]{0x0040000000040000L});
    public static final BitSet FOLLOW_54_in_import_unit279 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_import_unit282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_import_item306 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_import_item311 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_import_item315 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_import_item322 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_import_item324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_crl_rule341 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_J_int_literal_in_crl_rule343 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000C04L});
    public static final BitSet FOLLOW_useless_in_crl_rule345 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule348 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_crl_rule352 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule354 = new BitSet(new long[]{0x5800000000000000L,0x00000000000003C2L});
    public static final BitSet FOLLOW_condition_unit_in_crl_rule359 = new BitSet(new long[]{0x5800000000000000L,0x00000000010003C2L});
    public static final BitSet FOLLOW_88_in_crl_rule364 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_crl_rule366 = new BitSet(new long[]{0x8200000000000000L,0x0000000004FEC038L});
    public static final BitSet FOLLOW_action_in_crl_rule370 = new BitSet(new long[]{0xA200000000000000L,0x0000000004FEC038L});
    public static final BitSet FOLLOW_61_in_crl_rule375 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_EOL_in_crl_rule377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_in_condition_unit409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_condition_in_condition_unit411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_condition422 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_condition424 = new BitSet(new long[]{0x0020000000040000L});
    public static final BitSet FOLLOW_53_in_condition427 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_constraint_in_condition429 = new BitSet(new long[]{0x0008000000040000L});
    public static final BitSet FOLLOW_51_in_condition432 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_constraint_in_condition434 = new BitSet(new long[]{0x0008000000040000L});
    public static final BitSet FOLLOW_51_in_condition439 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_assignment_in_condition441 = new BitSet(new long[]{0x0008000000040000L});
    public static final BitSet FOLLOW_EOL_in_condition448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_query_in_no_condition497 = new BitSet(new long[]{0x0020000000040000L});
    public static final BitSet FOLLOW_53_in_no_condition500 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_constraint_in_no_condition502 = new BitSet(new long[]{0x0008000000040000L});
    public static final BitSet FOLLOW_51_in_no_condition505 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_constraint_in_no_condition507 = new BitSet(new long[]{0x0008000000040000L});
    public static final BitSet FOLLOW_EOL_in_no_condition514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_j_expr_in_constraint555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_assignment575 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_assignment577 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_assignment579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_j_expr623 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF2L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_action__in_action652 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOL_in_action654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_mark_in_action_670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_text_in_action_675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_indent_in_action_680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_value_in_action_685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_in_action_690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_merge_in_action_695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_label_in_action_700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_label_in_action_705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_category_in_action_710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_parent_in_action_715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_new_entry_in_action_720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_in_action_725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_c_print_in_action_730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_update_in_action_735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_set_mark747 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_mark749 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_set_mark751 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_set_mark753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_set_text783 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_text785 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_set_text787 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_set_text789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_set_indent819 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_J_int_literal_in_set_indent821 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_set_indent823 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_set_indent825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_split855 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_split857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_merge881 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_merge883 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_merge885 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_merge887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_new_entry917 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_new_entry919 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_new_entry922 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_new_entry924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_set_value958 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_value960 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_set_value962 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_value964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_set_category994 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_set_category996 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_set_category998 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_category1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_set_parent1030 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_parent1032 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_set_parent1034 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_set_parent1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_group1066 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_group1068 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_group1070 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_group1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_add_label1102 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_add_label1104 = new BitSet(new long[]{0x0000000000000000L,0x0000000002001000L});
    public static final BitSet FOLLOW_76_in_add_label1107 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_add_label1109 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_add_label1113 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_add_label1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_new_label1152 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Identifier_in_new_label1154 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_new_label1157 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_new_label1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_update1192 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_advanced_identifier_in_update1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_c_print1219 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_79_in_c_print1221 = new BitSet(new long[]{0xFFD5FFFFFFFBFFF0L,0x000000001DFFEFFFL});
    public static final BitSet FOLLOW_j_expr_in_c_print1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_advanced_identifier1244 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_advanced_identifier1247 = new BitSet(new long[]{0x5800000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_advanced_identifier1249 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_index_in_advanced_identifier1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_index1382 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_J_int_literal_in_index1384 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_index1386 = new BitSet(new long[]{0x0000000000000002L});

}