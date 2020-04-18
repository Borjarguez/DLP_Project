/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.List;

import org.antlr.v4.runtime.*;

import visitor.*;

//	varType:type -> name:String
public class VarType extends AbstractType {

    private String name;
    private DefStruct definition;

    public VarType(String name) {
        this.name = name;
    }

    public VarType(Object name) {
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public DefStruct getDefinition() {
        return definition;
    }

    public void setDefinition(DefStruct definition) {
        this.definition = definition;
    }

    public StructParam findParam(String name) {
        List<StructParam> params = definition.getParams();
        for (int i = 0; i < params.size(); i++) {
            if (params.get(i).getName().equals(name)) {
                return params.get(i);
            }
        }
        return null;
    }

    public String toString() {
        return "{name:" + getName() + "}";
    }

    @Override
    public int getMemorySize() {
        int size = 0;

        for (StructParam param : definition.getParams())
            size += param.getType().getMemorySize();

        return size;
    }

    @Override
    public String getMAPLName(){
        return name;
    }
}
