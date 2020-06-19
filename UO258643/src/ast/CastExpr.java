/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	castExpr:expression -> type:type  expression:expression

public class CastExpr extends AbstractExpression {

    public CastExpr(Type type, Expression expression) {
        this.type = type;
        this.expression = expression;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(type, expression);
    }

    public CastExpr(Object type, Object expression) {
        this.type = (Type) getAST(type);
        this.expression = (Expression) getAST(expression);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(type, expression);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private Type type;
    private Expression expression;

    public String toString() {
        return "{type:" + getType() + ", expression:" + getExpression() + "}";
    }
}
