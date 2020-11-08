package ast;

public class LiteralInt extends Expr {
    private int value;

    public int getValue() {
        return value;
    }

    public LiteralInt(int line, int col, int value) {
        super(line, col);
        this.value = value;
    }
}
