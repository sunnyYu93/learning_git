package com.example.tanyu.algorithm;

import java.util.Arrays;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

//    /**
//     * 数组插入元素,不涉及扩容
//     */
//    public void insert(int ele, int index) {
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException("超出数组实际元素范围");
//        }
//
//        //移位操作
//        for (int i = size-1; i >= index ; i--) {
//            array[i+1] = array[i];
//        }
//        array[index] = ele;
//        size++;
//    }

    /**
     * 数组插入元素,扩容
     */
    public void insert(int ele, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }

        if (size >= array.length) {
            resize();
        }
        //移位操作
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = ele;
        size++;
    }

    /**
     * 遍历数组元素
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出当前数组范围");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(5);
        myArray.insert(1, 0);
        myArray.insert(3, 1);
        myArray.insert(4, 2);
        myArray.insert(5, 3);
        myArray.insert(6, 4);
        myArray.insert(17, 5);
        myArray.output();
        System.out.println("--------------------");
        myArray.remove(4);
        myArray.output();
    }


}
