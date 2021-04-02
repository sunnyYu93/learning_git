package com.example.tanyu.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 18:41
 * 创建线程数最大为指定的nThread，利用LinkedBlockingQueue缓存任务
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 111; i++) {
            fixedThreadPool.execute(new Task());
        }
    }
}
