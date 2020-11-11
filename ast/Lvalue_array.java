package ast;

import visitors.Visitor;

//lvalue OP_SQBRACKET exp CL_SQBRACKET #lvalue_array

public class Lvalue_array extends Lvalue{

    Lvalue lv;
    Expr exp;

    public Lvalue_array(int line, int col, Lvalue lv, Expr exp) {
        super(line, col);
        this.lv = lv;
        this.exp = exp;
    }

    public Lvalue getLv() {
        return lv;
    }

    public Expr getExp() {
        return exp;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
