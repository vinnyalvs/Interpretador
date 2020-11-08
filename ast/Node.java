/* 
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C 
*/

package ast;

import visitors.Visitor;
import visitors.Visitable;

public class Node extends SuperNode implements Visitable{

    int line;
    int column;

    @Override
    public String toString() {
        return "Node{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getCol() {
        return column;
    }

    @Override
    public void accept(Visitor v) {}
}
