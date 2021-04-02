package com.example.tanyu.mutilthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟多用户买票
 * @author tanyu
 * @version 1.0
 * @date 2020/6/5 9:38
 */
public class BuyTicket implements Runnable{
    private int ticketNum = 10;
    //定义锁
    ReentrantLock lock = new ReentrantLock();
    @Override
    public  void run() {
        while (true) {
            try {
                //加锁
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                if (ticketNum<=0) {
                    return;
                }

                System.out.println(Thread.currentThread().getName()+"拿到了第"+ ticketNum--+"票");
            } finally {
                //解锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"小李").start();
        new Thread(buyTicket,"黄牛").start();
    }
}


