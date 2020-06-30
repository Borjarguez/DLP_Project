/**
 * Tutorial de Diseño de Lenguajes de Programación
 *
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import ast.DefVariable.VarScope;
import main.ErrorManager;
import visitor.DefaultVisitor;

import java.util.Arrays;
import java.util.Collection;

public class TypeChecking extends DefaultVisitor {

    private Collection<Class> tipoSimple = Arrays.asList(new Class[] { IntType.class, RealType.class, CharType.class });
    private Collection<Class> tipoRetornable = Arrays
            .asList(new Class[] { IntType.class, RealType.class, CharType.class, VoidType.class });
    private ErrorManager errorManager;

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // class DefVariable { String name; Type type; }
    public Object visit(DefVariable node, Object param) {
        super.visit(node, param);

        if (node.getScope().equals(VarScope.PARAM))
            predicado(esTipoSimple(node.getType()), "ERROR: El parámetro de la función no es tipo simple", node);

        return null;
    }

    // class DefFunc { String name; List<DefVariable> params; Type returnType;
    // List<DefVariable> definitions; List<Sentence> sentences; }
    public Object visit(DefFunc node, Object param) {
        super.visit(node, param);

        // Comprobación: el tipo de retorno debe de ser tipo retornable
        predicado(tipoRetornable.contains(node.getReturnType().getClass()), "ERROR: Retorno de tipo no simple", node);

        return null;
    }

    // class Assignment { Expression left; Expression right; }
    public Object visit(Assignment node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: ambos hijos deben de tener el mismo tipo
        predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()),
                "ERROR: Los operandos deben ser del mismo tipo", node);

        // Segunda comprobación: el tipo del hijo izquierdo debe ser simple
        predicado(tipoSimple.contains(node.getLeft().getType().getClass()),
                "ERROR: Valor de la izquierda debe ser simple: " + node.getLeft().getType(), node);

        // Tercera comprobación: el hijo izquierdo debe ser modificable
        predicado(node.getLeft().isModificable(), "ERROR: Valor de la izquierda no modificable", node.getLeft());

        return null;
    }

    //	class IfElse { Expression expression;  List<Sentence> if_sent;  List<Sentence> else_sent; }
    public Object visit(IfElse node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: el tipo de la condición debe ser un entero
        predicado(mismoTipo(node.getExpression().getType(), IntType.class),
                "ERROR: El tipo de la condición debe ser un entero", node);

        return null;
    }

    //	class While { Expression param;  List<Sentence> sentence; }
    public Object visit(While node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Comprobación: la condición evaluada debe ser de tipo entero
        predicado(mismoTipo(node.getParam().getType(), IntType.class),
                "ERROR: la condición evaluada debe ser de tipo entero", node);

        return null;
    }

    // class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresión de retorno debe ser de tipo retornable
        predicado(tipoRetornable.contains(node.getExpression().getType().getClass()),
                "ERROR: la expresion de retorno debe ser de tipo retornable", node);

        // Segunda comparación: la expresion debe de ser del mismo tipo que el retorno
        predicado(mismoTipo(node.getDefFunc().getReturnType(), node.getExpression().getType().getClass()),
                "ERROR: La expresion de retorno debe de ser del tipo de retorno de la función", node);

        return null;
    }

    //	class FuncExpr { String name;  List<Expression> args; }
    public Object visit(FuncExpr node, Object param) {
        super.visit(node, param);

        // Primera comprobación: el numero de parámetros debe ser el de su definición
        predicado(node.getArgs().size() == node.getDefinition().getParams().size(),
                "ERROR: Numero de parámetros incorrecto", node);

        // Segunda comprobación: el tipo de parámetro de la función sea el de su definición
        if (node.getDefinition().getParams().size() == node.getArgs().size())
            for (int i = 0; i < node.getDefinition().getParams().size(); i++) {
                predicado(mismoTipo(node.getDefinition().getParams().get(i).getType(), node.getArgs().get(i).getType()),
                        "ERROR: Tipo de los parámetros no coincide", node);
            }

        node.setType(node.getDefinition().getReturnType());
        node.setModificable(false);
        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresion que se quiere leer debe ser de tipo simple
        predicado(tipoSimple.contains(node.getExpression().getType().getClass()),
                "ERROR: la expresion que se quiere leer debe ser de tipo simple", node);

        // Segunda comprobación: la expresion que se quiere leer debe ser modificable
        predicado(node.getExpression().isModificable(), "ERROR: la expresion que se quiere leer debe ser modificable",
                node);

        return null;
    }

    // class Print { Expression expression; }
    public Object visit(Print node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresion que se quiere leer debe ser de tipo simples
        predicado(
                tipoSimple.contains(node.getExpression().getType().getClass())
                        || node.getExpression().getType().getClass() == VoidType.class
                        || node.getExpression().getType().getClass() == ErrorType.class,
                "ERROR: la expresion que se quiere imprimir debe ser de tipo simple", node);

        return null;
    }

    // class Println { Expression expression; }
    public Object visit(Println node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresion que se quiere leer debe ser de tipo simple
        predicado(
                tipoSimple.contains(node.getExpression().getType().getClass())
                        || node.getExpression().getType().getClass() == VoidType.class,
                "ERROR: la expresion que se quiere imprimir debe ser de tipo simple", node);

        return null;
    }

    // class Printsp { Expression expression; }
    public Object visit(Printsp node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresion que se quiere leer debe ser de tipo simple
        predicado(tipoSimple.contains(node.getExpression().getType().getClass()),
                "ERROR: la expresion que se quiere imprimir debe ser de tipo simple", node);

        return null;
    }

    // class FuncSentence { String name; List<Expression> args; }
    public Object visit(FuncSentence node, Object param) {
        super.visit(node, param);

        // Comprobamos que el numero de parámetros sea con el que se definió la función
        predicado(node.getArgs().size() == node.getDefFunc().getParams().size(),
                "ERROR: Número de argumentos incorrecto", node);

        // Compruebo que el tipo de parámetro de la función sea el de su definición
        if (node.getDefFunc().getParams().size() == node.getArgs().size())
            for (int i = 0; i < node.getDefFunc().getParams().size(); i++) {
                predicado(mismoTipo(node.getDefFunc().getParams().get(i).getType(), node.getArgs().get(i).getType()),
                        "ERROR: Tipo de los parámetros no coincide", node);
            }

        return null;
    }

    // class Variable { String name; }
    public Object visit(Variable node, Object param) {
        node.setType(node.getDefinition().getType());
        node.setModificable(true);
        return null;
    }

    // class FieldAccess { Expression expression; String name; }
    public Object visit(FieldAccess node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        predicado(mismoTipo(node.getExpression().getType(), VarType.class),
                "ERROR: el tipo de la expresion deberia ser una variable", node);

        if (!mismoTipo(node.getExpression().getType(), VarType.class)) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        StructParam sp = ((VarType) node.getExpression().getType()).findParam(node.getName());
        predicado(sp != null, "ERROR: no existe un argumento con ese nombre", node);

        if (sp == null) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        node.setType(sp.getType());
        node.setModificable(true);
        return null;
    }

    // class ArithmeticExpr { Expression left; String operator; Expression right; }
    public Object visit(ArithmeticExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()), "ERROR: valores de tipos distintos",
                node);

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        predicado(tipoSimple.contains(node.getLeft().getType().getClass()),
                "ERROR: valor de la izquierda debe ser simple:" + node.getLeft(), node);

        node.setType(node.getLeft().getType());
        node.setModificable(false);
        return null;
    }

    // class ComparationExpr { Expression left; String operator; Expression right; }
    public Object visit(ComparationExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()), "ERROR: valores de tipos distintos",
                node);

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        predicado(tipoSimple.contains(node.getLeft().getType().getClass()),
                "ERROR: valor de la izquierda debe ser simple:" + node.getLeft(), node);

        node.setType(new IntType());
        node.setModificable(false);
        return null;
    }

    // class LogicExpr { Expression left; String operator; Expression right; }
    public Object visit(LogicExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()), "ERROR: valores de tipos distintos",
                node);

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        predicado(mismoTipo(node.getLeft().getType(), IntType.class),
                "ERROR: valor de la izquierda debe ser entero:" + node.getLeft(), node);

        node.setType(node.getLeft().getType());
        node.setModificable(false);
        return null;
    }

    // Expresion de negación ('!')
    // class NegationExpr { String operator; Expression expression; }
    public Object visit(NegationExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: el tipo de la expresion debe de ser un entero
        predicado(mismoTipo(node.getType(), IntType.class), "ERROR: la expresion debe de ser un entero", node);

        node.setType(node.getExpression().getType());
        node.setModificable(false);
        return null;
    }

    // class CastExpr { Type type; Expression expression; }
    public Object visit(CastExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: el tipo debe de ser simple
        predicado(tipoSimple.contains(node.getType().getClass()), "ERROR: la expresion debe de ser tipo simple", node);

        if (!tipoSimple.contains(node.getType().getClass())) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Tercera comprobacion: el tipo de la expresion debe de ser tipo simple
        predicado(tipoSimple.contains(node.getExpression().getType().getClass()), "ERROR: el tipo debe de ser simple",
                node);

        // Tercera comprobacion: el tipo de cast no debe de ser el mismo que el de la
        // expresion
        predicado(!mismoTipo(node.getExpression().getType(), node.getType()),
                "ERROR: el tipo de cast debe de ser distinto que el de la expresion", node);

        node.setType(node.getType());
        node.setModificable(false);
        return null;
    }

    // class ArrayCall { Expression index; Expression expr; }
    public Object visit(ArrayCall node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: el tipo de la expresion debe de ser tipo simple
        predicado(node.getIndex().getType().getClass() == IntType.class, "ERROR: el índice debe ser de tipo entero",
                node);

        if (!(mismoTipo(node.getIndex().getType(), IntType.class)
                || !(mismoTipo(node.getIndex().getType(), ArrayType.class)))) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Segunda comprobacion:
        predicado(mismoTipo(node.getExpr().getType(), ArrayType.class),
                "ERROR: el tipo de la expresión debe de ser Array", node);

        if (!(mismoTipo(node.getExpr().getType(), ArrayType.class))) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Reglas semánticas
        node.setType(((ArrayType) node.getExpr().getType()).getType());
        node.setModificable(true);
        return null;
    }

    // class IntConstant { String valor; }
    public Object visit(IntConstant node, Object param) {
        node.setType(new IntType());
        node.setModificable(false);
        return null;
    }

    // class RealConstant { String valor; }
    public Object visit(RealConstant node, Object param) {
        node.setType(new RealType());
        node.setModificable(false);
        return null;
    }

    //	class CharConstant { String value; }
    public Object visit(CharConstant node, Object param) {
        node.setType(new CharType());
        node.setModificable(false);

        return null;
    }

    // class VoidConstant { }
    public Object visit(VoidConstant node, Object param) {
        node.setType(new VoidType());
        node.setModificable(false);
        return null;
    }

    /**
     * Method which checks if the parameter's type is simple
     *
     * @param type, the type to check
     * @return true if it is simple, false in other case
     */
    private boolean esTipoSimple(Type type) {
        return tipoSimple.contains(type.getClass());
    }

    /**
     * Method which checks if both types are equal
     * @param a, the first type
     * @param b, the second type
     * @return true if they are equal, false in other case
     */
    private boolean mismoTipo(Type a, Type b) {
        return mismoTipo(a, b.getClass());
    }

    /**
     * Method which checks if both types are equal
     * @param a, the first type
     * @param b, the second type
     * @return true if they are equal, false in other case
     */
    private boolean mismoTipo(Type typeA, Class... typesB) {
        for (Class type : typesB) {
            if (typeA.getClass().equals(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se
     * quiere usar.
     * <p>
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo"):
     * <p>
     * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
     * primitivo", expr.getStart()); 2. predicado(esPrimitivo(expr.tipo), "La
     * expresión debe ser de un tipo primitivo", expr); // Se asume getStart() 3.
     * predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
     * primitivo");
     * <p>
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero
     * fuente donde estaba el nodo (y así poder dar información más detallada de la
     * posición del error). Si se usa VGen, dicho método habrá sido generado en
     * todos los nodos del AST. No es obligatorio llamar a getStart() (ejemplo 2),
     * ya que si se pasa el nodo, se usará por defecto dicha posición. Si no se
     * quiere imprimir la posición del fichero, se puede omitir el tercer argumento
     * (ejemplo 3).
     *
     * @param condition     Debe cumplirse para que no se produzca un error
     * @param errorMessage  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el
     *                      error.
     */

    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Type Checking", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }
}
