# _*_ coding: utf-8 _*_

from random import randint

# 过滤列表[3,9,-10,20,-2...]中的负数
# data = [randint(-10, 10) for _ in range(10)]
# print(data)
# target = list(filter(lambda x: x >= 0, data))
# print(target)
# print([x for x in data if x >= 0])

# 晒出字典{'LiLei':79,'Jim':88,'Lucy':92...}中值高于90的项
# d = {x: randint(60, 100) for x in range(1, 21)}
# print(d)
# target = {k: v for k, v in d.items() if v > 90}
# print(target)

# 筛出集合中能被3整除的数
# data = [randint(-10, 10) for _ in range(10)]
# s = set(data)
# print(s)
# target = {x for x in s if x % 3 == 0}