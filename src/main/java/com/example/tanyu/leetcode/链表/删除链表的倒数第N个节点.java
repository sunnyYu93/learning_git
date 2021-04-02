package com.example.tanyu.leetcode.链表;

public class 删除链表的倒数第N个节点 {

    /**
     * 两次遍历
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        cur = dummy;
        length -= n;
        while (length > 0) {
            length--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;

    }


    /**
     * 一次遍历,快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndOne(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;

    }
}
