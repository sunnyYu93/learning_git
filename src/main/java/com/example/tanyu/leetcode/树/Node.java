package com.example.tanyu.leetcode.树;

import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/22 19:32
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
