package com.example.tanyu.algorithm;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/21 15:40
 */
public class ThreeNum {
    public static int test(int[] nums, int target) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i==j) {
                    continue;
                }
                for (int k = 0; k < nums.length; k++) {
                    if (j==k) {
                        continue;
                    }
                    arr[i] = nums[i] + nums[j] + nums[k] - target;
                }
            }
        }

        Arrays.sort(arr);
        return arr[0];
    }
}
