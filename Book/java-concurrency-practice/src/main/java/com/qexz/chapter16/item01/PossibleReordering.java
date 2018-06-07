package com.qexz.chapter16.item01;

/**
 * 程序清单16-1 如果在程序中没有包含足够的同步,那么可能产生奇怪的结果(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/6/7 16:05
 */
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });
        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });
        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("( " + x + "," + y + ")");
    }
}
