package com.example.tanyu.algorithm.easy.stack;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/2 20:47
 */
public class MyStackArray {

    private int[] stack;

    private int top = -1;

    MyStackArray(int depth) {
        this.stack = new int[depth];
    }

    private void push(int ele) {
        if (stack.length == top+1) {
            throw new ArrayIndexOutOfBoundsException("此栈已满");
        }
        stack[++top] = ele;

    }

    private int pop() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("此栈已空");
        }

        int resEle = stack[top];
        top--;
        return resEle;

    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + Arrays.toString(stack) + " top:"+top+
                '}';
    }

    public static void main(String[] args) throws Exception{
        MyStackArray myStack = new MyStackArray(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.toString());
        System.out.println( myStack.pop());
        System.out.println( myStack.pop());
        System.out.println( myStack.pop());
        System.out.println( myStack.pop());
        System.out.println( myStack.pop());

        System.out.println(myStack.toString());
    }

}
