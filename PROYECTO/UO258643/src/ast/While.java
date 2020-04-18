/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	while:sentence -> param:expression  sentence:sentence*

public class While extends AbstractSentence {

	public While(Expression param, List<Sentence> sentence) {
		this.param = param;
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(param, sentence);
	}

	public While(Object param, Object sentence) {
		this.param = (Expression) getAST(param);
		this.sentence = this.<Sentence>getAstFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(param, sentence);
	}

	public Expression getParam() {
		return param;
	}
	public void setParam(Expression param) {
		this.param = param;
	}

	public List<Sentence> getSentence() {
		return sentence;
	}
	public void setSentence(List<Sentence> sentence) {
		this.sentence = sentence;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression param;
	private List<Sentence> sentence;

	public String toString() {
       return "{param:" + getParam() + ", sentence:" + getSentence() + "}";
   }
}
