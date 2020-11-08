package parser;

import ast.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Stack;

public class CreateASTFromParser extends LangBaseVisitor<SuperNode> {

    @Override
    public SuperNode visitProg(LangParser.ProgContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Program program_node = new Program(line, column);

        SuperNode result = this.defaultResult();
        int n = ctx.data().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.data(i);
            SuperNode childResult = c.accept(this);
            program_node.addData((Data) this.aggregateResult(result, childResult));
        }

        result = this.defaultResult();
        n = ctx.func().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.func(i);
            SuperNode childResult = c.accept(this);
            program_node.addFunc((Func) this.aggregateResult(result, childResult));
        }
        return program_node;
    }

    @Override
    public SuperNode visitData(LangParser.DataContext ctx) {
        return super.visitData(ctx);
    }

    @Override
    public SuperNode visitDecl(LangParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public SuperNode visitFunc(LangParser.FuncContext ctx) {
        return super.visitFunc(ctx);
    }

    @Override
    public SuperNode visitParams(LangParser.ParamsContext ctx) {
        return super.visitParams(ctx);
    }

    @Override
    public SuperNode visitType_array(LangParser.Type_arrayContext ctx) {
        return super.visitType_array(ctx);
    }

    @Override
    public SuperNode visitType_btype(LangParser.Type_btypeContext ctx) {
        return super.visitType_btype(ctx);
    }

    @Override
    public SuperNode visitType_int(LangParser.Type_intContext ctx) {
        return super.visitType_int(ctx);
    }

    @Override
    public SuperNode visitType_char(LangParser.Type_charContext ctx) {
        return super.visitType_char(ctx);
    }

    @Override
    public SuperNode visitType_bool(LangParser.Type_boolContext ctx) {
        return super.visitType_bool(ctx);
    }

    @Override
    public SuperNode visitType_float(LangParser.Type_floatContext ctx) {
        return super.visitType_float(ctx);
    }

    @Override
    public SuperNode visitType_data(LangParser.Type_dataContext ctx) {
        return super.visitType_data(ctx);
    }

    @Override
    public SuperNode visitCmdlist(LangParser.CmdlistContext ctx) {
        return super.visitCmdlist(ctx);
    }

    @Override
    public SuperNode visitIf(LangParser.IfContext ctx) {
        return super.visitIf(ctx);
    }

    @Override
    public SuperNode visitIf_else(LangParser.If_elseContext ctx) {
        return super.visitIf_else(ctx);
    }

    @Override
    public SuperNode visitIterate(LangParser.IterateContext ctx) {
        return super.visitIterate(ctx);
    }

    @Override
    public SuperNode visitRead(LangParser.ReadContext ctx) {
        return super.visitRead(ctx);
    }

    @Override
    public SuperNode visitPrint(LangParser.PrintContext ctx) {
        return super.visitPrint(ctx);
    }

    @Override
    public SuperNode visitReturn(LangParser.ReturnContext ctx) {
        return super.visitReturn(ctx);
    }

    @Override
    public SuperNode visitAttr(LangParser.AttrContext ctx) {
        return super.visitAttr(ctx);
    }

    @Override
    public SuperNode visitCall(LangParser.CallContext ctx) {
        return super.visitCall(ctx);
    }

    @Override
    public SuperNode visitAnd(LangParser.AndContext ctx) {
        return super.visitAnd(ctx);
    }

    @Override
    public SuperNode visitExp_rexp(LangParser.Exp_rexpContext ctx) {
        return super.visitExp_rexp(ctx);
    }
    @Override
    public SuperNode visitRexp_aexp(LangParser.Rexp_aexpContext ctx) {
        return super.visitRexp_aexp(ctx);
    }

    @Override
    public SuperNode visitLess_than(LangParser.Less_thanContext ctx) {
        return super.visitLess_than(ctx);
    }

    @Override
    public SuperNode visitEqeq(LangParser.EqeqContext ctx) {
        return super.visitEqeq(ctx);
    }

    @Override
    public SuperNode visitNoeq(LangParser.NoeqContext ctx) {
        return super.visitNoeq(ctx);
    }

    @Override
    public SuperNode visitAdd(LangParser.AddContext ctx) {
        return super.visitAdd(ctx);
    }

    @Override
    public SuperNode visitDiff(LangParser.DiffContext ctx) {
        return super.visitDiff(ctx);
    }

    @Override
    public SuperNode visitAexp_mexp(LangParser.Aexp_mexpContext ctx) {
        return super.visitAexp_mexp(ctx);
    }

    @Override
    public SuperNode visitDiv(LangParser.DivContext ctx) {
        return super.visitDiv(ctx);
    }

    @Override
    public SuperNode visitMod(LangParser.ModContext ctx) {
        return super.visitMod(ctx);
    }

    @Override
    public SuperNode visitMul(LangParser.MulContext ctx) {
        return super.visitMul(ctx);
    }

    @Override
    public SuperNode visitMexp_sexp(LangParser.Mexp_sexpContext ctx) {
        return super.visitMexp_sexp(ctx);
    }

    @Override
    public SuperNode visitDeny(LangParser.DenyContext ctx) {
        return super.visitDeny(ctx);
    }

    @Override
    public SuperNode visitMinus(LangParser.MinusContext ctx) {
        return super.visitMinus(ctx);
    }

    @Override
    public SuperNode visitLiteral_true(LangParser.Literal_trueContext ctx) {
        return super.visitLiteral_true(ctx);
    }

    @Override
    public SuperNode visitLiteral_false(LangParser.Literal_falseContext ctx) {
        return super.visitLiteral_false(ctx);
    }

    @Override
    public SuperNode visitLiteral_null(LangParser.Literal_nullContext ctx) {
        return super.visitLiteral_null(ctx);
    }

    @Override
    public SuperNode visitLiteral_int(LangParser.Literal_intContext ctx) {
        return super.visitLiteral_int(ctx);
    }

    @Override
    public SuperNode visitLiteral_float(LangParser.Literal_floatContext ctx) {
        return super.visitLiteral_float(ctx);
    }

    @Override
    public SuperNode visitLiteral_char(LangParser.Literal_charContext ctx) {
        return super.visitLiteral_char(ctx);
    }

    @Override
    public SuperNode visitSexp_pexp(LangParser.Sexp_pexpContext ctx) {
        return super.visitSexp_pexp(ctx);
    }

    @Override
    public SuperNode visitPexp_lvalue(LangParser.Pexp_lvalueContext ctx) {
        return super.visitPexp_lvalue(ctx);
    }

    @Override
    public SuperNode visitParenthesis_exp(LangParser.Parenthesis_expContext ctx) {
        return super.visitParenthesis_exp(ctx);
    }

    @Override
    public SuperNode visitNew(LangParser.NewContext ctx) {
        return super.visitNew(ctx);
    }

    @Override
    public SuperNode visitPexp_func(LangParser.Pexp_funcContext ctx) {
        return super.visitPexp_func(ctx);
    }

    @Override
    public SuperNode visitLvalue_dot(LangParser.Lvalue_dotContext ctx) {
        return super.visitLvalue_dot(ctx);
    }

    @Override
    public SuperNode visitLvalue_id(LangParser.Lvalue_idContext ctx) {
        return super.visitLvalue_id(ctx);
    }

    @Override
    public SuperNode visitLvalue_array(LangParser.Lvalue_arrayContext ctx) {
        return super.visitLvalue_array(ctx);
    }

    @Override
    public SuperNode visitExp_list(LangParser.Exp_listContext ctx) {
        return super.visitExp_list(ctx);
    }

}





