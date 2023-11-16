./A4Gen ./benchmark.sc
# /cad2/ece467f/llvm-project/build/bin/clang benchmark.bc libscio.a -o benchmark
/cad2/ece467f/llvm-project/build/bin/llvm-dis ./benchmark.bc

./A4Gen-ref ./benchmark-ref.sc
# # /cad2/ece467f/llvm-project/build/bin/clang benchmark.bc libscio.a -o benchmark
/cad2/ece467f/llvm-project/build/bin/llvm-dis ./benchmark-ref.bc