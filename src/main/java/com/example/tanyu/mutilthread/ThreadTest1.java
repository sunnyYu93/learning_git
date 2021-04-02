package com.example.tanyu.mutilthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/3 19:46
 */
public class ThreadTest1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 23; i++) {
            System.out.println("新线程的run方法");
        }

    }

    public static void main(String[] args) {
        ThreadTest1 threadTest1 = new ThreadTest1();
        threadTest1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("循环体" + i);
        }
    }
}
