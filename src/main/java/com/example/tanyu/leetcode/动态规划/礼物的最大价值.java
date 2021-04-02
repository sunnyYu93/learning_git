package com.example.tanyu.leetcode.动态规划;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/14 20:07
 */
public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i==0) {
                    grid[i][j] += grid[i][j-1];
                } else if (j==0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];

    }

    /**
     * 优化第一行与第一列
     * @param grid
     * @return
     */
    public int maxValueUpdate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 0; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j]+=Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];

    }
}
