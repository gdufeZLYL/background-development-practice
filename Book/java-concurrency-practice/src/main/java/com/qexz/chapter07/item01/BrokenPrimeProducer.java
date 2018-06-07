package com.qexz.chapter07.item01;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 程序清单7-3 不可靠的取消操作将把生产者置于阻塞的操作中(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/5/31 13:28
 */
class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled)
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
        }
    }

    public void cancel() {
        cancelled = true;
    }
}
