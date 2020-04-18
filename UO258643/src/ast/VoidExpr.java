/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	voidExpr:expression -> 

public class VoidExpr extends AbstractExpression {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{VoidExpr}";
   }
}
