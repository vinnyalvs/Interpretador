package ast;

import visitors.Visitor;

public class Attr extends Cmd{
    Lvalue lv;
    Expr e;

    public Attr(int line, int col, Lvalue lv) {
        super(line, col);
        this.lv = lv;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
