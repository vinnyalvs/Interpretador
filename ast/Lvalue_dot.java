package ast;

import visitors.Visitor;

public class Lvalue_dot extends Lvalue{
    public Lvalue_dot(int line, int col, String id) {
        super(line, col, id);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
