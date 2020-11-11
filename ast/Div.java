package ast;

import visitors.Visitor;

//mexp DIV sexp #div
public class Div extends BinOP{

    public Div(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
