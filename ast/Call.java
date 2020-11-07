package ast;

import visitors.Visitor;

public class Call extends Expr{
    private String id;
    private Expr[] args;
    private Lvalue[] idRet;

    public Call(String name, Expr[] args){
        this.id = name;
        this.args = args;
    }

    public String getId() {
        return id;
    }

    public Expr[] getArgs() {
        return args;
    }

    public Lvalue[] getIdRet() {
        return idRet;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
