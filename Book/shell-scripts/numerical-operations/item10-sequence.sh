#!/bin/bash

seq 5

seq 1 5

seq 1 2 5

seq -s: 1 2 5

seq 1 2 14

seq -w 1 2 14

seq -s: -w 1 2 14

seq -f "0x%g" 1 5

for i in `seq -f"http://thns.tsinghua.edu.cn/thnsebooks/ebook73/%02g.pdf" 1 21`;do wget -c $i; done

for i in `seq -w 1 21`;do wget -c "http://thns.tsinghua.edu.cn/thnsebooks/ebook73/$i"; done

for i in {1..5}; do echo -n "$i "; done