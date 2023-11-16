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
            llvm::GlobalValue::ExternalLinkage,
            nullptr,
            name
        );
        venv->setLLVMValue(name, globalVar);
    }
    // Stack variable
    else{
        assert(declType->isArrayTy() == true);
        llvm::Value* alloca = Builder->CreateAlloca(declType, nullptr, name);
        assert(alloca->getType()->isPointerTy() == true);

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
    llvm::Function* TheFunction = llvm::Function::Create(
        llvm::FunctionType::get(
            retType, 
            paramTypes, 
            false
        ), 
        llvm::Function::ExternalLinkage,
        func->getIdent()->getName(), 
        TheModule.get()
    );
    
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
            llvm::GlobalValue::ExternalLinkage,
            nullptr,
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
    bin->getRight()->visit(this);
    llvm::Value* retVal;
    llvm::Value* L = bin->getLeft()->getLLVMValue();
    llvm::Value* R = bin->getRight()->getLLVMValue();
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
    ASTVisitorBase::visitBoolExprNode(boolExpr);
}

void
IRGen::visitCallExprNode (CallExprNode* call) {
    for (auto i: call->getArguments())
        i->visit(this);

    llvm::Function* F = TheModule->getFunction(call->getIdent()->getName());
    std::vector<llvm::Value*> args;
    for (auto i: call->getArguments()){
        llvm::Value* val = i->getExpr()->getLLVMValue();

        if(val->getType()->isArrayTy()){
            llvm::Type* elementType = val->getType()->getArrayElementType();
            
            val = Builder->CreateGEP(
                elementType, 
                val, 
                std::vector<Value*>{
                    // represent base address of array
                    llvm::ConstantInt::get(elementType, 0),
                    // represent index of element
                    llvm::ConstantInt::get(elementType, 0)
                }
            );
        }
        args.push_back(val);
    }
    
    Builder->CreateCall(F, args, "");
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
        
        // if(val->getType()->isArrayTy()){
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
            ref->setLLVMValue(Builder->CreateLoad(type, val, ""));
        // }
        // Array Pointer
        // else{
        //     std::cout << "Load1";
        //     llvm::Value* load = Builder->CreateLoad(type, val, "");
        //     PrimitiveTypeNode* node = new PrimitiveTypeNode(venvEntry.getType()->getTypeEnum());
        //     type = convertType(node);
        //     val = Builder->CreateGEP(
        //         type, 
        //         load, 
        //         std::vector<Value*>{ref->getIndex()->getLLVMValue()}
        //     );
        //     std::cout << "Load2";
        //     ref->setLLVMValue(Builder->CreateLoad(type, val, ""));
        // }
        // // Pointer Access
        // if (dynamic_cast<ArrayTypeNode*>(venvEntry.getType())->getSize() == 0) {
        //     // Pointer Value
        //     llvm::Value* load = Builder->CreateLoad(type, val, "");
            
        //     std::vector<Value*> indices{index};
        //     val = Builder->CreateGEP(convertType(venvEntry.getType())->getArrayElementType(), load, indices);
        // }
        // // Array Access
        // else{
        //     std::vector<Value*> indices{
        //         // represent base address of array
        //         llvm::ConstantInt::get(index->getType(), 0),
        //         // represent index of element
        //         index
        //     };
            
        //     val = Builder->CreateGEP(convertType(venvEntry.getType()), val, indices);
        // }
        
    }
    else{
        // Array Pointer
        if(venvEntry.getType()->isArray()){
            std::cout << "ArrayPointer" << std::endl;

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
            ref->setLLVMValue(val);
        }
        // Normal Scalar
        else
            ref->setLLVMValue(Builder->CreateLoad(type, val, ""));
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
    
    ASTVisitorBase::visitProgramNode(prg);

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

    llvm::Function::Create(
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
}

void 
IRGen::visitStmtNode(StmtNode* stmt) {
    ASTVisitorBase::visitStmtNode(stmt);
}

void 
IRGen::visitAssignStmtNode(AssignStmtNode* assign) {
    assign->getTarget()->visit(this);
    assign->getValue()->visit(this);
    ASTVisitorBase::visitAssignStmtNode(assign);
}

void 
IRGen::visitExprStmtNode(ExprStmtNode* expr) {
    expr->getExpr()->visit(this);
    ASTVisitorBase::visitExprStmtNode(expr);
}

void 
IRGen::visitIfStmtNode(IfStmtNode* ifStmt) {
    ifStmt->getCondition()->visit(this);
    ifStmt->getThen()->visit(this);
    if (ifStmt->getHasElse())
        ifStmt->getElse()->visit(this);
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
    whileStmt->getCondition()->visit(this);
    whileStmt->getBody()->visit(this);
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
