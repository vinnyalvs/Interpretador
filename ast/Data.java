package ast;

import visitors.Visitor;

public class Data extends Node{
    String id;
    Decl[] decl;

    public String getId() {
        return id;
    }

    public Decl[] getDecl() {
        return decl;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
