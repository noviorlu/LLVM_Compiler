//
//  A5Dom.cpp
//  ECE467 Lab 5
//
//  Created by Tarek Abdelrahman on 2023-11-18.
//  Copyright © 2023 Tarek Abdelrahman. All rights reserved.
//
//  Permission is hereby granted to use this code in ECE467 at
//  the University of Toronto. It is prohibited to distribute
//  this code, either publicly or to third parties.
//

#include "llvm/IR/LegacyPassManager.h"
#include "llvm/Passes/PassBuilder.h"
#include "llvm/Passes/PassPlugin.h"
#include "llvm/Support/raw_ostream.h"

#include <string>
#include <map>
#include <vector>
#include <set>
#include <cassert>
#include <iostream>
#include <algorithm>
#include <iterator>

using namespace llvm;
using namespace std;

namespace {

void printVector(const std::vector<std::string>& vector){
  for (const auto& element : vector) {
    std::cout << element << " ";
  }
  std::cout << std::endl;
}

class CFGEntry{
public:
  std::set<CFGEntry*> predecessors;
  std::set<CFGEntry*> successors;
  
  BasicBlock* BB;
  std::string name;
  bool visited = false;

  std::vector<std::string> dominator;
  std::vector<std::string> dominated;
  std::vector<std::string> dirDominator;

  std::vector<std::string> postDominator;
  std::vector<std::string> postDominated;
  std::vector<std::string> postDirDominator;

  void Printer(){
    std::cout << name <<  ":" << std::endl;
    // std::cout << "\tDominator: ";
    // std::sort(dominator.begin(), dominator.end());
    // if(dominator.size() == 0) std::cout << "X" << std::endl;
    // else printVector(dominator);

    std::cout << "\t";
    std::sort(dominated.begin(), dominated.end());
    if(dominated.size() == 0) std::cout << "X" << std::endl;
    else printVector(dominated);

    std::cout << "\t";
    std::sort(dirDominator.begin(), dirDominator.end());
    if(dirDominator.size() == 0) std::cout << "X" << std::endl;
    else printVector(dirDominator);

    // std::cout << "\tPost Dominator: ";
    // std::sort(postDominator.begin(), postDominator.end());
    // if(postDominator.size() == 0) std::cout << "X" << std::endl;
    // else printVector(postDominator);

    std::cout << "\t";
    std::sort(postDominated.begin(), postDominated.end());
    if(postDominated.size() == 0) std::cout << "X" << std::endl;
    else printVector(postDominated);

    std::cout << "\t";
    std::sort(postDirDominator.begin(), postDirDominator.end());
    if(postDirDominator.size() == 0) std::cout << "X" << std::endl;
    else printVector(postDirDominator);
  }
};
std::map<std::string, CFGEntry*> CFG;
std::vector<std::string> end;
bool changed;

std::vector<std::string> Union(const std::vector<std::string>& vec1, const std::vector<std::string>& vec2) {
    // Concatenate vectors
    std::vector<std::string> result = vec1;
    result.insert(result.end(), vec2.begin(), vec2.end());

    // Sort the concatenated vector
    std::sort(result.begin(), result.end());

    // Remove duplicates
    auto newEnd = std::unique(result.begin(), result.end());
    result.erase(newEnd, result.end());

    return result;
}

std::vector<std::string> Intersection(const std::vector<std::string>& vec1, const std::vector<std::string>& vec2) {
    std::vector<std::string> result;

    // Step 1: Sort both vectors
    std::vector<std::string> sortedVec1 = vec1;
    std::vector<std::string> sortedVec2 = vec2;

    std::sort(sortedVec1.begin(), sortedVec1.end());
    std::sort(sortedVec2.begin(), sortedVec2.end());

    // Step 2: Compute the intersection
    std::vector<std::string> intersection;
    std::set_intersection(sortedVec1.begin(), sortedVec1.end(),
                          sortedVec2.begin(), sortedVec2.end(),
                          std::back_inserter(intersection));

    return intersection;
}

void Remove(std::vector<std::string>& vec, const std::string& value) {
    auto newEnd = std::remove(vec.begin(), vec.end(), value);
    vec.erase(newEnd, vec.end());
}

void CleanVisitFlag(){
  for (auto& element : CFG) {
      element.second->visited = false;
  }
}

void CreateCFG(BasicBlock* currBB){
  std::string currBBName = currBB->getName().str();
  assert(CFG.find(currBBName) != CFG.end());

  CFGEntry* currEntry = CFG.find(currBBName)->second;
  if(currEntry->visited) return;
  currEntry->visited = true;
  currEntry->name = currBBName;

  if (llvm::Instruction* branchInst = llvm::dyn_cast<llvm::BranchInst>(&currBB->back())) {
    
    for (int i = 0, e = branchInst->getNumSuccessors(); i != e; i++) {
      BasicBlock* itrBB = branchInst->getSuccessor(i);
      std::string itrBBName = itrBB->getName().str();
      CFGEntry* itrEntry = nullptr;
      if(CFG.find(itrBBName) == CFG.end()){
        CFG[itrBBName] = new CFGEntry();
        CFG[itrBBName]->BB = itrBB;
      }
      itrEntry = CFG[itrBBName];
      
      if(itrEntry->predecessors.find(currEntry) == itrEntry->predecessors.end()){
        itrEntry->predecessors.insert(currEntry);
      }
      if(currEntry->successors.find(itrEntry) == currEntry->successors.end()){
        currEntry->successors.insert(itrEntry);
      }

      CreateCFG(itrBB);
    }
  }
  else{
    end.push_back(currBBName);
  }
}

void DominatorPipeline(CFGEntry* currEntry){
  std::vector<std::string> oldDom = currEntry->dominator;

  bool set = false;
  for (const auto& element : currEntry->predecessors) {
    currEntry->dominator = Intersection(currEntry->dominator, element->dominator);
  }
  currEntry->dominator = Union(std::vector<std::string>{currEntry->name}, currEntry->dominator);

  if(oldDom != currEntry->dominator) changed = true;
}

void DominatedPipeline(CFGEntry* currEntry){
  for (const auto& pair : CFG) {
    if (std::find(pair.second->dominator.begin(), pair.second->dominator.end(), currEntry->name) != pair.second->dominator.end()) {
        currEntry->dominated.push_back(pair.second->name);
    }
  }
}

void DirDominatorPipeline(CFGEntry* currEntry){
  std::vector<std::string> dirDom = currEntry->dirDominator;
  
  for(const std::string& S : currEntry->dirDominator){
    for(const std::string& T: currEntry->dirDominator){
      if(S==T) continue;
      const auto & dirDomS = CFG[S]->dirDominator;

      if(std::find(dirDomS.begin(), dirDomS.end(), T) != dirDomS.end()){
        Remove(dirDom, T);
      }
    }
  }
  currEntry->dirDominator = dirDom;
}

void PostDominatorPipeline(CFGEntry* currEntry){
  std::vector<std::string> oldDom = currEntry->postDominator;

  bool set = false;
  for (const auto& element : currEntry->successors) {
    currEntry->postDominator = Intersection(currEntry->postDominator, element->postDominator);
  }
  currEntry->postDominator = Union(std::vector<std::string>{currEntry->name}, currEntry->postDominator);

  if(oldDom != currEntry->postDominator) changed = true;
}

void PostDominatedPipeline(CFGEntry* currEntry){
  for (const auto& pair : CFG) {
    if (std::find(pair.second->postDominator.begin(), pair.second->postDominator.end(), currEntry->name) != pair.second->postDominator.end()) {
        currEntry->postDominated.push_back(pair.second->name);
    }
  }
}

void PostDirDominatorPipeline(CFGEntry* currEntry){
  std::vector<std::string> dirDom = currEntry->postDirDominator;
  
  for(const std::string& S : currEntry->postDirDominator){
    for(const std::string& T: currEntry->postDirDominator){
      if(S==T) continue;
      const auto & dirDomS = CFG[S]->postDirDominator;

      if(std::find(dirDomS.begin(), dirDomS.end(), T) != dirDomS.end()){
        Remove(dirDom, T);
      }
    }
  }
  currEntry->postDirDominator = dirDom;
}

void FrontPropagatePrinter(CFGEntry* currEntry){
  if(currEntry->visited) return;
  currEntry->visited = true;

  currEntry->Printer();

  std::vector<std::string> oldDom = currEntry->dominator;
  for (const auto& element : currEntry->successors) {
    FrontPropagatePrinter(element);
  }
}

// This method implements what the pass does
void processFunction(Function &F) {

  // ECE467 STUDENT: add your code here
  /* CFG Creation */
  for (llvm::BasicBlock& BB : F) {
    if (BB.getName() == "entry") {
      CFG["entry"] = new CFGEntry();
      CFG["entry"]->BB = &BB;
      break;
    }
  }
  CreateCFG(CFG["entry"]->BB);
  assert(end.size() == 1);


  std::vector<std::string> nodeList;
  for (const auto& pair : CFG) {
    nodeList.push_back(pair.first);
  }
  for (const auto& pair : CFG) {
    pair.second->dominator = nodeList;
    pair.second->postDominator = nodeList;
  }
  CFG["entry"]->dominator.clear();
  CFG["entry"]->dominator.push_back("entry");
  CFG[end[0]]->postDominator.clear();
  CFG[end[0]]->postDominator.push_back(end[0]);

  /* Dominator */
  changed = true;
  while(changed){
    changed = false;
    for (const auto& pair : CFG) {
      DominatorPipeline(pair.second);
    }
  }

  /* Dominated */
  for (const auto& pair : CFG) {
    DominatedPipeline(pair.second);
  }

  /* Direct Dominator */
  for (const auto& pair : CFG) {
    if(pair.first == "entry")continue;
    pair.second->dirDominator = pair.second->dominator;
    Remove(pair.second->dirDominator, pair.second->name);
  }
  changed = true;
  while(changed){
    changed = false;
    for (const auto& pair : CFG) {
      if(pair.first == "entry")continue;
      DirDominatorPipeline(pair.second);
    }
  }


  
  /* Post Dominator */
  changed = true;
  while(changed){
    changed = false;
    for (const auto& pair : CFG) {
      PostDominatorPipeline(pair.second);
    }
  }

  /* Post Dominated */
  for (const auto& pair : CFG) {
    PostDominatedPipeline(pair.second);
  }

  /* Post Direct Dominator */
  for (const auto& pair : CFG) {
    if(pair.first == end[0])continue;
    pair.second->postDirDominator = pair.second->postDominator;
    Remove(pair.second->postDirDominator, pair.second->name);
  }
  for (const auto& pair : CFG) {
    if(pair.first == end[0])continue;
    PostDirDominatorPipeline(pair.second);
  }

  
  /* Printer */
  for (const auto& pair : CFG) {
    pair.second->Printer();
  }
}

struct A5Dom : PassInfoMixin<A5Dom> {
  // This is the main entry point for processing the IR of a function
  // It simply calls the function that has your code
  PreservedAnalyses run(Function &F, FunctionAnalysisManager &) {
    processFunction(F);
    return PreservedAnalyses::all();
  }

  // This makes sure that the pass is executed, even when functions are
  // decorated with the optnone attribute; this is the case when using
  // clang without -O flags
  static bool isRequired() { return true; }
};
} // namespace

// Register the pass with the pass manager as a function pass
llvm::PassPluginLibraryInfo getA5DomPluginInfo() {
  return {LLVM_PLUGIN_API_VERSION, "A5Dom", LLVM_VERSION_STRING,
          [](PassBuilder &PB) {
            PB.registerPipelineParsingCallback(
                [](StringRef Name, FunctionPassManager &FPM,
                   ArrayRef<PassBuilder::PipelineElement>) {
                  if (Name == "A5Dom") {
                    FPM.addPass(A5Dom());
                    return true;
                  }
                  return false;
                });
          }};
}

// This ensures that opt recognizes A5Dom when specified on the
// command line by -passes="A5Dom"
extern "C" LLVM_ATTRIBUTE_WEAK ::llvm::PassPluginLibraryInfo
llvmGetPassPluginInfo() {
  return getA5DomPluginInfo();
}
