package ast;

import visitors.Visitor;


//aexp MINUS mexp #diff
public class Diff extends BinOP{

    public Diff(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
