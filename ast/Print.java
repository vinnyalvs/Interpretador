package ast;

import visitors.Visitor;

public class Print extends Cmd{
    Expr expr;

    public Print(int line, int col, Expr expr) {
        super(line, col);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
