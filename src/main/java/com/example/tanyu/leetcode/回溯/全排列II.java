package com.example.tanyu.leetcode.回溯;

import java.util.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/2 11:05
 *
 * 包含重复元素的全排列
 */
public class 全排列II {

    private void permuteRec(List<Integer> nums, int start, Set<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); ++i) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }

    /**
     * 利用 HashSet去重
     *
     * @param nums 数组
     * @return Time: O(n*n!), Space: O(n)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        permuteRec(list, 0, result);
        return new ArrayList<>(result);
    }
}

class SolutionTwo {

    /**
     * 利用剪枝 + 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    /**
     *
     * @param nums 数组
     * @param len 数组长度
     * @param depth 从0处开始遍历
     * @param used 记录数组对应位置元素是否已使用
     * @param path 存放已经遍历过的数
     * @param res 最后结果
     */
    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }
}
