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
    if (child != nullptr) child->setParent(this);
}

void
ASTNode::setParent (ASTNode *p) { parent = p; }

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

void
ASTNode::visit(ASTVisitorBase* visitor) { }

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
ProgramNode::getVarTable () {
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

/**********************************************************************************/
/* The TypeNode Class                                                             */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

bool
TypeNode::isArray(){
    return false;
}

/**********************************************************************************/
/* The PrimitiveTypeNode Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

PrimitiveTypeNode::PrimitiveTypeNode() : TypeNode(){
    type = Void;
}

PrimitiveTypeNode::PrimitiveTypeNode(TypeEnum type_) : TypeNode(){
    type = type_;
}

void
PrimitiveTypeNode::setType(enum TypeEnum type_){
    type = type_;
}

TypeEnum
PrimitiveTypeNode::getTypeEnum() const {
    return type;
}

bool
PrimitiveTypeNode::operator== (const PrimitiveTypeNode& t) const {
    return type == t.type;
}

bool
PrimitiveTypeNode::operator!= (const PrimitiveTypeNode& t) const {
    return type != t.type;
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
    size = 0;
}

ArrayTypeNode::ArrayTypeNode(PrimitiveTypeNode* type_) : TypeNode(){
    type = type_;
    size = 0;
}

ArrayTypeNode::ArrayTypeNode(PrimitiveTypeNode* type_, int size_) : TypeNode(){
    type = type_;
    size = size_;
}

void
ArrayTypeNode::setType(enum TypeEnum type_){
    type->setType(type_);
}

TypeEnum
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
ArrayTypeNode::operator== (const ArrayTypeNode& t) const {
    if(type->getTypeEnum() == t.type->getTypeEnum() && size == t.size) 
        return true;
    return false;
}

bool
ArrayTypeNode::operator!= (const ArrayTypeNode& t) const {
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
    type = new TypeNode();
    name = new IdentifierNode();
}

ParameterNode::ParameterNode(TypeNode *type_, IdentifierNode *name_): ASTNode(){
    type = type_;
    name = name_;
}

void
ParameterNode::setType(TypeNode *type_){
    // if(type != nullptr) delete type;
    type = type_;
}

TypeNode*& 
ParameterNode::getType(){
    assert(type!=nullptr);
    return type;
}

void 
ParameterNode::setIdent(IdentifierNode *&name_){
    // if(name != nullptr) delete name;
    name = name_;
}

IdentifierNode*& ParameterNode::getIdent(){
    assert(name!=nullptr);
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
}

void 
ExprNode::setType(PrimitiveTypeNode* type_){
    // if(type!=nullptr) delete type;
    type = type_;
}
void 
ExprNode::setTypeInt(){
    assert(type!=nullptr);
    type->setType(Int);
}

void 
ExprNode::setTypeBool(){
    assert(type!=nullptr);
    type->setType(Bool);
}

void 
ExprNode::setTypeVoid(){
    assert(type!=nullptr);
    type->setType(Void);
}

PrimitiveTypeNode* 
ExprNode::getType(){
    assert(type!=nullptr);
    return type;
}
/**********************************************************************************/
/* The Unary Expression Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

UnaryExprNode::UnaryExprNode() : ExprNode(){
    operand = new ExprNode();
    opcode = Unset;
}

UnaryExprNode::UnaryExprNode(ExprNode *expr) : ExprNode(){
    operand = expr;
    opcode = Unset;
}

UnaryExprNode::UnaryExprNode(ExprNode *expr, Opcode code) : ExprNode(){
    operand = expr;
    opcode = code;
}

ExprNode* 
UnaryExprNode::getOperand(){
    assert(operand!=nullptr);
    return operand;
}

void 
UnaryExprNode::setOperand(ExprNode *operand_){
    operand = operand_;
}

Opcode 
UnaryExprNode::getOpcode(){
    return opcode;
}

void 
UnaryExprNode::setOpcode(Opcode code){
    opcode = code;
}

void 
UnaryExprNode::setOpcode(std::string code){
    switch (code) {
        case "+":
            opcode = Addition;
            break;
        case "-":
            opcode = Subtraction;
            break;
        case "*":
            opcode = Multiplication;
            break;
        case "/":
            opcode = Division;
            break;
        case "!":
            opcode = Not;
            break;
        case "-":
            opcode = Minus;
            break;
        case "&&":
            opcode = And;
            break;
        case "||":opcode = code;
            opcode = NotEqual;
            break;
        case "<":
            opcode = LessThan;
            break;
        case "<=":
            opcode = LessorEqual;
            break;
        case ">":
            opcode = Greater;
            break;
        case ">=":
            opcode = GreaterorEqual;
            break;
        default:
            opcode = Unset;
            break;
    }
}

void 
UnaryExprNode::visit(ASTVisitorBase* visitor){
    visitor->visitUnaryExprNode(this);
}

/**********************************************************************************/
/* The Binary Expression Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
BinaryExprNode::BinaryExprNode(){
    left = new ExprNode();
    right = new ExprNode();
    opcode = Unset;
}

BinaryExprNode::BinaryExprNode(ExprNode *l, ExprNode *r){
    left = l;
    right = r;
    opcode = Unset;
}

BinaryExprNode::BinaryExprNode(ExprNode *l, ExprNode *r, Opcode code){
    left = l;
    right = r;
    opcode = code;
}

ExprNode* 
BinaryExprNode::getLeft(){
    assert(left != nullptr);
    return left;
}

void 
BinaryExprNode::setLeft(ExprNode *l){
    left = l;
}

ExprNode* 
BinaryExprNode::getRight(){
    assert(right != nullptr);
    return right;
}

void 
BinaryExprNode::setRight(ExprNode* r){
    right = r;
}

Opcode 
BinaryExprNode::getOpcode(){
    return opcode;
}

void 
BinaryExprNode::setOpcode(Opcode code){
    opcode = code;
}

void 
BinaryExprNode::setOpcode(std::string code){
    switch (code) {
        case "+":
            opcode = Addition;
            break;
        case "-":
            opcode = Subtraction;
            break;
        case "*":
            opcode = Multiplication;
            break;
        case "/":
            opcode = Division;
            break;
        case "!":
            opcode = Not;
            break;
        case "-":
            opcode = Minus;
            break;
        case "&&":
            opcode = And;
            break;
        case "||":opcode = code;
            opcode = NotEqual;
            break;
        case "<":
            opcode = LessThan;
            break;
        case "<=":
            opcode = LessorEqual;
            break;
        case ">":
            opcode = Greater;
            break;
        case ">=":
            opcode = GreaterorEqual;
            break;
        default:
            opcode = Unset;
            break;
    }
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
    value = new ExprNode();
}
BoolExprNode::BoolExprNode(ExprNode *val) : ExprNode(){
    value = val;
}
ExprNode* 
BoolExprNode::getValue(){
    return value;
}
void 
BoolExprNode::setValue(ExprNode *val){
    value = val;
}
Opcode 
BoolExprNode::getOpcode(){
    assert(false);
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
    value = new ExprNode();
}

IntExprNode::IntExprNode(ExprNode *val) : ExprNode(){
    value = val;
}

ExprNode* 
IntExprNode::getValue(){
    return value;
}

void 
IntExprNode::setValue(ExprNode *val){
    value = val;
}

Opcode 
IntExprNode::getOpcode(){
    assert(false);
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
    val = 0;
}

void 
ConstantExprNode::setSource(const std::string &source_){
    source = source_;
}

int 
ConstantExprNode::getVal(){
    return val;
}

/**********************************************************************************/
/* The Boolean Constant Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

BoolConstantNode::BoolConstantNode(const std::string &source) : ConstantExprNode(source){}
void 
BoolConstantNode::visit(ASTVisitorBase* visitor){
    visitor->visitBoolConstantNode(this);
}

/**********************************************************************************/
/* The Integer Constant Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
IntConstantNode::IntConstantNode(const std::string &source) : ConstantExprNode(source){}
void 
IntConstantNode::visit(ASTVisitorBase* visitor){
    visitor->visitIntConstantNode(this);
}

/**********************************************************************************/
/* The Function Argument Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ArgumentNode::ArgumentNode() : ASTNode(){
    this->expr = new ExprNode();
}

ArgumentNode::ArgumentNode(ExprNode *expr_) : ASTNode(){
    expr = expr_;
}

ExprNode* 
ArgumentNode::getExpr(){
    return expr;
}

void 
ArgumentNode::setExpr(ExprNode *expr_){
    expr = expr_;
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
    name = new IdentifierNode();
}

CallExprNode::CallExprNode(IdentifierNode *callee) : ExprNode(){
    name = callee;
}

CallExprNode::CallExprNode(IdentifierNode *callee, std::vector<ArgumentNode*> arglist) : ExprNode(){
    name = callee;
    args = arglist;
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
    args.push_back(arg);
}

void 
CallExprNode::setArguments(std::vector<ArgumentNode *> args_){
    args = args_;
}

void 
CallExprNode::setIdent(IdentifierNode *callee){
    name = callee;
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
    name = new IdentifierNode();
    index = IntExprNode();
}

ReferenceExprNode::ReferenceExprNode(IdentifierNode *name_) : ExprNode(){
    name = name_;
    index = IntExprNode();
}

ReferenceExprNode::ReferenceExprNode(IdentifierNode *name_, IntExprNode *index_) : ExprNode(){
    name = name_;
    index = index_;
}

IdentifierNode* 
ReferenceExprNode::getIdent(){
    return name;
}

void 
ReferenceExprNode::setIdent(IdentifierNode *name_){
    name = name_;
}

void 
ReferenceExprNode::setIndex(IntExprNode *index_){
    index = index_;
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
    type = new TypeNode();
    name = new IdentifierNode();
}

DeclNode::DeclNode(TypeNode* type_, IdentifierNode* name_) : ASTNode(){
    type = type_;
    name = name_;
}

void 
DeclNode::setName(IdentifierNode* name_){
    name = name_;
}

void 
DeclNode::setType(TypeNode* type_){
    type = type_;
}

IdentifierNode* 
DeclNode::getIdent(){
    return name;
}

bool isGlobal(){
    return true;
}

/**********************************************************************************/
/* The Scalar Declaration Class                                                   */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
ScalarDeclNode::ScalarDeclNode() : DeclNode(){ }
ScalarDeclNode::ScalarDeclNode(PrimitiveTypeNode*& type_, IdentifierNode*& name_) : DeclNode(type_, name_){ }

PrimitiveTypeNode* 
ScalarDeclNode::getType(){
    return static_cast<PrimitiveTypeNode*>(type);
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
ArrayDeclNode::ArrayDeclNode(PrimitiveTypeNode*& type_, IdentifierNode*& name_) : DeclNode(type_, name_){ }

PrimitiveTypeNode* 
ArrayDeclNode::getType(){
    return static_cast<ArrayTypeNode*>(type);
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
    decls.push_back(decl);
}
std::vector<DeclNode*> 
ScopeNode::getDeclarations(){
    return decls;
}
SymTable<VariableEntry>* 
ScopeNode::getVarTable(){
    return env;
}
bool 
ScopeNode::hasVarTable(){
    return false;
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
    body = new ScopeNode();
}

void 
FunctionDeclNode::setProto(bool val){
    isProto = val;
}

void 
FunctionDeclNode::setBody(ScopeNode* val){
    body = val;
}

void 
FunctionDeclNode::setRetType(PrimitiveTypeNode* type_){
    type = type_;
}

void 
FunctionDeclNode::setParameter(std::vector<ParameterNode* > parameters){
    params = parameters;
}

void 
FunctionDeclNode::addParameter(ParameterNode* param){
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
    return static_cast<PrimitiveTypeNode* >(type);
}

std::vector<ParameterNode*> 
FunctionDeclNode::getParams(){
    return params;
}

unsigned int 
FunctionDeclNode::getNumParameters(){
    return params.size();
}

PrimitiveTypeNode *
FunctionDeclNode::getType(){
    return static_cast<PrimitiveTypeNode* >(type);
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
    expr = new ExprNode();
}

ExprStmtNode::ExprStmtNode(ExprNode* exp) : StmtNode(){
    expr = exp;
}

void 
ExprStmtNode::setExpr(ExprNode* expr_){
    expr = expr_;
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
    target = new ReferenceExprNode();
    val = new ExprNode();
}

AssignStmtNode::AssignStmtNode(ReferenceExprNode* target_, ExprNode* val_): StmtNode{
    target = target_;
    val = val_;
}

ReferenceExprNode *
AssignStmtNode::getTarget(){
    return target;
}

void 
AssignStmtNode::setTarget(ReferenceExprNode* name){
    target = name;
}

ExprNode* 
AssignStmtNode::getValue(){
    return val;
}

void 
AssignStmtNode::setValue(ExprNode* value){
    val = value;
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
    condition = new ExprNode();
    Then = new StmtNode();
    Else = new StmtNode();
    hasElse = true;
}

IfStmtNode::IfStmtNode(ExprNode* cond, StmtNode* then_) : StmtNode(){
    condition = cond;
    Then = then_;
    hasElse = false;
}

IfStmtNode::IfStmtNode(ExprNode* cond, StmtNode* then_, StmtNode* else_) : StmtNode(){
    condition = cond;
    Then = then_;
    Else = else_;
    hasElse = true;
}

ExprNode* 
IfStmtNode::getCondition(){
    return cond;
}

void 
IfStmtNode::setCondition(ExprNode* condition_){
    cond =  condition_;
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
}

StmtNode *
IfStmtNode::getElse(){
    return Else;
}

void 
IfStmtNode::setElse(StmtNode* else_){
    Else = else_;
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
    condition = new ExprNode();
    body = new StmtNode();
}

WhileStmtNode::WhileStmtNode(ExprNode* cond, StmtNode* body_) : StmtNode(){
    condition = cond;
    body = body_;
}

ExprNode* 
WhileStmtNode::getCondition(){
    return condition;
}

void 
WhileStmtNode::setCondition(ExprNode* cond){
    condition = cond;
}

StmtNode* 
WhileStmtNode::getBody(){
    return body;
}

void 
WhileStmtNode::setBody(StmtNode* body_){
    body = body_;
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
}

ExprNode* 
ReturnStmtNode::getReturn(){
    return ret;
}

void 
ReturnStmtNode::setReturn(ExprNode* value){
    ret = value;
}

bool 
ReturnStmtNode::returnVoid(){
    return (ret == nullptr);
}

void 
ReturnStmtNode::visit(ASTVisitorBase* visitor) override{
    visitor->visitReturnStmtNode(this);
}
