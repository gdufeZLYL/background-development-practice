package com.qexz.chapter10.item01;

/**
 * 程序清单10-1 简单的锁顺序死锁(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/6/2 21:51
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    void doSomething() {
    }

    void doSomethingElse() {
    }
}