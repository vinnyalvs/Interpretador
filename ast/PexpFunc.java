package ast;

import visitors.Visitor;

public class PexpFunc extends Expr{
    Expr index;
    ExprList eList;
    String id;

    public PexpFunc(int line, int col, Expr index, ExprList eList, String id) {
        super(line, col);
        this.index = index;
        this.eList = eList;
        this.id = id;
    }

    public Expr getIndex() {
        return index;
    }

    public ExprList getEList() {
        return eList;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
