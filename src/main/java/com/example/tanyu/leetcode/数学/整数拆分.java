package com.example.tanyu.leetcode.数学;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/24 19:20
 */
public class 整数拆分 {
    public int integerBreak(int n) {

        if (n <= 3) {
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }

        return (int) Math.pow(3, a) * 2;
    }
}
