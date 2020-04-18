/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	fieldAccess:expression -> expression:expression  name:String

public class FieldAccess extends AbstractExpression {

	private Expression expression;
	private String name;
	private StructParam param;

	public FieldAccess(Expression expression, String name) {
		this.expression = expression;
		this.name = name;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression);
	}

	public FieldAccess(Object expression, Object name) {
		this.expression = (Expression) getAST(expression);
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(expression, name);
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StructParam getStructParam() {
		return param;
	}

	public void setStructParam(StructParam param) {
		this.param = param;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{expression:" + getExpression() + ", name:" + getName() + "}";
	}
}
