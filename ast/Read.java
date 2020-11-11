package ast;

import visitors.Visitor;
//|	READ lvalue SEMI #read

public class Read extends Cmd{

    public Read(int line, int col, Lvalue lv) {
        super(line, col);
        this.lv = lv;
    }

    Lvalue lv;

    public Lvalue getLv() {
        return lv;
    }

    public void setLv(Lvalue lv) {
        this.lv = lv;
    }


    @Override
    public void accept(Visitor v) {v.visit(this);}
}
