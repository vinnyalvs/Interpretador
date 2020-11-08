package ast;

public class TyArray extends Type{

    Type type;
    public TyArray(int line, int col, Type t) {
        super(line, col);
        this.type = t;
    }
}
