package ast;

import visitors.Visitor;

//rexp DIFF aexp #noeq
public class Noeq extends BinOP{

    public Noeq(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
