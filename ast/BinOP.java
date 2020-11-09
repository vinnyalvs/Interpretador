package ast;

import visitors.Visitor;

public class BinOP extends Expr{
    Expr l;
    Expr r;

    public BinOP(int line, int col, Expr l, Expr r) {
        super(line, col);
        this.l = l;
        this.r = r;
    }

    public Expr getL() {
        return l;
    }

    public Expr getR() {
        return r;
    }

    public void setLeft(Expr n){  l = n; }
    public void setRight(Expr n){ r = n; }

    public Number toNumber (Object o)
    {
        try{
            Number num;
            if (o instanceof Character) {
                char c = (Character) o;
                num = (int) c;
            }
            else
                num = (Number) o;
            return num;
        }catch(Exception x){
            throw new RuntimeException( x.getMessage() );
        }
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
