package com.qexz.chapter08.item05;

import java.util.Set;

/**
 * 程序清单8-13 表示"搬箱子"之类谜题的抽象类
 * @author zzqnxx@foxmail.com
 * @date 2018/6/1 22:42
 */
public interface Puzzle <P, M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
