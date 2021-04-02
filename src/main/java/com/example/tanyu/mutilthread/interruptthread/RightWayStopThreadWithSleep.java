package com.example.tanyu.mutilthread.interruptthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/7 10:33
 */
public class RightWayStopThreadWithSleep implements Runnable {
    //线程等待期间被中断
    @Override
    public void run() {
        int num = 0;

        try {
            while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是10000的倍数");
                }
                num++;

            }
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithSleep());
        thread.start();
        // 前提：主线程与thread线程由于是多处理器，所以是并行执行的。
        // 此处是在thread线程睡眠1秒的情况下，主线程几乎同时睡眠0.5在调用interrupt方法。
        // 此时thread线程处于睡眠状态，接受到中断信号，于是抛出异常
        Thread.sleep(500);
        thread.interrupt();
    }
}
