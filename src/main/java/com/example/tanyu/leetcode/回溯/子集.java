package com.example.tanyu.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res;
    }

    public void dfs(int[] nums, int start, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for(int i = start; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
