package ast;

import visitors.Visitor;

public class Iterate extends Node{
    Expr test;
    Node body;

    public Expr getTest() {
        return test;
    }

    public Node getBody() {
        return body;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
