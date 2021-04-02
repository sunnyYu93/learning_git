package com.example.tanyu.leetcode.array.easy;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 20:16
 * 切比雪夫问题
 */
public class 访问所有点的最小时间 {
    public int minTimeToVisitAllPoints(int[][] points) {

        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - points[i-1][0]);
            int y = Math.abs(points[i][1] - points[i-1][1]);
            sum = sum + Math.max(x,y);
        }
        return sum;


    }
}
