package com.example.tanyu.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/28 20:31
 */
public class 高度检查器 {

    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heights[i];
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            if (arr[i] != heights[i]) {
                sum++;
            }
        }

        return sum;
    }
}
