package ast;

import visitors.Visitor;

public class Read extends Node{
    Lvalue lv;

    public Lvalue getLv() {
        return lv;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
