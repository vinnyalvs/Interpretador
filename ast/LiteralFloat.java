package ast;

import visitors.Visitor;

public class LiteralFloat extends Expr {
    private float value;

    public LiteralFloat(int line, int col, float value) {
        super(line, col);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
