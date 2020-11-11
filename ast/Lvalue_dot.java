package ast;

import visitors.Visitor;

public class Lvalue_dot extends Lvalue{
    Lvalue lv;
    String id;
    public Lvalue_dot(int line, int col, Lvalue lv, String id) {
        super(line, col);
        this.lv = lv;
        this.id = id;
    }

    public Lvalue getLv() {
        return lv;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
