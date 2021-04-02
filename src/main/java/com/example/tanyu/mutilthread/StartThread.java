package com.example.tanyu.mutilthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/7 8:56
 */
public class StartThread {
    public static void main(String[] args) {
        Runnable runnable = ()-> {
            System.out.println(Thread.currentThread().getName());
        };

        //是由主线程执行
        runnable.run();

        Thread thread = new Thread(runnable);
        //是由新建线程执行
        thread.start();
    }
}