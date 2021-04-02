package com.example.tanyu.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, res);
        return res;
    }


    public static void dfs(int[] candidates, int start, int num, List<Integer> path, List<List<Integer>> res) {
        if (num == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        System.out.println("结果集：" + path.toString());
        for (int i = start; i < candidates.length; i++) {
            System.out.println("num: "+ num);
            if (num - candidates[i] < 0) {
                System.out.println("i"+i);
                break;
            }
            path.add(candidates[i]);
            System.out.println("中间集：" + path.toString());
            dfs(candidates, i, num - candidates[i], path, res);
            path.remove(path.size() - 1);
            System.out.println("回溯后的结果集：" + path.toString());
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2, 3, 6, 7};
        System.out.println(combinationSum(arr, 5));

    }
}
