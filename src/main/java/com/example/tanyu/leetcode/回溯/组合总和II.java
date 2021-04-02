package com.example.tanyu.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates, target, 0, path,used);
        return res;
    }

    public void dfs(int[] candidates, int num, int start, List<Integer> path, boolean[] used) {
        if(num==0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            // 差值小于0，避免接下来无意义的循环，降低代码量
            if(num -candidates[i]<0) {
                break;
            }
            // 剪掉同层级相同的元素
            //i>start:目的在于保留第一个出现的元素，剔除后面出现相同的元素
            if(i>start && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, num-candidates[i], i+1, path, used);
            path.remove(path.size()-1);
        }

    }
}
