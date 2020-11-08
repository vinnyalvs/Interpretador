package ast;

import visitors.Visitor;

public class Lvalue_id extends Lvalue{

    public Lvalue_id(int line, int col, String id) {
        super(line, col, id);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
