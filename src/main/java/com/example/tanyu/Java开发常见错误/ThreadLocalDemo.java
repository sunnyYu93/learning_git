package com.example.tanyu.Java开发常见错误;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {


    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);


    public static Map wrong(Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);

        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        String after = Thread.currentThread().getName() + ":" + currentUser.get();
        //汇总输出两次查询结果
        Map result = new HashMap<>();
        result.put("before", before);
        result.put("after", after);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(wrong(45));

        ExecutorService executorService = Executors.newCachedThreadPool();
        //输出结果显示此之前用户的信息，这是因为线程池重用了之前线程，这个线程里面的一些信息没有清楚。
        //显示清除就没事
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(wrong(23));
                }
            });
        }

    }

}
