package ast;

import visitors.Visitor;

// mexp MOD sexp #mod

public class Mod extends BinOP{

    public Mod(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
