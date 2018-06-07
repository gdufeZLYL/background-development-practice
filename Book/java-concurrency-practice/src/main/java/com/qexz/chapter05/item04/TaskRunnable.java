package com.qexz.chapter05.item04;

import java.util.concurrent.BlockingQueue;

/**
 * 程序清单5-10 恢复中断状态以避免屏蔽中断
 * @author zzqnxx@foxmail.com
 * @date 2018/5/30 11:51
 */
public class TaskRunnable implements Runnable {
    BlockingQueue<Task> queue;

    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            // restore interrupted status
            Thread.currentThread().interrupt();
        }
    }

    void processTask(Task task) {
        // Handle the task
    }

    interface Task {
    }
}