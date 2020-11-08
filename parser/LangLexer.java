// Generated from Lang.g4 by ANTLR 4.8

/* Edson Lopes da Silva Júnior 201635023
   Vinicius Alberto Alves da Silva 201665558C  */
package parser;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "ALPHA", "DATA", "NEW", "INT", "FLOAT", "BOOL", "CHAR", "PRINT", 
			"RETURN", "READ", "ITERATE", "IF", "ELSE", "LITERAL_INT", "LITERAL_FLOAT", 
			"LITERAL_CHAR", "LITERAL_TRUE", "LITERAL_FALSE", "LITERAL_NULL", "ID", 
			"NEWLINE", "WHITESPACE", "LINE_COMMENT", "COMMENT", "OP_BRACKET", "CL_BRACKET", 
			"OP_PARENTHESIS", "CL_PARENTHESIS", "OP_SQBRACKET", "CL_SQBRACKET", "SEMI", 
			"DOT", "COMMA", "EQ", "RELACIONAL", "GREATER_THAN", "EQEQ", "DIFF", "PLUS", 
			"MINUS", "TIMES", "DIV", "MOD", "DENY", "AND", "COLON", "DOUBLECOLON"
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


	public LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0131\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\6\20\u00a8\n\20"+
		"\r\20\16\20\u00a9\3\21\7\21\u00ad\n\21\f\21\16\21\u00b0\13\21\3\21\3\21"+
		"\6\21\u00b4\n\21\r\21\16\21\u00b5\3\22\3\22\3\22\3\22\5\22\u00bc\n\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\7\26\u00d2\n\26\f\26\16\26\u00d5\13\26"+
		"\3\27\5\27\u00d8\n\27\3\27\3\27\3\27\3\27\3\30\6\30\u00df\n\30\r\30\16"+
		"\30\u00e0\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00e9\n\31\f\31\16\31\u00ec"+
		"\13\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u00f6\n\32\f\32\16"+
		"\32\u00f9\13\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3"+
		"\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\61\3\u00f7\2\62\3\2\5\2\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25"+
		"\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30"+
		"\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a"+
		"\60\3\2\t\3\2\62;\4\2C\\c|\t\2$$))^^ddppttvv\6\2\f\f\17\17$$^^\6\2\62"+
		";C\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\2\u0137\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5e\3\2\2\2\7g\3\2\2\2\tl\3\2\2\2"+
		"\13p\3\2\2\2\rt\3\2\2\2\17z\3\2\2\2\21\177\3\2\2\2\23\u0084\3\2\2\2\25"+
		"\u008a\3\2\2\2\27\u0091\3\2\2\2\31\u0096\3\2\2\2\33\u009e\3\2\2\2\35\u00a1"+
		"\3\2\2\2\37\u00a7\3\2\2\2!\u00ae\3\2\2\2#\u00b7\3\2\2\2%\u00bf\3\2\2\2"+
		"\'\u00c4\3\2\2\2)\u00ca\3\2\2\2+\u00cf\3\2\2\2-\u00d7\3\2\2\2/\u00de\3"+
		"\2\2\2\61\u00e4\3\2\2\2\63\u00f1\3\2\2\2\65\u00ff\3\2\2\2\67\u0101\3\2"+
		"\2\29\u0103\3\2\2\2;\u0105\3\2\2\2=\u0107\3\2\2\2?\u0109\3\2\2\2A\u010b"+
		"\3\2\2\2C\u010d\3\2\2\2E\u010f\3\2\2\2G\u0111\3\2\2\2I\u0113\3\2\2\2K"+
		"\u0115\3\2\2\2M\u0117\3\2\2\2O\u011a\3\2\2\2Q\u011d\3\2\2\2S\u011f\3\2"+
		"\2\2U\u0121\3\2\2\2W\u0123\3\2\2\2Y\u0125\3\2\2\2[\u0127\3\2\2\2]\u0129"+
		"\3\2\2\2_\u012c\3\2\2\2a\u012e\3\2\2\2cd\t\2\2\2d\4\3\2\2\2ef\t\3\2\2"+
		"f\6\3\2\2\2gh\7f\2\2hi\7c\2\2ij\7v\2\2jk\7c\2\2k\b\3\2\2\2lm\7p\2\2mn"+
		"\7g\2\2no\7y\2\2o\n\3\2\2\2pq\7K\2\2qr\7p\2\2rs\7v\2\2s\f\3\2\2\2tu\7"+
		"H\2\2uv\7n\2\2vw\7q\2\2wx\7c\2\2xy\7v\2\2y\16\3\2\2\2z{\7D\2\2{|\7q\2"+
		"\2|}\7q\2\2}~\7n\2\2~\20\3\2\2\2\177\u0080\7E\2\2\u0080\u0081\7j\2\2\u0081"+
		"\u0082\7c\2\2\u0082\u0083\7t\2\2\u0083\22\3\2\2\2\u0084\u0085\7r\2\2\u0085"+
		"\u0086\7t\2\2\u0086\u0087\7k\2\2\u0087\u0088\7p\2\2\u0088\u0089\7v\2\2"+
		"\u0089\24\3\2\2\2\u008a\u008b\7t\2\2\u008b\u008c\7g\2\2\u008c\u008d\7"+
		"v\2\2\u008d\u008e\7w\2\2\u008e\u008f\7t\2\2\u008f\u0090\7p\2\2\u0090\26"+
		"\3\2\2\2\u0091\u0092\7t\2\2\u0092\u0093\7g\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7f\2\2\u0095\30\3\2\2\2\u0096\u0097\7k\2\2\u0097\u0098\7v\2\2\u0098"+
		"\u0099\7g\2\2\u0099\u009a\7t\2\2\u009a\u009b\7c\2\2\u009b\u009c\7v\2\2"+
		"\u009c\u009d\7g\2\2\u009d\32\3\2\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7"+
		"h\2\2\u00a0\34\3\2\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4"+
		"\7u\2\2\u00a4\u00a5\7g\2\2\u00a5\36\3\2\2\2\u00a6\u00a8\t\2\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa \3\2\2\2\u00ab\u00ad\t\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b3\7\60\2\2\u00b2\u00b4\t\2\2\2\u00b3\u00b2\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\"\3\2\2\2\u00b7\u00bb\7)\2\2\u00b8\u00b9\7^\2\2\u00b9\u00bc\t\4\2\2\u00ba"+
		"\u00bc\n\5\2\2\u00bb\u00b8\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\7)\2\2\u00be$\3\2\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1"+
		"\7t\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7g\2\2\u00c3&\3\2\2\2\u00c4\u00c5"+
		"\7h\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7u\2\2\u00c8"+
		"\u00c9\7g\2\2\u00c9(\3\2\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7w\2\2\u00cc"+
		"\u00cd\7n\2\2\u00cd\u00ce\7n\2\2\u00ce*\3\2\2\2\u00cf\u00d3\t\3\2\2\u00d0"+
		"\u00d2\t\6\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4,\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8"+
		"\7\17\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2"+
		"\u00d9\u00da\7\f\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\27\2\2\u00dc.\3"+
		"\2\2\2\u00dd\u00df\t\7\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\30"+
		"\2\2\u00e3\60\3\2\2\2\u00e4\u00e5\7/\2\2\u00e5\u00e6\7/\2\2\u00e6\u00ea"+
		"\3\2\2\2\u00e7\u00e9\n\b\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2"+
		"\2\2\u00ed\u00ee\5-\27\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b\31\2\2\u00f0"+
		"\62\3\2\2\2\u00f1\u00f2\7}\2\2\u00f2\u00f3\7/\2\2\u00f3\u00f7\3\2\2\2"+
		"\u00f4\u00f6\13\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\7,\2\2\u00fb\u00fc\7\177\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\b"+
		"\32\2\2\u00fe\64\3\2\2\2\u00ff\u0100\7}\2\2\u0100\66\3\2\2\2\u0101\u0102"+
		"\7\177\2\2\u01028\3\2\2\2\u0103\u0104\7*\2\2\u0104:\3\2\2\2\u0105\u0106"+
		"\7+\2\2\u0106<\3\2\2\2\u0107\u0108\7]\2\2\u0108>\3\2\2\2\u0109\u010a\7"+
		"_\2\2\u010a@\3\2\2\2\u010b\u010c\7=\2\2\u010cB\3\2\2\2\u010d\u010e\7\60"+
		"\2\2\u010eD\3\2\2\2\u010f\u0110\7.\2\2\u0110F\3\2\2\2\u0111\u0112\7?\2"+
		"\2\u0112H\3\2\2\2\u0113\u0114\7>\2\2\u0114J\3\2\2\2\u0115\u0116\7@\2\2"+
		"\u0116L\3\2\2\2\u0117\u0118\7?\2\2\u0118\u0119\7?\2\2\u0119N\3\2\2\2\u011a"+
		"\u011b\7#\2\2\u011b\u011c\7?\2\2\u011cP\3\2\2\2\u011d\u011e\7-\2\2\u011e"+
		"R\3\2\2\2\u011f\u0120\7/\2\2\u0120T\3\2\2\2\u0121\u0122\7,\2\2\u0122V"+
		"\3\2\2\2\u0123\u0124\7\61\2\2\u0124X\3\2\2\2\u0125\u0126\7\'\2\2\u0126"+
		"Z\3\2\2\2\u0127\u0128\7#\2\2\u0128\\\3\2\2\2\u0129\u012a\7(\2\2\u012a"+
		"\u012b\7(\2\2\u012b^\3\2\2\2\u012c\u012d\7<\2\2\u012d`\3\2\2\2\u012e\u012f"+
		"\7<\2\2\u012f\u0130\7<\2\2\u0130b\3\2\2\2\r\2\u00a9\u00ae\u00b5\u00bb"+
		"\u00d1\u00d3\u00d7\u00e0\u00ea\u00f7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}