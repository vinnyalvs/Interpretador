package ast;

import visitors.Visitor;

public class Print extends Node{
    Expr expr;

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
