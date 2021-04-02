package com.example.tanyu.algorithm.排序算法;


/**
 * 希尔排序
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * 不稳定
 */
public class 希尔排序 {
    public void sortByShell(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int gap = arr.length >> 1; gap > 0; gap >>= 1) {
            for (int i = gap; i < arr.length; i++) {
                int cur = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > gap) {
                    arr[j+gap] = arr[j];
                }

                arr[j+gap] = cur;
            }
        }
    }
}
