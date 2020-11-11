package ast;

import visitors.Visitor;

public class New extends Expr{

    Type t;
    Expr e;

    public New(int line, int col, Type t, Expr e) {
        super(line, col);
        this.t = t;
        this.e = e;
    }

    public Type getT() {
        return t;
    }

    public Expr getE() {
        return e;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
