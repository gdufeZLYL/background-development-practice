#!/bin/bash

# 范例：数字或者数字组合
i=5;j=9423483247234;
echo $i | grep -q "^[0-9]$"
echo $?
# 0
echo $j | grep -q "^[0-9]\+$"
echo $?
# 0

# 范例：字符组合（小写字母、大写字母、两者的组合）
c="A"; d="fwefewjuew"; e="fewfEFWefwefe"
echo $c | grep -q "^[A-Z]$"
echo $d | grep -q "^[a-z]\+$"
echo $e | grep -q "^[a-zA-Z]\+$"

# 范例：字母和数字的组合
ic="432fwfwefeFWEwefwef"
echo $ic | grep -q "^[0-9a-zA-Z]\+$"

# 范例：空格或者 Tab 键等
echo " " | grep " "
echo -e "\t" | grep "[[:space:]]" #[[:space:]]会同时匹配空格和TAB键
echo -e " \t" | grep "[[:space:]]"
echo -e "\t" | grep "" #为在键盘上按下TAB键，而不是字符

# 范例：匹配邮件地址
echo "test2007@lzu.cn" | grep "[0-9a-zA-Z\.]*@[0-9a-zA-Z\.]*"
# test2007@lzu.cn

# 范例：匹配 URL 地址(以 http 链接为例）
echo "http://news.lzu.edu.cn/article.jsp?newsid=10135" | grep "^http://[0-9a-zA-Z\./=?]\+$"
# http://news.lzu.edu.cn/article.jsp?newsid=10135

# 范例：判断字符是否为可打印字符
echo "\t\n" | grep "[[:print:]]"
# \t\n
echo $?
# 0
echo -e "\t\n" | grep "[[:print:]]"
echo $?
# 1