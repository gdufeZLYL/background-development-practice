package com.qexz.chapter15.item03;

/**
 * @author zzqnxx@foxmail.com
 * @date 2018/6/6 21:50
 */
public class PseudoRandom {
    int calculateNext(int prev) {
        prev ^= prev << 6;
        prev ^= prev >>> 21;
        prev ^= (prev << 7);
        return prev;
    }
}
