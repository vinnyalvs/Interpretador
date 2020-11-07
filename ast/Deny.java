package ast;

import visitors.Visitor;

public class Deny extends Expr{
    Expr expr;

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
