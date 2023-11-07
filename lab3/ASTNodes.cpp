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
    this->type = Void;
}

PrimitiveTypeNode::PrimitiveTypeNode(TypeEnum type_) : TypeNode(){
    this->type = type_;
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
    this->type = new PrimitiveTypeNode();
    this->size = 0;
}

ArrayTypeNode::ArrayTypeNode(PrimitiveTypeNode* type_) : TypeNode(){
    this->type = type_;
    this->size = 0;
}

ArrayTypeNode::ArrayTypeNode(PrimitiveTypeNode* type_, int size_) : TypeNode(){
    this->type = type_;
    this->size = size_;
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

ParameterNode::ParameterNode(){
    this->type = new TypeNode();
    this->name = new IdentifierNode();
}

ParameterNode::ParameterNode(TypeNode *type_, IdentifierNode *name_){
    this->type = type_;
    this->name = name_;
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
ExprNode::ExprNode(){
    this.type = new PrimitiveTypeNode();
}

void 
ExprNode::setType(PrimitiveTypeNode* type_){
    // if(type!=nullptr) delete type;
    this.type = type_;
}
void 
ExprNode::setTypeInt(){
    assert(type!=nullptr);
    this.type->setType(Int);
}

void 
ExprNode::setTypeBool(){
    assert(type!=nullptr);
    this.type->setType(Bool);
}

void 
ExprNode::setTypeVoid(){
    assert(type!=nullptr);
    this.type->setType(Void);
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

/**********************************************************************************/
/* The Binary Expression Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Boolean Expression Class                                                   */
/**********************************************************************************/


// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Integer Expression Class                                                   */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Constant Class                                                             */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Boolean Constant Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Integer Constant Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class


/**********************************************************************************/
/* The Function Argument Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Call Expression Class                                                      */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Reference Expression Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class


/**********************************************************************************/
/* The Declaration Class                                                          */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Scalar Declaration Class                                                   */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
    
/**********************************************************************************/
/* The Array Declaration Class                                                    */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Stmt Class                                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Scope Class                                                                */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Function Declaration Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Expression Statement Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Assignment Statement Class                                                 */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The If Statement Class                                                         */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The While Statement Class                                                      */
/**********************************************************************************/

// ECE467 STUDENT: implement the class

/**********************************************************************************/
/* The Return Statement Class                                                     */
/**********************************************************************************/

// ECE467 STUDENT: implement the class
