package ast;

import visitors.Visitor;

//Less Than
public class Lt extends BinOP{
    public Lt(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
