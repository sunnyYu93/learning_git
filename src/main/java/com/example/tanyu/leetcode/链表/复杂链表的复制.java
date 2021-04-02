package com.example.tanyu.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/3 23:40
 */
public class 复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if(head==null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next).next;
            map.get(cur).random = map.get(cur.next).random;
            cur = cur.next;
        }

        return map.get(head);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}