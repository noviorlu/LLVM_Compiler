//
//  SymTable.cpp
//  ECE467 Lab 3
//
//  Created by Tarek Abdelrahman on 2023-09-13.
//  Based on code written by Ao (Dino) Li for ECE467.
//  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
//
//  Permission is hereby granted to use this code in ECE467 at
//  the University of Toronto. It is prohibited to distribute
//  this code, either publicly or to third parties.

#include <map>
#include <string>
#include <cassert>

#include "ASTNodes.h"
#include "SymTable.h"

using namespace smallc;

namespace smallc {

/**********************************************************************************/
/* The VariableEntry Class                                                              */
/**********************************************************************************/

// ECE467 STUDENT: add your class implementation here
VariableEntry::VariableEntry(){
    isArray = false;
}

VariableEntry::VariableEntry(PrimitiveTypeNode* p){
    type = p;
    isArray = false;
}

VariableEntry::VariableEntry(ArrayTypeNode* arr){
    type = arr;
    isArray = true;
}

TypeNode* 
VariableEntry::getType(){
    return type;
}


/**********************************************************************************/
/* The FunctionEntry Class                                                              */
/**********************************************************************************/

// ECE467 STUDENT: add your class implementation here
FunctionEntry::FunctionEntry(){
    returnType = nullptr;
    proto = true;
}

FunctionEntry::FunctionEntry(PrimitiveTypeNode* retType, std::vector<TypeNode*> paraTypes, bool proto_){
    returnType = retType;
    parameterTypes = paraTypes;
    proto = proto_;
}

PrimitiveTypeNode* 
FunctionEntry::getReturnType(){
    assert(returnType != nullptr);
    return returnType;
}

std::vector<TypeNode*> 
FunctionEntry::getParameterTypes(){
    return parameterTypes;
}

bool
FunctionEntry::getProto(){
    return proto;
}
/**********************************************************************************/
/* The SymTable Class                                                              */
/**********************************************************************************/

// ECE467 STUDENT: add your class implementation here
template<class T>
bool 
SymTable<T>::contains(const std::string &name){
    return (table.find(name) != table.end());
}
    
template<class T> 
T 
SymTable<T>::get(const std::string &name){
    assert(SymTable::contains(name));
    return table[name];
}

template<class T> 
void 
SymTable<T>::insert(const std::string& name, T ent){
    assert(!SymTable::contains(name));
    table[name] = ent;
}

// Explicit template class instantiation
template class SymTable<FunctionEntry>;
template class SymTable<VariableEntry>;

} // namespace smallc

