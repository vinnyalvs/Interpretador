package ast;

public class If_else extends If {

    Node els;

    public If_else(int line, int col) {
        super(line, col);
    }

    public Node getElse() {
        return els;
    }
}
