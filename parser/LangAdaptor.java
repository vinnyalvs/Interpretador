/* 
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C 
*/

package parser;

import TypeCheck.LocalEnv;
import TypeCheck.STyData;
import TypeCheck.SType;
import TypeCheck.TyEnv;
import parser.LangLexer;
import parser.LangParser;
import ast.Node;
import ast.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.TokenSource;

import java.io.IOException;
import java.util.HashMap;

import visitors.*;


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

            TypeCheckVisitor tc = new TypeCheckVisitor();

            ((Node)s).accept(tc);

            if(tc.getNumErros() > 0) {
                System.out.println("Erro durante Analise Semantica!");
                tc.printErros();
            } else {
                TyEnv<LocalEnv<SType>> env = tc.getEnv();
                HashMap<String, STyData> datas = tc.getDatas();
                String [] splitted = path.split("/");
                String correct_name = splitted[splitted.length -1].substring(0, 1).toUpperCase() + splitted[splitted.length -1].substring(1);
                correct_name = correct_name.substring(0, correct_name.length()-4);
                JavaVisitor jv = new JavaVisitor(correct_name,env,datas );
                ((Node)s).accept(jv);
            }

//            InterpretVisitor iv = new InterpretVisitor();
//
//            ((Node)s).accept(iv);

            return s;

        }
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

}
