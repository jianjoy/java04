package com.jianjoy.thread;

/**
 * Author: zhoujian
 * Description: 计时器
 * Date: 2021/5/30 20:54
 */
public class Tracer {
    private long startTime;
    private long endTime;

    /**
     * 开始计时
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * 结束计时
     */
    public void end() {
        endTime = System.currentTimeMillis();
    }

    /**
     * 计算本次消耗时间(毫秒)
     *
     * @return
     */
    public long cost() {
        return (endTime - startTime);
    }
}