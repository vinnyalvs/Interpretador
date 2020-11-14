package visitors;
import TypeCheck.*;
import ast.*;

import java.util.ArrayList;
import java.util.Stack;

public class TypeCheckVisitor extends Visitor {
    private STyInt tyint =  STyInt.newSTyInt();
    private STyFloat tyfloat =  STyFloat.newSTyFloat();
    private STyChar tychar =  STyChar.newSTyChar();
    private STyBool tybool =  STyBool.newSTyBool();
    private STyErr tyerr =  STyErr.newSTyErr();

    private ArrayList<String> logError;

    // private TyEnv<LocalEnv<SType>> env;
    // private LocalEnv<SType> temp;

    private Stack<SType> stk;
    private  boolean retCheck;

    public TypeCheckVisitor() {
        stk = new Stack<SType>();
        // env = new TyEnv<LocalEnv<SType>>();
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

    }

    @Override
    public void visit(Return e) {

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

    }

    @Override
    public void visit(ParamList e) {

    }

    @Override
    public void visit(Print e) {

    }

    public void visit(Div e){
        e.getL().accept(this);
        e.getR().accept(this);
        typeArithmeticBinOp(e,"/");
    }

    @Override
    public void visit(Equal e) {

    }

    public void visit(Diff e){}

    public void visit(And e){
        e.getL().accept(this);
        e.getR().accept(this);
        typeArithmeticBinOp(e,"-");

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


}
