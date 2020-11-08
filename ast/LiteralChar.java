package ast;

import visitors.Visitor;

public class LiteralChar extends Expr {
    private char value;

    public char getValue() {
        return value;
    }

    public LiteralChar(int line, int col, char value) {
        super(line, col);
        this.value = value;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
