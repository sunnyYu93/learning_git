package com.example.tanyu.test;

/**
 * 继承Thread方式
 */
class MyThread extends Thread {
    int a;

    MyThread(int a) {
        this.a = a;
    }

    public void run() {
        System.out.println("这是一个继承Thread方式的run方法");
    }
}

/**
 * 实现runnable方式
 */
class ByRunnable implements Runnable {
    int b;

    ByRunnable(int b) {
        this.b = b;

    }

    public void run() {

//        System.out.println("这是一个实现runnable方式的run方法");
        System.out.println(Thread.currentThread().getName() + "is running");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

//        MyThread myThread = new MyThread(5);
//        myThread.start();

//        ByRunnable byRunnable = new ByRunnable(9);
//        new Thread(byRunnable).start();
        System.out.println("main线程是守护线程吗" + Thread.currentThread().isDaemon());
        // 创建一个ByRunnable对象daemonThead
        ByRunnable daemonThead = new ByRunnable(2);
        // 创建线程tthread，共享daemonThead资源
        Thread thread = new Thread(daemonThead, "后台线程");
        System.out.println("thread是后台线程吗？" + thread.isDaemon());
        // 将线程thread，设置为后台线程
        thread.setDaemon(true);
        System.out.println("设置以后，thread是后台线程吗？" + thread.isDaemon());
        // 调用start()方法，开启线程thread

        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }


}
