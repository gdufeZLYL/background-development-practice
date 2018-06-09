#!/bin/bash
# statistic_words.sh

if [ $# -lt 1 ]; then
    echo "Usage: basename $0 FILE WORDS ...."
    exit -1
fi

FILE=$1
((WORDS_NUM=$#-1))

for n in $(seq $WORDS_NUM)
do
    shift
    cat $FILE | sed -e "s/[^a-zA-Z]/\n/g" \
        | grep -v ^$ | sort | grep ^$1$ | uniq -c
done