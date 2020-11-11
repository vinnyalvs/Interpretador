package ast;

import visitors.Visitor;

import java.util.ArrayList;

//data :	DATA ID OP_BRACKET (decl)* CL_BRACKET ;

public class Data extends Node{
    String id;
    private ArrayList<Decl> decls;

    public Data(int line, int col, String id) {
        super(line, col);
        this.id = id;
        decls = new ArrayList<Decl>();
    }

    public String getId() {
        return id;
    }

    public ArrayList<Decl> getDeclList() {
        return decls;
    }

    public void addDecl(Decl d){decls.add(d);}

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
