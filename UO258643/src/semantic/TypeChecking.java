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
import java.util.List;
import java.util.stream.Collectors;

public class TypeChecking extends DefaultVisitor {

    private Collection<Class> tipoSimple = Arrays.asList(new Class[] { IntType.class, RealType.class, CharType.class });
    private Collection<Class> tipoRetornable = Arrays
            .asList(new Class[] { IntType.class, RealType.class, CharType.class, VoidType.class });
    private ErrorManager errorManager;

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
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

    //	class FuncExpr { String name;  List<Expression> args; }
    public Object visit(FuncExpr node, Object param) {
        super.visit(node, param);

        predicado(node.getDefinition().getReturnType().getClass() != VoidType.class, "ERROR: No tiene tipo de retorno",
                node);

        // Comprobamos que el numero de parámetros sea con el que se definió la función
        predicado(node.getArgs().size() == node.getDefinition().getParams().size(),
                "ERROR: Número de argumentos incorrecto", node);

        // Compruebo que el tipo de parámetro de la función sea el de su definición
        if (node.getDefinition().getParams().size() == node.getArgs().size())
            for (int i = 0; i < node.getDefinition().getParams().size(); i++) {
                predicado(mismoTipo(node.getDefinition().getParams().get(i).getType(), node.getArgs().get(i).getType()),
                        "ERROR: Tipo de los parámetros no coincide", node);
            }

        node.setType(node.getDefinition().getReturnType());
        node.setModificable(false);

        return null;
    }

    //	class IfElse { Expression expression;  List<Sentence> if_sent;  List<Sentence> else_sent; }
    public Object visit(IfElse node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);
        // TODO
        // Primera comprobación: el tipo de la condición debe ser un entero
        predicado(mismoTipo(node.getExpression().getType(), IntType.class),
                "ERROR: El tipo de la condición debe ser un entero", node);

        return null;
    }

    //	class While { Expression param;  List<Sentence> sentence; }
    public Object visit(While node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la condición evaluada debe ser de tipo entero
        predicado(mismoTipo(node.getParam().getType(), IntType.class),
                "ERROR: la condición evaluada debe ser de tipo entero", node);

        return null;
    }

    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresión de retorno debe ser de tipo retornable
        predicado(tipoRetornable.contains(node.getExpression().getType().getClass()),
                "ERROR: la expresion de retorno debe ser de tipo retornable", node);

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

    //	class Print { Expression expression; }
    public Object visit(Print node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresion que se quiere leer debe ser de tipo simple
        predicado(tipoSimple.contains(node.getExpression().getType().getClass()),
                "ERROR: la expresion que se quiere imprimir debe ser de tipo simple", node);
        return null;
    }

    //	class Println { Expression expression; }
    public Object visit(Println node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresion que se quiere leer debe ser de tipo simple
        predicado(tipoSimple.contains(node.getExpression().getType().getClass()),
                "ERROR: la expresion que se quiere imprimir debe ser de tipo simple", node);

        return null;
    }

    //	class Printsp { Expression expression; }
    public Object visit(Printsp node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobación: la expresion que se quiere leer debe ser de tipo simple
        predicado(tipoSimple.contains(node.getExpression().getType().getClass()),
                "ERROR: la expresion que se quiere imprimir debe ser de tipo simple", node);

        return null;
    }

    // class DefFunc { String name; List<DefVariable> params; Type returnType;
    // List<DefVariable> definitions; List<Sentence> sentences; }
    public Object visit(DefFunc node, Object param) {
        super.visit(node, param);

        // Comprobacion de los parametros
        node.getParams().forEach(
                p -> predicado(esTipoSimple(p.getType()), "ERROR: Los parámetros deben de ser tipos primitivos", node));

        if (!node.getName().equals("main")) {
            predicado(tipoRetornable.contains(node.getReturnType().getClass()), "ERROR: Retorno de tipo no simple",
                    node);

            // Segunda comprobación: el tipo de retorno existe pero no la cláusula return
            List<Sentence> returns = node.getSentences().stream()
                    .filter(sentence -> sentence.getClass() == Return.class).collect(Collectors.toList());

            predicado(node.getReturnType().getClass() != VoidType.class || returns.size() == 0,
                    "ERROR: El return no debe tener expresión en funciones void", node);

            // Tercera comprobación: el tipo del return y el de la funcion no coincide
            //if (node.getReturnType().getClass() != VoidType.class)
            returns.forEach(ret -> predicado(mismoTipo(node.getReturnType(), ret.getClass()),
                    "ERROR: los tipos de retorno de la funcion y return no coinciden " + node.getReturnType(), node));
        } else {
            predicado(node.getReturnType().getClass() == VoidType.class,
                    "ERROR: La función main no debe de tener returns", node);
        }

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

    // class DefVariable { String name; Type type; }
    public Object visit(DefVariable node, Object param) {
        super.visit(node, param);

        if (node.getScope().equals(VarScope.PARAM))
            predicado(esTipoSimple(node.getType()), "ERROR: El parámetro de la función no es tipo simple", node);

        return null;
    }

    // class Variable { String name; }
    public Object visit(Variable node, Object param) {
        node.setType(node.getDefinition().getType());
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

    // class VoidConstant { }
    public Object visit(VoidConstant node, Object param) {
        node.setType(new VoidType());
        node.setModificable(false);

        return null;
    }

    // # Expresiones acceso a estructuras ()
    // class FieldAccess { Expression expression; String name; }
    public Object visit(FieldAccess node, Object param) {
        // Condicion de error
        boolean isErr, isErr2;

        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        isErr = mismoTipo(node.getExpression().getType(), VarType.class);
        predicado(isErr, "ERROR: el tipo de la expresion deberia ser una variable", node);

        // Compruebo si ha generado error
        if (esError(node, isErr))
            return null;

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        StructParam sp = ((VarType) node.getExpression().getType()).findParam(node.getName());
        isErr2 = sp == null ? false : true;
        predicado(isErr2, "ERROR: no existe un argumento con ese nombre", node);

        // Reglas semánticas
        if (esError(node, isErr2))
            return null;
        else {
            node.setType(sp.getType());
            node.setModificable(true);
            return null;
        }
    }

    // # Expresiones aritméticas (suma, resta, multiplicacion y division)
    // class ArithmeticExpr { Expression left; String operator; Expression right; }
    public Object visit(ArithmeticExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        if (!mismoTipo(node.getLeft().getType(), node.getRight().getType())) {
            predicado(false, "ERROR: valores de tipos distintos", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        if (!tipoSimple.contains(node.getLeft().getType().getClass())) {
            predicado(false, "ERROR: valor de la izquierda debe ser simple:" + node.getLeft(), node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        node.setType(node.getLeft().getType());
        node.setModificable(false);
        return null;
    }

    // # Expresiones de comparación ('>' | '>=' | '<' | '<=')
    // class ComparationExpr { Expression left; String operator; Expression right; }
    public Object visit(ComparationExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        if (!mismoTipo(node.getLeft().getType(), node.getRight().getType())) {
            predicado(false, "ERROR: valores de tipos distintos", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        if (!tipoSimple.contains(node.getLeft().getType().getClass())) {
            predicado(false, "ERROR: valor de la izquierda debe ser simple:" + node.getLeft(), node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        node.setType(node.getLeft().getType());
        node.setModificable(false);
        return null;
    }

    // # Expresiones lógicas ('==' | '!=')
    // class LogicExpr { Expression left; String operator; Expression right; }
    public Object visit(LogicExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: ambos tipos deben de ser iguales
        if (!mismoTipo(node.getLeft().getType(), node.getRight().getType())) {
            predicado(false, "ERROR: valores de tipos distintos", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Segunda comprobacion: el tipo de la izquierda debe ser tipos simple
        if (!mismoTipo(node.getLeft().getType(), IntType.class)) {
            predicado(false, "ERROR: valor de la izquierda debe ser entero:" + node.getLeft(), node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        node.setType(node.getLeft().getType());
        node.setModificable(false);
        return null;
    }

    // # Expresion de negación ('!')
    // class NegationExpr { String operator; Expression expression; }
    public Object visit(NegationExpr node, Object param) {
        // Condicion de error
        boolean isErr = false;

        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: el tipo de la expresion debe de ser un entero
        isErr = mismoTipo(node.getType(), IntType.class);
        predicado(isErr, "ERROR: la expresion debe de ser un entero", node);

        // Reglas semánticas
        if (esError(node, isErr))
            return null;
        else {
            node.setType(node.getExpression().getType());
            node.setModificable(false);
            return null;
        }
    }

    // # Expresion de cast (cast <type>)
    // class CastExpr { Type type; Expression expression; }
    public Object visit(CastExpr node, Object param) {
        // Recorrido de los hijos
        super.visit(node, param);
        boolean cond;

        // Primera comprobacion: el tipo de la expresion debe de ser tipo simple
        cond = tipoSimple.contains(node.getType().getClass());

        if (!cond) {
            predicado(false, "ERROR: la expresion debe de ser tipo simple", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Tercera comprobacion: el tipo debe de ser simple
        cond = tipoSimple.contains(node.getExpression().getType().getClass());

        if (!cond) {
            predicado(false, "ERROR: el tipo debe de ser simple", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Tercera comprobacion: el tipo de cast no debe de ser el mismo que el de la
        // expresion
        cond = mismoTipo(node.getExpression().getType(), node.getType());

        if (!cond) {
            predicado(false, "ERROR: el tipo de cast debe de ser distinto que el de la expresion", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        node.setType(node.getType());
        node.setModificable(false);
        return null;
    }

    // # Expresion de acceso a array (expr '[' expr ']')
    // class ArrayCall { Expression index; Expression expr; }
    public Object visit(ArrayCall node, Object param) {
        // Condicion de error
        boolean cond;

        // Recorrido de los hijos
        super.visit(node, param);

        // Primera comprobacion: el tipo de la expresion debe de ser tipo simple
        cond = mismoTipo(node.getIndex().getType(), IntType.class);

        if (!cond) {
            predicado(false, "ERROR: el índice debe ser de tipo entero", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Segunda comprobacion:
        cond = mismoTipo(node.getExpr().getType(), ArrayType.class);
        if (!cond) {
            predicado(false, "ERROR: el tipo de la expresión debe de ser Array", node);

            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        // Reglas semánticas
        node.setType(((ArrayType) node.getExpr().getType()));
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

    // #--------------------------------------------------------
    // # Funciones auxiliares

    /**
     * Method which checks if the condition is false, so the program has to return
     * an error
     *
     * @param node,      the expression
     * @param condition, the condition to check
     * @return true if the condition is false, false in other case
     */
    private boolean esError(Expression node, boolean... condition) {
        for (boolean cond : condition) {
            if (!cond) {
                node.setType(new ErrorType());
                node.setModificable(false);
                return true;
            }
        }

        return false;
    }

    private boolean mismoTipo(Type a, Type b) {
        return mismoTipo(a, b.getClass());
    }

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
