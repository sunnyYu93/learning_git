package com.example.tanyu.leetcode.栈;

import java.util.HashMap;
import java.util.Stack;

public class 有效的括号 {


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }



            if (c == ')') {
                char d = stack.pop();
                if (map.get(c) != d) {
                    return false;
                }

            } else if (c == ']') {
                char d = stack.pop();
                if (map.get(c) != d) {
                    return false;
                }

            } else if (c == '}') {
                char d = stack.pop();
                if (map.get(c) != d) {
                    return false;
                }

            }


        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
