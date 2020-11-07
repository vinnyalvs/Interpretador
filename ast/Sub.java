package ast;

import visitors.Visitor;

public class Sub extends BinOP{
    public Sub(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
