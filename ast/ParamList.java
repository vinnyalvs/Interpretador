package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class ParamList extends Node{
    ArrayList<Type> type;
    ArrayList<String> id;

    public ParamList(int line, int col) {
        super(line, col);
        type = new ArrayList<Type>();
    }

    public ArrayList<Type> getType() {
        return type;
    }

    public ArrayList<String> getId() {
        return id;
    }

    public int getSize (){
        return type.size();
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
