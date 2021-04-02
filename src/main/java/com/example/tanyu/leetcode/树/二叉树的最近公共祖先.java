package com.example.tanyu.leetcode.树;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/27 19:24
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null) {
            return root;
        } else if (left!=null) {
            return left;
        } else {
            return right;
        }
    }
}
