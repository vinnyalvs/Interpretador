package TypeCheck;

public class STyArray extends SType {

    private SType a;

    public STyArray(SType t){
        a = t;

    }

    public SType getArg() {
        return a;
    }

    public void setA(SType a) {
        this.a = a;
    }

   /* public static SType newSTyArray(){
        return st;
    } */



    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyArray) && (a.match(((STyArray)v).getArg()) ) ;
    }


    @Override
    public java.lang.String toString() {
        return a.toString() + "[]";
    }
}
