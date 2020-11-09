package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class Return extends Cmd{
    private ArrayList<Expr> args;

    public Return(int line, int col) {
        super(line, col);
        args = new ArrayList<Expr>();
    }

    public ArrayList<Expr>  getArgs() {
        return args;
    }


    public void add (Expr expr){
        args.add(expr);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
