/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	arrayCall:expression -> index:expression  expr:expression

public class ArrayCall extends AbstractExpression {

    private Expression expr;
    private Expression index;
    private Type tipoArray;

    public ArrayCall(Expression expr, Expression index) {
        this.index = index;
        this.expr = expr;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expr, index);
    }

    public ArrayCall(Object expr, Object index) {
        this.expr = (Expression) getAST(expr);
        this.index = (Expression) getAST(index);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expr, index);
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public Type getTipoArray() {
        return tipoArray;
    }

    public void setTipoArray(Type tipoArray) {
        this.tipoArray = tipoArray;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{expr:" + getExpr() + ", index:" + getIndex() + "}";
    }
}
