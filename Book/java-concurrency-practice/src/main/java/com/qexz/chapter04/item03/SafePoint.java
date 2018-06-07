package com.qexz.chapter04.item03;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 程序清单4-11 线程安全且可变的Point类
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 17:57
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this")
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.set(x, y);
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
