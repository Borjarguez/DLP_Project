grammar Grammar
	;

import Lexicon
	;

@parser::header {import ast.*;import ast.DefVariable.VarScope;}

start returns[Program ast]
	: definitions EOF {$ast = new Program($definitions.list);}
	;

definitions returns[List<Definition> list = new ArrayList<Definition>()]
	: (definition {$list.add($definition.ast); })*
	;

definition returns[Definition ast]
	: defVariable								{$ast = $defVariable.ast;}
	| 'struct' IDENT '{' structParams '}' ';'	{$ast = new DefStruct(new VarType($IDENT), $structParams.list);}
	| defFunc									{$ast = $defFunc.ast;}
	;

structParams returns[List<StructParam> list = new ArrayList<StructParam>()]
	: (structParam {$list.add($structParam.ast); })*
	;

structParam returns[StructParam ast]
	: (IDENT ':' type ';') {$ast = new StructParam($IDENT, $type.ast);}
	;

defVariables returns[List<Definition> list = new ArrayList<Definition>()]
	: ('var' IDENT ':' type ';' {$list.add(new DefVariable($IDENT, $type.ast, VarScope.LOCAL));})*
	;

defVariable returns[Definition ast]
	: 'var' IDENT ':' type ';' {$ast = new DefVariable($IDENT, $type.ast, VarScope.GLOBAL);}
	;

defFunc returns[Definition ast]
	: IDENT '(' params ')' ':' type '{' defVariables sentences '}' {$ast = new DefFunc($IDENT, $params.list, $type.ast, $defVariables.list, $sentences.list);
		}
	| IDENT '(' params ')' '{' defVariables sentences '}' {$ast = new DefFunc($IDENT, $params.list, new VoidType(), $defVariables.list, $sentences.list);
		}
	;

sentences returns[List<Sentence> list = new ArrayList<Sentence>()]
	: (sentence { $list.add($sentence.ast); })*
	;

sentence returns[Sentence ast]
	: expr '=' expr ';'												{$ast = new Assignment($ctx.expr(0), $ctx.expr(1));}
	| 'if' '(' expr ')' '{' sentences '}'							{$ast = new IfElse($ctx.expr(0), $ctx.sentences(0).list, null);}
	| 'if' '(' expr ')' '{' sentences '}' 'else' '{' sentences '}'	{$ast = new IfElse($ctx.expr(0), $ctx.sentences(0).list, $ctx.sentences(1).list);}
	| 'while' '(' expr ')' '{' sentences '}'						{$ast = new While($ctx.expr(0), $sentences.list);}
	| 'return' expr ';'												{$ast = new Return($ctx.expr(0));}
	| 'return' ';'													{$ast = new Return(new VoidExpr());}
	| 'read' expr ';'												{$ast = new Read($ctx.expr(0));}
	| 'print' expr ';'												{$ast = new Print($ctx.expr(0));}
	| 'printsp' expr ';'											{$ast = new Printsp($ctx.expr(0));}
	| 'println' expr ';'											{$ast = new Println($ctx.expr(0));}
	| 'println' ';'													{$ast = new Println(new VoidExpr());}
	| IDENT '(' args ')' ';'										{$ast = new FuncSentence($IDENT, $args.list);}
	;

params returns[List<Definition> list = new ArrayList<Definition>()]
	: (
		IDENT ':' type			{$list.add(new DefVariable($IDENT, $type.ast, VarScope.PARAM));} (
			',' IDENT ':' type	{$list.add(new DefVariable($IDENT, $type.ast, VarScope.PARAM));}
		)*
	)?
	;

args returns[List<Expression> list = new ArrayList<Expression>()]
	: (expr { $list.add($expr.ast); } (',' expr { $list.add($expr.ast); })*)?
	;

expr returns[Expression ast]
	: INT_CONSTANT								{$ast = new IntConstant($INT_CONSTANT);}
	| REAL_CONSTANT								{$ast = new RealConstant($REAL_CONSTANT);}
	| CHAR_CONSTANT								{$ast = new CharConstant($CHAR_CONSTANT);}
	| IDENT										{$ast = new Variable($IDENT);}
	| '(' expr ')'								{$ast = $expr.ast;}
	| expr '[' expr ']'							{$ast = new ArrayCall($ctx.expr(0), $ctx.expr(1));}
	| expr '.' IDENT							{$ast = new FieldAccess($ctx.expr(0), $IDENT);}
	| expr op=('*' | '/') expr					{$ast = new ArithmeticExpr($ctx.expr(0), $op, $ctx.expr(1));}
	| expr op=('+' | '-') expr					{$ast = new ArithmeticExpr($ctx.expr(0), $op, $ctx.expr(1));}
	| expr op=('>' | '>=' | '<' | '<=') expr	{$ast = new ComparationExpr($ctx.expr(0), $op, $ctx.expr(1));}
	| expr op=('==' | '!=') expr				{$ast = new LogicExpr($ctx.expr(0), $op, $ctx.expr(1));}
	| op='!' expr								{$ast = new NegationExpr($op, $ctx.expr(0)); }
	| expr op='&&' expr							{$ast = new LogicExpr($ctx.expr(0), $op, $ctx.expr(1));}
	| expr op='||' expr							{$ast = new LogicExpr($ctx.expr(0), $op, $ctx.expr(1));}
	| 'cast' '<' type '>' expr					{$ast = new CastExpr($type.ast, $expr.ast);}
	| IDENT '(' args ')'						{$ast = new FuncExpr($IDENT, $args.list);}
	;

type returns[Type ast]
	: 'int'						{$ast = new IntType();}
	| 'float'					{$ast = new RealType();}
	| 'char'					{$ast = new CharType();}
	| IDENT						{$ast = new VarType($IDENT);}
	| '[' INT_CONSTANT ']' type	{$ast = new ArrayType(new IntConstant($INT_CONSTANT), $type.ast);}
	;
