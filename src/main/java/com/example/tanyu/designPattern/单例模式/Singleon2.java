package com.example.tanyu.designPattern.单例模式;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 19:32
 * 饿汉式（静态代码块）
 * */
public class Singleon2 {
    private final static Singleon2 INSTANCE;
    static {
        INSTANCE = new Singleon2();
    }

    private Singleon2() {
    }

    public static Singleon2 getInstance() {
        return INSTANCE;
    }
}
