package com.example.tanyu.algorithm.bubblesort;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/21 11:27
 */
public class ViolenceSort {
    /**
     * 暴力法实现冒泡排序 Time：O(n^2); Space:O(1)
     *
     * @param array
     */
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }
        }

    }

    /**
     * 优化暴力法造成的不必要排序，因为它在已经排序的情况下还会执行剩余的循环
     *
     * @param array
     */
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;

                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 针对数组中有一部分数据已经是排序的情况
     *
     * @param array
     */
    public static void sort3(int[] array) {
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j]>array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }

            sortBorder = lastExchangeIndex;
            if(isSorted) {
                break;
            }
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort3(array);
        System.out.println(Arrays.toString(array));
        ;
    }
}
