package com.example.tanyu.leetcode.array;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/13 23:42
 */
public class 青蛙跳台阶问题 {
    public int numWays(int n) {
//        int[] dp = new int[n + 2];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i < n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];

        if(n < 2) {
            return 1;
        }

        int[] dp = new int[n+2];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= n+1; i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
        }
        return dp[n];

    }
}
