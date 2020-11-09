package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class ExprList extends Node {

    private ArrayList<Expr> exprList;

    public ExprList(int line, int col) {
        super(line, col);
        exprList = new ArrayList<Expr>();
    }

    public ArrayList<Expr> getExprList() {
        return exprList;
    }

    public void add (Expr expr){
        exprList.add(expr);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
