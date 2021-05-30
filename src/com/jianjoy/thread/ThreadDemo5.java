package com.jianjoy.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Author: zhoujian
 * Description:使用LockSupport
 * Date: 2021/5/30 22:13
 */
public class ThreadDemo5 {
    /**
     * 计算结果
     */
    private static volatile int result;

    private static class CalcTaskRunnable implements Runnable {
        public CalcTaskRunnable(Thread t) {
            this.parentThread = t;
        }

        private Thread parentThread;

        @Override
        public void run() {
            result = FiboUtils.sum(20);
            LockSupport.unpark(parentThread);
        }
    }

    public static void main(String[] args) {
        Tracer tracer = new Tracer();
        tracer.start();
        new Thread(new CalcTaskRunnable(Thread.currentThread())).start();
        LockSupport.park();
        tracer.end();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + tracer.cost() + " ms");
    }
}