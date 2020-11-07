package ast;

import visitors.Visitor;

public class Rel extends BinOP {
    public Rel(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}