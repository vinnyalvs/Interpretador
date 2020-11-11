package ast;

import visitors.Visitor;

//aexp RELACIONAL aexp #less_than
public class LessThan extends BinOP{

    public LessThan(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
