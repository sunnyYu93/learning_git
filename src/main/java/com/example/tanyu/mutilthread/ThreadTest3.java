package com.example.tanyu.mutilthread;

import java.util.concurrent.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/3 20:19
 */
public class ThreadTest3 implements Callable<Integer> {

    private int number;

    public ThreadTest3(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 创建执行服务
        // 可以执行Runnable对象或者Callable对象代表的线程
        Future<Integer> future = pool.submit(new ThreadTest3(100));
        Future<Integer> future2 = pool.submit(new ThreadTest3(200));

        //获取结果
        Integer i1 = future.get();
        Integer i2 = future2.get();

        System.out.println(i1 + "," + i2);

        //关闭服务
        pool.shutdown();


    }
}
