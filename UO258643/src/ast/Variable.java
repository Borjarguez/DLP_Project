/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;
import visitor.*;

//	variable:expression -> value:String

public class Variable extends AbstractExpression {

    private String name;
    private DefVariable definition;

    public Variable(String name) {
        this.name = name;
    }

    public Variable(Object name) {
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DefVariable getDefinition() {
        return definition;
    }

    public void setDefinition(DefVariable definition) {
        this.definition = definition;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{value:" + getName() + "}";
    }
}
