package ast;

import visitors.Visitor;

//IF OP_PARENTHESIS exp CL_PARENTHESIS cmd #if
public class If extends Cmd{
    Expr test;
    Cmd then;

    public If(int line, int col, Expr test, Cmd then) {

        super(line, col);
        this.test = test;
        this.then = then;

    }

    public Expr getTest() {
        return test;
    }

    public Cmd getThen() {
        return then;
    }


    @Override
    public void accept(Visitor v) {v.visit(this);}
}
