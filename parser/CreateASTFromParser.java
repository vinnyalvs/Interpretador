package parser;

import ast.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Stack;

public class CreateASTFromParser extends LangBaseVisitor<SuperNode> {

    @Override
    public SuperNode visitProg(LangParser.ProgContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        Program progNode = new Program(line, column);
        return progNode; //super.visitProg(ctx);
    }

    public SuperNode visitData(LangParser.DataContext ctx) {

        SuperNode dataNode = null;
        return dataNode;
    }




}
