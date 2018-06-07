package com.qexz.chapter06.item02;

import java.util.concurrent.Executor;

/**
 * 程序清单6-6 在调用线程中以同步方式执行所有任务的Executor
 * @author zzqnxx@foxmail.com
 * @date 2018/5/30 21:30
 */
public class WithinThreadExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();
    };
}
