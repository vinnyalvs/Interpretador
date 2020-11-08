package ast;

import visitors.Visitor;

public abstract class Lvalue extends Expr{
    String id;

    public Lvalue(int line, int col, String id) {
        super(line, col);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
