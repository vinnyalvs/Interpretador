package ast;

import visitors.Visitor;

import java.util.ArrayList;

public class Data extends Node{
    String id;
    private ArrayList<Decl> decls;

    public Data(int line, int col, String id) {
        super(line, col);
        this.id = id;
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
