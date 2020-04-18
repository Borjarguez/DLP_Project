/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	ifElse:sentence -> expression:expression  if_sent:sentence*  else_sent:sentence*

public class IfElse extends AbstractSentence {

	public IfElse(Expression expression, List<Sentence> if_sent, List<Sentence> else_sent) {
		this.expression = expression;
		this.if_sent = if_sent;
		this.else_sent = else_sent;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, if_sent, else_sent);
	}

	public IfElse(Object expression, Object if_sent, Object else_sent) {
		this.expression = (Expression) getAST(expression);
		this.if_sent = this.<Sentence>getAstFromContexts(if_sent);
		this.else_sent = this.<Sentence>getAstFromContexts(else_sent);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, if_sent, else_sent);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public List<Sentence> getIf_sent() {
		return if_sent;
	}
	public void setIf_sent(List<Sentence> if_sent) {
		this.if_sent = if_sent;
	}

	public List<Sentence> getElse_sent() {
		return else_sent;
	}
	public void setElse_sent(List<Sentence> else_sent) {
		this.else_sent = else_sent;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;
	private List<Sentence> if_sent;
	private List<Sentence> else_sent;

	public String toString() {
       return "{expression:" + getExpression() + ", if_sent:" + getIf_sent() + ", else_sent:" + getElse_sent() + "}";
   }
}
