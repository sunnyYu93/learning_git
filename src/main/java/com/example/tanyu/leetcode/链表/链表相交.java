package com.example.tanyu.leetcode.链表;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/1 20:31
 */
public class 链表相交 {
    /**
     * 相同路径
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA;
        ListNode listB = headB;
        while (listA != listB) {
            listA = listA == null ? headB : listA.next;
            listB = listB == null ? headA : listB.next;
        }
        return listA;
    }
}
