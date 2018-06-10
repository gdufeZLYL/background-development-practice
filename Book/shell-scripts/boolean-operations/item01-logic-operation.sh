#!/bin/bash

if true;then echo "YES"; else echo "NO"; fi
# YES

if false;then echo "YES"; else echo "NO"; fi
# NO

# 与运算
if true && true;then echo "YES"; else echo "NO"; fi
# YES

if true && false;then echo "YES"; else echo "NO"; fi
# NO

if false && false;then echo "YES"; else echo "NO"; fi
# NO

if false && true;then echo "YES"; else echo "NO"; fi
# NO

# 或运算
if true || true;then echo "YES"; else echo "NO"; fi
# YES

if true || false;then echo "YES"; else echo "NO"; fi
# YES

if false || true;then echo "YES"; else echo "NO"; fi
# YES

if false || false;then echo "YES"; else echo "NO"; fi
# NO

# 非运算，即取反
if ! false;then echo "YES"; else echo "NO"; fi
# YES

if ! true;then echo "YES"; else echo "NO"; fi
# NO

# 范例：返回值 v.s. 逻辑值
true
echo $?
# 0
false
echo $?
# 1

# 范例：查看 true 和 false 帮助和类型
help true false
# true: true
#      Return a successful result.
# false: false
#      Return an unsuccessful result.
type true false
# true is a shell builtin
# false is a shell builtin