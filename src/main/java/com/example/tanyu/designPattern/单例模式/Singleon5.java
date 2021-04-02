package com.example.tanyu.designPattern.单例模式;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 19:51
 * 懒汉式（线程安全，同步代码块）
 */
public class Singleon5 {

    private static Singleon5 instance;

    private Singleon5() {
    }

    public static Singleon5 getInstance() {
        // 此处由于会产生两个线程同时到达此处判断为true，后抢到锁的线程还是会new一个实例
        if (instance == null) {
            synchronized (Singleon5.class) {
                instance = new Singleon5();
            }
        }

        return instance;
    }
}
