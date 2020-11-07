
grammar Lang;

@header {
/* Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C  */
    package lang.parser;

}

prog :	data* func* ;
data :	DATA ID OP_BRACKET (decl)* CL_BRACKET ;
decl:	ID DOUBLECOLON type SEMI ;
func:	ID OP_PARENTHESIS (params)? CL_PARENTHESIS (COLON type (COMMA type)* )? OP_BRACKET (cmd)* CL_BRACKET ;
params:	ID DOUBLECOLON type ( COMMA  ID DOUBLECOLON type )* ;
type: type OP_SQBRACKET CL_SQBRACKET
    | btype
;

btype:	INT
	|	CHAR
	|	BOOL
	|	FLOAT
	|	ID
;
cmd:	OP_BRACKET  (cmd)* CL_BRACKET
	|	IF OP_PARENTHESIS exp CL_PARENTHESIS cmd
	|	IF OP_PARENTHESIS exp CL_PARENTHESIS cmd ELSE cmd
	|	ITERATE OP_PARENTHESIS exp CL_PARENTHESIS cmd
	|	READ lvalue SEMI
	|	PRINT exp SEMI
	|	RETURN exp (COMMA exp)* SEMI
	|	lvalue EQ exp SEMI
	|	ID OP_PARENTHESIS (exps)? CL_PARENTHESIS ( RELACIONAL lvalue ( COMMA lvalue )* GREATER_THAN )? SEMI
;
exp:    exp AND exp
    |   rexp
;
rexp:	aexp RELACIONAL aexp
    |   rexp EQEQ aexp
    |   rexp DIFF aexp
    |   aexp
;
aexp:   aexp PLUS mexp
    |   aexp MINUS mexp
    |   mexp
;
mexp:	mexp TIMES sexp
    |   mexp DIV sexp
    |   mexp MOD sexp
    |   sexp
;
sexp:	DENY sexp
	|	MINUS sexp
	|	LITERAL_TRUE
	|	LITERAL_FALSE
	|	LITERAL_NULL
	|	LITERAL_INT
	|	LITERAL_FLOAT
	|	LITERAL_CHAR
	|	pexp
;
pexp:	lvalue
	|	OP_PARENTHESIS exp CL_PARENTHESIS
	|	NEW  type (OP_SQBRACKET exp CL_SQBRACKET)?
	|	ID OP_PARENTHESIS (exps)? CL_PARENTHESIS OP_SQBRACKET exp CL_SQBRACKET
;
lvalue:	ID
	|	lvalue OP_SQBRACKET exp CL_SQBRACKET
	|	lvalue DOT ID
;
exps:	exp  (COMMA exp)*  ;


/* Regras Léxicas */
fragment DIGIT : [0-9] ;
fragment ALPHA : [A-Za-z] ;
/*;

*/
/* Palavras reservadas */
DATA: 'data';
NEW: 'new';
INT: 'Int';
FLOAT: 'Float';
BOOL: 'Bool';
CHAR: 'Char';
PRINT: 'print';
RETURN: 'return';
READ: 'read';
ITERATE: 'iterate';
IF: 'if';
ELSE: 'else';

//NAME_TYPE : [A-Z]('_'|[0-9]|[a-zA-Z])*;
ID: [A-Za-z]('_' | [0-9]|[a-zA-Z])*;


LITERAL_INT : [0-9]+;
LITERAL_FLOAT : [0-9]*'.'[0-9]+;
LITERAL_CHAR : '\'' ( '\\' [btnr"'\\] | ~[\r\n\\"] ) '\'' ;
LITERAL_TRUE : 'true';
LITERAL_FALSE : 'false';
LITERAL_NULL : 'null';

NEWLINE : '\r'? '\n' -> skip;
WHITESPACE : [ \t]+ -> skip;
LINE_COMMENT : '--' ~( '\r' | '\n' )* NEWLINE -> skip;
COMMENT:  '{-' .*? '*}' -> skip;



OP_BRACKET: '{';
CL_BRACKET : '}';
OP_PARENTHESIS : '(';
CL_PARENTHESIS : ')';
OP_SQBRACKET : '[' ;
CL_SQBRACKET : ']' ;

SEMI : ';';
DOT : '.';
COMMA: ',';
EQ: '=';
RELACIONAL: '<';
GREATER_THAN: '>';
EQEQ: '==';
DIFF: '!=';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
MOD: '%';
DENY: '!';
AND: '&&';
COLON: ':';
DOUBLECOLON: '::';
