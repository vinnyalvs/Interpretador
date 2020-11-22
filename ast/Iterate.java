package ast;

import visitors.Visitor;

//	ITERATE OP_PARENTHESIS exp CL_PARENTHESIS cmd #iterate

public class Iterate extends Cmd{
    Expr test;
    Cmd body;
    public static int itrCount = 0;
    int myCount;

    public Iterate(int line, int col, Expr test, Cmd body) {
        super(line, col);
        this.test = test;
        this.body = body;
    }

    public Expr getTest() {
        return test;
    }

    public Cmd getBody() {
        return body;
    }

    public int getMyCount() {
        return myCount;
    }

    public void setMyCount(int myCount) {
        this.myCount = myCount;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
