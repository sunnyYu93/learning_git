package com.example.tanyu.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/4 20:52
 */
public class 两数之和 {
    /**
     * 暴力法与一遍哈希表、两遍哈希表
     * [3,2,4]
     * 6
     * 对于这个示例，3自身相加两次也可以得到6的结果，要排除这种情况
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (hashMap.containsKey(res)) {
                return new int[]{i, hashMap.get(res)};
            }
            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    /**
     * 两遍哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHashTwo(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            //hashMap.get(res) != i 是为了排除自身相加两次的情况
            if (hashMap.containsKey(res) && hashMap.get(res) != i) {
                return new int[]{i, hashMap.get(res)};
            }
            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public int[] twoSumByPointer(int[] nums, int target) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (copy[left] + copy[right] == target) {
                break;
            } else if (copy[left] + copy[right] > target) {
                right--;
            } else if (copy[left] + copy[right] < target) {
                left++;
            }
        }

        int first = 0;
        int second = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[left] == nums[i]) {
                first = i;
                break;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (copy[right] == nums[i] && i != first) {
                second = i;
            }
        }


        return new int[]{first, second};
    }
}
