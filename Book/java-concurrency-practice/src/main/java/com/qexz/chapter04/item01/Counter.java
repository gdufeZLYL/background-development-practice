package com.qexz.chapter04.item01;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单4-1 使用Java监视器模式的线程安全计数器
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 9:31
 */
@ThreadSafe
public final class Counter {

    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
