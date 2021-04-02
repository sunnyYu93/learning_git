package com.example.tanyu.algorithm.排序算法;

/**
 * 将数组分为：排序区、未排序区
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 不稳定排序
 */
public class 选择排序 {
    /**
     * 选择未排序部分最小的比较，得到升序排列
     * @param arr
     */
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        if(i==j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
