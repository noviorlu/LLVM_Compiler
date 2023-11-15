//
//  ASTNodes.cpp
//  ECE467 Lab 3
//
//  Created by Tarek Abdelrahman on 2023-09-13.
//  Based on code written by Ao (Dino) Li for ECE467.
//  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
//
//  Permission is hereby granted to use this code in ECE467 at
//  the University of Toronto. It is prohibited to distribute
//  this code, either publicly or to third parties.

#include "ASTNodes.h"

#include <iostream>
#include <cassert>
#include <cstdlib>

using namespace smallc;

/**********************************************************************************/
/* The ASTNode Class                                                              */
/**********************************************************************************/
ASTNode::ASTNode () {
    parent = nullptr;
    location.first = 0;
    location.second = 0;
    root = nullptr;
}

ASTNode::~ASTNode () {
    cout << "DESTRUCTOR INVOKED\n";
    for (size_t i = 0; i < children.size(); i++)
        delete children[i];
}

ASTNode*
ASTNode::getParent () { return parent;}

ASTNode*
ASTNode::getChild (unsigned int i) { return children[i]; }

unsigned int
ASTNode::getNumChildren () { return (unsigned int) children.size(); }

unsigned int
ASTNode::getLine () { return location.first; }

unsigned int
ASTNode::getCol () { return location.second;}

std::pair<unsigned int, unsigned int>
ASTNode::getLocation () { return location; }

ProgramNode*
ASTNode::getRoot () { return root; }

// Mutators
void
ASTNode::addChild (ASTNode* child) {
    children.push_back(child);
    child->setParent(this);
}

void
ASTNode::setParent (ASTNode *p) { assert(parent == nullptr); parent = p; }

void
ASTNode::setRoot (ProgramNode *r) { root = r; }

void
ASTNode::setLine (unsigned int line) { location.first = line; }

void
ASTNode::setColumn (unsigned int column) { location.second = column; }

void
ASTNode::setLocation (unsigned int line, unsigned int column) {
    location.first = line;
    location.second = column;
}

void
ASTNode::setLocation (std::pair<unsigned int, unsigned int> loc) { location = loc; }

bool
ASTNode::hasVarTable () {
    return false;
}

FunctionDeclNode*
ASTNode::getFunction () {
    ASTNode* now = this;
    while (now) {
        if(typeid(*now) == typeid(FunctionDeclNode)) {
            return (FunctionDeclNode*)now;
        }
        now = now->getParent();
    }
    return nullptr;
}

SymTable<VariableEntry>* 
ASTNode::getVarTable(int layer){
    return ASTNode::getParent()->getVarTable(layer);
}

SymTable<FunctionEntry>* 
ASTNode::getFuncTable(){
    return ASTNode::getParent()->getFuncTable();
}
/**********************************************************************************/
/* The ProgramNode Class                                                          */
/**********************************************************************************/
ProgramNode::ProgramNode () : ASTNode(), iolib(false) {
    this->fenv = new SymTable<FunctionEntry>();
    this->venv = new SymTable<VariableEntry>();
}

void
ProgramNode::setIo (bool flag) {
    iolib = flag;
}

bool
ProgramNode::useIo () {
    return iolib;
}


SymTable<FunctionEntry>*
ProgramNode::getFuncTable () {
    return fenv;
}

SymTable<VariableEntry>*
ProgramNode::getVarTable (int layer) {
    if(layer != 0) return nullptr;
    return venv;
}

bool
ProgramNode::hasVarTable () {
    return true;
}

void
ProgramNode::visit (ASTVisitorBase* visitor) {
    visitor->visitProgramNode(this);
}

void 
ProgramNode::addDeclaration(DeclNode *decl){
    ASTNode::addChild(decl);
}

/**********************************************************************************/
/* The TypeNode Class                                                             */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
void 
TypeNode::setType(TypeEnum){}

TypeNode::TypeEnum 
TypeNode::getTypeEnum() const{return TypeNode::TypeEnum::Void; }

bool
TypeNode::isArray(){
    return false;
}

/**********************************************************************************/
/* The PrimitiveTypeNode Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

PrimitiveTypeNode::PrimitiveTypeNode() : TypeNode(){
    type = TypeNode::TypeEnum::Void;
}

PrimitiveTypeNode::PrimitiveTypeNode(TypeEnum type_) : TypeNode(){
    type = type_;
}

void
PrimitiveTypeNode::setType(enum TypeEnum type_){
    type = type_;
}

TypeNode::TypeEnum
PrimitiveTypeNode::getTypeEnum() const {
    return type;
}

bool
PrimitiveTypeNode::operator == (const PrimitiveTypeNode& t) {
    return (type == t.type);
}

bool
PrimitiveTypeNode::operator != (const PrimitiveTypeNode& t) {
    return (type != t.type);
}

void
PrimitiveTypeNode::visit (ASTVisitorBase* visitor) {
    visitor->visitPrimitiveTypeNode(this);
}

/**********************************************************************************/
/* The ArrayTypeNode Class                                                        */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

ArrayTypeNode::ArrayTypeNode() : TypeNode(){
    type = new PrimitiveTypeNode();
    type->setParent(this);
    size = 0;
}

ArrayTypeNode::ArrayTypeNode(PrimitiveTypeNode* type_) : TypeNode(){
    type = type_;
    type->setParent(this);
    size = 0;
}

ArrayTypeNode::ArrayTypeNode(PrimitiveTypeNode* type_, int size_) : TypeNode(){
    type = type_;
    type->setParent(this);
    size = size_;
}

void
ArrayTypeNode::setType(enum TypeEnum type_){
    type->setType(type_);
    type->setParent(this);
}

TypeNode::TypeEnum 
ArrayTypeNode::getTypeEnum() const {
    return type->getTypeEnum();
}

void
ArrayTypeNode::setSize(int size_){
    size = size_;
}

int
ArrayTypeNode::getSize(){
    return size;
}

bool
ArrayTypeNode::operator == (const ArrayTypeNode& t) {
    if(type->getTypeEnum() == t.type->getTypeEnum() && size == t.size) 
        return true;
    return false;
}

bool
ArrayTypeNode::operator != (const ArrayTypeNode& t) {
    if(type->getTypeEnum() == t.type->getTypeEnum() && size == t.size) 
        return false;
    return true;
}

bool
ArrayTypeNode::isArray(){
    return true;
}

void
ArrayTypeNode::visit (ASTVisitorBase* visitor) {
    visitor->visitArrayTypeNode(this);
}

/**********************************************************************************/
/* The IdentifierNode Class                                                       */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

IdentifierNode::IdentifierNode() : ASTNode(){
    name = "";
}

IdentifierNode::IdentifierNode(const std::string &text) : ASTNode(){
    name = text;
}

const std::string&
IdentifierNode::getName(){
    return name;
}

void
IdentifierNode::visit (ASTVisitorBase* visitor) {
    visitor->visitIdentifierNode(this);
}

/**********************************************************************************/
/* The ParameterNode Class                                                        */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

ParameterNode::ParameterNode() : ASTNode(){
    type = nullptr;
    name = nullptr;
}

ParameterNode::ParameterNode(TypeNode *type_, IdentifierNode *name_): ASTNode(){
    type = type_;
    type->setParent(this);
    name = name_;
    name->setParent(this);
}

void
ParameterNode::setType(TypeNode *type_){
    assert(type == nullptr);
    type = type_;
    type->setParent(this);
}

TypeNode*& 
ParameterNode::getType(){
    return type;
}

void 
ParameterNode::setIdent(IdentifierNode *&name_){
    assert(name == nullptr);
    name = name_;
    name->setParent(this);
}

IdentifierNode*& ParameterNode::getIdent(){
    return name;
}

void 
ParameterNode::visit(ASTVisitorBase* visitor){
    visitor->visitParameterNode(this);
}

/**********************************************************************************/
/* The Expression Class                                                           */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ExprNode::ExprNode() : ASTNode(){
    type = new PrimitiveTypeNode();
    type->setParent(this);
}

void 
ExprNode::setType(PrimitiveTypeNode* type_){
    if(type != nullptr) delete type;
    type = type_;
    type->setParent(this);
}
void 
ExprNode::setTypeInt(){
    assert(type!=nullptr);
    type->setType(TypeNode::TypeEnum::Int);
}

void 
ExprNode::setTypeBool(){
    assert(type!=nullptr);
    type->setType(TypeNode::TypeEnum::Bool);
}

void 
ExprNode::setTypeVoid(){
    assert(type!=nullptr);
    type->setType(TypeNode::TypeEnum::Void);
}

PrimitiveTypeNode* 
ExprNode::getType(){
    return type;
}
/**********************************************************************************/
/* The Unary Expression Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

UnaryExprNode::UnaryExprNode() : ExprNode(){
    operand = nullptr;
    opcode = Unset;
}

UnaryExprNode::UnaryExprNode(ExprNode *expr) : ExprNode(){
    operand = expr;
    operand->setParent(this);
    opcode = Unset;
    ExprNode::setType(expr->getType());
}

UnaryExprNode::UnaryExprNode(ExprNode *expr, Opcode code) : ExprNode(){
    operand = expr;
    operand->setParent(this);
    opcode = code;
    ExprNode::setType(expr->getType());
}

ExprNode* 
UnaryExprNode::getOperand(){
    return operand;
}

void 
UnaryExprNode::setOperand(ExprNode *operand_){
    if(operand != nullptr) delete operand;
    operand = operand_;
    operand->setParent(this);
}

ExprNode::Opcode 
UnaryExprNode::getOpcode(){
    return opcode;
}

void 
UnaryExprNode::setOpcode(Opcode code){
    opcode = code;
}

void 
UnaryExprNode::setOpcode(std::string code){
    if(code == "!") opcode = Not;
    else if(code == "-") opcode = Minus;
    else assert(false);
}

void 
UnaryExprNode::visit(ASTVisitorBase* visitor){
    visitor->visitUnaryExprNode(this);
}

/**********************************************************************************/
/* The Binary Expression Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
BinaryExprNode::BinaryExprNode() : ExprNode(){
    left = nullptr;
    right = nullptr;
    opcode = Unset;
}

BinaryExprNode::BinaryExprNode(ExprNode *l, ExprNode *r) : ExprNode(){
    left = l;
    left->setParent(this);
    right = r;
    right->setParent(this);
    opcode = Unset;
}

BinaryExprNode::BinaryExprNode(ExprNode *l, ExprNode *r, Opcode code){
    left = l;
    left->setParent(this);
    right = r;
    left->setParent(this);
    opcode = code;

    assert(opcode == ExprNode::Opcode::Unset);
    if(opcode <= ExprNode::Opcode::Division)
        ExprNode::setTypeInt();
    else if(opcode >= ExprNode::Opcode::And)
        ExprNode::setTypeBool();
}

ExprNode* 
BinaryExprNode::getLeft(){
    return left;
}

void
BinaryExprNode::setLeft(ExprNode *l){
    if(left != nullptr) delete left;
    left = l;
    left->setParent(this);
}

ExprNode* 
BinaryExprNode::getRight(){
    return right;
}

void 
BinaryExprNode::setRight(ExprNode* r){
    if(right != nullptr) delete right;
    right = r;
    right->setParent(this);
}

ExprNode::Opcode 
BinaryExprNode::getOpcode(){
    return opcode;
}

void 
BinaryExprNode::setOpcode(Opcode code){
    assert(opcode == ExprNode::Opcode::Unset);
    if(code <= ExprNode::Opcode::Division)
        ExprNode::setTypeInt();
    else if(code >= ExprNode::Opcode::And)
        ExprNode::setTypeBool();
    opcode = code;
}

void 
BinaryExprNode::setOpcode(std::string code){
    if(code == "+") opcode = Addition;
    else if(code == "-") opcode = Subtraction;
    else if(code == "*") opcode = Multiplication;
    else if(code == "/") opcode = Division;
    else if(code == "&&") opcode = And;
    else if(code == "||") opcode = Or;
    else if(code == "==") opcode = Equal;
    else if(code == "!=") opcode = NotEqual;
    else if(code == "<") opcode = LessThan;
    else if(code == "<=") opcode = LessorEqual;
    else if(code == ">") opcode = Greater;
    else if(code == ">=") opcode = GreaterorEqual;
    else assert(false);

    if(opcode <= Division)
        ExprNode::setTypeInt();
    else if(opcode >= And)
        ExprNode::setTypeBool();
}

void 
BinaryExprNode::visit(ASTVisitorBase* visitor){
    visitor->visitBinaryExprNode(this);
}

/**********************************************************************************/
/* The Boolean Expression Class                                                   */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

BoolExprNode::BoolExprNode() : ExprNode(){
    value = nullptr;
    ExprNode::setTypeBool();
}

BoolExprNode::BoolExprNode(ExprNode *val) : ExprNode(){
    value = val;
    value->setParent(this);
    ExprNode::setTypeBool();
}

ExprNode* 
BoolExprNode::getValue(){
    return value;
}

void 
BoolExprNode::setValue(ExprNode *val){
    if(value != nullptr) delete value;
    value = val;
    value->setParent(this);
}

ExprNode::Opcode 
BoolExprNode::getOpcode(){
    return Unset;
}

void 
BoolExprNode::visit(ASTVisitorBase* visitor){
    visitor->visitBoolExprNode(this);
}

/**********************************************************************************/
/* The Integer Expression Class                                                   */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

IntExprNode::IntExprNode() : ExprNode(){
    value = nullptr;
    ExprNode::setTypeInt();
}

IntExprNode::IntExprNode(ExprNode *val) : ExprNode(){
    value = val;
    value->setParent(this);
    ExprNode::setTypeInt();
}

ExprNode* 
IntExprNode::getValue(){
    return value;
}

void 
IntExprNode::setValue(ExprNode *val){
    if(value != nullptr) delete value;
    value = val;
    value->setParent(this);

}

ExprNode::Opcode 
IntExprNode::getOpcode(){
    return Unset;
}

void 
IntExprNode::visit(ASTVisitorBase* visitor){
    visitor->visitIntExprNode(this);
}

/**********************************************************************************/
/* The Constant Class                                                             */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

ConstantExprNode::ConstantExprNode(const std::string &source_) : ExprNode(){
    source = source_;
    ExprNode::setTypeBool();
    if(source == "true") val = 1;
    else if(source == "false") val = 0;
    else {
        val = std::atoi(source.c_str());
        ExprNode::setTypeInt();
    }
}

void 
ConstantExprNode::setSource(const std::string &source_){
    source = source_;
    ExprNode::setTypeBool();
    if(source == "true") val = 1;
    else if(source == "false") val = 0;
    else {
        val = std::atoi(source.c_str());
        ExprNode::setTypeInt();
    }
}

int 
ConstantExprNode::getVal(){
    return val;
}

/**********************************************************************************/
/* The Boolean Constant Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

BoolConstantNode::BoolConstantNode(const std::string &source) : ConstantExprNode(source){
    ExprNode::setTypeBool();
}
void 
BoolConstantNode::visit(ASTVisitorBase* visitor){
    visitor->visitBoolConstantNode(this);
}

/**********************************************************************************/
/* The Integer Constant Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
IntConstantNode::IntConstantNode(const std::string &source) : ConstantExprNode(source){
    ExprNode::setTypeInt();
}
void 
IntConstantNode::visit(ASTVisitorBase* visitor){
    visitor->visitIntConstantNode(this);
}

/**********************************************************************************/
/* The Function Argument Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ArgumentNode::ArgumentNode() : ASTNode(){
    expr = nullptr;
}

ArgumentNode::ArgumentNode(ExprNode *expr_) : ASTNode(){
    expr = expr_;
    expr->setParent(this);
}

ExprNode* 
ArgumentNode::getExpr(){
    return expr;
}

void 
ArgumentNode::setExpr(ExprNode *expr_){
    if(expr != nullptr) delete expr;
    expr = expr_;
    expr->setParent(this);
}

void 
ArgumentNode::visit(ASTVisitorBase* visitor){
    visitor->visitArgumentNode(this);
}

/**********************************************************************************/
/* The Call Expression Class                                                      */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

CallExprNode::CallExprNode() : ExprNode(){
    name = nullptr;
}

CallExprNode::CallExprNode(IdentifierNode *callee) : ExprNode(){
    name = callee;
    name->setParent(this);
}

CallExprNode::CallExprNode(IdentifierNode *callee, std::vector<ArgumentNode*> arglist) : ExprNode(){
    name = callee;
    name->setParent(this);
    args = arglist;
    for(ArgumentNode* arg : args)
        arg->setParent(this);
}

ArgumentNode *
CallExprNode::getArgument(unsigned int i){
    assert(i>=0 && i<args.size());
    return args[i];
}

std::vector<ArgumentNode *> 
CallExprNode::getArguments(){
    return args;
}

void 
CallExprNode::addArgument(ArgumentNode *arg){
    arg->setParent(this);
    args.push_back(arg);
}

void 
CallExprNode::setArguments(std::vector<ArgumentNode *> args_){
    args = args_;
    for(ArgumentNode* arg : args)
        arg->setParent(this);
}

void 
CallExprNode::setIdent(IdentifierNode *callee){
    if(name != nullptr) delete name;
    name = callee;
    name->setParent(this);
}

IdentifierNode *
CallExprNode::getIdent(){
    return name;
}

void 
CallExprNode::visit(ASTVisitorBase* visitor){
    visitor->visitCallExprNode(this);
}

/**********************************************************************************/
/* The Reference Expression Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ReferenceExprNode::ReferenceExprNode() : ExprNode(){
    name = nullptr;
    index = nullptr;
}

ReferenceExprNode::ReferenceExprNode(IdentifierNode *name_) : ExprNode(){
    name = name_;
    name->setParent(this);
    index = nullptr;
}

ReferenceExprNode::ReferenceExprNode(IdentifierNode *name_, IntExprNode *index_) : ExprNode(){
    name = name_;
    name->setParent(this);
    index = index_;
    index->setParent(this);
}

IdentifierNode* 
ReferenceExprNode::getIdent(){
    return name;
}

void 
ReferenceExprNode::setIdent(IdentifierNode *name_){
    if(name != nullptr) delete name;
    name = name_;
    name->setParent(this);
}

void 
ReferenceExprNode::setIndex(IntExprNode *index_){
    if(index != nullptr) delete index;
    index = index_;
    index->setParent(this);
}

IntExprNode* 
ReferenceExprNode::getIndex(){
    return index;
}

void 
ReferenceExprNode::visit(ASTVisitorBase* visitor){
    visitor->visitReferenceExprNode(this);
}

/**********************************************************************************/
/* The Declaration Class                                                          */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

DeclNode::DeclNode() : ASTNode(){
    type = nullptr;
    name = nullptr;
}

DeclNode::DeclNode(TypeNode* type_, IdentifierNode* name_) : ASTNode(){
    type = type_;
    type->setParent(this);
    name = name_;
    name->setParent(this);
}

void 
DeclNode::setName(IdentifierNode* name_){
    if(name != nullptr) delete name;
    name = name_;
    name->setParent(this);
}

void 
DeclNode::setType(TypeNode* type_){
    if(type != nullptr) delete type;
    type = type_;
    type->setParent(this);
}

IdentifierNode* 
DeclNode::getIdent(){
    return name;
}
TypeNode* 
DeclNode::getType(){
    return type;
}

bool 
DeclNode::isGlobal(){
    ASTNode* curr = this;
    assert(curr != nullptr);

    while(!curr->hasVarTable()){
        curr = curr->getParent();
        assert(curr != nullptr);
    }
    return (curr->getRoot() != nullptr);
}

/**********************************************************************************/
/* The Scalar Declaration Class                                                   */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ScalarDeclNode::ScalarDeclNode() : DeclNode(){ }
ScalarDeclNode::ScalarDeclNode(PrimitiveTypeNode*& type_, IdentifierNode*& name_) : DeclNode(type_, name_){ }

PrimitiveTypeNode* 
ScalarDeclNode::getType(){
    return static_cast<PrimitiveTypeNode*>(DeclNode::getType());
}

void 
ScalarDeclNode::visit(ASTVisitorBase* visitor){
    visitor->visitScalarDeclNode(this);
}

/**********************************************************************************/
/* The Array Declaration Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ArrayDeclNode::ArrayDeclNode() : DeclNode(){ }
ArrayDeclNode::ArrayDeclNode(ArrayTypeNode* type_, IdentifierNode* name_) : DeclNode(type_, name_){ }

ArrayTypeNode* 
ArrayDeclNode::getType(){
    return static_cast<ArrayTypeNode*>(DeclNode::getType());
}

void 
ArrayDeclNode::visit(ASTVisitorBase* visitor){
    visitor->visitArrayDeclNode(this);
}

/**********************************************************************************/
/* The Stmt Class                                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
StmtNode::StmtNode() : ASTNode(){}

/**********************************************************************************/
/* The Scope Class                                                                */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ScopeNode::ScopeNode() : StmtNode(){
    env = new SymTable<VariableEntry>();
}
void 
ScopeNode::addDeclaration(DeclNode *decl){
    decl->setParent(this);
    decls.push_back(decl);
}
std::vector<DeclNode*> 
ScopeNode::getDeclarations(){
    return decls;
}
SymTable<VariableEntry>* 
ScopeNode::getVarTable(int layer){
    if(layer != 0) return ASTNode::getParent()->getVarTable(--layer);
    return env;
}
bool 
ScopeNode::hasVarTable(){
    return true;
}
void 
ScopeNode::visit(ASTVisitorBase* visitor){
    visitor->visitScopeNode(this);
}

/**********************************************************************************/
/* The Function Declaration Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
FunctionDeclNode::FunctionDeclNode() : DeclNode(){
    isProto = false;
    body = nullptr;
}

void 
FunctionDeclNode::setProto(bool val){
    isProto = val;
}

void 
FunctionDeclNode::setBody(ScopeNode* val){
    body = val;
    body->setParent(this);
}

void 
FunctionDeclNode::setRetType(PrimitiveTypeNode* type_){
    DeclNode::setType(type_);
}

void 
FunctionDeclNode::setParameter(std::vector<ParameterNode* > parameters){
    params = parameters;
    for(ParameterNode* param : params)
        param->setParent(this);
}

void 
FunctionDeclNode::addParameter(ParameterNode* param){
    param->setParent(this);
    params.push_back(param);
}

bool 
FunctionDeclNode::getProto(){
    return isProto;
}

ScopeNode* 
FunctionDeclNode::getBody(){
    return body;
}

PrimitiveTypeNode* 
FunctionDeclNode::getRetType(){
    return static_cast<PrimitiveTypeNode* >(DeclNode::getType());
}

std::vector<ParameterNode*> 
FunctionDeclNode::getParams(){
    return params;
}

std::vector<TypeNode*> 
FunctionDeclNode::getParamTypes(){
    std::vector<TypeNode*> tmp;
    tmp.reserve(params.size());
    for(ParameterNode* param : params)
        tmp.push_back(param->getType());
    
    return tmp;
}


unsigned int 
FunctionDeclNode::getNumParameters(){
    return params.size();
}

PrimitiveTypeNode *
FunctionDeclNode::getType(){
    return static_cast<PrimitiveTypeNode* >(DeclNode::getType());
}

void 
FunctionDeclNode::visit(ASTVisitorBase* visitor){
    visitor->visitFunctionDeclNode(this);
}

/**********************************************************************************/
/* The Expression Statement Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ExprStmtNode::ExprStmtNode() : StmtNode(){
    expr = nullptr;
}

ExprStmtNode::ExprStmtNode(ExprNode* exp) : StmtNode(){
    expr = exp;
    expr->setParent(this);
}

void 
ExprStmtNode::setExpr(ExprNode* expr_){
    expr = expr_;
    expr->setParent(this);
}

ExprNode* 
ExprStmtNode::getExpr(){
    return expr;
}

void 
ExprStmtNode::visit(ASTVisitorBase* visitor){
    visitor->visitExprStmtNode(this);
}

/**********************************************************************************/
/* The Assignment Statement Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
AssignStmtNode::AssignStmtNode() : StmtNode(){
    target = nullptr;
    val = nullptr;
}

AssignStmtNode::AssignStmtNode(ReferenceExprNode* target_, ExprNode* val_): StmtNode(){
    target = target_;
    target->setParent(this);
    val = val_;
    val->setParent(this);
}

ReferenceExprNode *
AssignStmtNode::getTarget(){
    return target;
}

void 
AssignStmtNode::setTarget(ReferenceExprNode* name){
    target = name;
    target->setParent(this);
}

ExprNode* 
AssignStmtNode::getValue(){
    return val;
}

void 
AssignStmtNode::setValue(ExprNode* value){
    val = value;
    val->setParent(this);
}

void 
AssignStmtNode::visit(ASTVisitorBase* visitor){
    visitor->visitAssignStmtNode(this);
}

/**********************************************************************************/
/* The If Statement Class                                                         */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
IfStmtNode::IfStmtNode() : StmtNode(){
    condition = nullptr;
    hasElse = false;
    Then = nullptr;
    Else = nullptr;
}

IfStmtNode::IfStmtNode(ExprNode* cond, StmtNode* then_) : StmtNode(){
    condition = cond;
    condition->setParent(this);
    hasElse = false;
    Then = then_;
    Then->setParent(this);
    Else = nullptr;
}

IfStmtNode::IfStmtNode(ExprNode* cond, StmtNode* then_, StmtNode* else_) : StmtNode(){
    condition = cond;
    condition->setParent(this);
    hasElse = true;
    Then = then_;
    Then->setParent(this);
    Else = else_;
    Else->setParent(this);
}

ExprNode* 
IfStmtNode::getCondition(){
    return condition;
}

void 
IfStmtNode::setCondition(ExprNode* condition_){
    condition =  condition_;
    condition->setParent(this);
}

bool 
IfStmtNode::getHasElse(){
    return hasElse;
}

void 
IfStmtNode::setHasElse(bool hasElse_){
    hasElse = hasElse_;
}

StmtNode *
IfStmtNode::getThen(){
    return Then;
}

void 
IfStmtNode::setThen(StmtNode* then_){
    Then = then_;
    Then->setParent(this);
}

StmtNode *
IfStmtNode::getElse(){
    return Else;
}

void 
IfStmtNode::setElse(StmtNode* else_){
    Else = else_;
    Else->setParent(this);
}

void 
IfStmtNode::visit(ASTVisitorBase* visitor){
    visitor->visitIfStmtNode(this);
}


/**********************************************************************************/
/* The While Statement Class                                                      */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
WhileStmtNode::WhileStmtNode() : StmtNode(){
    condition = nullptr;
    body = nullptr;
}

WhileStmtNode::WhileStmtNode(ExprNode* cond, StmtNode* body_) : StmtNode(){
    condition = cond;
    condition->setParent(this);
    
    body = body_;
    body->setParent(this);
}

ExprNode* 
WhileStmtNode::getCondition(){
    return condition;
}

void 
WhileStmtNode::setCondition(ExprNode* cond){
    condition = cond;
    condition->setParent(this);
}

StmtNode* 
WhileStmtNode::getBody(){
    return body;
}

void 
WhileStmtNode::setBody(StmtNode* body_){
    body = body_;
    body->setParent(this);
}

void 
WhileStmtNode::visit(ASTVisitorBase* visitor){
    visitor->visitWhileStmtNode(this);
}


/**********************************************************************************/
/* The Return Statement Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ReturnStmtNode::ReturnStmtNode() : StmtNode(){
    ret = nullptr;
}

ReturnStmtNode::ReturnStmtNode(ExprNode* exp) : StmtNode(){
    ret = exp;
    ret->setParent(this);
}

ExprNode* 
ReturnStmtNode::getReturn(){
    return ret;
}

void 
ReturnStmtNode::setReturn(ExprNode* value){
    ret = value;
    ret->setParent(this);
}

bool 
ReturnStmtNode::returnVoid(){
    return (ret == nullptr);
}

void 
ReturnStmtNode::visit(ASTVisitorBase* visitor){
    visitor->visitReturnStmtNode(this);
}
