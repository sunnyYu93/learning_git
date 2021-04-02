package com.example.tanyu.test;


public class SafeCalc {
    long value = 0L;
    long get() {
        synchronized (new Object()) {
            return value;
        }
    }
    void addOne() {
        synchronized (new Object()) {
            value += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SafeCalc safeCalc = new SafeCalc();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    safeCalc.addOne();
                    System.out.println(safeCalc.get());
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {

                }

            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
