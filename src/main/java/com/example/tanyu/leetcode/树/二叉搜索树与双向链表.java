package com.example.tanyu.leetcode.树;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/24 19:49
 */


public class 二叉搜索树与双向链表 {
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
