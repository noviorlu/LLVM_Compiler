make
/cad2/ece467f/llvm-project/build/bin/opt -load-pass-plugin=libA5Dom.so -passes="A5Dom" -disable-output benchmark.ll > benchmark.log
/cad2/ece467f/llvm-project/build/bin/opt -load-pass-plugin=/cad2/ece467f/public/libA5Dom-reference.so -passes="A5Dom" -disable-output benchmark.ll

#/cad2/ece467f/public/libA5Dom-reference.so