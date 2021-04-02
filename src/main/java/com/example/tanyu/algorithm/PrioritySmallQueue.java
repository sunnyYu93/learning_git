package com.example.tanyu.algorithm;

import java.util.Arrays;

/**
 * 最小优先队列实现
 */
public class PrioritySmallQueue {
    private int[] array;
    private int size;

    public PrioritySmallQueue() {
        // 数组初始容量为32
        array = new int[32];
    }

    /**
     * 入队
     */
    private void enQueue(int key) {
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     */
    private int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("队列为空");
        }
        int head = array[0];
        array[0] = array[--size];
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust();
        }

        return head;
    }

    /**
     * 队列扩容
     */
    private void resize() {
        int newSize = size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * 上浮调整，将小元素上浮
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp 保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    private void downAdjust() {
        int parentIndex = 0;
        int childIndex = size - 1;
        int temp = array[parentIndex];
        while (childIndex < size) {
            if (childIndex + 1 < size && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }

            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;

        }
        array[parentIndex] = temp;

    }

    public static void main(String[] args) throws Exception {
        PrioritySmallQueue priorityQueue = new PrioritySmallQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println(Arrays.toString(priorityQueue.array));
//        priorityQueue.deQueue();
//        priorityQueue.deQueue();
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
    }


}
