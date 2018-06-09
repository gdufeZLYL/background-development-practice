#!/bin/bash

echo "scale=3;1/13" | bc

echo "1 13" | awk '{printf("0.3f\n",$1/$2)}'

echo 1/13100 | bc -l