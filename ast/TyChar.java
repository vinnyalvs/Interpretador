package ast;

import visitors.Visitor;

public class TyChar extends Type {
    public TyChar(int line, int col) {
        super(line, col);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
