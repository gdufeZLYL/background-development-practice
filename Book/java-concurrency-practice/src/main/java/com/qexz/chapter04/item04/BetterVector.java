package com.qexz.chapter04.item04;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

/**
 * 程序清单4-13 扩展Vector并增加一个"若没有则添加"方法
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 20:23
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent)
            add(x);
        return absent;
    }
}
