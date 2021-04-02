package com.example.tanyu.leetcode.stack;

import java.util.Stack;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/14 8:48
 */
class MinStack {
    Stack<Integer> a;
    Stack<Integer> b;
    /** initialize your data structure here. */
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();

    }

    public void push(int x) {
        if(b.empty() || b.peek() >= x) {
            b.push(x);
        }
        a.push(x);
    }

    public void pop() {
        if(a.pop().equals(b.peek())) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
