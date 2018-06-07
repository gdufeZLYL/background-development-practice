package com.qexz.chapter08.item05;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * 程序清单8-17 由ConcurrentPuzzleSolver使用的携带结果的闭锁
 * @author zzqnxx@foxmail.com
 * @date 2018/6/2 8:40
 */
@ThreadSafe
public class ValueLatch <T> {
    @GuardedBy("this") private T value = null;
    private final CountDownLatch done = new CountDownLatch(1);

    public boolean isSet() {
        return (done.getCount() == 0);
    }

    public synchronized void setValue(T newValue) {
        if (!isSet()) {
            value = newValue;
            done.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        done.await();
        synchronized (this) {
            return value;
        }
    }
}
