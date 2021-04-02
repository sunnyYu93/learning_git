package com.example.tanyu.leetcode.动态规划;

import java.util.List;

/**
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 */

public class 三角形最小路径和 {

    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        //方法一：递归
        //弊端：会有大量的重复计算
        //优化点：利用记忆搜索
//        return dfsTopToDown(triangle, 0, 0);


        //方法三：动态规划
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];

    }

    /**
     * 递归，自顶向下。符合人类思维
     * 弊端：单纯的递归会有大量的重复计算
     * @param triangle
     * @param i
     * @param j
     */
    public int dfsTopToDown(List<List<Integer>> triangle, int i, int j) {
        //i == triangle.size()说明遍历到三角形金字塔的最底部
        if (i == triangle.size()) {
            return 0;
        }

        return Math.min(dfsTopToDown(triangle, i + 1, j), dfsTopToDown(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 递归 + 记忆化
     * 自顶向下的递归
     * @param triangle
     * @return
     */
    public int dfsByMemory(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        return memo[i][j] = Math.min(dfsTopToDown(triangle, i + 1, j), dfsTopToDown(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }





}
