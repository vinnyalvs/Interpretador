package ast;

import visitors.Visitor;

public class Decl extends Node{
    String id;
    Type type;

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
