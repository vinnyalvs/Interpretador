package ast;

import org.antlr.v4.runtime.misc.Pair;
import visitors.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

//params:	ID DOUBLECOLON type ( COMMA  ID DOUBLECOLON type )* ;

public class ParamList extends Node{

    ArrayList<Type> types;
    ArrayList<String> ids;

    public ParamList(int line, int col) {
        super(line, col);
        types = new ArrayList<>();
        ids = new ArrayList<>();
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

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    public ArrayList<String> getIds() {
        return ids;
    }

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }

    @Override
    public void accept(Visitor v) {v.visit(this);}
}
