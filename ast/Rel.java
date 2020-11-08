package ast;

import visitors.Visitor;

public class Rel extends BinOP {

    public Rel(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}