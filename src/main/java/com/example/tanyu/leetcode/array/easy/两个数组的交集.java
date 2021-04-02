package com.example.tanyu.leetcode.array.easy;

import java.util.HashSet;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/1 19:50
 */
public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] arr = new int[set2.size()];
        int index=0;
        for (int a : set2) {
            arr[index++] = a;
        }

        return arr;

    }
}
