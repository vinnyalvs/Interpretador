package ast;

import visitors.Visitor;

public class Lvalue extends Expr{
    Expr e;
    String id;

    public Expr getE() {
        return e;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
