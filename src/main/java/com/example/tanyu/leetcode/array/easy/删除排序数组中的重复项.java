package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/16 19:17
 */
public class 删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j-1]) {
                nums[i] = nums[j];
                i++;

            }
        }

        return i;
    }
}
