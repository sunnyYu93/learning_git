package com.example.tanyu.test;

public class YieldTest extends Thread {

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("" + this.getName() + "------" + i);

            if (i == 10) {
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest yt1 = new YieldTest("张三");
        YieldTest yt2 = new YieldTest("李四");
        yt1.setPriority(6);
        yt1.start();
        yt2.start();
    }


}
