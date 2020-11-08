package ast;

import visitors.Visitor;

public class If extends Cmd{
    Expr test;
    Node then;

    public If(int line, int col) {
        super(line, col);
    }

    public Expr getTest() {
        return test;
    }

    public Node getThen() {
        return then;
    }


    @Override
    public void accept(Visitor v) {v.visit(this);}
}
