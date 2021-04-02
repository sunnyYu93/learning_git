package com.example.tanyu.mutilthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/14 10:09
 */
public class DeadLock {
    A a = new A();
    B b = new B();

    class A implements Runnable {
        public synchronized void foo(B b) {
            System.out.println("In A try call B");
            b.bar(this);
            System.out.println("A end!");
        }

        @Override
        public void run() {
            foo(b);
        }

    }
    class B implements Runnable {
        public synchronized void bar(A a) {
            System.out.println("In B try cal A");
            a.foo(this);
            System.out.println("B end!");
        }

        @Override
        public void run() {
            b.bar(a);
        }

    }

    public void init() {
        Thread ta = new Thread(a);
        Thread tb = new Thread(b);

        ta.start();
        tb.start();
    }

    public static void main(String[] args) {
        String s = "a";
        char[] charArray = s.toCharArray();

        Thread.currentThread().interrupt();

        new DeadLock().init();
    }

}
