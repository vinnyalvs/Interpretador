package ast;

import visitors.Visitor;

public class Neq extends BinOP{
    public Neq(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
