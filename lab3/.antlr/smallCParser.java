// Generated from /homes/c/cheny811/ece467/lab3/smallC.g4 by ANTLR 4.13.1

#include "ASTNodes.h"
#include <iostream>
#include <string>

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class smallCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, BOOL=33, ID=34, INT=35, WS=36, COMMENT=37;
	public static final int
		RULE_program = 0, RULE_preamble = 1, RULE_decls = 2, RULE_scalarDeclList = 3, 
		RULE_scalarDecl = 4, RULE_arrDeclList = 5, RULE_arrDecl = 6, RULE_fcnProto = 7, 
		RULE_fcnDecl = 8, RULE_varType = 9, RULE_retType = 10, RULE_constant = 11, 
		RULE_boolConst = 12, RULE_scope = 13, RULE_stmt = 14, RULE_assignStmt = 15, 
		RULE_ifStmt = 16, RULE_whileStmt = 17, RULE_retStmt = 18, RULE_expr = 19, 
		RULE_intExpr = 20, RULE_var = 21, RULE_params = 22, RULE_paramEntry = 23, 
		RULE_paramList = 24, RULE_args = 25, RULE_argEntry = 26, RULE_argList = 27, 
		RULE_varName = 28, RULE_arrName = 29, RULE_fcnName = 30, RULE_intConst = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "preamble", "decls", "scalarDeclList", "scalarDecl", "arrDeclList", 
			"arrDecl", "fcnProto", "fcnDecl", "varType", "retType", "constant", "boolConst", 
			"scope", "stmt", "assignStmt", "ifStmt", "whileStmt", "retStmt", "expr", 
			"intExpr", "var", "params", "paramEntry", "paramList", "args", "argEntry", 
			"argList", "varName", "arrName", "fcnName", "intConst"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#include'", "'\"scio.h\"'", "';'", "'['", "']'", "'('", "')'", 
			"'bool'", "'int'", "'void'", "'{'", "'}'", "'='", "'if'", "'else'", "'while'", 
			"'return'", "'!'", "'-'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", 
			"'||'", "'&&'", "'*'", "'/'", "'+'", "'[]'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "BOOL", "ID", "INT", 
			"WS", "COMMENT"
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
	public String getGrammarFileName() { return "smallC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public smallCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public smallc::ProgramNode * prg;
		public DeclsContext decls;
		public TerminalNode EOF() { return getToken(smallCParser.EOF, 0); }
		public PreambleContext preamble() {
			return getRuleContext(PreambleContext.class,0);
		}
		public List<DeclsContext> decls() {
			return getRuleContexts(DeclsContext.class);
		}
		public DeclsContext decls(int i) {
			return getRuleContext(DeclsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);

		    ((ProgramContext)_localctx).prg =  new smallc::ProgramNode();
		    _localctx.prg->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(64);
				preamble();
				_localctx.prg->setIo(true);
				}
				break;
			case EOF:
			case T__7:
			case T__8:
			case T__9:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) {
				{
				{
				setState(70);
				((ProgramContext)_localctx).decls = decls();

				   for(unsigned int i = 0; i < ((ProgramContext)_localctx).decls.declarations.size();i++)
				   _localctx.prg->addChild(((ProgramContext)_localctx).decls.declarations[i]);

				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PreambleContext extends ParserRuleContext {
		public PreambleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preamble; }
	}

	public final PreambleContext preamble() throws RecognitionException {
		PreambleContext _localctx = new PreambleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_preamble);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__0);
			setState(81);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclsContext extends ParserRuleContext {
		public std::vector<smallc::DeclNode *> declarations;
		public ScalarDeclListContext scalarDeclList;
		public ScalarDeclListContext scalarDeclList() {
			return getRuleContext(ScalarDeclListContext.class,0);
		}
		public ArrDeclListContext arrDeclList() {
			return getRuleContext(ArrDeclListContext.class,0);
		}
		public FcnProtoContext fcnProto() {
			return getRuleContext(FcnProtoContext.class,0);
		}
		public FcnDeclContext fcnDecl() {
			return getRuleContext(FcnDeclContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decls);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				((DeclsContext)_localctx).scalarDeclList = scalarDeclList();

				    declarations.reserve(((DeclsContext)_localctx).scalarDeclList.scalars.size());
				    for(smallc::DeclNode * decl : ((DeclsContext)_localctx).scalarDeclList.scalars){
				        declarations.push_back(decl);
				    }

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				arrDeclList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				fcnProto();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				fcnDecl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScalarDeclListContext extends ParserRuleContext {
		public std::vector<smallc::ScalarDeclNode*> scalars;
		public ScalarDeclContext scalarDecl;
		public ScalarDeclListContext scalarDeclList;
		public ScalarDeclContext scalarDecl() {
			return getRuleContext(ScalarDeclContext.class,0);
		}
		public ScalarDeclListContext scalarDeclList() {
			return getRuleContext(ScalarDeclListContext.class,0);
		}
		public ScalarDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarDeclList; }
	}

	public final ScalarDeclListContext scalarDeclList() throws RecognitionException {
		ScalarDeclListContext _localctx = new ScalarDeclListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_scalarDeclList);
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				((ScalarDeclListContext)_localctx).scalarDecl = scalarDecl();

				        _localctx.scalars.push_back(((ScalarDeclListContext)_localctx).scalarDecl.decl);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				((ScalarDeclListContext)_localctx).scalarDecl = scalarDecl();

				        _localctx.scalars.push_back(((ScalarDeclListContext)_localctx).scalarDecl.decl);
				    
				setState(96);
				((ScalarDeclListContext)_localctx).scalarDeclList = scalarDeclList();

				        for(unsigned int i = 0; i < ((ScalarDeclListContext)_localctx).scalarDeclList.scalars.size(); i++)
				            _localctx.scalars.push_back(((ScalarDeclListContext)_localctx).scalarDeclList.scalars[i]);
				    
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScalarDeclContext extends ParserRuleContext {
		public smallc::ScalarDeclNode* decl;
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public ScalarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarDecl; }
	}

	public final ScalarDeclContext scalarDecl() throws RecognitionException {
		ScalarDeclContext _localctx = new ScalarDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scalarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			varType();
			setState(102);
			varName();
			setState(103);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrDeclListContext extends ParserRuleContext {
		public ArrDeclContext arrDecl() {
			return getRuleContext(ArrDeclContext.class,0);
		}
		public ArrDeclListContext arrDeclList() {
			return getRuleContext(ArrDeclListContext.class,0);
		}
		public ArrDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrDeclList; }
	}

	public final ArrDeclListContext arrDeclList() throws RecognitionException {
		ArrDeclListContext _localctx = new ArrDeclListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrDeclList);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				arrDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				arrDecl();
				setState(107);
				arrDeclList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrDeclContext extends ParserRuleContext {
		public smallc::ScalarDeclNode* decl;
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ArrNameContext arrName() {
			return getRuleContext(ArrNameContext.class,0);
		}
		public IntConstContext intConst() {
			return getRuleContext(IntConstContext.class,0);
		}
		public ArrDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrDecl; }
	}

	public final ArrDeclContext arrDecl() throws RecognitionException {
		ArrDeclContext _localctx = new ArrDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			varType();
			setState(112);
			arrName();
			setState(113);
			match(T__3);
			setState(114);
			intConst();
			setState(115);
			match(T__4);
			setState(116);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FcnProtoContext extends ParserRuleContext {
		public RetTypeContext retType() {
			return getRuleContext(RetTypeContext.class,0);
		}
		public FcnNameContext fcnName() {
			return getRuleContext(FcnNameContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FcnProtoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fcnProto; }
	}

	public final FcnProtoContext fcnProto() throws RecognitionException {
		FcnProtoContext _localctx = new FcnProtoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fcnProto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			retType();
			setState(119);
			fcnName();
			setState(120);
			match(T__5);
			setState(121);
			params();
			setState(122);
			match(T__6);
			setState(123);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FcnDeclContext extends ParserRuleContext {
		public RetTypeContext retType() {
			return getRuleContext(RetTypeContext.class,0);
		}
		public FcnNameContext fcnName() {
			return getRuleContext(FcnNameContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public FcnDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fcnDecl; }
	}

	public final FcnDeclContext fcnDecl() throws RecognitionException {
		FcnDeclContext _localctx = new FcnDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fcnDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			retType();
			setState(126);
			fcnName();
			setState(127);
			match(T__5);
			setState(128);
			params();
			setState(129);
			match(T__6);
			setState(130);
			scope();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarTypeContext extends ParserRuleContext {
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RetTypeContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public RetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retType; }
	}

	public final RetTypeContext retType() throws RecognitionException {
		RetTypeContext _localctx = new RetTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_retType);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(T__9);
				}
				break;
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				varType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public BoolConstContext boolConst() {
			return getRuleContext(BoolConstContext.class,0);
		}
		public IntConstContext intConst() {
			return getRuleContext(IntConstContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constant);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				boolConst();
				}
				break;
			case T__18:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				intConst();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BoolConstContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(smallCParser.BOOL, 0); }
		public BoolConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolConst; }
	}

	public final BoolConstContext boolConst() throws RecognitionException {
		BoolConstContext _localctx = new BoolConstContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_boolConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(BOOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScopeContext extends ParserRuleContext {
		public smallc::ScopeNode* scope_;
		public ScalarDeclContext scalarDecl;
		public ArrDeclContext arrDecl;
		public StmtContext stmt;
		public List<ScalarDeclContext> scalarDecl() {
			return getRuleContexts(ScalarDeclContext.class);
		}
		public ScalarDeclContext scalarDecl(int i) {
			return getRuleContext(ScalarDeclContext.class,i);
		}
		public List<ArrDeclContext> arrDecl() {
			return getRuleContexts(ArrDeclContext.class);
		}
		public ArrDeclContext arrDecl(int i) {
			return getRuleContext(ArrDeclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_scope);

		    ((ScopeContext)_localctx).scope_ =  new smallc::ScopeNode();
		    _localctx.scope_->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__10);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==T__8) {
				{
				setState(151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(145);
					((ScopeContext)_localctx).scalarDecl = scalarDecl();
					_localctx.scope_->addDeclaration(((ScopeContext)_localctx).scalarDecl.decl);
					}
					break;
				case 2:
					{
					setState(148);
					((ScopeContext)_localctx).arrDecl = arrDecl();
					_localctx.scope_->addDeclaration(((ScopeContext)_localctx).arrDecl.decl);
					}
					break;
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 60130543680L) != 0)) {
				{
				{
				setState(156);
				((ScopeContext)_localctx).stmt = stmt();
				_localctx.scope_->addChild(((ScopeContext)_localctx).stmt.statement);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public smallc::StmtNode* statement;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public RetStmtContext retStmt() {
			return getRuleContext(RetStmtContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmt);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				expr(0);
				setState(167);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				retStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(173);
				scope();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			var();
			setState(177);
			match(T__12);
			setState(178);
			expr(0);
			setState(179);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public StmtContext then;
		public StmtContext e;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStmt);
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__13);
				setState(182);
				match(T__5);
				setState(183);
				expr(0);
				setState(184);
				match(T__6);
				setState(185);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(T__13);
				setState(188);
				match(T__5);
				setState(189);
				expr(0);
				setState(190);
				match(T__6);
				setState(191);
				((IfStmtContext)_localctx).then = stmt();
				setState(192);
				match(T__14);
				setState(193);
				((IfStmtContext)_localctx).e = stmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__15);
			setState(198);
			match(T__5);
			setState(199);
			expr(0);
			setState(200);
			match(T__6);
			setState(201);
			stmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RetStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RetStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retStmt; }
	}

	public final RetStmtContext retStmt() throws RecognitionException {
		RetStmtContext _localctx = new RetStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_retStmt);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(T__16);
				setState(204);
				expr(0);
				setState(205);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(T__16);
				setState(208);
				match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext l;
		public Token op;
		public ExprContext r;
		public IntExprContext intExpr() {
			return getRuleContext(IntExprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FcnNameContext fcnName() {
			return getRuleContext(FcnNameContext.class,0);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(212);
				intExpr(0);
				}
				break;
			case 2:
				{
				setState(213);
				match(T__5);
				setState(214);
				expr(0);
				setState(215);
				match(T__6);
				}
				break;
			case 3:
				{
				setState(217);
				fcnName();
				setState(218);
				match(T__5);
				setState(219);
				args();
				setState(220);
				match(T__6);
				}
				break;
			case 4:
				{
				setState(222);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(223);
				expr(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(238);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(227);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						((ExprContext)_localctx).r = expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(230);
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
						setState(231);
						((ExprContext)_localctx).r = expr(4);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(233);
						((ExprContext)_localctx).op = match(T__25);
						setState(234);
						((ExprContext)_localctx).r = expr(3);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(236);
						((ExprContext)_localctx).op = match(T__26);
						setState(237);
						((ExprContext)_localctx).r = expr(2);
						}
						break;
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends ParserRuleContext {
		public IntExprContext l;
		public Token op;
		public IntExprContext r;
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public List<IntExprContext> intExpr() {
			return getRuleContexts(IntExprContext.class);
		}
		public IntExprContext intExpr(int i) {
			return getRuleContext(IntExprContext.class,i);
		}
		public IntExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intExpr; }
	}

	public final IntExprContext intExpr() throws RecognitionException {
		return intExpr(0);
	}

	private IntExprContext intExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IntExprContext _localctx = new IntExprContext(_ctx, _parentState);
		IntExprContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_intExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(244);
				var();
				}
				break;
			case T__18:
			case BOOL:
			case INT:
				{
				setState(245);
				constant();
				}
				break;
			case T__5:
				{
				setState(246);
				match(T__5);
				setState(247);
				intExpr(0);
				setState(248);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new IntExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpr);
						setState(252);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(253);
						((IntExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((IntExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						((IntExprContext)_localctx).r = intExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new IntExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpr);
						setState(255);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(256);
						((IntExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__29) ) {
							((IntExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(257);
						((IntExprContext)_localctx).r = intExpr(3);
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public ArrNameContext arrName() {
			return getRuleContext(ArrNameContext.class,0);
		}
		public IntExprContext intExpr() {
			return getRuleContext(IntExprContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_var);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				varName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				arrName();
				setState(265);
				match(T__3);
				setState(266);
				intExpr(0);
				setState(267);
				match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_params);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				paramList();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamEntryContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public ArrNameContext arrName() {
			return getRuleContext(ArrNameContext.class,0);
		}
		public ParamEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramEntry; }
	}

	public final ParamEntryContext paramEntry() throws RecognitionException {
		ParamEntryContext _localctx = new ParamEntryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_paramEntry);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				varType();
				setState(276);
				varName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				varType();
				setState(279);
				arrName();
				setState(280);
				match(T__30);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public ParamEntryContext paramEntry() {
			return getRuleContext(ParamEntryContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_paramList);
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				paramEntry();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				paramEntry();
				setState(286);
				match(T__31);
				setState(287);
				paramList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_args);
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__17:
			case T__18:
			case BOOL:
			case ID:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				argList();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgEntryContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argEntry; }
	}

	public final ArgEntryContext argEntry() throws RecognitionException {
		ArgEntryContext _localctx = new ArgEntryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_argEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public ArgEntryContext argEntry() {
			return getRuleContext(ArgEntryContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_argList);
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				argEntry();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				argEntry();
				setState(299);
				match(T__31);
				setState(300);
				argList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallCParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallCParser.ID, 0); }
		public ArrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrName; }
	}

	public final ArrNameContext arrName() throws RecognitionException {
		ArrNameContext _localctx = new ArrNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FcnNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallCParser.ID, 0); }
		public FcnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fcnName; }
	}

	public final FcnNameContext fcnName() throws RecognitionException {
		FcnNameContext _localctx = new FcnNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_fcnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntConstContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(smallCParser.INT, 0); }
		public IntConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intConst; }
	}

	public final IntConstContext intConst() throws RecognitionException {
		IntConstContext _localctx = new IntConstContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_intConst);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(INT);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(T__18);
				setState(312);
				match(INT);
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
		case 19:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 20:
			return intExpr_sempred((IntExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean intExpr_sempred(IntExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u013c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000E\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"J\b\u0000\n\u0000\f\u0000M\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002Z\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003d\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005n\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u0089\b\n\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u008d\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0098\b\r\n\r\f\r\u009b"+
		"\t\r\u0001\r\u0001\r\u0001\r\u0005\r\u00a0\b\r\n\r\f\r\u00a3\t\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00af\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00c4\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00d2\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u00e1\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u00ef\b\u0013\n\u0013\f\u0013\u00f2\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u00fb\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0103\b\u0014\n\u0014\f\u0014"+
		"\u0106\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u010e\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0112\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u011b\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0122\b\u0018\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0126\b\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u012f\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u013a\b\u001f\u0001\u001f"+
		"\u0000\u0002&( \u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>\u0000\u0006\u0001\u0000"+
		"\b\t\u0001\u0000\u0012\u0013\u0001\u0000\u0014\u0017\u0001\u0000\u0018"+
		"\u0019\u0001\u0000\u001c\u001d\u0002\u0000\u0013\u0013\u001e\u001e\u0140"+
		"\u0000D\u0001\u0000\u0000\u0000\u0002P\u0001\u0000\u0000\u0000\u0004Y"+
		"\u0001\u0000\u0000\u0000\u0006c\u0001\u0000\u0000\u0000\be\u0001\u0000"+
		"\u0000\u0000\nm\u0001\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000\u000e"+
		"v\u0001\u0000\u0000\u0000\u0010}\u0001\u0000\u0000\u0000\u0012\u0084\u0001"+
		"\u0000\u0000\u0000\u0014\u0088\u0001\u0000\u0000\u0000\u0016\u008c\u0001"+
		"\u0000\u0000\u0000\u0018\u008e\u0001\u0000\u0000\u0000\u001a\u0090\u0001"+
		"\u0000\u0000\u0000\u001c\u00ae\u0001\u0000\u0000\u0000\u001e\u00b0\u0001"+
		"\u0000\u0000\u0000 \u00c3\u0001\u0000\u0000\u0000\"\u00c5\u0001\u0000"+
		"\u0000\u0000$\u00d1\u0001\u0000\u0000\u0000&\u00e0\u0001\u0000\u0000\u0000"+
		"(\u00fa\u0001\u0000\u0000\u0000*\u010d\u0001\u0000\u0000\u0000,\u0111"+
		"\u0001\u0000\u0000\u0000.\u011a\u0001\u0000\u0000\u00000\u0121\u0001\u0000"+
		"\u0000\u00002\u0125\u0001\u0000\u0000\u00004\u0127\u0001\u0000\u0000\u0000"+
		"6\u012e\u0001\u0000\u0000\u00008\u0130\u0001\u0000\u0000\u0000:\u0132"+
		"\u0001\u0000\u0000\u0000<\u0134\u0001\u0000\u0000\u0000>\u0139\u0001\u0000"+
		"\u0000\u0000@A\u0003\u0002\u0001\u0000AB\u0006\u0000\uffff\uffff\u0000"+
		"BE\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000"+
		"\u0000DC\u0001\u0000\u0000\u0000EK\u0001\u0000\u0000\u0000FG\u0003\u0004"+
		"\u0002\u0000GH\u0006\u0000\uffff\uffff\u0000HJ\u0001\u0000\u0000\u0000"+
		"IF\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000NO\u0005\u0000\u0000\u0001O\u0001\u0001\u0000\u0000\u0000"+
		"PQ\u0005\u0001\u0000\u0000QR\u0005\u0002\u0000\u0000R\u0003\u0001\u0000"+
		"\u0000\u0000ST\u0003\u0006\u0003\u0000TU\u0006\u0002\uffff\uffff\u0000"+
		"UZ\u0001\u0000\u0000\u0000VZ\u0003\n\u0005\u0000WZ\u0003\u000e\u0007\u0000"+
		"XZ\u0003\u0010\b\u0000YS\u0001\u0000\u0000\u0000YV\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000Z\u0005\u0001\u0000"+
		"\u0000\u0000[\\\u0003\b\u0004\u0000\\]\u0006\u0003\uffff\uffff\u0000]"+
		"d\u0001\u0000\u0000\u0000^_\u0003\b\u0004\u0000_`\u0006\u0003\uffff\uffff"+
		"\u0000`a\u0003\u0006\u0003\u0000ab\u0006\u0003\uffff\uffff\u0000bd\u0001"+
		"\u0000\u0000\u0000c[\u0001\u0000\u0000\u0000c^\u0001\u0000\u0000\u0000"+
		"d\u0007\u0001\u0000\u0000\u0000ef\u0003\u0012\t\u0000fg\u00038\u001c\u0000"+
		"gh\u0005\u0003\u0000\u0000h\t\u0001\u0000\u0000\u0000in\u0003\f\u0006"+
		"\u0000jk\u0003\f\u0006\u0000kl\u0003\n\u0005\u0000ln\u0001\u0000\u0000"+
		"\u0000mi\u0001\u0000\u0000\u0000mj\u0001\u0000\u0000\u0000n\u000b\u0001"+
		"\u0000\u0000\u0000op\u0003\u0012\t\u0000pq\u0003:\u001d\u0000qr\u0005"+
		"\u0004\u0000\u0000rs\u0003>\u001f\u0000st\u0005\u0005\u0000\u0000tu\u0005"+
		"\u0003\u0000\u0000u\r\u0001\u0000\u0000\u0000vw\u0003\u0014\n\u0000wx"+
		"\u0003<\u001e\u0000xy\u0005\u0006\u0000\u0000yz\u0003,\u0016\u0000z{\u0005"+
		"\u0007\u0000\u0000{|\u0005\u0003\u0000\u0000|\u000f\u0001\u0000\u0000"+
		"\u0000}~\u0003\u0014\n\u0000~\u007f\u0003<\u001e\u0000\u007f\u0080\u0005"+
		"\u0006\u0000\u0000\u0080\u0081\u0003,\u0016\u0000\u0081\u0082\u0005\u0007"+
		"\u0000\u0000\u0082\u0083\u0003\u001a\r\u0000\u0083\u0011\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0007\u0000\u0000\u0000\u0085\u0013\u0001\u0000\u0000"+
		"\u0000\u0086\u0089\u0005\n\u0000\u0000\u0087\u0089\u0003\u0012\t\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u0015\u0001\u0000\u0000\u0000\u008a\u008d\u0003\u0018\f\u0000\u008b"+
		"\u008d\u0003>\u001f\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u0017\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0005!\u0000\u0000\u008f\u0019\u0001\u0000\u0000\u0000\u0090\u0099\u0005"+
		"\u000b\u0000\u0000\u0091\u0092\u0003\b\u0004\u0000\u0092\u0093\u0006\r"+
		"\uffff\uffff\u0000\u0093\u0098\u0001\u0000\u0000\u0000\u0094\u0095\u0003"+
		"\f\u0006\u0000\u0095\u0096\u0006\r\uffff\uffff\u0000\u0096\u0098\u0001"+
		"\u0000\u0000\u0000\u0097\u0091\u0001\u0000\u0000\u0000\u0097\u0094\u0001"+
		"\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u00a1\u0001"+
		"\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009d\u0003"+
		"\u001c\u000e\u0000\u009d\u009e\u0006\r\uffff\uffff\u0000\u009e\u00a0\u0001"+
		"\u0000\u0000\u0000\u009f\u009c\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0005\f\u0000\u0000\u00a5\u001b\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0003&\u0013\u0000\u00a7\u00a8\u0005\u0003\u0000"+
		"\u0000\u00a8\u00af\u0001\u0000\u0000\u0000\u00a9\u00af\u0003\u001e\u000f"+
		"\u0000\u00aa\u00af\u0003 \u0010\u0000\u00ab\u00af\u0003\"\u0011\u0000"+
		"\u00ac\u00af\u0003$\u0012\u0000\u00ad\u00af\u0003\u001a\r\u0000\u00ae"+
		"\u00a6\u0001\u0000\u0000\u0000\u00ae\u00a9\u0001\u0000\u0000\u0000\u00ae"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ae\u00ab\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af"+
		"\u001d\u0001\u0000\u0000\u0000\u00b0\u00b1\u0003*\u0015\u0000\u00b1\u00b2"+
		"\u0005\r\u0000\u0000\u00b2\u00b3\u0003&\u0013\u0000\u00b3\u00b4\u0005"+
		"\u0003\u0000\u0000\u00b4\u001f\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005"+
		"\u000e\u0000\u0000\u00b6\u00b7\u0005\u0006\u0000\u0000\u00b7\u00b8\u0003"+
		"&\u0013\u0000\u00b8\u00b9\u0005\u0007\u0000\u0000\u00b9\u00ba\u0003\u001c"+
		"\u000e\u0000\u00ba\u00c4\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u000e"+
		"\u0000\u0000\u00bc\u00bd\u0005\u0006\u0000\u0000\u00bd\u00be\u0003&\u0013"+
		"\u0000\u00be\u00bf\u0005\u0007\u0000\u0000\u00bf\u00c0\u0003\u001c\u000e"+
		"\u0000\u00c0\u00c1\u0005\u000f\u0000\u0000\u00c1\u00c2\u0003\u001c\u000e"+
		"\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00b5\u0001\u0000\u0000"+
		"\u0000\u00c3\u00bb\u0001\u0000\u0000\u0000\u00c4!\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0005\u0010\u0000\u0000\u00c6\u00c7\u0005\u0006\u0000\u0000"+
		"\u00c7\u00c8\u0003&\u0013\u0000\u00c8\u00c9\u0005\u0007\u0000\u0000\u00c9"+
		"\u00ca\u0003\u001c\u000e\u0000\u00ca#\u0001\u0000\u0000\u0000\u00cb\u00cc"+
		"\u0005\u0011\u0000\u0000\u00cc\u00cd\u0003&\u0013\u0000\u00cd\u00ce\u0005"+
		"\u0003\u0000\u0000\u00ce\u00d2\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005"+
		"\u0011\u0000\u0000\u00d0\u00d2\u0005\u0003\u0000\u0000\u00d1\u00cb\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2%\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0006\u0013\uffff\uffff\u0000\u00d4\u00e1\u0003"+
		"(\u0014\u0000\u00d5\u00d6\u0005\u0006\u0000\u0000\u00d6\u00d7\u0003&\u0013"+
		"\u0000\u00d7\u00d8\u0005\u0007\u0000\u0000\u00d8\u00e1\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0003<\u001e\u0000\u00da\u00db\u0005\u0006\u0000\u0000"+
		"\u00db\u00dc\u00032\u0019\u0000\u00dc\u00dd\u0005\u0007\u0000\u0000\u00dd"+
		"\u00e1\u0001\u0000\u0000\u0000\u00de\u00df\u0007\u0001\u0000\u0000\u00df"+
		"\u00e1\u0003&\u0013\u0005\u00e0\u00d3\u0001\u0000\u0000\u0000\u00e0\u00d5"+
		"\u0001\u0000\u0000\u0000\u00e0\u00d9\u0001\u0000\u0000\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00f0\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\n\u0004\u0000\u0000\u00e3\u00e4\u0007\u0002\u0000\u0000\u00e4\u00ef\u0003"+
		"&\u0013\u0005\u00e5\u00e6\n\u0003\u0000\u0000\u00e6\u00e7\u0007\u0003"+
		"\u0000\u0000\u00e7\u00ef\u0003&\u0013\u0004\u00e8\u00e9\n\u0002\u0000"+
		"\u0000\u00e9\u00ea\u0005\u001a\u0000\u0000\u00ea\u00ef\u0003&\u0013\u0003"+
		"\u00eb\u00ec\n\u0001\u0000\u0000\u00ec\u00ed\u0005\u001b\u0000\u0000\u00ed"+
		"\u00ef\u0003&\u0013\u0002\u00ee\u00e2\u0001\u0000\u0000\u0000\u00ee\u00e5"+
		"\u0001\u0000\u0000\u0000\u00ee\u00e8\u0001\u0000\u0000\u0000\u00ee\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\'\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4\u0006"+
		"\u0014\uffff\uffff\u0000\u00f4\u00fb\u0003*\u0015\u0000\u00f5\u00fb\u0003"+
		"\u0016\u000b\u0000\u00f6\u00f7\u0005\u0006\u0000\u0000\u00f7\u00f8\u0003"+
		"(\u0014\u0000\u00f8\u00f9\u0005\u0007\u0000\u0000\u00f9\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f3\u0001\u0000\u0000\u0000\u00fa\u00f5\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f6\u0001\u0000\u0000\u0000\u00fb\u0104\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fd\n\u0003\u0000\u0000\u00fd\u00fe\u0007\u0004\u0000"+
		"\u0000\u00fe\u0103\u0003(\u0014\u0004\u00ff\u0100\n\u0002\u0000\u0000"+
		"\u0100\u0101\u0007\u0005\u0000\u0000\u0101\u0103\u0003(\u0014\u0003\u0102"+
		"\u00fc\u0001\u0000\u0000\u0000\u0102\u00ff\u0001\u0000\u0000\u0000\u0103"+
		"\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0001\u0000\u0000\u0000\u0105)\u0001\u0000\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0107\u010e\u00038\u001c\u0000\u0108\u0109\u0003"+
		":\u001d\u0000\u0109\u010a\u0005\u0004\u0000\u0000\u010a\u010b\u0003(\u0014"+
		"\u0000\u010b\u010c\u0005\u0005\u0000\u0000\u010c\u010e\u0001\u0000\u0000"+
		"\u0000\u010d\u0107\u0001\u0000\u0000\u0000\u010d\u0108\u0001\u0000\u0000"+
		"\u0000\u010e+\u0001\u0000\u0000\u0000\u010f\u0112\u00030\u0018\u0000\u0110"+
		"\u0112\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0111"+
		"\u0110\u0001\u0000\u0000\u0000\u0112-\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0003\u0012\t\u0000\u0114\u0115\u00038\u001c\u0000\u0115\u011b\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0003\u0012\t\u0000\u0117\u0118\u0003:"+
		"\u001d\u0000\u0118\u0119\u0005\u001f\u0000\u0000\u0119\u011b\u0001\u0000"+
		"\u0000\u0000\u011a\u0113\u0001\u0000\u0000\u0000\u011a\u0116\u0001\u0000"+
		"\u0000\u0000\u011b/\u0001\u0000\u0000\u0000\u011c\u0122\u0003.\u0017\u0000"+
		"\u011d\u011e\u0003.\u0017\u0000\u011e\u011f\u0005 \u0000\u0000\u011f\u0120"+
		"\u00030\u0018\u0000\u0120\u0122\u0001\u0000\u0000\u0000\u0121\u011c\u0001"+
		"\u0000\u0000\u0000\u0121\u011d\u0001\u0000\u0000\u0000\u01221\u0001\u0000"+
		"\u0000\u0000\u0123\u0126\u00036\u001b\u0000\u0124\u0126\u0001\u0000\u0000"+
		"\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0124\u0001\u0000\u0000"+
		"\u0000\u01263\u0001\u0000\u0000\u0000\u0127\u0128\u0003&\u0013\u0000\u0128"+
		"5\u0001\u0000\u0000\u0000\u0129\u012f\u00034\u001a\u0000\u012a\u012b\u0003"+
		"4\u001a\u0000\u012b\u012c\u0005 \u0000\u0000\u012c\u012d\u00036\u001b"+
		"\u0000\u012d\u012f\u0001\u0000\u0000\u0000\u012e\u0129\u0001\u0000\u0000"+
		"\u0000\u012e\u012a\u0001\u0000\u0000\u0000\u012f7\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0005\"\u0000\u0000\u01319\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0005\"\u0000\u0000\u0133;\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0005\"\u0000\u0000\u0135=\u0001\u0000\u0000\u0000\u0136\u013a\u0005"+
		"#\u0000\u0000\u0137\u0138\u0005\u0013\u0000\u0000\u0138\u013a\u0005#\u0000"+
		"\u0000\u0139\u0136\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000"+
		"\u0000\u013a?\u0001\u0000\u0000\u0000\u001aDKYcm\u0088\u008c\u0097\u0099"+
		"\u00a1\u00ae\u00c3\u00d1\u00e0\u00ee\u00f0\u00fa\u0102\u0104\u010d\u0111"+
		"\u011a\u0121\u0125\u012e\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}