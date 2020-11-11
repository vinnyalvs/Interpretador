package ast;

import visitors.Visitor;

public class TyFloat extends Type{
    public TyFloat(int line, int col) {
        super(line, col);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
