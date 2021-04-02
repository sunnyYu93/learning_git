package com.example.tanyu.leetcode.array.easy;

import java.util.ArrayList;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 20:07
 */
public class 按既定顺序创建目标数组 {
    public int[] createTargetArray(int[] nums, int[] index) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            integers.add(index[i], nums[i]);
//        }
//
//        int[] arr = new int[integers.size()];
//        for (int i = 0; i < integers.size(); i++) {
//            arr[i] = integers.get(i);
//        }
//        return arr;

        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (index[j] >= index[i]) index[j]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            target[index[i]] = nums[i];
        }
        return target;
    }
}
