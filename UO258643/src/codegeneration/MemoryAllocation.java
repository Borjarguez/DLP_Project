/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import ast.DefVariable.VarScope;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    private int currentAddress = 0;

    // class Programa { List<DefVariable> definiciones; List<Sentencia> sentencias; }
    public Object visit(Program node, Object param) {
        super.visit(node, param);
        return null;
    }

    public Object visit(DefStruct node, Object param) {
        if (node.getName() != null)
            node.getName().accept(this, param);

        int size = 0;
        for (StructParam p : node.getParams()) {
            size += (int) p.accept(this, size);
        }
        return null;
    }

    public Object visit(StructParam node, Object param) {
        super.visit(node, param);

        int size = 0;
        if (param instanceof Integer)
            size = (int) param;

        node.setAddress(size);
        return node.getType().getMemorySize();
    }

    public Object visit(DefVariable node, Object param) {
        super.visit(node, param);

        if (node.getScope().equals(VarScope.GLOBAL)) {
            node.setAddress(currentAddress);
            currentAddress += node.getType().getMemorySize();
        }

        return null;
    }

    public Object visit(DefFunc node, Object param) {
        if (node.getReturnType() != null)
            node.getReturnType().accept(this, param);
        visitChildren(node.getSentences(), param);

        // visitamos los parametros y las definiciones
        int bp = 4;
        for (int i = node.getParams().size() - 1; i >= 0; i--) {
            DefVariable paramFunction = node.getParams().get(i);
            paramFunction.setAddress(bp);
            bp += paramFunction.getType().getMemorySize();
        }

        bp = 0;
        for (DefVariable definition : node.getDefinitions()) {
            bp -= definition.getType().getMemorySize();
            definition.setAddress(bp);
        }

        return null;
    }

}
