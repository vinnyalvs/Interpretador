package ast;

import visitors.Visitor;

public class Expr extends Node{
    public Expr(int line, int col) {
        super(line, col);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
