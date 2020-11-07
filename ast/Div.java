package ast;

import visitors.Visitor;

public class Div extends BinOP{
    public Div(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
