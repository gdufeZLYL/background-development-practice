#!/bin/bash

# 范例：数值测试
if test 5 -eq 5;then echo "YES"; else echo "NO"; fi
# YES
if test 5 -ne 5;then echo "YES"; else echo "NO"; fi
# NO

# 范例：字符串测试
if test -n "not empty";then echo "YES"; else echo "NO"; fi
# YES
if test -z "not empty";then echo "YES"; else echo "NO"; fi
# NO
if test -z "";then echo "YES"; else echo "NO"; fi
# YES
if test -n "";then echo "YES"; else echo "NO"; fi
# NO

# 范例：文件测试
if test -f /boot/System.map; then echo "YES"; else echo "NO"; fi
# YES
if test -d /boot/System.map; then echo "YES"; else echo "NO"; fi
# NO

# 范例：如果 a，b，c 都等于下面对应的值，那么打印 YES，通过 -a 进行"与"测试
a=5;b=4;c=6;
if test $a -eq 5 -a $b -eq 4 -a $c -eq 6; then echo "YES"; else echo "NO"; fi
# YES

# 范例：测试某个“东西”是文件或者目录，通过 -o 进行“或”运算
if test -f /etc/profile -o -d /etc/profile;then echo "YES"; else echo "NO"; fi
# YES

# 范例：测试某个“东西”是否为文件，测试 ! 非运算
if test ! -f /etc/profile; then echo "YES"; else echo "NO"; fi
# NO

# 范例：要求某文件可执行且有内容，用 -a 和 && 分别实现
cat > test.sh
# #!/bin/bash
# echo "test"
# [CTRL+D]  # 按下组合键CTRL与D结束cat输入，后同，不再注明
chmod +x test.sh
if test -s test.sh -a -x test.sh; then echo "YES"; else echo "NO"; fi
# YES
if test -s test.sh && test -x test.sh; then echo "YES"; else echo "NO"; fi
# YES

# 范例：要求某个字符串要么为空，要么和某个字符串相等
str1="test"
str2="test"
if test -z "$str2" -o "$str2" == "$str1"; then echo "YES"; else echo "NO"; fi
# YES
if test -z "$str2" || test "$str2" == "$str1"; then echo "YES"; else echo "NO"; fi
# YES

# 范例：测试某个数字不满足指定的所有条件
i=5
if test ! $i -lt 5 -a $i -ne 6; then echo "YES"; else echo "NO"; fi
# YES
if ! test $i -lt 5 -a $i -eq 6; then echo "YES"; else echo "NO"; fi
# YES

# -ne 和 -eq 对应的，我们有时候可以免去 ! 运算
i=5
if test $i -eq 5; then echo "YES"; else echo "NO"; fi
# YES
if test $i -ne 5; then echo "YES"; else echo "NO"; fi
# NO
if test ! $i -eq 5; then echo "YES"; else echo "NO"; fi
# NO

# 用 [ ] 可以取代 test，这样看上去会“美观”很多
if [ $i -eq 5 ]; then echo "YES"; else echo "NO"; fi
# YES
if [ $i -gt 4 ] && [ $i -lt 6 ]; then echo "YES"; else echo "NO"; fi
# YES

# 记得给一些字符串变量加上 ""，记得 [ 之后与 ] 之前多加一个空格
str=""
if [ "$str" = "test"]; then echo "YES"; else echo "NO"; fi
# -bash: [: missing `]'
# NO
if [ $str = "test" ]; then echo "YES"; else echo "NO"; fi
# -bash: [: =: unary operator expected
# NO
if [ "$str" = "test" ]; then echo "YES"; else echo "NO"; fi
# NO