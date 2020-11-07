package ast;

import visitors.Visitor;

public class Return extends Node{
    private Expr[] args;

    public Expr[] getArgs() {
        return args;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
