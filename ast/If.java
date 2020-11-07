package ast;

import visitors.Visitor;

public class If extends Node{
    Expr test;
    Node then;
    Node els;

    public Expr getTest() {
        return test;
    }

    public Node getThen() {
        return then;
    }

    public Node getElse() {
        return els;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
