package com.qexz.chapter16.item02;

import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单16-6 延长初始化占位类模式
 * @author zzqnxx@foxmail.com
 * @date 2018/6/7 19:23
 */
@ThreadSafe
public class ResourceFactory {
    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    public static Resource getResource() {
        return ResourceFactory.ResourceHolder.resource;
    }

    static class Resource {
    }
}
