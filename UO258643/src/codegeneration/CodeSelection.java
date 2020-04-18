/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.*;

import ast.*;
import visitor.*;

enum CodeFunction {
    ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

    private Map<String, String> arithmethicInstruction = new HashMap<String, String>();
    private Map<String, String> comparationInstruction = new HashMap<String, String>();
    private Map<String, String> logicalInstruction = new HashMap<String, String>();

    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;

        arithmethicInstruction.put("+", "add");
        arithmethicInstruction.put("-", "sub");
        arithmethicInstruction.put("*", "mul");
        arithmethicInstruction.put("/", "div");

        comparationInstruction.put(">", "gt");
        comparationInstruction.put("<", "lt");
        comparationInstruction.put(">=", "ge");
        comparationInstruction.put("<=", "le");

        logicalInstruction.put("==", "eq");
        logicalInstruction.put("!=", "ne");
        logicalInstruction.put("&&", "and");
        logicalInstruction.put("||", "or");
    }

    public Object visit(Program node, Object param) {
        out("#source \"" + sourceFile + "\"");
        visitChildren(node.getDefinitions(), param);
        out("halt");

        super.visit(node, param); // Recorrer los hijos
        return null;
    }

    public Object visit(Assignment node, Object param) {
        line(node);
        node.getLeft().accept(this, CodeFunction.ADDRESS);
        node.getRight().accept(this, CodeFunction.VALUE);
        out("store", node.getLeft().getType());
        return null;
    }

    // class Print { Expression expression; }
    public Object visit(Print node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        return null;
    }

    // # EXPRESSIONS

    // class ArithmeticExpression { Expression left; String operator; Expression
    // right; }
    public Object visit(ArithmeticExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(arithmethicInstruction.get(node.getOperator()), node.getType());
        return null;
    }

    //	class ComparationExpr { Expression left;  String operator;  Expression right; }
    public Object visit(ComparationExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(comparationInstruction.get(node.getOperator()), node.getType());
        return null;
    }

    //	class LogicExpr { Expression left;  String operator;  Expression right; }
    public Object visit(LogicExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(logicalInstruction.get(node.getOperator()), node.getType());
        return null;
    }

    // ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------
    private void out(String instruction) {
        writer.println(instruction);
    }

    private void out(String instruccion, Type tipo) {
        out(instruccion + tipo.getSuffix());
    }

    private void line(Position pos) {
        out("\n#line " + pos.getLine());
    }

    private void line(AST node) {
        line(node.getEnd());
    }

    private PrintWriter writer;
    private String sourceFile;
}
