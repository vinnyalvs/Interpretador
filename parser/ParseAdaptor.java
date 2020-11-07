/* 
   Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C 
*/

package parser;

import java.io.*;
import ast.SuperNode;
import lang.parser.*;
import java.util.List;


// Adaptador para classe de parser. a Função parseFile deve retornar null caso o parser resulte em erro. 

public interface ParseAdaptor{
   public abstract SuperNode parseFile(String path) throws IOException;
   
}



