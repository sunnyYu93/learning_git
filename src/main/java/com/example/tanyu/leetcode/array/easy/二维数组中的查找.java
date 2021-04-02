package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/14 20:31
 *
 * 左下角标志数法
 * 算法流程： 根据以上性质，设计算法在每轮对比时消去一行（列）元素，以降低时间复杂度。
 *
 * 从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
 * 当 matrix[i][j] > target 时： 行索引向上移动一格（即 i--），即消去矩阵第 i 行元素；
 * 当 matrix[i][j] < target 时： 列索引向右移动一格（即 j++），即消去矩阵第 j 列元素；
 * 当 matrix[i][j] == target 时： 返回 truetrue 。
 * 若行索引或列索引越界，则代表矩阵中无目标值，返回 falsefalse 。
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int i = matrix.length-1;
        int j = 0;
        while (i>=0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
