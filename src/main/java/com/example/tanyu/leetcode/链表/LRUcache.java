package com.example.tanyu.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/24 15:10
 */
public class LRUcache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        ;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache = new HashMap<>();
    Node head;
    Node tail;
    int size;
    int capacity;

    public LRUcache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 移动到链表头部
     */
    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除节点
     */
    public void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

//        node.pre.next = node.next;
//        node.next.pre = node.pre;
    }

    /**
     * 添加节点到头部
     */
    public void addToHead(Node node) {
        Node temp = head.next;
        head.next = node;
        temp.pre = node;
        node.pre = head;
        node.next = temp;

//        node.pre = head;
//        node.next = head.next;
//        head.next.pre = node;
//        head.next = node;
    }

    /**
     * 删除尾部节点
     */
    public Node removeTail() {
        Node pre = tail.pre;
        pre.pre.next = tail;
        tail.pre = pre.pre;
        return pre;
    }

    /**
     * 获取节点
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            //节点存在，移动到头部
            moveToHead(node);
            return node.value;
        }
    }

    /**
     * 放入节点
     */
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            //节点不存在，新增节点
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 超过容量，删除掉最少访问的节点，即队尾元素
                Node tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 节点存在，移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUcache cache = new LRUcache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}
