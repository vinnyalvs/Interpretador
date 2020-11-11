package ast;

import visitors.Visitor;

public abstract class Lvalue extends Expr{

    public Lvalue(int line, int col) {
        super(line, col);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
