package com.jianjoy.thread;

/**
 * Author: zhoujian
 * Description:使用对象锁
 * Date: 2021/5/30 20:36
 */
public class ThreadDemo0 {


    /**
     * 计算结果
     */
    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {
        Tracer tracer = new Tracer();
        tracer.start();
        //异步计算
        Thread thread = new Thread(() -> {
            result = FiboUtils.sum(20);
        });
        thread.start();
        //等待子线程计算任务结束
        thread.join();
        tracer.end();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + tracer.cost() + " ms");
    }


}