/* 
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C 
*/

package parser;

import parser.LangLexer;
import parser.LangParser;
import ast.Node;
import ast.SuperNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.TokenSource;

import java.io.IOException;


public class LangAdaptor implements ParseAdaptor {
    @Override
    public SuperNode parseFile(String path) throws IOException {

        LangLexer lexer = new LangLexer(CharStreams.fromFileName(path));
        LangParser parser = new LangParser(new CommonTokenStream(lexer));

        try {
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener()  {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    throw new RuntimeException(e.getCause());
                }
            });

            if( parser.getNumberOfSyntaxErrors() > 0)
                return null;

            CreateASTFromParser antlr_visitor = new CreateASTFromParser();

            SuperNode s = antlr_visitor.visit(parser.prog());

            System.out.println("Resultado");

            System.out.println(s.toString());

            SuperNode node = new Node();

            return node;


        }
        catch(RuntimeException e) {
            return null;
        }


    }

}
