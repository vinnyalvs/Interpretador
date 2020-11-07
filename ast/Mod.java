package ast;

import visitors.Visitor;

public class Mod extends BinOP{
    public Mod(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
