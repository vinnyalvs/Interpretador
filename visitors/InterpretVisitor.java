/*
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C
*/
package visitors;

import ast.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class InterpretVisitor extends Visitor{
    private Stack<HashMap <String, Object> > env;
    private HashMap <String, Func> funcs;
    private HashMap <String, Data> datas;
    private Stack <Object> operands;
    private boolean retMode;

    public InterpretVisitor(){
        env = new Stack <HashMap <String, Object> >();
        env.push (new HashMap <String, Object> ());
        funcs = new HashMap<String, Func>();
        datas = new HashMap<String, Data>();
        operands = new Stack<Object>();
        retMode = false;
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

            Lvalue lv = e.getLv();

            if (lv instanceof Lvalue_dot)
            {
                Object o = env.peek().get( ( (Lvalue_id) ( (Lvalue_dot) lv).getLv() ).getId() );
                ((HashMap<String,Object>)o).put(((Lvalue_dot)lv).getId(), operands.pop());
            }
            else if (lv instanceof Lvalue_id)
                env.peek().put( ((Lvalue_id)lv).getId(), operands.pop());

            else if (lv instanceof Lvalue_array)
            {
                Object o = env.peek().get( ( (Lvalue_id) ( (Lvalue_array) lv).getLv() ).getId() );

                ((Lvalue_array) lv).getExp().accept(this);
                Integer index = (Integer)operands.pop();

                ((ArrayList<Object>)o).set( index , operands.pop());
            }

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
                /*for(Expr exp : e.getArgs().getExprList()){
                    exp.accept(this);
                }*/
                e.getArgs().accept(this);
                f.accept(this);
                ArrayList <Lvalue> returns = e.getRets();

                for(int i = returns.size()-1; i >= 0 ; i--){
                    env.peek().put(returns.get(i).getId(),operands.pop());
                }
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
        if(retMode){ return;}
        try {
            for (Cmd cmd : e.getCmdList()) {
                cmd.accept(this);
                if(retMode){ return;}
            }
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

        ParamList params= f.getParamList();
        params.accept(this);

        for(int  i = f.getParamList().getSize()-1; i >= 0; i--){
            localEnv.put(params.getId(i),operands.pop());
        }

        for(int  i = f.getParamList().getSize()-1; i >= 0; i--){
           localEnv.put(params.getId(i),operands.pop());
        }
        env.push(localEnv);
        CmdList cmds = f.getBody();
        cmds.accept(this);
       /* for(Cmd cmd : cmds.getCmdList() ){
            cmd.accept(this);
        } */

        env.pop();
        retMode = false;
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

            Object o = operands.pop();

            if(o instanceof Boolean)
                while((Boolean) o){
                    e.getBody().accept(this);
                    e.getTest().accept(this);
                    o = operands.pop();
                }
            else if(o instanceof Integer ) {
                Integer max_iterations = (Integer) o;
                int i=0;
                while(i<max_iterations){
                    i++;
                    e.getBody().accept(this);
                    //e.getTest().accept(this);
                }
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
        try{
            e.getExp().accept(this);
            Integer index = (Integer)operands.pop();

            Lvalue_id lv = (Lvalue_id) e.getLv();

            Object r = env.peek().get(lv.getId());
            if(r != null ){
                if (((ArrayList<Object>)r).size() >= index)
                    operands.push(((ArrayList<Object>)r).get(index));
                else{throw new RuntimeException("Indice " + index + " fora dos limites da variavel " + lv.getId());}
            }
            else{throw new RuntimeException("variável " + lv.getId() + " não declarada");}
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Lvalue_dot e) {
        try{

            Lvalue_id lv = (Lvalue_id) e.getLv();

            Object r = env.peek().get(lv.getId());
            if(r != null ){
                if (((HashMap<String, Object>)r).containsKey(e.getId()))
                    operands.push(((HashMap<String, Object>)r).get(e.getId()));
                else{throw new RuntimeException("variável" +lv.getId() + "." + e.getId() + " não declarada ");}
            }
            else{throw new RuntimeException("variável " + lv.getId() + " não declarada");}
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(Lvalue_id e) {
        try{
            Object r = env.peek().get(e.getId());
            if(r != null || (r == null && env.peek().containsKey(e.getId()))){
                operands.push(r);
            }
            else{throw new RuntimeException("variável " + e.getId() + " não declarada");}
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
    public void visit(New e) {
        try{
            e.getT().accept(this);

            if (e.getE() != null)
            {
                e.getE().accept(this);
                Integer size = (Integer) operands.pop();

                Object o = operands.pop();
                ArrayList  newArray = new ArrayList<Object>(size);
                for (int i = 0; i < size; ++i)
                    newArray.add(o);

                operands.push(newArray);
            }

            if (e.getE() == null && e.getT() instanceof TyData)
            {
                String data_id = ((TyData) e.getT()).getId();
                HashMap<String, Object> newVar = new HashMap<String, Object>();
                for (Decl d : datas.get(data_id).getDeclList() )
                {
                    d.getType().accept(this);
                    newVar.put (d.getId() , operands.pop() );
                }
                operands.push(newVar);
            }
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
        try{
            for(Type t : e.getTypes()){
                t.accept(this);
                if(t instanceof TyArray) {

                    Object o = operands.pop(); //retirando elemento colocado no accept
                    ArrayList  newArray = new ArrayList<Object>();

                    operands.push(newArray);
                }
              // operands.pop();
            }
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
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

            Lvalue lv = e.getLv();

            if (lv instanceof Lvalue_dot)
            {
                Object o = env.peek().get( ( (Lvalue_id) ( (Lvalue_dot) lv).getLv() ).getId() );
                ((HashMap<String,Object>)o).put(((Lvalue_dot)lv).getId(), read_info);
            }
            else if (lv instanceof Lvalue_id)
                env.peek().put(((Lvalue_id)lv).getId(), read_info);

            else if (lv instanceof Lvalue_array)
            {
                Object o = env.peek().get( ( (Lvalue_id) ( (Lvalue_array) lv).getLv() ).getId() );

                ((Lvalue_array) lv).getExp().accept(this);
                Integer index = (Integer)operands.pop();

                ((ArrayList<Object>)o).set( index , read_info);
            }



        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }

    }

    @Override
    public void visit(Return e) {
        for(Expr ex : e.getArgs()){
            ex.accept(this);
        }
        retMode = true;
    }

    @Override
    public void visit(TyArray e) {
        try{
            e.getType().accept(this);
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(TyBool e) {
        try{
            operands.push(new Boolean(false));
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(TyChar e) {
        try{
            operands.push(new Character(' '));
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(TyFloat e) {
        try{
            operands.push(new Float(0.0));
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(TyInt e) {
        try{
            operands.push(new Integer(0));
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(TyData e) {
        try{
            if(!datas.containsKey(e.getId()))
            {
                throw new RuntimeException( "Data" + e.getId() + " não existe!");
            }
        }catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
    }

    @Override
    public void visit(ExprList e) {
        try{
             for(Expr exp : e.getExprList()){
                 exp.accept(this);
             }
        }
        catch(Exception x){
            throw new RuntimeException( " (" + e.getLine() + ", " + e.getCol() + ") " + x.getMessage() );
        }
}

}
