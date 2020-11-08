package visitors;

import ast.*;

import java.util.HashMap;
import java.util.Stack;

public class InterpretVisitor extends Visitor{
    private Stack<HashMap <String, Object> > env;
    private HashMap <String, Func> funcs;
    private HashMap <String, Data> datas;
    private Stack <Object> operands;

    public InterpretVisitor(){
        env = new Stack <HashMap <String, Object> >();
        env.push (new HashMap <String, Object> ());
        funcs = new HashMap<String, Func>();
        datas = new HashMap<String, Data>();
        operands = new Stack<Object>();
    }

    @Override
    public void visit(Program e) {
        Node main = null;

        for (Data d : e.getDatas())
            datas.put(d.getId(), d);

        for (Func f : e.getFuncs())
        {
            funcs.put(f.getId(), f);
            if (f.getId().equals("main"))
                main = f;
        }
        if (main == null)
            throw new RuntimeException("Função main não encontrada!");
        main.accept(this);
    }

    @Override
    public void visit(Add e) {

    }

    @Override
    public void visit(And e) {

    }

    @Override
    public void visit(Attr e) {

    }

    @Override
    public void visit(BinOP e) {

    }

    @Override
    public void visit(Call e) {

    }

    @Override
    public void visit(Data e) {

    }

    @Override
    public void visit(Decl e) {

    }

    @Override
    public void visit(Deny e) {

    }

    @Override
    public void visit(Diff e) {

    }

    @Override
    public void visit(Div e) {

    }

    @Override
    public void visit(Equal e) {

    }

    @Override
    public void visit(Expr e) {

    }

    @Override
    public void visit(Func e) {

    }

    @Override
    public void visit(If e) {

    }

    @Override
    public void visit(If_else e) {

    }

    @Override
    public void visit(Iterate e) {

    }

    @Override
    public void visit(LessThan e) {

    }

    @Override
    public void visit(LiteralChar e) {

    }

    @Override
    public void visit(LiteralFalse e) {

    }

    @Override
    public void visit(LiteralFloat e) {

    }

    @Override
    public void visit(LiteralInt e) {

    }

    @Override
    public void visit(LiteralNull e) {

    }

    @Override
    public void visit(LiteralTrue e) {

    }

    @Override
    public void visit(Lvalue e) {

    }

    @Override
    public void visit(Lvalue_array e) {

    }

    @Override
    public void visit(Lvalue_dot e) {

    }

    @Override
    public void visit(Lvalue_id e) {

    }

    @Override
    public void visit(Minus e) {

    }

    @Override
    public void visit(Mod e) {

    }

    @Override
    public void visit(Mul e) {

    }

    @Override
    public void visit(Noeq e) {

    }

    @Override
    public void visit(Param e) {

    }

    @Override
    public void visit(Print e) {

    }

    @Override
    public void visit(Read e) {

    }

    @Override
    public void visit(Rel e) {

    }

    @Override
    public void visit(Return e) {

    }

    @Override
    public void visit(Sub e) {

    }

    @Override
    public void visit(TyArray e) {

    }

    @Override
    public void visit(TyBool e) {

    }

    @Override
    public void visit(TyChar e) {

    }

    @Override
    public void visit(TyFloat e) {

    }

    @Override
    public void visit(TyInt e) {

    }

    @Override
    public void visit(TyData e) {

    }
}
