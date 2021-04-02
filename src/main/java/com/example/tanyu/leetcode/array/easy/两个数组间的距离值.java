package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/28 20:53
 */
public class 两个数组间的距离值 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) >= d) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum++;
            }
        }
        return sum;

    }
}

