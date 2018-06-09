#!/bin/bash

# 范例：获取一个随机数
echo $RANDOM

echo "" | awk '{srand(); printf("%f", rand());}'

# 范例：随机产生一个从0到255之间的数字
expr $RANDOM / 128

echo "" | awk '{srand(); printf("%d\n", rand()*255);}'

# 思考：如果要随机产生某个 IP 段的 IP 地址，该如何做呢？看例子：友善地获取一个可用的 IP 地址。
# getip.sh -- get an usable ipaddress automatically
# author: falcon &lt;zhangjinw@gmail.com>
# update: Tue Oct 30 23:46:17 CST 2007

# set your own network, default gateway, and the time out of "ping" command
net="192.168.1"
default_gateway="192.168.1.1"
over_time=2

# check the current ipaddress
ping -c 1 $default_gateway -W $over_time
[ $? -eq 0 ] && echo "the current ipaddress is okey!" && exit -1;

while :; do
    # clear the current configuration
    ifconfig eth0 down
    # configure the ip address of the eth0
    ifconfig eth0 \
        $net.$(($RANDOM /130 +2)) \
        up
    # configure the default gateway
    route add default gw $default_gateway
    # check the new configuration
    ping -c 1 $default_gateway -W $over_time
    # if work, finish
    [ $? -eq 0 ] && break
done