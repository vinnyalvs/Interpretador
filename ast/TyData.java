package ast;

public class TyData extends Type {
    String id;
    public TyData(int line, int col, String id) {
        super(line, col);
        this.id = id;
    }
}
