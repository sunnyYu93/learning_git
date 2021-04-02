package com.example.tanyu.leetcode.array;

import java.util.Arrays;

public class 最接近的三数之和 {

    /**
     * 暴力解法
     * 时间复杂度O(n^3)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosestByViolence(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int abs = Math.abs(sum - target);
                    if (abs < min) {
                        result = sum;
                        min = abs;
                    }

                }
            }
        }

        return result;
    }

    /**
     * 三指针法
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosestByThreePoints(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                //缩小范围
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;

                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosestByThreePoints(nums,1));
    }


}


