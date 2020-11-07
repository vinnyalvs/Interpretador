package ast;

import visitors.Visitor;

public class Expr extends Node{

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
