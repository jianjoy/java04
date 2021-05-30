package com.jianjoy.thread;

/**
 * Author: zhoujian
 * Description:fibo计算工具
 * Date: 2021/5/30 20:45
 */
public final class FiboUtils {

    /**
     * fibo求和
     *
     * @param num
     * @return
     */
    public static int sum(int num) {
        return fibo(num);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    private FiboUtils() {

    }
}