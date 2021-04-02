package com.example.tanyu.leetcode.array.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/16 19:42
 */
public class 旋转数组 {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums,0,arr,0,nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            nums[index] = arr[i];
        }

    }
}
