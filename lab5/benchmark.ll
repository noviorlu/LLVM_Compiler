; ModuleID = './benchmark.bc'
source_filename = "./benchmark.bc"
target triple = "x86_64-unknown-linux-gnu"

define i32 @main() {
entry:
  %x = alloca i32, align 4
  %y = alloca i32, align 4
  %z = alloca i32, align 4
  store i32 1, ptr %x, align 4
  store i32 3, ptr %y, align 4
  store i32 11, ptr %z, align 4
  br label %while.cond

while.cond:                                       ; preds = %merge, %entry
  %0 = load i32, ptr %x, align 4
  %1 = icmp slt i32 %0, 5
  %2 = load i32, ptr %z, align 4
  %3 = icmp ne i32 %2, 1
  %4 = and i1 %1, %3
  br i1 %4, label %while.body, label %while.exit

while.body:                                       ; preds = %while.cond
  %5 = load i32, ptr %y, align 4
  %6 = icmp slt i32 %5, 5
  br i1 %6, label %then, label %else

while.exit:                                       ; preds = %while.cond
  ret i32 0

then:                                             ; preds = %while.body
  %7 = load i32, ptr %y, align 4
  %8 = add i32 %7, 1
  store i32 %8, ptr %y, align 4
  br label %merge

merge:                                            ; preds = %else, %then
  %9 = load i32, ptr %x, align 4
  %10 = add i32 %9, 1
  store i32 %10, ptr %x, align 4
  br label %while.cond

else:                                             ; preds = %while.body
  br label %merge
}
