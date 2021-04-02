package com.example.tanyu.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/12 10:54
 */
public class 有效的括号 {
    HashMap<Character, Character> map = new HashMap<>();
    {
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        map.put(' ',' ');
    }
    public boolean isValid(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(')');
            } else if (s.charAt(i) == '['){
                stack.addLast(']');
            } else if (s.charAt(i) == '{') {
                stack.addLast('}');
            } else if (stack.isEmpty() || s.charAt(i) != stack.removeLast()) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
class Solution {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}

