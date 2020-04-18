/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	defFunc:definition -> name:String  params:defVariable*  returnType:type  definitions:defVariable*  sentences:sentence*

public class DefFunc extends AbstractDefinition {

    private String name;
    private List<DefVariable> params;
    private Type returnType;
    private List<DefVariable> definitions;
    private List<Sentence> sentences;

    private boolean hasReturn = false;

    public DefFunc(String name, List<DefVariable> params, Type returnType, List<DefVariable> definitions,
            List<Sentence> sentences) {
        this.name = name;
        this.params = params;
        this.returnType = returnType;
        this.definitions = definitions;
        this.sentences = sentences;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(params, returnType, definitions, sentences);
    }

    public DefFunc(Object name, Object params, Object returnType, Object definitions, Object sentences) {
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
        this.params = this.<DefVariable>getAstFromContexts(params);
        this.returnType = (Type) getAST(returnType);
        this.definitions = this.<DefVariable>getAstFromContexts(definitions);
        this.sentences = this.<Sentence>getAstFromContexts(sentences);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name, params, returnType, definitions, sentences);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DefVariable> getParams() {
        return params;
    }

    public void setParams(List<DefVariable> params) {
        this.params = params;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public List<DefVariable> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DefVariable> definitions) {
        this.definitions = definitions;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public boolean hasReturn() {
        return hasReturn;
    }

    public void setHasReturn(boolean hasReturn) {
        this.hasReturn = hasReturn;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{name:" + getName() + ", args:" + getParams() + ", returnType:" + getReturnType() + ", definitions:"
                + getDefinitions() + ", sentences:" + getSentences() + "}";
    }
}
