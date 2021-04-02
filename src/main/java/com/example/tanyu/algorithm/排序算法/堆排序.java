package com.example.tanyu.algorithm.排序算法;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/8 20:32
 */
public class 堆排序 {
    /**
     * 下沉
     *
     * @param arr
     * @param parentIndex 要下沉的父节点
     * @param length      堆得有效大小
     */
    public void downAdjust(int[] arr, int parentIndex, int length) {
        // 保存父节点的值，用于最后的赋值
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子大于左孩子，则定位到右孩子
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }

            // 如果父节点大于任何一个孩子节点，则直接跳出
            if (temp >= arr[parentIndex]) {
                break;
            }

            //无须真正交换，单向赋值即可
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = temp;

    }

    public void heapSort(int[] arr) {
        // 1、将无须数组构建成最大堆
        // 从最后一个非叶子节点开始，依次做“下沉”操作
        // (arr.length-2)/2 为计算出根节点个数
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        // 2、循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = arr.length - 1; i > 0; i--) {
            // 最后一个元素与第一个元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // 下沉调整最大堆
            downAdjust(arr, 0, i);
        }
    }

    /**
     * 上浮
     *
     * @param arr
     * @param childIndex 待上浮的孩子节点
     */
    public void upAdjust(int[] arr, int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        // temp保存插入的叶子节点，用于最后的赋值
        int temp = arr[childIndex];
        while (childIndex > 0 && temp > arr[parentIndex]) {
            // 无须真正交换，单向赋值即可
            //父节点值下沉到子节点
            arr[childIndex] = arr[parentIndex];
            //子节点上浮到父节点位置
            childIndex = parentIndex;
            // 父节点下沉到子节点
            parentIndex = (parentIndex - 1) / 2;

        }
        arr[childIndex] = temp;
    }
}
