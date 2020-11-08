package ast;

import visitors.Visitor;

public class LiteralTrue extends Expr {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public LiteralTrue(int line, int col) {
        super(line, col);
        this.value = true;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
