package TypeCheck;

import java.util.HashMap;

public class STyData extends SType {

    private String id;

    private HashMap<String, SType> vars;

    public STyData(String id){
        this.id = id;
        vars = new HashMap<>();
    }

    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyData && ((STyData) v).getId().equals(this.id));
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, SType> getVars() {
        return vars;
    }

    public void add(String id, SType type){
        vars.put(id, type);
    }
}
