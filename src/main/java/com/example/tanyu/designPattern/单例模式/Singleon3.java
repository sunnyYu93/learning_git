package com.example.tanyu.designPattern.单例模式;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 19:40
 * 懒汉式（线程不安全）
 */
public class Singleon3 {
    private static Singleon3 INSTANCE;

    private Singleon3() {
    }

    public static Singleon3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleon3();
        }

        return INSTANCE;
    }
}
