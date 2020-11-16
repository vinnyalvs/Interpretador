package visitors;
import TypeCheck.*;
import ast.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TypeCheckVisitor extends Visitor {
    private STyInt tyint =  STyInt.newSTyInt();
    private STyFloat tyfloat =  STyFloat.newSTyFloat();
    private STyChar tychar =  STyChar.newSTyChar();
    private STyBool tybool =  STyBool.newSTyBool();
    private STyNull tynull =  STyNull.newSTyNull();
    private STyErr tyerr =  STyErr.newSTyErr();

    private ArrayList<String> logError;

    private HashMap<String, STyData> datas;
    private TyEnv<LocalEnv<SType>> env;
    private LocalEnv<SType> temp;

    private Stack<SType> stk;
    private  boolean retCheck;

    public TypeCheckVisitor() {
        stk = new Stack<SType>();
        env = new TyEnv<LocalEnv<SType>>();
        datas = new HashMap<>();
        logError = new ArrayList<String>();
    }

    public int getNumErros(){
        return logError.size();
    }

    public void printErros(){
        for(String s : logError)
            System.out.println(s);
    }

    public void visit(Program p){
        for(Data d : p.getDatas())
        {
            STyData data = new STyData(d.getId());
            ArrayList<Decl> decList = d.getDeclList();
            for (Decl de : decList) {
                de.accept(this);
                data.add(de.getId(), stk.pop());
            }
            datas.put( d.getId() ,data);
        }

        for(Func f : p.getFuncs()){
            STyFunc ty;
            ArrayList <SType> params_stype = new ArrayList<SType>();

            ParamList params = f.getParamList();

            for( int i=0; i < params.getSize(); i++ ){
                params.getType(i).accept(this);
                params_stype.add(stk.pop());
            }

            SType[] xs = new SType[f.getParamList().getSize() + 1];

            for (Type t : f.getRet())
                t.accept(this);


//            xs[f.getParamList().getSize()] = stk.pop();
            ty = new STyFunc(xs);
            env.set(f.getId(), new LocalEnv<SType>(f.getId(),ty));
        }
        for(Func f : p.getFuncs()){
            f.accept(this);
        }
        for(String s : logError)
            System.out.println(s);
        //env.printTable();
    }

    @Override
    public void visit(Read e) {
        //Como comentado no Google Classroom, é possível limitar o Read.
        // Desta Forma será escolhido o READ apenas para valores inteiros

        Lvalue lv = e.getLv();

        String id = "";

        // È desse jeito pq o código é gambiarrado e o lvalue dot retorna o próprio id em getId()

        if (lv instanceof Lvalue_dot)
        {
            id =  ((Lvalue_dot) lv).getLv().getId() ;
            //((HashMap<String,Object>)o).put(((Lvalue_dot)lv).getId(), read_info);
        } else {
            id = (lv).getId();
        }

        if (temp.get(id) == null ) {
            temp.set(id, tyint);
        } else { // se já está declarada ou se é algum outro tipo
            lv.accept(this); // tipo da variavel
            if (!stk.pop().match(tyint)) {
                logError.add(e.getLine() + ", " + e.getCol() + ": Comando READ só funciona para números inteiros " + id);
            }
        }

    }

    @Override
    public void visit(Return e) {
        for(Expr expr : e.getArgs())
             expr.accept(this);
        if(temp.getFuncType() instanceof STyFunc){
            SType[] t = ((STyFunc)temp.getFuncType()).getTypes();
            t[t.length-1].match(stk.pop());
        }
        else{
            stk.pop().match(temp.getFuncType());
        }
        retCheck = true;

    }

    @Override
    public void visit(TyArray e) {
        e.getType().accept(this);
        stk.push(new STyArray(stk.pop()) );
    }

    @Override
    public void visit(TyBool e) {
        stk.push(tybool);
    }

    @Override
    public void visit(TyChar e) {
        stk.push(tychar);
    }

    @Override
    public void visit(TyFloat e) {
        stk.push(tyfloat);
    }

    @Override
    public void visit(TyInt e) {
        stk.push(tyint);
    }

    @Override
    public void visit(TyData e) {
        if (datas.containsKey(e.getId()))
            stk.push(new STyData(e.getId()));
        else{
            logError.add( e.getLine() + ", " + e.getCol() + ": O tipo " + e.getId() + " não está definido.");
            stk.push(tyerr);
        }
    }

    @Override
    public void visit(ExprList exprList) {

    }

    public void visit(Func f){
        retCheck = false;
        temp = env.get(f.getId());

        ParamList params = f.getParamList();
        // Transformar os Type dos params para SType

        ArrayList <SType> params_stype = new ArrayList<SType>();

        for( int i=0; i < params.getSize(); i++ ){
            params.getType(i).accept(this);
            params_stype.add(stk.pop());
        }

        for( int i=0; i < params.getSize(); i++ ){
            temp.set( params.getId(i),params_stype.get(i));
        }


        CmdList cmds = f.getBody();
        for( Cmd c : cmds.getCmdList()){
            c.accept(this);
        }

        if(!retCheck){
            logError.add( f.getLine() + ", " + f.getCol() + ": Função " + f.getId() + " deve retornar algum valor.");
        }
    }

    @Override
    public void visit(If e) {
        boolean rt;
        e.getTest().accept(this);
        if(stk.pop().match(tybool)){
            retCheck = false;
            e.getThen().accept(this);
            rt = retCheck;
            retCheck = rt;
        }else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Expressão de teste do IF deve ter tipo Bool");
        }

    }

    @Override
    public void visit(If_else e) {
        boolean rt, re;
        re = true;
        e.getTest().accept(this);
        if(stk.pop().match(tybool)){
            retCheck = false;
            e.getThen().accept(this);
            rt = retCheck;
            if(e.getElse() != null){
                retCheck = false;
                e.getElse().accept(this);
                re = retCheck;
            }
            retCheck = rt && re;
        }else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Expressão de teste do IF deve ter tipo Bool");
        }

    }

    @Override
    public void visit(Iterate e) {
        e.getTest().accept(this);
        SType o = stk.pop();
        if(o.match(tybool) || o.match(tyint)){
            e.getBody().accept(this);
        }else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Expressão de teste do Iterate deve ter tipo Bool Ou Inteiro");
        }

    }

    @Override
    public void visit(LessThan e) {
        e.getL().accept(this);
        e.getR().accept(this);
        SType tyr = stk.pop();
        SType tyl = stk.pop();
        if( (tyr.match(tyint) || tyr.match(tyfloat) ) && (tyl.match(tyint) || tyr.match(tyfloat)) ){
            stk.push(tybool);
        }
        else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Operador < não se aplica aos tipos " + tyl.toString() + " e " + tyr.toString() );
            stk.push(tyerr);
        }

    }

    @Override
    public void visit(LiteralChar e) {
        stk.push(tychar);

    }

    @Override
    public void visit(LiteralFalse e) {
        stk.push(tybool);
    }

    @Override
    public void visit(LiteralFloat e) {
        stk.push(tyfloat);

    }

    @Override
    public void visit(LiteralInt e) {
        stk.push(tyint);

    }

    @Override
    public void visit(LiteralNull e) {
        stk.push(tynull);
    }

    @Override
    public void visit(LiteralTrue e) {
        stk.push(tybool);
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

        SType t = temp.get(e.getId());
        if(t != null){
            stk.push(t);
        } else {
            logError.add(e.getLine() + ", " + e.getCol() + ": Variável não declarada " + e.getId());
            stk.push(tyerr);
        }

    }

    @Override
    public void visit(Minus e) {
        e.getE().accept(this);
        SType tyr = stk.pop();
        if(tyr.match(tyint) || tyr.match(tyfloat)   ){
            stk.push(tyr);
        }else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Operador - não se aplica ao tipo " + tyr.toString() );
            stk.push(tyerr);
        }

     }


    private void typeArithmeticBinOp(Node n,String opName){
        SType tyr = stk.pop();
        SType tyl = stk.pop();
        if((tyr.match(tyint))){
            if(tyl.match(tyint)){
                stk.push(tyl);
            } else {
                logError.add((n.getLine() + "," + n.getCol() + " Operador:" +opName+ " não se aplica aos tipos " + tyl.toString() + " e " + tyr.toString()));
                stk.push(tyerr);
            }
        } else if(tyr.match(tyfloat)){
            if(tyl.match(tyfloat)){
                stk.push(tyl);
            } else {
                logError.add((n.getLine() + "," + n.getCol() + " Operador:" +opName+ " não se aplica aos tipos " + tyl.toString() + " e " + tyr.toString()));
                stk.push(tyerr);
            }
        } else{
            logError.add((n.getLine() + "," + n.getCol() + " Operador:" +opName+ " não se aplica aos tipos " + tyl.toString() + " e " + tyr.toString()));
            stk.push(tyerr);
        }

    }

    public void visit(Add e){
        e.getL().accept(this);
        e.getR().accept(this);
        typeArithmeticBinOp(e,"+");
    }

    public void visit(Mod e){
        e.getL().accept(this);
        e.getR().accept(this);
        SType tyr = stk.pop();
        SType tyl = stk.pop();
        if( tyr.match(tyint) && tyl.match(tyint))
            stk.push(tyint);
        else {
            logError.add((e.getLine() + "," + e.getCol() + "Operador: %" +"não se aplica aos tipos" + tyl.toString() + "e" + tyr.toString()));
            stk.push(tyerr);
        }
    }

    @Override
    public void visit(Mul e) {
        e.getL().accept(this);
        e.getR().accept(this);
        typeArithmeticBinOp(e,"*");

    }

    @Override
    public void visit(New e) {

        e.getT().accept(this);

        if(e.getE() != null){
            e.getE().accept(this);
            if(!stk.pop().match(tyint)){
                logError.add(e.getLine() + ", " + e.getCol() + ": Index must be integer.");
            }
        }

        // TODO tipo data???

        /*if (e.getE() == null && e.getT() instanceof TyData)
        {
            String data_id = ((TyData) e.getT()).getId();
            HashMap<String, Object> newVar = new HashMap<String, Object>();
            for (Decl d : datas.get(data_id).getDeclList() )
            {
                d.getType().accept(this);
                newVar.put (d.getId() , operands.pop() );
            }
            operands.push(newVar);
        } */


    }

    @Override
    public void visit(Noeq e) {
        e.getL().accept(this);
        e.getR().accept(this);
        SType tyr = stk.pop();
        SType tyl = stk.pop();
//        if( (tyr.match(tyint) || tyr.match(tyfloat) || tyr.match(tybool) ||  tyr.match(tynull)  ) && (tyl.match(tyint) || tyr.match(tyfloat))  || tyl.match(tybool) ||  tyl.match(tynull) ){
        // TODO quando ouver tipo expressões, checar se dois lados são expr
        if(tyl.match(tyr))
            stk.push(tybool);
        else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Operador = não se aplica aos tipos " + tyl.toString() + " e " + tyr.toString() );
            stk.push(tyerr);
        }
    }

    @Override
    public void visit(ParamList e) { // FEITO NO FUNC

    }

    @Override
    public void visit(Print e) {
        e.getExpr().accept(this);
        stk.pop();
    }

    public void visit(Div e){
        e.getL().accept(this);
        e.getR().accept(this);
        typeArithmeticBinOp(e,"/");
    }

    @Override
    public void visit(Equal e) {
        e.getL().accept(this);
        e.getR().accept(this);
        SType tyr = stk.pop();
        SType tyl = stk.pop();
//        if( (tyr.match(tyint) || tyr.match(tyfloat) || tyr.match(tybool) ||  tyr.match(tynull)  ) && (tyl.match(tyint) || tyr.match(tyfloat))  || tyl.match(tybool) ||  tyl.match(tynull) ){
        // TODO quando ouver tipo expressões, checar se dois lados são expr
        if(tyl.match(tyr))
            stk.push(tybool);
        else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Operador = não se aplica aos tipos " + tyl.toString() + " e " + tyr.toString() );
            stk.push(tyerr);
        }
    }

    public void visit(Diff e){
        e.getL().accept(this);
        e.getR().accept(this);
        typeArithmeticBinOp(e,"-");


    }

    public void visit(And e){
        e.getL().accept(this);
        e.getR().accept(this);
        SType tyr = stk.pop();
        SType tyl = stk.pop();
        if( tyr.match(tybool) && tyl.match(tybool)  ){
            stk.push(tybool);
        }
        else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Operador & não se aplica aos tipos " + tyl.toString() + " e " + tyr.toString() );
            stk.push(tyerr);
        }

    }

    @Override
    public void visit(Attr e) {
        String id = "";
        Lvalue lv = e.getLv();
        if (lv instanceof Lvalue_dot)
        {
            id =  ((Lvalue_dot) lv).getLv().getId() ;
        } else {
            id = (lv).getId();
        }

        if(temp.get(id) != null){
            lv.accept(this);
            e.getE().accept(this);
            SType ste =  stk.pop();
            SType stlv = stk.pop();
            if (!stlv.match(ste))
            {
                logError.add( e.getLine() + ", " + e.getCol() + ": A variavel " + id + " foi declarada como " + stlv.toString() + " e esta sendo atribuido uma expressao do tipo " + ste.toString() );
                stk.push(tyerr);
            }
        }
        else{
            e.getE().accept(this);
            temp.set(id, stk.pop());
        }
    }

    @Override
    public void visit(BinOP e) { // Não é visitado

    }

    @Override
    public void visit(Call e) {

        ArrayList <SType> params_stype = new ArrayList<SType>();

        ExprList args_params = e.getArgs();
        ArrayList <Expr> args_expr= args_params.getExprList();
        for( int i=0; i < args_expr.size() ; i++ ){
            args_expr.get(i).accept(this);
            params_stype.add(stk.pop());
        } // Tipos dos params

        // Tipos dos retornos

        LocalEnv<SType> f = env.get(e.getId());
        if(f != null){ // Função foi declarada
            e.getArgs().accept(this);
            STyFunc tf = (STyFunc) f.getFuncType();

            if(tf.getTypes().length == e.getRets().size()) {

                for(int i = e.getRets().size()-1; i >= 0 ; i--) {
                    String id = "";

                    // È desse jeito pq o código é gambiarrado e o lvalue dot retorna o próprio id em getId()
                    Lvalue lv = e.getRets().get(i);
                    if (lv instanceof Lvalue_dot)
                    {
                        id =  ((Lvalue_dot) lv).getLv().getId() ;
                    } else {
                        id = (lv).getId();
                    }
                    if(temp.get(id) != null){ //Variável ja foi declarada
                        lv.accept(this);
                        SType type_return = stk.pop();
                        if (!type_return.match(tf.getTypes()[i])) {
                            logError.add(e.getLine() + ", " + e.getCol() + ": Variável " + id + "não é do tipo " + tf.getTypes()[i].toString() );
                        }
                    } else {
                        temp.set(id, tf.getTypes()[i]); // Declaramos nova variável
                    }

                }
            } else {
                logError.add(e.getLine() + ", " + e.getCol() + ": Número de retornos é diferente do número especificado: " + e.getId());
                stk.push(tyerr);
            }

        }
    }

    @Override
    public void visit(Cmd e) {

    }

    @Override
    public void visit(CmdList e) {
        for(Cmd cmd : e.getCmdList()){
            cmd.accept(this);
        }

    }

    @Override
    public void visit(Data e) { // Não é necessário

    }

    @Override
    public void visit(Decl e) {
        e.getType().accept(this);
    }

    @Override
    public void visit(Deny e) {
        e.getExpr().accept(this);
        SType tyr = stk.pop();
        if(tyr.match(tybool) ){
            stk.push(tybool);
        }else{
            logError.add( e.getLine() + ", " + e.getCol() + ": Operador ! não se aplica ao tipo " + tyr.toString() );
            stk.push(tyerr);
        }

    }


}
