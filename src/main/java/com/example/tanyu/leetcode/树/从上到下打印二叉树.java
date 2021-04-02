package com.example.tanyu.leetcode.树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/14 21:17
 */
public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root==null) {
            return new int[]{};
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            list.add(node.val);
            if (node.left!=null) {
                stack.offer(node.left);
            }
            if (node.right!=null) {
                stack.offer(node.right);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
