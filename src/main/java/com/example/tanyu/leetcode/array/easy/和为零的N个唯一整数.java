package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/28 19:55
 */
public class 和为零的N个唯一整数 {
    public int[] sumZero(int n) {
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            sum += i;
            arr[i-1] = i;
        }
        arr[n-1] = -sum;

        return arr;
    }
}
