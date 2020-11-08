package ast;

import visitors.Visitor;

public class LiteralNull extends Expr {
    private Object value;

    public Object getValue() {
        return value;
    }

    public LiteralNull(int line, int col) {
        super(line, col);
        this.value = null;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
