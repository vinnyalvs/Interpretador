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
            Expr esq,dir;
            dir = (Expr) operands.pop();
            esq = (Expr)operands.pop();
            operands.push( new Integer(esq +  dir ) );
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

    }

    @Override
    public void visit(BinOP e) {

    }

    @Override
    public void visit(Call e) {
        try{
            Func f = funcs.get(e.getName());
            if(f != null){
                for(Expr exp : e.getArgs()){
                    exp.accept(this);
                }
                f.accept(this);

            }else{
                throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") Função não definida " +  e.getName());
            }

        }catch(Exception x){
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
            dir = (Number)operands.pop();
            esq = (Number)operands.pop();
            operands.push( new Integer(esq.intValue() -  dir.intValue() ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }

    }

    @Override
    public void visit(Div e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq, dir;
            dir = (Number)operands.pop();
            esq = (Number)operands.pop();
            operands.push( new Float(esq.intValue() /  dir.intValue() ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Equal e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            operands.push( new Boolean( operands.pop().equals(operands.pop()) ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Expr e) {

    }

    @Override
    public void visit(Func e) {

    }

    @Override
    public void visit(If e) {
        try{
            e.getTeste().accept(this);
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
            e.getTeste().accept(this);
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
            Object esq,dir;
            dir = operands.pop();
            esq = operands.pop();
            operands.push( new Boolean( (Integer)esq <  (Integer)dir ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralChar e) {

    }

    @Override
    public void visit(LiteralFalse e) {
        try{
            operands.push(  new Boolean(false));
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralFloat e) {
        try{
            operands.push( new Float(e.getValue() ));
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralInt e) {
        try{
            operands.push( new Integer(e.getValue()) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(LiteralNull e) {

    }

    @Override
    public void visit(LiteralTrue e) {
        try{
            operands.push(  new Boolean(true));
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

    }

    @Override
    public void visit(Minus e) {

    }

    @Override
    public void visit(Mod e) {
        try{
            e.getL().accept(this);
            e.getR().accept(this);
            Number esq, dir;
            dir = (Number)operands.pop();
            esq = (Number)operands.pop();
            operands.push( new Integer(esq.intValue() %  dir.intValue() ) );
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
            dir = (Number)operands.pop();
            esq = (Number)operands.pop();
            operands.push( new Integer(esq.intValue() *  dir.intValue() ) );
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }

    }

    @Override
    public void visit(Noeq e) {

    }

    @Override
    public void visit(Param e) {

    }

    @Override
    public void visit(Print e) {
        try{
            e.getExpr().accept(this);
            System.out.println(operands.pop().toString());
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
