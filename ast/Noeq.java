package ast;

import visitors.Visitor;

public class Noeq extends BinOP{
    public Noeq(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
