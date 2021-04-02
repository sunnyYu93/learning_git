package com.example.tanyu.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/22 19:31
 */


public class N叉树的后序遍历 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        int len = root.children.size();
        for (int i = 0; i < len; i++) {
            helper(root.children.get(i),res);
        }

        res.add(root.val);

    }


    public List<Integer> postorderIteration(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }

}
