#include "scio.h"

int func0(){
    int i;
    i = 0;

    while(true){
        i = i + 1;
        if(i > 1000) return 0;
        else i + 2;
        return -1;
    }

    if(i != 0) i = i+1;
    else return -4;

    return -3;
}

void func1(){
    while(true){
        return;
    }
}

void func2(){
    while(true){
        return;
    }
    return;
}

void func3(){
    if(1 >= 3) return;
}

void main() {
    int a;
    a = func0();
    func1();
    func2();
    func3();
    
}