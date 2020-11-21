package visitors;


import TypeCheck.*;
import ast.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JavaVisitor extends Visitor {

    private STGroup groupTemplate;
    private ST type, stmt, expr;
    private List<ST> funcs, params, datas;
    private HashMap<String, STyData> datas_map;

    private String fileName;

    TyEnv<LocalEnv<SType>> env;

    public JavaVisitor(String fileName, TyEnv<LocalEnv<SType>> env, HashMap<String, STyData> datas) {
        groupTemplate = new STGroupFile("./template/java.stg");
        this.fileName = fileName;
        this.env = env;
        this.datas_map = datas;
    }

    @Override
    public void visit(Program p) {
        ST template = groupTemplate.getInstanceOf("program");

        template.add("name", fileName);
        datas = new ArrayList<ST>();
        for(Data d : p.getDatas() ) {
            d.accept(this);
        }
        template.add("data", datas);

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
    public void visit(BinOP e) { // não visita

    }

    @Override
    public void visit(Call e) {
        ArrayList <SType> params_stype = new ArrayList<SType>();

        ArrayList <Expr> args_expr= e.getArgs().getExprList();

        for( int i=0; i < args_expr.size() ; i++ ){
            args_expr.get(i).accept(this);
        } // Tipos dos params
    }

    @Override
    public void visit(Cmd e) { //não visita

    }

    @Override
    public void visit(CmdList e) {
        for(Cmd cmd : e.getCmdList()){
            cmd.accept(this);

        }
    }

    @Override
    public void visit(Data e) {
        ST data = groupTemplate.getInstanceOf("data");
        data.add("id", e.getId());

        STyData data_aux = datas_map.get(e.getId());

        for(Decl d : e.getDeclList()){
            d.accept(this);
            ST decl = groupTemplate.getInstanceOf("param");
            decl.add("name", d.getId());
            processSType(data_aux.getVars().get(d.getId()));
            decl.add("type", type);
            data.add("decl", decl);

        }
        datas.add(data);
    }

    @Override
    public void visit(Decl e) {
        ST aux = groupTemplate.getInstanceOf("decl");
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

            ST param = groupTemplate.getInstanceOf("param");
            param.add("type", type);
            param.add("name", paramList.getId(i));

            params.add(param);
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
        ST aux = groupTemplate.getInstanceOf("iterate");
        e.getTest().accept(this);
        aux.add("expr", expr);
        e.getBody().accept(this);
        for(Cmd cmd :  ((CmdList) e.getBody()).getCmdList()){
            cmd.accept(this);
            aux.add("stmt", stmt);
            stmt = aux;
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
        ST lvalue = groupTemplate.getInstanceOf("lvalue_dot");
        lvalue.add("name",e.getLv().getId());
        lvalue.add("attribute",e.getId());
        expr = lvalue;
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
    public void visit(New e) { //TODO relatar o new
        ST aux = groupTemplate.getInstanceOf("new");
        e.getT().accept(this);
        aux.add("type",type);

        if (e.getE() != null)
        {
            e.getE().accept(this);
            aux.add("expr", expr);
        }
        expr = aux;
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
        ST aux = groupTemplate.getInstanceOf("array_type");
        e.getType().accept(this);
        aux.add("type", type);
        type = aux;
    }

    @Override
    public void visit(TyBool e) {
        type = groupTemplate.getInstanceOf("boolean_type");
    }

    @Override
    public void visit(TyChar e) {
        type = groupTemplate.getInstanceOf("char_type");
    }

    @Override
    public void visit(TyFloat e) {
        type = groupTemplate.getInstanceOf("float_type");
    }

    @Override
    public void visit(TyInt e) {
        type = groupTemplate.getInstanceOf("int_type");
    }

    @Override
    public void visit(TyData e) {
        type = groupTemplate.getInstanceOf("data_type");
        type.add("id",e.getId());

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
        else if(t instanceof STyData){
            type = groupTemplate.getInstanceOf("data_type");
            type.add("id", ((STyData) t).getId());
        }
    }

    @Override
    public void visit(ExprList exprList) {

    }

}


