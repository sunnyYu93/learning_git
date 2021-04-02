package com.example.tanyu.leetcode.middle;

import java.util.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/10 20:39
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // j = i + 1为了跳过重复索引处
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> asList = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (set.contains(asList)) {
                            continue;
                        }
                        list.add(asList);
                        set.add(asList);
                    }
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSumSecond(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            int L = i + 1;
//            int R = nums.length - 1;
//            while (L < R) {
//                int sum = nums[i] + nums[L] + nums[R];
//                if (sum == 0) {
//                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
//                    //跳过相等的数
//                    while (L < R && nums[L] == nums[L + 1]) {
//                        L++;
//                    }
//
//                    //跳过相等的数
//                    while (L < R && nums[R] == nums[R - 1]) {
//                        R--;
//                    }
//
//                } else if (sum < 0) {
//                    L++;
//                } else if (sum > 0) {
//                    R--;
//                }
//            }
//        }
//        return list;


        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return list;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSumSecond(arr);
        System.out.println(list.toString());
    }
}
