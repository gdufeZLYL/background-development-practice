package com.qexz.chapter04.item02;

import net.jcip.annotations.GuardedBy;

/**
 * 程序清单4-3 通过一个私有锁来保护状态
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 11:48
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }

    interface Widget {

    }
}
