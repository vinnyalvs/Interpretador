package ast;

import visitors.Visitor;

public class Deny extends Expr{
    Expr expr;

    public Deny(int line, int col) {
        super(line, col);
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
