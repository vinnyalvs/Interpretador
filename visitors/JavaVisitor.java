package visitors;


import TypeCheck.*;
import ast.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JavaVisitor extends Visitor {

    private STGroup groupTemplate;
    private ST type, stmt, expr;
    private List<ST> funcs, params;

    private String fileName;

    TyEnv<LocalEnv<SType>> env;

    public JavaVisitor(String fileName, TyEnv<LocalEnv<SType>> env) {
        groupTemplate = new STGroupFile("./template/java.stg");
        this.fileName = fileName;
        this.env = env;
    }

    @Override
    public void visit(Program p) {
        ST template = groupTemplate.getInstanceOf("program");

        template.add("name", fileName);
        funcs = new ArrayList<ST>();
        for(Func f : p.getFuncs()) {
            f.accept(this);
        }
        template.add("funcs", funcs);

        System.out.println(template.render());
        // TODO save file in JAVA
    }

    @Override
    public void visit(Add e) {
        ST aux = groupTemplate.getInstanceOf("add_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(And e) {
        ST aux = groupTemplate.getInstanceOf("and_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Attr e) {
        stmt = groupTemplate.getInstanceOf("attr");
        String id = "";

        // È desse jeito pq o código é gambiarrado e o lvalue dot retorna o próprio id em getId()

        Lvalue lv = e.getLv();

        if (lv instanceof Lvalue_dot)
        {
            id =  ((Lvalue_dot) lv).getLv().getId();
        } else {
            id = (lv).getId();
        }
        e.getLv().accept(this);
        stmt.add("var", expr);

        e.getE().accept(this);
        stmt.add("expr", expr);
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
        ST aux = groupTemplate.getInstanceOf("not_expr");
        e.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Diff e) {
        ST aux = groupTemplate.getInstanceOf("sub_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Div e) {
        ST aux = groupTemplate.getInstanceOf("div_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Equal e) {
        ST aux = groupTemplate.getInstanceOf("eq_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Func f) {
        ST fun = groupTemplate.getInstanceOf("func");
        fun.add("name", f.getId().equals("main") ? "inicio" : f.getId() ); // TODO justificar no relatório
        String id = f.getId();
        LocalEnv<SType> local = env.get(id);
        Set<String> keys = local.getKeys();

        ArrayList<Type> func_rets = f.getRet();
        for(Type ret : func_rets){
            ret.accept(this);
            fun.add("type", ret);
            break;
            // TODO multiple returns
        }

        params = new ArrayList<ST>();
        ParamList paramList = f.getParamList();
        for(int i=0; i< paramList.getSize(); i++) {
            keys.remove(paramList.getId(i));
            paramList.getType(i).accept(this);
        }
        fun.add("params", params);

        for(String key : keys) {
            ST decl = groupTemplate.getInstanceOf("param");
            decl.add("name", key);
            SType t = local.get(key);
            processSType(t);
            decl.add("type", type);
            fun.add("decl", decl);
        }

        for(Cmd cmd :  f.getBody().getCmdList()){
            cmd.accept(this);
            fun.add("stmt", stmt);
        }

        funcs.add(fun);
    }

    @Override
    public void visit(If e) {
        ST aux = groupTemplate.getInstanceOf("if");
        e.getTest().accept(this);
        aux.add("expr", expr);
        e.getThen().accept(this);
        aux.add("thn", stmt);
        stmt = aux;
    }

    @Override
    public void visit(If_else e) {
        ST aux = groupTemplate.getInstanceOf("if");
        e.getTest().accept(this);
        aux.add("expr", expr);
        e.getThen().accept(this);
        aux.add("thn", stmt);
        Node n = e.getElse();
        if(n != null) {
            n.accept(this);
            aux.add("els", stmt);
        }
        stmt = aux;
    }

    @Override
    public void visit(Iterate e) { // TODO relatar o iterate _aux
        ST aux = groupTemplate.getInstanceOf("if");
        e.getTest().accept(this);
        aux.add("expr", expr);
        e.getBody().accept(this);
        for(Cmd cmd :  ((CmdList) e.getBody()).getCmdList()){
            cmd.accept(this);
            stmt = aux;
            aux.add("stmt", stmt);

        }


    }

    @Override
    public void visit(LessThan e) {
        ST aux = groupTemplate.getInstanceOf("lt_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(LiteralChar e) {
        expr = groupTemplate.getInstanceOf("char_expr");
        expr.add("value", e.getValue());
    }

    @Override
    public void visit(LiteralFalse e) {
        expr = groupTemplate.getInstanceOf("boolean_expr");
        expr.add("value", e.getValue());
    }

    @Override
    public void visit(LiteralFloat e) {
        expr = groupTemplate.getInstanceOf("float_expr");
        expr.add("value", e.getValue());
    }

    @Override
    public void visit(LiteralInt e) {
        expr = groupTemplate.getInstanceOf("int_expr");
        expr.add("value", e.getValue());
    }

    @Override
    public void visit(LiteralNull e) {
        expr = groupTemplate.getInstanceOf("null");
    }

    @Override
    public void visit(LiteralTrue e) {
        expr = groupTemplate.getInstanceOf("boolean_expr");
        expr.add("value", e.getValue());
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
        ST lvalue = groupTemplate.getInstanceOf("lvalue_id");
        lvalue.add("name",e.getId());
        expr = lvalue;
    }

    @Override
    public void visit(Minus e) {
        ST aux = groupTemplate.getInstanceOf("minus_expr");
        e.getE().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Mod e) {
        ST aux = groupTemplate.getInstanceOf("mod_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Mul e) {
        ST aux = groupTemplate.getInstanceOf("mul_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(New e) {

    }

    @Override
    public void visit(Noeq e) {
        ST aux = groupTemplate.getInstanceOf("notequals_expr");
        e.getL().accept(this);
        aux.add("left_expr", expr);
        e.getR().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(ParamList e) {

    }

    @Override
    public void visit(PexpFunc e) {

    }

    @Override
    public void visit(Print e) {
        stmt = groupTemplate.getInstanceOf("print");
        e.getExpr().accept(this);
        stmt.add("expr", expr);
    }


    @Override
    public void visit(Read e) {
        stmt = groupTemplate.getInstanceOf("read");
        e.getLv().accept(this);
        stmt.add("expr", expr);
    }

    @Override
    public void visit(Return e) {
        /*stmt = groupTemplate.getInstanceOf("return");
        ArrayList<Expr> exps = e.getArgs();
        for(Expr exp : exps){
            exp.accept(this);
            stmt.add("expr", expr);
        } */
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

    ////////////// Métodos ///////////
    private void processSType(SType t) {
        if(t instanceof STyInt)
            type = groupTemplate.getInstanceOf("int_type");
        else if(t instanceof STyBool)
            type = groupTemplate.getInstanceOf("boolean_type");
        else if(t instanceof STyFloat)
            type = groupTemplate.getInstanceOf("float_type");
        else if(t instanceof STyChar)
            type = groupTemplate.getInstanceOf("char_type");
        else if(t instanceof STyArray) {
            ST aux = groupTemplate.getInstanceOf("array_type");
            processSType(((STyArray) t).getArg());
            aux.add("type", type);
            type = aux;
        }
    }

    @Override
    public void visit(ExprList exprList) {

    }

}
