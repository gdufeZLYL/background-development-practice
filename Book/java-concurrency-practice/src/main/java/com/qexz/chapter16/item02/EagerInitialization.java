package com.qexz.chapter16.item02;

import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单16-5 提前初始化
 * @author zzqnxx@foxmail.com
 * @date 2018/6/7 19:20
 */
@ThreadSafe
public class EagerInitialization {
    private static Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {
    }
}
