package ast;

import visitors.Visitor;

public class Diff extends BinOP{
    public Diff(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
