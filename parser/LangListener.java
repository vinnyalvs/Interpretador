// Generated from /home/vinicius/Compiladores/TesteInterpretador/src/Lang.g4 by ANTLR 4.8

/* Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C  */
package parser;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(LangParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(LangParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(LangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(LangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(LangParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(LangParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(LangParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(LangParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_array}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType_array(LangParser.Type_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_array}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType_array(LangParser.Type_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_btype}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType_btype(LangParser.Type_btypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_btype}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType_btype(LangParser.Type_btypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_int}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterType_int(LangParser.Type_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_int}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitType_int(LangParser.Type_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_char}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterType_char(LangParser.Type_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_char}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitType_char(LangParser.Type_charContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_bool}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterType_bool(LangParser.Type_boolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_bool}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitType_bool(LangParser.Type_boolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_float}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterType_float(LangParser.Type_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_float}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitType_float(LangParser.Type_floatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_data}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterType_data(LangParser.Type_dataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_data}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitType_data(LangParser.Type_dataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmdlist}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmdlist(LangParser.CmdlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmdlist}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmdlist(LangParser.CmdlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIf(LangParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIf(LangParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_else}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIf_else(LangParser.If_elseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_else}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIf_else(LangParser.If_elseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterate}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIterate(LangParser.IterateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterate}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIterate(LangParser.IterateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterRead(LangParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitRead(LangParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterPrint(LangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitPrint(LangParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterReturn(LangParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitReturn(LangParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attr}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterAttr(LangParser.AttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attr}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitAttr(LangParser.AttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCall(LangParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCall(LangParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAnd(LangParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAnd(LangParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp_rexp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp_rexp(LangParser.Exp_rexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp_rexp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp_rexp(LangParser.Exp_rexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rexp_aexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterRexp_aexp(LangParser.Rexp_aexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rexp_aexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitRexp_aexp(LangParser.Rexp_aexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code less_than}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterLess_than(LangParser.Less_thanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code less_than}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitLess_than(LangParser.Less_thanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqeq}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterEqeq(LangParser.EqeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqeq}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitEqeq(LangParser.EqeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noeq}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterNoeq(LangParser.NoeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noeq}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitNoeq(LangParser.NoeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAdd(LangParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAdd(LangParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code diff}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterDiff(LangParser.DiffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code diff}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitDiff(LangParser.DiffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aexp_mexp}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAexp_mexp(LangParser.Aexp_mexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aexp_mexp}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAexp_mexp(LangParser.Aexp_mexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterDiv(LangParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitDiv(LangParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mod}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterMod(LangParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mod}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitMod(LangParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mul}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterMul(LangParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitMul(LangParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mexp_sexp}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void enterMexp_sexp(LangParser.Mexp_sexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mexp_sexp}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 */
	void exitMexp_sexp(LangParser.Mexp_sexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deny}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterDeny(LangParser.DenyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deny}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitDeny(LangParser.DenyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterMinus(LangParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitMinus(LangParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_true}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_true(LangParser.Literal_trueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_true}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_true(LangParser.Literal_trueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_false}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_false(LangParser.Literal_falseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_false}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_false(LangParser.Literal_falseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_null}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_null(LangParser.Literal_nullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_null}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_null(LangParser.Literal_nullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_int(LangParser.Literal_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_int(LangParser.Literal_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_float(LangParser.Literal_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_float(LangParser.Literal_floatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_char(LangParser.Literal_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_char(LangParser.Literal_charContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sexp_pexp}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterSexp_pexp(LangParser.Sexp_pexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sexp_pexp}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitSexp_pexp(LangParser.Sexp_pexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pexp_lvalue}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterPexp_lvalue(LangParser.Pexp_lvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pexp_lvalue}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitPexp_lvalue(LangParser.Pexp_lvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis_exp}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis_exp(LangParser.Parenthesis_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis_exp}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis_exp(LangParser.Parenthesis_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterNew(LangParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitNew(LangParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pexp_func}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void enterPexp_func(LangParser.Pexp_funcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pexp_func}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 */
	void exitPexp_func(LangParser.Pexp_funcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalue_dot}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue_dot(LangParser.Lvalue_dotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalue_dot}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue_dot(LangParser.Lvalue_dotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalue_id}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue_id(LangParser.Lvalue_idContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalue_id}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue_id(LangParser.Lvalue_idContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalue_array}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue_array(LangParser.Lvalue_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalue_array}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue_array(LangParser.Lvalue_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp_list}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExp_list(LangParser.Exp_listContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp_list}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExp_list(LangParser.Exp_listContext ctx);
}