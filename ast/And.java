package ast;

import visitors.Visitor;

// exp AND exp #and
public class And extends BinOP{

    public And(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
