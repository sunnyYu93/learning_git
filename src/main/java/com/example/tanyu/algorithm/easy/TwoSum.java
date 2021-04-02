package com.example.tanyu.algorithm.easy;


import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

public class TwoSum {

    int[] nums = new int[]{2, 3, 5, 7};
    int target = 9;

    /**
     * 暴力法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {


        int[] result = new int[]{};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[]{0};
    }

    /**
     * 两遍哈希表
     * 第一遍循环已经构成完整K-V，第二遍循环的时候当containsKey()为true的时候，result[0]为当前循环的位置。
     * 此处与一遍哈希表的解法存在不同。因为一遍哈希表只有在找到第二个满足条件的元素的时候再去找到第一个满足条件的元素。
     */
    public static int[] twoSumHash(int[] nums, int target) {
        System.out.println("测试");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];
            if (map.containsKey(ele)) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = map.get(ele);
                System.out.println(Arrays.toString(result));
                return new int[]{i, map.get(ele)};
            }
        }

        return new int[]{0};

    }

    /**
     * 一遍哈希表
     *
     */
    public static int[] oneSumHash(int[] nums, int target) {
        System.out.println("测试");
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];
            if (map.containsKey(ele)) {
                res[0] = map.get(ele);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println("测试");
        int[] nums = new int[]{2, 3, 5, 7};
        int target = 9;
        System.out.println(Arrays.toString(twoSumHash(nums, target)));

    }


}
