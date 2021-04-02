package com.example.tanyu.designPattern.单例模式;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 19:27
 * 饿汉式（静态常量）
 */
public class Singleon1 {

    private static final Singleon1 INSTANCE = new Singleon1();

    private Singleon1() {
    }

    public static Singleon1 getInstance() {
        return INSTANCE;
    }
}
