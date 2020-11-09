package ast;

import org.antlr.v4.runtime.misc.Pair;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ParamList extends Node{

    ArrayList<Type> types;
    ArrayList<String> ids;

    public ParamList(int line, int col) {
        super(line, col);
        types = new ArrayList<>();
        ids = new ArrayList<>();
    }

    public static void addParam(int line, int column, Type t, String type_id) {
    }

    public Type getType(int index) {
        return types.get(index);
    }

    public String getId(int index) {
        return ids.get(index);
    }

    public void addParam(String id, Type type) {
        this.types.add(type);
        this.ids.add(id);
    }

    public int getSize (){
        return types.size();
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
