package ast;

import visitors.Visitor;

//ID #lvalue_id
public class Lvalue_id extends Lvalue{

    String id;

    public Lvalue_id(int line, int col, String id) {
        super(line, col);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
