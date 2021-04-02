package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/28 19:47
 */
public class 奇数值单元格的数目 {
    public int oddCells(int n, int m, int[][] indices) {
        //初始化矩阵
        int[][] mat = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int[] in = indices[i];
            //指定行单元格数目加1
            for (int k = 0; k < m; k++) {
                mat[in[0]][k] += 1;
            }
            //指定列单元格数目加1
            for (int j = 0; j < n; j++) {
                mat[j][in[1]] += 1;
            }
        }
        int num = 0;
        //遍历结果矩阵找到奇数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //注意这里和mat[i][j] % 2 != 0并不等价哦
                if (mat[i][j] % 2 == 1) {
                    num++;
                }
            }
        }
        return num;
    }
}
