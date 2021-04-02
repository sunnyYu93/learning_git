package com.example.tanyu.mutilthread.interruptthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/7 17:05
 * 在catch语句中调用Thread.currentThread().interrupt()来恢复设置中断状态，
 */
public class RightWayStopThreadProd2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("中断，程序退出");
                break;
            }
            System.out.println("go");
            reInterrupt();

        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadProd2());
        thread.start();
        // 这里之前不了解为啥是五秒后产生中断，一直觉得主线程睡眠5秒与thread中断有什么关系
        // 然后明白了：是因为让主线程睡眠5秒后再调用interrupt方法。main方法是由主线程调用的
        Thread.sleep(1000);
        thread.interrupt();
    }
}
