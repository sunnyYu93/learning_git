package com.example.tanyu.笔试题.华为;

/**
 * [2,3,1,1,4]
 */

public class NumberOne {
    public int jump(int[] nums) {
        int n = nums.length;
        int border = 0;
        int rightBide = 0;
        int step = 0;

        for (int i = 0; i < n - 1; i++) {
            rightBide = Math.max(rightBide, i + nums[i]);
            if (i == border) {
                border = rightBide;
                step++;
            }
        }

        return step;
    }

}
