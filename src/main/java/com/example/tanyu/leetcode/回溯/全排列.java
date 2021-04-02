package com.example.tanyu.leetcode.回溯;

import java.util.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/2 10:25
 *
 * 不含重复字符
 */
public class 全排列 {
    /**
     * 辅助函数
     *
     * @param nums   数组转换后的列表
     * @param start  开始下标
     * @param result 返回结果集
     */
    void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); ++i) {
                // 将子数组的不同位置元素与start位置交换，相当于将不同元素放置在start位置上
                Collections.swap(nums, i, start);
                // 递归求从start + 1开始的子数组的全排列
                permuteRec(nums, start + 1, result);
                // 反过来交换一下，达到撤销的目的。
                // 撤销刚刚做的交换
                Collections.swap(nums, i, start);
            }
        }


    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        // 将数组转换为列表，便于操作
        for (int num : nums) {
            list.add(num);
        }
        // 从索引0处开始遍历
        permuteRec(list, 0, result);
        return result;
    }
}

/**
 * 第二种解法实例，思想都是用回溯，实现代码不同而已
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现

    /**
     * @param nums  选择列表：nums 中不存在于 track 的那些元素
     *              结束条件：nums 中的元素全都在 track 中出现
     * @param track 路径：记录在 track 中
     */
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

}

/**
 * 作者 ：liweiwei1419
 *
 * 此解法是利用boolean数组来达到回溯的目的
 */
 class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                //表示i位置处的字符已经选择
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                // 达到回溯的目的
                used[i] = false;
                // 撤销刚刚做的选择
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}

class Solution3 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>(factorial(len));
        if (len == 0) {
            return res;
        }

        // 使用哈希表检测一个数字是否使用过
        Set<Integer> used = new HashSet<>(len);
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, Set<Integer> used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used.contains(i)) {
                used.add(i);
                path.addLast(nums[i]);

                dfs(nums, len, depth + 1, path, used, res);

                path.removeLast();
                used.remove(i);
            }
        }
    }
}


