#!/bin/bash

# 范例：把字符串拆分成字符串数组
var="get the length of me"
var_arr=($var)    #把字符串var存放到字符串数组var_arr中，默认以空格作为分割符
echo ${var_arr[0]} ${var_arr[1]} ${var_arr[2]} ${var_arr[3]} ${var_arr[4]}
# get the length of me
echo ${var_arr[@]}    #整个字符串，可以用*代替@，下同
# get the length of me
echo ${#var_arr[@]}   #类似于求字符串长度，`#`操作符也可用来求数组元素个数
# 5

# 也可以直接给某个数组元素赋值
var_arr[5]="new_element"
echo ${#var_arr[@]}
# 6
echo ${var_arr[5]}
# new_element

# Bash 实际上还提供了一种类似于“数组”的功能，即 for i in，它可以很方便地获取某个字符串的各个部分，例如：
for i in $var; do echo -n $i"_"; done
# get_the_length_of_me_

# awk 里的数组，注意比较它和 Bash 里的数组的异同
# split 把一行按照空格分割，存放到数组 var_arr 中，并返回数组长度。注意：这里第一个元素下标不是 0，而是 1
echo $var | awk '{printf("%d %s\n", split($0, var_arr, " "), var_arr[1]);}'
# 5 get

# 实际上，上述操作很类似 awk 自身的行处理功能： awk 默认把一行按照空格分割为多个域，并可以通过 $1，$2，$3 ... 来获取，$0 表示整行。
# 这里的 NF 是该行的域的总数，类似于上面数组的长度，它同样提供了一种通过类似“下标”访问某个字符串的功能。
echo $var | awk '{printf("%d | %s %s %s %s %s | %s\n", NF, $1, $2, $3, $4, $5, $0);}'
# 5 | get the length of me | get the length of me

# awk 的“数组”功能何止于此呢，看看它的 for 引用吧，注意，这个和 Bash 里头的 for 不太一样，i 不是元素本身，而是下标：
echo $var | awk '{split($0, var_arr, " "); for(i in var_arr) printf("%s ",var_arr[i]);}'
# of me get the length
# 4 5 1 2 3

# 另外，从上述结果可以看到，经过 for 处理后，整个结果没有按照原理的字符顺序排列，不过如果仅仅是迭代出所有元素这个同样很有意义。
# awk 还有更“厉害”的处理能力，它的下标可以不是数字，可以是字符串，从而变成了“关联”数组，这种“关联”在某些方面非常方便。 比如，把某个文件中的某个系统调用名根据另外一个文件中的函数地址映射表替换成地址，可以这么实现：
cat symbol
# sys_exit
# sys_read
# sys_close
ls /boot/System.map*
# /boot/System.map-2.6.20-16-generic
awk '{if(FILENAME ~ "System.map") map[$3]=$1; else {printf("%s\n", map[$1])}}' \
    /boot/System.map-2.6.20-16-generic symbol
# c0129a80
# c0177310
# c0175d80