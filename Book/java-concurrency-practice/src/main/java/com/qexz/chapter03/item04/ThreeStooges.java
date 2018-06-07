package com.qexz.chapter03.item04;

import java.util.HashSet;
import java.util.Set;

/**
 * 程序清单3-11 在可变对象基础上构建的不可变类
 * @author zzqnxx@foxmail.com
 * @date 2018/5/28 13:03
 */
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}
