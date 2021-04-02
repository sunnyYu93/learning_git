package com.example.tanyu.mutilthread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/10 18:38
 */
public class ConsumerAndProducerPattern {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }



}

class Consumer implements Runnable {


    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    /**
     * 放入仓库
     */
    public synchronized void put() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "件产品");
        notify();

    }

    public synchronized void take() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("拿到了" + storage.poll() + "仓库剩余" + storage.size() + "件产品");
        notify();
    }
}


