package com.example.tanyu.leetcode.链表;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/2 20:51
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
