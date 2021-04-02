package com.example.tanyu.leetcode.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/21 21:23
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;

    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);

    }


}
