package com.qexz.chapter09.item01;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.*;

/**
 * 程序清单9-1 使用Executor来实现SwingUtilities
 * @author zzqnxx@foxmail.com
 * @date 2018/6/2 17:12
 */
public class SwingUtilities {
    private static final ExecutorService exec =
            Executors.newSingleThreadExecutor(new SwingThreadFactory());
    private static volatile Thread swingThread;

    private static class SwingThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
            swingThread = new Thread(r);
            return swingThread;
        }
    }

    public static boolean isEventDispatchThread() {
        return Thread.currentThread() == swingThread;
    }

    public static void invokeLater(Runnable task) {
        exec.execute(task);
    }

    public static void invokeAndWait(Runnable task)
            throws InterruptedException, InvocationTargetException {
        Future f = exec.submit(task);
        try {
            f.get();
        } catch (ExecutionException e) {
            throw new InvocationTargetException(e);
        }
    }
}