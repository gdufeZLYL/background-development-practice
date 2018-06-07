package com.qexz.chapter04.item03;

import net.jcip.annotations.Immutable;

/**
 * 程序清单4-6 在DelegatingVehicleTracker中使用的不可变Point类
 * @author zzqnxx@foxmail.com
 * @date 2018/5/29 16:17
 */
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
