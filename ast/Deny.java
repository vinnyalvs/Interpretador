package ast;

import visitors.Visitor;

public class Deny extends Expr{
    Expr expr;

    public Deny(int line, int col, Expr expr) {
        super(line, col);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
