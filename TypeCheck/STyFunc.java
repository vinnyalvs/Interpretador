/*
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C
*/

package TypeCheck;

public class STyFunc extends SType {

    private  SType ty[];

    public STyFunc(SType[] ty) {
        this.ty = ty;
    }

    public SType[] getTypes() {
        return ty;
    }

    public void setTy(SType[] ty) {
        this.ty = ty;
    }

    @Override
    public boolean match(SType v) {
        boolean r =  false;
        if( v instanceof STyFunc){
            if(((STyFunc) v).getTypes().length == ty.length){
                r = true;
                for(int i=0;i< ty.length; i++){
                    r = r && ty[i].match( ((STyFunc) v).getTypes()[i]);
                }
            }
        }
        return r;
    }


}
