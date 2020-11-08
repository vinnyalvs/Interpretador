package ast;

import visitors.Visitor;

public class Call extends Cmd{
    private String id;
    private Expr[] args;
    private Lvalue[] idRet;

    public Call(int line, int col, String id) {
        super(line, col);
        this.id = id;
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
