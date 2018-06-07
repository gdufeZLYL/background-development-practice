package com.qexz.chapter16.item02;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单16-3 不安全的延迟初始化(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/6/7 18:43
 */
@NotThreadSafe
public class UnsafeLazyInitialization {
    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null)
            resource = new Resource(); // unsafe publication
        return resource;
    }

    static class Resource {
    }
}
