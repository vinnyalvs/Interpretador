package ast;

import visitors.Visitor;

public class Func extends Node{
    Param[] params;
    Return ret;
    String id;

    public Param[] getParams() {
        return params;
    }

    public Return getRet() {
        return ret;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
