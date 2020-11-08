package ast;

import visitors.Visitor;

public class Return extends Cmd{
    private Expr[] args;

    public Return(int line, int col) {
        super(line, col);
    }

    public Expr[] getArgs() {
        return args;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
