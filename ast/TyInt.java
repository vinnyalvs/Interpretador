package ast;

import visitors.Visitor;

public class TyInt extends Type{
    public TyInt(int line, int col) {
        super(line, col);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
