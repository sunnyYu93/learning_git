package com.example.tanyu.leetcode.array.easy;

/**
 * 对于排序数组，首先想到的应该是二分查找
 *
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 20:35
 */


public class 统计有序矩阵中的负数 {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            int[] arr = grid[i];
            int l = 0;
            int r = arr.length - 1;
            int m =0;
            //为什么是“<=”,而不是“<”.这是因为l、r取得是[0,arr.length - 1]前闭后闭区间。
            while (l <= r) {
                m = l + (r - l) / 2;
                if (arr[m] >= 0) {
                    l = m + 1;
                } else {
                    r = m-1;
                }
            }
            count = count + arr.length - l;

        }

        return count;
    }
}
