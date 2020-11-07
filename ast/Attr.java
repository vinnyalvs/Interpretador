package ast;

import visitors.Visitor;

public class Attr extends Node{
    Lvalue lv;
    Expr e;

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
