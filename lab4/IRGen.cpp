//
//  IRGen.cpp
//  ECE467 Lab 4
//
//  Created by Tarek Abdelrahman on 2023-10-13.
//  Based on code written by Ao (Dino) Li for ECE467.
//  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
//
//  Permission is hereby granted to use this code in ECE467 at
//  the University of Toronto. It is prohibited to distribute
//  this code, either publicly or to third parties.

#include <iostream>
using namespace std;

#include "IRGen.h"
#include "SymTable.h"
#include "ASTVisitorBase.h"
using namespace smallc;
using namespace llvm;

namespace smallc {

IRGen::IRGen(const std::string moduleName) : ASTVisitorBase(),
                                             prog(nullptr),
                                             TheModule(),
                                             Builder(),
                                             ModuleName(moduleName) {
    TheContext = std::make_unique<llvm::LLVMContext>();
}

unique_ptr<Module> 
IRGen::getModule() {
    Builder.reset();
    return std::move(TheModule);
}

llvm::Type*
IRGen::convertType(TypeNode* type){
    llvm::Type* base;
    switch(type->getTypeEnum()){
        case TypeNode::TypeEnum::Void:
            base = llvm::Type::getVoidTy(*TheContext);
            break;
        case TypeNode::TypeEnum::Int:
            base = llvm::Type::getInt32Ty(*TheContext);
            break;
        case TypeNode::TypeEnum::Bool:
            base = llvm::Type::getInt1Ty(*TheContext);
            break;
    }
    if(type->isArray()){
        ArrayTypeNode* arrType = (ArrayTypeNode*) type;
        return llvm::ArrayType::get(base, arrType->getSize());
    }
    return base;
}

SymTable<VariableEntry>*
IRGen::findTable(IdentifierNode* id){
    ASTNode* parent = id->getParent();
    bool found = false;
    SymTable<VariableEntry>* res = nullptr;
    while (parent && !found){
        if (parent->hasVarTable()){
            if (parent->getParent()){
                ScopeNode* scope = (ScopeNode*)parent;
                res = scope->getVarTable();
            }
            else {
                res = id->getRoot()->getVarTable();
            }
            if (res && res->contains(id->getName()))
                found = true;
        }
        parent = parent->getParent();
    }
    return res;
}

// ECE467 STUDENT: complete the implementation of the visitor functions

void
IRGen::visitASTNode (ASTNode* node) {

}

void 
IRGen::visitArgumentNode (ArgumentNode* arg) {

}

void 
IRGen::visitDeclNode (DeclNode* decl) {
    
}

void
IRGen::visitArrayDeclNode (ArrayDeclNode* array) {
 
}

void
IRGen::visitFunctionDeclNode (FunctionDeclNode* func) {

}

void
IRGen::visitScalarDeclNode (ScalarDeclNode* scalar) {

}

void 
IRGen::visitExprNode (ExprNode* exp) {

}

void 
IRGen::visitBinaryExprNode(BinaryExprNode* bin) {

}

void 
IRGen::visitBoolExprNode (BoolExprNode* boolExpr) {

}

void
IRGen::visitCallExprNode (CallExprNode* call) {

}

void 
IRGen::visitConstantExprNode(ConstantExprNode* constant) {
   
}

void 
IRGen::visitBoolConstantNode(BoolConstantNode* boolConst) {

}

void 
IRGen::visitIntConstantNode(IntConstantNode* intConst) {

}

void
IRGen::visitIntExprNode(IntExprNode* intExpr) {
 
}

void
IRGen::visitReferenceExprNode(ReferenceExprNode* ref) {

}

void 
IRGen::visitUnaryExprNode(UnaryExprNode* unary) {
 
}

void 
IRGen::visitIdentifierNode(IdentifierNode* id) {
    
}

void
IRGen::visitParameterNode(ParameterNode* param) {

}

void
IRGen::visitProgramNode(ProgramNode* prg) {

}

void 
IRGen::visitStmtNode(StmtNode* stmt) {
    
}

void 
IRGen::visitAssignStmtNode(AssignStmtNode* assign) {

}

void 
IRGen::visitExprStmtNode(ExprStmtNode* expr) {

}

void 
IRGen::visitIfStmtNode(IfStmtNode* ifStmt) {

}

void 
IRGen::visitReturnStmtNode(ReturnStmtNode* ret) {

}

void 
IRGen::visitScopeNode(ScopeNode* scope) {

}

void 
IRGen::visitWhileStmtNode(WhileStmtNode* whileStmt) {

}

void 
IRGen::visitTypeNode(TypeNode* type) {
   
}

void 
IRGen::visitPrimitiveTypeNode(PrimitiveTypeNode* type) {
    
}

void 
IRGen::visitArrayTypeNode(ArrayTypeNode* type) {

}

} // namespace smallc
