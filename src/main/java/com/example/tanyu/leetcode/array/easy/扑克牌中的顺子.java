package com.example.tanyu.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/14 20:46
 */
public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        int jocker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                jocker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[jocker] < 5;
    }

    public boolean isStraightSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                continue;
            }

            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            if (hashSet.contains(nums[i])) {
                return false;
            } else {
                hashSet.add(nums[i]);
            }
        }

        return max - min < 5;
    }
}
