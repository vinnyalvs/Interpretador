// Generated from Lang.g4 by ANTLR 4.8

/* Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C  */
package parser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DATA=1, NEW=2, INT=3, FLOAT=4, BOOL=5, CHAR=6, PRINT=7, RETURN=8, READ=9, 
		ITERATE=10, IF=11, ELSE=12, LITERAL_INT=13, LITERAL_FLOAT=14, LITERAL_CHAR=15, 
		LITERAL_TRUE=16, LITERAL_FALSE=17, LITERAL_NULL=18, ID=19, NEWLINE=20, 
		WHITESPACE=21, LINE_COMMENT=22, COMMENT=23, OP_BRACKET=24, CL_BRACKET=25, 
		OP_PARENTHESIS=26, CL_PARENTHESIS=27, OP_SQBRACKET=28, CL_SQBRACKET=29, 
		SEMI=30, DOT=31, COMMA=32, EQ=33, RELACIONAL=34, GREATER_THAN=35, EQEQ=36, 
		DIFF=37, PLUS=38, MINUS=39, TIMES=40, DIV=41, MOD=42, DENY=43, AND=44, 
		COLON=45, DOUBLECOLON=46;
	public static final int
		RULE_prog = 0, RULE_data = 1, RULE_decl = 2, RULE_func = 3, RULE_params = 4, 
		RULE_type = 5, RULE_btype = 6, RULE_cmd = 7, RULE_exp = 8, RULE_rexp = 9, 
		RULE_aexp = 10, RULE_mexp = 11, RULE_sexp = 12, RULE_pexp = 13, RULE_lvalue = 14, 
		RULE_exps = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "data", "decl", "func", "params", "type", "btype", "cmd", "exp", 
			"rexp", "aexp", "mexp", "sexp", "pexp", "lvalue", "exps"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'data'", "'new'", "'Int'", "'Float'", "'Bool'", "'Char'", "'print'", 
			"'return'", "'read'", "'iterate'", "'if'", "'else'", null, null, null, 
			"'true'", "'false'", "'null'", null, null, null, null, null, "'{'", "'}'", 
			"'('", "')'", "'['", "']'", "';'", "'.'", "','", "'='", "'<'", "'>'", 
			"'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'&&'", "':'", 
			"'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DATA", "NEW", "INT", "FLOAT", "BOOL", "CHAR", "PRINT", "RETURN", 
			"READ", "ITERATE", "IF", "ELSE", "LITERAL_INT", "LITERAL_FLOAT", "LITERAL_CHAR", 
			"LITERAL_TRUE", "LITERAL_FALSE", "LITERAL_NULL", "ID", "NEWLINE", "WHITESPACE", 
			"LINE_COMMENT", "COMMENT", "OP_BRACKET", "CL_BRACKET", "OP_PARENTHESIS", 
			"CL_PARENTHESIS", "OP_SQBRACKET", "CL_SQBRACKET", "SEMI", "DOT", "COMMA", 
			"EQ", "RELACIONAL", "GREATER_THAN", "EQEQ", "DIFF", "PLUS", "MINUS", 
			"TIMES", "DIV", "MOD", "DENY", "AND", "COLON", "DOUBLECOLON"
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
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DATA) {
				{
				{
				setState(32);
				data();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(38);
				func();
				}
				}
				setState(43);
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

	public static class DataContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(LangParser.DATA, 0); }
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode OP_BRACKET() { return getToken(LangParser.OP_BRACKET, 0); }
		public TerminalNode CL_BRACKET() { return getToken(LangParser.CL_BRACKET, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(DATA);
			setState(45);
			match(ID);
			setState(46);
			match(OP_BRACKET);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(47);
				decl();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(CL_BRACKET);
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode DOUBLECOLON() { return getToken(LangParser.DOUBLECOLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LangParser.SEMI, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(ID);
			setState(56);
			match(DOUBLECOLON);
			setState(57);
			type(0);
			setState(58);
			match(SEMI);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode OP_PARENTHESIS() { return getToken(LangParser.OP_PARENTHESIS, 0); }
		public TerminalNode CL_PARENTHESIS() { return getToken(LangParser.CL_PARENTHESIS, 0); }
		public TerminalNode OP_BRACKET() { return getToken(LangParser.OP_BRACKET, 0); }
		public TerminalNode CL_BRACKET() { return getToken(LangParser.CL_BRACKET, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LangParser.COLON, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(ID);
			setState(61);
			match(OP_PARENTHESIS);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(62);
				params();
				}
			}

			setState(65);
			match(CL_PARENTHESIS);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(66);
				match(COLON);
				setState(67);
				type(0);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(68);
					match(COMMA);
					setState(69);
					type(0);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(77);
			match(OP_BRACKET);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << RETURN) | (1L << READ) | (1L << ITERATE) | (1L << IF) | (1L << ID) | (1L << OP_BRACKET))) != 0)) {
				{
				{
				setState(78);
				cmd();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(CL_BRACKET);
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
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public List<TerminalNode> DOUBLECOLON() { return getTokens(LangParser.DOUBLECOLON); }
		public TerminalNode DOUBLECOLON(int i) {
			return getToken(LangParser.DOUBLECOLON, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			setState(87);
			match(DOUBLECOLON);
			setState(88);
			type(0);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89);
				match(COMMA);
				setState(90);
				match(ID);
				setState(91);
				match(DOUBLECOLON);
				setState(92);
				type(0);
				}
				}
				setState(97);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Type_arrayContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OP_SQBRACKET() { return getToken(LangParser.OP_SQBRACKET, 0); }
		public TerminalNode CL_SQBRACKET() { return getToken(LangParser.CL_SQBRACKET, 0); }
		public Type_arrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitType_array(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Type_btypeContext extends TypeContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public Type_btypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType_btype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType_btype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitType_btype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Type_btypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(99);
			btype();
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Type_arrayContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(101);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(102);
					match(OP_SQBRACKET);
					setState(103);
					match(CL_SQBRACKET);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class BtypeContext extends ParserRuleContext {
		public BtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btype; }
	 
		public BtypeContext() { }
		public void copyFrom(BtypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Type_floatContext extends BtypeContext {
		public TerminalNode FLOAT() { return getToken(LangParser.FLOAT, 0); }
		public Type_floatContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType_float(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitType_float(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Type_dataContext extends BtypeContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public Type_dataContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType_data(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType_data(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitType_data(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Type_boolContext extends BtypeContext {
		public TerminalNode BOOL() { return getToken(LangParser.BOOL, 0); }
		public Type_boolContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType_bool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitType_bool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Type_charContext extends BtypeContext {
		public TerminalNode CHAR() { return getToken(LangParser.CHAR, 0); }
		public Type_charContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType_char(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType_char(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitType_char(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Type_intContext extends BtypeContext {
		public TerminalNode INT() { return getToken(LangParser.INT, 0); }
		public Type_intContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterType_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitType_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitType_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_btype);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new Type_intContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(INT);
				}
				break;
			case CHAR:
				_localctx = new Type_charContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(CHAR);
				}
				break;
			case BOOL:
				_localctx = new Type_boolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(BOOL);
				}
				break;
			case FLOAT:
				_localctx = new Type_floatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(FLOAT);
				}
				break;
			case ID:
				_localctx = new Type_dataContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				match(ID);
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

	public static class CmdContext extends ParserRuleContext {
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	 
		public CmdContext() { }
		public void copyFrom(CmdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallContext extends CmdContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode OP_PARENTHESIS() { return getToken(LangParser.OP_PARENTHESIS, 0); }
		public TerminalNode CL_PARENTHESIS() { return getToken(LangParser.CL_PARENTHESIS, 0); }
		public TerminalNode SEMI() { return getToken(LangParser.SEMI, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public TerminalNode RELACIONAL() { return getToken(LangParser.RELACIONAL, 0); }
		public List<LvalueContext> lvalue() {
			return getRuleContexts(LvalueContext.class);
		}
		public LvalueContext lvalue(int i) {
			return getRuleContext(LvalueContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(LangParser.GREATER_THAN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public CallContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends CmdContext {
		public TerminalNode PRINT() { return getToken(LangParser.PRINT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LangParser.SEMI, 0); }
		public PrintContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadContext extends CmdContext {
		public TerminalNode READ() { return getToken(LangParser.READ, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LangParser.SEMI, 0); }
		public ReadContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CmdlistContext extends CmdContext {
		public TerminalNode OP_BRACKET() { return getToken(LangParser.OP_BRACKET, 0); }
		public TerminalNode CL_BRACKET() { return getToken(LangParser.CL_BRACKET, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdlistContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCmdlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCmdlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCmdlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttrContext extends CmdContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(LangParser.EQ, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LangParser.SEMI, 0); }
		public AttrContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends CmdContext {
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public TerminalNode OP_PARENTHESIS() { return getToken(LangParser.OP_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CL_PARENTHESIS() { return getToken(LangParser.CL_PARENTHESIS, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public IfContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class If_elseContext extends CmdContext {
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public TerminalNode OP_PARENTHESIS() { return getToken(LangParser.OP_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CL_PARENTHESIS() { return getToken(LangParser.CL_PARENTHESIS, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LangParser.ELSE, 0); }
		public If_elseContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIf_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIf_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIf_else(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends CmdContext {
		public TerminalNode RETURN() { return getToken(LangParser.RETURN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(LangParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public ReturnContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterateContext extends CmdContext {
		public TerminalNode ITERATE() { return getToken(LangParser.ITERATE, 0); }
		public TerminalNode OP_PARENTHESIS() { return getToken(LangParser.OP_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CL_PARENTHESIS() { return getToken(LangParser.CL_PARENTHESIS, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public IterateContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIterate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIterate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIterate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmd);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new CmdlistContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(OP_BRACKET);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << RETURN) | (1L << READ) | (1L << ITERATE) | (1L << IF) | (1L << ID) | (1L << OP_BRACKET))) != 0)) {
					{
					{
					setState(117);
					cmd();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(CL_BRACKET);
				}
				break;
			case 2:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(IF);
				setState(125);
				match(OP_PARENTHESIS);
				setState(126);
				exp(0);
				setState(127);
				match(CL_PARENTHESIS);
				setState(128);
				cmd();
				}
				break;
			case 3:
				_localctx = new If_elseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				match(IF);
				setState(131);
				match(OP_PARENTHESIS);
				setState(132);
				exp(0);
				setState(133);
				match(CL_PARENTHESIS);
				setState(134);
				cmd();
				setState(135);
				match(ELSE);
				setState(136);
				cmd();
				}
				break;
			case 4:
				_localctx = new IterateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(ITERATE);
				setState(139);
				match(OP_PARENTHESIS);
				setState(140);
				exp(0);
				setState(141);
				match(CL_PARENTHESIS);
				setState(142);
				cmd();
				}
				break;
			case 5:
				_localctx = new ReadContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(READ);
				setState(145);
				lvalue(0);
				setState(146);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				match(PRINT);
				setState(149);
				exp(0);
				setState(150);
				match(SEMI);
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(152);
				match(RETURN);
				setState(153);
				exp(0);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(154);
					match(COMMA);
					setState(155);
					exp(0);
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(SEMI);
				}
				break;
			case 8:
				_localctx = new AttrContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(163);
				lvalue(0);
				setState(164);
				match(EQ);
				setState(165);
				exp(0);
				setState(166);
				match(SEMI);
				}
				break;
			case 9:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(168);
				match(ID);
				setState(169);
				match(OP_PARENTHESIS);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << LITERAL_INT) | (1L << LITERAL_FLOAT) | (1L << LITERAL_CHAR) | (1L << LITERAL_TRUE) | (1L << LITERAL_FALSE) | (1L << LITERAL_NULL) | (1L << ID) | (1L << OP_PARENTHESIS) | (1L << MINUS) | (1L << DENY))) != 0)) {
					{
					setState(170);
					exps();
					}
				}

				setState(173);
				match(CL_PARENTHESIS);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RELACIONAL) {
					{
					setState(174);
					match(RELACIONAL);
					setState(175);
					lvalue(0);
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(176);
						match(COMMA);
						setState(177);
						lvalue(0);
						}
						}
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(183);
					match(GREATER_THAN);
					}
				}

				setState(187);
				match(SEMI);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(LangParser.AND, 0); }
		public AndContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_rexpContext extends ExpContext {
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public Exp_rexpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterExp_rexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitExp_rexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitExp_rexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Exp_rexpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(191);
			rexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndContext(new ExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(193);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(194);
					match(AND);
					setState(195);
					exp(3);
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class RexpContext extends ParserRuleContext {
		public RexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rexp; }
	 
		public RexpContext() { }
		public void copyFrom(RexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Rexp_aexpContext extends RexpContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public Rexp_aexpContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterRexp_aexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitRexp_aexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitRexp_aexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Less_thanContext extends RexpContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public TerminalNode RELACIONAL() { return getToken(LangParser.RELACIONAL, 0); }
		public Less_thanContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLess_than(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLess_than(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLess_than(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqeqContext extends RexpContext {
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public TerminalNode EQEQ() { return getToken(LangParser.EQEQ, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public EqeqContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterEqeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitEqeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitEqeq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoeqContext extends RexpContext {
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public TerminalNode DIFF() { return getToken(LangParser.DIFF, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public NoeqContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNoeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNoeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNoeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RexpContext rexp() throws RecognitionException {
		return rexp(0);
	}

	private RexpContext rexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RexpContext _localctx = new RexpContext(_ctx, _parentState);
		RexpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_rexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new Less_thanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(202);
				aexp(0);
				setState(203);
				match(RELACIONAL);
				setState(204);
				aexp(0);
				}
				break;
			case 2:
				{
				_localctx = new Rexp_aexpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				aexp(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(215);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new EqeqContext(new RexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
						setState(209);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(210);
						match(EQEQ);
						setState(211);
						aexp(0);
						}
						break;
					case 2:
						{
						_localctx = new NoeqContext(new RexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
						setState(212);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(213);
						match(DIFF);
						setState(214);
						aexp(0);
						}
						break;
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class AexpContext extends ParserRuleContext {
		public AexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp; }
	 
		public AexpContext() { }
		public void copyFrom(AexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddContext extends AexpContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(LangParser.PLUS, 0); }
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public AddContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiffContext extends AexpContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(LangParser.MINUS, 0); }
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public DiffContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDiff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDiff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDiff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Aexp_mexpContext extends AexpContext {
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public Aexp_mexpContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAexp_mexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAexp_mexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAexp_mexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpContext aexp() throws RecognitionException {
		return aexp(0);
	}

	private AexpContext aexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexpContext _localctx = new AexpContext(_ctx, _parentState);
		AexpContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_aexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Aexp_mexpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(221);
			mexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new AddContext(new AexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(223);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(224);
						match(PLUS);
						setState(225);
						mexp(0);
						}
						break;
					case 2:
						{
						_localctx = new DiffContext(new AexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(226);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(227);
						match(MINUS);
						setState(228);
						mexp(0);
						}
						break;
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class MexpContext extends ParserRuleContext {
		public MexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mexp; }
	 
		public MexpContext() { }
		public void copyFrom(MexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivContext extends MexpContext {
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public TerminalNode DIV() { return getToken(LangParser.DIV, 0); }
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public DivContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModContext extends MexpContext {
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public TerminalNode MOD() { return getToken(LangParser.MOD, 0); }
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public ModContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulContext extends MexpContext {
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(LangParser.TIMES, 0); }
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public MulContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Mexp_sexpContext extends MexpContext {
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public Mexp_sexpContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterMexp_sexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitMexp_sexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitMexp_sexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MexpContext mexp() throws RecognitionException {
		return mexp(0);
	}

	private MexpContext mexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MexpContext _localctx = new MexpContext(_ctx, _parentState);
		MexpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_mexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Mexp_sexpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(235);
			sexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new MulContext(new MexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(237);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(238);
						match(TIMES);
						setState(239);
						sexp();
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new MexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(240);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(241);
						match(DIV);
						setState(242);
						sexp();
						}
						break;
					case 3:
						{
						_localctx = new ModContext(new MexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(243);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(244);
						match(MOD);
						setState(245);
						sexp();
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class SexpContext extends ParserRuleContext {
		public SexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexp; }
	 
		public SexpContext() { }
		public void copyFrom(SexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinusContext extends SexpContext {
		public TerminalNode MINUS() { return getToken(LangParser.MINUS, 0); }
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public MinusContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_falseContext extends SexpContext {
		public TerminalNode LITERAL_FALSE() { return getToken(LangParser.LITERAL_FALSE, 0); }
		public Literal_falseContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLiteral_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLiteral_false(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteral_false(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_intContext extends SexpContext {
		public TerminalNode LITERAL_INT() { return getToken(LangParser.LITERAL_INT, 0); }
		public Literal_intContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLiteral_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLiteral_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteral_int(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DenyContext extends SexpContext {
		public TerminalNode DENY() { return getToken(LangParser.DENY, 0); }
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public DenyContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDeny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDeny(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDeny(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_nullContext extends SexpContext {
		public TerminalNode LITERAL_NULL() { return getToken(LangParser.LITERAL_NULL, 0); }
		public Literal_nullContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLiteral_null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLiteral_null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteral_null(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_trueContext extends SexpContext {
		public TerminalNode LITERAL_TRUE() { return getToken(LangParser.LITERAL_TRUE, 0); }
		public Literal_trueContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLiteral_true(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLiteral_true(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteral_true(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_floatContext extends SexpContext {
		public TerminalNode LITERAL_FLOAT() { return getToken(LangParser.LITERAL_FLOAT, 0); }
		public Literal_floatContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLiteral_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLiteral_float(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteral_float(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Literal_charContext extends SexpContext {
		public TerminalNode LITERAL_CHAR() { return getToken(LangParser.LITERAL_CHAR, 0); }
		public Literal_charContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLiteral_char(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLiteral_char(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLiteral_char(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Sexp_pexpContext extends SexpContext {
		public PexpContext pexp() {
			return getRuleContext(PexpContext.class,0);
		}
		public Sexp_pexpContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterSexp_pexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitSexp_pexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitSexp_pexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexpContext sexp() throws RecognitionException {
		SexpContext _localctx = new SexpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sexp);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DENY:
				_localctx = new DenyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(DENY);
				setState(252);
				sexp();
				}
				break;
			case MINUS:
				_localctx = new MinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(MINUS);
				setState(254);
				sexp();
				}
				break;
			case LITERAL_TRUE:
				_localctx = new Literal_trueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(LITERAL_TRUE);
				}
				break;
			case LITERAL_FALSE:
				_localctx = new Literal_falseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				match(LITERAL_FALSE);
				}
				break;
			case LITERAL_NULL:
				_localctx = new Literal_nullContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(257);
				match(LITERAL_NULL);
				}
				break;
			case LITERAL_INT:
				_localctx = new Literal_intContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(258);
				match(LITERAL_INT);
				}
				break;
			case LITERAL_FLOAT:
				_localctx = new Literal_floatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(259);
				match(LITERAL_FLOAT);
				}
				break;
			case LITERAL_CHAR:
				_localctx = new Literal_charContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(260);
				match(LITERAL_CHAR);
				}
				break;
			case NEW:
			case ID:
			case OP_PARENTHESIS:
				_localctx = new Sexp_pexpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(261);
				pexp();
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

	public static class PexpContext extends ParserRuleContext {
		public PexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pexp; }
	 
		public PexpContext() { }
		public void copyFrom(PexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Pexp_lvalueContext extends PexpContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public Pexp_lvalueContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterPexp_lvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitPexp_lvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPexp_lvalue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewContext extends PexpContext {
		public TerminalNode NEW() { return getToken(LangParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OP_SQBRACKET() { return getToken(LangParser.OP_SQBRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CL_SQBRACKET() { return getToken(LangParser.CL_SQBRACKET, 0); }
		public NewContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Parenthesis_expContext extends PexpContext {
		public TerminalNode OP_PARENTHESIS() { return getToken(LangParser.OP_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CL_PARENTHESIS() { return getToken(LangParser.CL_PARENTHESIS, 0); }
		public Parenthesis_expContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterParenthesis_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitParenthesis_exp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitParenthesis_exp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pexp_funcContext extends PexpContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode OP_PARENTHESIS() { return getToken(LangParser.OP_PARENTHESIS, 0); }
		public TerminalNode CL_PARENTHESIS() { return getToken(LangParser.CL_PARENTHESIS, 0); }
		public TerminalNode OP_SQBRACKET() { return getToken(LangParser.OP_SQBRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CL_SQBRACKET() { return getToken(LangParser.CL_SQBRACKET, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public Pexp_funcContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterPexp_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitPexp_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPexp_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PexpContext pexp() throws RecognitionException {
		PexpContext _localctx = new PexpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pexp);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new Pexp_lvalueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				lvalue(0);
				}
				break;
			case 2:
				_localctx = new Parenthesis_expContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(OP_PARENTHESIS);
				setState(266);
				exp(0);
				setState(267);
				match(CL_PARENTHESIS);
				}
				break;
			case 3:
				_localctx = new NewContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				match(NEW);
				setState(270);
				type(0);
				setState(275);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(271);
					match(OP_SQBRACKET);
					setState(272);
					exp(0);
					setState(273);
					match(CL_SQBRACKET);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new Pexp_funcContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(277);
				match(ID);
				setState(278);
				match(OP_PARENTHESIS);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << LITERAL_INT) | (1L << LITERAL_FLOAT) | (1L << LITERAL_CHAR) | (1L << LITERAL_TRUE) | (1L << LITERAL_FALSE) | (1L << LITERAL_NULL) | (1L << ID) | (1L << OP_PARENTHESIS) | (1L << MINUS) | (1L << DENY))) != 0)) {
					{
					setState(279);
					exps();
					}
				}

				setState(282);
				match(CL_PARENTHESIS);
				setState(283);
				match(OP_SQBRACKET);
				setState(284);
				exp(0);
				setState(285);
				match(CL_SQBRACKET);
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

	public static class LvalueContext extends ParserRuleContext {
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	 
		public LvalueContext() { }
		public void copyFrom(LvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Lvalue_dotContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LangParser.DOT, 0); }
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public Lvalue_dotContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLvalue_dot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLvalue_dot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLvalue_dot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Lvalue_idContext extends LvalueContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public Lvalue_idContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLvalue_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLvalue_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLvalue_id(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Lvalue_arrayContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode OP_SQBRACKET() { return getToken(LangParser.OP_SQBRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CL_SQBRACKET() { return getToken(LangParser.CL_SQBRACKET, 0); }
		public Lvalue_arrayContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLvalue_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLvalue_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLvalue_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Lvalue_idContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(290);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(300);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new Lvalue_arrayContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(292);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(293);
						match(OP_SQBRACKET);
						setState(294);
						exp(0);
						setState(295);
						match(CL_SQBRACKET);
						}
						break;
					case 2:
						{
						_localctx = new Lvalue_dotContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(297);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(298);
						match(DOT);
						setState(299);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class ExpsContext extends ParserRuleContext {
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
	 
		public ExpsContext() { }
		public void copyFrom(ExpsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Exp_listContext extends ExpsContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public Exp_listContext(ExpsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterExp_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitExp_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitExp_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exps);
		int _la;
		try {
			_localctx = new Exp_listContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			exp(0);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(306);
				match(COMMA);
				setState(307);
				exp(0);
				}
				}
				setState(312);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 8:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 9:
			return rexp_sempred((RexpContext)_localctx, predIndex);
		case 10:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 11:
			return mexp_sempred((MexpContext)_localctx, predIndex);
		case 14:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rexp_sempred(RexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean aexp_sempred(AexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mexp_sempred(MexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u013c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2"+
		"$\n\2\f\2\16\2\'\13\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\3\3\3\3\7\3"+
		"\63\n\3\f\3\16\3\66\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5B"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\5\5N\n\5\3\5\3\5\7\5"+
		"R\n\5\f\5\16\5U\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6`\n\6\f\6"+
		"\16\6c\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7k\n\7\f\7\16\7n\13\7\3\b\3\b\3"+
		"\b\3\b\3\b\5\bu\n\b\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009f\n\t\f\t\16\t\u00a2"+
		"\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ae\n\t\3\t\3\t\3"+
		"\t\3\t\3\t\7\t\u00b5\n\t\f\t\16\t\u00b8\13\t\3\t\3\t\5\t\u00bc\n\t\3\t"+
		"\5\t\u00bf\n\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00c7\n\n\f\n\16\n\u00ca\13"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d2\n\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\7\13\u00da\n\13\f\13\16\13\u00dd\13\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\7\f\u00e8\n\f\f\f\16\f\u00eb\13\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f9\n\r\f\r\16\r\u00fc\13\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0109\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0116\n\17\3\17\3\17"+
		"\3\17\5\17\u011b\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u0122\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u012f\n\20\f\20"+
		"\16\20\u0132\13\20\3\21\3\21\3\21\7\21\u0137\n\21\f\21\16\21\u013a\13"+
		"\21\3\21\2\b\f\22\24\26\30\36\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \2\2\2\u015e\2%\3\2\2\2\4.\3\2\2\2\69\3\2\2\2\b>\3\2\2\2\nX\3\2\2\2\f"+
		"d\3\2\2\2\16t\3\2\2\2\20\u00be\3\2\2\2\22\u00c0\3\2\2\2\24\u00d1\3\2\2"+
		"\2\26\u00de\3\2\2\2\30\u00ec\3\2\2\2\32\u0108\3\2\2\2\34\u0121\3\2\2\2"+
		"\36\u0123\3\2\2\2 \u0133\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3"+
		"\2\2\2%&\3\2\2\2&+\3\2\2\2\'%\3\2\2\2(*\5\b\5\2)(\3\2\2\2*-\3\2\2\2+)"+
		"\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-+\3\2\2\2./\7\3\2\2/\60\7\25\2\2\60\64\7"+
		"\32\2\2\61\63\5\6\4\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65"+
		"\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7\33\2\28\5\3\2\2\29:\7\25\2"+
		"\2:;\7\60\2\2;<\5\f\7\2<=\7 \2\2=\7\3\2\2\2>?\7\25\2\2?A\7\34\2\2@B\5"+
		"\n\6\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CM\7\35\2\2DE\7/\2\2EJ\5\f\7\2FG\7"+
		"\"\2\2GI\5\f\7\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3"+
		"\2\2\2MD\3\2\2\2MN\3\2\2\2NO\3\2\2\2OS\7\32\2\2PR\5\20\t\2QP\3\2\2\2R"+
		"U\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\33\2\2W\t\3\2\2"+
		"\2XY\7\25\2\2YZ\7\60\2\2Za\5\f\7\2[\\\7\"\2\2\\]\7\25\2\2]^\7\60\2\2^"+
		"`\5\f\7\2_[\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\13\3\2\2\2ca\3\2\2"+
		"\2de\b\7\1\2ef\5\16\b\2fl\3\2\2\2gh\f\4\2\2hi\7\36\2\2ik\7\37\2\2jg\3"+
		"\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\r\3\2\2\2nl\3\2\2\2ou\7\5\2\2pu"+
		"\7\b\2\2qu\7\7\2\2ru\7\6\2\2su\7\25\2\2to\3\2\2\2tp\3\2\2\2tq\3\2\2\2"+
		"tr\3\2\2\2ts\3\2\2\2u\17\3\2\2\2vz\7\32\2\2wy\5\20\t\2xw\3\2\2\2y|\3\2"+
		"\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u00bf\7\33\2\2~\177\7\r"+
		"\2\2\177\u0080\7\34\2\2\u0080\u0081\5\22\n\2\u0081\u0082\7\35\2\2\u0082"+
		"\u0083\5\20\t\2\u0083\u00bf\3\2\2\2\u0084\u0085\7\r\2\2\u0085\u0086\7"+
		"\34\2\2\u0086\u0087\5\22\n\2\u0087\u0088\7\35\2\2\u0088\u0089\5\20\t\2"+
		"\u0089\u008a\7\16\2\2\u008a\u008b\5\20\t\2\u008b\u00bf\3\2\2\2\u008c\u008d"+
		"\7\f\2\2\u008d\u008e\7\34\2\2\u008e\u008f\5\22\n\2\u008f\u0090\7\35\2"+
		"\2\u0090\u0091\5\20\t\2\u0091\u00bf\3\2\2\2\u0092\u0093\7\13\2\2\u0093"+
		"\u0094\5\36\20\2\u0094\u0095\7 \2\2\u0095\u00bf\3\2\2\2\u0096\u0097\7"+
		"\t\2\2\u0097\u0098\5\22\n\2\u0098\u0099\7 \2\2\u0099\u00bf\3\2\2\2\u009a"+
		"\u009b\7\n\2\2\u009b\u00a0\5\22\n\2\u009c\u009d\7\"\2\2\u009d\u009f\5"+
		"\22\n\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7 "+
		"\2\2\u00a4\u00bf\3\2\2\2\u00a5\u00a6\5\36\20\2\u00a6\u00a7\7#\2\2\u00a7"+
		"\u00a8\5\22\n\2\u00a8\u00a9\7 \2\2\u00a9\u00bf\3\2\2\2\u00aa\u00ab\7\25"+
		"\2\2\u00ab\u00ad\7\34\2\2\u00ac\u00ae\5 \21\2\u00ad\u00ac\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00bb\7\35\2\2\u00b0\u00b1\7"+
		"$\2\2\u00b1\u00b6\5\36\20\2\u00b2\u00b3\7\"\2\2\u00b3\u00b5\5\36\20\2"+
		"\u00b4\u00b2\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7%\2\2\u00ba"+
		"\u00bc\3\2\2\2\u00bb\u00b0\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00bf\7 \2\2\u00bev\3\2\2\2\u00be~\3\2\2\2\u00be\u0084\3\2"+
		"\2\2\u00be\u008c\3\2\2\2\u00be\u0092\3\2\2\2\u00be\u0096\3\2\2\2\u00be"+
		"\u009a\3\2\2\2\u00be\u00a5\3\2\2\2\u00be\u00aa\3\2\2\2\u00bf\21\3\2\2"+
		"\2\u00c0\u00c1\b\n\1\2\u00c1\u00c2\5\24\13\2\u00c2\u00c8\3\2\2\2\u00c3"+
		"\u00c4\f\4\2\2\u00c4\u00c5\7.\2\2\u00c5\u00c7\5\22\n\5\u00c6\u00c3\3\2"+
		"\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\23\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\b\13\1\2\u00cc\u00cd\5\26"+
		"\f\2\u00cd\u00ce\7$\2\2\u00ce\u00cf\5\26\f\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00d2\5\26\f\2\u00d1\u00cb\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00db\3"+
		"\2\2\2\u00d3\u00d4\f\5\2\2\u00d4\u00d5\7&\2\2\u00d5\u00da\5\26\f\2\u00d6"+
		"\u00d7\f\4\2\2\u00d7\u00d8\7\'\2\2\u00d8\u00da\5\26\f\2\u00d9\u00d3\3"+
		"\2\2\2\u00d9\u00d6\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\25\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\b\f\1"+
		"\2\u00df\u00e0\5\30\r\2\u00e0\u00e9\3\2\2\2\u00e1\u00e2\f\5\2\2\u00e2"+
		"\u00e3\7(\2\2\u00e3\u00e8\5\30\r\2\u00e4\u00e5\f\4\2\2\u00e5\u00e6\7)"+
		"\2\2\u00e6\u00e8\5\30\r\2\u00e7\u00e1\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\27\3\2\2"+
		"\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b\r\1\2\u00ed\u00ee\5\32\16\2\u00ee"+
		"\u00fa\3\2\2\2\u00ef\u00f0\f\6\2\2\u00f0\u00f1\7*\2\2\u00f1\u00f9\5\32"+
		"\16\2\u00f2\u00f3\f\5\2\2\u00f3\u00f4\7+\2\2\u00f4\u00f9\5\32\16\2\u00f5"+
		"\u00f6\f\4\2\2\u00f6\u00f7\7,\2\2\u00f7\u00f9\5\32\16\2\u00f8\u00ef\3"+
		"\2\2\2\u00f8\u00f2\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\31\3\2\2\2\u00fc\u00fa\3\2\2"+
		"\2\u00fd\u00fe\7-\2\2\u00fe\u0109\5\32\16\2\u00ff\u0100\7)\2\2\u0100\u0109"+
		"\5\32\16\2\u0101\u0109\7\22\2\2\u0102\u0109\7\23\2\2\u0103\u0109\7\24"+
		"\2\2\u0104\u0109\7\17\2\2\u0105\u0109\7\20\2\2\u0106\u0109\7\21\2\2\u0107"+
		"\u0109\5\34\17\2\u0108\u00fd\3\2\2\2\u0108\u00ff\3\2\2\2\u0108\u0101\3"+
		"\2\2\2\u0108\u0102\3\2\2\2\u0108\u0103\3\2\2\2\u0108\u0104\3\2\2\2\u0108"+
		"\u0105\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\33\3\2\2"+
		"\2\u010a\u0122\5\36\20\2\u010b\u010c\7\34\2\2\u010c\u010d\5\22\n\2\u010d"+
		"\u010e\7\35\2\2\u010e\u0122\3\2\2\2\u010f\u0110\7\4\2\2\u0110\u0115\5"+
		"\f\7\2\u0111\u0112\7\36\2\2\u0112\u0113\5\22\n\2\u0113\u0114\7\37\2\2"+
		"\u0114\u0116\3\2\2\2\u0115\u0111\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0122"+
		"\3\2\2\2\u0117\u0118\7\25\2\2\u0118\u011a\7\34\2\2\u0119\u011b\5 \21\2"+
		"\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d"+
		"\7\35\2\2\u011d\u011e\7\36\2\2\u011e\u011f\5\22\n\2\u011f\u0120\7\37\2"+
		"\2\u0120\u0122\3\2\2\2\u0121\u010a\3\2\2\2\u0121\u010b\3\2\2\2\u0121\u010f"+
		"\3\2\2\2\u0121\u0117\3\2\2\2\u0122\35\3\2\2\2\u0123\u0124\b\20\1\2\u0124"+
		"\u0125\7\25\2\2\u0125\u0130\3\2\2\2\u0126\u0127\f\4\2\2\u0127\u0128\7"+
		"\36\2\2\u0128\u0129\5\22\n\2\u0129\u012a\7\37\2\2\u012a\u012f\3\2\2\2"+
		"\u012b\u012c\f\3\2\2\u012c\u012d\7!\2\2\u012d\u012f\7\25\2\2\u012e\u0126"+
		"\3\2\2\2\u012e\u012b\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\37\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0138\5\22\n"+
		"\2\u0134\u0135\7\"\2\2\u0135\u0137\5\22\n\2\u0136\u0134\3\2\2\2\u0137"+
		"\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139!\3\2\2\2"+
		"\u013a\u0138\3\2\2\2!%+\64AJMSaltz\u00a0\u00ad\u00b6\u00bb\u00be\u00c8"+
		"\u00d1\u00d9\u00db\u00e7\u00e9\u00f8\u00fa\u0108\u0115\u011a\u0121\u012e"+
		"\u0130\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}