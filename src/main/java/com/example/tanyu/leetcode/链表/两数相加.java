package com.example.tanyu.leetcode.链表;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/4 21:11
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        // 进位值
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }

        return dummy.next;
    }



}
