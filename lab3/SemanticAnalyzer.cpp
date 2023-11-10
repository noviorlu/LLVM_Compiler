//
//  SemanticAnalyzer.cpp
//  ECE467 Lab 3
//
//  Created by Tarek Abdelrahman on 2023-09-13.
//  Based on code written by Ao (Dino) Li for ECE467.
//  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
//
//  Permission is hereby granted to use this code in ECE467 at
//  the University of Toronto. It is prohibited to distribute
//  this code, either publicly or to third parties.

#include <iostream>
using namespace std;

#include "SemanticAnalyzer.h"
#include "SymTable.h"
#include <cassert>
using namespace smallc;

namespace smallc {

SemaError::SemaError (ErrorEnum code_, std::pair<unsigned int, unsigned int> location_) : code(code_), location(location_), msg() { }

SemaError::SemaError(ErrorEnum code_, std::pair<unsigned int, unsigned int> location_, std::string msg_) : code(code_), location(location_), msg(msg_) { }

// Constructor
SemanticAnalyzer::SemanticAnalyzer (): ASTVisitorBase(), prog(nullptr), errors() { }

// Print all the error messages at once
void
SemanticAnalyzer::printErrorMsgs () {
    for (const auto& e : errors) {
        std::cout << "sema: " << e.location.first
                  << ":" << e.location.second << " : ";
        switch (e.code) {
            case SemaError::IdentReDefined:
                std::cout << "redefinition of";
                break;
            case SemaError::IdentUnDefined:
                std::cout << "use of undefined identifier";
                break;
            case SemaError::NoMatchingDef:
                std::cout << "no matching definition for";
                break;
            case SemaError::MisMatchedReturn:
                std::cout << "mismatched return statement";
                break;
            case SemaError::InconsistentDef:
                std::cout << "definition inconsistent with earlier definition of";
                break;
            case SemaError::InvalidCond:
                std::cout << "invalid condition in";
                break;
            case SemaError::TypeMisMatch:
                std::cout << "type mismatch";
                break;
            case SemaError::InvalidArraySize:
                std::cout << "size cannot be negative for array";
                break;
            case SemaError::InvalidAccess:
                std::cout << "invalid use of identifier";
                break;
            default:
                std::cout << "unknown error number";
                break;
        }
        std::cout << " " << e.msg << std::endl;
    }
}

// Add an error to the list of errors
void
SemanticAnalyzer::addError (const SemaError& err) {
    errors.push_back(err);
}

// ECE467 STUDENT: implement the visitor classes, perfoming
// semantic analysis
void SemanticAnalyzer::visitASTNode(ASTNode *node) {
    ASTVisitorBase::visitASTNode(node);
}
void SemanticAnalyzer::visitArgumentNode(ArgumentNode *arg) {
    arg->getExpr()->visit(this);
    ASTVisitorBase::visitArgumentNode(arg);
}
void SemanticAnalyzer::visitDeclNode(DeclNode *decl) {
    ASTVisitorBase::visitDeclNode(decl);
}
void SemanticAnalyzer::visitArrayDeclNode(ArrayDeclNode *array) {
    array->getType()->visit(this);
    array->getIdent()->visit(this);
    ASTVisitorBase::visitArrayDeclNode(array);
}
void SemanticAnalyzer::visitFunctionDeclNode(FunctionDeclNode *func) {
    func->getRetType()->visit(this);
    func->getIdent()->visit(this);
    for (auto i: func->getParams())
        i->visit(this);
    if (func->getBody())
        func->getBody()->visit(this);
    ASTVisitorBase::visitFunctionDeclNode(func);
}
void SemanticAnalyzer::visitScalarDeclNode(ScalarDeclNode *scalar) {
    scalar->getType()->visit(this);
    scalar->getIdent()->visit(this);
    ASTVisitorBase::visitScalarDeclNode(scalar);
}
void SemanticAnalyzer::visitExprNode(ExprNode *exp) {
    ASTVisitorBase::visitExprNode(exp);
}
void SemanticAnalyzer::visitBinaryExprNode(BinaryExprNode *bin) {
    bin->getLeft()->visit(this);
    bin->getRight()->visit(this);
    ASTVisitorBase::visitBinaryExprNode(bin);
}
void SemanticAnalyzer::visitBoolExprNode(BoolExprNode *boolExpr) {
    boolExpr->getValue()->visit(this);
    ASTVisitorBase::visitBoolExprNode(boolExpr);
}
void SemanticAnalyzer::visitCallExprNode(CallExprNode *call) {
    call->getIdent()->visit(this);
    for (auto i: call->getArguments())
        i->visit(this);
    ASTVisitorBase::visitCallExprNode(call);
}
void SemanticAnalyzer::visitConstantExprNode(ConstantExprNode *constant) {
    ASTVisitorBase::visitConstantExprNode(constant);
}
void SemanticAnalyzer::visitBoolConstantNode(BoolConstantNode *boolConst) {
    ASTVisitorBase::visitBoolConstantNode(boolConst);
}
void SemanticAnalyzer::visitIntConstantNode(IntConstantNode *intConst) {
    ASTVisitorBase::visitIntConstantNode(intConst);
}
void SemanticAnalyzer::visitIntExprNode(IntExprNode *intExpr) {
    intExpr->getValue()->visit(this);
    ASTVisitorBase::visitIntExprNode(intExpr);
}
void SemanticAnalyzer::visitReferenceExprNode(ReferenceExprNode *ref) {
    ref->getIdent()->visit(this);
    if (ref->getIndex())
        ref->getIndex()->visit(this);
    ASTVisitorBase::visitReferenceExprNode(ref);
}
void SemanticAnalyzer::visitUnaryExprNode(UnaryExprNode *unary) {
    unary->getOperand()->visit(this);
    ASTVisitorBase::visitUnaryExprNode(unary);
}
void SemanticAnalyzer::visitIdentifierNode(IdentifierNode *id) {
    ASTVisitorBase::visitIdentifierNode(id);
}
void SemanticAnalyzer::visitParameterNode(ParameterNode *param) {
    param->getType()->visit(this);
    param->getIdent()->visit(this);
    ASTVisitorBase::visitParameterNode(param);
}
void SemanticAnalyzer::visitProgramNode(ProgramNode *prg) {
    /*SymbolTable Creation - BEGIN*/ 
    DeclNode *decl = nullptr;
    SymTable<VariableEntry>* venv = prg->getVarTable();
    SymTable<FunctionEntry>* fenv = prg->getFuncTable();

    int i = prg->getNumChildren() - 1;
    for(; i>=0; i--){
        decl = dynamic_cast<DeclNode *>(prg->getChild(i));
        if(decl == nullptr) assert(false);

        std::pair<unsigned int, unsigned int> loc(decl->getLine(), decl->getCol());
        std::string name = decl->getIdent()->getName();
        
        ScalarDeclNode * cast = dynamic_cast<ScalarDeclNode *>(decl);
        if(cast != nullptr){
            if(venv->contains(name)){
                // [Error 0]: sameName in SymbolTable
                SemanticAnalyzer::addError(SemaError(SemaError::ErrorEnum::IdentReDefined, loc, name));
                continue;
            }
            
            venv->insert(name, VariableEntry(cast->getType()));
            continue;
        }

        ArrayDeclNode * cast1 = dynamic_cast<ArrayDeclNode *>(decl);
        if(cast1 != nullptr){
            if(venv->contains(name)){
                // [Error 0]: sameName in SymbolTable
                SemanticAnalyzer::addError(SemaError(SemaError::ErrorEnum::IdentReDefined, loc, name));
                continue;
            }
            
            venv->insert(name, VariableEntry(cast1->getType()));
            continue;
        }

        FunctionDeclNode* cast2 = dynamic_cast<FunctionDeclNode *>(decl);
        if(cast2 != nullptr){
            fenv->insert(
                cast2->getIdent()->getName(), 
                FunctionEntry(
                    cast2->getRetType(),
                    cast2->getParamTypes(),
                    cast2->getProto()
                )
            );
            continue;
        }
        
        assert(false);
    }
    /*SymbolTable Creation - END*/ 

    ASTVisitorBase::visitProgramNode(prg);
}
void SemanticAnalyzer::visitStmtNode(StmtNode *stmt) {
    ASTVisitorBase::visitStmtNode(stmt);
}
void SemanticAnalyzer::visitAssignStmtNode(AssignStmtNode *assign) {
    assign->getTarget()->visit(this);
    assign->getValue()->visit(this);
    ASTVisitorBase::visitAssignStmtNode(assign);
}
void SemanticAnalyzer::visitExprStmtNode(ExprStmtNode *expr) {
    expr->getExpr()->visit(this);
    ASTVisitorBase::visitExprStmtNode(expr);
}
void SemanticAnalyzer::visitIfStmtNode(IfStmtNode *ifStmt) {
    ifStmt->getCondition()->visit(this);
    ifStmt->getThen()->visit(this);
    if (ifStmt->getHasElse())
        ifStmt->getElse()->visit(this);
    ASTVisitorBase::visitIfStmtNode(ifStmt);
}
void SemanticAnalyzer::visitReturnStmtNode(ReturnStmtNode *ret) {
    if (!ret->returnVoid())
        ret->getReturn()->visit(this);
    ASTVisitorBase::visitReturnStmtNode(ret);
}
void SemanticAnalyzer::visitScopeNode(ScopeNode *scope) {
    /*SymbolTable Creation - BEGIN*/ 
    DeclNode *decl = nullptr;
    SymTable<VariableEntry>* venv = scope->getVarTable();

    for(auto decl: scope->getDeclarations()){
        std::pair<unsigned int, unsigned int> loc(decl->getLine(), decl->getCol());
        std::string name = decl->getIdent()->getName();
        
        ScalarDeclNode * cast = dynamic_cast<ScalarDeclNode *>(decl);
        if(cast != nullptr){
            if(venv->contains(name)){
                // [Error 0]: sameName in SymbolTable
                SemanticAnalyzer::addError(SemaError(SemaError::ErrorEnum::IdentReDefined, loc, name));
                continue;
            }
            
            venv->insert(name, VariableEntry(cast->getType()));
            continue;
        }

        ArrayDeclNode * cast1 = dynamic_cast<ArrayDeclNode *>(decl);
        if(cast1 != nullptr){
            if(venv->contains(name)){
                // [Error 0]: sameName in SymbolTable
                SemanticAnalyzer::addError(SemaError(SemaError::ErrorEnum::IdentReDefined, loc, name));
                continue;
            }
            
            venv->insert(name, VariableEntry(cast1->getType()));
            continue;
        }
        
        assert(false);
    }
    /*SymbolTable Creation - END*/ 
    
    for (auto i: scope->getDeclarations())
        i->visit(this);
    
    ASTVisitorBase::visitScopeNode(scope);
}
void SemanticAnalyzer::visitWhileStmtNode(WhileStmtNode *whileStmt) {
    whileStmt->getCondition()->visit(this);
    whileStmt->getBody()->visit(this);
    ASTVisitorBase::visitWhileStmtNode(whileStmt);
}
void SemanticAnalyzer::visitTypeNode(TypeNode *type) {
    ASTVisitorBase::visitTypeNode(type);
}
void SemanticAnalyzer::visitPrimitiveTypeNode(PrimitiveTypeNode *type) {
    ASTVisitorBase::visitPrimitiveTypeNode(type);
}
void SemanticAnalyzer::visitArrayTypeNode(ArrayTypeNode *type) {
    ASTVisitorBase::visitArrayTypeNode(type);
}
bool SemanticAnalyzer::success(){
    if(errors.size())
        return false;
    return true;
}
}