// $ANTLR 3.5.1 C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g 2017-11-14 11:17:14

package ru.icc.cells.ssdc.interpreeter.output;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class crl_gramParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Action", "Actions", "Assignment", 
		"Breackits", "Char_lit", "Condition", "Conditions", "Constraint", "DIGIT", 
		"EOL", "IDENT", "Identifier", "Import_item", "J_Expression", "J_expr", 
		"J_int_literal", "Java_string_expr", "LETTER", "New_label", "Other_literals", 
		"RULES", "SETTING", "Set_mark", "Set_text", "String_lit", "WS", "'\"'", 
		"'*'", "','", "'.'", "':'", "';'", "'add label'", "'as'", "'end'", "'group'", 
		"'import'", "'lock-on-active'", "'merge'", "'new entry'", "'new label'", 
		"'of'", "'package'", "'print'", "'printf'", "'rule #'", "'set category'", 
		"'set indent'", "'set mark'", "'set parent'", "'set text'", "'set value'", 
		"'split'", "'then'", "'to'", "'update'", "'when'", "'with'"
	};
	public static final int EOF=-1;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
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
	public static final int Action=4;
	public static final int Actions=5;
	public static final int Assignment=6;
	public static final int Breackits=7;
	public static final int Char_lit=8;
	public static final int Condition=9;
	public static final int Conditions=10;
	public static final int Constraint=11;
	public static final int DIGIT=12;
	public static final int EOL=13;
	public static final int IDENT=14;
	public static final int Identifier=15;
	public static final int Import_item=16;
	public static final int J_Expression=17;
	public static final int J_expr=18;
	public static final int J_int_literal=19;
	public static final int Java_string_expr=20;
	public static final int LETTER=21;
	public static final int New_label=22;
	public static final int Other_literals=23;
	public static final int RULES=24;
	public static final int SETTING=25;
	public static final int Set_mark=26;
	public static final int Set_text=27;
	public static final int String_lit=28;
	public static final int WS=29;

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
	@Override public String[] getTokenNames() { return crl_gramParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g"; }


	public static class crl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "crl"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:43:1: crl : ( import_stmt )* ( crl_rule )+ -> ^( SETTING ( import_stmt )* ) ^( RULES ( crl_rule )+ ) ;
	public final crl_gramParser.crl_return crl() throws RecognitionException {
		crl_gramParser.crl_return retval = new crl_gramParser.crl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope import_stmt1 =null;
		ParserRuleReturnScope crl_rule2 =null;

		RewriteRuleSubtreeStream stream_crl_rule=new RewriteRuleSubtreeStream(adaptor,"rule crl_rule");
		RewriteRuleSubtreeStream stream_import_stmt=new RewriteRuleSubtreeStream(adaptor,"rule import_stmt");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:2: ( ( import_stmt )* ( crl_rule )+ -> ^( SETTING ( import_stmt )* ) ^( RULES ( crl_rule )+ ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:4: ( import_stmt )* ( crl_rule )+
			{
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:4: ( import_stmt )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==40||LA1_0==46) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:4: import_stmt
					{
					pushFollow(FOLLOW_import_stmt_in_crl125);
					import_stmt1=import_stmt();
					state._fsp--;

					stream_import_stmt.add(import_stmt1.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:17: ( crl_rule )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==49) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:17: crl_rule
					{
					pushFollow(FOLLOW_crl_rule_in_crl128);
					crl_rule2=crl_rule();
					state._fsp--;

					stream_crl_rule.add(crl_rule2.getTree());
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			// AST REWRITE
			// elements: import_stmt, crl_rule
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 44:27: -> ^( SETTING ( import_stmt )* ) ^( RULES ( crl_rule )+ )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:30: ^( SETTING ( import_stmt )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SETTING, "SETTING"), root_1);
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:40: ( import_stmt )*
				while ( stream_import_stmt.hasNext() ) {
					adaptor.addChild(root_1, stream_import_stmt.nextTree());
				}
				stream_import_stmt.reset();

				adaptor.addChild(root_0, root_1);
				}

				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:44:54: ^( RULES ( crl_rule )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULES, "RULES"), root_1);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "import_stmt"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:48:1: import_stmt : i= import_item -> Import_item[$i.value] ;
	public final crl_gramParser.import_stmt_return import_stmt() throws RecognitionException {
		crl_gramParser.import_stmt_return retval = new crl_gramParser.import_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope i =null;

		RewriteRuleSubtreeStream stream_import_item=new RewriteRuleSubtreeStream(adaptor,"rule import_item");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:49:2: (i= import_item -> Import_item[$i.value] )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:49:4: i= import_item
			{
			pushFollow(FOLLOW_import_item_in_import_stmt161);
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 49:18: -> Import_item[$i.value]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Import_item, (i!=null?((crl_gramParser.import_item_return)i).value:null)));
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "import_item"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:51:1: import_item returns [String value] : t= ( 'import' | 'package' ) t1= identifier ( ';' )? EOL ;
	public final crl_gramParser.import_item_return import_item() throws RecognitionException {
		crl_gramParser.import_item_return retval = new crl_gramParser.import_item_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken t=null;
		CommonToken char_literal3=null;
		CommonToken EOL4=null;
		ParserRuleReturnScope t1 =null;

		CommonTree t_tree=null;
		CommonTree char_literal3_tree=null;
		CommonTree EOL4_tree=null;

		 retval.value =""; 
		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:54:2: (t= ( 'import' | 'package' ) t1= identifier ( ';' )? EOL )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:54:4: t= ( 'import' | 'package' ) t1= identifier ( ';' )? EOL
			{
			root_0 = (CommonTree)adaptor.nil();


			t=(CommonToken)input.LT(1);
			if ( input.LA(1)==40||input.LA(1)==46 ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(t));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			 retval.value+=(t!=null?t.getText():null)+" "; 
			pushFollow(FOLLOW_identifier_in_import_item203);
			t1=identifier();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			 retval.value+=(t1!=null?((crl_gramParser.identifier_return)t1).value:null); 
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:40: ( ';' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==35) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:55:40: ';'
					{
					char_literal3=(CommonToken)match(input,35,FOLLOW_35_in_import_item207); 
					char_literal3_tree = (CommonTree)adaptor.create(char_literal3);
					adaptor.addChild(root_0, char_literal3_tree);

					}
					break;

			}

			EOL4=(CommonToken)match(input,EOL,FOLLOW_EOL_in_import_item210); 
			EOL4_tree = (CommonTree)adaptor.create(EOL4);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "crl_rule"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:57:1: crl_rule : 'rule #' J_int_literal ( 'lock-on-active' )? EOL 'when' EOL ( condition )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) ) ;
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
		ParserRuleReturnScope condition11 =null;
		ParserRuleReturnScope action14 =null;

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
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
		RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:58:2: ( 'rule #' J_int_literal ( 'lock-on-active' )? EOL 'when' EOL ( condition )+ 'then' EOL ( action )+ 'end' ( EOL )? -> ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:58:4: 'rule #' J_int_literal ( 'lock-on-active' )? EOL 'when' EOL ( condition )+ 'then' EOL ( action )+ 'end' ( EOL )?
			{
			string_literal5=(CommonToken)match(input,49,FOLLOW_49_in_crl_rule220);  
			stream_49.add(string_literal5);

			J_int_literal6=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_crl_rule222);  
			stream_J_int_literal.add(J_int_literal6);

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:58:27: ( 'lock-on-active' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==41) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:58:27: 'lock-on-active'
					{
					string_literal7=(CommonToken)match(input,41,FOLLOW_41_in_crl_rule224);  
					stream_41.add(string_literal7);

					}
					break;

			}

			EOL8=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule227);  
			stream_EOL.add(EOL8);

			string_literal9=(CommonToken)match(input,60,FOLLOW_60_in_crl_rule231);  
			stream_60.add(string_literal9);

			EOL10=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule233);  
			stream_EOL.add(EOL10);

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:60:3: ( condition )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==Identifier) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:60:3: condition
					{
					pushFollow(FOLLOW_condition_in_crl_rule238);
					condition11=condition();
					state._fsp--;

					stream_condition.add(condition11.getTree());
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			string_literal12=(CommonToken)match(input,57,FOLLOW_57_in_crl_rule243);  
			stream_57.add(string_literal12);

			EOL13=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule245);  
			stream_EOL.add(EOL13);

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:62:3: ( action )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==36||LA6_0==39||(LA6_0 >= 42 && LA6_0 <= 44)||(LA6_0 >= 47 && LA6_0 <= 48)||(LA6_0 >= 50 && LA6_0 <= 54)||LA6_0==56||LA6_0==59) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:62:3: action
					{
					pushFollow(FOLLOW_action_in_crl_rule249);
					action14=action();
					state._fsp--;

					stream_action.add(action14.getTree());
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			string_literal15=(CommonToken)match(input,38,FOLLOW_38_in_crl_rule254);  
			stream_38.add(string_literal15);

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:63:9: ( EOL )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==EOL) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:63:9: EOL
					{
					EOL16=(CommonToken)match(input,EOL,FOLLOW_EOL_in_crl_rule256);  
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 63:14: -> ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:63:17: ^( J_int_literal ^( Conditions ( condition )+ ) ^( Actions ( action )+ ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_J_int_literal.nextNode(), root_1);
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:63:33: ^( Conditions ( condition )+ )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Conditions, "Conditions"), root_2);
				if ( !(stream_condition.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_condition.hasNext() ) {
					adaptor.addChild(root_2, stream_condition.nextTree());
				}
				stream_condition.reset();

				adaptor.addChild(root_1, root_2);
				}

				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:63:58: ^( Actions ( action )+ )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Actions, "Actions"), root_2);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "condition"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:65:1: condition : query identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query identifier ( constraint )* ( assignment )* ) ;
	public final crl_gramParser.condition_return condition() throws RecognitionException {
		crl_gramParser.condition_return retval = new crl_gramParser.condition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken char_literal19=null;
		CommonToken char_literal21=null;
		CommonToken char_literal23=null;
		CommonToken EOL25=null;
		ParserRuleReturnScope query17 =null;
		ParserRuleReturnScope identifier18 =null;
		ParserRuleReturnScope constraint20 =null;
		ParserRuleReturnScope constraint22 =null;
		ParserRuleReturnScope assignment24 =null;

		CommonTree char_literal19_tree=null;
		CommonTree char_literal21_tree=null;
		CommonTree char_literal23_tree=null;
		CommonTree EOL25_tree=null;
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
		RewriteRuleSubtreeStream stream_query=new RewriteRuleSubtreeStream(adaptor,"rule query");
		RewriteRuleSubtreeStream stream_constraint=new RewriteRuleSubtreeStream(adaptor,"rule constraint");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:2: ( query identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL -> ^( Condition query identifier ( constraint )* ( assignment )* ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:4: query identifier ( ':' constraint ( ',' constraint )* ( ',' assignment )* )? EOL
			{
			pushFollow(FOLLOW_query_in_condition287);
			query17=query();
			state._fsp--;

			stream_query.add(query17.getTree());
			pushFollow(FOLLOW_identifier_in_condition289);
			identifier18=identifier();
			state._fsp--;

			stream_identifier.add(identifier18.getTree());
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:21: ( ':' constraint ( ',' constraint )* ( ',' assignment )* )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==34) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:22: ':' constraint ( ',' constraint )* ( ',' assignment )*
					{
					char_literal19=(CommonToken)match(input,34,FOLLOW_34_in_condition292);  
					stream_34.add(char_literal19);

					pushFollow(FOLLOW_constraint_in_condition294);
					constraint20=constraint();
					state._fsp--;

					stream_constraint.add(constraint20.getTree());
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:37: ( ',' constraint )*
					loop8:
					while (true) {
						int alt8=2;
						alt8 = dfa8.predict(input);
						switch (alt8) {
						case 1 :
							// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:38: ',' constraint
							{
							char_literal21=(CommonToken)match(input,32,FOLLOW_32_in_condition297);  
							stream_32.add(char_literal21);

							pushFollow(FOLLOW_constraint_in_condition299);
							constraint22=constraint();
							state._fsp--;

							stream_constraint.add(constraint22.getTree());
							}
							break;

						default :
							break loop8;
						}
					}

					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:55: ( ',' assignment )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==32) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:66:56: ',' assignment
							{
							char_literal23=(CommonToken)match(input,32,FOLLOW_32_in_condition304);  
							stream_32.add(char_literal23);

							pushFollow(FOLLOW_assignment_in_condition306);
							assignment24=assignment();
							state._fsp--;

							stream_assignment.add(assignment24.getTree());
							}
							break;

						default :
							break loop9;
						}
					}

					}
					break;

			}

			EOL25=(CommonToken)match(input,EOL,FOLLOW_EOL_in_condition313);  
			stream_EOL.add(EOL25);

			// AST REWRITE
			// elements: assignment, query, identifier, constraint
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 67:3: -> ^( Condition query identifier ( constraint )* ( assignment )* )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:67:6: ^( Condition query identifier ( constraint )* ( assignment )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Condition, "Condition"), root_1);
				adaptor.addChild(root_1, stream_query.nextTree());
				adaptor.addChild(root_1, stream_identifier.nextTree());
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:67:35: ( constraint )*
				while ( stream_constraint.hasNext() ) {
					adaptor.addChild(root_1, stream_constraint.nextTree());
				}
				stream_constraint.reset();

				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:67:47: ( assignment )*
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "query"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:69:1: query : Identifier ;
	public final crl_gramParser.query_return query() throws RecognitionException {
		crl_gramParser.query_return retval = new crl_gramParser.query_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken Identifier26=null;

		CommonTree Identifier26_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:70:2: ( Identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:70:4: Identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			Identifier26=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_query342); 
			Identifier26_tree = (CommonTree)adaptor.create(Identifier26);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constraint"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:73:1: constraint : j_expr -> ( ^( Constraint j_expr ) )+ ;
	public final crl_gramParser.constraint_return constraint() throws RecognitionException {
		crl_gramParser.constraint_return retval = new crl_gramParser.constraint_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope j_expr27 =null;

		RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:2: ( j_expr -> ( ^( Constraint j_expr ) )+ )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:4: j_expr
			{
			pushFollow(FOLLOW_j_expr_in_constraint355);
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 74:11: -> ( ^( Constraint j_expr ) )+
			{
				if ( !(stream_j_expr.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_j_expr.hasNext() ) {
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:74:14: ^( Constraint j_expr )
					{
					CommonTree root_1 = (CommonTree)adaptor.nil();
					root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Constraint, "Constraint"), root_1);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:76:1: assignment : identifier ':' j_expr_ -> ^( Assignment identifier j_expr_ ) ;
	public final crl_gramParser.assignment_return assignment() throws RecognitionException {
		crl_gramParser.assignment_return retval = new crl_gramParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken char_literal29=null;
		ParserRuleReturnScope identifier28 =null;
		ParserRuleReturnScope j_expr_30 =null;

		CommonTree char_literal29_tree=null;
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_j_expr_=new RewriteRuleSubtreeStream(adaptor,"rule j_expr_");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:2: ( identifier ':' j_expr_ -> ^( Assignment identifier j_expr_ ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:4: identifier ':' j_expr_
			{
			pushFollow(FOLLOW_identifier_in_assignment374);
			identifier28=identifier();
			state._fsp--;

			stream_identifier.add(identifier28.getTree());
			char_literal29=(CommonToken)match(input,34,FOLLOW_34_in_assignment376);  
			stream_34.add(char_literal29);

			pushFollow(FOLLOW_j_expr__in_assignment378);
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 77:27: -> ^( Assignment identifier j_expr_ )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:77:30: ^( Assignment identifier j_expr_ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Assignment, "Assignment"), root_1);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "j_expr"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:95:1: j_expr returns [String value] : (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+ ;
	public final crl_gramParser.j_expr_return j_expr() throws RecognitionException {
		crl_gramParser.j_expr_return retval = new crl_gramParser.j_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken i=null;

		CommonTree i_tree=null;

		 retval.value =""; 
		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:97:2: ( (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+ )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:97:5: (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:97:5: (i=~ ( ',' | '\"' | ':' | 'to' | EOL ) )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= Action && LA11_0 <= DIGIT)||(LA11_0 >= IDENT && LA11_0 <= WS)||LA11_0==31||LA11_0==33||(LA11_0 >= 35 && LA11_0 <= 57)||(LA11_0 >= 59 && LA11_0 <= 61)) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:97:7: i=~ ( ',' | '\"' | ':' | 'to' | EOL )
					{
					i=(CommonToken)input.LT(1);
					if ( (input.LA(1) >= Action && input.LA(1) <= DIGIT)||(input.LA(1) >= IDENT && input.LA(1) <= WS)||input.LA(1)==31||input.LA(1)==33||(input.LA(1) >= 35 && input.LA(1) <= 57)||(input.LA(1) >= 59 && input.LA(1) <= 61) ) {
						input.consume();
						adaptor.addChild(root_0, (CommonTree)adaptor.create(i));
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
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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
	// $ANTLR end "j_expr"


	public static class j_expr__return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "j_expr_"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:100:1: j_expr_ : j= j_expr -> ^( J_expr[$j.value] ) ;
	public final crl_gramParser.j_expr__return j_expr_() throws RecognitionException {
		crl_gramParser.j_expr__return retval = new crl_gramParser.j_expr__return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope j =null;

		RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:101:2: (j= j_expr -> ^( J_expr[$j.value] ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:101:4: j= j_expr
			{
			pushFollow(FOLLOW_j_expr_in_j_expr_448);
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 101:13: -> ^( J_expr[$j.value] )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:101:16: ^( J_expr[$j.value] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(J_expr, (j!=null?((crl_gramParser.j_expr_return)j).value:null)), root_1);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "action"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:104:1: action : action_ EOL -> action_ ;
	public final crl_gramParser.action_return action() throws RecognitionException {
		crl_gramParser.action_return retval = new crl_gramParser.action_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken EOL32=null;
		ParserRuleReturnScope action_31 =null;

		CommonTree EOL32_tree=null;
		RewriteRuleTokenStream stream_EOL=new RewriteRuleTokenStream(adaptor,"token EOL");
		RewriteRuleSubtreeStream stream_action_=new RewriteRuleSubtreeStream(adaptor,"rule action_");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:105:2: ( action_ EOL -> action_ )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:105:4: action_ EOL
			{
			pushFollow(FOLLOW_action__in_action467);
			action_31=action_();
			state._fsp--;

			stream_action_.add(action_31.getTree());
			EOL32=(CommonToken)match(input,EOL,FOLLOW_EOL_in_action469);  
			stream_EOL.add(EOL32);

			// AST REWRITE
			// elements: action_
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 105:16: -> action_
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "action_"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:107:1: action_ : ( set_mark | set_text | set_indent | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update );
	public final crl_gramParser.action__return action_() throws RecognitionException {
		crl_gramParser.action__return retval = new crl_gramParser.action__return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope set_mark33 =null;
		ParserRuleReturnScope set_text34 =null;
		ParserRuleReturnScope set_indent35 =null;
		ParserRuleReturnScope split36 =null;
		ParserRuleReturnScope merge37 =null;
		ParserRuleReturnScope new_label38 =null;
		ParserRuleReturnScope add_label39 =null;
		ParserRuleReturnScope set_category40 =null;
		ParserRuleReturnScope set_parent41 =null;
		ParserRuleReturnScope new_entry42 =null;
		ParserRuleReturnScope group43 =null;
		ParserRuleReturnScope c_print44 =null;
		ParserRuleReturnScope update45 =null;


		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:108:2: ( set_mark | set_text | set_indent | split | merge | new_label | add_label | set_category | set_parent | new_entry | group | c_print | update )
			int alt12=13;
			switch ( input.LA(1) ) {
			case 52:
				{
				alt12=1;
				}
				break;
			case 54:
				{
				alt12=2;
				}
				break;
			case 51:
				{
				alt12=3;
				}
				break;
			case 56:
				{
				alt12=4;
				}
				break;
			case 42:
				{
				alt12=5;
				}
				break;
			case 44:
				{
				alt12=6;
				}
				break;
			case 36:
				{
				alt12=7;
				}
				break;
			case 50:
				{
				alt12=8;
				}
				break;
			case 53:
				{
				alt12=9;
				}
				break;
			case 43:
				{
				alt12=10;
				}
				break;
			case 39:
				{
				alt12=11;
				}
				break;
			case 47:
			case 48:
				{
				alt12=12;
				}
				break;
			case 59:
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
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:108:4: set_mark
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_set_mark_in_action_483);
					set_mark33=set_mark();
					state._fsp--;

					adaptor.addChild(root_0, set_mark33.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:109:4: set_text
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_set_text_in_action_488);
					set_text34=set_text();
					state._fsp--;

					adaptor.addChild(root_0, set_text34.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:110:4: set_indent
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_set_indent_in_action_493);
					set_indent35=set_indent();
					state._fsp--;

					adaptor.addChild(root_0, set_indent35.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:111:4: split
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_split_in_action_498);
					split36=split();
					state._fsp--;

					adaptor.addChild(root_0, split36.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:112:4: merge
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_merge_in_action_503);
					merge37=merge();
					state._fsp--;

					adaptor.addChild(root_0, merge37.getTree());

					}
					break;
				case 6 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:113:4: new_label
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_new_label_in_action_508);
					new_label38=new_label();
					state._fsp--;

					adaptor.addChild(root_0, new_label38.getTree());

					}
					break;
				case 7 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:114:4: add_label
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_add_label_in_action_513);
					add_label39=add_label();
					state._fsp--;

					adaptor.addChild(root_0, add_label39.getTree());

					}
					break;
				case 8 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:115:4: set_category
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_set_category_in_action_518);
					set_category40=set_category();
					state._fsp--;

					adaptor.addChild(root_0, set_category40.getTree());

					}
					break;
				case 9 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:116:4: set_parent
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_set_parent_in_action_523);
					set_parent41=set_parent();
					state._fsp--;

					adaptor.addChild(root_0, set_parent41.getTree());

					}
					break;
				case 10 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:117:4: new_entry
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_new_entry_in_action_528);
					new_entry42=new_entry();
					state._fsp--;

					adaptor.addChild(root_0, new_entry42.getTree());

					}
					break;
				case 11 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:118:4: group
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_group_in_action_533);
					group43=group();
					state._fsp--;

					adaptor.addChild(root_0, group43.getTree());

					}
					break;
				case 12 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:119:4: c_print
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_c_print_in_action_538);
					c_print44=c_print();
					state._fsp--;

					adaptor.addChild(root_0, c_print44.getTree());

					}
					break;
				case 13 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:120:4: update
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_update_in_action_543);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_mark"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:122:1: set_mark : 'set mark' j_expr 'to' identifier -> ^( Set_mark identifier j_expr ) ;
	public final crl_gramParser.set_mark_return set_mark() throws RecognitionException {
		crl_gramParser.set_mark_return retval = new crl_gramParser.set_mark_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal46=null;
		CommonToken string_literal48=null;
		ParserRuleReturnScope j_expr47 =null;
		ParserRuleReturnScope identifier49 =null;

		CommonTree string_literal46_tree=null;
		CommonTree string_literal48_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:123:2: ( 'set mark' j_expr 'to' identifier -> ^( Set_mark identifier j_expr ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:123:4: 'set mark' j_expr 'to' identifier
			{
			string_literal46=(CommonToken)match(input,52,FOLLOW_52_in_set_mark553);  
			stream_52.add(string_literal46);

			pushFollow(FOLLOW_j_expr_in_set_mark555);
			j_expr47=j_expr();
			state._fsp--;

			stream_j_expr.add(j_expr47.getTree());
			string_literal48=(CommonToken)match(input,58,FOLLOW_58_in_set_mark557);  
			stream_58.add(string_literal48);

			pushFollow(FOLLOW_identifier_in_set_mark559);
			identifier49=identifier();
			state._fsp--;

			stream_identifier.add(identifier49.getTree());
			// AST REWRITE
			// elements: identifier, j_expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 123:38: -> ^( Set_mark identifier j_expr )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:123:41: ^( Set_mark identifier j_expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Set_mark, "Set_mark"), root_1);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_text"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:125:1: set_text : 'set text' j_expr 'to' identifier -> ^( Set_text identifier j_expr ) ;
	public final crl_gramParser.set_text_return set_text() throws RecognitionException {
		crl_gramParser.set_text_return retval = new crl_gramParser.set_text_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal50=null;
		CommonToken string_literal52=null;
		ParserRuleReturnScope j_expr51 =null;
		ParserRuleReturnScope identifier53 =null;

		CommonTree string_literal50_tree=null;
		CommonTree string_literal52_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:126:2: ( 'set text' j_expr 'to' identifier -> ^( Set_text identifier j_expr ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:126:4: 'set text' j_expr 'to' identifier
			{
			string_literal50=(CommonToken)match(input,54,FOLLOW_54_in_set_text579);  
			stream_54.add(string_literal50);

			pushFollow(FOLLOW_j_expr_in_set_text581);
			j_expr51=j_expr();
			state._fsp--;

			stream_j_expr.add(j_expr51.getTree());
			string_literal52=(CommonToken)match(input,58,FOLLOW_58_in_set_text583);  
			stream_58.add(string_literal52);

			pushFollow(FOLLOW_identifier_in_set_text585);
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 126:38: -> ^( Set_text identifier j_expr )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:126:41: ^( Set_text identifier j_expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Set_text, "Set_text"), root_1);
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_indent"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:128:1: set_indent : 'set indent' J_int_literal 'to' identifier ;
	public final crl_gramParser.set_indent_return set_indent() throws RecognitionException {
		crl_gramParser.set_indent_return retval = new crl_gramParser.set_indent_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal54=null;
		CommonToken J_int_literal55=null;
		CommonToken string_literal56=null;
		ParserRuleReturnScope identifier57 =null;

		CommonTree string_literal54_tree=null;
		CommonTree J_int_literal55_tree=null;
		CommonTree string_literal56_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:129:2: ( 'set indent' J_int_literal 'to' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:129:4: 'set indent' J_int_literal 'to' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal54=(CommonToken)match(input,51,FOLLOW_51_in_set_indent605); 
			string_literal54_tree = (CommonTree)adaptor.create(string_literal54);
			adaptor.addChild(root_0, string_literal54_tree);

			J_int_literal55=(CommonToken)match(input,J_int_literal,FOLLOW_J_int_literal_in_set_indent607); 
			J_int_literal55_tree = (CommonTree)adaptor.create(J_int_literal55);
			adaptor.addChild(root_0, J_int_literal55_tree);

			string_literal56=(CommonToken)match(input,58,FOLLOW_58_in_set_indent609); 
			string_literal56_tree = (CommonTree)adaptor.create(string_literal56);
			adaptor.addChild(root_0, string_literal56_tree);

			pushFollow(FOLLOW_identifier_in_set_indent611);
			identifier57=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier57.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "split"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:131:1: split : 'split' identifier ;
	public final crl_gramParser.split_return split() throws RecognitionException {
		crl_gramParser.split_return retval = new crl_gramParser.split_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal58=null;
		ParserRuleReturnScope identifier59 =null;

		CommonTree string_literal58_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:132:2: ( 'split' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:132:4: 'split' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal58=(CommonToken)match(input,56,FOLLOW_56_in_split621); 
			string_literal58_tree = (CommonTree)adaptor.create(string_literal58);
			adaptor.addChild(root_0, string_literal58_tree);

			pushFollow(FOLLOW_identifier_in_split623);
			identifier59=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier59.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "merge"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:134:1: merge : 'merge' identifier 'with' identifier ;
	public final crl_gramParser.merge_return merge() throws RecognitionException {
		crl_gramParser.merge_return retval = new crl_gramParser.merge_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal60=null;
		CommonToken string_literal62=null;
		ParserRuleReturnScope identifier61 =null;
		ParserRuleReturnScope identifier63 =null;

		CommonTree string_literal60_tree=null;
		CommonTree string_literal62_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:135:2: ( 'merge' identifier 'with' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:135:4: 'merge' identifier 'with' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal60=(CommonToken)match(input,42,FOLLOW_42_in_merge633); 
			string_literal60_tree = (CommonTree)adaptor.create(string_literal60);
			adaptor.addChild(root_0, string_literal60_tree);

			pushFollow(FOLLOW_identifier_in_merge635);
			identifier61=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier61.getTree());

			string_literal62=(CommonToken)match(input,61,FOLLOW_61_in_merge637); 
			string_literal62_tree = (CommonTree)adaptor.create(string_literal62);
			adaptor.addChild(root_0, string_literal62_tree);

			pushFollow(FOLLOW_identifier_in_merge639);
			identifier63=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier63.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "new_entry"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:137:1: new_entry : 'new entry' identifier ( 'as' j_expr )? ;
	public final crl_gramParser.new_entry_return new_entry() throws RecognitionException {
		crl_gramParser.new_entry_return retval = new crl_gramParser.new_entry_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal64=null;
		CommonToken string_literal66=null;
		ParserRuleReturnScope identifier65 =null;
		ParserRuleReturnScope j_expr67 =null;

		CommonTree string_literal64_tree=null;
		CommonTree string_literal66_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:138:2: ( 'new entry' identifier ( 'as' j_expr )? )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:138:4: 'new entry' identifier ( 'as' j_expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal64=(CommonToken)match(input,43,FOLLOW_43_in_new_entry649); 
			string_literal64_tree = (CommonTree)adaptor.create(string_literal64);
			adaptor.addChild(root_0, string_literal64_tree);

			pushFollow(FOLLOW_identifier_in_new_entry651);
			identifier65=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier65.getTree());

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:138:27: ( 'as' j_expr )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==37) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:138:28: 'as' j_expr
					{
					string_literal66=(CommonToken)match(input,37,FOLLOW_37_in_new_entry654); 
					string_literal66_tree = (CommonTree)adaptor.create(string_literal66);
					adaptor.addChild(root_0, string_literal66_tree);

					pushFollow(FOLLOW_j_expr_in_new_entry656);
					j_expr67=j_expr();
					state._fsp--;

					adaptor.addChild(root_0, j_expr67.getTree());

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
	// $ANTLR end "new_entry"


	public static class set_value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_value"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:140:1: set_value : 'set value' j_expr 'to' identifier ;
	public final crl_gramParser.set_value_return set_value() throws RecognitionException {
		crl_gramParser.set_value_return retval = new crl_gramParser.set_value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal68=null;
		CommonToken string_literal70=null;
		ParserRuleReturnScope j_expr69 =null;
		ParserRuleReturnScope identifier71 =null;

		CommonTree string_literal68_tree=null;
		CommonTree string_literal70_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:141:2: ( 'set value' j_expr 'to' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:141:4: 'set value' j_expr 'to' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal68=(CommonToken)match(input,55,FOLLOW_55_in_set_value668); 
			string_literal68_tree = (CommonTree)adaptor.create(string_literal68);
			adaptor.addChild(root_0, string_literal68_tree);

			pushFollow(FOLLOW_j_expr_in_set_value670);
			j_expr69=j_expr();
			state._fsp--;

			adaptor.addChild(root_0, j_expr69.getTree());

			string_literal70=(CommonToken)match(input,58,FOLLOW_58_in_set_value672); 
			string_literal70_tree = (CommonTree)adaptor.create(string_literal70);
			adaptor.addChild(root_0, string_literal70_tree);

			pushFollow(FOLLOW_identifier_in_set_value674);
			identifier71=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier71.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_category"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:143:1: set_category : 'set category' identifier 'to' identifier ;
	public final crl_gramParser.set_category_return set_category() throws RecognitionException {
		crl_gramParser.set_category_return retval = new crl_gramParser.set_category_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal72=null;
		CommonToken string_literal74=null;
		ParserRuleReturnScope identifier73 =null;
		ParserRuleReturnScope identifier75 =null;

		CommonTree string_literal72_tree=null;
		CommonTree string_literal74_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:144:2: ( 'set category' identifier 'to' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:144:4: 'set category' identifier 'to' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal72=(CommonToken)match(input,50,FOLLOW_50_in_set_category685); 
			string_literal72_tree = (CommonTree)adaptor.create(string_literal72);
			adaptor.addChild(root_0, string_literal72_tree);

			pushFollow(FOLLOW_identifier_in_set_category687);
			identifier73=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier73.getTree());

			string_literal74=(CommonToken)match(input,58,FOLLOW_58_in_set_category689); 
			string_literal74_tree = (CommonTree)adaptor.create(string_literal74);
			adaptor.addChild(root_0, string_literal74_tree);

			pushFollow(FOLLOW_identifier_in_set_category691);
			identifier75=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier75.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_parent"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:146:1: set_parent : 'set parent' identifier 'to' identifier ;
	public final crl_gramParser.set_parent_return set_parent() throws RecognitionException {
		crl_gramParser.set_parent_return retval = new crl_gramParser.set_parent_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal76=null;
		CommonToken string_literal78=null;
		ParserRuleReturnScope identifier77 =null;
		ParserRuleReturnScope identifier79 =null;

		CommonTree string_literal76_tree=null;
		CommonTree string_literal78_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:147:2: ( 'set parent' identifier 'to' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:147:4: 'set parent' identifier 'to' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal76=(CommonToken)match(input,53,FOLLOW_53_in_set_parent701); 
			string_literal76_tree = (CommonTree)adaptor.create(string_literal76);
			adaptor.addChild(root_0, string_literal76_tree);

			pushFollow(FOLLOW_identifier_in_set_parent703);
			identifier77=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier77.getTree());

			string_literal78=(CommonToken)match(input,58,FOLLOW_58_in_set_parent705); 
			string_literal78_tree = (CommonTree)adaptor.create(string_literal78);
			adaptor.addChild(root_0, string_literal78_tree);

			pushFollow(FOLLOW_identifier_in_set_parent707);
			identifier79=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier79.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "group"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:149:1: group : 'group' identifier 'with' identifier ;
	public final crl_gramParser.group_return group() throws RecognitionException {
		crl_gramParser.group_return retval = new crl_gramParser.group_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal80=null;
		CommonToken string_literal82=null;
		ParserRuleReturnScope identifier81 =null;
		ParserRuleReturnScope identifier83 =null;

		CommonTree string_literal80_tree=null;
		CommonTree string_literal82_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:150:2: ( 'group' identifier 'with' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:150:4: 'group' identifier 'with' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal80=(CommonToken)match(input,39,FOLLOW_39_in_group717); 
			string_literal80_tree = (CommonTree)adaptor.create(string_literal80);
			adaptor.addChild(root_0, string_literal80_tree);

			pushFollow(FOLLOW_identifier_in_group719);
			identifier81=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier81.getTree());

			string_literal82=(CommonToken)match(input,61,FOLLOW_61_in_group721); 
			string_literal82_tree = (CommonTree)adaptor.create(string_literal82);
			adaptor.addChild(root_0, string_literal82_tree);

			pushFollow(FOLLOW_identifier_in_group723);
			identifier83=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier83.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "add_label"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:152:1: add_label : 'add label' identifier ( 'of' identifier )? 'to' identifier ;
	public final crl_gramParser.add_label_return add_label() throws RecognitionException {
		crl_gramParser.add_label_return retval = new crl_gramParser.add_label_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal84=null;
		CommonToken string_literal86=null;
		CommonToken string_literal88=null;
		ParserRuleReturnScope identifier85 =null;
		ParserRuleReturnScope identifier87 =null;
		ParserRuleReturnScope identifier89 =null;

		CommonTree string_literal84_tree=null;
		CommonTree string_literal86_tree=null;
		CommonTree string_literal88_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:153:2: ( 'add label' identifier ( 'of' identifier )? 'to' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:153:4: 'add label' identifier ( 'of' identifier )? 'to' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal84=(CommonToken)match(input,36,FOLLOW_36_in_add_label733); 
			string_literal84_tree = (CommonTree)adaptor.create(string_literal84);
			adaptor.addChild(root_0, string_literal84_tree);

			pushFollow(FOLLOW_identifier_in_add_label735);
			identifier85=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier85.getTree());

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:153:27: ( 'of' identifier )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==45) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:153:28: 'of' identifier
					{
					string_literal86=(CommonToken)match(input,45,FOLLOW_45_in_add_label738); 
					string_literal86_tree = (CommonTree)adaptor.create(string_literal86);
					adaptor.addChild(root_0, string_literal86_tree);

					pushFollow(FOLLOW_identifier_in_add_label740);
					identifier87=identifier();
					state._fsp--;

					adaptor.addChild(root_0, identifier87.getTree());

					}
					break;

			}

			string_literal88=(CommonToken)match(input,58,FOLLOW_58_in_add_label744); 
			string_literal88_tree = (CommonTree)adaptor.create(string_literal88);
			adaptor.addChild(root_0, string_literal88_tree);

			pushFollow(FOLLOW_identifier_in_add_label746);
			identifier89=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier89.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "new_label"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:155:1: new_label : 'new label' identifier ( 'as' j_expr )? -> ^( New_label identifier ( j_expr )? ) ;
	public final crl_gramParser.new_label_return new_label() throws RecognitionException {
		crl_gramParser.new_label_return retval = new crl_gramParser.new_label_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal90=null;
		CommonToken string_literal92=null;
		ParserRuleReturnScope identifier91 =null;
		ParserRuleReturnScope j_expr93 =null;

		CommonTree string_literal90_tree=null;
		CommonTree string_literal92_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_j_expr=new RewriteRuleSubtreeStream(adaptor,"rule j_expr");

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:156:2: ( 'new label' identifier ( 'as' j_expr )? -> ^( New_label identifier ( j_expr )? ) )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:156:4: 'new label' identifier ( 'as' j_expr )?
			{
			string_literal90=(CommonToken)match(input,44,FOLLOW_44_in_new_label756);  
			stream_44.add(string_literal90);

			pushFollow(FOLLOW_identifier_in_new_label758);
			identifier91=identifier();
			state._fsp--;

			stream_identifier.add(identifier91.getTree());
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:156:27: ( 'as' j_expr )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==37) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:156:28: 'as' j_expr
					{
					string_literal92=(CommonToken)match(input,37,FOLLOW_37_in_new_label761);  
					stream_37.add(string_literal92);

					pushFollow(FOLLOW_j_expr_in_new_label763);
					j_expr93=j_expr();
					state._fsp--;

					stream_j_expr.add(j_expr93.getTree());
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 156:42: -> ^( New_label identifier ( j_expr )? )
			{
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:156:45: ^( New_label identifier ( j_expr )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(New_label, "New_label"), root_1);
				adaptor.addChild(root_1, stream_identifier.nextTree());
				// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:156:68: ( j_expr )?
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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "update"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:158:1: update : 'update' identifier ;
	public final crl_gramParser.update_return update() throws RecognitionException {
		crl_gramParser.update_return retval = new crl_gramParser.update_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken string_literal94=null;
		ParserRuleReturnScope identifier95 =null;

		CommonTree string_literal94_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:159:2: ( 'update' identifier )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:159:4: 'update' identifier
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal94=(CommonToken)match(input,59,FOLLOW_59_in_update786); 
			string_literal94_tree = (CommonTree)adaptor.create(string_literal94);
			adaptor.addChild(root_0, string_literal94_tree);

			pushFollow(FOLLOW_identifier_in_update788);
			identifier95=identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier95.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "c_print"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:161:1: c_print : ( 'print' | 'printf' ) j_expr ;
	public final crl_gramParser.c_print_return c_print() throws RecognitionException {
		crl_gramParser.c_print_return retval = new crl_gramParser.c_print_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set96=null;
		ParserRuleReturnScope j_expr97 =null;

		CommonTree set96_tree=null;

		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:162:2: ( ( 'print' | 'printf' ) j_expr )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:162:4: ( 'print' | 'printf' ) j_expr
			{
			root_0 = (CommonTree)adaptor.nil();


			set96=(CommonToken)input.LT(1);
			if ( (input.LA(1) >= 47 && input.LA(1) <= 48) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set96));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_j_expr_in_c_print804);
			j_expr97=j_expr();
			state._fsp--;

			adaptor.addChild(root_0, j_expr97.getTree());

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
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "identifier"
	// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:165:1: identifier returns [String value] : t1= Identifier ( '.' t2= Identifier )* ( '.' '*' )? -> IDENT[$value] ;
	public final crl_gramParser.identifier_return identifier() throws RecognitionException {
		crl_gramParser.identifier_return retval = new crl_gramParser.identifier_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken t1=null;
		CommonToken t2=null;
		CommonToken char_literal98=null;
		CommonToken char_literal99=null;
		CommonToken char_literal100=null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree char_literal98_tree=null;
		CommonTree char_literal99_tree=null;
		CommonTree char_literal100_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

		 retval.value =""; 
		try {
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:2: (t1= Identifier ( '.' t2= Identifier )* ( '.' '*' )? -> IDENT[$value] )
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:5: t1= Identifier ( '.' t2= Identifier )* ( '.' '*' )?
			{
			t1=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_identifier827);  
			stream_Identifier.add(t1);

			 retval.value+=(t1!=null?t1.getText():null); 
			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:41: ( '.' t2= Identifier )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==33) ) {
					int LA16_1 = input.LA(2);
					if ( (LA16_1==Identifier) ) {
						alt16=1;
					}

				}

				switch (alt16) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:42: '.' t2= Identifier
					{
					char_literal98=(CommonToken)match(input,33,FOLLOW_33_in_identifier832);  
					stream_33.add(char_literal98);

					t2=(CommonToken)match(input,Identifier,FOLLOW_Identifier_in_identifier836);  
					stream_Identifier.add(t2);

					 retval.value+="."+(t2!=null?t2.getText():null); 
					}
					break;

				default :
					break loop16;
				}
			}

			// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:88: ( '.' '*' )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==33) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// C:\\Users\\user\\Documents\\GitHub\\tabbyxl2\\src\\main\\java\\ru\\icc\\cells\\ssdc\\interpreeter\\crl_gram.g:167:89: '.' '*'
					{
					char_literal99=(CommonToken)match(input,33,FOLLOW_33_in_identifier843);  
					stream_33.add(char_literal99);

					char_literal100=(CommonToken)match(input,31,FOLLOW_31_in_identifier845);  
					stream_31.add(char_literal100);

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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 167:117: -> IDENT[$value]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(IDENT, retval.value));
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
		"\1\15\1\4\1\uffff\1\4\1\uffff\3\4";
	static final String DFA8_maxS =
		"\1\40\1\75\1\uffff\1\75\1\uffff\3\75";
	static final String DFA8_acceptS =
		"\2\uffff\1\2\1\uffff\1\1\3\uffff";
	static final String DFA8_specialS =
		"\10\uffff}>";
	static final String[] DFA8_transitionS = {
			"\1\2\22\uffff\1\1",
			"\11\4\1\uffff\1\4\1\3\16\4\1\uffff\1\4\1\uffff\1\4\1\uffff\27\4\1\uffff"+
			"\3\4",
			"",
			"\32\4\1\uffff\2\4\1\5\1\2\27\4\1\uffff\3\4",
			"",
			"\13\4\1\6\16\4\1\uffff\1\7\2\4\1\uffff\27\4\1\uffff\3\4",
			"\32\4\1\uffff\2\4\1\5\1\2\27\4\1\uffff\3\4",
			"\32\4\1\uffff\3\4\1\2\27\4\1\uffff\3\4"
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

	protected class DFA8 extends DFA {

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
		@Override
		public String getDescription() {
			return "()* loopback of 66:37: ( ',' constraint )*";
		}
	}

	public static final BitSet FOLLOW_import_stmt_in_crl125 = new BitSet(new long[]{0x0002410000000000L});
	public static final BitSet FOLLOW_crl_rule_in_crl128 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_import_item_in_import_stmt161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_import_item191 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_import_item203 = new BitSet(new long[]{0x0000000800002000L});
	public static final BitSet FOLLOW_35_in_import_item207 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EOL_in_import_item210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_crl_rule220 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_J_int_literal_in_crl_rule222 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_41_in_crl_rule224 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EOL_in_crl_rule227 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_crl_rule231 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EOL_in_crl_rule233 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_condition_in_crl_rule238 = new BitSet(new long[]{0x0200000000008000L});
	public static final BitSet FOLLOW_57_in_crl_rule243 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EOL_in_crl_rule245 = new BitSet(new long[]{0x097D9C9000000000L});
	public static final BitSet FOLLOW_action_in_crl_rule249 = new BitSet(new long[]{0x097D9CD000000000L});
	public static final BitSet FOLLOW_38_in_crl_rule254 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_EOL_in_crl_rule256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_query_in_condition287 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_condition289 = new BitSet(new long[]{0x0000000400002000L});
	public static final BitSet FOLLOW_34_in_condition292 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_constraint_in_condition294 = new BitSet(new long[]{0x0000000100002000L});
	public static final BitSet FOLLOW_32_in_condition297 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_constraint_in_condition299 = new BitSet(new long[]{0x0000000100002000L});
	public static final BitSet FOLLOW_32_in_condition304 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assignment_in_condition306 = new BitSet(new long[]{0x0000000100002000L});
	public static final BitSet FOLLOW_EOL_in_condition313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_query342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_j_expr_in_constraint355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_assignment374 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_assignment376 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_j_expr__in_assignment378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_j_expr418 = new BitSet(new long[]{0x3BFFFFFABFFFDFF2L});
	public static final BitSet FOLLOW_j_expr_in_j_expr_448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action__in_action467 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EOL_in_action469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_mark_in_action_483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_text_in_action_488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_indent_in_action_493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_split_in_action_498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_merge_in_action_503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_new_label_in_action_508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_label_in_action_513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_category_in_action_518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_parent_in_action_523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_new_entry_in_action_528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_group_in_action_533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_c_print_in_action_538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_in_action_543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_set_mark553 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_j_expr_in_set_mark555 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_set_mark557 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_mark559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_set_text579 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_j_expr_in_set_text581 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_set_text583 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_text585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_set_indent605 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_J_int_literal_in_set_indent607 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_set_indent609 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_indent611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_split621 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_split623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_merge633 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_merge635 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_merge637 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_merge639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_new_entry649 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_new_entry651 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_new_entry654 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_j_expr_in_new_entry656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_set_value668 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_j_expr_in_set_value670 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_set_value672 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_value674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_set_category685 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_category687 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_set_category689 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_category691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_set_parent701 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_parent703 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_set_parent705 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_set_parent707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_group717 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_group719 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_group721 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_group723 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_add_label733 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_add_label735 = new BitSet(new long[]{0x0400200000000000L});
	public static final BitSet FOLLOW_45_in_add_label738 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_add_label740 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_add_label744 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_add_label746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_new_label756 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_new_label758 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_new_label761 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_j_expr_in_new_label763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_update786 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_identifier_in_update788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_c_print798 = new BitSet(new long[]{0x3BFFFFFABFFFDFF0L});
	public static final BitSet FOLLOW_j_expr_in_c_print804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_identifier827 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_identifier832 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Identifier_in_identifier836 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_identifier843 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_identifier845 = new BitSet(new long[]{0x0000000000000002L});
}
