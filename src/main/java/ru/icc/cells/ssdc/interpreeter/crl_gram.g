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
	Constraint;
	Condition;
	No_condition;
	Conditions;
	Action;
	Actions;
	J_expr;
	Imports;
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
	IDENT1;
	IDENT2;
	ADV_IDENT;
	ADV_IDENT1;
	ADV_IDENT2;
	STRING;
	INT;
	CATEGORY;
	LABEL;
}

/*@headers
{	
	package ru.icc.cells.ssdc.interpreeter.output;
}*/


//parser


crl
	:	import_stmt* crl_rule+ -> ^(Imports import_stmt*) ^(RULES crl_rule+)
	;
	
	
import_stmt
	:	i=import_unit -> Import_item [$i.value]
	;
	
import_unit returns [String value]
@init{ $value=""; }
@after{ $value+=";"; }
	:	t=('import'|'package') { $value+=$t.text+" "; } t1=import_item { $value+=$t1.value; } ';'? EOL
	;
	
import_item returns [String value]
@init { $value=""; }
	: 	i1=Identifier { $value+=$i1.text; } ('.' i2=Identifier { $value+="."+$i2.text; })* ('.' '*' { $value+=".*"; })? //-> ^(IDENT Identifier1 Identifier2)
	;
	
crl_rule
	:	'rule #' J_int_literal 'lock-on-active'? EOL
		'when' EOL 
		condition_unit+
		'then' EOL
		action+
		'end' EOL? -> ^(J_int_literal ^(Conditions condition_unit+) ^(Actions action+))
	;

condition_unit
	:	condition|no_condition
	;

condition
	:	query Identifier (':' constraint (',' constraint)* (',' assignment)* )? EOL 
		-> ^(Condition query Identifier constraint* assignment*)
	;
	
query
	:	'cell'|'entry'|'label'|'category'
	;
	
no_condition
	:	no_query (':' constraint (',' constraint)* )? EOL -> ^(No_condition no_query constraint*)
	;
	
no_query
	:	'no cells'|'no labels'|'no entries'|'no categories'
	;
	
constraint
	:	j_expr -> ^(Constraint j_expr)
	;
	
assignment
	:	Identifier ':' j_expr -> ^(Assignment ^(IDENT Identifier) ^(STRING j_expr))
	;
	
j_expr returns [String value]
@init{ $value=""; }
	:	 ( i= ~(','|'"'|':'|'to'|'of'|EOL) { $value+=$i.text; } )+
	;

action
	:	action_ EOL -> action_
	;
	
action_
	:	set_mark
		|set_text
		|set_indent
		|set_value
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
	:	'set mark' j_expr 'to' Identifier -> ^(Set_mark ^(IDENT Identifier) ^(STRING j_expr))
	;
	
set_text
	:	'set text' j_expr 'to' Identifier -> ^(Set_text ^(IDENT Identifier) ^(STRING j_expr))
	;
	
set_indent
	:	'set indent' J_int_literal 'to' Identifier -> ^(Set_indent ^(IDENT Identifier) ^(INT J_int_literal))
	;
	
split
	:	'split' Identifier -> ^(Split ^(IDENT Identifier))
	;
	
merge
	:	'merge' Identifier 'with' Identifier -> ^(Merge ^(IDENT1 Identifier) ^(IDENT2 Identifier))
	;
	
new_entry
	:	'new entry' Identifier ('as' j_expr)? -> ^(New_entry ^(IDENT Identifier) ^(STRING j_expr)? )
	;
	
set_value
	:	'set value' j_expr 'to' advanced_identifier -> ^(Set_value ^(ADV_IDENT advanced_identifier) ^(STRING j_expr))
	;
	
set_category
	:	'set category' j_expr 'to' advanced_identifier -> ^(Set_category ^(ADV_IDENT advanced_identifier) ^(CATEGORY j_expr))
	;
	
set_parent
	:	'set parent' advanced_identifier 'to' advanced_identifier -> ^(Set_parent ^(ADV_IDENT1 advanced_identifier) ^(ADV_IDENT2 advanced_identifier))
	;
	
group
	:	'group' advanced_identifier 'with' advanced_identifier -> ^(Group ^(ADV_IDENT1 advanced_identifier) ^(ADV_IDENT2 advanced_identifier))
	;
	
add_label
	:	'add label' j_expr ('of' j_expr)? 'to' advanced_identifier -> ^(Add_label ^(LABEL j_expr) ^(CATEGORY j_expr)? ^(ADV_IDENT advanced_identifier))
	;
	
new_label
	:	'new label' Identifier ('as' j_expr)? -> ^(New_label ^(IDENT Identifier) ^(STRING j_expr)?)
	;
	
update
	:	'update' advanced_identifier -> ^(Update ^(ADV_IDENT advanced_identifier))
	;
	
c_print
	:	('print'|'printf') j_expr -> ^(Print j_expr)
	;

advanced_identifier	
	:	Identifier ('.' query index?)?
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
	:	('$'|'_'|LETTER|DIGIT)('$'|'_'|LETTER|DIGIT)*

	;
index
	:	'[' J_int_literal ']' -> J_int_literal
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