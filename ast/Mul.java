package ast;

import visitors.Visitor;

public class Mul extends BinOP{
    public Mul(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
