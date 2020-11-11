package ast;

import visitors.Visitor;

import java.util.ArrayList;
//ID OP_PARENTHESIS (exps)? CL_PARENTHESIS ( RELACIONAL lvalue ( COMMA lvalue )* GREATER_THAN )? SEMI #call
public class Call extends Cmd{
    private String id;
    ArrayList<Expr> exprs;
    ArrayList<Lvalue> rets;

    public Call(int line, int col, String id) {
        super(line, col);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public  ArrayList<Expr> getArgs() {
        return exprs;
    }

    public  ArrayList<Lvalue> getRets() {
        return rets;
    }

    public void addExpr(Expr exp) {
        this.exprs.add(exp);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
