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
	if(arrType->getSize() == 0) return llvm::PointerType::get(base, 0);
        return llvm::ArrayType::get(base, arrType->getSize());
    }
    return base;
}
SymTable<VariableEntry>*
IRGen::findTable(IdentifierNode* id, bool& isRoot){
    isRoot = false;
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
                isRoot = true;
            }
            if (res && res->contains(id->getName())){
                found = true;
            }
            else res = nullptr;
        }
        parent = parent->getParent();
    }
    return res;
}

SymTable<VariableEntry>*
findClosestTable(IdentifierNode* id){
    ASTNode* parent = id->getParent();
    SymTable<VariableEntry>* res = nullptr;
    while (res == nullptr && parent != nullptr){
        if (parent->hasVarTable()){
            if (parent->getParent()){
                ScopeNode* scope = (ScopeNode*)parent;
                res = scope->getVarTable();
            }
            else {
                res = id->getRoot()->getVarTable();
            }
        }
        parent = parent->getParent();
    }
    return res;
}

// ECE467 STUDENT: complete the implementation of the visitor functions

void
IRGen::visitASTNode (ASTNode* node) {
    ASTVisitorBase::visitASTNode(node);
}

void 
IRGen::visitArgumentNode (ArgumentNode* arg) {
    arg->getExpr()->visit(this);
    ASTVisitorBase::visitArgumentNode(arg);
}

void 
IRGen::visitDeclNode (DeclNode* decl) {
    ASTVisitorBase::visitDeclNode(decl);
}

void
IRGen::visitArrayDeclNode (ArrayDeclNode* array) {
    bool isRoot;
    SymTable<VariableEntry>* venv = findTable(array->getIdent(), isRoot);
    llvm::Type* declType = convertType(array->getType());
    std::string name = array->getIdent()->getName();
    
    // Global variable
    if(isRoot){
        llvm::GlobalVariable* globalVar = new llvm::GlobalVariable(
            *TheModule,
            declType,
            false,
            llvm::GlobalValue::CommonLinkage,
            llvm::Constant::getNullValue(declType),
            name
        );
        venv->setLLVMValue(name, globalVar);
    }
    // Stack variable
    else{
        llvm::Value* alloca = Builder->CreateAlloca(declType, nullptr, name);
        venv->setLLVMValue(name, alloca);
    }

    ASTVisitorBase::visitArrayDeclNode(array);
}

void
IRGen::visitFunctionDeclNode (FunctionDeclNode* func) {
    // Return Type
    llvm::Type* retType = convertType(func->getRetType());
    
    // Parameter Types
    std::vector<ParameterNode*> paramTypeList = func->getParams();
    std::vector<llvm::Type*> paramTypes;
    for(auto i : paramTypeList){
        paramTypes.push_back(convertType(i->getType()));
    }
    
    
    // Function insert to Module
    TheFunction = llvm::Function::Create(
        llvm::FunctionType::get(
            retType, 
            paramTypes, 
            false
        ), 
        llvm::Function::ExternalLinkage,
        func->getIdent()->getName(), 
        TheModule.get()
    );

    // Iterate over the arguments of the function
    for (llvm::Argument& arg : TheFunction->args()) {
        // Check if the type of the argument is i1 (boolean)
        if (arg.getType()->isIntegerTy(1)) {
            // Add the ZExt attribute to the argument
            arg.addAttr(llvm::Attribute::ZExt);
        }
    }
    
    // If Function not a Prototype
    if(func->getBody()){
        llvm::BasicBlock *entry = BasicBlock::Create(*TheContext, "entry", TheFunction);
        Builder->SetInsertPoint(entry);

        SymTable<VariableEntry>* venv = func->getBody()->getVarTable();
        std::string name;
        bool isRoot = false;
        for(int i = 0; i< paramTypeList.size(); i++){
            auto param = paramTypeList[i];
            name = param->getIdent()->getName();
            
            llvm::Argument* arg = TheFunction->getArg(i);
            arg->setName(param->getIdent()->getName());

            llvm::Value* alloca = Builder->CreateAlloca(
                paramTypes[i], 
                nullptr, 
                name
            );
            
            venv->setLLVMValue(name, alloca);
            
            // Create first set of Instr for store arguments into new alloc variables
            Builder->CreateStore(arg, alloca);
        }

        // go into Body Scope
        func->getBody()->visit(this);
    }
    
    if(func->getRetType()->getTypeEnum() == TypeNode::TypeEnum::Void)
        Builder->CreateRetVoid();
    ASTVisitorBase::visitFunctionDeclNode(func);
}

void
IRGen::visitScalarDeclNode (ScalarDeclNode* scalar) {
    bool isRoot;
    SymTable<VariableEntry>* venv = findTable(scalar->getIdent(), isRoot);
    llvm::Type* declType = convertType(scalar->getType());
    std::string name = scalar->getIdent()->getName();

    // Global variable
    if(isRoot){
        llvm::GlobalVariable* globalVar = new llvm::GlobalVariable(
            *TheModule,
            declType,
            false,
            llvm::GlobalValue::CommonLinkage,
            llvm::Constant::getNullValue(declType),
            name
        );
        venv->setLLVMValue(name, globalVar);
    }
    // Stack variable
    else{
        llvm::Value* alloca = Builder->CreateAlloca(declType, nullptr, name);
        venv->setLLVMValue(name, alloca);
    }
    
    ASTVisitorBase::visitScalarDeclNode(scalar);
}

void 
IRGen::visitExprNode (ExprNode* exp) {
    ASTVisitorBase::visitExprNode(exp);
}

void 
IRGen::visitBinaryExprNode(BinaryExprNode* bin) {
    bin->getLeft()->visit(this);
    llvm::Value* L = bin->getLeft()->getLLVMValue();

    bin->getRight()->visit(this);
    llvm::Value* R = bin->getRight()->getLLVMValue();

    llvm::Value* retVal;

    switch (bin->getOpcode()) {
        case ExprNode::Opcode::Addition:
            retVal = Builder->CreateAdd(L, R, "");
            break;
        case ExprNode::Opcode::Subtraction:
            retVal = Builder->CreateSub(L, R, "");
            break;
        case ExprNode::Opcode::Multiplication:
            retVal = Builder->CreateMul(L, R, "");
            break;
        case ExprNode::Opcode::Division:
            retVal = Builder->CreateSDiv(L, R, "");
            break;
        case ExprNode::Opcode::And:
            retVal = Builder->CreateAnd(L, R, "");
            break;
        case ExprNode::Opcode::Or:
            retVal = Builder->CreateOr(L, R, "");
            break;
        case ExprNode::Opcode::Equal:
            retVal = Builder->CreateICmpEQ(L, R, "");
            break;
        case ExprNode::Opcode::NotEqual:
            retVal = Builder->CreateICmpNE(L, R, "");
            break;
        case ExprNode::Opcode::LessThan:
            retVal =  Builder->CreateICmpSLT(L, R, "");
            break;
        case ExprNode::Opcode::LessorEqual:
            retVal =  Builder->CreateICmpSLE(L, R, "");
            break;
        case ExprNode::Opcode::Greater:
            retVal =  Builder->CreateICmpSGT(L, R, "");
            break;
        case ExprNode::Opcode::GreaterorEqual:
            retVal =  Builder->CreateICmpSGE(L, R, "");
            break;
    }
    bin->setLLVMValue(retVal);
    ASTVisitorBase::visitBinaryExprNode(bin);
}

void 
IRGen::visitBoolExprNode (BoolExprNode* boolExpr) {
    boolExpr->getValue()->visit(this);
    boolExpr->setLLVMValue(boolExpr->getValue()->getLLVMValue());
    ASTVisitorBase::visitBoolExprNode(boolExpr);
}

void
IRGen::visitCallExprNode (CallExprNode* call) {
    llvm::Function* F = TheModule->getFunction(call->getIdent()->getName());
    assert(F != nullptr);
    std::vector<llvm::Value*> args;
    int counter = 0;
    for (auto i: call->getArguments()){
        i->visit(this);
        llvm::Value* val = i->getExpr()->getLLVMValue();
        args.push_back(val);
    }
    if(F->getReturnType()->isVoidTy()){
        Builder->CreateCall(F, args, "");
        call->setLLVMValue(nullptr);
    }
    else
        call->setLLVMValue(Builder->CreateCall(F, args, ""));
    ASTVisitorBase::visitCallExprNode(call);
}

void 
IRGen::visitConstantExprNode(ConstantExprNode* constant) {
    llvm::Constant* constVal;
    if(constant->getType()->getTypeEnum() == TypeNode::TypeEnum::Bool){
        constVal = Builder->getInt1(constant->getVal());
    }
    else if(constant->getType()->getTypeEnum() == TypeNode::TypeEnum::Int){
        constVal = Builder->getInt32(constant->getVal());
    }
    constant->setLLVMValue(constVal);
    ASTVisitorBase::visitConstantExprNode(constant);
}

void 
IRGen::visitBoolConstantNode(BoolConstantNode* boolConst) {
    ASTVisitorBase::visitBoolConstantNode(boolConst);
}

void 
IRGen::visitIntConstantNode(IntConstantNode* intConst) {
    ASTVisitorBase::visitIntConstantNode(intConst);
}

void
IRGen::visitIntExprNode(IntExprNode* intExpr) {
    intExpr->getValue()->visit(this);
    intExpr->setLLVMValue(intExpr->getValue()->getLLVMValue());
    ASTVisitorBase::visitIntExprNode(intExpr);
}

void
IRGen::visitReferenceExprNode(ReferenceExprNode* ref) {
    bool isRoot;
    string name = ref->getIdent()->getName();
    auto venvEntry = findTable(ref->getIdent(),isRoot)->get(name);
    
    llvm::Value* val = venvEntry.getValue();
    llvm::Type* type = convertType(venvEntry.getType());
    
    // Array (type definitetly Pointer)
    if (ref->getIndex()){
        ref->getIndex()->visit(this);

        if(dynamic_cast<ArrayTypeNode*>(venvEntry.getType())->getSize()!=0){
            val = Builder->CreateGEP(
                type, 
                val, 
                std::vector<Value*>{
                    // represent base address of array
                    llvm::ConstantInt::get(llvm::Type::getInt32Ty(*TheContext), 0),
                    // represent index of element
                    ref->getIndex()->getLLVMValue()
                }
            );

            type = type->getArrayElementType();
        }
        // Array Pointer
        else{
            llvm::Value* load = Builder->CreateLoad(type, val, "");
            PrimitiveTypeNode* node = new PrimitiveTypeNode(venvEntry.getType()->getTypeEnum());
            type = convertType(node);
            val = Builder->CreateGEP(
                type, 
                load, 
                std::vector<Value*>{ref->getIndex()->getLLVMValue()}
            );
        }
    }
    else{
        // Array Pointer
        if(venvEntry.getType()->isArray()){
            val = Builder->CreateGEP(
                type, 
                val, 
                std::vector<Value*>{
                    // represent base address of array
                    llvm::ConstantInt::get(llvm::Type::getInt32Ty(*TheContext), 0),
                    // represent index of element
                    llvm::ConstantInt::get(llvm::Type::getInt32Ty(*TheContext), 0)
                }
            );
            goto RefNoLD;
        }
    }

    if(refCreateLoad)
        ref->setLLVMValue(Builder->CreateLoad(type,val,""));
    else{
RefNoLD:
        ref->setLLVMValue(val);
    }
        
    ASTVisitorBase::visitReferenceExprNode(ref);
}

void 
IRGen::visitUnaryExprNode(UnaryExprNode* unary) {
    unary->getOperand()->visit(this);
    llvm::Value* retVal;
    llvm::Value* R = unary->getOperand()->getLLVMValue();

    switch (unary->getOpcode()) {
        case ExprNode::Opcode::Not:
            retVal = Builder->CreateNot(R, "");
            break;
        case ExprNode::Opcode::Minus:
            
            llvm::Value* zero = llvm::ConstantInt::get(R->getType(), 0);
            retVal = Builder->CreateSub(zero, R, "");
            break;
        
    }
    unary->setLLVMValue(retVal);
    
    ASTVisitorBase::visitUnaryExprNode(unary);
}

void 
IRGen::visitIdentifierNode(IdentifierNode* id) {
    ASTVisitorBase::visitIdentifierNode(id);
}

void
IRGen::visitParameterNode(ParameterNode* param) {
    ASTVisitorBase::visitParameterNode(param);
}

void
IRGen::visitProgramNode(ProgramNode* prg) {
    TheModule = std::make_unique<llvm::Module>(ModuleName, *TheContext);
    Builder = std::make_unique<llvm::IRBuilder<>>(*TheContext);

    llvm::Function::Create(
        llvm::FunctionType::get(
            llvm::Type::getVoidTy(*TheContext), 
            std::vector<llvm::Type*>(), 
            false
        ), 
        llvm::Function::ExternalLinkage,
        "newLine", 
        TheModule.get()
    );

    llvm::Function::Create(
        llvm::FunctionType::get(
            llvm::Type::getInt1Ty(*TheContext), 
            std::vector<llvm::Type*>(), 
            false
        ), 
        llvm::Function::ExternalLinkage,
        "readBool", 
        TheModule.get()
    );

    llvm::Function::Create(
        llvm::FunctionType::get(
            llvm::Type::getInt32Ty(*TheContext), 
            std::vector<llvm::Type*>(), 
            false
        ), 
        llvm::Function::ExternalLinkage,
        "readInt", 
        TheModule.get()
    );

    auto func = llvm::Function::Create(
        llvm::FunctionType::get(
            llvm::Type::getVoidTy(*TheContext), 
            std::vector<llvm::Type*>{
                llvm::Type::getInt1Ty(*TheContext)
            }, 
            false
        ), 
        llvm::Function::ExternalLinkage,
        "writeBool", 
        TheModule.get()
    );
    llvm::Argument* firstArg = &*func->arg_begin();
    firstArg->addAttr(llvm::Attribute::ZExt);

    llvm::Function::Create(
        llvm::FunctionType::get(
            llvm::Type::getVoidTy(*TheContext), 
            std::vector<llvm::Type*>{
                llvm::Type::getInt32Ty(*TheContext)
            }, 
            false
        ), 
        llvm::Function::ExternalLinkage,
        "writeInt", 
        TheModule.get()
    );

    ASTVisitorBase::visitProgramNode(prg);
}

void 
IRGen::visitStmtNode(StmtNode* stmt) {
    ASTVisitorBase::visitStmtNode(stmt);
}

void 
IRGen::visitAssignStmtNode(AssignStmtNode* assign) {
    assign->getValue()->visit(this);

    refCreateLoad = false;
    assign->getTarget()->visit(this);
    refCreateLoad = true;

    
    Builder->CreateStore(assign->getValue()->getLLVMValue(), assign->getTarget()->getLLVMValue());
    ASTVisitorBase::visitAssignStmtNode(assign);
}

void 
IRGen::visitExprStmtNode(ExprStmtNode* expr) {
    expr->getExpr()->visit(this);
    ASTVisitorBase::visitExprStmtNode(expr);
}

void 
IRGen::visitIfStmtNode(IfStmtNode* ifStmt) {
    llvm::BasicBlock* ThenBB = llvm::BasicBlock::Create(*TheContext, "then", TheFunction);
    llvm::BasicBlock* MergeBB = llvm::BasicBlock::Create(*TheContext, "merge", TheFunction);
    llvm::BasicBlock* ElseBB;

    if(ifStmt->getHasElse())
        ElseBB = llvm::BasicBlock::Create(*TheContext, "else", TheFunction);
    else
        ElseBB = MergeBB;

    ifStmt->getCondition()->visit(this);
    Builder->CreateCondBr(ifStmt->getCondition()->getLLVMValue(), ThenBB, ElseBB);

    Builder->SetInsertPoint(ThenBB);
    ifStmt->getThen()->visit(this);
    Builder->CreateBr(MergeBB);

    if (ifStmt->getHasElse()){
        Builder->SetInsertPoint(ElseBB);
        ifStmt->getElse()->visit(this);
        Builder->CreateBr(MergeBB);
    }
    

    Builder->SetInsertPoint(MergeBB);
    ASTVisitorBase::visitIfStmtNode(ifStmt);
}

void 
IRGen::visitReturnStmtNode(ReturnStmtNode* ret) {
    if (!ret->returnVoid()){
        ret->getReturn()->visit(this);
        Builder->CreateRet(ret->getReturn()->getLLVMValue());
    }
    else{
        Builder->CreateRetVoid();
    }
    
    ASTVisitorBase::visitReturnStmtNode(ret);
}

void 
IRGen::visitScopeNode(ScopeNode* scope) {
    for (auto i: scope->getDeclarations())
        i->visit(this);
    ASTVisitorBase::visitScopeNode(scope);
}

void 
IRGen::visitWhileStmtNode(WhileStmtNode* whileStmt) {
    llvm::BasicBlock* whileCond = BasicBlock::Create(*TheContext, "while.cond", TheFunction);
    llvm::BasicBlock* whileBody = BasicBlock::Create(*TheContext, "while.body", TheFunction);
    llvm::BasicBlock* whileExit = BasicBlock::Create(*TheContext, "while.exit", TheFunction);
    Builder->CreateBr(whileCond);

    Builder->SetInsertPoint(whileCond);
    whileStmt->getCondition()->visit(this);
    Builder->CreateCondBr(whileStmt->getCondition()->getLLVMValue(), whileBody, whileExit);
    
    Builder->SetInsertPoint(whileBody);
    whileStmt->getBody()->visit(this);
    Builder->CreateBr(whileCond);
    
    Builder->SetInsertPoint(whileExit);
    ASTVisitorBase::visitWhileStmtNode(whileStmt);
}

void 
IRGen::visitTypeNode(TypeNode* type) {
    ASTVisitorBase::visitTypeNode(type);
}

void 
IRGen::visitPrimitiveTypeNode(PrimitiveTypeNode* type) {
    ASTVisitorBase::visitPrimitiveTypeNode(type);
}

void 
IRGen::visitArrayTypeNode(ArrayTypeNode* type) {
    ASTVisitorBase::visitArrayTypeNode(type);
}

} // namespace smallc
