package ast;

import visitors.Visitor;

public class Add extends BinOP {

    public Add(int line, int col, Expr l, Expr r) {
        super(line, col, l, r);
    }

    public String toString(){
        String s = getL().toString();
        String ss = getR().toString();
        if(getR() instanceof Add){
            ss = "(" + ss + ")";
        }
        return   s + " + " + ss;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
