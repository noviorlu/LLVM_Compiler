# Makefile 
# ECE467 Lab 3
#
#  Created by Tarek Abdelrahman on 2023-09-13.
#  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
#
#  Permission is hereby granted to use this code in ECE467 at
#  the University of Toronto. It is prohibited to distribute
#  this code, either publicly or to third parties.

SHELL := /bin/bash

ANTLR_VER     = 4.7.2
ECE467_ROOT   = /cad2/ece467f
ANTLR_INC_DIR = $(ECE467_ROOT)/ANTLR-$(ANTLR_VER)/include/antlr4-runtime/
ANTLR_LIB_DIR = $(ECE467_ROOT)/ANTLR-$(ANTLR_VER)/lib

CC            = g++ 
CC_OPT        = -std=c++17 -w

ANTLR         = java -jar $(ECE467_ROOT)/ANTLR-$(ANTLR_VER)/antlr-$(ANTLR_VER)-complete.jar
ANTLR_OPTS    = -no-listener -visitor -Dlanguage=Cpp

TARGET        = smallC
EXE           = A3Sema

GEN_SRCS      = $(TARGET)Lexer.cpp  $(TARGET)Parser.cpp $(TARGET)BaseVisitor.cpp \
                $(TARGET)Visitor.cpp 

GEN_OBJS      = $(patsubst %.cpp,%.o,$(GEN_SRCS))

GEN_INCS      = $(patsubst %.cpp,%.h,$(GEN_SRCS))

GEN_OTHR      = $(TARGET).interp $(TARGET).tokens $(TARGET)Lexer.interp $(TARGET)Lexer.tokens

SRCS          = $(EXE).cpp ASTNodes.cpp ASTVisitorBase.cpp ASTPrinter.cpp \
                SymTable.cpp SemanticAnalyzer.cpp
OBJS          = $(patsubst %.cpp,%.o,$(SRCS))
INCS          = $(patsubst %.cpp,%.h,$(SRCS))

$(EXE):	$(OBJS) $(GEN_OBJS)
	$(CC) $(CC_OPT) -I$(ANTLR_INC_DIR) -L$(ANTLR_LIB_DIR) $(OBJS) \
	          $(GEN_OBJS) -o $(EXE) -lantlr4-runtime

$(OBJS):	%.o:	%.cpp $(GEN_INCS)
	$(CC) $(CC_OPT) -c -I$(ANTLR_INC_DIR) -o $@ $<
	
$(GEN_OBJS):	%.o:	%.cpp %.h
	$(CC) $(CC_OPT) -c -I$(ANTLR_INC_DIR) -o $@ $<

$(GEN_INCS):	$(TARGET).g4
	$(ANTLR) $(ANTLR_OPTS)  $(TARGET).g4

$(GEN_SRCS):	$(TARGET).g4
	$(ANTLR) $(ANTLR_OPTS)  $(TARGET).g4

depend:
	@makedepend -- $(CC_OPT) -I$(ANTLR_INC_DIR) -L$(ANTLR_LIB_DIR) -- \
		                               $(SRCS) $(GEN_SRCS) >& /dev/null

.PHONY: clean
clean:
	@rm -f $(GEN_SRCS) $(GEN_INCS) $(GEN_OBJS) $(GEN_OTHR) $(OBJS) $(EXE) Makefile.bak

# DO NOT DELETE

A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/antlr4-runtime.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/antlr4-common.h
A3Sema.o: /usr/include/assert.h /usr/include/features.h
A3Sema.o: /usr/include/stdc-predef.h /usr/include/sys/cdefs.h
A3Sema.o: /usr/include/bits/wordsize.h /usr/include/bits/long-double.h
A3Sema.o: /usr/include/gnu/stubs.h /usr/include/limits.h
A3Sema.o: /usr/include/bits/libc-header-start.h
A3Sema.o: /usr/include/bits/posix1_lim.h /usr/include/bits/local_lim.h
A3Sema.o: /usr/include/linux/limits.h /usr/include/bits/posix2_lim.h
A3Sema.o: /usr/include/stdint.h /usr/include/bits/types.h
A3Sema.o: /usr/include/bits/timesize.h /usr/include/bits/typesizes.h
A3Sema.o: /usr/include/bits/time64.h /usr/include/bits/wchar.h
A3Sema.o: /usr/include/bits/stdint-intn.h /usr/include/bits/stdint-uintn.h
A3Sema.o: /usr/include/stdlib.h /usr/include/bits/waitflags.h
A3Sema.o: /usr/include/bits/waitstatus.h /usr/include/bits/floatn.h
A3Sema.o: /usr/include/bits/floatn-common.h /usr/include/sys/types.h
A3Sema.o: /usr/include/bits/types/clock_t.h
A3Sema.o: /usr/include/bits/types/clockid_t.h
A3Sema.o: /usr/include/bits/types/time_t.h /usr/include/bits/types/timer_t.h
A3Sema.o: /usr/include/endian.h /usr/include/bits/endian.h
A3Sema.o: /usr/include/bits/endianness.h /usr/include/bits/byteswap.h
A3Sema.o: /usr/include/bits/uintn-identity.h /usr/include/sys/select.h
A3Sema.o: /usr/include/bits/select.h /usr/include/bits/types/sigset_t.h
A3Sema.o: /usr/include/bits/types/__sigset_t.h
A3Sema.o: /usr/include/bits/types/struct_timeval.h
A3Sema.o: /usr/include/bits/types/struct_timespec.h
A3Sema.o: /usr/include/bits/pthreadtypes.h
A3Sema.o: /usr/include/bits/thread-shared-types.h
A3Sema.o: /usr/include/bits/pthreadtypes-arch.h
A3Sema.o: /usr/include/bits/struct_mutex.h /usr/include/bits/struct_rwlock.h
A3Sema.o: /usr/include/alloca.h /usr/include/bits/stdlib-float.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/guid.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/Declarations.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRErrorListener.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RecognitionException.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Exceptions.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRErrorStrategy.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Token.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/IntStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRFileStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRInputStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CharStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/Interval.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/BailErrorStrategy.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/DefaultErrorStrategy.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/IntervalSet.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/BaseErrorListener.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/BufferedTokenStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CommonToken.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/WritableToken.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CommonTokenFactory.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenFactory.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CommonTokenStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ConsoleErrorListener.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/DiagnosticErrorListener.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/FailedPredicateException.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/InputMismatchException.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/InterpreterRuleContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ParserRuleContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RuleContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTree.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/Any.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/CPPUtils.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Lexer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Recognizer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ProxyErrorListener.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenSource.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/LexerInterpreter.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredictionContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATN.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Vocabulary.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/LexerNoViableAltException.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNConfigSet.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/BitSet.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ListTokenSource.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/NoViableAltException.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Parser.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeListener.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ParserInterpreter.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RuleContextWithAltNum.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RuntimeMetaData.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenStreamRewriter.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/UnbufferedCharStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/UnbufferedTokenStream.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNConfig.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNDeserializationOptions.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNDeserializer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerActionType.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNSerializer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNSimulator.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNType.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/AbstractPredicateTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/Transition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ActionTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/AmbiguityInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/DecisionEventInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ArrayPredictionContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/AtomTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BasicBlockStartState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BlockStartState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/DecisionState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BasicState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BlockEndState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ContextSensitivityInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/DecisionInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredicateEvalInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ErrorInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/EmptyPredictionContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SingletonPredictionContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/EpsilonTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LL1Analyzer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerATNConfig.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerATNSimulator.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerActionExecutor.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerChannelAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerCustomAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerIndexedCustomAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerModeAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerMoreAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerPopModeAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerPushModeAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerSkipAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerTypeAction.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LookaheadEventInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LoopEndState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/NotSetTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SetTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/OrderedATNConfigSet.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ParseInfo.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ParserATNSimulator.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredictionMode.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/DFAState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SemanticContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PlusBlockStartState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PlusLoopbackState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PrecedencePredicateTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredicateTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredictionMode.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ProfilingATNSimulator.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RangeTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RuleStartState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RuleStopState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RuleTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SemanticContext.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/StarBlockStartState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/StarLoopEntryState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/StarLoopbackState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/TokensStartState.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/WildcardTransition.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/DFA.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/DFASerializer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/LexerDFASerializer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/InterpreterDataReader.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/MurmurHash.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/Predicate.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/Arrays.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/StringUtils.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/AbstractParseTreeVisitor.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeVisitor.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ErrorNode.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/TerminalNode.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ErrorNodeImpl.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/TerminalNodeImpl.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeProperty.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeWalker.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/Trees.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/Chunk.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/ParseTreeMatch.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/ParseTreePattern.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/ParseTreePatternMatcher.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/RuleTagToken.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/TagChunk.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/Chunk.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/TextChunk.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/TokenTagToken.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPath.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathElement.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathLexer.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathLexerErrorListener.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathRuleAnywhereElement.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathElement.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathRuleElement.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathTokenAnywhereElement.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathTokenElement.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathWildcardAnywhereElement.h
A3Sema.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathWildcardElement.h
A3Sema.o: smallCLexer.h ASTNodes.h ASTVisitorBase.h SymTable.h ASTPrinter.h
A3Sema.o: SemanticAnalyzer.h
ASTNodes.o: ASTNodes.h ASTVisitorBase.h SymTable.h
ASTVisitorBase.o: ASTNodes.h ASTVisitorBase.h SymTable.h
ASTPrinter.o: ASTPrinter.h ASTNodes.h ASTVisitorBase.h SymTable.h
SymTable.o: ASTNodes.h ASTVisitorBase.h SymTable.h
SemanticAnalyzer.o: SemanticAnalyzer.h ASTNodes.h ASTVisitorBase.h SymTable.h
smallCLexer.o: ASTNodes.h ASTVisitorBase.h SymTable.h smallCLexer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/antlr4-runtime.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/antlr4-common.h
smallCLexer.o: /usr/include/assert.h /usr/include/features.h
smallCLexer.o: /usr/include/stdc-predef.h /usr/include/sys/cdefs.h
smallCLexer.o: /usr/include/bits/wordsize.h /usr/include/bits/long-double.h
smallCLexer.o: /usr/include/gnu/stubs.h /usr/include/limits.h
smallCLexer.o: /usr/include/bits/libc-header-start.h
smallCLexer.o: /usr/include/bits/posix1_lim.h /usr/include/bits/local_lim.h
smallCLexer.o: /usr/include/linux/limits.h /usr/include/bits/posix2_lim.h
smallCLexer.o: /usr/include/stdint.h /usr/include/bits/types.h
smallCLexer.o: /usr/include/bits/timesize.h /usr/include/bits/typesizes.h
smallCLexer.o: /usr/include/bits/time64.h /usr/include/bits/wchar.h
smallCLexer.o: /usr/include/bits/stdint-intn.h
smallCLexer.o: /usr/include/bits/stdint-uintn.h /usr/include/stdlib.h
smallCLexer.o: /usr/include/bits/waitflags.h /usr/include/bits/waitstatus.h
smallCLexer.o: /usr/include/bits/floatn.h /usr/include/bits/floatn-common.h
smallCLexer.o: /usr/include/sys/types.h /usr/include/bits/types/clock_t.h
smallCLexer.o: /usr/include/bits/types/clockid_t.h
smallCLexer.o: /usr/include/bits/types/time_t.h
smallCLexer.o: /usr/include/bits/types/timer_t.h /usr/include/endian.h
smallCLexer.o: /usr/include/bits/endian.h /usr/include/bits/endianness.h
smallCLexer.o: /usr/include/bits/byteswap.h
smallCLexer.o: /usr/include/bits/uintn-identity.h /usr/include/sys/select.h
smallCLexer.o: /usr/include/bits/select.h /usr/include/bits/types/sigset_t.h
smallCLexer.o: /usr/include/bits/types/__sigset_t.h
smallCLexer.o: /usr/include/bits/types/struct_timeval.h
smallCLexer.o: /usr/include/bits/types/struct_timespec.h
smallCLexer.o: /usr/include/bits/pthreadtypes.h
smallCLexer.o: /usr/include/bits/thread-shared-types.h
smallCLexer.o: /usr/include/bits/pthreadtypes-arch.h
smallCLexer.o: /usr/include/bits/struct_mutex.h
smallCLexer.o: /usr/include/bits/struct_rwlock.h /usr/include/alloca.h
smallCLexer.o: /usr/include/bits/stdlib-float.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/guid.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/Declarations.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRErrorListener.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RecognitionException.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Exceptions.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRErrorStrategy.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Token.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/IntStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRFileStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ANTLRInputStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CharStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/Interval.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/BailErrorStrategy.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/DefaultErrorStrategy.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/IntervalSet.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/BaseErrorListener.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/BufferedTokenStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CommonToken.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/WritableToken.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CommonTokenFactory.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenFactory.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/CommonTokenStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ConsoleErrorListener.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/DiagnosticErrorListener.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/FailedPredicateException.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/InputMismatchException.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/InterpreterRuleContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ParserRuleContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RuleContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTree.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/Any.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/CPPUtils.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Lexer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Recognizer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ProxyErrorListener.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenSource.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/LexerInterpreter.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredictionContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATN.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Vocabulary.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/LexerNoViableAltException.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNConfigSet.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/BitSet.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ListTokenSource.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/NoViableAltException.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/Parser.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeListener.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/ParserInterpreter.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RuleContextWithAltNum.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/RuntimeMetaData.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/TokenStreamRewriter.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/UnbufferedCharStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/UnbufferedTokenStream.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNConfig.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNDeserializationOptions.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNDeserializer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerActionType.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNSerializer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNSimulator.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ATNType.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/AbstractPredicateTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/Transition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ActionTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/AmbiguityInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/DecisionEventInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ArrayPredictionContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/AtomTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BasicBlockStartState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BlockStartState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/DecisionState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BasicState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/BlockEndState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ContextSensitivityInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/DecisionInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredicateEvalInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ErrorInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/EmptyPredictionContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SingletonPredictionContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/EpsilonTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LL1Analyzer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerATNConfig.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerATNSimulator.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerActionExecutor.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerChannelAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerCustomAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerIndexedCustomAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerModeAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerMoreAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerPopModeAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerPushModeAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerSkipAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LexerTypeAction.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LookaheadEventInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/LoopEndState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/NotSetTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SetTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/OrderedATNConfigSet.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ParseInfo.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ParserATNSimulator.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredictionMode.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/DFAState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SemanticContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PlusBlockStartState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PlusLoopbackState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PrecedencePredicateTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredicateTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/PredictionMode.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/ProfilingATNSimulator.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RangeTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RuleStartState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RuleStopState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/RuleTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/SemanticContext.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/StarBlockStartState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/StarLoopEntryState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/StarLoopbackState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/TokensStartState.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/atn/WildcardTransition.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/DFA.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/DFASerializer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/dfa/LexerDFASerializer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/InterpreterDataReader.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/MurmurHash.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/misc/Predicate.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/Arrays.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/support/StringUtils.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/AbstractParseTreeVisitor.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeVisitor.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ErrorNode.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/TerminalNode.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ErrorNodeImpl.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/TerminalNodeImpl.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeProperty.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/ParseTreeWalker.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/Trees.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/Chunk.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/ParseTreeMatch.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/ParseTreePattern.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/ParseTreePatternMatcher.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/RuleTagToken.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/TagChunk.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/Chunk.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/TextChunk.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/pattern/TokenTagToken.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPath.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathElement.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathLexer.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathLexerErrorListener.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathRuleAnywhereElement.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathElement.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathRuleElement.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathTokenAnywhereElement.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathTokenElement.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathWildcardAnywhereElement.h
smallCLexer.o: /cad2/ece467f/ANTLR-4.7.2/include/antlr4-runtime/tree/xpath/XPathWildcardElement.h
