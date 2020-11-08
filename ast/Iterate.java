package ast;

import visitors.Visitor;

public class Iterate extends Cmd{
    Expr test;
    Node body;

    public Iterate(int line, int col) {
        super(line, col);
    }

    public Expr getTest() {
        return test;
    }

    public Node getBody() {
        return body;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
