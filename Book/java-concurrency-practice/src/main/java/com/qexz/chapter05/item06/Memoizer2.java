package com.qexz.chapter05.item06;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 程序清单5-17 用ConcurrentHashMap替换HashMap
 * @author zzqnxx@foxmail.com
 * @date 2018/5/30 17:48
 */
public class Memoizer2 <A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}