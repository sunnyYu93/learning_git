package com.example.tanyu.leetcode.链表;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/11 21:17
 *
 * */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            // 这一步试将前面两节点与后面两节点建立关系
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
        }

        return dummy.next;
    }
}
