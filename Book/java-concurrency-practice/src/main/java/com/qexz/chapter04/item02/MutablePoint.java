package com.qexz.chapter04.item02;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单4-5 与Java.awt.Point类似的可变Point类(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 15:33
 */
@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}