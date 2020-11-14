package TypeCheck;

public class STyBool extends SType {

    private static STyBool st = new STyBool();

    private STyBool(){

    }

    public static STyBool newSTyBool(){
        return st;
    }


    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyBool);
    }


    @Override
    public java.lang.String toString() {
        return "Bool";
    }
}
