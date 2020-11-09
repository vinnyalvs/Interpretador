package ast;

import visitors.Visitor;

public class Iterate extends Cmd{
    Expr test;
    Cmd body;

    public Iterate(int line, int col, Expr test, Cmd body) {
        super(line, col);
        this.test = test;
        this.body = body;
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
