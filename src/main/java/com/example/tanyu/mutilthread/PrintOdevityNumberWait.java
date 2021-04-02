package com.example.tanyu.mutilthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/10 19:32
 */
public class PrintOdevityNumberWait {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Print(), "偶数").start();
        new Thread(new Print(), "奇数").start();
    }

    static class Print implements Runnable {
        @Override
        public void run() {
            while (count<=100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName()+count++);
                    lock.notify();
                    if (count<=100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}


