package ast;

import visitors.Visitor;

public class Program extends Node{
    Func[] funcs;
    Data[] datas;

    public Func[] getFuncs() {
        return funcs;
    }

    public Data[] getDatas() {
        return datas;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
