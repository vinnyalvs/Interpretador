/*
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C
*/
package TypeCheck;

public class STyChar extends SType {

    private static STyChar st = new STyChar();

    private STyChar(){

    }

    public static STyChar newSTyChar(){
        return st;
    }

    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyChar);
    }


    @Override
    public java.lang.String toString() {
        return "Char";
    }
}
