package com.qexz.chapter06.item02;

import java.util.concurrent.Executor;

/**
 * 程序清单6-5 为每个请求启动一个新线程的Executor
 * @author zzqnxx@foxmail.com
 * @date 2018/5/30 21:09
 */
public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    };
}