package com.qexz.chapter07.item01;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 程序清单7-5 通过中断来取消
 * @author zzqnxx@foxmail.com
 * @date 2018/5/31 21:06
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
            /* Allow thread to exit */
        }
    }

    public void cancel() {
        interrupt();
    }
}
