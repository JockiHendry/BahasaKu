// Generated from src/main/resources/BahasaKu.g4 by ANTLR 4.1
package com.wordpress.thesolidsnake.bahasaku.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BahasaKuParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TAMPILKAN=1, BUAT=2, BOOLEAN_TRUE=3, BOOLEAN_FALSE=4, ASSIGNMENT=5, KOMA=6, 
		TITIK=7, SELF=8, TAMBAH=9, KURANG=10, KALI=11, BAGI=12, KURUNG_BUKA=13, 
		KURUNG_TUTUP=14, STRING=15, IDENTIFIER=16, ANGKA=17, NEWLINE=18, WS=19;
	public static final String[] tokenNames = {
		"<INVALID>", "'tampilkan'", "'buat'", "'iya'", "'tidak'", "'<-'", "','", 
		"'.'", "'#'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "STRING", "IDENTIFIER", 
		"ANGKA", "NEWLINE", "WS"
	};
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_tampilkan = 2, RULE_assignment = 3, 
		RULE_exprList = 4, RULE_arguments = 5, RULE_expr = 6, RULE_qualifiedName = 7;
	public static final String[] ruleNames = {
		"file", "statement", "tampilkan", "assignment", "exprList", "arguments", 
		"expr", "qualifiedName"
	};

	@Override
	public String getGrammarFileName() { return "BahasaKu.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BahasaKuParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(BahasaKuParser.NEWLINE); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode NEWLINE(int i) {
			return getToken(BahasaKuParser.NEWLINE, i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(16); statement();
					setState(17); match(NEWLINE);
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(24); statement();
			setState(26);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(25); match(NEWLINE);
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

	public static class StatementContext extends ParserRuleContext {
		public TampilkanContext tampilkan() {
			return getRuleContext(TampilkanContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(31);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); tampilkan();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29); expr(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30); assignment();
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

	public static class TampilkanContext extends ParserRuleContext {
		public TerminalNode TAMPILKAN() { return getToken(BahasaKuParser.TAMPILKAN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TampilkanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tampilkan; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitTampilkan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TampilkanContext tampilkan() throws RecognitionException {
		TampilkanContext _localctx = new TampilkanContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tampilkan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(TAMPILKAN);
			setState(34); expr(0);
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

	public static class AssignmentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BahasaKuParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(BahasaKuParser.ASSIGNMENT, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(IDENTIFIER);
			setState(37); match(ASSIGNMENT);
			setState(38); expr(0);
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

	public static class ExprListContext extends ParserRuleContext {
		public TerminalNode KOMA(int i) {
			return getToken(BahasaKuParser.KOMA, i);
		}
		public List<TerminalNode> KOMA() { return getTokens(BahasaKuParser.KOMA); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); expr(0);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KOMA) {
				{
				{
				setState(41); match(KOMA);
				setState(42); expr(0);
				}
				}
				setState(47);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode KURUNG_BUKA() { return getToken(BahasaKuParser.KURUNG_BUKA, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode KURUNG_TUTUP() { return getToken(BahasaKuParser.KURUNG_TUTUP, 0); }
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(KURUNG_BUKA);
			setState(50);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUAT) | (1L << BOOLEAN_TRUE) | (1L << BOOLEAN_FALSE) | (1L << STRING) | (1L << IDENTIFIER) | (1L << ANGKA))) != 0)) {
				{
				setState(49); exprList();
				}
			}

			setState(52); match(KURUNG_TUTUP);
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
		public int _p;
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class BuatObjectContext extends ExprContext {
		public TerminalNode BUAT() { return getToken(BahasaKuParser.BUAT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BuatObjectContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitBuatObject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AngkaContext extends ExprContext {
		public TerminalNode ANGKA() { return getToken(BahasaKuParser.ANGKA, 0); }
		public AngkaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitAngka(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PembagianContext extends ExprContext {
		public TerminalNode BAGI() { return getToken(BahasaKuParser.BAGI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PembagianContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitPembagian(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PerkalianContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode KALI() { return getToken(BahasaKuParser.KALI, 0); }
		public PerkalianContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitPerkalian(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PenguranganContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode KURANG() { return getToken(BahasaKuParser.KURANG, 0); }
		public PenguranganContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitPengurangan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(BahasaKuParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanTrueContext extends ExprContext {
		public TerminalNode BOOLEAN_TRUE() { return getToken(BahasaKuParser.BOOLEAN_TRUE, 0); }
		public BooleanTrueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitBooleanTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanFalseContext extends ExprContext {
		public TerminalNode BOOLEAN_FALSE() { return getToken(BahasaKuParser.BOOLEAN_FALSE, 0); }
		public BooleanFalseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitBooleanFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(BahasaKuParser.IDENTIFIER, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PanggilMethodContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SELF() { return getToken(BahasaKuParser.SELF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BahasaKuParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode TITIK() { return getToken(BahasaKuParser.TITIK, 0); }
		public PanggilMethodContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitPanggilMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PenjumlahanContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode TAMBAH() { return getToken(BahasaKuParser.TAMBAH, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PenjumlahanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitPenjumlahan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			switch (_input.LA(1)) {
			case BUAT:
				{
				_localctx = new BuatObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(55); match(BUAT);
				setState(56); qualifiedName();
				setState(57); arguments();
				}
				break;
			case ANGKA:
				{
				_localctx = new AngkaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59); match(ANGKA);
				}
				break;
			case BOOLEAN_TRUE:
				{
				_localctx = new BooleanTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); match(BOOLEAN_TRUE);
				}
				break;
			case BOOLEAN_FALSE:
				{
				_localctx = new BooleanFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); match(BOOLEAN_FALSE);
				}
				break;
			case STRING:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62); match(STRING);
				}
				break;
			case IDENTIFIER:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63); match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(82);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new PerkalianContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(67); match(KALI);
						setState(68); expr(10);
						}
						break;

					case 2:
						{
						_localctx = new PembagianContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(70); match(BAGI);
						setState(71); expr(9);
						}
						break;

					case 3:
						{
						_localctx = new PenjumlahanContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(73); match(TAMBAH);
						setState(74); expr(8);
						}
						break;

					case 4:
						{
						_localctx = new PenguranganContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(76); match(KURANG);
						setState(77); expr(7);
						}
						break;

					case 5:
						{
						_localctx = new PanggilMethodContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(79);
						((PanggilMethodContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TITIK || _la==SELF) ) {
							((PanggilMethodContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(80); match(IDENTIFIER);
						setState(81); arguments();
						}
						break;
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BahasaKuParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BahasaKuParser.IDENTIFIER); }
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BahasaKuVisitor ) return ((BahasaKuVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(IDENTIFIER);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TITIK) {
				{
				{
				setState(88); match(TITIK);
				setState(89); match(IDENTIFIER);
				}
				}
				setState(94);
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
		case 6: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 9 >= _localctx._p;

		case 1: return 8 >= _localctx._p;

		case 2: return 7 >= _localctx._p;

		case 3: return 6 >= _localctx._p;

		case 4: return 11 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\25b\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6.\n\6\f\6\16\6\61\13\6\3\7\3\7\5\7"+
		"\65\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bC\n\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bU\n\b\f"+
		"\b\16\bX\13\b\3\t\3\t\3\t\7\t]\n\t\f\t\16\t`\13\t\3\t\2\n\2\4\6\b\n\f"+
		"\16\20\2\3\3\2\t\nj\2\27\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b&\3\2\2\2\n*\3"+
		"\2\2\2\f\62\3\2\2\2\16B\3\2\2\2\20Y\3\2\2\2\22\23\5\4\3\2\23\24\7\24\2"+
		"\2\24\26\3\2\2\2\25\22\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2"+
		"\2\30\32\3\2\2\2\31\27\3\2\2\2\32\34\5\4\3\2\33\35\7\24\2\2\34\33\3\2"+
		"\2\2\34\35\3\2\2\2\35\3\3\2\2\2\36\"\5\6\4\2\37\"\5\16\b\2 \"\5\b\5\2"+
		"!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"\5\3\2\2\2#$\7\3\2\2$%\5\16\b\2%\7"+
		"\3\2\2\2&\'\7\22\2\2\'(\7\7\2\2()\5\16\b\2)\t\3\2\2\2*/\5\16\b\2+,\7\b"+
		"\2\2,.\5\16\b\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\13\3\2"+
		"\2\2\61/\3\2\2\2\62\64\7\17\2\2\63\65\5\n\6\2\64\63\3\2\2\2\64\65\3\2"+
		"\2\2\65\66\3\2\2\2\66\67\7\20\2\2\67\r\3\2\2\289\b\b\1\29:\7\4\2\2:;\5"+
		"\20\t\2;<\5\f\7\2<C\3\2\2\2=C\7\23\2\2>C\7\5\2\2?C\7\6\2\2@C\7\21\2\2"+
		"AC\7\22\2\2B8\3\2\2\2B=\3\2\2\2B>\3\2\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2"+
		"\2CV\3\2\2\2DE\6\b\2\3EF\7\r\2\2FU\5\16\b\2GH\6\b\3\3HI\7\16\2\2IU\5\16"+
		"\b\2JK\6\b\4\3KL\7\13\2\2LU\5\16\b\2MN\6\b\5\3NO\7\f\2\2OU\5\16\b\2PQ"+
		"\6\b\6\3QR\t\2\2\2RS\7\22\2\2SU\5\f\7\2TD\3\2\2\2TG\3\2\2\2TJ\3\2\2\2"+
		"TM\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\17\3\2\2\2XV\3\2\2"+
		"\2Y^\7\22\2\2Z[\7\t\2\2[]\7\22\2\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3"+
		"\2\2\2_\21\3\2\2\2`^\3\2\2\2\13\27\34!/\64BTV^";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}