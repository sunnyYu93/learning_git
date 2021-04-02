package com.example.tanyu.huawei.hal;

import java.util.ArrayList;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/27 22:02
 */
public class Test {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }

    public static void main(String[] args) {
        Object obj = new Object();
        ArrayList list0 = new ArrayList();
        long startTime0 = System.currentTimeMillis();
        int N=99999;
        for (int i = 0; i <= N; i++) {

            list0.add(obj);
        }
        long endTime0 = System.currentTimeMillis();
        System.out.println("111没有调用ensureCapacity()方法所用时间：" + (endTime0 - startTime0) + "ms");

        ArrayList list1 = new ArrayList();
        long startTime1 = System.currentTimeMillis();

        list1.ensureCapacity(N);//预先设置list的大小
        for (int i = 0; i <= N; i++) {
            list1.add(obj);
        }
        long endTime1 = System.currentTimeMillis();

        System.out.println("222调用ensureCapacity()方法所用时间：" + (endTime1 - startTime1) + "ms");


    }
}
