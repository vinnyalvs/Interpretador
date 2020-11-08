package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class CmdList extends Node{
    private ArrayList<Cmd> cmdList;

    public ArrayList<Cmd> getCmdList() {
        return cmdList;
    }

    public void add (Cmd cmd){
        cmdList.add(cmd);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
