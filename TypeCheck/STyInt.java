package TypeCheck;

public class STyInt extends SType {

    private static STyInt st = new STyInt();

    private STyInt(){

    }

    public static STyInt newSTyInt(){
        return st;
    }

    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyInt);
    }


    @Override
    public java.lang.String toString() {
        return "Int";
    }
}
