package com.qexz.chapter14.item05;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;


/**
 * 程序清单14-14 使用AbstractQueuedSynchronizer实现的二元闭锁
 * @author zzqnxx@foxmail.com
 * @date 2018/6/6 16:09
 */
@ThreadSafe
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        protected int tryAcquireShared(int ignored) {
            // Succeed if latch is open (state == 1), else fail
            return (getState() == 1) ? 1 : -1;
        }

        protected boolean tryReleaseShared(int ignored) {
            setState(1); // Latch is now open
            return true; // Other threads may now be able to acquire

        }
    }
}