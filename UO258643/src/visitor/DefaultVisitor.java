/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

    //	class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {
        visitChildren(node.getDefinitions(), param);
        return null;
    }

    //	class DefVariable { String name;  Type type; }
    public Object visit(DefVariable node, Object param) {
        if (node.getType() != null)
            node.getType().accept(this, param);
        return null;
    }

    //	class DefStruct { String name;  List<StructParam> param; }
    public Object visit(DefStruct node, Object param) {
        visitChildren(node.getParams(), param);
        return null;
    }

    //	class StructParam { String name;  Type type; }
    public Object visit(StructParam node, Object param) {
        if (node.getType() != null)
            node.getType().accept(this, param);
        return null;
    }

    //	class DefFunc { String name;  List<DefVariable> args;  Type returnType;  List<DefVariable> definitions;  List<Sentence> sentences; }
    public Object visit(DefFunc node, Object param) {
        visitChildren(node.getParams(), param);
        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);
        visitChildren(node.getDefinitions(), param);
        visitChildren(node.getSentences(), param);
        return null;
    }

    //	class IntType {  }
    public Object visit(IntType node, Object param) {
        return null;
    }

    //	class RealType {  }
    public Object visit(RealType node, Object param) {
        return null;
    }

    //	class CharType {  }
    public Object visit(CharType node, Object param) {
        return null;
    }

    //	class VarType { String name; }
    public Object visit(VarType node, Object param) {
        return null;
    }

    //	class ArrayType { IntConstant size;  Type type; }
    public Object visit(ArrayType node, Object param) {
        if (node.getSize() != null)
            node.getSize().accept(this, param);
        if (node.getType() != null)
            node.getType().accept(this, param);
        return null;
    }

    //	class ErrorType {  }
    public Object visit(ErrorType node, Object param) {
        return null;
    }

    //	class VoidType {  }
    public Object visit(VoidType node, Object param) {
        return null;
    }

    //	class Assignment { Expression left;  Expression right; }
    public Object visit(Assignment node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        if (node.getRight() != null)
            node.getRight().accept(this, param);
        return null;
    }

    //	class IfElse { Expression expression;  List<Sentence> if_sent;  List<Sentence> else_sent; }
    public Object visit(IfElse node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        visitChildren(node.getIf_sent(), param);
        visitChildren(node.getElse_sent(), param);
        return null;
    }

    //	class While { Expression param;  List<Sentence> sentence; }
    public Object visit(While node, Object param) {
        if (node.getParam() != null)
            node.getParam().accept(this, param);
        visitChildren(node.getSentence(), param);
        return null;
    }

    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class Print { Expression expression; }
    public Object visit(Print node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class Println { Expression expression; }
    public Object visit(Println node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class Printsp { Expression expression; }
    public Object visit(Printsp node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class FuncSentence { String name;  List<Expression> args; }
    public Object visit(FuncSentence node, Object param) {
        visitChildren(node.getArgs(), param);
        return null;
    }

    //	class IntConstant { String value; }
    public Object visit(IntConstant node, Object param) {
        return null;
    }

    //	class RealConstant { String value; }
    public Object visit(RealConstant node, Object param) {
        return null;
    }

    //	class CharConstant { String value; }
    public Object visit(CharConstant node, Object param) {
        return null;
    }

    //	class Variable { String value; }
    public Object visit(Variable node, Object param) {
        return null;
    }

    //	class VoidConstant {  }
    public Object visit(VoidConstant node, Object param) {
        return null;
    }

    //	class ArrayCall { Expression index;  Expression expr; }
    public Object visit(ArrayCall node, Object param) {
        if (node.getIndex() != null)
            node.getIndex().accept(this, param);
        if (node.getExpr() != null)
            node.getExpr().accept(this, param);
        return null;
    }

    //	class FieldAccess { Expression expression;  String name; }
    public Object visit(FieldAccess node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class ArithmeticExpr { Expression left;  String operator;  Expression right; }
    public Object visit(ArithmeticExpr node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        if (node.getRight() != null)
            node.getRight().accept(this, param);
        return null;
    }

    //	class ComparationExpr { Expression left;  String operator;  Expression right; }
    public Object visit(ComparationExpr node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        if (node.getRight() != null)
            node.getRight().accept(this, param);
        return null;
    }

    //	class LogicExpr { Expression left;  String operator;  Expression right; }
    public Object visit(LogicExpr node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, param);
        if (node.getRight() != null)
            node.getRight().accept(this, param);
        return null;
    }

    //	class NegationExpr { String operator;  Expression expression; }
    public Object visit(NegationExpr node, Object param) {
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class CastExpr { Type type;  Expression expression; }
    public Object visit(CastExpr node, Object param) {
        if (node.getType() != null)
            node.getType().accept(this, param);
        if (node.getExpression() != null)
            node.getExpression().accept(this, param);
        return null;
    }

    //	class VoidExpr {  }
    public Object visit(VoidExpr node, Object param) {
        return null;
    }

    //	class FuncExpr { String name;  List<Expression> args; }
    public Object visit(FuncExpr node, Object param) {
        visitChildren(node.getArgs(), param);
        return null;
    }

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }

}
