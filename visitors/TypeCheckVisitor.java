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

    private HashMap<String, SType> map_datas;
    private TyEnv<LocalEnv<SType>> env;
    private LocalEnv<SType> temp;

    private Stack<SType> stk;
    private  boolean retCheck;

    public TypeCheckVisitor() {
        stk = new Stack<SType>();
        env = new TyEnv<LocalEnv<SType>>();
        map_datas = new HashMap<String, SType>();
        logError = new ArrayList<String>();
    }

    public int getNumErros(){
        return logError.size();
    }

    public void printErros(){
        for(String s : logError)
            System.out.println(s);
    }

    public void visit(Program p){}

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

    }

    @Override
    public void visit(ExprList exprList) {

    }

    public void visit(Func f){}

    @Override
    public void visit(If e) {

    }

    @Override
    public void visit(If_else e) {

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

    private void typeArithmeticBinOp(Node n,String opName){
        SType tyr = stk.pop();
        SType tyl = stk.pop();
        if((tyr.match(tyint))){
            if(tyl.match(tyint) || tyl.match(tyfloat)){
                stk.push(tyl);
            } else {
                logError.add((n.getLine() + "," + n.getCol() + "Operador:" +opName+ "não se aplica aos tipos" + tyl.toString() + "e" + tyr.toString()));
                stk.push(tyerr);
            }
        } else if(tyr.match(tyfloat)){
            if(tyl.match(tyint) || tyl.match(tyfloat)){
                stk.push(tyl);
            } else {
                logError.add((n.getLine() + "," + n.getCol() + "Operador:" +opName+ "não se aplica aos tipos" + tyl.toString() + "e" + tyr.toString()));
                stk.push(tyerr);
            }
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
    public void visit(ParamList e) {

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

    }

    @Override
    public void visit(BinOP e) {

    }

    @Override
    public void visit(Call e) {

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
    public void visit(Data e) {

    }

    @Override
    public void visit(Decl e) {

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
