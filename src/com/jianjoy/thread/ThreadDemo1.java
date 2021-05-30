package com.jianjoy.thread;

/**
 * Author: zhoujian
 * Description:使用对象锁
 * Date: 2021/5/30 20:36
 */
public class ThreadDemo1 {


    /**
     * 计算结果
     */
    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {
        Tracer tracer = new Tracer();
        tracer.start();
        //对象锁
        final Object lock = new Object();
        //异步计算
        new Thread(() -> {
            result = FiboUtils.sum(20);
            synchronized (lock) {
                lock.notify();
            }
        }).start();
        synchronized (lock) {
            lock.wait();
        }
        tracer.end();
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + tracer.cost() + " ms");
    }


}