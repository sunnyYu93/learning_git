package com.example.tanyu.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/10 16:20
 */
public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        condition.await();
        condition.signal();
    }
}
