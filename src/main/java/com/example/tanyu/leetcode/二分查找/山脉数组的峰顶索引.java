package com.example.tanyu.leetcode.二分查找;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/1 19:37
 */
public class 山脉数组的峰顶索引 {
    public int peakIndexInMountainArray(int[] A) {

        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > A[mid+1] && A[mid] > A[mid-1]) {
                return mid;
            } else if(A[mid] > A[mid+1] && A[mid] < A[mid-1]) {
                right=mid-1;
            } else if (A[mid] < A[mid+1] && A[mid] >A[mid-1]) {
                left = mid+1;
            }
        }

        return 0;
    }
}
