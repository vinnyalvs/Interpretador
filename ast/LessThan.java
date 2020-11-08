package ast;

import visitors.Visitor;

//Less Than
public class LessThan extends BinOP{
    public LessThan(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
