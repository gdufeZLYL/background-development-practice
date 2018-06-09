#!/bin/bash
expr 5 % 2

let i=5%2
echo $i

echo 5 % 2 | bc

((i=5%2))
echo $i
