package ast;

import visitors.Visitor;

import java.util.ArrayList;

//prog :	data* func* ;
public class Program extends Node{
    ArrayList<Func> funcs;
    ArrayList<Data> datas;



    public Program(int line, int column) {
        this.line = line;
        this.column = column;
        funcs = new ArrayList<Func>();
        datas = new ArrayList<Data>();
    }

    public void addFunc(Func func) {
        this.funcs.add(func);
    }

    public void addData(Data data) {
        this.datas.add(data);
    }

    public ArrayList<Func> getFuncs() {
        return funcs;
    }

    public ArrayList<Data> getDatas() {
        return datas;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
