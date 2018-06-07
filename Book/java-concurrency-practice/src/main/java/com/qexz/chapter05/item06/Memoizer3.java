package com.qexz.chapter05.item06;

import com.qexz.chapter05.item05.LaunderThrowable;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 程序清单5-18 基于FutureTask的Memoizing封装器
 * @author zzqnxx@foxmail.com
 * @date 2018/5/30 18:00
 */
public class Memoizer3 <A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache
            = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                public V call() throws InterruptedException {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run(); // call to c.compute happens here
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw LaunderThrowable.launderThrowable(e.getCause());
        }
    }
}