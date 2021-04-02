package com.example.tanyu.mutilthread.interruptthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/7 10:29
 */
public class RightWayStopThreadWithoutSleep implements Runnable {


    @Override
    public void run() {
        int num = 0;
        while (num <= Integer.MAX_VALUE / 2 && !Thread.currentThread().isInterrupted()) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RightWayStopThreadWithoutSleep stopThreadWithoutSleep = new RightWayStopThreadWithoutSleep();
        Thread thread = new Thread(stopThreadWithoutSleep);
        thread.start();
        Thread.sleep(500);
        //此处对线程中断有时是不会成功的，这是因为线程中断是由它自己决定的，
        //只有它自己想中断时才中断
        thread.interrupt();
    }
}
