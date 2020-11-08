package visitors;

import ast.*;

public abstract class Visitor {
    public abstract void visit(Add e);
    public abstract void visit(And e);
    public abstract void visit(Attr e);
    public abstract void visit(BinOP e);
    public abstract void visit(Call e);
    public abstract void visit(Data e);
    public abstract void visit(Decl e);
    public abstract void visit(Deny e);
    public abstract void visit(Diff e);
    public abstract void visit(Div e);
    public abstract void visit(Equal e);
    public abstract void visit(Expr e);
    public abstract void visit(Func e);
    public abstract void visit(If e);
    public abstract void visit(Iterate e);
    public abstract void visit(Lt e);
    public abstract void visit(Lvalue e);
    public abstract void visit(Minus e);
    public abstract void visit(Mod e);
    public abstract void visit(Mul e);
    public abstract void visit(Noeq e);
    public abstract void visit(Param e);
    public abstract void visit(Print e);
    public abstract void visit(Program e);
    public abstract void visit(Read e);
    public abstract void visit(Rel e);
    public abstract void visit(Return e);
    public abstract void visit(Sub e);
}
