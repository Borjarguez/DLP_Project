/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

public abstract class AbstractSentence extends AbstractAST implements Sentence {
    private DefFunc defFunc;

    public DefFunc getDefFunc() {
        return defFunc;
    }

    public void setFunDefinition(DefFunc defFunc) {
        this.defFunc = defFunc;
    }
}
