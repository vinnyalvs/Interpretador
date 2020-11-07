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
    public void visit(Iterate e) {

    }

    @Override
    public void visit(Lt e) {

    }

    @Override
    public void visit(Lvalue e) {

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
    public void visit(Neq e) {

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
}
