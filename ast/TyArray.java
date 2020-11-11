package ast;

import visitors.Visitor;

public class TyArray extends Type{

    Type type;
    public TyArray(int line, int col, Type t) {
        super(line, col);
        this.type = t;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
