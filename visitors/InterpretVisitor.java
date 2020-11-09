package visitors;

import ast.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        if (e.getDatas() != null)
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
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;

            dir = e.toNumber(operands.pop());
            esq = e.toNumber(operands.pop());

            if ((dir instanceof Float) || (esq instanceof Float))
                operands.push( new Float (esq.floatValue() + dir.floatValue()) );
            else
                operands.push( new Integer (esq.intValue() + dir.intValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(And e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Object esq,dir;
            dir = operands.pop();
            esq = operands.pop();
            operands.push( new Boolean( (Boolean)esq &&  (Boolean)dir ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }

    }

    @Override
    public void visit(Attr e) {
        try{
            e.getE().accept(this);
            env.peek().put(e.getLv().getId(), operands.pop());
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(BinOP e) {}

    @Override
    public void visit(Call e) {
        try{
            Func f = funcs.get(e.getId());
            if(f != null){
                for(Expr exp : e.getArgs()){
                    exp.accept(this);
                }
                f.accept(this);

            }else{
                throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") Função não definida " +  e.getId());
            }

        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Cmd e) {

        try {
            e.accept(this);
        }
        catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(CmdList e) {
        try {
            for (Cmd cmd : e.getCmdList())
                cmd.accept(this);
        }
        catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Data e) {

    }

    @Override
    public void visit(Decl e) {

    }

    @Override
    public void visit(Deny e) {
        try{
            e.getExpr().accept(this);
            operands.push (new Boolean( ! (Boolean)operands.pop() ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Diff e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;

            dir = e.toNumber(operands.pop());
            esq = e.toNumber(operands.pop());

            if ((dir instanceof Float) || (esq instanceof Float))
                operands.push( new Float (esq.floatValue() - dir.floatValue()) );
            else
                operands.push( new Integer (esq.intValue() - dir.intValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }

    }

    @Override
    public void visit(Div e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;

            dir = e.toNumber(operands.pop());
            esq = e.toNumber(operands.pop());

            if ((dir instanceof Float) || (esq instanceof Float))
                operands.push( new Float (esq.floatValue() / dir.floatValue()) );
            else
                operands.push( new Integer (esq.intValue() / dir.intValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Equal e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;

            dir = e.toNumber(operands.pop());
            esq = e.toNumber(operands.pop());

            if ((dir instanceof Float) || (esq instanceof Float))
                operands.push( new Boolean (esq.floatValue() == dir.floatValue()) );
            else
                operands.push( new Boolean (esq.intValue() == dir.intValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Func f) {
        HashMap<String,Object> localEnv = new HashMap<String,Object>();
        for(int  i = f.getParamList().getSize()-1; i >= 0; i--){
//            localEnv.put(f.getParamList()[i].getId(),operands.pop());
        }
        env.push(localEnv);
        f.getBody().accept(this);

        env.pop();
    }

    @Override
    public void visit(If e) {
        try{
            e.getTest().accept(this);
            if((Boolean)operands.pop()){
                e.getThen().accept(this);
            }
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(If_else e) {
        try{
            e.getTest().accept(this);
            if((Boolean)operands.pop()){
                e.getThen().accept(this);
            }else if(e.getElse() != null){
                e.getElse().accept(this);
            }
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Iterate e) {
        try{
            e.getTest().accept(this);
            while( (Boolean)operands.pop()){
                e.getBody().accept(this);
                e.getTest().accept(this);
            }
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LessThan e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;
            dir = e.toNumber(operands.pop());
            esq = e.toNumber(operands.pop());
            operands.push( new Boolean( (Integer)esq <  (Integer)dir ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralChar e) {
        try{
            operands.push(e.getValue());
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralFalse e) {
        try{
            operands.push(  e.getValue());
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralFloat e) {
        try{
            operands.push( e.getValue() );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralInt e) {
        try{
            operands.push( e.getValue() );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralNull e) {


        try{
            operands.push(  e.getValue());
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }



    @Override
    public void visit(LiteralTrue e) {
        try{
            operands.push(  e.getValue());
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
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
        try{
            Object r = env.peek().get(e.getId());
            if(r != null || (r == null && env.peek().containsKey(e.getId()))){
                operands.push(r);
            }
            else{throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") variável não declarada " +e.getId() );}
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Minus e) {
        try{
            e.getE().accept(this);

            Number num = e.toNumber(operands.pop());

            if (num instanceof Float)
                operands.push( new Float (-1 * num.floatValue()) );
            else
                operands.push( new Integer (-1 * num.intValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Mod e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;

            dir = (Integer) operands.pop();
            esq = (Integer) operands.pop();

            if (!(dir instanceof Integer) || !(esq instanceof Integer))
                throw new RuntimeException("os valores usados na operacao % (mod) devem ser inteiros!");

            operands.push( new Integer (esq.intValue() % dir.intValue()) );

        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Mul e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;

            dir = e.toNumber(operands.pop());
            esq = e.toNumber(operands.pop());

            if ((dir instanceof Float) || (esq instanceof Float))
                operands.push( new Float (esq.floatValue() * dir.floatValue()) );
            else
                operands.push( new Integer (esq.intValue() * dir.intValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Noeq e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq,dir;

            dir = e.toNumber(operands.pop());
            esq = e.toNumber(operands.pop());

            if ((dir instanceof Float) || (esq instanceof Float))
                operands.push( new Boolean (esq.floatValue() != dir.floatValue()) );
            else
                operands.push( new Boolean (esq.intValue() != dir.intValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(ParamList e) {

    }

    @Override
    public void visit(Print e) {
        try{
            e.getExpr().accept(this);
            System.out.println(operands.pop());
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Read e) {
        try{

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String read_info = reader.readLine();
           // e.setLv((Lvalue) read_info);
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }

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
