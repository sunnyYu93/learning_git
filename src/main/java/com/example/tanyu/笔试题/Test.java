package com.example.tanyu.笔试题;


import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(8);
        priorityQueue.add(1);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);

        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.toString());
        for (int i = 0; i < 7; i++) {
            System.out.println(priorityQueue.poll());
        }

//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.add(1);
//        queue.add(1);
//        queue.add(2);
//        queue.add(2);
//        for (int i = 0; i < 2; i++) {
//            queue.add(3);
//        }
//
//        System.out.println("queue的大小：" + queue.size() + " 具体元素为：" + queue.toString());
//        Stack<Long> stack = new Stack<>();
//        while (!queue.isEmpty()) {
//            System.out.println("queue:" + queue.toString());
//            long tmp = queue.poll();
//            System.out.println("temp:" + tmp);
//
//            if (queue.isEmpty()) {
//                stack.push(tmp);
//                continue;
//            }
//
//            if (tmp != queue.peek()) {
//                stack.push(tmp);
//            } else {
//                queue.add(queue.poll() * 2);
//            }
//
//            System.out.println("stack:" + stack);
//            System.out.println("---------------------------------------------------------------");
//        }
//
//        while (!stack.isEmpty()) {
//            System.out.print(stack.pop() + " ");
//        }

    }
}
