package com.qexz.chapter15.item02;

import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单15-2 基于CAS实现的非阻塞计数器
 * @author zzqnxx@foxmail.com
 * @date 2018/6/6 21:17
 */
@ThreadSafe
public class CasCounter {
    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
