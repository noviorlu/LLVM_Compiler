#include "scio.h"

void func0(){

}

void func1(int a, bool b){
    -a;
    !b;
}

void func2(int a[], bool b[]){
    a[3]+a[4];
    !b[1];
}

int func4(){
    return 0;
}

bool func5(){
    return false;
}

void main(){
    int x[10];
    bool y[10];
    int a;
    bool b;

    func0();
    func1(a,b);
    func1(x[3],y[3]);
    func2(x,y);
}