package ast;

import visitors.Visitor;

//MINUS sexp #minus

public class Minus extends Expr{
    Expr e;

    public Minus(int line, int col, Expr e) {
        super(line, col);
        this.e = e;
    }

    public Expr getE() {
        return e;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}

    public Number toNumber (Object o)
    {
        Number num;
        if (o instanceof Character) {
            char c = (Character) o;
            num = (int) c;
        }
        else
            num = (Number) o;
        return num;
    }
}
