package ast;

import visitors.Visitor;

public class Add extends BinOP {

    public Add(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
