package com.example.tanyu.designPattern.单例模式;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 19:48
 * 懒汉式（线程安全，同步方法）可用，但是因为同步的原因，效率低下
 */
public class Singleon4 {

    private static Singleon4 instance;

    private Singleon4() {
    }

    public static synchronized Singleon4 getInstance() {
        if (instance == null) {
            instance = new Singleon4();
        }
        return instance;
    }
}
