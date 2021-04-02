package com.example.tanyu.threadpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/5 17:05
 */
public class UserThreadPool {
    public static void main(String[] args) {

        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(2);

        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(1,2,60,
                TimeUnit.SECONDS,queue,f1,handler);
        ThreadPoolExecutor threadPool2 = new ThreadPoolExecutor(1,2,60,
                TimeUnit.SECONDS,queue,f2,handler);

        Task task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPool1.execute(task);
            threadPool2.execute(task);
        }

    }
}
