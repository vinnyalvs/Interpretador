package ast;

import visitors.Visitor;

public class If extends Node{
    Expr test;
    Node then;

    public Expr getTest() {
        return test;
    }

    public Node getThen() {
        return then;
    }


    @Override
    public void accept(Visitor v) {v.visit(this);}
}
