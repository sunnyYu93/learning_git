package com.example.tanyu.algorithm.easy.stack;

import java.util.Stack;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/2 21:31
 */

class StackNode {
    int data;
    StackNode next;

    StackNode(int ele) {
        this.data = ele;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

public class MyStackByLinked {

    StackNode top;

    private void push(int ele) {
        StackNode stackNode = new StackNode(ele);
        stackNode.next = top;
        top = stackNode;
    }

    private int pop() {
        int res = top.data;
        top = top.next;
        return res;
    }

    @Override
    public String toString() {
        return "MyStackByLinked{" +
                "top=" + top +
                '}';
    }

    public static void main(String[] args) {
        MyStackByLinked myStackByLinked = new MyStackByLinked();
        myStackByLinked.push(1);
        myStackByLinked.push(2);
        myStackByLinked.push(3);
        myStackByLinked.push(4);

        myStackByLinked.pop();
        System.out.println(myStackByLinked.toString());

    }

}
