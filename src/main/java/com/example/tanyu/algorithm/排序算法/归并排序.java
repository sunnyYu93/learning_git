package com.example.tanyu.algorithm.排序算法;

public class 归并排序 {

    /**
     * 合并
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     * @param temp
     */
    public void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 将切分后的子数组按照大小放入到辅助数组中
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 以下两个while循环只会存在一个
        // 当左边的数组没有遍历完时，将其添加到子数组的右边
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        // 当左边的数组没有遍历完时，将其添加到子数组的右边
        while (j <= high) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        //将排序好的辅助数组复制到原数组对应的位置中。
        //开始下标是low，长度为k
        System.arraycopy(temp, 0, arr, low, k);
    }

    /**
     * 分治解决
     * @param arr 原数组
     * @param low 开始下标
     * @param high 结束下标
     * @param temp 辅助数组
     */
    public void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid + 1, high, temp);
            merge(arr, low, mid, high,temp);
        }
    }

    /**
     * 递归方式的归并排序
     * @param arr
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(n)
     */
    public void sortRecursive(int[] arr) {
        if (arr == null || arr.length==0) {
            return;
        }
        int low = 0;
        int high = arr.length-1;
        int[] temp = new int[arr.length];
        mergeSort(arr, low, high, temp);
    }
}
