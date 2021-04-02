package com.example.tanyu.mutilthread;

import jdk.nashorn.internal.ir.Block;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/10 19:06
 */
public class PrintOdevityNumberSyn {
    static final Object lock = new Object();
    private static int num;

    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (num < 100) {
                    synchronized (lock) {

                            if ((num & 1) == 0) {
                                System.out.println(Thread.currentThread().getName() + num);
                                num++;
                            }


                    }
                }
            }
        }, "偶数").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (num < 100) {
                    synchronized (lock) {
                            if ((num & 1) == 1) {
                                System.out.println(Thread.currentThread().getName() + num);
                                num++;
                            }


                    }
                }
            }
        }, "奇数").start();

    }


    }


