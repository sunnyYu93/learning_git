package com.example.tanyu.leetcode.字符串;

import java.util.Stack;

public class 反转每队括号中的字符串 {
    public  String reverseParentheses(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(i);
            }

            if (array[i]  == ')') {
                reverse(array, stack.pop()+1, i-1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != ')' && array[i] != '(') {
                stringBuilder.append(array[i]);
            }
        }

        return stringBuilder.toString();
    }

    public  void reverse(char[] arr, int left, int right) {
        while (right > left) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


}
