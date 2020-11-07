package ast;

import visitors.Visitor;

public class Param extends Node{
    Type type;
    String id;

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
