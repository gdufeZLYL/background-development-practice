package com.qexz.chapter03.item01;


/**
 * 程序清单3-1 在没有同步的情况下共享变量(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/5/27 21:06
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }

        public static void main(String[] args) {
            new ReaderThread().start();
            number = 42;
            ready= true;
        }
    }
}
