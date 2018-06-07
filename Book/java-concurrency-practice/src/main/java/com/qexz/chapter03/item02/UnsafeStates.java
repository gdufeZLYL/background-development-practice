package com.qexz.chapter03.item02;

/**
 * 程序清单3-6 使内部的可变状态逸出(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/5/27 22:27
 */
public class UnsafeStates {
    private String[] states = new String[] {
            "AK", "AL"
    };

    public String[] getStates() {
        return states;
    }
}
