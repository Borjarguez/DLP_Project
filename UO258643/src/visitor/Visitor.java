/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package visitor;

import ast.*;

public interface Visitor {
    public Object visit(Program node, Object param);

    public Object visit(DefVariable node, Object param);

    public Object visit(DefStruct node, Object param);

    public Object visit(StructParam node, Object param);

    public Object visit(DefFunc node, Object param);

    public Object visit(IntType node, Object param);

    public Object visit(RealType node, Object param);

    public Object visit(CharType node, Object param);

    public Object visit(VarType node, Object param);

    public Object visit(ArrayType node, Object param);

    public Object visit(ErrorType node, Object param);

    public Object visit(VoidType node, Object param);

    public Object visit(Assignment node, Object param);

    public Object visit(IfElse node, Object param);

    public Object visit(While node, Object param);

    public Object visit(Return node, Object param);

    public Object visit(Read node, Object param);

    public Object visit(Print node, Object param);

    public Object visit(Println node, Object param);

    public Object visit(Printsp node, Object param);

    public Object visit(FuncSentence node, Object param);

    public Object visit(IntConstant node, Object param);

    public Object visit(RealConstant node, Object param);

    public Object visit(CharConstant node, Object param);

    public Object visit(Variable node, Object param);

    public Object visit(VoidConstant node, Object param);

    public Object visit(ArrayCall node, Object param);

    public Object visit(FieldAccess node, Object param);

    public Object visit(ArithmeticExpr node, Object param);

    public Object visit(ComparationExpr node, Object param);

    public Object visit(LogicExpr node, Object param);

    public Object visit(NegationExpr node, Object param);

    public Object visit(CastExpr node, Object param);

    public Object visit(FuncExpr node, Object param);

    public Object visit(VoidExpr node, Object param);
}
