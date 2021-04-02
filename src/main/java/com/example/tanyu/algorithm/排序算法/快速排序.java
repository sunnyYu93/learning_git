package com.example.tanyu.algorithm.排序算法;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/26 20:43
 * <p>
 * 时间复杂度：O(nlogn)
 */
public class 快速排序 {

    /**
     * 快排3步骤：选基、分割、递归
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex >= endIndex时
        if (startIndex >= endIndex) {
            return;
        }

        // 计算基准元素的位置
        int pivotIndex = partitionDoubleSide(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 分治法（双边循环法）
     *
     * @param arr
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    public static int partitionDoubleSide(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置（也可随机选择）的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        // 控制right指针比较并左移
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }

            // 控制right指针比较并左移
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // pivot与指针重合点数据交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     * 分治法（单边循环法）
     * @param arr
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     * @return
     */
    public static int partitionOneSide(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置（也可随机选择）的元素当作基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex-1; i <= endIndex; i++) {
            if (arr[i]<pivot) {
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,2,8,1};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
