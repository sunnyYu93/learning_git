package com.example.tanyu.leetcode.字符串;

import java.util.Scanner;

public class 回文串 {
    public static int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > 1) {
                        ++res;
                    }

                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
//        System.out.println(countSubstrings("aabaac"));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > 1) {
                        ++res;
                    }

                }
            }
        }

        System.out.println(res);
    }
}
