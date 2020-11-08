package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class ParamList extends Node{
    ArrayList<Type> type;
    ArrayList<String> id;

    public ParamList(int line, int col) {
        super(line, col);
    }

    public ArrayList<Type> getType() {
        return type;
    }

    public ArrayList<String> getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
