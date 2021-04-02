package com.example.tanyu.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/5 16:55
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String namePrefix) {
        this.namePrefix = "线程工厂" + namePrefix +"worker";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}

class Task implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
