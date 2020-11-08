package ast;

import visitors.Visitor;

public class Lvalue_dot extends Lvalue{
    Expr e;
    String id;

    public Lvalue_dot(int line, int col) {
        super(line, col);
    }

    public Expr getE() {
        return e;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
