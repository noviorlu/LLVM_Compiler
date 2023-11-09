int z;

int main() {
    int x;
    bool y;

    if (x) return -1;
    if (y) return 1;
    return 0;
}


// Program [useIO=0](1,0)
//         Scalar Declaration      Int(1,0)
//                 Identifier[name:z](1,4)
//         Function[isProto=0]     Int(3,0)
//                 Identifier[name:main](3,4)
//                 Scope(3,11)
//                         Scalar Declaration                      Int(4,4)
//                                 Identifier[name:x](4,8)
//                         Scalar Declaration                      Bool(5,4)
//                                 Identifier[name:y](5,9)
//                         IfStmt[hasElse=0](7,4)
//                                 Int Expression(7,8)
//                                         Reference(7,8)
//                                                 Identifier[name:x](7,8)
//                                 ReturnStmt(7,11)
//                                         Int Expression(7,18)
//                                                 IntConstant[val=0](7,18)
//                         IfStmt[hasElse=0](8,4)
//                                 Int Expression(8,8)
//                                         Reference(8,8)
//                                                 Identifier[name:y](8,8)
//                                 ReturnStmt(8,11)
//                                         Int Expression(8,18)
//                                                 IntConstant[val=0](8,18)
//                         ReturnStmt(9,4)
//                                 Int Expression(9,11)
//                                         IntConstant[val=0](9,11)