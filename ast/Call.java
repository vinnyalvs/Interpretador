package ast;

import visitors.Visitor;

import java.util.ArrayList;
//ID OP_PARENTHESIS (exps)? CL_PARENTHESIS ( RELACIONAL lvalue ( COMMA lvalue )* GREATER_THAN )? SEMI #call
public class Call extends Cmd{
    private String id;
    ExprList exprs;
    private String f_id;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
