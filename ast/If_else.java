package ast;

import visitors.Visitor;

//IF OP_PARENTHESIS exp CL_PARENTHESIS cmd ELSE cmd #if_else
public class If_else extends If {

    Cmd els;

    public If_else(int line, int col, Expr test, Cmd then, Cmd els) {
        super(line, col,test,then);
        this.els = els;
    }

    public Node getElse() {
        return els;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
