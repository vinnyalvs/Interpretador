package TypeCheck;

public class STyFloat extends SType {

    private static STyFloat st = new STyFloat();

    private STyFloat(){

    }

    public static STyFloat newSTyFloat(){
        return st;
    }

    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyFloat);
    }


    @Override
    public java.lang.String toString() {
        return "Float";
    }
}
