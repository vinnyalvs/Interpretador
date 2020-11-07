/* 
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C 
*/

package ast;

import visitors.Visitor;
import visitors.Visitable;

public class Node extends SuperNode implements Visitable{

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public void accept(Visitor v) {}
}
