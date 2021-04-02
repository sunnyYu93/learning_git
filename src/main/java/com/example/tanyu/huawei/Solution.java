package com.example.tanyu.huawei;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/1 10:48
 */


class ListNode {
    int val;
    ListNode next;

}
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur=head;
        while (cur!=null) {

            cur=cur.next;
            if(cur.val == val) {
                cur.next = cur.next.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        int e=0;
        int b=6;

        System.out.println(1%1);
    }
}
