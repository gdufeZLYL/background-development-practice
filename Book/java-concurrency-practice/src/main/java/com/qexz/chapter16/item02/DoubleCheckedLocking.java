package com.qexz.chapter16.item02;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单16-7 双重检查加锁(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/6/7 19:49
 */
@NotThreadSafe
public class DoubleCheckedLocking {
    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resource == null)
                    resource = new Resource();
            }
        }
        return resource;
    }

    static class Resource {

    }
}
