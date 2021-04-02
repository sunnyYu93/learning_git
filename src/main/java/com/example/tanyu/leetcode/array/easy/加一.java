package com.example.tanyu.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/16 20:51
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;

    }
}
