package com.example.tanyu.leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String curStr, int left, int right, List<String> res) {
        // 每一次使用新的字符串，所以不需要回溯
        // 达到递归终止条件的时候，直接把他添加到结果集即可。
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝
        // 左括号数量大于右括号时，没有对应的右括号匹配，这种情况需要剪枝
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
