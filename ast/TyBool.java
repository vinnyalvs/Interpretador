package ast;

import visitors.Visitor;

public class TyBool extends Type{
    public TyBool(int line, int col) {
        super(line, col);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
