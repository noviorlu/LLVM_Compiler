//
//  smallC.g4
//  ECE467 Lab 3
//
//  Created by Tarek Abdelrahman on 2023-09-13.
//  Based on code written by Ao (Dino) Li for ECE467.
//  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
//
//  Permission is hereby granted to use this code in ECE467 at
//  the University of Toronto. It is prohibited to distribute
//  this code, either publicly or to third parties.

grammar smallC;

@header {
#include "ASTNodes.h"
#include <iostream>
#include <string>
}

program
returns [smallc::ProgramNode *prg]
@init {
    $prg = new smallc::ProgramNode();
    $prg->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
}
: (preamble {$prg->setIo(true);}
| ) (decls
{
    for(unsigned int i = 0; i < $decls.declarations.size();i++)
        $prg->addChild($decls.declarations[i]);
}
)* EOF ;

preamble:  '#include' '"scio.h"';

decls 
returns [std::vector<smallc::DeclNode *> declarations]
:
    scalarDeclList 
    {
        for(smallc::DeclNode * scalardecl : $scalarDeclList.scalardecls)
            $declarations.push_back(scalardecl);
    }
    | arrDeclList
    {
        for(smallc::DeclNode * arrdecl : $arrDeclList.arrdecls)
            $declarations.push_back(arrdecl);
    }
    | fcnProto
    {
        $declarations.push_back($fcnProto.fcndeclaration);
    }
    | fcnDecl
    {
        $declarations.push_back($fcnDecl.fcndeclaration);
    }
;

scalarDeclList
returns [std::vector<smallc::ScalarDeclNode*> scalardecls]
    :
    scalarDecl
    {
        $scalardecls.push_back($scalarDecl.scalardecl);
    }
    | scalarDecl scalarDeclList
    {
        $scalardecls.push_back($scalarDecl.scalardecl);
        for(smallc::ScalarDeclNode* decl : $scalarDeclList.scalardecls)
            $scalardecls.push_back(decl);
    }
;

scalarDecl 
returns [smallc::ScalarDeclNode* scalardecl]
@init {
    $scalardecl = new smallc::ScalarDeclNode();
}
: 
    varType varName ';'
    {
        $scalardecl->setType($varType.type);
        $scalardecl->setName($varName.name);
    }
;

arrDeclList 
returns [std::vector<smallc::ArrayDeclNode *> arrdecls]
:
    arrDecl
    { 
        $arrdecls.push_back($arrDecl.arrdecl);
    }
    | arrDecl arrDeclList
    {
        $arrdecls.push_back($arrDecl.arrdecl);
        for(smallc::ArrayDeclNode* decl : $arrDeclList.arrdecls)
            $arrdecls.push_back(decl);
    }
;

arrDecl 
returns [smallc::ScalarDeclNode* arrdecl] locals[smallc::ArrayTypeNode * type]
:
    varType arrName '[' intConst ']' ';'
    {
        $type = new smallc::ArrayTypeNode($varType.type, $intConst.intconst->getVal());
        $arrdecl = new smallc::ScalarDeclNode($type, $arrName.name);
    }
;

fcnProto
returns [smallc::FunctionDeclNode * fcndeclaration]
@init{
    $fcndeclaration = new smallc::FunctionDeclNode();
    $fcndeclaration->setProto(true);
}
:
    retType fcnName '(' params ')' ';'
    {
        $fcndeclaration->setRetType($retType.rettype);
        $fcndeclaration->setName($fcnName.name);
        $fcndeclaration->setParameter($params.paramlist);
    }
;

fcnDecl 
returns [smallc::FunctionDeclNode * fcndeclaration]
@init{
    $fcndeclaration = new smallc::FunctionDeclNode();
    $fcndeclaration->setProto(false);
    $fcndeclaration->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
}
:
    retType fcnName '(' params ')' scope
    {
        $fcndeclaration->setRetType($retType.rettype);
        $fcndeclaration->setName($fcnName.name);
        $fcndeclaration->setParameter($params.paramlist);
        $fcndeclaration->setBody($scope.scope_);
    }
;

varType 
returns [smallc::PrimitiveTypeNode* type]
@init{ 
    $type = new smallc::PrimitiveTypeNode();
    $type->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
}
:
    'bool'
    {
        $type->setType(smallc::TypeNode::TypeEnum::Bool);
    }
    | 'int'
    {
        $type->setType(smallc::TypeNode::TypeEnum::Int);
    }
;

retType 
returns [smallc::PrimitiveTypeNode* rettype]
:
    'void'
    {
        $rettype = new smallc::PrimitiveTypeNode();
        $rettype->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
    }
    | varType
    {
        $rettype = $varType.type;
    }
;

constant
returns[smallc::ConstantExprNode* expression]
:
    boolConst
    {
        $expression = $boolConst.boolconst;
    }
    | intConst
    {
        $expression = $intConst.intconst;
    }
;

boolConst 
returns[smallc::BoolConstantNode* boolconst]
:
    BOOL
    {
        $boolconst = new smallc::BoolConstantNode($BOOL.text);
    }
;

scope
returns[smallc::ScopeNode* scope_]
@init{
    $scope_ = new smallc::ScopeNode();
    $scope_->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
}
:
    '{' (scalarDecl
    {$scope_->addDeclaration($scalarDecl.scalardecl);}
    |arrDecl
    {$scope_->addDeclaration($arrDecl.arrdecl);}
    )* (stmt
    {$scope_->addChild($stmt.statement);}
    )* '}'
;

stmt 
returns [smallc::StmtNode* statement]
:
    expr ';'
    | assignStmt
    {
        $statement = $assignStmt.assignstatement;
    }
    | ifStmt
    {
        $statement = $ifStmt.ifstatement;
    }
    | whileStmt
    {
        $statement = $whileStmt.whilestatement;
    }
    | retStmt
    {
        $statement = $retStmt.returnstatement;
    }
    | scope
    {
        $statement = $scope.scope_;
    }
;

assignStmt
returns [smallc::AssignStmtNode* assignstatement]
@init{ 
    $assignstatement = new smallc::AssignStmtNode();
}
:
    var '=' expr ';'
    { 
        $assignstatement->setTarget($var.expression);
        $assignstatement->setValue($expr.expression);
    }
;

ifStmt 
returns [smallc::IfStmtNode* ifstatement]
:
    'if' '(' expr ')' stmt
    {
        $ifstatement = new smallc::IfStmtNode($expr.expression, $stmt.statement);
    }
    | 'if' '(' expr ')' then=stmt 'else' e=stmt
    {
        $ifstatement = new smallc::IfStmtNode($expr.expression, $then.statement, $e.statement);
    }
;

whileStmt 
returns [smallc::WhileStmtNode* whilestatement]
:
    'while' '(' expr ')' stmt
    {
        $whilestatement = new smallc::WhileStmtNode($expr.expression, $stmt.statement);
    }
;

retStmt 
returns [smallc::ReturnStmtNode* returnstatement]
:
    'return' expr ';'
    { 
        $returnstatement = new smallc::ReturnStmtNode($expr.expression);
    }
    |'return' ';'
    { 
        $returnstatement = new smallc::ReturnStmtNode();
    }
;

expr 
returns[smallc::ExprNode* expression] locals [smallc::BinaryExprNode* tmp, smallc::UnaryExprNode* tmp1]
:
    intExpr
    {
        $expression = $intExpr.expression;
    }
    | '(' expr ')'
    {
        $expression = $expr.expression;
    }
    | fcnName '(' args ')'
    {
        $expression = new smallc::CallExprNode($fcnName.name, $args.arglist);
    }
    | op=('!' | '-') expr
    {
        $tmp1 = new smallc::UnaryExprNode($expr.expression);
        $tmp1->setOpcode($op.text);
        $expression = $tmp1;
    }
    | l=expr op=('<' | '<=' | '>' | '>=') r=expr
    {
        $tmp = new smallc::BinaryExprNode($l.expression, $r.expression);
        $tmp->setOpcode($op.text);
        $expression = $tmp;
    }
    | l=expr op=('==' | '!=') r=expr
    {
        $tmp = new smallc::BinaryExprNode($l.expression, $r.expression);
        $tmp->setOpcode($op.text);
        $expression = $tmp;
    }
    | l=expr op='||' r=expr
    {
        $tmp = new smallc::BinaryExprNode($l.expression, $r.expression);
        $tmp->setOpcode($op.text);
        $expression = $tmp;
    }
    | l=expr op='&&' r=expr
    {
        $tmp = new smallc::BinaryExprNode($l.expression, $r.expression);
        $tmp->setOpcode($op.text);
        $expression = $tmp;
    }
;

intExpr 
returns[smallc::ExprNode* expression] locals [smallc::BinaryExprNode* tmp]
:
    var
    {
        $expression = $var.expression;
    }
    | constant
    {
        $expression = $constant.expression;
    }
    | l=intExpr op=('*' | '/' ) r=intExpr
    {
        $tmp = new smallc::BinaryExprNode($l.expression, $r.expression);
        $tmp->setOpcode($op.text);
        $expression = $tmp;
    }
    | l=intExpr op=('+' | '-' ) r=intExpr
    {
        $tmp = new smallc::BinaryExprNode($l.expression, $r.expression);
        $tmp->setOpcode($op.text);
        $expression = $tmp;
    }
    | '(' intExpr ')'
    {
        $expression = $intExpr.expression;
    }
;

var 
returns[smallc::ReferenceExprNode* expression]
@init{
    $expression = new smallc::ReferenceExprNode();
}
:
    varName
    {
        $expression->setIdent($varName.name);
    }
    | arrName '[' intExpr ']'
    {
        $expression->setIdent($arrName.name);
        $expression->setIndex(static_cast<smallc::IntExprNode*>($intExpr.expression));
    } 
;

params
returns[std::vector<smallc::ParameterNode*> paramlist]
:
    paramList
    { 
        $paramlist = $paramList.paramlist;
    }
    | ;

paramEntry
returns[smallc::ParameterNode* paramentry] locals [smallc::PrimitiveTypeNode* savetype]
@init{ 
    $paramentry = new smallc::ParameterNode();
}
:
    varType varName
    { 
        $paramentry->setType($varType.type);
        $paramentry->setIdent($varName.name);
    }
    | varType arrName '[]' 
    { 
        $savetype = $varType.type;
        $paramentry->setIdent($arrName.name);
        $paramentry->setType(new smallc::ArrayTypeNode($savetype));
    }
;

paramList
returns[std::vector<smallc::ParameterNode*> paramlist]
:
    paramEntry
    { 
        $paramlist.push_back($paramEntry.paramentry);
    }
    | paramEntry ',' paramList  
    { 
        $paramlist.push_back($paramEntry.paramentry);
        for(smallc::ParameterNode* param : $paramList.paramlist)
            $paramlist.push_back(param);
    }
;

args 
returns[std::vector<smallc::ArgumentNode*> arglist]
:
    argList
    {
        $arglist = $argList.arglist;
    }
    |
;

argEntry 
returns[smallc::ArgumentNode* arg]
:
    expr
    { 
        $arg = new smallc::ArgumentNode($expr.expression);
    }
;

argList 
returns[std::vector<smallc::ArgumentNode*> arglist]
:
    argEntry
    {
        $arglist.push_back($argEntry.arg);
    }
    | argEntry ',' argList
    {
        $arglist.push_back($argEntry.arg);
        for(smallc::ArgumentNode* arg : $argList.arglist)
            $arglist.push_back(arg);
    }
;
varName 
returns [smallc::IdentifierNode* name]
: ID
    { 
        $name = new smallc::IdentifierNode($ID.text);
        $name->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
    }
;

arrName
returns [smallc::IdentifierNode* name]
: ID
    { 
        $name = new smallc::IdentifierNode($ID.text);
        $name->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
    }
;

fcnName 
returns [smallc::IdentifierNode* name]
: ID
    { 
        $name = new smallc::IdentifierNode($ID.text);
        $name->setLocation($ctx->start->getLine(), $ctx->start->getCharPositionInLine());
    }
;

intConst 
returns[smallc::IntConstantNode* intconst]
: 
    INT
    {
        $intconst = new smallc::IntConstantNode($INT.text);
    }
    | '-' INT
    {
        $intconst = new smallc::IntConstantNode("-" + $INT.text);
    }
;

BOOL: 'true' | 'false';
ID: [a-zA-Z][a-zA-Z0-9_]* ;
INT:    [0] | ([1-9][0-9]*);
WS:     [ \t\r\n]+ -> skip;
COMMENT: '//' (~[\r\n])* -> skip;
