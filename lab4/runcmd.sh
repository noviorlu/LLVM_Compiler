rm ./benchmark.bc
rm ./benchmark.ll
rm ./benchmark-ref.ll

./A4Gen-ref ./benchmark.sc
/cad2/ece467f/llvm-project/build/bin/llvm-dis ./benchmark.bc
# Check if the source file exists
if [ -f "./benchmark.ll" ]; then
    mv "./benchmark.ll" "./benchmark-ref.ll"
    echo "File renamed successfully."
else
    echo "Error: ./benchmark.ll does not exist."
fi

./A4Gen ./benchmark.sc
/cad2/ece467f/llvm-project/build/bin/llvm-dis ./benchmark.bc

# /cad2/ece467f/llvm-project/build/bin/clang benchmark.bc libscio.a -o benchmark
# /cad2/ece467f/llvm-project/build/bin/clang benchmark.bc libscio.a -o benchmark
