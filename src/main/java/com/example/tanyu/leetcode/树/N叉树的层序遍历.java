package com.example.tanyu.leetcode.树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/24 21:38
 */
public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            res.add(list);
        }

        return res;

    }
}
