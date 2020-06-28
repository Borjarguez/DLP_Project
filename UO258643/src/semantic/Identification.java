/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.*;
import ast.DefVariable.VarScope;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

    private ErrorManager errorManager;
    private Map<String, DefFunc> funciones = new HashMap<String, DefFunc>();
    private Map<String, DefStruct> simbolos = new HashMap<String, DefStruct>();
    private ContextMap<String, Definition> variables = new ContextMap<String, Definition>();

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // ----------------- FUNCIONES -----------------

    //	class DefFunc { String name;  List<DefVariable> args;  Type returnType;  List<DefVariable> definitions;  List<Sentence> sentences; }
    public Object visit(DefFunc node, Object param) {
        predicado(funciones.get(node.getName()) == null, "ERROR: Function already exists: " + node.getName(), node);
        funciones.put(node.getName(), node);

        variables.set();

        // Recorro los parametros
        for (DefVariable paramm : node.getParams())
            paramm.accept(this, VarScope.PARAM);

        // Recorro las definiciones de dentro de la funcion
        for (DefVariable def : node.getDefinitions())
            def.accept(this, VarScope.LOCAL);

        // Recorro las sentencias
        for (Sentence sent : node.getSentences())
            sent.accept(this, node);

        node.getReturnType().accept(this, param);

        variables.reset();
        return null;
    }

    //	class FuncSentence { String name;  List<Expression> args; }
    public Object visit(FuncSentence node, Object param) {
        super.visit(node, param);

        predicado(funciones.get(node.getName()) != null, "ERROR: Function does not exists " + node.getName(), node);
        node.setFunDefinition(funciones.get(node.getName()));

        return null;
    }

    //	class FuncExpr { String name;  List<Expression> args; }
    public Object visit(FuncExpr node, Object param) {
        super.visit(node, param);

        DefFunc def = funciones.get(node.getName());
        predicado(funciones.get(node.getName()) != null, "ERROR: Function does not exists " + node.getName(), node);
        node.setDefinition(def);
        return null;
    }

    // ----------------- VARIABLES -----------------

    //	class DefVariable { String name;  Type type; }
    public Object visit(DefVariable node, Object param) {
        super.visit(node, param);
        predicado(variables.getFromTop(node.getName()) == null, "ERROR: Variable ya definida: " + node.getName(), node);
        variables.put(node.getName(), node);
        return null;
    }

    //	class Variable { String value; }
    public Object visit(Variable node, Object param) {
        Definition def = variables.getFromAny(node.getName());
        predicado(def != null, "ERROR: Variable no definida: " + node.getName(), node);

        node.setDefinition((DefVariable) def);
        return null;
    }

    // ----------------- ESTRUCTURAS -----------------

    public Object visit(DefStruct node, Object param) {
        predicado(variables.getFromAny(node.getName().getName()) == null,
                "ERROR: Estructura ya definida: " + node.getName(), node);

        variables.put(node.getName().getName(), node);
        simbolos.put(node.getName().getName(), node);

        variables.set();
        super.visit(node, param);
        variables.reset();

        return null;
    }

    public Object visit(StructParam node, Object param) {
        super.visit(node, param);

        Definition definition = variables.getFromTop(node.getName());

        predicado(definition == null, "ERROR: Atributo repetido en la estructura: " + node.getName(), node);

        node.setDefinition((DefStruct) param);
        variables.put(node.getName(), node);

        return null;
    }

    // ----------------- TIPO VARIABLES -----------------

    public Object visit(VarType node, Object param) {
        super.visit(node, param);
        DefStruct def = simbolos.get(node.getName());
        predicado(def != null, "ERROR: Tipo de dato no definido: " + node.getName(), node);

        node.setDefinition(def);
        return null;
    }

    public Object visit(VoidExpr node, Object param) {
        node.setType(new VoidType());
        return null;
    }

    public Object visit(Assignment node, Object param) {
        super.visit(node, param);

        if (param instanceof DefFunc)
            node.setFunDefinition((DefFunc) param);

        return null;
    }

    public Object visit(IfElse node, Object param) {
        super.visit(node, param);

        if (param instanceof DefFunc)
            node.setFunDefinition((DefFunc) param);

        return null;
    }

    //	class While { Expression expression;  List<Sentence> sentence; }
    public Object visit(While node, Object param) {
        super.visit(node, param);

        if (param instanceof DefFunc) {
            node.setFunDefinition((DefFunc) param);
        }

        return null;
    }

    public Object visit(Return node, Object param) {
        super.visit(node, param);

        if (param instanceof DefFunc) {
            node.setFunDefinition((DefFunc) param);
        }

        return null;
    }

    // Métodos auxiliares recomendados (opcionales) -------------
    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Identification", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }

}
