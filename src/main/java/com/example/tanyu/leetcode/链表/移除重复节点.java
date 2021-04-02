package com.example.tanyu.leetcode.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/1 20:45
 */
public class 移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        Set<Integer> s = new HashSet<>();
        while (current != null) {
            if (!s.contains(current.val)) {
                s.add(current.val);
                prev = current;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return head;


    }
}
