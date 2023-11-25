make
rm ./benchmark.bc
rm ./benchmark.ll
rm ./benchmark-ref.ll
rm ./benchmark
rm ./benchmark-ref

/cad2/ece467f/public/A4Gen-reference ./benchmark.sc
/cad2/ece467f/llvm-project/build/bin/llvm-dis ./benchmark.bc
/cad2/ece467f/llvm-project/build/bin/clang benchmark.bc libscio.a -o benchmark-ref
# Check if the source file exists
if [ -f "./benchmark.ll" ]; then
    mv "./benchmark.ll" "./benchmark-ref.ll"
    echo "File renamed successfully."
else
    echo "Error: ./benchmark.ll does not exist."
fi

./A4Gen ./benchmark.sc
/cad2/ece467f/llvm-project/build/bin/llvm-dis ./benchmark.bc
/cad2/ece467f/llvm-project/build/bin/clang benchmark.bc libscio.a -o benchmark

# Define the paths to the binaries
BINARY_REF="./benchmark-ref"
BINARY_TEST="./benchmark"

# Check if both binaries exist
if [ ! -f "$BINARY_REF" ]; then
    echo "Reference binary not found: $BINARY_REF"
    exit 1
fi

if [ ! -f "$BINARY_TEST" ]; then
    echo "Test binary not found: $BINARY_TEST"
    exit 1
fi

# Execute binaries and capture their outputs
OUTPUT_REF=$(mktemp)
OUTPUT_TEST=$(mktemp)

"$BINARY_REF" > "$OUTPUT_REF"
"$BINARY_TEST" > "$OUTPUT_TEST"

# Compare the outputs
if diff "$OUTPUT_REF" "$OUTPUT_TEST" > /dev/null; then
    echo "The outputs are identical."
else
    echo "The outputs differ:"
    diff "$OUTPUT_REF" "$OUTPUT_TEST"
fi

# Clean up temporary files
rm "$OUTPUT_REF" "$OUTPUT_TEST"
