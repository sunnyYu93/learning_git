package com.example.tanyu.leetcode.树;

import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/27 20:32
 */
public class 从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inPos.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inPos);
    }

    /**
     *
     * @param pre 前序遍历数组
     * @param preStart 前序遍历开始下标
     * @param preEnd 前序遍历结束下标
     * @param inStart 中序遍历开始下标
     * @param inPos
     * @return
     */
    private TreeNode buildTree(int[] pre, int preStart, int preEnd,
                               int inStart, Map<Integer, Integer> inPos) {
        // 说明本次构建的二叉树中没有节点
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的第一个节点为根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 当前节点在中序遍历中的下标，用于计算左子树节点个数
        int rootIdx = inPos.get(pre[preStart]);
        // 左子树节点个数
        int leftLen = rootIdx - inStart;
        root.left = buildTree(pre, preStart + 1, preStart + leftLen, inStart, inPos);
        root.right = buildTree(pre, preStart + leftLen + 1, preEnd, rootIdx + 1, inPos);
        return root;
    }


}
