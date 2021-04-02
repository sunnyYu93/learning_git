package com.example.tanyu.algorithm;


import java.util.Stack;

public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;

    /**
     * 不同位置插入元素
     *
     * @param data
     * @param index
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node newNode = new Node(data);
        // 链表是空的
        if (size == 0) {
            head = newNode;
            last = newNode;

            //在头部位置插入
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;

            //尾部位置插入
        } else if (index == size) {
            last.next = newNode;
            last = newNode;

            //中间位置插入
        } else {
            Node preNode = get(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;

        }
    }

    /**
     * 遍历链表
     *
     * @param index 位置
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }



    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(1, 0);
        myLinkedList.insert(1, 1);
        myLinkedList.insert(1, 2);
        myLinkedList.insert(1, 3);


    }

}
