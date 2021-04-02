package com.example.tanyu.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 18:36
 * 创建的线程数最多为Integer.MAX_VALUE，SynchronousQueue<Runnable>不做存储任务作用
 */
public class CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            cachedThreadPool.execute(new Task());
        }


    }


}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
