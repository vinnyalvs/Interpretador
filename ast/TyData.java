package ast;

import visitors.Visitor;

public class TyData extends Type {
    String id;
    public TyData(int line, int col, String id) {
        super(line, col);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
