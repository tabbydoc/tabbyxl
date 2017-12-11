grammar crl_gram;

options {

	language=Java;
	TokenLabelType=CommonToken;
	output=AST;
	ASTLabelType=CommonTree;
	//backtrack=true;
}


tokens
{	
	RULES;
	J_Expression;
	Constraint;
	Condition;
	Conditions;
	Action;
	Actions;
	Set_mark;
	Java_string_expr;
	J_expr;
	SETTING;
	Import_item;
	Assignment;
	Set_mark;
	Set_text;
	Set_indent;
	Set_value;
	Set_category;
	Set_parent;
	Split;
	Merge;
	Group;
	New_entry;
	New_label;
	Add_label;
	Update;
	Print;
	IDENT;
}

/*@headers
{	
	package ru.icc.cells.ssdc.interpreeter.output;
}*/


//parser


crl
	:	import_stmt* crl_rule+ -> ^(SETTING import_stmt*) ^(RULES crl_rule+)
	;
	
	
import_stmt
	:	i=import_item -> Import_item [$i.value]
	;
import_item returns [String value]
@init{ $value=""; }
@after{ $value+=";"; }
	:	t=('import'|'package') { $value+=$t.text+" "; }
		t1=identifier { $value+=$t1.value; } ';'? EOL
	;
crl_rule
	:	'rule #' J_int_literal 'lock-on-active'? EOL
		'when' EOL 
		condition+
		'then' EOL
		action+
		'end' EOL? -> ^(J_int_literal ^(Conditions condition+) ^(Actions action+))
	;
condition
	:	query identifier (':' constraint (',' constraint)* (',' assignment)* )? EOL 
		-> ^(Condition query identifier constraint* assignment*)
	;
query
	:	Identifier //'cell'|'entry'|'label'|'category'|'no cells'|'no labels'|'no entries'|'no categories'
	;
	
constraint
	:	j_expr -> ^(Constraint j_expr)+
	;
assignment
	:	identifier ':' j_expr_ -> ^(Assignment identifier j_expr_)
	;
/*j_expr
	:	i=j_expr_ -> J_Expression [$i.value]//^(J_Expression j_expr_)
	;

j_expr_ returns [String value]
@init	{$value="";}
	:	 (i1=  ~(','|'"'|':'|'to'|'as'|'of'|'with'|EOL) { $value+=$i1.text; }
		 (i2=  ~(','|'"'|':'|'to'|'as'|'of'|'with'|EOL) { $value+=" "+$i2.text; })* )?
	;*/
	
/* 
j_expr returns [String value]
@init{ $value=""; }
	:	 ( i= ~(','|'"'|':'|'to'|'as'|'of'|'with'|EOL) { $value+=$i.text; } )+
	;
*/
j_expr returns [String value]
@init{ $value=""; }
	:	 ( i= ~(','|'"'|':'|'to'|EOL) { $value+=$i.text; } )+
	;
	
j_expr_
	:	j=j_expr -> ^(J_expr [$j.value])
	;

action
	:	action_ EOL -> action_
	;
action_
	:	set_mark
		|set_text
		|set_indent
		|split
		|merge
		|new_label
		|add_label
		|set_category
		|set_parent
		|new_entry
		|group
		|c_print
		|update
	;
set_mark
	:	'set mark' j_expr 'to' identifier -> ^(Set_mark identifier j_expr)
	;
set_text
	:	'set text' j_expr 'to' identifier -> ^(Set_text identifier j_expr)
	;
set_indent
	:	'set indent' J_int_literal 'to' identifier -> ^(Set_indent identifier J_int_literal)
	;
split
	:	'split' identifier -> ^(Split identifier)
	;
merge
	:	'merge' i1=identifier 'with' i2=identifier -> ^(Merge $i1 $i2)
	;
new_entry
	:	'new entry' identifier ('as' j_expr)? -> ^(New_entry identifier j_expr?)
	;
set_value
	:	'set value' j_expr 'to' identifier -> ^(Set_value j_expr identifier)
	;
set_category
	:	'set category' i1=identifier 'to' i2=identifier -> ^(Set_category $i1 $i2)
	;
set_parent
	:	'set parent' i1=identifier 'to' i2=identifier -> ^(Set_parent $i1 $i2)
	;
group
	:	'group' i1=identifier 'with' i2=identifier -> ^(Group $i1 $i2)
	;
add_label
	:	'add label' i1=identifier ('of' i2=identifier)? 'to' i3=identifier -> ^(Add_label $i1 $i2? $i3)
	;
new_label
	:	'new label' identifier ('as' j_expr)? -> ^(New_label identifier j_expr?)
	;
update
	:	'update' identifier -> ^(Update identifier)
	;
c_print
	:	('print'|'printf') j_expr -> ^(Print j_expr)
	;

identifier returns [String value]
@init { $value=""; }
	: 	t1=Identifier { $value+=$t1.text; } ('.' t2=Identifier { $value+="."+$t2.text; })* ('.' '*' { $value+=".*"; })? -> IDENT [$value]
	;

//lexer
WS
	:	 (' ')+ { $channel=HIDDEN; } 
	;
//S	:	' '	;
EOL
	:	('\n'|'\r')+
	;
J_int_literal
	:	DIGIT+
	;
Other_literals
	:	'='|'!'|'?'|'|'|'>'|'<'|'=='|'>='|'<='|'!='
	;
Identifier
	:	('$'|'_'|LETTER)('$'|'_'|LETTER|DIGIT)*
	;
String_lit
	:	'"' (.)* '"'
	;

Char_lit
	:	'\'' (.) '\''
	;
Breackits
	:	'('|')'
	;
/*lockonactive
	:	'lockonactive'
	;*/
fragment DIGIT
	:	'0'..'9'
	;
fragment LETTER
	:	'A'..'Z'|'a'..'z'
	;