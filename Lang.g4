
grammar Lang;

@header {
/* Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C  */
package parser;

}

prog :	data* func* ;
data :	DATA ID OP_BRACKET (decl)* CL_BRACKET ;
decl:	ID DOUBLECOLON type SEMI ;
func:	ID OP_PARENTHESIS (params)? CL_PARENTHESIS (COLON type (COMMA type)* )? OP_BRACKET (cmd)* CL_BRACKET ;
params:	ID DOUBLECOLON type ( COMMA  ID DOUBLECOLON type )* ;
type: type OP_SQBRACKET CL_SQBRACKET #type_array
    | btype #type_btype
;

btype:	INT #type_int
	|	CHAR #type_char
	|	BOOL #type_bool
	|	FLOAT #type_float
	|	ID #type_data
;
cmd:	OP_BRACKET  (cmd)* CL_BRACKET #cmdlist
	|	IF OP_PARENTHESIS exp CL_PARENTHESIS cmd #if
	|	IF OP_PARENTHESIS exp CL_PARENTHESIS cmd ELSE cmd #if_else
	|	ITERATE OP_PARENTHESIS exp CL_PARENTHESIS cmd #iterate
	|	READ lvalue SEMI #read
	|	PRINT exp SEMI  #print
	|	RETURN exp (COMMA exp)* SEMI #return
	|	lvalue EQ exp SEMI #attr
	|	ID OP_PARENTHESIS (exps)? CL_PARENTHESIS ( RELACIONAL lvalue ( COMMA lvalue )* GREATER_THAN )? SEMI #call
;
exp:    exp AND exp #and
    |   rexp #exp_rexp
;
rexp:	aexp RELACIONAL aexp #relacional
    |   rexp EQEQ aexp #eqeq
    |   rexp DIFF aexp #noeq
    |   aexp #rexp_aexp
;
aexp:   aexp PLUS mexp #add
    |   aexp MINUS mexp #diff
    |   mexp #aexp_mexp
;
mexp:	mexp TIMES sexp #mul
    |   mexp DIV sexp #div
    |   mexp MOD sexp #mod
    |   sexp #mexp_sexp
;
sexp:	DENY sexp #deny
	|	MINUS sexp #minus
	|	LITERAL_TRUE #literal_true
	|	LITERAL_FALSE #literal_false
	|	LITERAL_NULL #literal_null
	|	LITERAL_INT #literal_int
	|	LITERAL_FLOAT #literal_float
	|	LITERAL_CHAR #literal_char
	|	pexp #sexp_pexp
;
pexp:	lvalue #pexp_lvalue
	|	OP_PARENTHESIS exp CL_PARENTHESIS #parenthesis_exp
	|	NEW  type (OP_SQBRACKET exp CL_SQBRACKET)? #new
	|	ID OP_PARENTHESIS (exps)? CL_PARENTHESIS OP_SQBRACKET exp  #pexp_func
;
lvalue:	ID #lvalue_id
	|	lvalue OP_SQBRACKET exp CL_SQBRACKET #lvalue_array
	|	lvalue DOT ID #lvalue_dot
;
exps:	exp  (COMMA exp)* #exp_list  ;


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
