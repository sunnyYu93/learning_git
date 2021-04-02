package com.example.tanyu.leetcode.树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/22 20:23
 */
public class N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                if (item !=null) {
                    stack.add(item);
                }
            }
        }

        return output;

    }

}
