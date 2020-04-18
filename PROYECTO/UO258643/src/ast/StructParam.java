/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	structParam:definition -> name:String  type:type
public class StructParam extends AbstractDefinition {

    private String name;
    private Type type;
    private Definition definition;
    private int address;

    public StructParam(String name, Type type) {
        this.name = name;
        this.type = type;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(type);
    }

    public StructParam(Object name, Object type) {
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
        this.type = (Type) getAST(type);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{name:" + getName() + ", type:" + getType() + "}";
    }

    public void setAddress(int size) {
        this.address = size;
    }

    public int getAddress() {
        return this.address;
    }
}
