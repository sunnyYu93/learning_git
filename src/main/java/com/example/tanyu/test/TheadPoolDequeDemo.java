package com.example.tanyu.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TheadPoolDequeDemo {
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition producerCondition = LOCK.newCondition();
    private static final Condition consumerCondition = LOCK.newCondition();

    static int repository = 0;

    /**
     * 判断仓库是否为空，
     *
     * @return
     */
    private static boolean isEmpty() {
        if (repository == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断仓库是否满了
     *
     * @return
     */
    private static boolean isFull() {
        if (repository == 10) {
            return true;
        }
        return false;
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                LOCK.lock();
                //需要一个判断仓库是否满了的方法
                if (isFull()) {

                    try {

                        System.out.println(Thread.currentThread().getName() + "仓库容量" + repository);
                        //再让自己阻塞之前需要调用这个方法通知消费者过来消费
                        consumerCondition.signal();
                        producerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "生产者" +
                            "仓库容量" + repository);
                    repository++;
                }
                LOCK.unlock();
            }
        }

    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                LOCK.lock();

                if (isEmpty()) {
                    try {
                        System.out.println("消费者仓库容量" + repository);
                        producerCondition.signal();
                        consumerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "生产者" +
                            "仓库容量" + repository);
                    repository--;
                }
                LOCK.unlock();
            }

        }


        public static void main(String[] args) {
            new Thread(new Producer(), "生产者1").start();
            new Thread(new Consumer(), "消费者1").start();
            new Thread(new Producer(), "生产者2").start();
            new Thread(new Consumer(), "消费者2").start();
            new Thread(new Producer(), "生产者3").start();
            new Thread(new Consumer(), "消费者3").start();
            new Thread(new Producer(), "生产者4").start();
            new Thread(new Consumer(), "消费者4").start();
        }
    }
}
