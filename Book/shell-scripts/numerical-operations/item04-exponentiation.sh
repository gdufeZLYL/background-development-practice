#!/bin/bash

let i=5**2
echo $i

((i=5**2))
echo $i

echo "5^2" | bc
