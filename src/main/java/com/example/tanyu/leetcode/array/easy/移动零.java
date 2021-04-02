package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/5 21:10
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        // 耗时102ms，太大了
        // 类似冒泡排序
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                int temp = 0;
                if (nums[j] == 0) {
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        int fast=0;
        int slow=0;
        //双指针一:赋值版本
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;

        }

        //双指针二：交换数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
