package ast;

import visitors.Visitor;

public class BinOP extends Expr{
    Expr l;
    Expr r;

    public BinOP(int line, int col, Expr l, Expr r) {
        super(line, col);
        this.l = l;
        this.r = r;
    }

    public Expr getL() {
        return l;
    }

    public Expr getR() {
        return r;
    }

    public void setLeft(Expr n){  l = n; }
    public void setRight(Expr n){ r = n; }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
