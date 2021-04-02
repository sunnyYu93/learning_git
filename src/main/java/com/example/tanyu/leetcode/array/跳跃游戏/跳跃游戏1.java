package com.example.tanyu.leetcode.array.跳跃游戏;

public class 跳跃游戏1 {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightBide = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightBide) {
                rightBide = Math.max(rightBide, i + nums[i]);
                if (rightBide >= n-1) {
                    return true;
                }
            }
        }

        return false;
    }
}
