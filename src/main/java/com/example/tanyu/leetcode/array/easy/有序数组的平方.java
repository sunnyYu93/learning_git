package com.example.tanyu.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/28 20:44
 */
public class 有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);
        return A;
    }
}
