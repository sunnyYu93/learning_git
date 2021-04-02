package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/4 21:47
 */
public class 顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int x = 0;

        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                // left to right.
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                // top to bottom.
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                // right to left.
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                // bottom to top.
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

}
