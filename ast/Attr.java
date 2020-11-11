package ast;

import visitors.Visitor;
//lvalue EQ exp SEMI #attr
public class Attr extends Cmd{
    Lvalue lv;
    Expr e;

    public Attr(int line, int col, Lvalue lv, Expr e) {
        super(line, col);
        this.lv = lv;
        this.e = e;
    }

    public Lvalue getLv() {
        return lv;
    }

    public Expr getE() {
        return e;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
