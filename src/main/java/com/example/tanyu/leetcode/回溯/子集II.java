package com.example.tanyu.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<>();
        //排序是剪枝的前提！！！！！！
        Arrays.sort(nums);
        dfs(nums, 0, path);
        return res;
    }

    public void dfs(int[] nums, int start, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            dfs(nums, i+1, path);
            path.remove(path.size() - 1);
        }
    }
}
