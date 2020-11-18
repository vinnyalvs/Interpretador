/*
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C
*/

package TypeCheck;

public class STyArray extends SType {

    private SType a;

    public STyArray(SType a) {
        this.a = a;
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
