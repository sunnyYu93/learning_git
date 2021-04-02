package com.example.tanyu.mutilthread.interruptthread;

import java.util.concurrent.Executors;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/7 16:50
 *  传递中断
 */
public class RightWayStopThreadProd implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 方法签名中抛出异常，传递给别的方法处理，不能吞掉异常
    public void throwInMethod() throws InterruptedException {
            Thread.sleep(2000);

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadProd());
        thread.start();
        // 这里之前不了解为啥是五秒后产生中断，一直觉得主线程睡眠5秒与thread中断有什么关系
        // 然后明白了：是因为让主线程睡眠5秒后再调用interrupt方法。main方法是由主线程调用的
        Thread.sleep(1000);
        thread.interrupt();

    }
}
