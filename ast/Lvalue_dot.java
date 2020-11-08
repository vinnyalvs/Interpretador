package ast;

import visitors.Visitor;

public class Lvalue_dot extends Lvalue{
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
