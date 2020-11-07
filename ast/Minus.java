package ast;

import visitors.Visitor;

// 	MINUS sexp
//return - x
public class Minus extends Expr{
    Expr e;

    public Expr getE() {
        return e;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
