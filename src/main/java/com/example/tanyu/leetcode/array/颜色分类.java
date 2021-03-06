package com.example.tanyu.leetcode.array;

import java.util.Arrays;

public class 颜色分类 {
    /**
     * 计算排序思想
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] sortedArray = new int[3];
        for (int i = 0; i < nums.length; i++) {
            sortedArray[nums[i]]++;
        }

        System.out.println(Arrays.toString(sortedArray));
        int index =0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray[i]; j++) {
                arr[index++] = i;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序思想
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先减，再交换
        int two = len;
        int i = 0;
        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};

    }
}
