grammar CRL;

options {

	language=Java;
	TokenLabelType=CommonToken;
	output=AST;
	ASTLabelType=CommonTree;
	backtrack = true;
}

tokens {
	IMPORTS;
	IMPORT;
	RULES;
	RULE;
	CONDITIONS;
	CONDITION;
	TYPE;
	QUERY;
	IDENTIFIER;
	CONSTRAINTS;
	CONSTRAINT;
	ASSIGNMENT;
	EXPRESSION;
	ACTIONS;
	ACTION;
	OPERAND;
}

@header {
package ru.icc.td.tabbyxl.crl2j.parsing;
}

@lexer::header {
package ru.icc.td.tabbyxl.crl2j.parsing;
}

// parser

ruleset
	:	importing*
		rule*
		-> ^(IMPORTS importing*) ^(RULES rule*)
	;

importing
scope {
	String value;
}
@init { $importing::value = "import static "; }
	:	'import static' id = ID { $importing::value+=$id.text; } ('.' id = ID { $importing::value+="."+$id.text; } )* ('.*' { $importing::value+=".*"; })? ';'? EOL
		-> IMPORT [$importing::value]
	;
	
rule 	
	:	'rule #' num=INT EOL
		'when' EOL
			condition*
		'then' EOL
			action*
		'end' EOL?
		-> ^(RULE[$num] ^(CONDITIONS condition*) ^(ACTIONS action*))
	;
	
condition 
scope { 
	String quantifier;
	String id; 
}
@init { 
	$condition::quantifier = "EXIST";
	$condition::id = null;
}
	:	('no' { $condition::quantifier = "NOT_EXIST"; })?
		query 
		( idntfr = ID { $condition::id = $idntfr.text; } )? { $condition::id = ( ($condition::id == null)? "null":$condition::id ); } 
		(
		':' 
		( (constraint (',' constraint)* (',' assignment)? ) | assignment )
		)? EOL
		-> ^( CONDITION TYPE[$condition::quantifier] query IDENTIFIER[$condition::id] ^(CONSTRAINTS ^(CONSTRAINT constraint)*) ^(ASSIGNMENT assignment?) )
	;
	
query
	:	('cell'|'cells') -> QUERY["CCell"]
		|('label'|'labels') -> QUERY["CLabel"]
		|('entry'|'entries') -> QUERY["CEntry"]
		|('category'|'categories') -> QUERY["CCategory"]
	;
	
constraint
	:	(~(','|EOL|':'))+
	;
	
assignment
	:	id = ID ':' expression
		-> IDENTIFIER[$id] ^(EXPRESSION expression)
	;
	
expression
	:	( ESC_SEQ| ~(EOL))+
	;

action 	
	:	set_tag
		|set_text
		|set_indent
		|split
		|merge
		|new_entry
		|set_value
		|set_category
		|set_parent
		|group
		|add_label
		|new_label
		|print
	;
	
operand
	:	( STRING | ESC_SEQ | ~('to'|'with'|'as'|'of'|EOL))+
	;

set_tag
	:	'set tag' op1 = operand 'to' op2 = operand EOL
		-> ^(ACTION["setTag"] ^(OPERAND $op2) ^(OPERAND $op1))
	;
	
set_text
	:	'set text' op1 = operand 'to' op2 = operand EOL
		-> ^(ACTION["setText"] ^(OPERAND $op2) ^(OPERAND $op1))
	;
	
set_indent
	:	'set indent' op1 = operand 'to' op2 = operand EOL
		-> ^(ACTION["setIndent"] ^(OPERAND $op2) ^(OPERAND $op1))
	;
	
split
	:	'split' operand EOL
		-> ^( ACTION["split"] ^(OPERAND operand))
	;
	
merge
	:	'merge' op1 = operand 'with' op2 = operand EOL
		-> ^(ACTION["merge"] ^(OPERAND $op2) ^(OPERAND $op1))
	;
	
new_entry
	:	'new entry' op1 = operand ('as' op2 = operand)? EOL
		-> ^(ACTION["newEntry"] ^(OPERAND $op1) ^(OPERAND $op2)?)
	;
	
set_value
	:	'set value' op1 = operand 'to' op2 = operand EOL
		-> ^(ACTION["setValue"] ^(OPERAND $op2) ^(OPERAND $op1))
	;
	
set_category
	:	'set category' op1 = operand 'to' op2 = operand EOL
		-> ^(ACTION["setCategory"] ^(OPERAND $op2) ^(OPERAND $op1))
	;
	
set_parent
	:	'set parent' op1 = operand 'to' op2 = operand EOL
		-> ^(ACTION["setParent"] ^(OPERAND $op2) ^(OPERAND $op1))
	;
	
group
	:	'group' op1 = operand 'with' op2 = operand EOL
		-> ^(ACTION["group"] ^(OPERAND $op1) ^(OPERAND $op2))
	;
	
add_label
	:	'add label' op1 = operand ('of' op2 = operand)? 'to' op3 = operand EOL
		-> ^(ACTION["addLabel"] ^(OPERAND $op3) ^(OPERAND $op1) ^(OPERAND $op2)?)
	;
	
new_label
	:	'new label' op1 = operand ('as' op2 = operand)? EOL
		-> ^(ACTION["newLabel"] ^(OPERAND $op1) ^(OPERAND $op2)?)
	;
	
print
	:	name = ('print'|'printf') operand EOL
		-> ^(ACTION[$name] ^(OPERAND operand))
	;

//lexer

ID  :	('a'..'z'|'A'..'Z'|'_'|'$') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'$')*
    ;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

OPERATOR 
	:	('='|'>'|'<'|'&'|'|'|'+'|'-'|'*'|'/'|'%'|'!')+	
	;
	
BRACKET
	:	'('|')'|'['|']'|'{'|'}'
	;
	
EOL 
    	:	(('\r')? '\n')+
    	;
	
fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'f'|'t'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
  
