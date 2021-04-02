package com.example.tanyu.leetcode.链表;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/1 20:12
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;

        }

        return cur;

    }
}
