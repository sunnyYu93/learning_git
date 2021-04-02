package com.example.tanyu.algorithm.排序算法;

/**
 * 插入排序
 * 解决冒泡排序多次交换的问题
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定
 */
public class 插入排序 {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            // j 指向有序区的最后一个元素
            int j = i - 1;
            while (j >= 0 && arr[j] > cur) {
                // 将大于cur的元素往前移动一位
                arr[j + 1] = arr[j];
                j--;
            }
            // 此处j的定义由上面while循环决定
            // 当不满足j >= 0时，此时j=-1;
            // 当不满足arr[j] > cur，此时j处于小于cur区域的最大一个元素处;
            arr[j + 1] = cur;
        }
    }
}
