package com.example.tanyu.designPattern.单例模式;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 19:54
 *
 * 双重检查--推荐面试的时候写
 *
 * 创建对象实例时，JVM做了3件事
 * 1、给instance分配内存
 * 2、调用Singleton构造函数来初始化成员变量
 * 3、将instance对象指向分配的内存空间（执行完这步instance就为非null了）
 *
 * 但是JVM在做这3件事的时候不一定是按这个顺序进行，有可能1-2-3，也有可能是1-3-2.
 * 这样就会造成对象的成员变量还未初始化就将这个实例返回给其他方法使用，
 * 当调用实例中的成员变量的时候就会发生NPE异常
 * volatile可以禁止重排序 
 */
public class Singleton6 {

    private volatile static Singleton6 instance;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
