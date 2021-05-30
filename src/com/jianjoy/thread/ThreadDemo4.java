package com.jianjoy.thread;

import java.util.concurrent.*;

/**
 * Author: zhoujian
 * Description:使用线程池提交异步任务，获取任务返回值
 * Date: 2021/5/30 20:36
 */
public class ThreadDemo4 {

    /**
     * 计算任务
     */
    private static class CalcTaskCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return Integer.valueOf(FiboUtils.sum(20));
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tracer tracer = new Tracer();
        tracer.start();
        //使用线程池执行任务，获取结果
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new CalcTaskCallable());
        int result = future.get();
        tracer.end();
        executorService.shutdown();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + tracer.cost() + " ms");
    }


}