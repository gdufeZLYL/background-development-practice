package com.qexz.chapter03.item04;

import net.jcip.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 程序清单3-12 对数值及其因数分解结果进行缓存的不可变容器类
 * @author zzqnxx@foxmail.com
 * @date 2018/5/28 15:07
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,
                         BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}
