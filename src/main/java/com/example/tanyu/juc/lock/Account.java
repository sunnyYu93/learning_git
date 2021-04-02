package com.example.tanyu.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private final Lock lock = new ReentrantLock();

    void transfer(Account tar, int amt) throws InterruptedException {
        while (true) {
            if (this.lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    if (tar.lock.tryLock(80, TimeUnit.MILLISECONDS)) {
                        try {
                            this.balance -= amt;
                            tar.balance += amt;
                        } finally {
                            tar.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       
        Account account = new Account();
        account.balance = 200;
        Account account2 = new Account();
        account2.balance = 100;
        account.transfer(account, 50);
        System.out.println(account.balance);
        System.out.println(account2.balance);
    }
}
