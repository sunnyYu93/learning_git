package com.example.tanyu.juc.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 18:46
 */
public class ScheduleThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            scheduledThreadPool.execute(new Task());
        }
    }
}
