package com.qexz.chapter03.item01;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单3-2 非线程安全的可变整数类
 * @author zzqnxx@foxmail.com
 * @date 2018/5/27 21:34
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
