// Generated from c:\Users\borja\Documents\BORJA\REPOS\DLP\PROYECTO\UO258643\src\parser\Grammar.g4 by ANTLR 4.7.1
import ast.*;
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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

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
		RULE_structParam = 4, RULE_defVariable = 5, RULE_defFunc = 6, RULE_sentences = 7, 
		RULE_sentence = 8, RULE_params = 9, RULE_expr = 10, RULE_type = 11;
	public static final String[] ruleNames = {
		"start", "definitions", "definition", "structParams", "structParam", "defVariable", 
		"defFunc", "sentences", "sentence", "params", "expr", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'struct'", "'{'", "'}'", "';'", "':'", "'var'", "'('", "')'", "'='", 
		"'if'", "'else'", "'while'", "'return'", "'read'", "'print'", "'printsp'", 
		"'println'", "','", "'['", "']'", "'.'", "'*'", "'/'", "'+'", "'-'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'!='", "'!'", "'&&'", "'||'", "'cast'", 
		"'int'", "'float'", "'char'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
		"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
	};
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
			setState(24);
			((StartContext)_localctx).definitions = definitions();
			setState(25);
			match(EOF);
			_localctx.ast = new Program(((StartContext)_localctx).definitions.list)
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << IDENT))) != 0)) {
				{
				{
				setState(28);
				((DefinitionsContext)_localctx).definition = definition();
				_localctx.list.add(((DefinitionsContext)_localctx).definition.ast); 
				}
				}
				setState(35);
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
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				((DefinitionContext)_localctx).defVariable = defVariable();
				((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).defVariable.ast;
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(T__0);
				setState(40);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(41);
				match(T__1);
				setState(42);
				((DefinitionContext)_localctx).structParams = structParams();
				setState(43);
				match(T__2);
				setState(44);
				match(T__3);
				((DefinitionContext)_localctx).ast =  new DefStruct(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).structParams.list);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(52);
				((StructParamsContext)_localctx).structParam = structParam();
				_localctx.list.add(((StructParamsContext)_localctx).structParam.ast); 
				}
				}
				setState(59);
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
			setState(60);
			((StructParamContext)_localctx).IDENT = match(IDENT);
			setState(61);
			match(T__4);
			setState(62);
			((StructParamContext)_localctx).type = type();
			setState(63);
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
		enterRule(_localctx, 10, RULE_defVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__5);
			setState(68);
			((DefVariableContext)_localctx).IDENT = match(IDENT);
			setState(69);
			match(T__4);
			setState(70);
			((DefVariableContext)_localctx).type = type();
			setState(71);
			match(T__3);
			((DefVariableContext)_localctx).ast =  new DefVariable(((DefVariableContext)_localctx).IDENT, ((DefVariableContext)_localctx).type.ast);
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
		public DefVariableContext defVariable;
		public SentencesContext sentences;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefVariableContext defVariable() {
			return getRuleContext(DefVariableContext.class,0);
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
		enterRule(_localctx, 12, RULE_defFunc);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				((DefFuncContext)_localctx).IDENT = match(IDENT);
				setState(75);
				match(T__6);
				setState(76);
				((DefFuncContext)_localctx).params = params();
				setState(77);
				match(T__7);
				setState(78);
				match(T__4);
				setState(79);
				((DefFuncContext)_localctx).type = type();
				setState(80);
				match(T__1);
				setState(81);
				((DefFuncContext)_localctx).defVariable = defVariable();
				setState(82);
				((DefFuncContext)_localctx).sentences = sentences();
				setState(83);
				match(T__2);
				((DefFuncContext)_localctx).ast =  new DefFunc(((DefFuncContext)_localctx).IDENT, ((DefFuncContext)_localctx).params.list, ((DefFuncContext)_localctx).type.ast, ((DefFuncContext)_localctx).defVariable.ast, ((DefFuncContext)_localctx).sentences.list);
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((DefFuncContext)_localctx).IDENT = match(IDENT);
				setState(87);
				match(T__6);
				setState(88);
				((DefFuncContext)_localctx).params = params();
				setState(89);
				match(T__7);
				setState(90);
				match(T__1);
				setState(91);
				((DefFuncContext)_localctx).defVariable = defVariable();
				setState(92);
				((DefFuncContext)_localctx).sentences = sentences();
				setState(93);
				match(T__2);
				((DefFuncContext)_localctx).ast =  new DefFunc(((DefFuncContext)_localctx).IDENT, ((DefFuncContext)_localctx).params.list, new VoidType(), ((DefFuncContext)_localctx).defVariable.ast, ((DefFuncContext)_localctx).sentences.list);
						
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
		enterRule(_localctx, 14, RULE_sentences);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__31) | (1L << T__34) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(98);
				((SentencesContext)_localctx).sentence = sentence();
				 _localctx.list.add(((SentencesContext)_localctx).sentence.ast); 
				}
				}
				setState(105);
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
		public Token op;
		public SentencesContext sentences;
		public ExprContext expr;
		public Token IDENT;
		public ParamsContext params;
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
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentence);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				expr(0);
				setState(107);
				((SentenceContext)_localctx).op = match(T__8);
				setState(108);
				expr(0);
				setState(109);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Assignment(_localctx.expr(0), ((SentenceContext)_localctx).op,_localctx.expr(1));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(T__9);
				setState(113);
				match(T__6);
				setState(114);
				expr(0);
				setState(115);
				match(T__7);
				setState(116);
				match(T__1);
				setState(117);
				sentences();
				setState(118);
				match(T__2);
				setState(119);
				match(T__10);
				setState(120);
				match(T__1);
				setState(121);
				sentences();
				setState(122);
				match(T__2);
				((SentenceContext)_localctx).ast =  new IfElse(&expr.ast, _localctx.sentences(0).list, _localctx.sentences(1).list);
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(T__9);
				setState(126);
				match(T__6);
				setState(127);
				expr(0);
				setState(128);
				match(T__7);
				setState(129);
				match(T__1);
				setState(130);
				((SentenceContext)_localctx).sentences = sentences();
				setState(131);
				match(T__2);
				((SentenceContext)_localctx).ast =  new IfElse(&expr.ast, ((SentenceContext)_localctx).sentences.list);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(T__11);
				setState(135);
				match(T__6);
				setState(136);
				expr(0);
				setState(137);
				match(T__7);
				setState(138);
				match(T__1);
				setState(139);
				((SentenceContext)_localctx).sentences = sentences();
				setState(140);
				match(T__2);
				((SentenceContext)_localctx).ast =  new While(&expr.ast, ((SentenceContext)_localctx).sentences.list);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				match(T__12);
				setState(144);
				((SentenceContext)_localctx).expr = expr(0);
				setState(145);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Return(((SentenceContext)_localctx).expr.ast);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				match(T__12);
				setState(149);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Return(null);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
				match(T__13);
				setState(152);
				((SentenceContext)_localctx).expr = expr(0);
				setState(153);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Read(((SentenceContext)_localctx).expr.ast);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(156);
				match(T__14);
				setState(157);
				((SentenceContext)_localctx).expr = expr(0);
				setState(158);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Print(((SentenceContext)_localctx).expr.ast);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(161);
				match(T__14);
				setState(162);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Print(null);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(164);
				match(T__15);
				setState(165);
				((SentenceContext)_localctx).expr = expr(0);
				setState(166);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Printsp(((SentenceContext)_localctx).expr.ast);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(169);
				match(T__15);
				setState(170);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Printsp(null);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(172);
				match(T__16);
				setState(173);
				((SentenceContext)_localctx).expr = expr(0);
				setState(174);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Println(((SentenceContext)_localctx).expr.ast);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(177);
				match(T__16);
				setState(178);
				match(T__3);
				((SentenceContext)_localctx).ast =  new Println(null);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(180);
				((SentenceContext)_localctx).IDENT = match(IDENT);
				setState(181);
				match(T__6);
				setState(182);
				((SentenceContext)_localctx).params = params();
				setState(183);
				match(T__7);
				setState(184);
				match(T__3);
				((SentenceContext)_localctx).ast =  new FuncSentence(((SentenceContext)_localctx).IDENT, ((SentenceContext)_localctx).params.list);
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
		enterRule(_localctx, 18, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(189);
				((ParamsContext)_localctx).IDENT = match(IDENT);
				setState(190);
				match(T__4);
				setState(191);
				((ParamsContext)_localctx).type = type();
				_localctx.list.add(new DefVariable(((ParamsContext)_localctx).IDENT, ((ParamsContext)_localctx).type.ast));
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(193);
					match(T__17);
					setState(194);
					((ParamsContext)_localctx).IDENT = match(IDENT);
					setState(195);
					match(T__4);
					setState(196);
					((ParamsContext)_localctx).type = type();
					_localctx.list.add(new DefVariable(((ParamsContext)_localctx).IDENT, ((ParamsContext)_localctx).type.ast));
					}
					}
					setState(203);
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
		public Expresion ast;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token IDENT;
		public ExprContext expr;
		public Token op;
		public TypeContext type;
		public ParamsContext params;
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
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(207);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExprContext)_localctx).ast =  new IntConstant(((ExprContext)_localctx).INT_CONSTANT);
				}
				break;
			case 2:
				{
				setState(209);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExprContext)_localctx).ast =  new RealConstant(((ExprContext)_localctx).REAL_CONSTANT);
				}
				break;
			case 3:
				{
				setState(211);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExprContext)_localctx).ast =  new CharConstant(((ExprContext)_localctx).CHAR_CONSTANT);
				}
				break;
			case 4:
				{
				setState(213);
				((ExprContext)_localctx).IDENT = match(IDENT);
				((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT);
				}
				break;
			case 5:
				{
				setState(215);
				match(T__6);
				setState(216);
				((ExprContext)_localctx).expr = expr(0);
				setState(217);
				match(T__7);
				((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast;
				}
				break;
			case 6:
				{
				setState(220);
				((ExprContext)_localctx).op = match(T__31);
				setState(221);
				((ExprContext)_localctx).expr = expr(5);
				((ExprContext)_localctx).ast =  new NegationExpr(((ExprContext)_localctx).op, _localctx.expr(0)); 
				}
				break;
			case 7:
				{
				setState(224);
				match(T__34);
				setState(225);
				match(T__27);
				setState(226);
				((ExprContext)_localctx).type = type();
				setState(227);
				match(T__25);
				setState(228);
				((ExprContext)_localctx).expr = expr(2);
				((ExprContext)_localctx).ast =  new CastExpr(((ExprContext)_localctx).type.ast, ((ExprContext)_localctx).expr.ast);
				}
				break;
			case 8:
				{
				setState(231);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(232);
				match(T__6);
				setState(233);
				((ExprContext)_localctx).params = params();
				setState(234);
				match(T__7);
				((ExprContext)_localctx).ast =  new FuncExpr(((ExprContext)_localctx).IDENT, ((ExprContext)_localctx).params.list);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(279);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(240);
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
						setState(241);
						((ExprContext)_localctx).expr = expr(10);
						((ExprContext)_localctx).ast =  new ArithmeticExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(245);
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
						setState(246);
						((ExprContext)_localctx).expr = expr(9);
						((ExprContext)_localctx).ast =  new ArithmeticExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(250);
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
						setState(251);
						((ExprContext)_localctx).expr = expr(8);
						((ExprContext)_localctx).ast =  new ComparationExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						          		
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(255);
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
						setState(256);
						((ExprContext)_localctx).expr = expr(7);
						((ExprContext)_localctx).ast =  new LogicExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(260);
						((ExprContext)_localctx).op = match(T__32);
						setState(261);
						((ExprContext)_localctx).expr = expr(5);
						((ExprContext)_localctx).ast =  new LogicExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(265);
						((ExprContext)_localctx).op = match(T__33);
						setState(266);
						((ExprContext)_localctx).expr = expr(4);
						((ExprContext)_localctx).ast =  new LogicExpr(_localctx.expr(0), ((ExprContext)_localctx).op, _localctx.expr(1));
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(270);
						match(T__18);
						setState(271);
						((ExprContext)_localctx).expr = expr(0);
						setState(272);
						match(T__19);
						((ExprContext)_localctx).ast =  new ArrayCall(_localctx.expr(0), _localctx.expr(1));
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(275);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(276);
						match(T__20);
						setState(277);
						((ExprContext)_localctx).IDENT = match(IDENT);
						((ExprContext)_localctx).ast =  new FieldAccess(_localctx.expr(0), ((ExprContext)_localctx).IDENT);
						}
						break;
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(T__35);
				((TypeContext)_localctx).ast =  new IntType();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				match(T__36);
				((TypeContext)_localctx).ast =  new RealType();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				match(T__37);
				((TypeContext)_localctx).ast =  new CharType();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(290);
				match(IDENT);
				((TypeContext)_localctx).ast =  new VarType();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(292);
				match(T__18);
				setState(293);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(294);
				match(T__19);
				setState(295);
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
		case 10:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u012f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\65\n\4"+
		"\3\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bc\n\b\3\t\3\t\3\t\7\th\n\t"+
		"\f\t\16\tk\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00be"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ca\n\13"+
		"\f\13\16\13\u00cd\13\13\5\13\u00cf\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f0\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u011a\n"+
		"\f\f\f\16\f\u011d\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u012d\n\r\3\r\2\3\26\16\2\4\6\b\n\f\16\20\22\24\26\30\2\6"+
		"\3\2\30\31\3\2\32\33\3\2\34\37\3\2 !\2\u014a\2\32\3\2\2\2\4#\3\2\2\2\6"+
		"\64\3\2\2\2\b;\3\2\2\2\n>\3\2\2\2\fE\3\2\2\2\16b\3\2\2\2\20i\3\2\2\2\22"+
		"\u00bd\3\2\2\2\24\u00ce\3\2\2\2\26\u00ef\3\2\2\2\30\u012c\3\2\2\2\32\33"+
		"\5\4\3\2\33\34\7\2\2\3\34\35\b\2\1\2\35\3\3\2\2\2\36\37\5\6\4\2\37 \b"+
		"\3\1\2 \"\3\2\2\2!\36\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2"+
		"\2%#\3\2\2\2&\'\5\f\7\2\'(\b\4\1\2(\65\3\2\2\2)*\7\3\2\2*+\7,\2\2+,\7"+
		"\4\2\2,-\5\b\5\2-.\7\5\2\2./\7\6\2\2/\60\b\4\1\2\60\65\3\2\2\2\61\62\5"+
		"\16\b\2\62\63\b\4\1\2\63\65\3\2\2\2\64&\3\2\2\2\64)\3\2\2\2\64\61\3\2"+
		"\2\2\65\7\3\2\2\2\66\67\5\n\6\2\678\b\5\1\28:\3\2\2\29\66\3\2\2\2:=\3"+
		"\2\2\2;9\3\2\2\2;<\3\2\2\2<\t\3\2\2\2=;\3\2\2\2>?\7,\2\2?@\7\7\2\2@A\5"+
		"\30\r\2AB\7\6\2\2BC\3\2\2\2CD\b\6\1\2D\13\3\2\2\2EF\7\b\2\2FG\7,\2\2G"+
		"H\7\7\2\2HI\5\30\r\2IJ\7\6\2\2JK\b\7\1\2K\r\3\2\2\2LM\7,\2\2MN\7\t\2\2"+
		"NO\5\24\13\2OP\7\n\2\2PQ\7\7\2\2QR\5\30\r\2RS\7\4\2\2ST\5\f\7\2TU\5\20"+
		"\t\2UV\7\5\2\2VW\b\b\1\2Wc\3\2\2\2XY\7,\2\2YZ\7\t\2\2Z[\5\24\13\2[\\\7"+
		"\n\2\2\\]\7\4\2\2]^\5\f\7\2^_\5\20\t\2_`\7\5\2\2`a\b\b\1\2ac\3\2\2\2b"+
		"L\3\2\2\2bX\3\2\2\2c\17\3\2\2\2de\5\22\n\2ef\b\t\1\2fh\3\2\2\2gd\3\2\2"+
		"\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\21\3\2\2\2ki\3\2\2\2lm\5\26\f\2mn\7"+
		"\13\2\2no\5\26\f\2op\7\6\2\2pq\b\n\1\2q\u00be\3\2\2\2rs\7\f\2\2st\7\t"+
		"\2\2tu\5\26\f\2uv\7\n\2\2vw\7\4\2\2wx\5\20\t\2xy\7\5\2\2yz\7\r\2\2z{\7"+
		"\4\2\2{|\5\20\t\2|}\7\5\2\2}~\b\n\1\2~\u00be\3\2\2\2\177\u0080\7\f\2\2"+
		"\u0080\u0081\7\t\2\2\u0081\u0082\5\26\f\2\u0082\u0083\7\n\2\2\u0083\u0084"+
		"\7\4\2\2\u0084\u0085\5\20\t\2\u0085\u0086\7\5\2\2\u0086\u0087\b\n\1\2"+
		"\u0087\u00be\3\2\2\2\u0088\u0089\7\16\2\2\u0089\u008a\7\t\2\2\u008a\u008b"+
		"\5\26\f\2\u008b\u008c\7\n\2\2\u008c\u008d\7\4\2\2\u008d\u008e\5\20\t\2"+
		"\u008e\u008f\7\5\2\2\u008f\u0090\b\n\1\2\u0090\u00be\3\2\2\2\u0091\u0092"+
		"\7\17\2\2\u0092\u0093\5\26\f\2\u0093\u0094\7\6\2\2\u0094\u0095\b\n\1\2"+
		"\u0095\u00be\3\2\2\2\u0096\u0097\7\17\2\2\u0097\u0098\7\6\2\2\u0098\u00be"+
		"\b\n\1\2\u0099\u009a\7\20\2\2\u009a\u009b\5\26\f\2\u009b\u009c\7\6\2\2"+
		"\u009c\u009d\b\n\1\2\u009d\u00be\3\2\2\2\u009e\u009f\7\21\2\2\u009f\u00a0"+
		"\5\26\f\2\u00a0\u00a1\7\6\2\2\u00a1\u00a2\b\n\1\2\u00a2\u00be\3\2\2\2"+
		"\u00a3\u00a4\7\21\2\2\u00a4\u00a5\7\6\2\2\u00a5\u00be\b\n\1\2\u00a6\u00a7"+
		"\7\22\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\7\6\2\2\u00a9\u00aa\b\n\1\2"+
		"\u00aa\u00be\3\2\2\2\u00ab\u00ac\7\22\2\2\u00ac\u00ad\7\6\2\2\u00ad\u00be"+
		"\b\n\1\2\u00ae\u00af\7\23\2\2\u00af\u00b0\5\26\f\2\u00b0\u00b1\7\6\2\2"+
		"\u00b1\u00b2\b\n\1\2\u00b2\u00be\3\2\2\2\u00b3\u00b4\7\23\2\2\u00b4\u00b5"+
		"\7\6\2\2\u00b5\u00be\b\n\1\2\u00b6\u00b7\7,\2\2\u00b7\u00b8\7\t\2\2\u00b8"+
		"\u00b9\5\24\13\2\u00b9\u00ba\7\n\2\2\u00ba\u00bb\7\6\2\2\u00bb\u00bc\b"+
		"\n\1\2\u00bc\u00be\3\2\2\2\u00bdl\3\2\2\2\u00bdr\3\2\2\2\u00bd\177\3\2"+
		"\2\2\u00bd\u0088\3\2\2\2\u00bd\u0091\3\2\2\2\u00bd\u0096\3\2\2\2\u00bd"+
		"\u0099\3\2\2\2\u00bd\u009e\3\2\2\2\u00bd\u00a3\3\2\2\2\u00bd\u00a6\3\2"+
		"\2\2\u00bd\u00ab\3\2\2\2\u00bd\u00ae\3\2\2\2\u00bd\u00b3\3\2\2\2\u00bd"+
		"\u00b6\3\2\2\2\u00be\23\3\2\2\2\u00bf\u00c0\7,\2\2\u00c0\u00c1\7\7\2\2"+
		"\u00c1\u00c2\5\30\r\2\u00c2\u00cb\b\13\1\2\u00c3\u00c4\7\24\2\2\u00c4"+
		"\u00c5\7,\2\2\u00c5\u00c6\7\7\2\2\u00c6\u00c7\5\30\r\2\u00c7\u00c8\b\13"+
		"\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00c3\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00ce\u00bf\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\25\3\2\2\2\u00d0\u00d1"+
		"\b\f\1\2\u00d1\u00d2\7)\2\2\u00d2\u00f0\b\f\1\2\u00d3\u00d4\7*\2\2\u00d4"+
		"\u00f0\b\f\1\2\u00d5\u00d6\7+\2\2\u00d6\u00f0\b\f\1\2\u00d7\u00d8\7,\2"+
		"\2\u00d8\u00f0\b\f\1\2\u00d9\u00da\7\t\2\2\u00da\u00db\5\26\f\2\u00db"+
		"\u00dc\7\n\2\2\u00dc\u00dd\b\f\1\2\u00dd\u00f0\3\2\2\2\u00de\u00df\7\""+
		"\2\2\u00df\u00e0\5\26\f\7\u00e0\u00e1\b\f\1\2\u00e1\u00f0\3\2\2\2\u00e2"+
		"\u00e3\7%\2\2\u00e3\u00e4\7\36\2\2\u00e4\u00e5\5\30\r\2\u00e5\u00e6\7"+
		"\34\2\2\u00e6\u00e7\5\26\f\4\u00e7\u00e8\b\f\1\2\u00e8\u00f0\3\2\2\2\u00e9"+
		"\u00ea\7,\2\2\u00ea\u00eb\7\t\2\2\u00eb\u00ec\5\24\13\2\u00ec\u00ed\7"+
		"\n\2\2\u00ed\u00ee\b\f\1\2\u00ee\u00f0\3\2\2\2\u00ef\u00d0\3\2\2\2\u00ef"+
		"\u00d3\3\2\2\2\u00ef\u00d5\3\2\2\2\u00ef\u00d7\3\2\2\2\u00ef\u00d9\3\2"+
		"\2\2\u00ef\u00de\3\2\2\2\u00ef\u00e2\3\2\2\2\u00ef\u00e9\3\2\2\2\u00f0"+
		"\u011b\3\2\2\2\u00f1\u00f2\f\13\2\2\u00f2\u00f3\t\2\2\2\u00f3\u00f4\5"+
		"\26\f\f\u00f4\u00f5\b\f\1\2\u00f5\u011a\3\2\2\2\u00f6\u00f7\f\n\2\2\u00f7"+
		"\u00f8\t\3\2\2\u00f8\u00f9\5\26\f\13\u00f9\u00fa\b\f\1\2\u00fa\u011a\3"+
		"\2\2\2\u00fb\u00fc\f\t\2\2\u00fc\u00fd\t\4\2\2\u00fd\u00fe\5\26\f\n\u00fe"+
		"\u00ff\b\f\1\2\u00ff\u011a\3\2\2\2\u0100\u0101\f\b\2\2\u0101\u0102\t\5"+
		"\2\2\u0102\u0103\5\26\f\t\u0103\u0104\b\f\1\2\u0104\u011a\3\2\2\2\u0105"+
		"\u0106\f\6\2\2\u0106\u0107\7#\2\2\u0107\u0108\5\26\f\7\u0108\u0109\b\f"+
		"\1\2\u0109\u011a\3\2\2\2\u010a\u010b\f\5\2\2\u010b\u010c\7$\2\2\u010c"+
		"\u010d\5\26\f\6\u010d\u010e\b\f\1\2\u010e\u011a\3\2\2\2\u010f\u0110\f"+
		"\r\2\2\u0110\u0111\7\25\2\2\u0111\u0112\5\26\f\2\u0112\u0113\7\26\2\2"+
		"\u0113\u0114\b\f\1\2\u0114\u011a\3\2\2\2\u0115\u0116\f\f\2\2\u0116\u0117"+
		"\7\27\2\2\u0117\u0118\7,\2\2\u0118\u011a\b\f\1\2\u0119\u00f1\3\2\2\2\u0119"+
		"\u00f6\3\2\2\2\u0119\u00fb\3\2\2\2\u0119\u0100\3\2\2\2\u0119\u0105\3\2"+
		"\2\2\u0119\u010a\3\2\2\2\u0119\u010f\3\2\2\2\u0119\u0115\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\27\3\2\2"+
		"\2\u011d\u011b\3\2\2\2\u011e\u011f\7&\2\2\u011f\u012d\b\r\1\2\u0120\u0121"+
		"\7\'\2\2\u0121\u012d\b\r\1\2\u0122\u0123\7(\2\2\u0123\u012d\b\r\1\2\u0124"+
		"\u0125\7,\2\2\u0125\u012d\b\r\1\2\u0126\u0127\7\25\2\2\u0127\u0128\7)"+
		"\2\2\u0128\u0129\7\26\2\2\u0129\u012a\5\30\r\2\u012a\u012b\b\r\1\2\u012b"+
		"\u012d\3\2\2\2\u012c\u011e\3\2\2\2\u012c\u0120\3\2\2\2\u012c\u0122\3\2"+
		"\2\2\u012c\u0124\3\2\2\2\u012c\u0126\3\2\2\2\u012d\31\3\2\2\2\16#\64;"+
		"bi\u00bd\u00cb\u00ce\u00ef\u0119\u011b\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}