package com.jianjoy.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Author: zhoujian
 * Description:使用信号量CountDownLatch
 * Date: 2021/5/30 20:36
 */
public class ThreadDemo2 {


    /**
     * 计算结果
     */
    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {
        Tracer tracer = new Tracer();
        tracer.start();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //异步计算
        new Thread(() -> {
            result = FiboUtils.sum(20);
            countDownLatch.countDown();
        }).start();
        //等待计算结果
        countDownLatch.await();
        tracer.end();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + tracer.cost() + " ms");
    }


}