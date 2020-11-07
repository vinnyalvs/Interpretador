package ast;

import visitors.Visitor;

public class BinOP extends Expr{
    Expr l;
    Expr r;

    public BinOP(Expr l, Expr r) {
        this.l = l;
        this.r = r;
    }

    public Expr getL() {
        return l;
    }

    public Expr getR() {
        return r;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
