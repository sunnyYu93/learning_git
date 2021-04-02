package com.example.tanyu.algorithm.easy;

import java.util.LinkedList;

public class BinaryTree {

    /**
     * 构建二叉树
     */
    private Node createBinaryTree(LinkedList<Integer> linkedList) {
        Node node = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }

        Integer data = linkedList.removeFirst();
        if (data != null) {
            node = new Node(data);
            node.leftChild = createBinaryTree(linkedList);
            node.rightChild = createBinaryTree(linkedList);
        }

        return node;
    }


    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 二叉树的前序遍历
     */
    private void front(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        front(node.leftChild);
        front(node.rightChild);
    }

    /**
     * 二叉树的中序遍历
     */
    private void medium(Node node) {
        if (node == null) {
            return;
        }
        medium(node.leftChild);
        System.out.println(node.data);
        medium(node.rightChild);
    }

    /**
     * 二叉树的后序遍历
     */
    private void last(Node node) {
        if (node == null) {
            return;
        }
        medium(node.leftChild);
        medium(node.rightChild);
        System.out.println(node.data);

    }

    public static void main(String[] args) {
        String s = "abcdef";
        int n = 2;
        String re = s.substring(n) + s.substring(0, n);

        System.out.println(re);
    }


}
