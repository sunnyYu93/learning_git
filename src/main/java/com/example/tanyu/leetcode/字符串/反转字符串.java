package com.example.tanyu.leetcode.字符串;

import com.example.tanyu.leetcode.树.Node;

import java.util.Arrays;

public class 反转字符串 {
//    public String reverseString(String s) {
//
//    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node mergeTwoLists(Node n1, Node n2) {
        Node preHead = new Node(-1);
        Node pre = preHead;
        while (n1 != null && n2 != null) {
            if (n1.data <= n2.data) {
                pre.next = n1;
                n1 = n1.next;
            } else {
                pre.next = n2;
                n2 = n2.next;
            }

            pre = pre.next;
        }

        if (n1 != null) {
            pre.next = n1;
        }

        if (n2 != null) {
            pre.next = n2;
        }

        return preHead.next;
    }


    public static void main(String[] args) {
        String s = "(sfd(dhfhdjf)ghg)";
        String[] split = s.split("()");
        System.out.println(Arrays.toString(split));
    }
}
