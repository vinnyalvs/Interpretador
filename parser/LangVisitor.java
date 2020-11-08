// Generated from /home/vinicius/Compiladores/TesteInterpretador/src/Lang.g4 by ANTLR 4.8

/* Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C  */
package parser;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(LangParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(LangParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(LangParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(LangParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_array}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_array(LangParser.Type_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_btype}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_btype(LangParser.Type_btypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_int}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_int(LangParser.Type_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_char}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_char(LangParser.Type_charContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_bool}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_bool(LangParser.Type_boolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_float}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_float(LangParser.Type_floatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_data}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_data(LangParser.Type_dataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmdlist}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdlist(LangParser.CmdlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(LangParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_else}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else(LangParser.If_elseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterate}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterate(LangParser.IterateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code read}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(LangParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(LangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(LangParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attr}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr(LangParser.AttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LangParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(LangParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp_rexp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_rexp(LangParser.Exp_rexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rexp_aexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRexp_aexp(LangParser.Rexp_aexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code less_than}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess_than(LangParser.Less_thanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqeq}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqeq(LangParser.EqeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noeq}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoeq(LangParser.NoeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(LangParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code diff}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiff(LangParser.DiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aexp_mexp}
	 * labeled alternative in {@link LangParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexp_mexp(LangParser.Aexp_mexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(LangParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mod}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(LangParser.ModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(LangParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mexp_sexp}
	 * labeled alternative in {@link LangParser#mexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMexp_sexp(LangParser.Mexp_sexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deny}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeny(LangParser.DenyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(LangParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_true}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_true(LangParser.Literal_trueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_false}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_false(LangParser.Literal_falseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_null}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_null(LangParser.Literal_nullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_int(LangParser.Literal_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_float(LangParser.Literal_floatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_char(LangParser.Literal_charContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sexp_pexp}
	 * labeled alternative in {@link LangParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSexp_pexp(LangParser.Sexp_pexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pexp_lvalue}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPexp_lvalue(LangParser.Pexp_lvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis_exp}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis_exp(LangParser.Parenthesis_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(LangParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pexp_func}
	 * labeled alternative in {@link LangParser#pexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPexp_func(LangParser.Pexp_funcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalue_dot}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue_dot(LangParser.Lvalue_dotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalue_id}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue_id(LangParser.Lvalue_idContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalue_array}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue_array(LangParser.Lvalue_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp_list}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_list(LangParser.Exp_listContext ctx);
}