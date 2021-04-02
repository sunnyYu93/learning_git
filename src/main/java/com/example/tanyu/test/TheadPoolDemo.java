package com.example.tanyu.test;

/**
 * 生产者、消费者模型
 * 假如一个仓库只能放十个商品，例如仓库满了的话：repository=10，此时生产者停止生产
 * 如果仓库 repository=0，那么消费者要停止消费
 */
public class TheadPoolDemo {
    private static final Object LOCK = new Object();
    static int repository = 0;

    /**
     * 判断仓库是否为空，
     *
     * @return
     */
    private static boolean isEmpty() {
        if (repository == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断仓库是否满了
     *
     * @return
     */
    private static boolean isFull() {
        if (repository == 10) {
            return true;
        }
        return false;
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    //需要一个判断仓库是否满了的方法
                    if (isFull()) {
                        try {
                            Thread.sleep(500);
                            System.out.println("仓库容量" + repository);
                            //再让自己阻塞之前需要调用这个方法通知消费者过来消费
                            LOCK.notify();
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "生产者" +
                                "仓库容量" + repository);
                        LOCK.notify();
                        repository++;
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (isEmpty()) {
                        try {
                            Thread.sleep(500);
                            System.out.println("仓库容量" + repository);
                            LOCK.notify();
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "生产者" +
                                "仓库容量" + repository);
                        LOCK.notify();
                        repository--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer(), "生产者1").start();
        new Thread(new Consumer(), "消费者1").start();
        new Thread(new Producer(), "生产者2").start();
        new Thread(new Consumer(), "消费者2").start();
        new Thread(new Producer(), "生产者3").start();
        new Thread(new Consumer(), "消费者3").start();
        new Thread(new Producer(), "生产者4").start();
        new Thread(new Consumer(), "消费者4").start();
    }

}
