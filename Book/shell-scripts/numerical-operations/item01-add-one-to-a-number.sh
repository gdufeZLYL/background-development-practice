#!/bin/bash
i=0;
((i++))
echo $i

let i++
echo $i

expr $i + 1
echo $i

echo $i 1 | awk '{printf $1+$2}'
