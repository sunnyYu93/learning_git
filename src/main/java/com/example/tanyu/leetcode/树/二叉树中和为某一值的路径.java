package com.example.tanyu.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, sum, path);
        return res;
    }

    public void dfs(TreeNode root, int count, LinkedList<Integer> path) {
        if(root==null) {
            return;
        }
        path.add(root.val);
        count -= root.val;
        if (count == 0 && root.left == null && root.right ==null) {

            res.add(new LinkedList<>(path));
            // 如果在这里return的话会导致后面的remove没有执行，
            // 所以在此处要单独进行remove回溯.
            // 刚开始我就犯了这个错误，然后看了leetcode其他人写的回复发现了这个问题出自哪里了
            path.removeLast();
            return;
        }
        dfs(root.left, count, path);
        dfs(root.right, count, path);
        path.removeLast();
    }
}

class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
