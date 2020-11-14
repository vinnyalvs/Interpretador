package TypeCheck;

public class STyErr extends SType {

    private static STyErr st = new STyErr();

    private STyErr(){

    }

    @Override
    public boolean match(SType v) {
        return true;
    }

    public static STyErr newSTyErr(){
        return st;
    }


    @Override
    public java.lang.String toString() {
        return "Erro";
    }
}
