#!/bin/bash

echo "obase=10;ibase=8;11" | bc -l

echo $((8#11))
