package com.example.tanyu.leetcode.array.easy;

import java.util.HashMap;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/14 20:57
 */
public class 数组中数字出现的次数II {
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        System.out.println(hashMap);

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 3, 3};
        System.out.println(singleNumber(arr));
    }
}
