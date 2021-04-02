package com.example.tanyu.leetcode.数学;

import java.util.ArrayList;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/20 20:52
 */
public class 丑数 {
    public static int nthUglyNumber(int n) {
        int a = 0;
        int b = 0;
        int c = 0;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;

            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }

        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        nthUglyNumber(12);
    }
}
