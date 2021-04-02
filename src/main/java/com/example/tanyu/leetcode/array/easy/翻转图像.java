package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/28 20:02
 */
public class 翻转图像 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] arr = A[i];
            int l = 0;
            int r = arr.length - 1;
            while (l <= r) {
                int temp = 0;
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        for (int j = 0; j < A.length; j++) {
            int[] arr = A[j];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }

        }

        return A;

    }
}
