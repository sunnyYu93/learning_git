package com.example.tanyu.leetcode.链表;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/1 20:07
 */
public class 返回倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode last = head;

        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            last = last.next;
        }

        return last.val;

    }
}


