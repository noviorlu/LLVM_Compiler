#include "scio.h"

void func1(int a, bool b){
    -a;
    !b;
}

void func2(int a[]){
 
}

void main(){
    int x[10];
    bool y[10];

    x[3] >= x[4];
    y[3] != y[4];

    func1(x[5], y[5]);
    func2(x);
}