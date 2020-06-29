/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.*;

import ast.*;
import ast.DefVariable.VarScope;
import visitor.*;

enum CodeFunction {
    ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

    private Map<String, String> instruction = new HashMap<String, String>();

    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;

        instruction.put("+", "add");
        instruction.put("-", "sub");
        instruction.put("*", "mul");
        instruction.put("/", "div");
        instruction.put(">", "gt");
        instruction.put("<", "lt");
        instruction.put(">=", "ge");
        instruction.put("<=", "le");
        instruction.put("==", "eq");
        instruction.put("!=", "ne");
        instruction.put("&&", "and");
        instruction.put("||", "or");
        instruction.put("!", "not");
    }

    public Object visit(Program node, Object param) {
        out("#source \"" + sourceFile + "\"");
        out("call main");
        out("halt");
        writer.println();

        visitChildren(node.getDefinitions(), param);
        return null;
    }

    // class VarDefinition { String name; Type type; }
    public Object visit(DefVariable node, Object param) {
        out("#" + node.getScope().toString() + " " + node.getName() + ":" + node.getType().getMAPLName());
        return null;
    }

    // class Variable { String name; }
    public Object visit(Variable node, Object param) {
        if (((CodeFunction) param) == CodeFunction.VALUE) {
            visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
        } else { // Funcion.DIRECCION
            assert (param == CodeFunction.ADDRESS);
            if (node.getDefinition().getScope().equals(VarScope.GLOBAL)) // Comprobacion variable global
                out("pusha " + node.getDefinition().getAddress());
            else {
                out("pusha BP");
                out("push " + node.getDefinition().getAddress());
                out("add");
            }

        }
        return null;
    }

    // # SENTENCES

    // class Assignment { Expression left; Expression right; }
    public Object visit(Assignment node, Object param) {
        line(node);
        node.getLeft().accept(this, CodeFunction.ADDRESS);
        node.getRight().accept(this, CodeFunction.VALUE);
        out("store", node.getLeft().getType());
        return null;
    }

    private int numIfElse = 0;

    // class IfElse { Expression expression; List<Sentence> if_sent; List<Sentence>
    // else_sent; }
    public Object visit(IfElse node, Object param) {
        line(node); // Linea del inicio del bucle

        int num = numIfElse++; // Para llevar el control del numero de ifElse del programa (n en la especificacion)
        node.getExpression().accept(this, param); // Compruebo la condicion

        // Si no existe clausula else se salta al final del bloque
        if (node.getElse_sent() != null)
            out("jz else_" + num);
        else
            out("jz endBlock_" + num);

        if (node.getIf_sent() != null)
            visitChildren(node.getIf_sent(), param); // recorremos las sentencias del bloque if

        out("jmp endBlock_" + num);

        if (node.getElse_sent() != null) {
            out("else_" + num + ":"); // comienzo de la etiqueta else
            visitChildren(node.getElse_sent(), param); // recorremos las sentencias del bloque else
        }

        out("endBlock_" + num + ":"); // Final del bloque
        return null;
    }

    // Esto es la n en la especificación
    private int numWhiles = 0;

    // class While { Expression param; List<Sentence> sentence; }
    public Object visit(While node, Object param) {
        line(node); // Linea del inicio del bucle

        int num = numWhiles++; // Recupero el numero de whiles del programa
        out("startWhile_" + num + ":"); // Etiqueta while
        node.getParam().accept(this, param); // Visito los hijos

        out("jz endWhile_" + num); // Salto si la condición es válida

        if (node.getSentence() != null)
            visitChildren(node.getSentence(), param);

        out("jmp startWhile_" + num); // Vuelta al principio del bucle
        out("endWhile_" + num + ":"); // Final del bucle

        return null;
    }

    // class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        // Primero, calculo el tamaño de los parámetros
        int paramsSize = 0;
        List<DefVariable> listParams = node.getDefFunc().getParams();

        for (DefVariable var : listParams)
            paramsSize += var.getType().getMemorySize();

        // Segundo, calculo el tamaño del retorno
        int retSize = node.getExpression().getType().getMemorySize();

        // Tercero, calculo el tamaño de las variables
        int varsSize = 0;
        List<DefVariable> listVariables = node.getDefFunc().getDefinitions();

        for (DefVariable var : listVariables)
            varsSize += var.getType().getMemorySize();

        out("ret " + retSize + "-" + varsSize + "-" + paramsSize);
        return null;
    }

    // class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        line(node);
        super.visit(node, CodeFunction.ADDRESS);

        out("in", node.getDefFunc().getReturnType());
        out("store", node.getDefFunc().getReturnType());

        writer.println();
        return null;
    }

    // class Print { Expression expression; }
    public Object visit(Print node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        return null;
    }

    // class Println { Expression expression; }
    public Object visit(Println node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        return null;
    }

    // class Printsp { Expression expression; }
    public Object visit(Printsp node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        return null;
    }

    // class FuncSentence { String name; List<Expression> args; }
    public Object visit(FuncSentence node, Object param) {
        visitChildren(node.getArgs(), CodeFunction.VALUE);
        out("call " + node.getName());
        return null;
    }

    // # EXPRESSIONS

    // class ArithmeticExpression { Expression left; String operator; Expression
    // right; }
    public Object visit(ArithmeticExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()), node.getType());
        return null;
    }

    // class ComparationExpr { Expression left; String operator; Expression right; }
    public Object visit(ComparationExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()), node.getType());
        return null;
    }

    // class LogicExpr { Expression left; String operator; Expression right; }
    public Object visit(LogicExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()), node.getType());
        return null;
    }

    // class NegationExpr { String operator; Expression expression; }
    public Object visit(NegationExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()));
        return null;
    }

    // class CastExpr { Type type; Expression expression; }
    public Object visit(CastExpr node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out(node.getExpression().getType().getSuffix() + "2" + node.getType().getSuffix());
        return null;
    }

    // class FieldAccess { Expression expression; String name; }
    public Object visit(FieldAccess node, Object param) {
        if (param == CodeFunction.VALUE) {
            visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
        } else {
            if (param == CodeFunction.ADDRESS) {
                node.getExpression().accept(this, param);
                VarType definition = (VarType) node.getExpression().getType();
                out("push " + definition.findParam(node.getName()).getAddress());
                out(instruction.get("+"));
            }
        }
        return null;
    }

    // class ArrayCall { Expression index; Expression expr; }
    public Object visit(ArrayCall node, Object param) {
        if (param == CodeFunction.VALUE) {
            visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
        } else {
            if (param == CodeFunction.ADDRESS) {
                node.getExpr().accept(this, param);
                node.getIndex().accept(this, CodeFunction.VALUE);
                out("push " + node.getType().getMemorySize());
                out(instruction.get("*"));
                out(instruction.get("+"));
            }
        }
        return null;
    }

    // class FuncExpr { String name; List<Expression> args; }
    public Object visit(FuncExpr node, Object param) {
        visitChildren(node.getArgs(), CodeFunction.VALUE);
        out("call " + node.getName());
        return null;
    }

    //	class IntConstant { String valor; }
    public Object visit(IntConstant node, Object param) {
        assert (param == CodeFunction.VALUE);
        out("push " + node.getValue());
        return node.getValue();
    }

    //	class RealConstant { String valor; }
    public Object visit(RealConstant node, Object param) {
        assert (param == CodeFunction.VALUE);
        out("pushf " + node.getValue());
        return null;
    }

    //	class CharConstant { String value; }
    public Object visit(CharConstant node, Object param) {
        assert (param == CodeFunction.VALUE);

        int code = (int) node.getValue().charAt(0);
        if (node.getValue().charAt(0) == '\\' && node.getValue().charAt(1) == 'n')
            code = 10;

        out("pushb " + code);
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
