// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
import ast.*;import ast.DefVariable.VarScope;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		INT_CONSTANT=39, REAL_CONSTANT=40, CHAR_CONSTANT=41, IDENT=42, LINE_COMMENT=43, 
		MULTILINE_COMMENT=44, WHITESPACE=45;
	public static final int
		RULE_start = 0, RULE_definitions = 1, RULE_definition = 2, RULE_structParams = 3, 
		RULE_structParam = 4, RULE_defVariables = 5, RULE_defVariable = 6, RULE_defFunc = 7, 
		RULE_sentences = 8, RULE_sentence = 9, RULE_params = 10, RULE_args = 11, 
		RULE_expr = 12, RULE_type = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definitions", "definition", "structParams", "structParam", 
			"defVariables", "defVariable", "defFunc", "sentences", "sentence", "params", 
			"args", "expr", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "':'", "'var'", "'('", "')'", 
			"'='", "'if'", "'else'", "'while'", "'return'", "'read'", "'print'", 
			"'printsp'", "'println'", "','", "'['", "']'", "'.'", "'*'", "'/'", "'+'", 
			"'-'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'!'", "'&&'", "'||'", 
			"'cast'", "'int'", "'float'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((StartContext)_localctx).definitions = definitions();
			setState(29);
			match(EOF);
			((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).definitions.list);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public DefinitionContext definition;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << IDENT))) != 0)) {
				{
				{
				setState(32);
				((DefinitionsContext)_localctx).definition = definition();
				_localctx.list.add(((DefinitionsContext)_localctx).definition.ast); 
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public Definition ast;
		public DefVariableContext defVariable;
		public Token IDENT;
		public StructParamsContext structParams;
		public DefFuncContext defFunc;
		public DefVariableContext defVariable() {
			return getRuleContext(DefVariableContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public StructParamsContext structParams() {
			return getRuleContext(StructParamsContext.class,0);
		}
		public DefFuncContext defFunc() {
			return getRuleContext(DefFuncContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				((DefinitionContext)_localctx).defVariable = defVariable();
				((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).defVariable.ast;
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(T__0);
				setState(44);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(45);
				match(T__1);
				setState(46);
				((DefinitionContext)_localctx).structParams = structParams();
				setState(47);
				match(T__2);
				setState(48);
				match(T__3);
				((DefinitionContext)_localctx).ast =  new DefStruct(new VarType(((DefinitionContext)_localctx).IDENT), ((DefinitionContext)_localctx).structParams.list);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				((DefinitionContext)_localctx).defFunc = defFunc();
				((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).defFunc.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructParamsContext extends ParserRuleContext {
		public List<StructParam> list = new ArrayList<StructParam>();
		public StructParamContext structParam;
		public List<StructParamContext> structParam() {
			return getRuleContexts(StructParamContext.class);
		}
		public StructParamContext structParam(int i) {
			return getRuleContext(StructParamContext.class,i);
		}
		public StructParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structParams; }
	}

	public final StructParamsContext structParams() throws RecognitionException {
		StructParamsContext _localctx = new StructParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(56);
				((StructParamsContext)_localctx).structParam = structParam();
				_localctx.list.add(((StructParamsContext)_localctx).structParam.ast); 
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructParamContext extends ParserRuleContext {
		public StructParam ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StructParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structParam; }
	}

	public final StructParamContext structParam() throws RecognitionException {
		StructParamContext _localctx = new StructParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_structParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(64);
			((StructParamContext)_localctx).IDENT = match(IDENT);
			setState(65);
			match(T__4);
			setState(66);
			((StructParamContext)_localctx).type = type();
			setState(67);
			match(T__3);
			}
			((StructParamContext)_localctx).ast =  new StructParam(((StructParamContext)_localctx).IDENT, ((StructParamContext)_localctx).type.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefVariablesContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public Token IDENT;
		public TypeContext type;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public DefVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVariables; }
	}

	public final DefVariablesContext defVariables() throws RecognitionException {
		DefVariablesContext _localctx = new DefVariablesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(71);
				match(T__5);
				setState(72);
				((DefVariablesContext)_localctx).IDENT = match(IDENT);
				setState(73);
				match(T__4);
				setState(74);
				((DefVariablesContext)_localctx).type = type();
				setState(75);
				match(T__3);
				_localctx.list.add(new DefVariable(((DefVariablesContext)_localctx).IDENT, ((DefVariablesContext)_localctx).type.ast, VarScope.LOCAL));
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefVariableContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVariable; }
	}

	public final DefVariableContext defVariable() throws RecognitionException {
		DefVariableContext _localctx = new DefVariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__5);
			setState(84);
			((DefVariableContext)_localctx).IDENT = match(IDENT);
			setState(85);
			match(T__4);
			setState(86);
			((DefVariableContext)_localctx).type = type();
			setState(87);
			match(T__3);
			((DefVariableContext)_localctx).ast =  new DefVariable(((DefVariableContext)_localctx).IDENT, ((DefVariableContext)_localctx).type.ast, VarScope.GLOBAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefFuncContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public ParamsContext params;
		public TypeContext type;
		public DefVariablesContext defVariables;
		public SentencesContext sentences;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefVariablesContext defVariables() {
			return getRuleContext(DefVariablesContext.class,0);
		}
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public DefFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFunc; }
	}

	public final DefFuncContext defFunc() throws RecognitionException {
		DefFuncContext _localctx = new DefFuncContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defFunc);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((DefFuncContext)_localctx).IDENT = match(IDENT);
				setState(91);
				match(T__6);
				setState(92);
				((DefFuncContext)_localctx).params = params();
				setState(93);
				match(T__7);
				setState(94);
				match(T__4);
				setState(95);
				((DefFuncContext)_localctx).type = type();
				setState(96);
				match(T__1);
				setState(97);
				((DefFuncContext)_localctx).defVariables = defVariables();
				setState(98);
				((DefFuncContext)_localctx).sentences = sentences();
				setState(99);
				match(T__2);
				((DefFuncContext)_localctx).ast =  new DefFunc(((DefFuncContext)_localctx).IDENT, ((DefFuncContext)_localctx).params.list, ((DefFuncContext)_localctx).type.ast, ((DefFuncContext)_localctx).defVariables.list, ((DefFuncContext)_localctx).sentences.list);
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((DefFuncContext)_localctx).IDENT = match(IDENT);
				setState(103);
				match(T__6);
				setState(104);
				((DefFuncContext)_localctx).params = params();
				setState(105);
				match(T__7);
				setState(106);
				match(T__1);
				setState(107);
				((DefFuncContext)_localctx).defVariables = defVariables();
				setState(108);
				((DefFuncContext)_localctx).sentences = sentences();
				setState(109);
				match(T__2);
				((DefFuncContext)_localctx).ast =  new DefFunc(((DefFuncContext)_localctx).IDENT, ((DefFuncContext)_localctx).params.list, new VoidType(), ((DefFuncContext)_localctx).defVariables.list, ((DefFuncContext)_localctx).sentences.list);
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentencesContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public SentenceContext sentence;
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public SentencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentences; }
	}

	public final SentencesContext sentences() throws RecognitionException {
		SentencesContext _localctx = new SentencesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentences);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__31) | (1L << T__34) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(114);
				((SentencesContext)_localctx).sentence = sentence();
				 _localctx.list.add(((SentencesContext)_localctx).sentence.ast); 
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public Sentence ast;
		public SentencesContext sentences;
		public Token IDENT;
		public ArgsContext args;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<SentencesContext> sentences() {
			return getRuleContexts(SentencesContext.class);
		}
		public SentencesContext sentences(int i) {
			return getRuleContext(SentencesContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentence);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				expr(0);
				setState(123);
				match(T__8);
				setState(124);
				expr(0);
				setState(125);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Assignment(_localctx.expr(0), _localctx.expr(1));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__9);
				setState(129);
				match(T__6);
				setState(130);
				expr(0);
				setState(131);
				match(T__7);
				setState(132);
				match(T__1);
				setState(133);
				sentences();
				setState(134);
				match(T__2);
				((SentenceContext)_localctx).ast =  new IfElse(_localctx.expr(0), _localctx.sentences(0).list, null);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(T__9);
				setState(138);
				match(T__6);
				setState(139);
				expr(0);
				setState(140);
				match(T__7);
				setState(141);
				match(T__1);
				setState(142);
				sentences();
				setState(143);
				match(T__2);
				setState(144);
				match(T__10);
				setState(145);
				match(T__1);
				setState(146);
				sentences();
				setState(147);
				match(T__2);
				((SentenceContext)_localctx).ast =  new IfElse(_localctx.expr(0), _localctx.sentences(0).list, _localctx.sentences(1).list);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				match(T__11);
				setState(151);
				match(T__6);
				setState(152);
				expr(0);
				setState(153);
				match(T__7);
				setState(154);
				match(T__1);
				setState(155);
				((SentenceContext)_localctx).sentences = sentences();
				setState(156);
				match(T__2);
				((SentenceContext)_localctx).ast =  new While(_localctx.expr(0), ((SentenceContext)_localctx).sentences.list);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				match(T__12);
				setState(160);
				expr(0);
				setState(161);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Return(_localctx.expr(0));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
				match(T__12);
				setState(165);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Return(new VoidExpr());
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				match(T__13);
				setState(168);
				expr(0);
				setState(169);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Read(_localctx.expr(0));
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(172);
				match(T__14);
				setState(173);
				expr(0);
				setState(174);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Print(_localctx.expr(0));
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(177);
				match(T__14);
				setState(178);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Print(null);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(180);
				match(T__15);
				setState(181);
				expr(0);
				setState(182);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Printsp(_localctx.expr(0));
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(185);
				match(T__15);
				setState(186);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Printsp(null);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(188);
				match(T__16);
				setState(189);
				expr(0);
				setState(190);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Println(_localctx.expr(0));
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(193);
				match(T__16);
				setState(194);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Println(null);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(196);
				((SentenceContext)_localctx).IDENT = match(IDENT);
				setState(197);
				match(T__6);
				setState(198);
				((SentenceContext)_localctx).args = args();
				setState(199);
				match(T__7);
				setState(200);
				match(T__3);
				((SentenceContext)_localctx).ast =  new FuncSentence(((SentenceContext)_localctx).IDENT, ((SentenceContext)_localctx).args.list);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public Token IDENT;
		public TypeContext type;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(205);
				((ParamsContext)_localctx).IDENT = match(IDENT);
				setState(206);
				match(T__4);
				setState(207);
				((ParamsContext)_localctx).type = type();
				_localctx.list.add(new DefVariable(((ParamsContext)_localctx).IDENT, ((ParamsContext)_localctx).type.ast, VarScope.LOCAL));
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(209);
					match(T__17);
					setState(210);
					((ParamsContext)_localctx).IDENT = match(IDENT);
					setState(211);
					match(T__4);
					setState(212);
					((ParamsContext)_localctx).type = type();
					_localctx.list.add(new DefVariable(((ParamsContext)_localctx).IDENT, ((ParamsContext)_localctx).type.ast, VarScope.LOCAL));
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__31) | (1L << T__34) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(222);
				((ArgsContext)_localctx).expr = expr(0);
				 _localctx.list.add(((ArgsContext)_localctx).expr.ast); 
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(224);
					match(T__17);
					setState(225);
					((ArgsContext)_localctx).expr = expr(0);
					 _localctx.list.add(((ArgsContext)_localctx).expr.ast); 
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Expression ast;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token IDENT;
		public ExprContext expr;
		public Token op;
		public TypeContext type;
		public ArgsContext args;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(236);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExprContext)_localctx).ast =  new IntConstant(((ExprContext)_localctx).INT_CONSTANT);
				}
				break;
			case 2:
				{
				setState(238);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExprContext)_localctx).ast =  new RealConstant(((ExprContext)_localctx).REAL_CONSTANT);
				}
				break;
			case 3:
				{
				setState(240);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExprContext)_localctx).ast =  new CharConstant(((ExprContext)_localctx).CHAR_CONSTANT);
				}
				break;
			case 4:
				{
				setState(242);
				((ExprContext)_localctx).IDENT = match(IDENT);
				((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT);
				}
				break;
			case 5:
				{
				setState(244);
				match(T__6);
				setState(245);
				((ExprContext)_localctx).expr = expr(0);
				setState(246);
				match(T__7);
				((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast;
				}
				break;
			case 6:
				{
				setState(249);
				((ExprContext)_localctx).op = match(T__31);
				setState(250);
				((ExprContext)_localctx).expr = expr(5);
				((ExprContext)_localctx).ast =  new NegationExpr(((ExprContext)_localctx).op, _localctx.expr(0)); 
				}
				break;
			case 7:
				{
				setState(253);
				match(T__34);
				setState(254);
				match(T__27);
				setState(255);
				((ExprContext)_localctx).type = type();
				setState(256);
				match(T__25);
				setState(257);
				((ExprContext)_localctx).expr = expr(2);
				((ExprContext)_localctx).ast =  new CastExpr(((ExprContext)_localctx).type.ast, ((ExprContext)_localctx).expr.ast);
				}
				break;
			case 8:
				{
				setState(260);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(261);
				match(T__6);
				setState(262);
				((ExprContext)_localctx).args = args();
				setState(263);
				match(T__7);
				((ExprContext)_localctx).ast =  new FuncExpr(((ExprContext)_localctx).IDENT, ((ExprContext)_localctx).args.list);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(308);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(269);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						((ExprContext)_localctx).expr = expr(10);
						((ExprContext)_localctx).ast =  new ArithmeticExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(274);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(275);
						((ExprContext)_localctx).expr = expr(9);
						((ExprContext)_localctx).ast =  new ArithmeticExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(278);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(279);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(280);
						((ExprContext)_localctx).expr = expr(8);
						((ExprContext)_localctx).ast =  new ComparationExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(284);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(285);
						((ExprContext)_localctx).expr = expr(7);
						((ExprContext)_localctx).ast =  new LogicExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(289);
						((ExprContext)_localctx).op = match(T__32);
						setState(290);
						((ExprContext)_localctx).expr = expr(5);
						((ExprContext)_localctx).ast =  new LogicExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(293);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(294);
						((ExprContext)_localctx).op = match(T__33);
						setState(295);
						((ExprContext)_localctx).expr = expr(4);
						((ExprContext)_localctx).ast =  new LogicExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(299);
						match(T__18);
						setState(300);
						((ExprContext)_localctx).expr = expr(0);
						setState(301);
						match(T__19);
						((ExprContext)_localctx).ast =  new ArrayCall(_localctx.expr(0), _localctx.expr(1));
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(304);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(305);
						match(T__20);
						setState(306);
						((ExprContext)_localctx).IDENT = match(IDENT);
						((ExprContext)_localctx).ast =  new FieldAccess(_localctx.expr(0), ((ExprContext)_localctx).IDENT);
						}
						break;
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token IDENT;
		public Token INT_CONSTANT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type);
		try {
			setState(327);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(T__35);
				((TypeContext)_localctx).ast =  new IntType();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				match(T__36);
				((TypeContext)_localctx).ast =  new RealType();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				match(T__37);
				((TypeContext)_localctx).ast =  new CharType();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				((TypeContext)_localctx).IDENT = match(IDENT);
				((TypeContext)_localctx).ast =  new VarType(((TypeContext)_localctx).IDENT);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(321);
				match(T__18);
				setState(322);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(323);
				match(T__19);
				setState(324);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast =  new ArrayType(new IntConstant(((TypeContext)_localctx).INT_CONSTANT), ((TypeContext)_localctx).type.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u014c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7"+
		"\3&\n\3\f\3\16\3)\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\49\n\4\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7Q\n\7\f\7\16\7T\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ts\n\t\3\n\3\n\3\n\7\nx\n\n"+
		"\f\n\16\n{\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00ce\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00da\n\f"+
		"\f\f\16\f\u00dd\13\f\5\f\u00df\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e7\n"+
		"\r\f\r\16\r\u00ea\13\r\5\r\u00ec\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u010d\n\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0137\n\16"+
		"\f\16\16\16\u013a\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u014a\n\17\3\17\2\3\32\20\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\2\6\3\2\30\31\3\2\32\33\3\2\34\37\3\2 !\2\u0168"+
		"\2\36\3\2\2\2\4\'\3\2\2\2\68\3\2\2\2\b?\3\2\2\2\nB\3\2\2\2\fR\3\2\2\2"+
		"\16U\3\2\2\2\20r\3\2\2\2\22y\3\2\2\2\24\u00cd\3\2\2\2\26\u00de\3\2\2\2"+
		"\30\u00eb\3\2\2\2\32\u010c\3\2\2\2\34\u0149\3\2\2\2\36\37\5\4\3\2\37 "+
		"\7\2\2\3 !\b\2\1\2!\3\3\2\2\2\"#\5\6\4\2#$\b\3\1\2$&\3\2\2\2%\"\3\2\2"+
		"\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2)\'\3\2\2\2*+\5\16\b\2+,"+
		"\b\4\1\2,9\3\2\2\2-.\7\3\2\2./\7,\2\2/\60\7\4\2\2\60\61\5\b\5\2\61\62"+
		"\7\5\2\2\62\63\7\6\2\2\63\64\b\4\1\2\649\3\2\2\2\65\66\5\20\t\2\66\67"+
		"\b\4\1\2\679\3\2\2\28*\3\2\2\28-\3\2\2\28\65\3\2\2\29\7\3\2\2\2:;\5\n"+
		"\6\2;<\b\5\1\2<>\3\2\2\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\t\3"+
		"\2\2\2A?\3\2\2\2BC\7,\2\2CD\7\7\2\2DE\5\34\17\2EF\7\6\2\2FG\3\2\2\2GH"+
		"\b\6\1\2H\13\3\2\2\2IJ\7\b\2\2JK\7,\2\2KL\7\7\2\2LM\5\34\17\2MN\7\6\2"+
		"\2NO\b\7\1\2OQ\3\2\2\2PI\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\r\3\2"+
		"\2\2TR\3\2\2\2UV\7\b\2\2VW\7,\2\2WX\7\7\2\2XY\5\34\17\2YZ\7\6\2\2Z[\b"+
		"\b\1\2[\17\3\2\2\2\\]\7,\2\2]^\7\t\2\2^_\5\26\f\2_`\7\n\2\2`a\7\7\2\2"+
		"ab\5\34\17\2bc\7\4\2\2cd\5\f\7\2de\5\22\n\2ef\7\5\2\2fg\b\t\1\2gs\3\2"+
		"\2\2hi\7,\2\2ij\7\t\2\2jk\5\26\f\2kl\7\n\2\2lm\7\4\2\2mn\5\f\7\2no\5\22"+
		"\n\2op\7\5\2\2pq\b\t\1\2qs\3\2\2\2r\\\3\2\2\2rh\3\2\2\2s\21\3\2\2\2tu"+
		"\5\24\13\2uv\b\n\1\2vx\3\2\2\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2"+
		"z\23\3\2\2\2{y\3\2\2\2|}\5\32\16\2}~\7\13\2\2~\177\5\32\16\2\177\u0080"+
		"\7\6\2\2\u0080\u0081\b\13\1\2\u0081\u00ce\3\2\2\2\u0082\u0083\7\f\2\2"+
		"\u0083\u0084\7\t\2\2\u0084\u0085\5\32\16\2\u0085\u0086\7\n\2\2\u0086\u0087"+
		"\7\4\2\2\u0087\u0088\5\22\n\2\u0088\u0089\7\5\2\2\u0089\u008a\b\13\1\2"+
		"\u008a\u00ce\3\2\2\2\u008b\u008c\7\f\2\2\u008c\u008d\7\t\2\2\u008d\u008e"+
		"\5\32\16\2\u008e\u008f\7\n\2\2\u008f\u0090\7\4\2\2\u0090\u0091\5\22\n"+
		"\2\u0091\u0092\7\5\2\2\u0092\u0093\7\r\2\2\u0093\u0094\7\4\2\2\u0094\u0095"+
		"\5\22\n\2\u0095\u0096\7\5\2\2\u0096\u0097\b\13\1\2\u0097\u00ce\3\2\2\2"+
		"\u0098\u0099\7\16\2\2\u0099\u009a\7\t\2\2\u009a\u009b\5\32\16\2\u009b"+
		"\u009c\7\n\2\2\u009c\u009d\7\4\2\2\u009d\u009e\5\22\n\2\u009e\u009f\7"+
		"\5\2\2\u009f\u00a0\b\13\1\2\u00a0\u00ce\3\2\2\2\u00a1\u00a2\7\17\2\2\u00a2"+
		"\u00a3\5\32\16\2\u00a3\u00a4\7\6\2\2\u00a4\u00a5\b\13\1\2\u00a5\u00ce"+
		"\3\2\2\2\u00a6\u00a7\7\17\2\2\u00a7\u00a8\7\6\2\2\u00a8\u00ce\b\13\1\2"+
		"\u00a9\u00aa\7\20\2\2\u00aa\u00ab\5\32\16\2\u00ab\u00ac\7\6\2\2\u00ac"+
		"\u00ad\b\13\1\2\u00ad\u00ce\3\2\2\2\u00ae\u00af\7\21\2\2\u00af\u00b0\5"+
		"\32\16\2\u00b0\u00b1\7\6\2\2\u00b1\u00b2\b\13\1\2\u00b2\u00ce\3\2\2\2"+
		"\u00b3\u00b4\7\21\2\2\u00b4\u00b5\7\6\2\2\u00b5\u00ce\b\13\1\2\u00b6\u00b7"+
		"\7\22\2\2\u00b7\u00b8\5\32\16\2\u00b8\u00b9\7\6\2\2\u00b9\u00ba\b\13\1"+
		"\2\u00ba\u00ce\3\2\2\2\u00bb\u00bc\7\22\2\2\u00bc\u00bd\7\6\2\2\u00bd"+
		"\u00ce\b\13\1\2\u00be\u00bf\7\23\2\2\u00bf\u00c0\5\32\16\2\u00c0\u00c1"+
		"\7\6\2\2\u00c1\u00c2\b\13\1\2\u00c2\u00ce\3\2\2\2\u00c3\u00c4\7\23\2\2"+
		"\u00c4\u00c5\7\6\2\2\u00c5\u00ce\b\13\1\2\u00c6\u00c7\7,\2\2\u00c7\u00c8"+
		"\7\t\2\2\u00c8\u00c9\5\30\r\2\u00c9\u00ca\7\n\2\2\u00ca\u00cb\7\6\2\2"+
		"\u00cb\u00cc\b\13\1\2\u00cc\u00ce\3\2\2\2\u00cd|\3\2\2\2\u00cd\u0082\3"+
		"\2\2\2\u00cd\u008b\3\2\2\2\u00cd\u0098\3\2\2\2\u00cd\u00a1\3\2\2\2\u00cd"+
		"\u00a6\3\2\2\2\u00cd\u00a9\3\2\2\2\u00cd\u00ae\3\2\2\2\u00cd\u00b3\3\2"+
		"\2\2\u00cd\u00b6\3\2\2\2\u00cd\u00bb\3\2\2\2\u00cd\u00be\3\2\2\2\u00cd"+
		"\u00c3\3\2\2\2\u00cd\u00c6\3\2\2\2\u00ce\25\3\2\2\2\u00cf\u00d0\7,\2\2"+
		"\u00d0\u00d1\7\7\2\2\u00d1\u00d2\5\34\17\2\u00d2\u00db\b\f\1\2\u00d3\u00d4"+
		"\7\24\2\2\u00d4\u00d5\7,\2\2\u00d5\u00d6\7\7\2\2\u00d6\u00d7\5\34\17\2"+
		"\u00d7\u00d8\b\f\1\2\u00d8\u00da\3\2\2\2\u00d9\u00d3\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00cf\3\2\2\2\u00de\u00df\3\2\2\2\u00df\27\3\2\2"+
		"\2\u00e0\u00e1\5\32\16\2\u00e1\u00e8\b\r\1\2\u00e2\u00e3\7\24\2\2\u00e3"+
		"\u00e4\5\32\16\2\u00e4\u00e5\b\r\1\2\u00e5\u00e7\3\2\2\2\u00e6\u00e2\3"+
		"\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00e0\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\31\3\2\2\2\u00ed\u00ee\b\16\1\2\u00ee\u00ef\7)\2\2\u00ef\u010d"+
		"\b\16\1\2\u00f0\u00f1\7*\2\2\u00f1\u010d\b\16\1\2\u00f2\u00f3\7+\2\2\u00f3"+
		"\u010d\b\16\1\2\u00f4\u00f5\7,\2\2\u00f5\u010d\b\16\1\2\u00f6\u00f7\7"+
		"\t\2\2\u00f7\u00f8\5\32\16\2\u00f8\u00f9\7\n\2\2\u00f9\u00fa\b\16\1\2"+
		"\u00fa\u010d\3\2\2\2\u00fb\u00fc\7\"\2\2\u00fc\u00fd\5\32\16\7\u00fd\u00fe"+
		"\b\16\1\2\u00fe\u010d\3\2\2\2\u00ff\u0100\7%\2\2\u0100\u0101\7\36\2\2"+
		"\u0101\u0102\5\34\17\2\u0102\u0103\7\34\2\2\u0103\u0104\5\32\16\4\u0104"+
		"\u0105\b\16\1\2\u0105\u010d\3\2\2\2\u0106\u0107\7,\2\2\u0107\u0108\7\t"+
		"\2\2\u0108\u0109\5\30\r\2\u0109\u010a\7\n\2\2\u010a\u010b\b\16\1\2\u010b"+
		"\u010d\3\2\2\2\u010c\u00ed\3\2\2\2\u010c\u00f0\3\2\2\2\u010c\u00f2\3\2"+
		"\2\2\u010c\u00f4\3\2\2\2\u010c\u00f6\3\2\2\2\u010c\u00fb\3\2\2\2\u010c"+
		"\u00ff\3\2\2\2\u010c\u0106\3\2\2\2\u010d\u0138\3\2\2\2\u010e\u010f\f\13"+
		"\2\2\u010f\u0110\t\2\2\2\u0110\u0111\5\32\16\f\u0111\u0112\b\16\1\2\u0112"+
		"\u0137\3\2\2\2\u0113\u0114\f\n\2\2\u0114\u0115\t\3\2\2\u0115\u0116\5\32"+
		"\16\13\u0116\u0117\b\16\1\2\u0117\u0137\3\2\2\2\u0118\u0119\f\t\2\2\u0119"+
		"\u011a\t\4\2\2\u011a\u011b\5\32\16\n\u011b\u011c\b\16\1\2\u011c\u0137"+
		"\3\2\2\2\u011d\u011e\f\b\2\2\u011e\u011f\t\5\2\2\u011f\u0120\5\32\16\t"+
		"\u0120\u0121\b\16\1\2\u0121\u0137\3\2\2\2\u0122\u0123\f\6\2\2\u0123\u0124"+
		"\7#\2\2\u0124\u0125\5\32\16\7\u0125\u0126\b\16\1\2\u0126\u0137\3\2\2\2"+
		"\u0127\u0128\f\5\2\2\u0128\u0129\7$\2\2\u0129\u012a\5\32\16\6\u012a\u012b"+
		"\b\16\1\2\u012b\u0137\3\2\2\2\u012c\u012d\f\r\2\2\u012d\u012e\7\25\2\2"+
		"\u012e\u012f\5\32\16\2\u012f\u0130\7\26\2\2\u0130\u0131\b\16\1\2\u0131"+
		"\u0137\3\2\2\2\u0132\u0133\f\f\2\2\u0133\u0134\7\27\2\2\u0134\u0135\7"+
		",\2\2\u0135\u0137\b\16\1\2\u0136\u010e\3\2\2\2\u0136\u0113\3\2\2\2\u0136"+
		"\u0118\3\2\2\2\u0136\u011d\3\2\2\2\u0136\u0122\3\2\2\2\u0136\u0127\3\2"+
		"\2\2\u0136\u012c\3\2\2\2\u0136\u0132\3\2\2\2\u0137\u013a\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\33\3\2\2\2\u013a\u0138\3\2\2"+
		"\2\u013b\u013c\7&\2\2\u013c\u014a\b\17\1\2\u013d\u013e\7\'\2\2\u013e\u014a"+
		"\b\17\1\2\u013f\u0140\7(\2\2\u0140\u014a\b\17\1\2\u0141\u0142\7,\2\2\u0142"+
		"\u014a\b\17\1\2\u0143\u0144\7\25\2\2\u0144\u0145\7)\2\2\u0145\u0146\7"+
		"\26\2\2\u0146\u0147\5\34\17\2\u0147\u0148\b\17\1\2\u0148\u014a\3\2\2\2"+
		"\u0149\u013b\3\2\2\2\u0149\u013d\3\2\2\2\u0149\u013f\3\2\2\2\u0149\u0141"+
		"\3\2\2\2\u0149\u0143\3\2\2\2\u014a\35\3\2\2\2\21\'8?Rry\u00cd\u00db\u00de"+
		"\u00e8\u00eb\u010c\u0136\u0138\u0149";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}