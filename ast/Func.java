package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class Func extends Node{
    ParamList paramList;
    ArrayList<Type> ret;
    String id;
    private CmdList body;

    public Func(int line, int col, String id) {
        super (line, col);
        this.id = id;
        body = new CmdList(line, col);
        paramList = new ParamList(line, col);
    }

    public ParamList getParamList() {
        return paramList;
    }

    public void setParamList(ParamList paramList) {
        this.paramList = paramList;
    }

    public String getId() {
        return id;
    }

    public CmdList getBody() {
        return body;
    }

    public ArrayList<Type> getRet() {
        return ret;
    }

    public void setRet(ArrayList<Type> ret) {
        this.ret = ret;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBody(CmdList body) {
        this.body = body;
    }

    public void addReturn (Type r){
        ret.add(r);
    }

    public void addCmd (Cmd cmd){
        body.add(cmd);
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}