/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	defStruct:definition -> name:String  param:structParam*

public class DefStruct extends AbstractDefinition {

    private VarType name;
    private List<StructParam> params;

    public DefStruct(VarType name, List<StructParam> params) {
        this.name = name;
        this.params = params;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(params);
    }

    public DefStruct(Object name, Object param) {
        this.name = (VarType) ((name instanceof Token) ? getAST(name) : name);
        this.params = this.<StructParam>getAstFromContexts(param);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name, param);
    }

    public VarType getName() {
        return name;
    }

    public void setName(VarType name) {
        this.name = name;
    }

    public List<StructParam> getParams() {
        return params;
    }

    public void setParams(List<StructParam> params) {
        this.params = params;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{name:" + getName() + ", param:" + getParams() + "}";
    }
}
