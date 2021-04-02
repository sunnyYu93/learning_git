package com.example.tanyu.designPattern.单例模式;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 20:14
 * <p>
 * 静态内部类
 */
public class Singleton7 {

    private Singleton7() {
    }

    /**
     * 类的静态属性只会在第一次加载类的时候初始化，所以在这里JVM帮助我们保证了线程的安全性
     * 在类进行初始化的时候，别的线程是无法进入的
     */
    private static class SingletonInstance {
        private static final Singleton7 instance = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.instance;
    }
}
