package com.example.tanyu.mutilthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/3 19:54
 */
public class ThreadTest2 implements Runnable{
    @Override
    public void run() {
        System.out.println("实现runnable接口");
    }

    public static void main(String[] args) {
        ThreadTest2 threadTest2 = new ThreadTest2();
        Thread thread = new Thread(threadTest2);
        thread.start();
    }
}
