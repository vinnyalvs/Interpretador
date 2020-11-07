package ast;

import visitors.Visitor;

public class And extends BinOP{
    public And(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
