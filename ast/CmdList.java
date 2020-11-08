package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class CmdList extends Node{
    private ArrayList<Cmd> cmdList;

    public CmdList(int line, int col) {
        super(line, col);
        cmdList = new ArrayList<Cmd>();
    }

    public ArrayList<Cmd> getCmdList() {
        return cmdList;
    }

    public void add (Cmd cmd){
        cmdList.add(cmd);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
