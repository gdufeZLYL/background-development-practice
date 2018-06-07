package com.qexz.chapter08.item01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 程序清单8-1 在单线程Executor中任务发生死锁(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/6/1 17:09
 */
public class ThreadDeadlock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public class LoadFileTask implements Callable<String> {
        private final String fileName;

        public LoadFileTask(String fileName) {
            this.fileName = fileName;
        }

        public String call() throws Exception {
            // Here's where we would actually read the file
            return "";
        }
    }

    public class RenderPageTask implements Callable<String> {
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            // Will deadlock -- task waiting for result of subtask
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            // Here's where we would actually render the page
            return "";
        }
    }
}
