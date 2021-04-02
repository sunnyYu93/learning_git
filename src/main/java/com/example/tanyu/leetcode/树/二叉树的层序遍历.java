package com.example.tanyu.leetcode.树;

import java.util.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/22 20:53
 */
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();

            List<Integer> storeList = new ArrayList<>();
            // 每一个节点出队的时候会将子节点加入队列中。
            // 队列的size为每层节点数
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                storeList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(storeList);

        }
        return res;
    }
}
