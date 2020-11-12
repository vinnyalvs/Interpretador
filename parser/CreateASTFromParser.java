/*
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C
*/
package parser;

import ast.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Data node_data = new Data(line, column, ctx.ID().getText());

        SuperNode result = this.defaultResult();
        int n = ctx.decl().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.decl(i);
            SuperNode childResult = c.accept(this);
            node_data.addDecl((Decl) this.aggregateResult(result, childResult));
        }

        return node_data;
    }

    @Override
    public SuperNode visitDecl(LangParser.DeclContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Type t = (Type) ctx.type().accept(this);

        Decl node_decl = new Decl(line, column, ctx.ID().getText(), t);

        return node_decl;
    }

    @Override
    public SuperNode visitFunc(LangParser.FuncContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Func funcNode = new Func(line, column, ctx.ID().getText());
        ParamList prms = null;
        if(ctx.params()!= null) {
            prms = (ParamList) ctx.params().accept(this);
            funcNode.setParamList(prms);
        }

        SuperNode result = this.defaultResult();
        int n = ctx.type().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.type(i);
            SuperNode childResult = c.accept(this);
            funcNode.addReturn((Type) this.aggregateResult(result, childResult));
        }

        result = this.defaultResult();
        n = ctx.cmd().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.cmd(i);
            SuperNode childResult = c.accept(this);
            funcNode.addCmd((Cmd) this.aggregateResult(result, childResult));
        }

        return funcNode;
    }

    @Override
    public SuperNode visitParams(LangParser.ParamsContext ctx) {
       int line = ctx.getStart().getLine();
       int column = ctx.getStart().getCharPositionInLine();
       ParamList paramsNode = new ParamList(line, column);
       SuperNode result = this.defaultResult();

        for(int i = 0; i < ctx.type().size() && this.shouldVisitNextChild(ctx, result); ++i) {
           // ParseTree c = ctx.type(i);
            //SuperNode childResult = c.accept(this);
            Type t = (Type) ctx.type(i).accept(this);
            String type_id = ctx.ID(i).getText();
            paramsNode.addParam(type_id,t);


        }
        return paramsNode;
    }


    @Override
    public SuperNode visitType_array(LangParser.Type_arrayContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Type t;
        TyArray ta;

        t = (Type) ctx.type().accept(this);

        ta = new TyArray(line, column, t);

        return ta;
    }

    @Override
    public SuperNode visitType_btype(LangParser.Type_btypeContext ctx) {
        return super.visitType_btype(ctx);
    }

    @Override
    public SuperNode visitType_int(LangParser.Type_intContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        TyInt t = new TyInt(line, column);
        return t;
    }

    @Override
    public SuperNode visitType_char(LangParser.Type_charContext ctx){
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        TyChar t = new TyChar(line, column);
        return t;
    }

    @Override
    public SuperNode visitType_bool(LangParser.Type_boolContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        TyBool t = new TyBool(line, column);
        return t;
    }

    @Override
    public SuperNode visitType_float(LangParser.Type_floatContext ctx){
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        TyFloat t = new TyFloat(line, column);
        return t;
    }

    @Override
    public SuperNode visitType_data(LangParser.Type_dataContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        TyData t = new TyData(line, column, ctx.ID().getText());
        return t;
    }

    @Override
    public SuperNode visitCmdlist(LangParser.CmdlistContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        CmdList cmd_node = new CmdList(line, column);

        SuperNode result = this.defaultResult();
        int n = ctx.cmd().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.cmd(i);
            SuperNode childResult = c.accept(this);
            cmd_node.add((Cmd) this.aggregateResult(result, childResult));
        }

        return cmd_node;
    }

    @Override
    public SuperNode visitIf(LangParser.IfContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Expr e = (Expr)ctx.exp().accept(this);
        Cmd c = (Cmd)ctx.cmd().accept(this);

        If node_if = new If(line,column,e,c);

        return node_if;
    }

    @Override
    public SuperNode visitIf_else(LangParser.If_elseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Expr e = (Expr)ctx.exp().accept(this);
        Cmd then = (Cmd)ctx.cmd().get(0).accept(this);
        Cmd els = (Cmd)ctx.cmd().get(1).accept(this);

        If_else node_if_else = new If_else(line,column,e,then,els);

        return node_if_else;
    }

    @Override
    public SuperNode visitIterate(LangParser.IterateContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Expr e = (Expr)ctx.exp().accept(this);
        Cmd body = (Cmd)ctx.cmd().accept(this);
        Iterate node_iterate = new Iterate(line,column,e,body);

        return node_iterate;
    }

    @Override
    public SuperNode visitRead(LangParser.ReadContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Lvalue lv = (Lvalue)ctx.lvalue().accept(this);
        Read node = new Read(line, column, lv);
        return node;
    }

    @Override
    public SuperNode visitPrint(LangParser.PrintContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Expr e = (Expr)ctx.exp().accept(this);
        Print node = new Print(line, column, e);
        return node;
    }

    @Override
    public SuperNode visitReturn(LangParser.ReturnContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Return node_return = new Return(line,column);

        SuperNode result = this.defaultResult();
        int n = ctx.exp().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.exp(i);
            SuperNode childResult = c.accept(this);
            node_return.add((Expr) this.aggregateResult(result, childResult));
        }

        return node_return;
    }

    @Override
    public SuperNode visitAttr(LangParser.AttrContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr e = (Expr)ctx.exp().accept(this);
        Lvalue lv = (Lvalue)ctx.lvalue().accept(this);

        Attr attr = new Attr(line, column, lv, e);
        return attr;
    }

    @Override
    public SuperNode visitCall(LangParser.CallContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Call node_call = new Call(line, column, ctx.ID().getText());

        if(ctx.exps() != null){
            ExprList exprlist = (ExprList) ctx.exps().accept(this);
            node_call.setExprs(exprlist);
        }

        SuperNode result = this.defaultResult();
        int n = ctx.lvalue().size();

        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.lvalue(i);
            SuperNode childResult = c.accept(this);
            node_call.addReturn((Lvalue) this.aggregateResult(result, childResult));
        }


        return node_call;


    }

    @Override
    public SuperNode visitAnd(LangParser.AndContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.exp().get(0).accept(this);
        Expr dir = (Expr)ctx.exp().get(1).accept(this);

        And node = new And(line, column, esq, dir);
        return node;
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
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.aexp().get(0).accept(this);
        Expr dir = (Expr)ctx.aexp().get(1).accept(this);

        LessThan node = new LessThan(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitEqeq(LangParser.EqeqContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.rexp().accept(this);
        Expr dir = (Expr)ctx.aexp().accept(this);

        Equal node = new Equal(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitNoeq(LangParser.NoeqContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.rexp().accept(this);
        Expr dir = (Expr)ctx.aexp().accept(this);

        Noeq node = new Noeq(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitAdd(LangParser.AddContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.aexp().accept(this);
        Expr dir = (Expr)ctx.mexp().accept(this);

        Add node = new Add(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitDiff(LangParser.DiffContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.aexp().accept(this);
        Expr dir = (Expr)ctx.mexp().accept(this);

        Diff node = new Diff(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitAexp_mexp(LangParser.Aexp_mexpContext ctx) {
        return super.visitAexp_mexp(ctx);
    }

    @Override
    public SuperNode visitDiv(LangParser.DivContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.mexp().accept(this);
        Expr dir = (Expr)ctx.sexp().accept(this);

        Div node = new Div(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitMod(LangParser.ModContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.mexp().accept(this);
        Expr dir = (Expr)ctx.sexp().accept(this);

        Mod node = new Mod(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitMul(LangParser.MulContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr esq = (Expr)ctx.mexp().accept(this);
        Expr dir = (Expr)ctx.sexp().accept(this);

        Mul node = new Mul(line, column, esq, dir);
        return node;
    }

    @Override
    public SuperNode visitMexp_sexp(LangParser.Mexp_sexpContext ctx) {
        return super.visitMexp_sexp(ctx);
    }

    @Override
    public SuperNode visitDeny(LangParser.DenyContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr e = (Expr)ctx.sexp().accept(this);

        Deny node = new Deny(line, column, e);
        return node;
    }

    @Override
    public SuperNode visitMinus(LangParser.MinusContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Expr e = (Expr)ctx.sexp().accept(this);

        Minus node = new Minus(line, column, e);
        return node;
    }

    @Override
    public SuperNode visitLiteral_true(LangParser.Literal_trueContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        LiteralTrue litNode = new LiteralTrue(line, column);
        return litNode;
    }

    @Override
    public SuperNode visitLiteral_false(LangParser.Literal_falseContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        LiteralFalse litNode = new LiteralFalse(line, column);
        return litNode;
    }

    @Override
    public SuperNode visitLiteral_null(LangParser.Literal_nullContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        LiteralNull litNode = new LiteralNull(line, column);
        return litNode;
    }

    @Override
    public SuperNode visitLiteral_int(LangParser.Literal_intContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        LiteralInt litNode = new LiteralInt(line, column, Integer.parseInt(ctx.LITERAL_INT().getText()));
        return litNode;
    }

    @Override
    public SuperNode visitLiteral_float(LangParser.Literal_floatContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        LiteralFloat litNode = new LiteralFloat(line, column, Float.parseFloat(ctx.LITERAL_FLOAT().getText()));
        return litNode;
    }

    @Override
    public SuperNode visitLiteral_char(LangParser.Literal_charContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        String original_text = ctx.LITERAL_CHAR().getText();
        //Criar HashMap como um dicionário mapeando os caracteres.
        HashMap<String,String> dict = new HashMap<String,String>();
        dict.put("'\\\\'", "'\\'");
        dict.put("'\\n'", "'\n'");
        dict.put("'\\r'", "'\r'");
        dict.put("'\\t'", "'\t'");
        dict.put("'\\b'", "'\b'");
        dict.put("'\\''", "'''");
        dict.put("'\\\"'", "'\"'");

        String new_string = original_text;

        Iterator it = dict.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            new_string = new_string.replace((String) pair.getKey(), (String)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

        Character c = new_string.charAt(1);


        LiteralChar litNode = new LiteralChar(line, column, c);
        return litNode;

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
        Expr e = (Expr) ctx.exp().accept(this);
        return e;
    }

    @Override
    public SuperNode visitNew(LangParser.NewContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Type t = (Type) ctx.type().accept(this);
        Expr e = null;
        if (ctx.exp() != null)
           e = (Expr) ctx.exp().accept(this);

        New node = new New(line, column, t, e);

        return node;
    }

    @Override
    public SuperNode visitPexp_func(LangParser.Pexp_funcContext ctx) {
        return super.visitPexp_func(ctx);
    }

    @Override
    public SuperNode visitLvalue_dot(LangParser.Lvalue_dotContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Lvalue lv = (Lvalue) ctx.lvalue().accept(this);

        Lvalue_dot node = new Lvalue_dot(line, column, lv, ctx.ID().getText());

        return node;
    }

    @Override
    public SuperNode visitLvalue_id(LangParser.Lvalue_idContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Lvalue_id node = new Lvalue_id(line, column, ctx.ID().getText());
        return node;
    }

    @Override
    public SuperNode visitLvalue_array(LangParser.Lvalue_arrayContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Lvalue l = (Lvalue) ctx.lvalue().accept(this);
        Expr e = (Expr) ctx.exp().accept(this);

        Lvalue_array node = new Lvalue_array(line, column, l, e);

        return node;
    }

    @Override
    public SuperNode visitExp_list(LangParser.Exp_listContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        ExprList node_expr_list = new ExprList(line,column);

        SuperNode result = this.defaultResult();
        int n = ctx.exp().size();
        for(int i = 0; i < n && this.shouldVisitNextChild(ctx, result); ++i) {
            ParseTree c = ctx.exp(i);
            SuperNode childResult = c.accept(this);
            node_expr_list.add((Expr) this.aggregateResult(result, childResult));
        }
        return node_expr_list;

    }

}





