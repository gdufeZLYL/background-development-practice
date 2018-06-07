package com.qexz.chapter16.item02;

import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单16-4 线程安全的延迟初始化
 * @author zzqnxx@foxmail.com
 * @date 2018/6/7 19:12
 */
@ThreadSafe
public class SafeLazyInitialization {
    private static Resource resource;

    public synchronized static Resource getInstance() {
        if (resource == null)
            resource = new Resource();
        return resource;
    }

    static class Resource {
    }
}
