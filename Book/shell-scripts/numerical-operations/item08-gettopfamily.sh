#!/bin/bash
# gettopfamily.sh

[ $# -lt 1 ] && echo "please input the income file" && exit -1
[ ! -f $1 ] && "$1 is not a file" && exit -1

income=$1
awk 'BEGIN{ print NR } {
        printf("%d %0.2f\n", $1, $3/$2);
}' $income | sort -k 2 -n -r
