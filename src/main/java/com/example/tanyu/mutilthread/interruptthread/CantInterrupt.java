package com.example.tanyu.mutilthread.interruptthread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/7 16:35
 *  在while中进行try/catch
 *  中断一次后继续运行，这是因为sleep()一旦响应中断一次后会把interrupt标记位清楚
 *  所以!Thread.currentThread().isInterrupted()检查不到中断
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            while (num <= 30000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        // 这里之前不了解为啥是五秒后产生中断，一直觉得主线程睡眠5秒与thread中断有什么关系
        // 然后明白了：是因为让主线程睡眠5秒后再调用interrupt方法。main方法是由主线程调用的
        Thread.sleep(5000);
        thread.interrupt();
    }
}
