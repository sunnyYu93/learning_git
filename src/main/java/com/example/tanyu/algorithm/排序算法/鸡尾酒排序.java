package com.example.tanyu.algorithm.排序算法;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/26 20:25
 * <p>
 * 应用场景：针对数组大部分数据已经是有序的情况
 * 特色：从左到右、从右到左交替进行
 */
public class 鸡尾酒排序 {
    public static void sort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            boolean isSorted = true;
            // 奇数轮，从左到右比较交换
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            // 偶数轮之前，将isSorted重新标记位true
            isSorted = true;
            // 偶数轮，从右到左进行比较交换
            for (int j = arr.length-i-1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }
}
