#include "scio.h"

int function1(){
    return -1;
}

bool function2(){
    return false;
}

void main(){
    bool x[10];
    bool y;
    int a;
    int b;

    x[3] = y;
    y = x[4];

    a = b;

    a = function1();
    y = function2();
}