package com.example.tanyu.mutilthread.interruptthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/7 10:55
 * 在每次执行过程中，每次循环都会调用sleep或wait等方法
 * 那么不需要在每次迭代中检查是否已中断。即：!Thread.currentThread().isInterrupted()
 */
public class RightWayStopThreadWithSleepEveryLoop implements Runnable {

    @Override
    public void run() {
        int num = 0;

        try {

            while (num <= 10000) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                // sleep方法中会检测InterruptedException，故不需要自己在while条件中判断中断异常。
                Thread.sleep(10);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithSleepEveryLoop(),"新线程");
        thread.start();
        // 这里之前不了解为啥是五秒后产生中断，一直觉得主线程睡眠5秒与thread中断有什么关系
        // 然后明白了：是因为让主线程睡眠5秒后再调用interrupt方法。main方法是由主线程调用的
        Thread.sleep(5000);
        thread.interrupt();
    }
}

