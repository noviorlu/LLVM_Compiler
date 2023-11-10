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
		    _localctx.prg->setRoot(_localctx.prg);

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

				    for(smallc::DeclNode * decl : ((ProgramContext)_localctx).decls.declarations)
				        _localctx.prg->addDeclaration(decl);

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
		public ArrDeclListContext arrDeclList;
		public FcnProtoContext fcnProto;
		public FcnDeclContext fcnDecl;
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				((DeclsContext)_localctx).scalarDeclList = scalarDeclList();

				        for(smallc::DeclNode * scalardecl : ((DeclsContext)_localctx).scalarDeclList.scalardecls)
				            _localctx.declarations.push_back(scalardecl);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((DeclsContext)_localctx).arrDeclList = arrDeclList();

				        for(smallc::DeclNode * arrdecl : ((DeclsContext)_localctx).arrDeclList.arrdecls)
				            _localctx.declarations.push_back(arrdecl);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				((DeclsContext)_localctx).fcnProto = fcnProto();

				        _localctx.declarations.push_back(((DeclsContext)_localctx).fcnProto.fcndeclaration);
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				((DeclsContext)_localctx).fcnDecl = fcnDecl();

				        _localctx.declarations.push_back(((DeclsContext)_localctx).fcnDecl.fcndeclaration);
				    
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
		public std::vector<smallc::ScalarDeclNode*> scalardecls;
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
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((ScalarDeclListContext)_localctx).scalarDecl = scalarDecl();

				        _localctx.scalardecls.push_back(((ScalarDeclListContext)_localctx).scalarDecl.scalardecl);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				((ScalarDeclListContext)_localctx).scalarDecl = scalarDecl();
				setState(101);
				((ScalarDeclListContext)_localctx).scalarDeclList = scalarDeclList();

				        _localctx.scalardecls.push_back(((ScalarDeclListContext)_localctx).scalarDecl.scalardecl);
				        for(smallc::ScalarDeclNode* decl : ((ScalarDeclListContext)_localctx).scalarDeclList.scalardecls)
				            _localctx.scalardecls.push_back(decl);
				    
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
		public smallc::ScalarDeclNode* scalardecl;
		public VarTypeContext varType;
		public VarNameContext varName;
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

		    ((ScalarDeclContext)_localctx).scalardecl =  new smallc::ScalarDeclNode();
		    _localctx.scalardecl->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			((ScalarDeclContext)_localctx).varType = varType();
			setState(107);
			((ScalarDeclContext)_localctx).varName = varName();
			setState(108);
			match(T__2);

			        _localctx.scalardecl->setType(((ScalarDeclContext)_localctx).varType.type);
			        _localctx.scalardecl->setName(((ScalarDeclContext)_localctx).varName.name);
			    
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
		public std::vector<smallc::ArrayDeclNode *> arrdecls;
		public ArrDeclContext arrDecl;
		public ArrDeclListContext arrDeclList;
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				((ArrDeclListContext)_localctx).arrDecl = arrDecl();
				 
				        _localctx.arrdecls.push_back(((ArrDeclListContext)_localctx).arrDecl.arrdecl);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				((ArrDeclListContext)_localctx).arrDecl = arrDecl();
				setState(115);
				((ArrDeclListContext)_localctx).arrDeclList = arrDeclList();

				        _localctx.arrdecls.push_back(((ArrDeclListContext)_localctx).arrDecl.arrdecl);
				        for(smallc::ArrayDeclNode* decl : ((ArrDeclListContext)_localctx).arrDeclList.arrdecls)
				            _localctx.arrdecls.push_back(decl);
				    
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
		public smallc::ArrayDeclNode* arrdecl;
		public smallc::ArrayTypeNode * type;
		public VarTypeContext varType;
		public ArrNameContext arrName;
		public IntConstContext intConst;
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
			setState(120);
			((ArrDeclContext)_localctx).varType = varType();
			setState(121);
			((ArrDeclContext)_localctx).arrName = arrName();
			setState(122);
			match(T__3);
			setState(123);
			((ArrDeclContext)_localctx).intConst = intConst();
			setState(124);
			match(T__4);
			setState(125);
			match(T__2);

			        ((ArrDeclContext)_localctx).type =  new smallc::ArrayTypeNode(((ArrDeclContext)_localctx).varType.type, ((ArrDeclContext)_localctx).intConst.intconst->getVal());
			        ((ArrDeclContext)_localctx).arrdecl =  new smallc::ArrayDeclNode(_localctx.type, ((ArrDeclContext)_localctx).arrName.name);
			        _localctx.arrdecl->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
			    
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
		public smallc::FunctionDeclNode * fcndeclaration;
		public RetTypeContext retType;
		public FcnNameContext fcnName;
		public ParamsContext params;
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

		    ((FcnProtoContext)_localctx).fcndeclaration =  new smallc::FunctionDeclNode();
		    _localctx.fcndeclaration->setProto(true);
		    _localctx.fcndeclaration->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((FcnProtoContext)_localctx).retType = retType();
			setState(129);
			((FcnProtoContext)_localctx).fcnName = fcnName();
			setState(130);
			match(T__5);
			setState(131);
			((FcnProtoContext)_localctx).params = params();
			setState(132);
			match(T__6);
			setState(133);
			match(T__2);

			        _localctx.fcndeclaration->setRetType(((FcnProtoContext)_localctx).retType.rettype);
			        _localctx.fcndeclaration->setName(((FcnProtoContext)_localctx).fcnName.name);
			        _localctx.fcndeclaration->setParameter(((FcnProtoContext)_localctx).params.paramlist);
			    
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
		public smallc::FunctionDeclNode * fcndeclaration;
		public RetTypeContext retType;
		public FcnNameContext fcnName;
		public ParamsContext params;
		public ScopeContext scope;
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

		    ((FcnDeclContext)_localctx).fcndeclaration =  new smallc::FunctionDeclNode();
		    _localctx.fcndeclaration->setProto(false);
		    _localctx.fcndeclaration->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((FcnDeclContext)_localctx).retType = retType();
			setState(137);
			((FcnDeclContext)_localctx).fcnName = fcnName();
			setState(138);
			match(T__5);
			setState(139);
			((FcnDeclContext)_localctx).params = params();
			setState(140);
			match(T__6);
			setState(141);
			((FcnDeclContext)_localctx).scope = scope();

			        _localctx.fcndeclaration->setRetType(((FcnDeclContext)_localctx).retType.rettype);
			        _localctx.fcndeclaration->setName(((FcnDeclContext)_localctx).fcnName.name);
			        _localctx.fcndeclaration->setParameter(((FcnDeclContext)_localctx).params.paramlist);
			        _localctx.fcndeclaration->setBody(((FcnDeclContext)_localctx).scope.scope_);
			    
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
		public smallc::PrimitiveTypeNode* type;
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varType);
		 
		    ((VarTypeContext)_localctx).type =  new smallc::PrimitiveTypeNode();
		    _localctx.type->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(T__7);

				        _localctx.type->setType(smallc::TypeNode::TypeEnum::Bool);
				    
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(T__8);

				        _localctx.type->setType(smallc::TypeNode::TypeEnum::Int);
				    
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
	public static class RetTypeContext extends ParserRuleContext {
		public smallc::PrimitiveTypeNode* rettype;
		public VarTypeContext varType;
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
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(T__9);

				        ((RetTypeContext)_localctx).rettype =  new smallc::PrimitiveTypeNode();
				        _localctx.rettype->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
				}
				break;
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				((RetTypeContext)_localctx).varType = varType();

				        ((RetTypeContext)_localctx).rettype =  ((RetTypeContext)_localctx).varType.type;
				    
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
		public smallc::ExprNode* expression;
		public BoolConstContext boolConst;
		public IntConstContext intConst;
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
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				((ConstantContext)_localctx).boolConst = boolConst();

				        ((ConstantContext)_localctx).expression =  new smallc::BoolExprNode(((ConstantContext)_localctx).boolConst.boolconst);
				        _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
				}
				break;
			case T__18:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				((ConstantContext)_localctx).intConst = intConst();

				        ((ConstantContext)_localctx).expression =  new smallc::IntExprNode(((ConstantContext)_localctx).intConst.intconst);
				        _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
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
		public smallc::BoolConstantNode* boolconst;
		public Token BOOL;
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
			setState(165);
			((BoolConstContext)_localctx).BOOL = match(BOOL);

			        ((BoolConstContext)_localctx).boolconst =  new smallc::BoolConstantNode((((BoolConstContext)_localctx).BOOL!=null?((BoolConstContext)_localctx).BOOL.getText():null));
			        _localctx.boolconst->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
			    
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
			setState(168);
			match(T__10);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==T__8) {
				{
				setState(175);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(169);
					((ScopeContext)_localctx).scalarDecl = scalarDecl();

					        _localctx.scope_->addDeclaration(((ScopeContext)_localctx).scalarDecl.scalardecl);

					    
					}
					break;
				case 2:
					{
					setState(172);
					((ScopeContext)_localctx).arrDecl = arrDecl();

					        _localctx.scope_->addDeclaration(((ScopeContext)_localctx).arrDecl.arrdecl);
					    
					}
					break;
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 60130543680L) != 0)) {
				{
				{
				setState(180);
				((ScopeContext)_localctx).stmt = stmt();

				        _localctx.scope_->addChild(((ScopeContext)_localctx).stmt.statement);
				    
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
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
		public AssignStmtContext assignStmt;
		public IfStmtContext ifStmt;
		public WhileStmtContext whileStmt;
		public RetStmtContext retStmt;
		public ScopeContext scope;
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
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				expr(0);
				setState(191);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				((StmtContext)_localctx).assignStmt = assignStmt();

				        ((StmtContext)_localctx).statement =  ((StmtContext)_localctx).assignStmt.assignstatement;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				((StmtContext)_localctx).ifStmt = ifStmt();

				        ((StmtContext)_localctx).statement =  ((StmtContext)_localctx).ifStmt.ifstatement;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				((StmtContext)_localctx).whileStmt = whileStmt();

				        ((StmtContext)_localctx).statement =  ((StmtContext)_localctx).whileStmt.whilestatement;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				((StmtContext)_localctx).retStmt = retStmt();

				        ((StmtContext)_localctx).statement =  ((StmtContext)_localctx).retStmt.returnstatement;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				((StmtContext)_localctx).scope = scope();

				        ((StmtContext)_localctx).statement =  ((StmtContext)_localctx).scope.scope_;
				    
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
		public smallc::AssignStmtNode* assignstatement;
		public VarContext var;
		public ExprContext expr;
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
		 
		    ((AssignStmtContext)_localctx).assignstatement =  new smallc::AssignStmtNode();
		    _localctx.assignstatement->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			((AssignStmtContext)_localctx).var = var();
			setState(211);
			match(T__12);
			setState(212);
			((AssignStmtContext)_localctx).expr = expr(0);
			setState(213);
			match(T__2);
			 
			        _localctx.assignstatement->setTarget(((AssignStmtContext)_localctx).var.expression);
			        _localctx.assignstatement->setValue(((AssignStmtContext)_localctx).expr.expression);
			    
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
		public smallc::IfStmtNode* ifstatement;
		public ExprContext expr;
		public StmtContext stmt;
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
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(T__13);
				setState(217);
				match(T__5);
				setState(218);
				((IfStmtContext)_localctx).expr = expr(0);
				setState(219);
				match(T__6);
				setState(220);
				((IfStmtContext)_localctx).stmt = stmt();

				        ((IfStmtContext)_localctx).ifstatement =  new smallc::IfStmtNode(((IfStmtContext)_localctx).expr.expression, ((IfStmtContext)_localctx).stmt.statement);
				        _localctx.ifstatement->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(T__13);
				setState(224);
				match(T__5);
				setState(225);
				((IfStmtContext)_localctx).expr = expr(0);
				setState(226);
				match(T__6);
				setState(227);
				((IfStmtContext)_localctx).then = stmt();
				setState(228);
				match(T__14);
				setState(229);
				((IfStmtContext)_localctx).e = stmt();

				        ((IfStmtContext)_localctx).ifstatement =  new smallc::IfStmtNode(((IfStmtContext)_localctx).expr.expression, ((IfStmtContext)_localctx).then.statement, ((IfStmtContext)_localctx).e.statement);
				        _localctx.ifstatement->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
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
		public smallc::WhileStmtNode* whilestatement;
		public ExprContext expr;
		public StmtContext stmt;
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
			setState(234);
			match(T__15);
			setState(235);
			match(T__5);
			setState(236);
			((WhileStmtContext)_localctx).expr = expr(0);
			setState(237);
			match(T__6);
			setState(238);
			((WhileStmtContext)_localctx).stmt = stmt();

			        ((WhileStmtContext)_localctx).whilestatement =  new smallc::WhileStmtNode(((WhileStmtContext)_localctx).expr.expression, ((WhileStmtContext)_localctx).stmt.statement);
			        _localctx.whilestatement->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
			    
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
		public smallc::ReturnStmtNode* returnstatement;
		public ExprContext expr;
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
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(T__16);
				setState(242);
				((RetStmtContext)_localctx).expr = expr(0);
				setState(243);
				match(T__2);
				 
				        ((RetStmtContext)_localctx).returnstatement =  new smallc::ReturnStmtNode(((RetStmtContext)_localctx).expr.expression);
				        _localctx.returnstatement->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(T__16);
				setState(247);
				match(T__2);
				 
				        ((RetStmtContext)_localctx).returnstatement =  new smallc::ReturnStmtNode();
				        _localctx.returnstatement->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
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
		public smallc::ExprNode* expression;
		public smallc::BinaryExprNode* tmp;
		public smallc::UnaryExprNode* tmp1;
		public ExprContext l;
		public IntExprContext intExpr;
		public ExprContext expr;
		public FcnNameContext fcnName;
		public ArgsContext args;
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
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(252);
				((ExprContext)_localctx).intExpr = intExpr(0);

				        ((ExprContext)_localctx).expression =  ((ExprContext)_localctx).intExpr.expression;
				    
				}
				break;
			case 2:
				{
				setState(255);
				match(T__5);
				setState(256);
				((ExprContext)_localctx).expr = expr(0);
				setState(257);
				match(T__6);

				        ((ExprContext)_localctx).expression =  ((ExprContext)_localctx).expr.expression;
				    
				}
				break;
			case 3:
				{
				setState(260);
				((ExprContext)_localctx).fcnName = fcnName();
				setState(261);
				match(T__5);
				setState(262);
				((ExprContext)_localctx).args = args();
				setState(263);
				match(T__6);

				        ((ExprContext)_localctx).expression =  new smallc::CallExprNode(((ExprContext)_localctx).fcnName.name, ((ExprContext)_localctx).args.arglist);
				        _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

				    
				}
				break;
			case 4:
				{
				setState(266);
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
				setState(267);
				((ExprContext)_localctx).expr = expr(5);

				        ((ExprContext)_localctx).tmp1 =  new smallc::UnaryExprNode(((ExprContext)_localctx).expr.expression);
				        _localctx.tmp1->setOpcode((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
				        ((ExprContext)_localctx).expression =  _localctx.tmp1;
				        _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(292);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(272);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(273);
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
						setState(274);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(5);

						                  ((ExprContext)_localctx).tmp =  new smallc::BinaryExprNode(((ExprContext)_localctx).l.expression, ((ExprContext)_localctx).r.expression);
						                  _localctx.tmp->setOpcode((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
						                  ((ExprContext)_localctx).expression =  _localctx.tmp;
						                  _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
						              
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(278);
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
						setState(279);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(4);

						                  ((ExprContext)_localctx).tmp =  new smallc::BinaryExprNode(((ExprContext)_localctx).l.expression, ((ExprContext)_localctx).r.expression);
						                  _localctx.tmp->setOpcode((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
						                  ((ExprContext)_localctx).expression =  _localctx.tmp;
						                  _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
						              
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(283);
						((ExprContext)_localctx).op = match(T__25);
						setState(284);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(3);

						                  ((ExprContext)_localctx).tmp =  new smallc::BinaryExprNode(((ExprContext)_localctx).l.expression, ((ExprContext)_localctx).r.expression);
						                  _localctx.tmp->setOpcode((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
						                  ((ExprContext)_localctx).expression =  _localctx.tmp;
						                  _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
						              
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(287);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(288);
						((ExprContext)_localctx).op = match(T__26);
						setState(289);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(2);

						                  ((ExprContext)_localctx).tmp =  new smallc::BinaryExprNode(((ExprContext)_localctx).l.expression, ((ExprContext)_localctx).r.expression);
						                  _localctx.tmp->setOpcode((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
						                  ((ExprContext)_localctx).expression =  _localctx.tmp;
						                  _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
						              
						}
						break;
					}
					} 
				}
				setState(296);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends ParserRuleContext {
		public smallc::ExprNode* expression;
		public smallc::BinaryExprNode* tmp;
		public IntExprContext l;
		public VarContext var;
		public ConstantContext constant;
		public IntExprContext intExpr;
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
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(298);
				((IntExprContext)_localctx).var = var();

				        ((IntExprContext)_localctx).expression =  ((IntExprContext)_localctx).var.expression;
				    
				}
				break;
			case T__18:
			case BOOL:
			case INT:
				{
				setState(301);
				((IntExprContext)_localctx).constant = constant();

				        ((IntExprContext)_localctx).expression =  ((IntExprContext)_localctx).constant.expression;
				    
				}
				break;
			case T__5:
				{
				setState(304);
				match(T__5);
				setState(305);
				((IntExprContext)_localctx).intExpr = intExpr(0);
				setState(306);
				match(T__6);

				        ((IntExprContext)_localctx).expression =  ((IntExprContext)_localctx).intExpr.expression;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(321);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new IntExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpr);
						setState(311);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(312);
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
						setState(313);
						((IntExprContext)_localctx).r = ((IntExprContext)_localctx).intExpr = intExpr(4);

						                  ((IntExprContext)_localctx).tmp =  new smallc::BinaryExprNode(((IntExprContext)_localctx).l.expression, ((IntExprContext)_localctx).r.expression);
						                  _localctx.tmp->setOpcode((((IntExprContext)_localctx).op!=null?((IntExprContext)_localctx).op.getText():null));
						                  ((IntExprContext)_localctx).expression =  _localctx.tmp;
						                  _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
						              
						}
						break;
					case 2:
						{
						_localctx = new IntExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpr);
						setState(316);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(317);
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
						setState(318);
						((IntExprContext)_localctx).r = ((IntExprContext)_localctx).intExpr = intExpr(3);

						                  ((IntExprContext)_localctx).tmp =  new smallc::BinaryExprNode(((IntExprContext)_localctx).l.expression, ((IntExprContext)_localctx).r.expression);
						                  _localctx.tmp->setOpcode((((IntExprContext)_localctx).op!=null?((IntExprContext)_localctx).op.getText():null));
						                  ((IntExprContext)_localctx).expression =  _localctx.tmp;
						                  _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
						              
						}
						break;
					}
					} 
				}
				setState(325);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public smallc::ReferenceExprNode* expression;
		public VarNameContext varName;
		public ArrNameContext arrName;
		public IntExprContext intExpr;
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

		    ((VarContext)_localctx).expression =  new smallc::ReferenceExprNode();
		    _localctx.expression->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				((VarContext)_localctx).varName = varName();

				        _localctx.expression->setIdent(((VarContext)_localctx).varName.name);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				((VarContext)_localctx).arrName = arrName();
				setState(330);
				match(T__3);
				setState(331);
				((VarContext)_localctx).intExpr = intExpr(0);
				setState(332);
				match(T__4);

				        _localctx.expression->setIdent(((VarContext)_localctx).arrName.name);
				        _localctx.expression->setIndex(static_cast<smallc::IntExprNode*>(((VarContext)_localctx).intExpr.expression));
				    
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
		public std::vector<smallc::ParameterNode*> paramlist;
		public ParamListContext paramList;
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
			setState(341);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				((ParamsContext)_localctx).paramList = paramList();
				 
				        ((ParamsContext)_localctx).paramlist =  ((ParamsContext)_localctx).paramList.paramlist;
				    
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
		public smallc::ParameterNode* paramentry;
		public smallc::PrimitiveTypeNode* savetype;
		public VarTypeContext varType;
		public VarNameContext varName;
		public ArrNameContext arrName;
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
		 
		    ((ParamEntryContext)_localctx).paramentry =  new smallc::ParameterNode();
		    _localctx.paramentry->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				((ParamEntryContext)_localctx).varType = varType();
				setState(344);
				((ParamEntryContext)_localctx).varName = varName();
				 
				        _localctx.paramentry->setType(((ParamEntryContext)_localctx).varType.type);
				        _localctx.paramentry->setIdent(((ParamEntryContext)_localctx).varName.name);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				((ParamEntryContext)_localctx).varType = varType();
				setState(348);
				((ParamEntryContext)_localctx).arrName = arrName();
				setState(349);
				match(T__30);
				 
				        ((ParamEntryContext)_localctx).savetype =  ((ParamEntryContext)_localctx).varType.type;
				        _localctx.paramentry->setIdent(((ParamEntryContext)_localctx).arrName.name);
				        _localctx.paramentry->setType(new smallc::ArrayTypeNode(_localctx.savetype));
				        _localctx.paramentry->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
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
		public std::vector<smallc::ParameterNode*> paramlist;
		public ParamEntryContext paramEntry;
		public ParamListContext paramList;
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
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				((ParamListContext)_localctx).paramEntry = paramEntry();
				 
				        _localctx.paramlist.push_back(((ParamListContext)_localctx).paramEntry.paramentry);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				((ParamListContext)_localctx).paramEntry = paramEntry();
				setState(358);
				match(T__31);
				setState(359);
				((ParamListContext)_localctx).paramList = paramList();
				 
				        _localctx.paramlist.push_back(((ParamListContext)_localctx).paramEntry.paramentry);
				        for(smallc::ParameterNode* param : ((ParamListContext)_localctx).paramList.paramlist)
				            _localctx.paramlist.push_back(param);
				    
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
		public std::vector<smallc::ArgumentNode*> arglist;
		public ArgListContext argList;
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
			setState(368);
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
				setState(364);
				((ArgsContext)_localctx).argList = argList();

				        ((ArgsContext)_localctx).arglist =  ((ArgsContext)_localctx).argList.arglist;
				    
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
		public smallc::ArgumentNode* arg;
		public ExprContext expr;
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
			setState(370);
			((ArgEntryContext)_localctx).expr = expr(0);
			 
			        ((ArgEntryContext)_localctx).arg =  new smallc::ArgumentNode(((ArgEntryContext)_localctx).expr.expression);
			        _localctx.arg->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
			    
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
		public std::vector<smallc::ArgumentNode*> arglist;
		public ArgEntryContext argEntry;
		public ArgListContext argList;
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
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				((ArgListContext)_localctx).argEntry = argEntry();

				        _localctx.arglist.push_back(((ArgListContext)_localctx).argEntry.arg);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				((ArgListContext)_localctx).argEntry = argEntry();
				setState(377);
				match(T__31);
				setState(378);
				((ArgListContext)_localctx).argList = argList();

				        _localctx.arglist.push_back(((ArgListContext)_localctx).argEntry.arg);
				        for(smallc::ArgumentNode* arg : ((ArgListContext)_localctx).argList.arglist)
				            _localctx.arglist.push_back(arg);
				    
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
		public smallc::IdentifierNode* name;
		public Token ID;
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
			setState(383);
			((VarNameContext)_localctx).ID = match(ID);
			 
			        ((VarNameContext)_localctx).name =  new smallc::IdentifierNode((((VarNameContext)_localctx).ID!=null?((VarNameContext)_localctx).ID.getText():null));
			        _localctx.name->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
			    
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
		public smallc::IdentifierNode* name;
		public Token ID;
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
			setState(386);
			((ArrNameContext)_localctx).ID = match(ID);
			 
			        ((ArrNameContext)_localctx).name =  new smallc::IdentifierNode((((ArrNameContext)_localctx).ID!=null?((ArrNameContext)_localctx).ID.getText():null));
			        _localctx.name->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
			    
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
		public smallc::IdentifierNode* name;
		public Token ID;
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
			setState(389);
			((FcnNameContext)_localctx).ID = match(ID);
			 
			        ((FcnNameContext)_localctx).name =  new smallc::IdentifierNode((((FcnNameContext)_localctx).ID!=null?((FcnNameContext)_localctx).ID.getText():null));
			        _localctx.name->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
			    
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
		public smallc::IntConstantNode* intconst;
		public Token INT;
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
			setState(397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(392);
				((IntConstContext)_localctx).INT = match(INT);

				        ((IntConstContext)_localctx).intconst =  new smallc::IntConstantNode((((IntConstContext)_localctx).INT!=null?((IntConstContext)_localctx).INT.getText():null));
				        _localctx.intconst->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());

				    
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				match(T__18);
				setState(395);
				((IntConstContext)_localctx).INT = match(INT);

				        ((IntConstContext)_localctx).intconst =  new smallc::IntConstantNode("-" + (((IntConstContext)_localctx).INT!=null?((IntConstContext)_localctx).INT.getText():null));
				        _localctx.intconst->setLocation(_localctx->start->getLine(), _localctx->start->getCharPositionInLine());
				    
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
		"\u0004\u0001%\u0190\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002`\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"i\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005w\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0095\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u009c\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a4\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00b0\b\r\n\r\f\r\u00b3\t\r\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u00b8\b\r\n\r\f\r\u00bb\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00d1\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00e9\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00fa\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u010f\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0125\b\u0013\n"+
		"\u0013\f\u0013\u0128\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0136\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0142\b\u0014\n\u0014\f\u0014"+
		"\u0145\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0150\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0156\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0161\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u016b\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0171\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u017e\b\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u018e\b\u001f\u0001\u001f\u0000\u0002&( \u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>\u0000\u0005\u0001\u0000\u0012\u0013\u0001\u0000\u0014\u0017"+
		"\u0001\u0000\u0018\u0019\u0001\u0000\u001c\u001d\u0002\u0000\u0013\u0013"+
		"\u001e\u001e\u0195\u0000D\u0001\u0000\u0000\u0000\u0002P\u0001\u0000\u0000"+
		"\u0000\u0004_\u0001\u0000\u0000\u0000\u0006h\u0001\u0000\u0000\u0000\b"+
		"j\u0001\u0000\u0000\u0000\nv\u0001\u0000\u0000\u0000\fx\u0001\u0000\u0000"+
		"\u0000\u000e\u0080\u0001\u0000\u0000\u0000\u0010\u0088\u0001\u0000\u0000"+
		"\u0000\u0012\u0094\u0001\u0000\u0000\u0000\u0014\u009b\u0001\u0000\u0000"+
		"\u0000\u0016\u00a3\u0001\u0000\u0000\u0000\u0018\u00a5\u0001\u0000\u0000"+
		"\u0000\u001a\u00a8\u0001\u0000\u0000\u0000\u001c\u00d0\u0001\u0000\u0000"+
		"\u0000\u001e\u00d2\u0001\u0000\u0000\u0000 \u00e8\u0001\u0000\u0000\u0000"+
		"\"\u00ea\u0001\u0000\u0000\u0000$\u00f9\u0001\u0000\u0000\u0000&\u010e"+
		"\u0001\u0000\u0000\u0000(\u0135\u0001\u0000\u0000\u0000*\u014f\u0001\u0000"+
		"\u0000\u0000,\u0155\u0001\u0000\u0000\u0000.\u0160\u0001\u0000\u0000\u0000"+
		"0\u016a\u0001\u0000\u0000\u00002\u0170\u0001\u0000\u0000\u00004\u0172"+
		"\u0001\u0000\u0000\u00006\u017d\u0001\u0000\u0000\u00008\u017f\u0001\u0000"+
		"\u0000\u0000:\u0182\u0001\u0000\u0000\u0000<\u0185\u0001\u0000\u0000\u0000"+
		">\u018d\u0001\u0000\u0000\u0000@A\u0003\u0002\u0001\u0000AB\u0006\u0000"+
		"\uffff\uffff\u0000BE\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000"+
		"D@\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000EK\u0001\u0000\u0000"+
		"\u0000FG\u0003\u0004\u0002\u0000GH\u0006\u0000\uffff\uffff\u0000HJ\u0001"+
		"\u0000\u0000\u0000IF\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000"+
		"KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000NO\u0005\u0000\u0000\u0001O\u0001\u0001"+
		"\u0000\u0000\u0000PQ\u0005\u0001\u0000\u0000QR\u0005\u0002\u0000\u0000"+
		"R\u0003\u0001\u0000\u0000\u0000ST\u0003\u0006\u0003\u0000TU\u0006\u0002"+
		"\uffff\uffff\u0000U`\u0001\u0000\u0000\u0000VW\u0003\n\u0005\u0000WX\u0006"+
		"\u0002\uffff\uffff\u0000X`\u0001\u0000\u0000\u0000YZ\u0003\u000e\u0007"+
		"\u0000Z[\u0006\u0002\uffff\uffff\u0000[`\u0001\u0000\u0000\u0000\\]\u0003"+
		"\u0010\b\u0000]^\u0006\u0002\uffff\uffff\u0000^`\u0001\u0000\u0000\u0000"+
		"_S\u0001\u0000\u0000\u0000_V\u0001\u0000\u0000\u0000_Y\u0001\u0000\u0000"+
		"\u0000_\\\u0001\u0000\u0000\u0000`\u0005\u0001\u0000\u0000\u0000ab\u0003"+
		"\b\u0004\u0000bc\u0006\u0003\uffff\uffff\u0000ci\u0001\u0000\u0000\u0000"+
		"de\u0003\b\u0004\u0000ef\u0003\u0006\u0003\u0000fg\u0006\u0003\uffff\uffff"+
		"\u0000gi\u0001\u0000\u0000\u0000ha\u0001\u0000\u0000\u0000hd\u0001\u0000"+
		"\u0000\u0000i\u0007\u0001\u0000\u0000\u0000jk\u0003\u0012\t\u0000kl\u0003"+
		"8\u001c\u0000lm\u0005\u0003\u0000\u0000mn\u0006\u0004\uffff\uffff\u0000"+
		"n\t\u0001\u0000\u0000\u0000op\u0003\f\u0006\u0000pq\u0006\u0005\uffff"+
		"\uffff\u0000qw\u0001\u0000\u0000\u0000rs\u0003\f\u0006\u0000st\u0003\n"+
		"\u0005\u0000tu\u0006\u0005\uffff\uffff\u0000uw\u0001\u0000\u0000\u0000"+
		"vo\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000w\u000b\u0001\u0000"+
		"\u0000\u0000xy\u0003\u0012\t\u0000yz\u0003:\u001d\u0000z{\u0005\u0004"+
		"\u0000\u0000{|\u0003>\u001f\u0000|}\u0005\u0005\u0000\u0000}~\u0005\u0003"+
		"\u0000\u0000~\u007f\u0006\u0006\uffff\uffff\u0000\u007f\r\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0003\u0014\n\u0000\u0081\u0082\u0003<\u001e"+
		"\u0000\u0082\u0083\u0005\u0006\u0000\u0000\u0083\u0084\u0003,\u0016\u0000"+
		"\u0084\u0085\u0005\u0007\u0000\u0000\u0085\u0086\u0005\u0003\u0000\u0000"+
		"\u0086\u0087\u0006\u0007\uffff\uffff\u0000\u0087\u000f\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0003\u0014\n\u0000\u0089\u008a\u0003<\u001e\u0000"+
		"\u008a\u008b\u0005\u0006\u0000\u0000\u008b\u008c\u0003,\u0016\u0000\u008c"+
		"\u008d\u0005\u0007\u0000\u0000\u008d\u008e\u0003\u001a\r\u0000\u008e\u008f"+
		"\u0006\b\uffff\uffff\u0000\u008f\u0011\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0005\b\u0000\u0000\u0091\u0095\u0006\t\uffff\uffff\u0000\u0092\u0093"+
		"\u0005\t\u0000\u0000\u0093\u0095\u0006\t\uffff\uffff\u0000\u0094\u0090"+
		"\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0013"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0005\n\u0000\u0000\u0097\u009c\u0006"+
		"\n\uffff\uffff\u0000\u0098\u0099\u0003\u0012\t\u0000\u0099\u009a\u0006"+
		"\n\uffff\uffff\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0096\u0001"+
		"\u0000\u0000\u0000\u009b\u0098\u0001\u0000\u0000\u0000\u009c\u0015\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0003\u0018\f\u0000\u009e\u009f\u0006\u000b"+
		"\uffff\uffff\u0000\u009f\u00a4\u0001\u0000\u0000\u0000\u00a0\u00a1\u0003"+
		">\u001f\u0000\u00a1\u00a2\u0006\u000b\uffff\uffff\u0000\u00a2\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a3\u009d\u0001\u0000\u0000\u0000\u00a3\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a4\u0017\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005"+
		"!\u0000\u0000\u00a6\u00a7\u0006\f\uffff\uffff\u0000\u00a7\u0019\u0001"+
		"\u0000\u0000\u0000\u00a8\u00b1\u0005\u000b\u0000\u0000\u00a9\u00aa\u0003"+
		"\b\u0004\u0000\u00aa\u00ab\u0006\r\uffff\uffff\u0000\u00ab\u00b0\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0003\f\u0006\u0000\u00ad\u00ae\u0006\r"+
		"\uffff\uffff\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00a9\u0001"+
		"\u0000\u0000\u0000\u00af\u00ac\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b9\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0003\u001c\u000e\u0000\u00b5\u00b6\u0006"+
		"\r\uffff\uffff\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005"+
		"\f\u0000\u0000\u00bd\u001b\u0001\u0000\u0000\u0000\u00be\u00bf\u0003&"+
		"\u0013\u0000\u00bf\u00c0\u0005\u0003\u0000\u0000\u00c0\u00d1\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0003\u001e\u000f\u0000\u00c2\u00c3\u0006\u000e"+
		"\uffff\uffff\u0000\u00c3\u00d1\u0001\u0000\u0000\u0000\u00c4\u00c5\u0003"+
		" \u0010\u0000\u00c5\u00c6\u0006\u000e\uffff\uffff\u0000\u00c6\u00d1\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0003\"\u0011\u0000\u00c8\u00c9\u0006\u000e"+
		"\uffff\uffff\u0000\u00c9\u00d1\u0001\u0000\u0000\u0000\u00ca\u00cb\u0003"+
		"$\u0012\u0000\u00cb\u00cc\u0006\u000e\uffff\uffff\u0000\u00cc\u00d1\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u0003\u001a\r\u0000\u00ce\u00cf\u0006\u000e"+
		"\uffff\uffff\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00be\u0001"+
		"\u0000\u0000\u0000\u00d0\u00c1\u0001\u0000\u0000\u0000\u00d0\u00c4\u0001"+
		"\u0000\u0000\u0000\u00d0\u00c7\u0001\u0000\u0000\u0000\u00d0\u00ca\u0001"+
		"\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000\u00d1\u001d\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0003*\u0015\u0000\u00d3\u00d4\u0005\r"+
		"\u0000\u0000\u00d4\u00d5\u0003&\u0013\u0000\u00d5\u00d6\u0005\u0003\u0000"+
		"\u0000\u00d6\u00d7\u0006\u000f\uffff\uffff\u0000\u00d7\u001f\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0005\u000e\u0000\u0000\u00d9\u00da\u0005\u0006"+
		"\u0000\u0000\u00da\u00db\u0003&\u0013\u0000\u00db\u00dc\u0005\u0007\u0000"+
		"\u0000\u00dc\u00dd\u0003\u001c\u000e\u0000\u00dd\u00de\u0006\u0010\uffff"+
		"\uffff\u0000\u00de\u00e9\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u000e"+
		"\u0000\u0000\u00e0\u00e1\u0005\u0006\u0000\u0000\u00e1\u00e2\u0003&\u0013"+
		"\u0000\u00e2\u00e3\u0005\u0007\u0000\u0000\u00e3\u00e4\u0003\u001c\u000e"+
		"\u0000\u00e4\u00e5\u0005\u000f\u0000\u0000\u00e5\u00e6\u0003\u001c\u000e"+
		"\u0000\u00e6\u00e7\u0006\u0010\uffff\uffff\u0000\u00e7\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e8\u00d8\u0001\u0000\u0000\u0000\u00e8\u00df\u0001\u0000"+
		"\u0000\u0000\u00e9!\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u0010\u0000"+
		"\u0000\u00eb\u00ec\u0005\u0006\u0000\u0000\u00ec\u00ed\u0003&\u0013\u0000"+
		"\u00ed\u00ee\u0005\u0007\u0000\u0000\u00ee\u00ef\u0003\u001c\u000e\u0000"+
		"\u00ef\u00f0\u0006\u0011\uffff\uffff\u0000\u00f0#\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f2\u0005\u0011\u0000\u0000\u00f2\u00f3\u0003&\u0013\u0000\u00f3"+
		"\u00f4\u0005\u0003\u0000\u0000\u00f4\u00f5\u0006\u0012\uffff\uffff\u0000"+
		"\u00f5\u00fa\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u0011\u0000\u0000"+
		"\u00f7\u00f8\u0005\u0003\u0000\u0000\u00f8\u00fa\u0006\u0012\uffff\uffff"+
		"\u0000\u00f9\u00f1\u0001\u0000\u0000\u0000\u00f9\u00f6\u0001\u0000\u0000"+
		"\u0000\u00fa%\u0001\u0000\u0000\u0000\u00fb\u00fc\u0006\u0013\uffff\uffff"+
		"\u0000\u00fc\u00fd\u0003(\u0014\u0000\u00fd\u00fe\u0006\u0013\uffff\uffff"+
		"\u0000\u00fe\u010f\u0001\u0000\u0000\u0000\u00ff\u0100\u0005\u0006\u0000"+
		"\u0000\u0100\u0101\u0003&\u0013\u0000\u0101\u0102\u0005\u0007\u0000\u0000"+
		"\u0102\u0103\u0006\u0013\uffff\uffff\u0000\u0103\u010f\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0003<\u001e\u0000\u0105\u0106\u0005\u0006\u0000\u0000"+
		"\u0106\u0107\u00032\u0019\u0000\u0107\u0108\u0005\u0007\u0000\u0000\u0108"+
		"\u0109\u0006\u0013\uffff\uffff\u0000\u0109\u010f\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0007\u0000\u0000\u0000\u010b\u010c\u0003&\u0013\u0005\u010c"+
		"\u010d\u0006\u0013\uffff\uffff\u0000\u010d\u010f\u0001\u0000\u0000\u0000"+
		"\u010e\u00fb\u0001\u0000\u0000\u0000\u010e\u00ff\u0001\u0000\u0000\u0000"+
		"\u010e\u0104\u0001\u0000\u0000\u0000\u010e\u010a\u0001\u0000\u0000\u0000"+
		"\u010f\u0126\u0001\u0000\u0000\u0000\u0110\u0111\n\u0004\u0000\u0000\u0111"+
		"\u0112\u0007\u0001\u0000\u0000\u0112\u0113\u0003&\u0013\u0005\u0113\u0114"+
		"\u0006\u0013\uffff\uffff\u0000\u0114\u0125\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\n\u0003\u0000\u0000\u0116\u0117\u0007\u0002\u0000\u0000\u0117\u0118"+
		"\u0003&\u0013\u0004\u0118\u0119\u0006\u0013\uffff\uffff\u0000\u0119\u0125"+
		"\u0001\u0000\u0000\u0000\u011a\u011b\n\u0002\u0000\u0000\u011b\u011c\u0005"+
		"\u001a\u0000\u0000\u011c\u011d\u0003&\u0013\u0003\u011d\u011e\u0006\u0013"+
		"\uffff\uffff\u0000\u011e\u0125\u0001\u0000\u0000\u0000\u011f\u0120\n\u0001"+
		"\u0000\u0000\u0120\u0121\u0005\u001b\u0000\u0000\u0121\u0122\u0003&\u0013"+
		"\u0002\u0122\u0123\u0006\u0013\uffff\uffff\u0000\u0123\u0125\u0001\u0000"+
		"\u0000\u0000\u0124\u0110\u0001\u0000\u0000\u0000\u0124\u0115\u0001\u0000"+
		"\u0000\u0000\u0124\u011a\u0001\u0000\u0000\u0000\u0124\u011f\u0001\u0000"+
		"\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\'\u0001\u0000\u0000"+
		"\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012a\u0006\u0014\uffff"+
		"\uffff\u0000\u012a\u012b\u0003*\u0015\u0000\u012b\u012c\u0006\u0014\uffff"+
		"\uffff\u0000\u012c\u0136\u0001\u0000\u0000\u0000\u012d\u012e\u0003\u0016"+
		"\u000b\u0000\u012e\u012f\u0006\u0014\uffff\uffff\u0000\u012f\u0136\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u0005\u0006\u0000\u0000\u0131\u0132\u0003"+
		"(\u0014\u0000\u0132\u0133\u0005\u0007\u0000\u0000\u0133\u0134\u0006\u0014"+
		"\uffff\uffff\u0000\u0134\u0136\u0001\u0000\u0000\u0000\u0135\u0129\u0001"+
		"\u0000\u0000\u0000\u0135\u012d\u0001\u0000\u0000\u0000\u0135\u0130\u0001"+
		"\u0000\u0000\u0000\u0136\u0143\u0001\u0000\u0000\u0000\u0137\u0138\n\u0003"+
		"\u0000\u0000\u0138\u0139\u0007\u0003\u0000\u0000\u0139\u013a\u0003(\u0014"+
		"\u0004\u013a\u013b\u0006\u0014\uffff\uffff\u0000\u013b\u0142\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\n\u0002\u0000\u0000\u013d\u013e\u0007\u0004\u0000"+
		"\u0000\u013e\u013f\u0003(\u0014\u0003\u013f\u0140\u0006\u0014\uffff\uffff"+
		"\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u0137\u0001\u0000\u0000"+
		"\u0000\u0141\u013c\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000"+
		"\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000"+
		"\u0000\u0144)\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000"+
		"\u0146\u0147\u00038\u001c\u0000\u0147\u0148\u0006\u0015\uffff\uffff\u0000"+
		"\u0148\u0150\u0001\u0000\u0000\u0000\u0149\u014a\u0003:\u001d\u0000\u014a"+
		"\u014b\u0005\u0004\u0000\u0000\u014b\u014c\u0003(\u0014\u0000\u014c\u014d"+
		"\u0005\u0005\u0000\u0000\u014d\u014e\u0006\u0015\uffff\uffff\u0000\u014e"+
		"\u0150\u0001\u0000\u0000\u0000\u014f\u0146\u0001\u0000\u0000\u0000\u014f"+
		"\u0149\u0001\u0000\u0000\u0000\u0150+\u0001\u0000\u0000\u0000\u0151\u0152"+
		"\u00030\u0018\u0000\u0152\u0153\u0006\u0016\uffff\uffff\u0000\u0153\u0156"+
		"\u0001\u0000\u0000\u0000\u0154\u0156\u0001\u0000\u0000\u0000\u0155\u0151"+
		"\u0001\u0000\u0000\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0156-\u0001"+
		"\u0000\u0000\u0000\u0157\u0158\u0003\u0012\t\u0000\u0158\u0159\u00038"+
		"\u001c\u0000\u0159\u015a\u0006\u0017\uffff\uffff\u0000\u015a\u0161\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u0003\u0012\t\u0000\u015c\u015d\u0003:"+
		"\u001d\u0000\u015d\u015e\u0005\u001f\u0000\u0000\u015e\u015f\u0006\u0017"+
		"\uffff\uffff\u0000\u015f\u0161\u0001\u0000\u0000\u0000\u0160\u0157\u0001"+
		"\u0000\u0000\u0000\u0160\u015b\u0001\u0000\u0000\u0000\u0161/\u0001\u0000"+
		"\u0000\u0000\u0162\u0163\u0003.\u0017\u0000\u0163\u0164\u0006\u0018\uffff"+
		"\uffff\u0000\u0164\u016b\u0001\u0000\u0000\u0000\u0165\u0166\u0003.\u0017"+
		"\u0000\u0166\u0167\u0005 \u0000\u0000\u0167\u0168\u00030\u0018\u0000\u0168"+
		"\u0169\u0006\u0018\uffff\uffff\u0000\u0169\u016b\u0001\u0000\u0000\u0000"+
		"\u016a\u0162\u0001\u0000\u0000\u0000\u016a\u0165\u0001\u0000\u0000\u0000"+
		"\u016b1\u0001\u0000\u0000\u0000\u016c\u016d\u00036\u001b\u0000\u016d\u016e"+
		"\u0006\u0019\uffff\uffff\u0000\u016e\u0171\u0001\u0000\u0000\u0000\u016f"+
		"\u0171\u0001\u0000\u0000\u0000\u0170\u016c\u0001\u0000\u0000\u0000\u0170"+
		"\u016f\u0001\u0000\u0000\u0000\u01713\u0001\u0000\u0000\u0000\u0172\u0173"+
		"\u0003&\u0013\u0000\u0173\u0174\u0006\u001a\uffff\uffff\u0000\u01745\u0001"+
		"\u0000\u0000\u0000\u0175\u0176\u00034\u001a\u0000\u0176\u0177\u0006\u001b"+
		"\uffff\uffff\u0000\u0177\u017e\u0001\u0000\u0000\u0000\u0178\u0179\u0003"+
		"4\u001a\u0000\u0179\u017a\u0005 \u0000\u0000\u017a\u017b\u00036\u001b"+
		"\u0000\u017b\u017c\u0006\u001b\uffff\uffff\u0000\u017c\u017e\u0001\u0000"+
		"\u0000\u0000\u017d\u0175\u0001\u0000\u0000\u0000\u017d\u0178\u0001\u0000"+
		"\u0000\u0000\u017e7\u0001\u0000\u0000\u0000\u017f\u0180\u0005\"\u0000"+
		"\u0000\u0180\u0181\u0006\u001c\uffff\uffff\u0000\u01819\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0005\"\u0000\u0000\u0183\u0184\u0006\u001d\uffff\uffff"+
		"\u0000\u0184;\u0001\u0000\u0000\u0000\u0185\u0186\u0005\"\u0000\u0000"+
		"\u0186\u0187\u0006\u001e\uffff\uffff\u0000\u0187=\u0001\u0000\u0000\u0000"+
		"\u0188\u0189\u0005#\u0000\u0000\u0189\u018e\u0006\u001f\uffff\uffff\u0000"+
		"\u018a\u018b\u0005\u0013\u0000\u0000\u018b\u018c\u0005#\u0000\u0000\u018c"+
		"\u018e\u0006\u001f\uffff\uffff\u0000\u018d\u0188\u0001\u0000\u0000\u0000"+
		"\u018d\u018a\u0001\u0000\u0000\u0000\u018e?\u0001\u0000\u0000\u0000\u001b"+
		"DK_hv\u0094\u009b\u00a3\u00af\u00b1\u00b9\u00d0\u00e8\u00f9\u010e\u0124"+
		"\u0126\u0135\u0141\u0143\u014f\u0155\u0160\u016a\u0170\u017d\u018d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}