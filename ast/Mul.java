package ast;

import visitors.Visitor;

//mexp TIMES sexp #mul
public class Mul extends BinOP{

    public Mul(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
