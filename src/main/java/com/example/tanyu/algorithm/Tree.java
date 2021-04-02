package com.example.tanyu.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    /**
     * 构建二叉树
     *
     * @param inputList
     */
    public static Node createBinaryTree(LinkedList<Integer> inputList) {
        Node node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new Node(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树节点
     */
    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 前序遍历
     */
    public static void preOrderTraveral(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     */
    private static void inOrderTraveral(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     */
    private static void postOrderTraveral(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     */
    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }

            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }

        }
    }

    /**
     * 栈方式的前序遍历
     *
     * @param root 根节点
     */
    private static void preOrderTraveralWithStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.leftChild;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }

    /**
     * 栈方式的中序遍历
     *
     * @param root 根节点
     */
    private static void inOrderTraveralWithStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.leftChild;

            }

            node = stack.pop();
            System.out.println(node.data);
            node = node.rightChild;
        }
    }

    /**
     * 栈方式的后序遍历,还不会啊
     *
     * @param root 根节点
     */
    private static void postOrderTraveralWithStack(Node root) {

    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.leftChild);
        int right = maxDepth(root.rightChild);
        return Math.max(left, right) + 1;

    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3,9,20,null,null,15,7));
        Node binaryTree = createBinaryTree(inputList);

        int i = maxDepth(binaryTree);
        System.out.println(i);

    }

}
