package com.qexz.chapter08.item03;

import java.util.concurrent.ThreadFactory;

/**
 * 程序清单8-6 自定义的线程工厂
 * @author zzqnxx@foxmail.com
 * @date 2018/6/1 19:56
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}