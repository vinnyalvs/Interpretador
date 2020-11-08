package ast;

import visitors.Visitor;

public abstract class Cmd extends Node{
    @Override
    public void accept(Visitor v) {v.visit(this);}

    public Cmd(int line, int col) {
        super(line, col);
    }
}
