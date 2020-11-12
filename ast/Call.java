package ast;

import visitors.Visitor;

import java.util.ArrayList;
//ID OP_PARENTHESIS (exps)? CL_PARENTHESIS ( RELACIONAL lvalue ( COMMA lvalue )* GREATER_THAN )? SEMI #call
public class Call extends Cmd{
    private String id;
    ExprList exprs;

    ArrayList<Lvalue> rets;

    public Call(int line, int col, String id) {
        super(line, col);
        this.id = id;
        rets = new ArrayList<Lvalue>();
    }

    public String getId() {
        return id;
    }

    public ExprList getArgs() {
        return exprs;
    }

    public  ArrayList<Lvalue> getRets() {
        return rets;
    }

    public void setExprs(ExprList exprs) {
        this.exprs = exprs;
    }

    public void addReturn(Lvalue ret) {
        this.rets.add(ret);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
