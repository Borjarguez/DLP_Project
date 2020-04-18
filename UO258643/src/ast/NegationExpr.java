/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	negationExpr:expression -> operator:String  expression:expression

public class NegationExpr extends AbstractExpression {

	public NegationExpr(String operator, Expression expression) {
		this.operator = operator;
		this.expression = expression;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public NegationExpr(Object operator, Object expression) {
		this.operator = (operator instanceof Token) ? ((Token)operator).getText() : (String) operator;
		this.expression = (Expression) getAST(expression);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operator, expression);
	}

	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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

	private String operator;
	private Expression expression;

	public String toString() {
       return "{operator:" + getOperator() + ", expression:" + getExpression() + "}";
   }
}
