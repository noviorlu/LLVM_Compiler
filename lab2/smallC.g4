//
//  smallC.g4
//  ECE467 Lab 2
//
//  Created by Tarek Abdelrahman on 2023-08-21.
//  Modified by Tarek Abdelrahman on 2023-08-21.
//  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
//
//  Permission is hereby granted to use this code in ECE467 at
//  the University of Toronto. It is prohibited to distribute
//  this code, either publicly or to third parties.

// This file contains the skeltal code for the smallC grammar

// ECE467 student: please 
//    1. complete the rules as indicated,
//    2. do NOT change the name of grammar
//    3. do NOT change the names of the non-terminals
//    4. do NOT change the order of the rules 
//    5. do NOT change the names of the takens

grammar smallC;

program: (preamble | ) decls* EOF;

preamble:  '#include' '"scio.h"';

decls:
    scalarDeclList
    | arrDeclList
    | fcnProto
    | fcnDecl
    ;

scalarDeclList:
    scalarDecl|
    scalarDecl scalarDeclList
;

scalarDecl: varType varName ';';

arrDeclList:
    arrDecl|
    arrDecl arrDeclList
;

arrDecl: // ECE467 student: add rule

fcnProto: // ECE467 student: add rule

fcnDecl: // ECE467 student: add rule

varType: // ECE467 student: add rule

retType: // ECE467 student: add rule

constant: // ECE467 student: add rule

boolConst: // ECE467 student: add rule

scope: // ECE467 student: add rule

stmt: // ECE467 student: add rule

assignStmt: // ECE467 student: add rule

ifStmt: // ECE467 student: add rule

whileStmt: // ECE467 student: add rule

retStmt: // ECE467 student: add rule

expr: // ECE467 student: add rule

intExpr: // ECE467 student: add rule

var: // ECE467 student: add rule

params: // ECE467 student: add rule

paramEntry: // ECE467 student: add rule

paramList: // ECE467 student: add rule

args: // ECE467 student: add rule

argEntry: // ECE467 student: add rule

argList: // ECE467 student: add rule

varName: // ECE467 student: add rule

arrName: // ECE467 student: add rule

fcnName: // ECE467 student: add rule

intConst: // ECE467 student: add rule

// ECE467 student: complete these tokens definitions and use 
// them in the rules 
ID: 
BOOL: '0' | '1';
INT:    
WS:   
COMMENT: '//' (~[\r\n])* -> skip;

