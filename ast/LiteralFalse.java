package ast;

import visitors.Visitor;

public class LiteralFalse extends Expr {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public LiteralFalse(int line, int col) {
        super(line, col);
        this.value = false;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
