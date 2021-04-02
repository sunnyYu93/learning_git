package com.example.tanyu.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 18:56
 */
public class SigleThreadPool {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 15; i++) {
            singleThreadExecutor.execute(new Task());
        }
    }
}
