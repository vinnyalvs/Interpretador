package visitors;

import ast.*;

public abstract class Visitor {
    public abstract void visit(Add e);
    public abstract void visit(And e);
    public abstract void visit(Attr e);
    public abstract void visit(BinOP e);
    public abstract void visit(Call e);
    public abstract void visit(Cmd e);
    public abstract void visit(CmdList e);
    public abstract void visit(Data e);
    public abstract void visit(Decl e);
    public abstract void visit(Deny e);
    public abstract void visit(Diff e);
    public abstract void visit(Div e);
    public abstract void visit(Equal e);
//    public abstract void visit(Expr e);
    public abstract void visit(Func e);
    public abstract void visit(If e);
    public abstract void visit(If_else e);
    public abstract void visit(Iterate e);
    public abstract void visit(LessThan e);
    public abstract void visit(LiteralChar e);
    public abstract void visit(LiteralFalse e);
    public abstract void visit(LiteralFloat e);
    public abstract void visit(LiteralInt e);
    public abstract void visit(LiteralNull e);
    public abstract void visit(LiteralTrue e);
    public abstract void visit(Lvalue e);
    public abstract void visit(Lvalue_array e);
    public abstract void visit(Lvalue_dot e);
    public abstract void visit(Lvalue_id e);
    public abstract void visit(Minus e);
    public abstract void visit(Mod e);
    public abstract void visit(Mul e);
    public abstract void visit(Noeq e);
    public abstract void visit(ParamList e);
    public abstract void visit(Print e);
    public abstract void visit(Program e);
    public abstract void visit(Read e);
    public abstract void visit(Rel e);
    public abstract void visit(Return e);
    public abstract void visit(Sub e);
    public abstract void visit(TyArray e);
    public abstract void visit(TyBool e);
    public abstract void visit(TyChar e);
    public abstract void visit(TyFloat e);
    public abstract void visit(TyInt e);
    public abstract void visit(TyData e);

    public abstract void visit(ExprList exprList);
}
