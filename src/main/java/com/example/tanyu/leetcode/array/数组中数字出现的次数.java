package com.example.tanyu.leetcode.array;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/20 19:33
 */
public class 数组中数字出现的次数 {
    public static int[] singleNumbers(int[] nums) {
        int sum = 0;
        //得到异或结果，即为不相同两个数的异或结果sum
        for (int num : nums) {
            sum ^= num;
        }
        //得到sum的二进制的1的最低位，等于1的那个位置就是两个数二进制不等的地方，
        // 可以以此处将数组中的数分组
        int flag = (-sum) & sum;
        System.out.println(flag);
        int[] result = new int[2];
        //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for (int num : nums) {
            if ((flag & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(-8 & 8);
        int[] arr = new int[]{4,15,4,9};
        System.out.println(Arrays.toString(singleNumbers(arr)));
    }
}
