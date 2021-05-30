package com.jianjoy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: zhoujian
 * Description:使用重入锁
 * Date: 2021/5/30 20:36
 */
public class ThreadDemo3 {


    /**
     * 计算结果
     */
    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {
        Tracer tracer = new Tracer();
        tracer.start();
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        //异步计算
        new Thread(() -> {
            try {
                lock.lock();
                result = FiboUtils.sum(20);
                condition.signal();
            } finally {
                lock.unlock();
            }
        }).start();
        //等待计算结果
        try {
            lock.lock();
            condition.await();
        } finally {
            lock.unlock();
        }
        tracer.end();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + tracer.cost() + " ms");
    }


}