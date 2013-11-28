// Generated from src/main/resources/BahasaKu.g4 by ANTLR 4.1
package com.wordpress.thesolidsnake.bahasaku.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BahasaKuLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TAMPILKAN=1, BUAT=2, BOOLEAN_TRUE=3, BOOLEAN_FALSE=4, ASSIGNMENT=5, KOMA=6, 
		TITIK=7, SELF=8, TAMBAH=9, KURANG=10, KALI=11, BAGI=12, KURUNG_BUKA=13, 
		KURUNG_TUTUP=14, STRING=15, IDENTIFIER=16, ANGKA=17, NEWLINE=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'tampilkan'", "'buat'", "'iya'", "'tidak'", "'<-'", "','", "'.'", "'#'", 
		"'+'", "'-'", "'*'", "'/'", "'('", "')'", "STRING", "IDENTIFIER", "ANGKA", 
		"NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"TAMPILKAN", "BUAT", "BOOLEAN_TRUE", "BOOLEAN_FALSE", "ASSIGNMENT", "KOMA", 
		"TITIK", "SELF", "TAMBAH", "KURANG", "KALI", "BAGI", "KURUNG_BUKA", "KURUNG_TUTUP", 
		"STRING", "IDENTIFIER", "ANGKA", "NEWLINE", "WS"
	};


	public BahasaKuLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BahasaKu.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 18: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\25x\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\7\20Z\n\20\f\20\16\20]\13\20\3\20\3\20\3\21\3\21\7\21c\n\21"+
		"\f\21\16\21f\13\21\3\22\6\22i\n\22\r\22\16\22j\3\23\5\23n\n\23\3\23\3"+
		"\23\3\24\6\24s\n\24\r\24\16\24t\3\24\3\24\3[\25\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35"+
		"\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\2\3\2\6\6\2&&C\\aac|\7\2&&\62;C\\"+
		"aac|\3\2\62;\5\2\13\f\17\17\"\"|\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2"+
		"\5\63\3\2\2\2\78\3\2\2\2\t<\3\2\2\2\13B\3\2\2\2\rE\3\2\2\2\17G\3\2\2\2"+
		"\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31Q\3\2\2\2\33S\3\2\2"+
		"\2\35U\3\2\2\2\37W\3\2\2\2!`\3\2\2\2#h\3\2\2\2%m\3\2\2\2\'r\3\2\2\2)*"+
		"\7v\2\2*+\7c\2\2+,\7o\2\2,-\7r\2\2-.\7k\2\2./\7n\2\2/\60\7m\2\2\60\61"+
		"\7c\2\2\61\62\7p\2\2\62\4\3\2\2\2\63\64\7d\2\2\64\65\7w\2\2\65\66\7c\2"+
		"\2\66\67\7v\2\2\67\6\3\2\2\289\7k\2\29:\7{\2\2:;\7c\2\2;\b\3\2\2\2<=\7"+
		"v\2\2=>\7k\2\2>?\7f\2\2?@\7c\2\2@A\7m\2\2A\n\3\2\2\2BC\7>\2\2CD\7/\2\2"+
		"D\f\3\2\2\2EF\7.\2\2F\16\3\2\2\2GH\7\60\2\2H\20\3\2\2\2IJ\7%\2\2J\22\3"+
		"\2\2\2KL\7-\2\2L\24\3\2\2\2MN\7/\2\2N\26\3\2\2\2OP\7,\2\2P\30\3\2\2\2"+
		"QR\7\61\2\2R\32\3\2\2\2ST\7*\2\2T\34\3\2\2\2UV\7+\2\2V\36\3\2\2\2W[\7"+
		")\2\2XZ\13\2\2\2YX\3\2\2\2Z]\3\2\2\2[\\\3\2\2\2[Y\3\2\2\2\\^\3\2\2\2]"+
		"[\3\2\2\2^_\7)\2\2_ \3\2\2\2`d\t\2\2\2ac\t\3\2\2ba\3\2\2\2cf\3\2\2\2d"+
		"b\3\2\2\2de\3\2\2\2e\"\3\2\2\2fd\3\2\2\2gi\t\4\2\2hg\3\2\2\2ij\3\2\2\2"+
		"jh\3\2\2\2jk\3\2\2\2k$\3\2\2\2ln\7\17\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2"+
		"\2op\7\f\2\2p&\3\2\2\2qs\t\5\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2"+
		"\2uv\3\2\2\2vw\b\24\2\2w(\3\2\2\2\b\2[djmt";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}