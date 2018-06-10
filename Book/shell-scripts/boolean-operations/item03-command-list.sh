#!/bin/bash

# 范例：如果 ping 通 www.lzu.edu.cn，那么打印连通信息
ping -c 1 www.lzu.edu.cn -W 1 && echo "=======connected======="

# 范例：在脚本里判断程序的参数个数，和参数类型
echo $#
echo $1
if [ $# -eq 1 ] && (echo $1 | grep '^[0-9]*$' >/dev/null);then
    echo "YES"
fi

# 再加上 exit 1，我们将省掉 if/then 结构
echo $#
echo $1
! ([ $# -eq 1 ] && (echo $1 | grep '^[0-9]*$' >/dev/null)) && exit 1

echo "YES"