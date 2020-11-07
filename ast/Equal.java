package ast;

import visitors.Visitor;

public class Equal extends BinOP{
    public Equal(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
