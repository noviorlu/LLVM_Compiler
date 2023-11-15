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
    
    SymTable<VariableEntry>* venv = array->getVarTable(0);
    std::string name = array->getIdent()->getName();

    // [Semantic 0]: sameName in SymbolTable
    if(venv->contains(name)){
        SemanticAnalyzer::addError(
            SemaError(
                SemaError::ErrorEnum::IdentReDefined, 
                std::pair<unsigned int, unsigned int>(array->getLine(), array->getCol()), 
                name
            )
        );
    }else{
        // [Semantic 11]: ArraySize must be positive
        if(array->getType()->getSize() < 0){
            SemanticAnalyzer::addError(
                SemaError(
                    SemaError::ErrorEnum::InvalidArraySize, 
                    std::pair<unsigned int, unsigned int>(array->getLine(), array->getCol()), 
                    name
                )
            );
        }
        else venv->insert(name, VariableEntry(array->getType()));
    }
    
    ASTVisitorBase::visitArrayDeclNode(array);
}
void SemanticAnalyzer::visitFunctionDeclNode(FunctionDeclNode *func) {
    func->getRetType()->visit(this);
    func->getIdent()->visit(this);
    for (auto i: func->getParams())
        i->visit(this);
    if (func->getBody())
        func->getBody()->visit(this);

    SymTable<FunctionEntry>* fenv = func->getFuncTable();
    std::string name = func->getIdent()->getName();

    if(fenv->contains(name)){
        if(fenv->get(name).getProto()){
            if(func->getProto()) goto InconsistentDefError;

            FunctionEntry fe = fenv->get(name);
            
            if(*(fe.getReturnType())!=*(func->getRetType()))
                goto InconsistentDefError;
            
            std::vector<TypeNode*> fePT = fe.getParameterTypes();
            std::vector<TypeNode*> funcPT = func->getParamTypes();

            if(fePT.size() != funcPT.size())
                goto InconsistentDefError;

            for(int i = 0; i < fePT.size(); i++){
                if(fePT[i]->isArray() != funcPT[i]->isArray())
                    goto InconsistentDefError;
                
                if(fePT[i]->isArray()){
                    if(
                        *(static_cast<ArrayTypeNode*>(fePT[i])) != 
                        *(static_cast<ArrayTypeNode*>(funcPT[i]))
                    ) goto InconsistentDefError;
                }
                else{
                    if(
                        *(static_cast<PrimitiveTypeNode*>(fePT[i])) != 
                        *(static_cast<PrimitiveTypeNode*>(funcPT[i]))
                    ) goto InconsistentDefError;
                    
                }
            }
            
            goto End;
        }
        else { goto IdentReDefinedError;}
    }
    fenv->insert(
        name, 
        FunctionEntry(
            func->getRetType(),
            func->getParamTypes(),
            func->getProto()
        )
    );

End:
    ASTVisitorBase::visitFunctionDeclNode(func);
    return;

InconsistentDefError:
    SemanticAnalyzer::addError(
        SemaError(
            SemaError::ErrorEnum::InconsistentDef, 
            std::pair<unsigned int, unsigned int>(func->getLine(), func->getCol()), 
            name
        )
    );
    ASTVisitorBase::visitFunctionDeclNode(func);
    return;

IdentReDefinedError:
    SemanticAnalyzer::addError(
        SemaError(
            SemaError::ErrorEnum::IdentReDefined, 
            std::pair<unsigned int, unsigned int>(func->getLine(), func->getCol()), 
            name
        )
    );
    ASTVisitorBase::visitFunctionDeclNode(func);
    return;
}

void SemanticAnalyzer::visitScalarDeclNode(ScalarDeclNode *scalar) {
    scalar->getType()->visit(this);
    scalar->getIdent()->visit(this);
    
    SymTable<VariableEntry>* venv = scalar->getVarTable(0);
    std::string name = scalar->getIdent()->getName();
    
    // [Semantic 0]: sameName in SymbolTable
    if(venv->contains(name)){
        SemanticAnalyzer::addError(
            SemaError(
                SemaError::ErrorEnum::IdentReDefined, 
                std::pair<unsigned int, unsigned int>(scalar->getLine(), scalar->getCol()), 
                name
            )
        );
    }else{
        venv->insert(name, VariableEntry(scalar->getType()));
    }

    ASTVisitorBase::visitScalarDeclNode(scalar);
}
void SemanticAnalyzer::visitExprNode(ExprNode *exp) {
    ASTVisitorBase::visitExprNode(exp);
}
void SemanticAnalyzer::visitBinaryExprNode(BinaryExprNode *bin) {
    bin->getLeft()->visit(this);
    bin->getRight()->visit(this);

    // [Semantic 4]: arithmetic operators must be int
    ExprNode::Opcode op = bin->getOpcode();

    assert(op != ExprNode::Opcode::Unset);
    if(op <= ExprNode::Opcode::Division){
        if(
            bin->getLeft()->getType()->getTypeEnum() != TypeNode::TypeEnum::Int ||
            bin->getRight()->getType()->getTypeEnum() != TypeNode::TypeEnum::Int
        ){
            SemanticAnalyzer::addError(
                SemaError(
                    SemaError::ErrorEnum::TypeMisMatch, 
                    std::pair<unsigned int, unsigned int>(bin->getLine(), bin->getCol())
                )
            );
        }
    }
    else if(op == ExprNode::Opcode::And || op == ExprNode::Opcode::Or){
        if(
            bin->getLeft()->getType()->getTypeEnum() != TypeNode::TypeEnum::Bool || 
            bin->getRight()->getType()->getTypeEnum() != TypeNode::TypeEnum::Bool 
        ){
            SemanticAnalyzer::addError(
                SemaError(
                    SemaError::ErrorEnum::TypeMisMatch, 
                    std::pair<unsigned int, unsigned int>(bin->getLine(), bin->getCol())
                )
            );
            bin->setTypeVoid();
        }
    }
    // [Semantic 5]: logical operators must same type
    else if(op >= ExprNode::Opcode::Equal){
        if(
            *(bin->getLeft()->getType()) != 
            *(bin->getRight()->getType())
        ){
            SemanticAnalyzer::addError(
                SemaError(
                    SemaError::ErrorEnum::TypeMisMatch, 
                    std::pair<unsigned int, unsigned int>(bin->getLine(), bin->getCol())
                )
            );
        }
    }

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

    //[Semantic 10]: check Caller arg is same as declaration?
    std::vector<ArgumentNode*> arglist = call->getArguments();
    std::vector<TypeNode*> typelist;
    std::string name = call->getIdent()->getName();

    if(!call->getFuncTable()->contains(name)){
        goto Error;
    }
    typelist = call->getFuncTable()->get(name).getParameterTypes();
    
    if(arglist.size() != typelist.size()){
        goto Error;
    }
    
    for(int i = 0; i < arglist.size(); i++){
        //BIG PROBLEM HERE!!!!!!!!!!!
        PrimitiveTypeNode* cast = dynamic_cast<PrimitiveTypeNode*>(typelist[i]);
        if(cast == nullptr || *(arglist[i]->getExpr()->getType()) != *(cast)){
            goto Error;
        }
    }

    ASTVisitorBase::visitCallExprNode(call);
    return;

Error:
    SemanticAnalyzer::addError(
        SemaError(
            SemaError::ErrorEnum::IdentUnDefined, 
            std::pair<unsigned int, unsigned int>(call->getLine(), call->getCol()),
            name
        )
    );
    ASTVisitorBase::visitCallExprNode(call);
    return;
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

    SymTable<VariableEntry>* venv = ref->getVarTable(0);
    TypeNode::TypeEnum vartype = TypeNode::TypeEnum::Void;
    std::string name = ref->getIdent()->getName();
    ref->setTypeVoid();
    
    int i = 1;
    do{
        if(venv->contains(name)){
            vartype = venv->get(name).getType()->getTypeEnum();
            if(vartype == TypeNode::TypeEnum::Int)
                ref->setTypeInt();
            else if(vartype == TypeNode::TypeEnum::Bool)
                ref->setTypeBool();
            else assert(false);
            
            //[Semantic 12]: Array not use at Var, via
            if(
                (venv->get(name).getType()->isArray() && ref->getIndex() == nullptr) ||
                (!venv->get(name).getType()->isArray() && ref->getIndex() != nullptr)
            ){
                SemanticAnalyzer::addError(
                    SemaError(
                        SemaError::ErrorEnum::InvalidAccess, 
                        std::pair<unsigned int, unsigned int>(ref->getLine(), ref->getCol()), 
                        name
                    )
                );
                ref->setTypeVoid();
            }
            break;
        }
        venv = ref->getVarTable(i);
        i++;
    }while(venv != nullptr);
    
    //[Semantic 1]: reference not defined in scope
    if(venv == nullptr){

        SemanticAnalyzer::addError(
            SemaError(
                SemaError::ErrorEnum::IdentUnDefined, 
                std::pair<unsigned int, unsigned int>(ref->getLine(), ref->getCol()), 
                name
            )
        );
    }

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

    SymTable<VariableEntry>* venv = param->getVarTable(0);
    std::string name = param->getIdent()->getName();
    
    FunctionDeclNode* parent = dynamic_cast<FunctionDeclNode*>(param->getParent());
    if(parent->getProto()) goto End;

    // [Semantic 0]: sameName in SymbolTable
    if(venv->contains(name)){
        SemanticAnalyzer::addError(
            SemaError(
                SemaError::ErrorEnum::IdentReDefined, 
                std::pair<unsigned int, unsigned int>(param->getLine(), param->getCol()), 
                name
            )
        );
    }else{
        if(param->getType()->isArray())
            venv->insert(name, VariableEntry(static_cast<ArrayTypeNode*>(param->getType())));
        else
            venv->insert(name, VariableEntry(static_cast<PrimitiveTypeNode*>(param->getType())));
    }

End:
    ASTVisitorBase::visitParameterNode(param);
}
void SemanticAnalyzer::visitProgramNode(ProgramNode *prg) {
    SymTable<FunctionEntry>* fenv = prg->getFuncTable();
    if(prg->useIo()){
        fenv->insert(
            "readBool", 
            FunctionEntry(
                new PrimitiveTypeNode(TypeNode::TypeEnum::Bool),
                {},
                true
            )
        );
        fenv->insert(
            "readInt", 
            FunctionEntry(
                new PrimitiveTypeNode(TypeNode::TypeEnum::Int),
                {},
                true
            )
        );
        fenv->insert(
            "writeBool", 
            FunctionEntry(
                new PrimitiveTypeNode(TypeNode::TypeEnum::Void),
                {new PrimitiveTypeNode(TypeNode::TypeEnum::Bool)},
                true
            )
        );
        fenv->insert(
            "writeInt", 
            FunctionEntry(
                new PrimitiveTypeNode(TypeNode::TypeEnum::Void),
                {new PrimitiveTypeNode(TypeNode::TypeEnum::Int)},
                true
            )
        );
    }
    ASTVisitorBase::visitProgramNode(prg);
}
void SemanticAnalyzer::visitStmtNode(StmtNode *stmt) {
    ASTVisitorBase::visitStmtNode(stmt);
}
void SemanticAnalyzer::visitAssignStmtNode(AssignStmtNode *assign) {
    assign->getTarget()->visit(this);
    assign->getValue()->visit(this);

    
    // [Semantic 6]: same type on left and right
    ReferenceExprNode *target = assign->getTarget();
    ExprNode* val = assign->getValue();

    if(
        target->getType()->getTypeEnum() == TypeNode::TypeEnum::Void ||
        val->getType()->getTypeEnum() == TypeNode::TypeEnum::Void
    ){
        SemanticAnalyzer::addError(
            SemaError(
                SemaError::ErrorEnum::TypeMisMatch, 
                std::pair<unsigned int, unsigned int>(assign->getLine(), assign->getCol())
            )
        );
    }
    else {
        if(
            *(target->getType()) != *(val->getType())
        ){
            SemanticAnalyzer::addError(
                SemaError(
                    SemaError::ErrorEnum::TypeMisMatch, 
                    std::pair<unsigned int, unsigned int>(assign->getLine(), assign->getCol())
                )
            );
        }
    }
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

    // [Semantic 7]:ifStatemnt condition must be bool
    if(ifStmt->getCondition()->getType()->getTypeEnum() != TypeNode::TypeEnum::Bool){
        SemanticAnalyzer::addError(
            SemaError(
                SemaError::ErrorEnum::InvalidCond, 
                std::pair<unsigned int, unsigned int>(ifStmt->getLine(), ifStmt->getCol()),
                "if statement"
            )
        );
    }
    ASTVisitorBase::visitIfStmtNode(ifStmt);
}
void SemanticAnalyzer::visitReturnStmtNode(ReturnStmtNode *ret) {
    if (!ret->returnVoid())
        ret->getReturn()->visit(this);

    //[Semantic 9]: return type match funcDecl
    if(ret->getFunction()->getRetType()->getTypeEnum() == TypeNode::TypeEnum::Void){
        if(ret->getReturn() != nullptr){
            SemanticAnalyzer::addError(
                SemaError(
                    SemaError::ErrorEnum::MisMatchedReturn, 
                    std::pair<unsigned int, unsigned int>(ret->getLine(), ret->getCol())
                )
            );
        }
    }
    else{
        if(*(ret->getFunction()->getRetType()) != *(ret->getReturn()->getType())){
            SemanticAnalyzer::addError(
                SemaError(
                    SemaError::ErrorEnum::MisMatchedReturn, 
                    std::pair<unsigned int, unsigned int>(ret->getLine(), ret->getCol())
                )
            );
        }
    }
    
    ASTVisitorBase::visitReturnStmtNode(ret);
}
void SemanticAnalyzer::visitScopeNode(ScopeNode *scope) {
    for (auto i: scope->getDeclarations())
        i->visit(this);
    
    ASTVisitorBase::visitScopeNode(scope);
}
void SemanticAnalyzer::visitWhileStmtNode(WhileStmtNode *whileStmt) {
    whileStmt->getCondition()->visit(this);
    whileStmt->getBody()->visit(this);

    // [Semantic 7]:w hileStatemnt condition must be bool
    if(whileStmt->getCondition()->getType()->getTypeEnum() != TypeNode::TypeEnum::Bool){
        SemanticAnalyzer::addError(
            SemaError(
                SemaError::ErrorEnum::InvalidCond, 
                std::pair<unsigned int, unsigned int>(whileStmt->getLine(), whileStmt->getCol()),
                "while statement"
            )
        );
    }
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