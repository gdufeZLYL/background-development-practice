#!/bin/bash

# 范例：在屏幕控制字符显示位置、颜色、背景等
echo -e "\033[31;40m" #设置前景色为黑色，背景色为红色
echo -e '\033[11;29H Hello, World!' #在屏幕的第11行，29列开始打印字符串Hello,World!

# 范例：在屏幕的某个位置动态显示当前系统时间\
$ while :; do echo -e "\033[11;29H "$(date "+%Y-%m-%d %H:%M:%S"); done

# 范例：过滤掉某些控制字符串
screen -L
cat /bin/cat
exit
cat screenlog.0 | col -b   # 把一些控制字符过滤后，就可以保留可读的操作日志